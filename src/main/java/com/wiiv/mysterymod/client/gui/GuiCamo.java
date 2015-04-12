package com.wiiv.mysterymod.client.gui;

import java.util.List;

import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import com.wiiv.mysterymod.client.gui.container.ContainerCamo;
import com.wiiv.mysterymod.tileentities.TileEntityCamo;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class GuiCamo extends GuiMMGeneric{
	
	protected TileEntityCamo camo;

	public GuiCamo(InventoryPlayer invPlayer, TileEntityCamo camo) {
		super(new ContainerCamo(invPlayer, camo));
		
		this.camo = camo;
		
		xSize = 176;
		ySize = 166;
	}

	private static final ResourceLocation texture = new ResourceLocation("mm", "textures/gui/camo.png");
	
	@Override
	protected void drawGuiContainerBackgroundLayer(float f, int x, int y) {
		
		GL11.glColor4f(1, 1, 1, 1);
		
		mc.getTextureManager().bindTexture(texture);
		drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);
	}
	
	@Override
	protected void drawGuiContainerForegroundLayer(int x, int y) {
		
		fontRendererObj.drawString("Camouflager", 7, 6, 0x404040);
	}
	
	@Override
	public void initGui() {
		super.initGui();
	}
	
	@Override
	protected void actionPerformed(GuiButton button) {

	}
	
	@Override
	protected void mouseClicked(int x, int y, int button) {
		super.mouseClicked(x, y, button);

	}
	
	private boolean currentMode;
	
	@Override
	protected void mouseClickMove(int x, int y, int button, long timeSinceClicked) {
		super.mouseClickMove(x, y, button, timeSinceClicked);
		
	}
	
	@Override
	public void mouseMovedOrUp(int x, int y, int button) {
		super.mouseMovedOrUp(x, y, button);
		
	}
	
	protected int getLeft(){
		return guiLeft;
	}
	
	protected int getTop(){
		return guiTop;
	}
	
	protected FontRenderer getFontRenderer() {
		return fontRendererObj;
	}
	
	protected void drawHoverString(List lst, int x, int y){
		drawHoveringText(lst, x, y, fontRendererObj);
	}
	
		
}
