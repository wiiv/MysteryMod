package com.wiiv.mysterymod.client.renderer.tileentity;

import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import com.wiiv.mysterymod.client.model.ModelAlembic;

public class RenderAlembicTileEntity extends TileEntitySpecialRenderer{

	private static final ResourceLocation texture = new ResourceLocation("example", "textures/models/alembic.png");
	
	private ModelAlembic model;
	
	public RenderAlembicTileEntity() {
		this.model = new ModelAlembic();
	}
	
	@Override
	public void renderTileEntityAt(TileEntity alembic, double x, double y, double z, float f) {
		
		GL11.glPushMatrix();
		
		GL11.glTranslatef((float)x + 0.5F, (float)y + 0.5F, (float)z + 0.5F);
		
		float scale = 1.0F; 
		GL11.glScalef(-scale, -scale, scale);
	
		bindTexture(texture);
		
		GL11.glPushMatrix();
		model.renderModel(0.0625F);
		GL11.glPopMatrix();
		
		GL11.glPopMatrix();
	}

}
