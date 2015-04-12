package com.wiiv.mysterymod.client.renderer.tileentity;

import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import com.wiiv.mysterymod.client.model.ModelPump;
import com.wiiv.mysterymod.tileentities.TileEntityPump;

public class RenderPumpTileEntity extends TileEntitySpecialRenderer{
	
	public static final ResourceLocation texture = new ResourceLocation("mm", "textures/models/pump.png");
	
	private static final ModelPump model = new ModelPump();
	
	@Override
	public void renderTileEntityAt(TileEntity tilePump, double x, double y, double z, float f) {
		
		TileEntityPump pump = (TileEntityPump) tilePump;
		
		GL11.glPushMatrix();
		
		GL11.glTranslatef((float)x + 0.5F, (float)y + 0.5F, (float)z + 0.5F);
		
		float scale = 1.0F; 
		GL11.glScalef(-scale, -scale, scale);
	
		bindTexture(texture);
		
		GL11.glPushMatrix();
	
		model.renderModel(0.0F, 0.0F, 0.0625F);
	
		GL11.glPopMatrix();
		
		GL11.glPopMatrix();	
	}

}
