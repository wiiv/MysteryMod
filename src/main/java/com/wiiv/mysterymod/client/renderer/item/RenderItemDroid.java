package com.wiiv.mysterymod.client.renderer.item;

import net.minecraft.client.Minecraft;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.IItemRenderer;

import org.lwjgl.opengl.GL11;

import com.wiiv.mysterymod.client.model.ModelDroid;
import com.wiiv.mysterymod.client.renderer.entity.RenderDroid;

public class RenderItemDroid implements IItemRenderer{

	private ModelDroid model;
	
	public RenderItemDroid(ModelDroid model){
		this.model =  model;
	}
	
	@Override
	public boolean handleRenderType(ItemStack item, ItemRenderType type) {
		
		//return type != ItemRenderType.ENTITY && item.stackSize != 1;
		return true;
	}

	@Override
	public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item, ItemRendererHelper helper) {
		
		return helper != ItemRendererHelper.ENTITY_BOBBING && helper != ItemRendererHelper.ENTITY_ROTATION;
		//return true;
	}

	@Override
	public void renderItem(ItemRenderType type, ItemStack item, Object... data) {
		
		GL11.glPushMatrix();//1
		
		float scale = 1.0F;
		GL11.glScalef(-scale, -scale, scale);//3
		
		Minecraft.getMinecraft().getTextureManager().bindTexture(RenderDroid.texture);//4
		
		switch(type) {
		
			case INVENTORY:
				GL11.glTranslatef(0.0F, 0.2F, 0.0F);
				break;
				
			case EQUIPPED:
				GL11.glTranslatef(-0.8F, -0.2F, 0.8F);
				break;
				
			case EQUIPPED_FIRST_PERSON:
				GL11.glTranslatef(0.0F, -0.8F, 0.8F);
				break;
				
			default:
		}//2
		
		model.render(-6.0F, 0.0F, 0.0F, -(float)Math.PI / 2, /*R*/0.5F, /*G*/0.0F, /*b*/(item.stackSize / 64.0F), 0.0625F);
		
		GL11.glPopMatrix();//1
	}

}
