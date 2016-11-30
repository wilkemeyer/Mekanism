package mekanism.generators.client.model;

import mekanism.client.model.FastModelBase;
import mekanism.client.model.FastModelRenderer;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ModelSolarGenerator extends FastModelBase 
{
	FastModelRenderer solarPanel;
	FastModelRenderer solarPanelBottom;
	FastModelRenderer solarPanelConnector;
	FastModelRenderer solarPanelRod2;
	FastModelRenderer solarPanelPipeConnector;
	FastModelRenderer solarPanelPort;
	FastModelRenderer solarPanelRod1;
	FastModelRenderer solarPanelPipeBase;

	public ModelSolarGenerator() 
	{
		textureWidth = 64;
		textureHeight = 64;

		solarPanel = new FastModelRenderer(this, 0, 0);
		solarPanel.addBox(0F, 0F, 0F, 16, 2, 16);
		solarPanel.setRotationPoint(-8F, 13F, -8F);
		solarPanel.setTextureSize(64, 64);
		solarPanel.mirror = true;
		setRotation(solarPanel, 0F, 0F, 0F);
		solarPanelBottom = new FastModelRenderer(this, 0, 18);
		solarPanelBottom.addBox(0F, 0F, 0F, 14, 1, 14);
		solarPanelBottom.setRotationPoint(-7F, 15F, -7F);
		solarPanelBottom.setTextureSize(64, 64);
		solarPanelBottom.mirror = true;
		setRotation(solarPanelBottom, 0F, 0F, 0F);
		solarPanelConnector = new FastModelRenderer(this, 0, 33);
		solarPanelConnector.addBox(0F, 0F, 0F, 4, 2, 4);
		solarPanelConnector.setRotationPoint(-2F, 15F, -2F);
		solarPanelConnector.setTextureSize(64, 64);
		solarPanelConnector.mirror = true;
		setRotation(solarPanelConnector, 0F, 0F, 0F);
		solarPanelRod2 = new FastModelRenderer(this, 16, 33);
		solarPanelRod2.addBox(0F, 0F, 0F, 2, 3, 2);
		solarPanelRod2.setRotationPoint(-1F, 19F, -1F);
		solarPanelRod2.setTextureSize(64, 64);
		solarPanelRod2.mirror = true;
		setRotation(solarPanelRod2, 0F, 0F, 0F);
		solarPanelPipeConnector = new FastModelRenderer(this, 24, 33);
		solarPanelPipeConnector.addBox(0F, 0F, 0F, 3, 3, 3);
		solarPanelPipeConnector.setRotationPoint(-1.5F, 18F, -1.5F);
		solarPanelPipeConnector.setTextureSize(64, 64);
		solarPanelPipeConnector.mirror = true;
		setRotation(solarPanelPipeConnector, 0F, 0F, 0F);
		solarPanelPort = new FastModelRenderer(this, 0, 44);
		solarPanelPort.addBox(0F, 0F, 0F, 8, 1, 8);
		solarPanelPort.setRotationPoint(-4F, 23F, -4F);
		solarPanelPort.setTextureSize(64, 64);
		solarPanelPort.mirror = true;
		setRotation(solarPanelPort, 0F, 0F, 0F);
		solarPanelRod1 = new FastModelRenderer(this, 16, 33);
		solarPanelRod1.addBox(0F, 0F, 0F, 2, 3, 2);
		solarPanelRod1.setRotationPoint(-1F, 16F, -1F);
		solarPanelRod1.setTextureSize(64, 64);
		solarPanelRod1.mirror = true;
		setRotation(solarPanelRod1, 0F, 0F, 0F);
		solarPanelPipeBase = new FastModelRenderer(this, 0, 39);
		solarPanelPipeBase.addBox(0F, 0F, 0F, 4, 1, 4);
		solarPanelPipeBase.setRotationPoint(-2F, 22F, -2F);
		solarPanelPipeBase.setTextureSize(64, 64);
		solarPanelPipeBase.mirror = true;
		setRotation(solarPanelPipeBase, 0F, 0F, 0F);
	}


	private void setRotation(FastModelRenderer model, float x, float y, float z) 
	{
		model.rotateAngleX = x;
		model.rotateAngleY = y;
		model.rotateAngleZ = z;
	}
}
