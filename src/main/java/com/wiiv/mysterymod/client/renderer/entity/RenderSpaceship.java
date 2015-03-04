package com.wiiv.mysterymod.client.renderer.entity;

import net.minecraft.client.renderer.entity.Render;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import com.wiiv.mysterymod.client.model.ModelSpaceship;
import com.wiiv.mysterymod.entities.EntitySpaceship;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderSpaceship extends Render {
	
    private static final ResourceLocation texture = new ResourceLocation("example", "textures/models/spaceship.png");
	private static final ResourceLocation chargedTexture = new ResourceLocation("example", "textures/models/spaceship_charged.png");

    protected ModelSpaceship model;

    public RenderSpaceship() {
        
        model = new ModelSpaceship();
        shadowSize = 1.0F;
    }

    public void renderSpaceship(EntitySpaceship spaceship, double x, double y, double z, float yaw, float partialTickTime) {
        GL11.glPushMatrix();
        GL11.glTranslatef((float)x, (float)y, (float)z);
        GL11.glRotatef(180.0F - yaw, 0.0F, 1.0F, 0.0F);
        GL11.glScalef(-1.0F, -1.0F, 1.0F);     

        bindEntityTexture(spaceship);
        
        model.render(spaceship, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
        
        GL11.glPopMatrix();
    }


    @Override
    public void doRender(Entity entity, double x, double y, double z, float yaw, float partialTickTime)
    {
        this.renderSpaceship((EntitySpaceship)entity, x, y, z, yaw, partialTickTime);
    }

	@Override
	protected ResourceLocation getEntityTexture(Entity entity) {
		return ((EntitySpaceship)entity).isCharged() ? chargedTexture : texture;
	}
}
