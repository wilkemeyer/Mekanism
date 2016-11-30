package mekanism.generators.client.model;


import mekanism.client.model.FastModelBase;
import mekanism.client.model.FastModelRenderer;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ModelAdvancedSolarGenerator extends FastModelBase 
{
	FastModelRenderer Shape1;
	FastModelRenderer Shape2;
	FastModelRenderer Shape3;
	FastModelRenderer Shape4;
	FastModelRenderer Shape5;
	FastModelRenderer Shape6;
	FastModelRenderer Shape7;
	FastModelRenderer Shape8;
	FastModelRenderer Shape9;
	FastModelRenderer Shape10;
	FastModelRenderer Shape11;
	FastModelRenderer Shape12;
	FastModelRenderer Shape13;
	FastModelRenderer Shape14;
	FastModelRenderer Shape15;
	FastModelRenderer Shape16;

	public ModelAdvancedSolarGenerator() 
	{
		textureWidth = 256;
		textureHeight = 256;

		Shape1 = new FastModelRenderer(this, 0, 95);
		Shape1.addBox(0F, -1F, -1F, 40, 2, 2);
		Shape1.setRotationPoint(-20F, -17F, 0F);
		Shape1.setTextureSize(256, 256);
		Shape1.mirror = true;
		setRotation(Shape1, 0F, 0F, 0F); //rotates
		Shape2 = new FastModelRenderer(this, 0, 49);
		Shape2.addBox(0F, -1F, -23F, 16, 1, 45);
		Shape2.setRotationPoint(7F, -17F, 0F);
		Shape2.setTextureSize(256, 256);
		Shape2.mirror = true;
		setRotation(Shape2, 0F, 0F, 0F); //rotates
		Shape3 = new FastModelRenderer(this, 0, 0);
		Shape3.addBox(0F, -2F, -24F, 18, 1, 48);
		Shape3.setRotationPoint(6F, -17F, 0F);
		Shape3.setTextureSize(256, 256);
		Shape3.mirror = true;
		setRotation(Shape3, 0F, 0F, 0F); //rotates
		Shape4 = new FastModelRenderer(this, 86, 21);
		Shape4.addBox(0F, 0F, 0F, 6, 6, 10);
		Shape4.setRotationPoint(-3F, 13F, -7F);
		Shape4.setTextureSize(256, 256);
		Shape4.mirror = true;
		setRotation(Shape4, 0F, 0F, 0F);
		Shape5 = new FastModelRenderer(this, 0, 0);
		Shape5.addBox(0F, 0F, 0F, 4, 40, 4);
		Shape5.setRotationPoint(-2F, -16F, -2F);
		Shape5.setTextureSize(256, 256);
		Shape5.mirror = true;
		setRotation(Shape5, 0F, 0F, 0F);
		Shape6 = new FastModelRenderer(this, 16, 28);
		Shape6.addBox(0F, 0F, 0F, 2, 2, 12);
		Shape6.setRotationPoint(1F, -14F, -6F);
		Shape6.setTextureSize(256, 256);
		Shape6.mirror = true;
		setRotation(Shape6, 0F, 0F, 0F);
		Shape7 = new FastModelRenderer(this, 0, 50);
		Shape7.addBox(0F, 0F, 0F, 1, 7, 7);
		Shape7.setRotationPoint(1.5F, -20.5F, -3.5F);
		Shape7.setTextureSize(256, 256);
		Shape7.mirror = true;
		setRotation(Shape7, 0F, 0F, 0F);
		Shape8 = new FastModelRenderer(this, 16, 28);
		Shape8.addBox(0F, 0F, 0F, 2, 2, 12);
		Shape8.setRotationPoint(-3F, -14F, -6F);
		Shape8.setTextureSize(256, 256);
		Shape8.mirror = true;
		setRotation(Shape8, 0F, 0F, 0F);
		Shape9 = new FastModelRenderer(this, 16, 0);
		Shape9.addBox(0F, 0F, 0F, 8, 6, 6);
		Shape9.setRotationPoint(-4F, -20F, -3F);
		Shape9.setTextureSize(256, 256);
		Shape9.mirror = true;
		setRotation(Shape9, 0F, 0F, 0F);
		Shape10 = new FastModelRenderer(this, 0, 50);
		Shape10.addBox(0F, 0F, 0F, 1, 7, 7);
		Shape10.setRotationPoint(-2.5F, -20.5F, -3.5F);
		Shape10.setTextureSize(256, 256);
		Shape10.mirror = true;
		setRotation(Shape10, 0F, 0F, 0F);
		Shape11 = new FastModelRenderer(this, 0, 0);
		Shape11.addBox(0F, -2F, -24F, 18, 1, 48);
		Shape11.setRotationPoint(-24F, -17F, 0F);
		Shape11.setTextureSize(256, 256);
		Shape11.mirror = true;
		setRotation(Shape11, 0F, 0F, 0F); //rotates
		Shape12 = new FastModelRenderer(this, 0, 49);
		Shape12.addBox(0F, -1F, -23F, 16, 1, 45);
		Shape12.setRotationPoint(-23F, -17F, 0F);
		Shape12.setTextureSize(256, 256);
		Shape12.mirror = true;
		setRotation(Shape12, 0F, 0F, 0F); //rotates
		Shape13 = new FastModelRenderer(this, 78, 50);
		Shape13.addBox(0F, 0F, 0F, 16, 2, 16);
		Shape13.setRotationPoint(-8F, 22F, -8F);
		Shape13.setTextureSize(256, 256);
		Shape13.mirror = true;
		setRotation(Shape13, 0F, 0F, 0F);
		Shape14 = new FastModelRenderer(this, 86, 12);
		Shape14.addBox(0F, 0F, 0F, 8, 8, 1);
		Shape14.setRotationPoint(-4F, 12F, -8F);
		Shape14.setTextureSize(256, 256);
		Shape14.mirror = true;
		setRotation(Shape14, 0F, 0F, 0F);
		Shape15 = new FastModelRenderer(this, 16, 12);
		Shape15.addBox(0F, 0F, 0F, 8, 8, 8);
		Shape15.setRotationPoint(-4F, 14F, -4F);
		Shape15.setTextureSize(256, 256);
		Shape15.mirror = true;
		setRotation(Shape15, 0F, 0F, 0F);
		Shape16 = new FastModelRenderer(this, 86, 0);
		Shape16.addBox(0F, 0F, 0F, 10, 2, 10);
		Shape16.setRotationPoint(-5F, 21F, -5F);
		Shape16.setTextureSize(256, 256);
		Shape16.mirror = true;
		setRotation(Shape16, 0F, 0F, 0F);
	}

	private void setRotation(FastModelRenderer model, float x, float y, float z) 
	{
		model.rotateAngleX = x;
		model.rotateAngleY = y;
		model.rotateAngleZ = z;
	}
}
