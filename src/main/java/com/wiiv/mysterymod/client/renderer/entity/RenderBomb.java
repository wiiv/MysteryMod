package com.wiiv.mysterymod.client.renderer.entity;

import net.minecraft.client.renderer.entity.Render;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import com.wiiv.mysterymod.client.model.ModelBomb;

public class RenderBomb extends Render{

	private static final ResourceLocation texture = new ResourceLocation("mm", "textures/models/bomb.png");
	
	private ModelBomb model;
	
	public RenderBomb() {
		
		model = new ModelBomb();
		shadowSize = 0.5F;
	}
	
	@Override
	public void doRender(Entity bomb, double x, double y, double z, float yaw, float partialTickTime) {
		
		GL11.glPushMatrix();
		
		GL11.glTranslatef((float)x, (float)y, (float)z);
		GL11.glScalef(-1.0F, -1.0F, 1.0F);
		
		bindEntityTexture(bomb);
		model.render(bomb, 0, 0, 0, 0, 0, 0.0625F);
		
		GL11.glPopMatrix();
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity bomb) {
		
		return texture;
	}

}
