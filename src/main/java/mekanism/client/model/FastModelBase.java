package mekanism.client.model;

import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import net.minecraft.client.renderer.GLAllocation;
import net.minecraft.client.renderer.Tessellator;
import org.lwjgl.opengl.GL11;

import java.util.ArrayList;

@SideOnly(Side.CLIENT)
public class FastModelBase extends ModelBase
{
	public ArrayList subList;
	
	private boolean subCompiled;
	private int subDisplayList;
	
	public FastModelBase(){
		subList = new ArrayList();
		subCompiled = false;
		
	} // end ModelBase()
	
	
	public void addSubRenderer(ModelRenderer sub){
		subList.add(sub);
	} // end addSubRenderer()


	public void renderAllSubs(float size){
		
		// Simple Debug Code:
		if(subCompiled == false){
			compileSubDisplayList(size);
		}
		
		GL11.glCallList(this.subDisplayList);
		
	} // end renderAllSubs()
	

	public void render(float size){	// Mekanism Speciifc Routine
		renderAllSubs(size);
	} // end render()
	
	public void compileSubDisplayList(float size){
		Tessellator tessellator = Tessellator.instance;
				
		this.subDisplayList = GLAllocation.generateDisplayLists(1);
		GL11.glNewList(this.subDisplayList, GL11.GL_COMPILE);
		
		int sz = subList.size();
		int j;
		
		for(int i = 0; i < sz; i++){
			ModelRenderer mdl = (ModelRenderer)subList.get(i);
			
			GL11.glTranslatef(mdl.offsetX, mdl.offsetY, mdl.offsetZ);
			
			if(mdl.rotateAngleX == 0.0F && mdl.rotateAngleY == 0.0F && mdl.rotateAngleZ == 0.0F){
				if(mdl.rotationPointX == 0.0F && mdl.rotationPointY == 0.0F && mdl.rotationPointZ == 0.0F){
					// draw all boxes
					for(j = 0; j < mdl.cubeList.size(); j++){
						((ModelBox)mdl.cubeList.get(j)).render(tessellator, size);
					}
					
				}else{
					GL11.glTranslatef(mdl.rotationPointX * size, mdl.rotationPointY * size, mdl.rotationPointZ * size);
					// draw all boxes
					for(j = 0; j < mdl.cubeList.size(); j++){
						((ModelBox)mdl.cubeList.get(j)).render(tessellator, size);
					}
							
					GL11.glTranslatef(-mdl.rotationPointX * size, -mdl.rotationPointY * size, -mdl.rotationPointZ * size);
				}
			}else{
				GL11.glPushMatrix();
				GL11.glTranslatef(mdl.rotationPointX * size, mdl.rotationPointY * size, mdl.rotationPointZ * size);

				if (mdl.rotateAngleZ != 0.0F){
					GL11.glRotatef(mdl.rotateAngleZ * (180F / (float)Math.PI), 0.0F, 0.0F, 1.0F);
				}

				if (mdl.rotateAngleY != 0.0F){
					GL11.glRotatef(mdl.rotateAngleY * (180F / (float)Math.PI), 0.0F, 1.0F, 0.0F);
				}

				if (mdl.rotateAngleX != 0.0F){
					GL11.glRotatef(mdl.rotateAngleX * (180F / (float)Math.PI), 1.0F, 0.0F, 0.0F);
				}
				
				// draw all boxes
				for(j = 0; j < mdl.cubeList.size(); j++){
					((ModelBox)mdl.cubeList.get(j)).render(tessellator, size);
				}
					
				GL11.glPopMatrix();
			}
			
			GL11.glTranslatef(-mdl.offsetX, -mdl.offsetY, -mdl.offsetZ);
		}
		
		GL11.glEndList();
		
		subCompiled = true;		
	}// end compileSubDisplaylist()
	
}
