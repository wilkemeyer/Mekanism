package mekanism.client.model;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ModelMetallurgicInfuser extends FastModelBase
{
	FastModelRenderer base;
    FastModelRenderer back;
    FastModelRenderer connector1;
    FastModelRenderer connector2;
    FastModelRenderer sideRight;
    FastModelRenderer top;
    FastModelRenderer sideLeft;
    FastModelRenderer tap1;
    FastModelRenderer tap2;
    FastModelRenderer tapBase1;
    FastModelRenderer tapBase2;
    FastModelRenderer divider;
    FastModelRenderer plate1;
    FastModelRenderer plate2;
    FastModelRenderer plate3;
    FastModelRenderer bar1;
    FastModelRenderer bar2;

	public ModelMetallurgicInfuser() 
	{
		textureWidth = 128;
		textureHeight = 64;

		base = new FastModelRenderer(this, 0, 0);
		base.addBox(0F, 0F, 0F, 16, 4, 16);
		base.setRotationPoint(-8F, 20F, -8F);
		base.setTextureSize(128, 64);
		base.mirror = true;
		setRotation(base, 0F, 0F, 0F);
		back = new FastModelRenderer(this, 42, 20);
		back.addBox(0F, 0F, 0F, 16, 12, 1);
		back.setRotationPoint(-8F, 8F, 7F);
		back.setTextureSize(128, 64);
		back.mirror = true;
		setRotation(back, 0F, 0F, 0F);
		connector1 = new FastModelRenderer(this, 0, 8);
		connector1.addBox(0F, 0F, 0F, 1, 5, 3);
		connector1.setRotationPoint(-4F, 8.5F, -3F);
		connector1.setTextureSize(128, 64);
		connector1.mirror = true;
		setRotation(connector1, 0F, 0F, 0F);
		connector2 = new FastModelRenderer(this, 0, 8);
		connector2.addBox(0F, 0F, 0F, 1, 5, 3);
		connector2.setRotationPoint(3F, 8.5F, -3F);
		connector2.setTextureSize(128, 64);
		connector2.mirror = true;
		setRotation(connector2, 0F, 0F, 0F);
		sideRight = new FastModelRenderer(this, 64, 0);
		sideRight.mirror = true;
		sideRight.addBox(0F, 0F, 0F, 1, 11, 7);
		sideRight.setRotationPoint(7F, 9F, 0F);
		sideRight.setTextureSize(128, 64);
		setRotation(sideRight, 0F, 0F, 0F);
		top = new FastModelRenderer(this, 80, 0);
		top.addBox(0F, 0F, 0F, 16, 1, 7);
		top.setRotationPoint(-8F, 8F, 0F);
		top.setTextureSize(128, 64);
		top.mirror = true;
		setRotation(top, 0F, 0F, 0F);
		sideLeft = new FastModelRenderer(this, 64, 0);
		sideLeft.addBox(0F, 0F, 0F, 1, 11, 7);
		sideLeft.setRotationPoint(-8F, 9F, 0F);
		sideLeft.setTextureSize(128, 64);
		sideLeft.mirror = true;
		setRotation(sideLeft, 0F, 0F, 0F);
		tap1 = new FastModelRenderer(this, 80, 8);
		tap1.addBox(0F, 0F, 0F, 2, 1, 11);
		tap1.setRotationPoint(-4.5F, 11.5F, -4F);
		tap1.setTextureSize(128, 64);
		tap1.mirror = true;
		setRotation(tap1, 0F, 0F, 0F);
		tap2 = new FastModelRenderer(this, 80, 8);
		tap2.addBox(0F, 0F, 0F, 2, 1, 11);
		tap2.setRotationPoint(2.5F, 11.5F, -4F);
		tap2.setTextureSize(128, 64);
		tap2.mirror = true;
		setRotation(tap2, 0F, 0F, 0F);
		tapBase1 = new FastModelRenderer(this, 4, 0);
		tapBase1.addBox(0F, 0F, 0F, 2, 1, 2);
		tapBase1.setRotationPoint(-4.5F, 12.5F, 5F);
		tapBase1.setTextureSize(128, 64);
		tapBase1.mirror = true;
		setRotation(tapBase1, 0F, 0F, 0F);
		tapBase2 = new FastModelRenderer(this, 4, 0);
		tapBase2.addBox(0F, 0F, 0F, 2, 1, 2);
		tapBase2.setRotationPoint(2.5F, 12.5F, 5F);
		tapBase2.setTextureSize(128, 64);
		tapBase2.mirror = true;
		setRotation(tapBase2, 0F, 0F, 0F);
		divider = new FastModelRenderer(this, 66, 20);
		divider.addBox(0F, 0F, 0F, 13, 1, 14);
		divider.setRotationPoint(-6.5F, 16F, -6.5F);
		divider.setTextureSize(128, 64);
		divider.mirror = true;
		setRotation(divider, 0F, 0F, 0F);
		plate1 = new FastModelRenderer(this, 0, 20);
		plate1.addBox(0F, 0F, 0F, 14, 3, 14);
		plate1.setRotationPoint(-7F, 9F, -7F);
		plate1.setTextureSize(128, 64);
		plate1.mirror = true;
		setRotation(plate1, 0F, 0F, 0F);
		plate2 = new FastModelRenderer(this, 0, 37);
		plate2.addBox(0F, 0F, 0F, 14, 3, 14);
		plate2.setRotationPoint(-7F, 13F, -7F);
		plate2.setTextureSize(128, 64);
		plate2.mirror = true;
		setRotation(plate2, 0F, 0F, 0F);
		plate3 = new FastModelRenderer(this, 0, 37);
		plate3.addBox(0F, 0F, 0F, 14, 3, 14);
		plate3.setRotationPoint(-7F, 17F, -7F);
		plate3.setTextureSize(128, 64);
		plate3.mirror = true;
		setRotation(plate3, 0F, 0F, 0F);
		bar1 = new FastModelRenderer(this, 0, 0);
		bar1.addBox(0F, 0F, 0F, 1, 1, 1);
		bar1.setRotationPoint(-6.5F, 12F, -6.5F);
		bar1.setTextureSize(128, 64);
		bar1.mirror = true;
		setRotation(bar1, 0F, 0F, 0F);
		bar2 = new FastModelRenderer(this, 0, 0);
		bar2.addBox(0F, 0F, 0F, 1, 1, 1);
		bar2.setRotationPoint(5.5F, 12F, -6.5F);
		bar2.setTextureSize(128, 64);
		bar2.mirror = true;
		setRotation(bar2, 0F, 0F, 0F);
	}


	private void setRotation(FastModelRenderer model, float x, float y, float z)
	{
		model.rotateAngleX = x;
		model.rotateAngleY = y;
		model.rotateAngleZ = z;
	}
}
