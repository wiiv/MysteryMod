package com.wiiv.mysterymod.client.gui;

import java.util.List;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import com.wiiv.mysterymod.client.gui.container.ContainerMachine;
import com.wiiv.mysterymod.tileentities.TileEntityMachine;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class GuiMachine extends GuiContainer{
	
	protected TileEntityMachine machine;
	private final GuiTab[] tabs;
	private GuiTab activeTab;

	public GuiMachine(InventoryPlayer playerInv, TileEntityMachine machine) {
		super(new ContainerMachine(playerInv, machine));
		
		this.machine = machine;
		
		xSize = 176;
		ySize = 218;
		
		tabs = new GuiTab[] {
				new GuiTabCustom(0), 
				new GuiTabHeight(1),
				new GuiTabPreview(2)
				};
		
		activeTab = tabs[0];
	}

	private static final ResourceLocation texture = new ResourceLocation("mm", "textures/gui/machine.png");
	
	protected static final GuiRectangle[] rectangles;
	
	static {
		
		rectangles = new GuiRectangle[25];
		
		for (int i = 0; i < 5; i++) {
			
			for (int j = 0; j < 5; j++) {
				
				rectangles[i * 5 + j] = new GuiRectangle(30 + i * 9, 53 + j * 9, 8, 8);
			}
		}
	}
	
	@Override
	protected void drawGuiContainerBackgroundLayer(float f, int x, int y) {
		
		GL11.glColor4f(1, 1, 1, 1);
		
		mc.getTextureManager().bindTexture(texture);
		drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);
		
		int meta = machine.getWorldObj().getBlockMetadata(machine.xCoord, machine.yCoord, machine.zCoord);
		int type =  meta / 2;
		
		//machine type
		if (type == 0) {
			
			drawTexturedModalRect(guiLeft + 12, guiTop + 106, 0, ySize, 20, 20);
			
		}else if (type != 0) {
			
			int srcX = 20 * (type);
			int srcY = ySize;
			
			drawTexturedModalRect(guiLeft + 12, guiTop + 106, srcX, srcY, 20, 20);
		}
		
		//dynamic anvil level
		
		float filled = machine.getAnvils() / 192F;
		
		int barHeight = (int)(filled * 24);
		
		if(barHeight > 0) {
			
			int srcX = xSize;
			int srcY = 24 - barHeight;
			
			drawTexturedModalRect(guiLeft + 152, guiTop + 106 + (24 - barHeight), srcX, srcY, 16, barHeight);
		}
		
		//background for custom type(4) > (GuiTabCustom)
		
		activeTab.drawBackground(this, x, y);
		
		for (GuiTab tab : tabs) {
			
			int srcY =  41;
					
			if (tab == activeTab) {
				
				srcY += 32;
				
			}else if (tab.inRect(this, x, y)) {
				srcY += 16;
			}		
			tab.draw(this, xSize, srcY);
		}
		
		Minecraft.getMinecraft().getTextureManager().bindTexture(TextureMap.locationBlocksTexture);
		//drawTexturedModelRectFromIcon(guiLeft + 63, guiTop + 18, BlocksMMInit.machine.getIcon(1, meta), 16, 16);
	}
	
	@Override
	protected void drawGuiContainerForegroundLayer(int x, int y) {
		super.drawGuiContainerForegroundLayer(x, y);
		
		fontRendererObj.drawString(I18n.format("gui.mm.machine.name"), 7, 6, 0x404040);
		
		int meta = machine.getWorldObj().getBlockMetadata(machine.xCoord, machine.yCoord, machine.zCoord);
		int type =  meta / 2;
		
		String displayType;
		String displayRequirement;
		
		boolean invalid = true;
		
		if (type == 0) {
			
			displayRequirement = "Waiting option...";	
			displayType = "Normal MODE";
			
		}else {
			
			int count = 0;
			String mode = "";
			
			switch (type) {
			
			case 1:	
				count = 5;
				//mode = GuiColor.RED + "ARROW";
				break;
				
			case 2:
				count = 12;
				//mode = GuiColor.RED + "BOX";
				break;
			
			case 3:
				count = 12;
				//mode = GuiColor.RED + "CROSS";
				break;
				
			case 4:
				count = machine.getCustomAnvils();
				//mode = GuiColor.RED + "CUSTOM";
				break;	
			}
			
			if (machine.getAnvils() >= count) {
				invalid = false;
			}
			if (count == 1){
				displayRequirement = "Requires " + count + " anvil.";
			}
			else
			displayRequirement = "Requires " + count + " anvils.";
			//displayType = mode + " MODE";
		}
		
		int color = invalid ? 0xD30000 : 0x404040;
		
		fontRendererObj.drawString(displayRequirement, 40, 112, color);
		//fontRendererObj.drawSplitString(displayRequirement, 40, 106, 100, color);
		//fontRendererObj.drawString(displayType, 30, 42, 0x0000D3);
		
		//hovering text
		//foreground for custom type(4) > (GuiTabCustom)
		activeTab.drawForeground(this, x, y);
		
		for (GuiTab tab : tabs) {
			tab.drawString(this, x, y, tab.getName());	
		}
	}
	
	private static final String ENABLE_TEXT = "Enable";
	private static final String DISABLE_TEXT = "Disable";
	
	@Override
	public void initGui() {
		super.initGui();
		
		buttonList.clear();
		
		GuiButton enableButton = new GuiButton(0, guiLeft + 85, guiTop + 16, 47, 20, machine.getBlockMetadata() % 2 == 0 ? DISABLE_TEXT : ENABLE_TEXT);
		buttonList.add(enableButton);
		
		GuiButton clearButton = new GuiButton(1, guiLeft + 133, guiTop + 16, 36, 20, I18n.format("gui.mm.machine.button.clear"));
		
		clearButton.enabled = machine.getBlockMetadata() / 2 != 0;
		
		buttonList.add(clearButton);
	}
	
	@Override
	protected void actionPerformed(GuiButton button) {
		
		//PacketHandler.sendInterfacePacket((byte)(0),(byte)button.id);
		
		if (button.id == 0) {
			
			button.displayString = button.displayString.equals(DISABLE_TEXT) ? ENABLE_TEXT : DISABLE_TEXT;
			
		}else if (button.id == 1){
			
			button.enabled = false;
		}
		
	}
	
	@Override
	protected void mouseClicked(int x, int y, int button) {
		super.mouseClicked(x, y, button);
		
		//dropping selection > (GuiTabCustom)
		activeTab.mouseClicked(this, x, y, button);
		
		//tabs
		
		for (GuiTab tab : tabs) {
			
			if (activeTab != tab) {
				
				if (tab.inRect(this, x, y)) {
					
					activeTab = tab;
					
					break;
				}
			}
		}
	}
	
	private boolean currentMode;
	
	@Override
	protected void mouseClickMove(int x, int y, int button, long timeSinceClicked) {
		super.mouseClickMove(x, y, button, timeSinceClicked);
		
		activeTab.mouseClickToMove(this, x, y, button, timeSinceClicked);
	}
	
	@Override
	public void mouseMovedOrUp(int x, int y, int button) {
		super.mouseMovedOrUp(x, y, button);
		
		activeTab.mouseReleased(this, x, y, button);
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
