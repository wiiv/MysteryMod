package com.wiiv.mysterymod.client.gui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.item.EntityFallingBlock;
import net.minecraft.init.Blocks;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class GuiTabPreview extends GuiTab {
	
	//private final Entity anvil;
	
	private float roll;
	private float yaw;
	
	private boolean rollDown;
	
	EntityFallingBlock anvil = new EntityFallingBlock(Minecraft.getMinecraft().theWorld, 0, 0, 0, Blocks.anvil);
	
	@SideOnly(Side.CLIENT)
	public GuiTabPreview(int id) {
		
		super(GuiColor.GREY + "anvil preview".toUpperCase(), id);
	}
	
	public static final GuiRectangle background = new GuiRectangle(106, 41, 58, 58);
	
	@Override
	public void drawBackground(GuiMachine gui, int x, int y) {
		
		background.draw(gui, 176, 89);
		
		GL11.glPushMatrix();//1
		
		GL11.glTranslatef(gui.getLeft() + 135, gui.getTop() + 70, 100);
		
		float scale = 32F;
		GL11.glScalef(-scale, scale, scale);
		
		RenderHelper.enableStandardItemLighting();//2
		
		GL11.glRotatef(roll, 1, 0, 0);
		GL11.glRotatef(yaw, 0, 1, 0);
		GL11.glRotatef(180, 0, 0, 1);
		
		RenderManager.instance.renderEntityWithPosYaw(anvil, 0, 0, 0, 0, 0);
		
		//RenderHelper.enableStandardItemLighting();//2
		
		GL11.glPopMatrix();//1
		
		yaw += 0.4F;
		
		if (rollDown) {
			
			roll -= 0.04F;
			
			if (roll < -4){
				
				rollDown = false;
				
				roll = -4F;
			}
			
		}else {
			
			roll += 0.04F;
			
			if (roll > 24){
				
				rollDown = true;
				
				roll = 24F;
			}
		}
	}

	@Override
	public void drawForeground(GuiMachine gui, int x, int y) {
		
		//gui.getFontRenderer().drawString(GuiColor.GREY + "anvil preview".toUpperCase(), 30, 43, 0x404040);
	}

}