package mekanism.client.model;


import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ModelChemicalWasher extends FastModelBase
{
	FastModelRenderer tankBack;
	FastModelRenderer base;
	FastModelRenderer portTop;
	FastModelRenderer pipe1;
	FastModelRenderer pipe2b;
	FastModelRenderer portRight;
	FastModelRenderer bridge1;
	FastModelRenderer bridge2;
	FastModelRenderer bridge3;
	FastModelRenderer conduit;
	FastModelRenderer bridge4;
	FastModelRenderer pipe2;
	FastModelRenderer tankLeft;
	FastModelRenderer connectorRight;
	FastModelRenderer portLeft;
	FastModelRenderer connectorLeft;
	FastModelRenderer tankRight;
	FastModelRenderer tubeLeft1;
	FastModelRenderer tubeLeft2;
	FastModelRenderer tubeRight3;
	FastModelRenderer tubeRight1;
	FastModelRenderer tubeRight2;
	FastModelRenderer tubeLeft3;

	public ModelChemicalWasher() 
	{
		textureWidth = 128;
		textureHeight = 64;

		tankBack = new FastModelRenderer(this, 0, 20);
		tankBack.addBox(0F, 0F, 0F, 16, 10, 6);
		tankBack.setRotationPoint(-8F, 10F, 2F);
		tankBack.setTextureSize(128, 64);
		tankBack.mirror = true;
		setRotation(tankBack, 0F, 0F, 0F);
		base = new FastModelRenderer(this, 0, 0);
		base.addBox(0F, 0F, 0F, 16, 4, 16);
		base.setRotationPoint(-8F, 20F, -8F);
		base.setTextureSize(128, 64);
		base.mirror = true;
		setRotation(base, 0F, 0F, 0F);
		portTop = new FastModelRenderer(this, 53, 33);
		portTop.addBox(0F, 0F, 0F, 10, 1, 10);
		portTop.setRotationPoint(-5F, 8F, -5F);
		portTop.setTextureSize(128, 64);
		portTop.mirror = true;
		setRotation(portTop, 0F, 0F, 0F);
		pipe1 = new FastModelRenderer(this, 66, 9);
		pipe1.addBox(0F, 0F, 0F, 7, 5, 7);
		pipe1.setRotationPoint(-3.5F, 9F, -3.5F);
		pipe1.setTextureSize(128, 64);
		pipe1.mirror = true;
		setRotation(pipe1, 0F, 0F, 0F);
		pipe2b = new FastModelRenderer(this, 44, 21);
		pipe2b.addBox(0F, 0F, 0F, 1, 8, 4);
		pipe2b.setRotationPoint(-3.49F, 14F, -3.5F);
		pipe2b.setTextureSize(128, 64);
		pipe2b.mirror = true;
		setRotation(pipe2b, 0.837758F, 0F, 0F);
		portRight = new FastModelRenderer(this, 48, 0);
		portRight.addBox(0F, 0F, 0F, 1, 8, 8);
		portRight.setRotationPoint(7.01F, 12F, -4F);
		portRight.setTextureSize(128, 64);
		portRight.mirror = true;
		setRotation(portRight, 0F, 0F, 0F);
		bridge1 = new FastModelRenderer(this, 0, 0);
		bridge1.addBox(0F, 0F, 0F, 2, 1, 1);
		bridge1.setRotationPoint(-1F, 11F, -7F);
		bridge1.setTextureSize(128, 64);
		bridge1.mirror = true;
		setRotation(bridge1, 0F, 0F, 0F);
		bridge2 = new FastModelRenderer(this, 0, 0);
		bridge2.addBox(0F, 0F, 0F, 2, 1, 1);
		bridge2.setRotationPoint(-1F, 13F, -7F);
		bridge2.setTextureSize(128, 64);
		bridge2.mirror = true;
		setRotation(bridge2, 0F, 0F, 0F);
		bridge3 = new FastModelRenderer(this, 0, 0);
		bridge3.addBox(0F, 0F, 0F, 2, 1, 1);
		bridge3.setRotationPoint(-1F, 15F, -7F);
		bridge3.setTextureSize(128, 64);
		bridge3.mirror = true;
		setRotation(bridge3, 0F, 0F, 0F);
		conduit = new FastModelRenderer(this, 0, 3);
		conduit.addBox(0F, 0F, 0F, 2, 1, 2);
		conduit.setRotationPoint(-1F, 19.5F, -5F);
		conduit.setTextureSize(128, 64);
		conduit.mirror = true;
		setRotation(conduit, 0F, 0F, 0F);
		bridge4 = new FastModelRenderer(this, 0, 0);
		bridge4.addBox(0F, 0F, 0F, 2, 1, 1);
		bridge4.setRotationPoint(-1F, 17F, -7F);
		bridge4.setTextureSize(128, 64);
		bridge4.mirror = true;
		setRotation(bridge4, 0F, 0F, 0F);
		pipe2 = new FastModelRenderer(this, 54, 21);
		pipe2.addBox(0F, 0F, 0F, 6, 8, 4);
		pipe2.setRotationPoint(-2.51F, 14F, -3.5F);
		pipe2.setTextureSize(128, 64);
		pipe2.mirror = true;
		setRotation(pipe2, 0.837758F, 0F, 0F);
		tankLeft = new FastModelRenderer(this, 0, 36);
		tankLeft.addBox(0F, 0F, 0F, 7, 10, 8);
		tankLeft.setRotationPoint(-8F, 10F, -8F);
		tankLeft.setTextureSize(128, 64);
		tankLeft.mirror = true;
		setRotation(tankLeft, 0F, 0F, 0F);
		connectorRight = new FastModelRenderer(this, 0, 7);
		connectorRight.addBox(0F, 0F, 0F, 2, 6, 2);
		connectorRight.setRotationPoint(5F, 13F, 0F);
		connectorRight.setTextureSize(128, 64);
		connectorRight.mirror = true;
		setRotation(connectorRight, 0F, 0F, 0F);
		portLeft = new FastModelRenderer(this, 48, 0);
		portLeft.addBox(0F, 0F, 0F, 1, 8, 8);
		portLeft.setRotationPoint(-8.01F, 12F, -4F);
		portLeft.setTextureSize(128, 64);
		portLeft.mirror = true;
		setRotation(portLeft, 0F, 0F, 0F);
		connectorLeft = new FastModelRenderer(this, 0, 7);
		connectorLeft.addBox(0F, 0F, 0F, 2, 6, 2);
		connectorLeft.setRotationPoint(-7F, 13F, 0F);
		connectorLeft.setTextureSize(128, 64);
		connectorLeft.mirror = true;
		setRotation(connectorLeft, 0F, 0F, 0F);
		tankRight = new FastModelRenderer(this, 0, 36);
		tankRight.mirror = true;
		tankRight.addBox(0F, 0F, 0F, 7, 10, 8);
		tankRight.setRotationPoint(1F, 10F, -8F);
		tankRight.setTextureSize(128, 64);
		setRotation(tankRight, 0F, 0F, 0F);
		tubeLeft1 = new FastModelRenderer(this, 30, 36);
		tubeLeft1.addBox(0F, 0F, -1F, 1, 2, 1);
		tubeLeft1.setRotationPoint(-6F, 8.5F, 4F);
		tubeLeft1.setTextureSize(128, 64);
		tubeLeft1.mirror = true;
		setRotation(tubeLeft1, 0.6806784F, 0F, 0F);
		tubeLeft2 = new FastModelRenderer(this, 30, 36);
		tubeLeft2.addBox(0F, 0F, 0F, 1, 1, 8);
		tubeLeft2.setRotationPoint(-6F, 8.5F, -4F);
		tubeLeft2.setTextureSize(128, 64);
		tubeLeft2.mirror = true;
		setRotation(tubeLeft2, 0F, 0F, 0F);
		tubeRight3 = new FastModelRenderer(this, 30, 39);
		tubeRight3.addBox(0F, -1F, 0F, 1, 2, 1);
		tubeRight3.setRotationPoint(6F, 10F, -2.5F);
		tubeRight3.setTextureSize(128, 64);
		tubeRight3.mirror = true;
		setRotation(tubeRight3, 0F, 0F, 0.3141593F);
		tubeRight1 = new FastModelRenderer(this, 30, 39);
		tubeRight1.addBox(0F, -1F, 0F, 1, 2, 1);
		tubeRight1.setRotationPoint(6F, 10F, -6.5F);
		tubeRight1.setTextureSize(128, 64);
		tubeRight1.mirror = true;
		setRotation(tubeRight1, 0F, 0F, 0.3141593F);
		tubeRight2 = new FastModelRenderer(this, 30, 39);
		tubeRight2.addBox(0F, -1F, 0F, 1, 2, 1);
		tubeRight2.setRotationPoint(6F, 10F, -4.5F);
		tubeRight2.setTextureSize(128, 64);
		tubeRight2.mirror = true;
		setRotation(tubeRight2, 0F, 0F, 0.3141593F);
		tubeLeft3 = new FastModelRenderer(this, 30, 36);
		tubeLeft3.addBox(0F, 0F, 0F, 1, 2, 1);
		tubeLeft3.setRotationPoint(-6F, 9.5F, -4F);
		tubeLeft3.setTextureSize(128, 64);
		tubeLeft3.mirror = true;
		setRotation(tubeLeft3, 0F, 0F, -0.8203047F);
	}


	private void setRotation(FastModelRenderer model, float x, float y, float z)
	{
		model.rotateAngleX = x;
		model.rotateAngleY = y;
		model.rotateAngleZ = z;
	}
}
