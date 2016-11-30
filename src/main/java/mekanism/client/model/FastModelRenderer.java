package mekanism.client.model;

import net.minecraft.client.model.ModelRenderer;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class FastModelRenderer extends ModelRenderer
{
	public FastModelRenderer(FastModelBase base, String name){

		super(base, name);
		
		// Register this ModelRenderer at FastModelRenderer for optimized list generation code
		base.addSubRenderer(this);
	}


	public FastModelRenderer(FastModelBase base){

		super(base);
		
		// Register this ModelRenderer at FastModelRenderer for optimized list generation code
		base.addSubRenderer(this);
	}

	public FastModelRenderer(FastModelBase base, int tex_x, int tex_y){ // UV

		super(base, tex_x, tex_y);
		
		// Register this ModelRenderer at FastModelRenderer for optimized list generation code
		base.addSubRenderer(this);
	}

	@Override
	public void postRender(float size) {
	}
	
	@Override 
	public void renderWithRotation(float size) {
	}
	
	@Override
	public void render(float p_78785_1_){
	}
}
