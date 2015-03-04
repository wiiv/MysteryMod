package com.wiiv.mysterymod.client.gui;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class GuiTabCustom extends GuiTab {

	@SideOnly(Side.CLIENT)
	public GuiTabCustom(int id) {
		super(GuiColor.RED + "custom layout".toUpperCase(), id);
	}
	
	 @Override
	 public void drawBackground(GuiMachine gui, int x, int y) {
		 
		 int meta = gui.machine.getWorldObj().getBlockMetadata(gui.machine.xCoord, gui.machine.yCoord, gui.machine.zCoord);
		 int type =  meta / 2;
		 
		 if (type == 4) {
				
				for (int i = 0;  i < GuiMachine.rectangles.length; i++) {
					
					GuiRectangle rect = GuiMachine.rectangles[i];
					
					int srcX = 176;
					
					if (rect.inRect(gui, x, y)) {
						srcX += 8;
					}	
					
					rect.draw(gui, srcX, 24);
					
					if (gui.machine.customSetup[i]) {
						rect.draw(gui, 176, 32);
					}
				}
			}
	 }
	 
	 @Override
	 public void drawForeground(GuiMachine gui, int x, int y) {
		
		 gui.getFontRenderer().drawString(GuiColor.RED + "custom layout".toUpperCase(), 30, 43, 0x404040);
		 
		 int meta = gui.machine.getWorldObj().getBlockMetadata(gui.machine.xCoord, gui.machine.yCoord, gui.machine.zCoord);
		 int type =  meta / 2;
		 
		 if (type == 4) {
				
			for (int i = 0; i < GuiMachine.rectangles.length; i++) {

				GuiRectangle rect = GuiMachine.rectangles[i];
					
				String text;
				
				if (gui.machine.customSetup[i]) {
						
					text = GuiColor.RED + "Active";
				}else {
					text = GuiColor.GREY + "Inactive";
				}
				text += "\n" + GuiColor.WHITE + "Click to change";
				rect.drawString(gui, x, y, text);
			}
		 }
		 
	 }
	 
	 private boolean currentMode;
	 
	 public void mouseClicked(GuiMachine gui, int x, int y, int button) {
			
		//dropping selection
		
		for (int i = 0; i < GuiMachine.rectangles.length; i++) {
			
			GuiRectangle rect = GuiMachine.rectangles[i];
			
			if (rect.inRect(gui, x, y)) {
				
				//PacketHandler.sendInterfacePacket((byte)(1),(byte)(i));
				currentMode = gui.machine.customSetup[i];
				gui.machine.setCustomAnvil(i, !currentMode);
				
				break;
			}
		}
	 }
	 
	 public void mouseClickMove(GuiMachine gui, int x, int y, int button, long timeSinceClicked) {


			for (int i = 0; i < GuiMachine.rectangles.length; i++) {
				
				GuiRectangle rect = GuiMachine.rectangles[i];
				
				if (gui.machine.customSetup[i] == currentMode && rect.inRect(gui, x, y)) {
					
					//PacketHandler.sendInterfacePacket((byte)(1),(byte)(i));
					
					gui.machine.setCustomAnvil(i, !currentMode);
					
					break;
				}
			}
		}
}
