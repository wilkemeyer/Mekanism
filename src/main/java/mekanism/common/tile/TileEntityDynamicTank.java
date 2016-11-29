package mekanism.common.tile;

import io.netty.buffer.ByteBuf;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import mekanism.api.Coord4D;
import mekanism.api.Range4D;
import mekanism.common.Mekanism;
import mekanism.common.base.IFluidContainerManager;
import mekanism.common.block.BlockBasic;
import mekanism.common.content.tank.SynchronizedTankData;
import mekanism.common.content.tank.SynchronizedTankData.ValveData;
import mekanism.common.content.tank.TankCache;
import mekanism.common.content.tank.TankUpdateProtocol;
import mekanism.common.multiblock.MultiblockManager;
import mekanism.common.network.PacketTileEntity.TileEntityMessage;
import mekanism.common.util.FluidContainerUtils;
import mekanism.common.util.FluidContainerUtils.ContainerEditMode;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.util.ForgeDirection;
import net.minecraftforge.fluids.FluidContainerRegistry;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.IFluidContainerItem;

public class TileEntityDynamicTank extends TileEntityMultiblock<SynchronizedTankData> implements IFluidContainerManager
{
	/** A client-sided set of valves on this tank's structure that are currently active, used on the client for rendering fluids. */
	public Set<ValveData> valveViewing = new HashSet<ValveData>();

	/** The capacity this tank has on the client-side. */
	public int clientCapacity;

	public float prevScale;

	public TileEntityDynamicTank()
	{
		super("DynamicTank");
	}

	public TileEntityDynamicTank(String name)
	{
		super(name);
		inventory = new ItemStack[2];
	}

	@Override
	public void onUpdate()
	{
		super.onUpdate();
		
		if(worldObj.isRemote)
		{
			if(structure != null && clientHasStructure && isRendering)
			{
				float targetScale = (float)(structure.fluidStored != null ? structure.fluidStored.amount : 0)/clientCapacity;
				
				if(Math.abs(prevScale - targetScale) > 0.01)
				{
					prevScale = (9*prevScale + targetScale)/10;
				}
			}

			if(!clientHasStructure || !isRendering)
			{
				for(ValveData data : valveViewing)
				{
					TileEntityDynamicTank tileEntity = (TileEntityDynamicTank)data.location.getTileEntity(worldObj);

					if(tileEntity != null)
					{
						tileEntity.clientHasStructure = false;
					}
				}

				valveViewing.clear();
			}
		}

		if(!worldObj.isRemote)
		{
			if(structure != null)
			{
				if(structure.fluidStored != null && structure.fluidStored.amount <= 0)
				{
					structure.fluidStored = null;
					markDirty();
				}
				
				if(isRendering)
				{
					boolean needsValveUpdate = false;
					
					for(ValveData data : structure.valves)
					{
						if(data.activeTicks > 0)
						{
							data.activeTicks--;
						}
						
						if(data.activeTicks > 0 != data.prevActive)
						{
							needsValveUpdate = true;
						}
						
						data.prevActive = data.activeTicks > 0;
					}
					
					if(needsValveUpdate || structure.needsRenderUpdate())
					{
						sendPacketToRenderer();
					}
					
					if( structure.prevFluid == null && structure.fluidStored != null )
					{
						structure.prevFluid = structure.fluidStored.copy();
					}
					else if( structure.prevFluid != null && structure.fluidStored == null )
					{
						structure.prevFluid = null;
					}
 
					manageInventory();
				}
			}
		}
	}

	public void manageInventory()
	{
		int needed = (structure.volume*TankUpdateProtocol.FLUID_PER_TANK)-(structure.fluidStored != null ? structure.fluidStored.amount : 0);

		if(structure.inventory[0] != null)
		{
			if(structure.inventory[0].getItem() instanceof IFluidContainerItem)
			{
				if(structure.editMode == ContainerEditMode.FILL && structure.fluidStored != null)
				{
					structure.fluidStored = FluidContainerUtils.handleContainerItemFill(this, structure.inventory, structure.fluidStored, 0, 1);
				}
				else if(structure.editMode == ContainerEditMode.EMPTY)
				{
					structure.fluidStored = FluidContainerUtils.handleContainerItemEmpty(this, structure.inventory, structure.fluidStored, needed, 0, 1, null);
				}
			}
			else if(FluidContainerRegistry.isEmptyContainer(structure.inventory[0]) && (structure.editMode == ContainerEditMode.BOTH || structure.editMode == ContainerEditMode.FILL))
			{
				structure.fluidStored = FluidContainerUtils.handleRegistryItemFill(this, structure.inventory, structure.fluidStored, 0, 1);
				
				Mekanism.packetHandler.sendToReceivers(new TileEntityMessage(Coord4D.get(this), getNetworkedData(new ArrayList())), new Range4D(Coord4D.get(this)));
			}
			else if(FluidContainerRegistry.isFilledContainer(structure.inventory[0]) && (structure.editMode == ContainerEditMode.BOTH || structure.editMode == ContainerEditMode.EMPTY))
			{
				structure.fluidStored = FluidContainerUtils.handleRegistryItemEmpty(this, structure.inventory, structure.fluidStored, needed, 0, 1, null);
				
				Mekanism.packetHandler.sendToReceivers(new TileEntityMessage(Coord4D.get(this), getNetworkedData(new ArrayList())), new Range4D(Coord4D.get(this)));
			}
		}
	}
	
	@Override
	public boolean onActivate(EntityPlayer player)
	{
		if(!player.isSneaking() && structure != null)
		{
			if(!BlockBasic.manageInventory(player, this))
			{
				Mekanism.packetHandler.sendToReceivers(new TileEntityMessage(Coord4D.get(this), getNetworkedData(new ArrayList())), new Range4D(Coord4D.get(this)));
				player.openGui(Mekanism.instance, 18, worldObj, xCoord, yCoord, zCoord);
			}
			else {
				player.inventory.markDirty();
				sendPacketToRenderer();
			}

			return true;
		}
		
		return false;
	}
	
	@Override
	protected SynchronizedTankData getNewStructure()
	{
		return new SynchronizedTankData();
	}
	
	@Override
	public TankCache getNewCache()
	{
		return new TankCache();
	}
	
	@Override
	protected TankUpdateProtocol getProtocol()
	{
		return new TankUpdateProtocol(this);
	}
	
	@Override
	public MultiblockManager<SynchronizedTankData> getManager()
	{
		return Mekanism.tankManager;
	}

	@Override
	public ArrayList getNetworkedData(ArrayList data)
	{
		super.getNetworkedData(data);
		
		if(structure != null)
		{
			data.add(structure.volume*TankUpdateProtocol.FLUID_PER_TANK);
			data.add(structure.editMode.ordinal());
			
			if(structure.fluidStored != null)
			{
				data.add(1);
				data.add(structure.fluidStored.getFluidID());
				data.add(structure.fluidStored.amount);
			}
			else {
				data.add(0);
			}
			
			if(isRendering)
			{
				Set<ValveData> toSend = new HashSet<ValveData>();

				for(ValveData valveData : structure.valves)
				{
					if(valveData.activeTicks > 0)
					{
						toSend.add(valveData);
					}
				}
				
				data.add(toSend.size());
				
				for(ValveData valveData : toSend)
				{
					valveData.location.write(data);
					data.add(valveData.side.ordinal());
				}
			}
		}

		return data;
	}

	@Override
	public void handlePacketData(ByteBuf dataStream)
	{
		super.handlePacketData(dataStream);
		
		if(worldObj.isRemote)
		{
			if(clientHasStructure)
			{
				clientCapacity = dataStream.readInt();
				structure.editMode = ContainerEditMode.values()[dataStream.readInt()];
				
				if(dataStream.readInt() == 1)
				{
					structure.fluidStored = new FluidStack(FluidRegistry.getFluid(dataStream.readInt()), dataStream.readInt());
				}
				else {
					structure.fluidStored = null;
				}
	
				if(isRendering)
				{
					int size = dataStream.readInt();
					
					valveViewing.clear();
	
					for(int i = 0; i < size; i++)
					{
						ValveData data = new ValveData();
						data.location = Coord4D.read(dataStream);
						data.side = ForgeDirection.getOrientation(dataStream.readInt());
						
						valveViewing.add(data);
	
						TileEntityDynamicTank tileEntity = (TileEntityDynamicTank)data.location.getTileEntity(worldObj);
	
						if(tileEntity != null)
						{
							tileEntity.clientHasStructure = true;
						}
					}
				}
			}
		}
	}

	public int getScaledFluidLevel(long i)
	{
		if(clientCapacity == 0 || structure.fluidStored == null)
		{
			return 0;
		}

		return (int)(structure.fluidStored.amount*i / clientCapacity);
	}

	@Override
	public ContainerEditMode getContainerEditMode() 
	{
		if(structure != null)
		{
			return structure.editMode;
		}
		
		return ContainerEditMode.BOTH;
	}

	@Override
	public void setContainerEditMode(ContainerEditMode mode) 
	{
		if(structure == null)
		{
			return;
		}
		
		structure.editMode = mode;
	}
}
