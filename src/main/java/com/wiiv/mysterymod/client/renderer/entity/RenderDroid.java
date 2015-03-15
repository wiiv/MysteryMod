package com.wiiv.mysterymod.client.renderer.entity;

import net.minecraft.client.renderer.entity.Render;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import com.wiiv.mysterymod.client.model.ModelDroid;
import com.wiiv.mysterymod.entity.EntityDroid;

public class RenderDroid extends Render {

	private ModelDroid model;
	
	public RenderDroid(ModelDroid model) {
		this.model = model;
		
		shadowSize = 0.5F;
	}
	
	public static final ResourceLocation texture = new ResourceLocation("mm", "textures/models/droid.png");
	
	public void renderDroid(EntityDroid droid, double x, double y, double z, float yaw, float partialTickTime) {
		
		GL11.glPushMatrix();//1
		
		GL11.glTranslatef((float)x, (float)y, (float)z);//2
		
		float scale = 1.0F;
		GL11.glScalef(-scale, -scale, scale);//3
		
		bindEntityTexture(droid);//4
		
		model.render(droid.getHelmetRotationPosition(), droid.getCoreRotation(), droid.getInnerPanelRotation(), droid.getOuterPanelRotation(), droid.getRedCoreColor(), droid.getGreenCoreColor(), droid.getBlueCoreColor(), 0.0625F);
		
		GL11.glPopMatrix();//1
	}
	
	@Override
	public void doRender(Entity entity, double x, double y, double z, float yaw, float partialTickTime) {
		
		renderDroid((EntityDroid)entity, x, y, z, yaw, partialTickTime); 
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity entity) {
		
		return texture;
	}

}
