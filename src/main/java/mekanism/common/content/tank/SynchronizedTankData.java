package mekanism.common.content.tank;

import java.util.HashSet;
import java.util.Set;

import mekanism.api.Coord4D;
import mekanism.common.multiblock.SynchronizedData;
import mekanism.common.util.FluidContainerUtils.ContainerEditMode;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.util.ForgeDirection;
import net.minecraftforge.fluids.FluidStack;

public class SynchronizedTankData extends SynchronizedData<SynchronizedTankData>
{
	public FluidStack fluidStored;
	
	/** For use by rendering segment */
	public FluidStack prevFluid;
	public int prevFluidStage = 0;
	
	public ContainerEditMode editMode = ContainerEditMode.BOTH;

	public ItemStack[] inventory = new ItemStack[2];

	public Set<ValveData> valves = new HashSet<ValveData>();
	
	public boolean needsRenderUpdate()
	{
		if((fluidStored == null && prevFluid != null) || (fluidStored != null && prevFluid == null))
		{
			return true;
		}
		
		if(fluidStored != null && prevFluid != null)
		{
			int totalStage 		= (volHeight - 2) * (TankUpdateProtocol.FLUID_PER_TANK / 100);
			int currentStage 	= (int)((fluidStored.amount / (float)(volume*TankUpdateProtocol.FLUID_PER_TANK)) * totalStage);
			boolean stageChanged 	= currentStage != prevFluidStage;
			prevFluidStage 		= currentStage;
			if((fluidStored.getFluid() != prevFluid.getFluid()) || stageChanged)
			{
				return true;
			}
		}
		
		return false;
	}
	
	@Override
	public ItemStack[] getInventory()
	{
		return inventory;
	}

	public static class ValveData
	{
		public ForgeDirection side;
		public Coord4D location;
		
		public boolean prevActive;
		public int activeTicks;
		
		public void onTransfer()
		{
			activeTicks = 30;
		}

		@Override
		public int hashCode()
		{
			int code = 1;
			code = 31 * code + side.ordinal();
			code = 31 * code + location.hashCode();
			return code;
		}

		@Override
		public boolean equals(Object obj)
		{
			return obj instanceof ValveData && ((ValveData)obj).side == side && ((ValveData)obj).location.equals(location);
		}
	}
}
