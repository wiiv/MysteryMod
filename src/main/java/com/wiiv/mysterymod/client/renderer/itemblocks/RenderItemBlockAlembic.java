package com.wiiv.mysterymod.client.renderer.itemblocks;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.client.IItemRenderer;

import org.lwjgl.opengl.GL11;

import com.wiiv.mysterymod.client.renderer.tileentity.RenderAlembicTileEntity;

public class RenderItemBlockAlembic implements IItemRenderer{

	TileEntitySpecialRenderer renderAlembic;
	private TileEntity tileEntityAlembic;
	
	public RenderItemBlockAlembic(TileEntitySpecialRenderer render, TileEntity tileEntity){
		renderAlembic = render;
		tileEntityAlembic = tileEntity;
	}
	
	@Override
	public boolean handleRenderType(ItemStack item, ItemRenderType type) {
		
		//return type != ItemRenderType.ENTITY && item.stackSize != 1;
		return true;
	}

	@Override
	public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item, ItemRendererHelper helper) {
		
		//return helper != ItemRendererHelper.ENTITY_BOBBING && helper != ItemRendererHelper.ENTITY_ROTATION;
		return true;
	}

	@Override
	public void renderItem(ItemRenderType type, ItemStack item, Object... data) {
		
		GL11.glPushMatrix();//1
		
		float scale = 1.0F;
		GL11.glScalef(scale, scale, scale);//3
		
		
		Minecraft.getMinecraft().getTextureManager().bindTexture(RenderAlembicTileEntity.texture);//4
		
		switch(type) {
		
			case INVENTORY:
				GL11.glTranslatef(0.0F, 0.0F, 0.0F);
				break;
				
			case EQUIPPED:
				GL11.glTranslatef(0.0F, 0.0F, 0.0F);
				break;
				
			case EQUIPPED_FIRST_PERSON:
				GL11.glTranslatef(0.0F, 0.0F, 0.0F);
				break;
				
			default:
		}//2
		
		renderAlembic.renderTileEntityAt(tileEntityAlembic, 0.0D, 0.0D, 0.0D, 0.0F);
		
		GL11.glPopMatrix();//1
	}

}
