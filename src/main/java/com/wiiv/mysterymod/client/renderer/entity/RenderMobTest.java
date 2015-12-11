package com.wiiv.mysterymod.client.renderer.entity;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.entity.RenderBiped;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.ResourceLocation;


public class RenderMobTest extends RenderBiped{

	public RenderMobTest(ModelBiped model, float shadowSize) {
	
		super(model, shadowSize);
		}
	
	 
	@Override
	protected ResourceLocation getEntityTexture(Entity entity){
		
		return new ResourceLocation("mm", "textures/models/MobTest.png");
	    }
	
	
	@Override
	public void doRender(Entity entity, double x, double y, double z, float rotationYaw, float rotationPitch){
	     
		super.doRender((EntityLiving)entity, x, y, z, rotationYaw, rotationPitch);
		}
}
