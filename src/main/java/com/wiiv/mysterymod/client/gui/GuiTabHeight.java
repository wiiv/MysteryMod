package com.wiiv.mysterymod.client.gui;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class GuiTabHeight extends GuiTab {

	@SideOnly(Side.CLIENT)
	public GuiTabHeight(int id) {
		super(GuiColor.WHITE + "height setting".toUpperCase(), id);
	}
	
	private static int xBarSPos = 30;
	private static int xSliderSPos = xBarSPos - 3;
	
	public static final GuiRectangle bar = new GuiRectangle(xBarSPos, 60, 82, 6);
	public static final GuiRectangle slider = new GuiRectangle(xSliderSPos, 58, 7, 10);
	
	private int tempHeightSetting;
	private boolean isDragging;
	
	@Override
	public void drawBackground(GuiMachine gui, int x, int y) {

		bar.draw(gui, 0, 250);
		
		updateSliderPosition(gui);
		slider.draw(gui, 0, 240);
	}

	@Override
	public void drawForeground(GuiMachine gui, int x, int y) {
		
		gui.getFontRenderer().drawString(GuiColor.WHITE + "height setting".toUpperCase(), 30, 43, 0x404040);
		gui.getFontRenderer().drawString("height: +".toUpperCase() + getCurrentHeight(gui), 30, 89, 0x404040);
	}
	
	@Override
	public void mouseClicked(GuiMachine gui, int x, int y, int button) {
		
		updateSliderPosition(gui);
		
		if(slider.inRect(gui, x, y)) {
			
			isDragging = true;
			tempHeightSetting = gui.machine.heightSetting;
		}
	}
	
	@Override
	public void mouseClickToMove(GuiMachine gui, int x, int y, int button, long timeSinceClicked) {
		
		if (isDragging) {
			
			tempHeightSetting = x - gui.getLeft() - xBarSPos;
			
			if(tempHeightSetting < 1) {
				
				tempHeightSetting = 1;
				
			}else if (tempHeightSetting > 80) {
				
				tempHeightSetting = 80;
			}
		}
	}
	
	@Override
	public void mouseReleased(GuiMachine gui, int x, int y, int button) {
		
		if (isDragging) {
			
			//PacketHandler.sendInterfacePacket((byte)(2), (byte)(tempHeightSetting));
			gui.machine.heightSetting = tempHeightSetting;
			
			isDragging = false;
		}
	}
	
	private void updateSliderPosition(GuiMachine gui) {
		
		slider.setX(xSliderSPos + getCurrentHeight(gui));
	}
	
	private int getCurrentHeight(GuiMachine gui) {
		
		return (isDragging ? tempHeightSetting : gui.machine.heightSetting);
	}
}
