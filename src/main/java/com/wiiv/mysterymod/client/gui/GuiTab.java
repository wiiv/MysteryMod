package com.wiiv.mysterymod.client.gui;

public abstract class GuiTab extends GuiRectangle{

	private String name;

	public GuiTab(String name, int id) {
		super(8, 38 + id * 16, 18, 16);
		
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public abstract void drawBackground(GuiMachine gui, int x, int y);
	public abstract void drawForeground(GuiMachine gui, int x, int y);
	
	public void mouseClicked(GuiMachine gui, int x, int y, int button) {}
	public void mouseClickToMove(GuiMachine gui, int x, int y, int button, long timeSinceClicked) {}
	public void mouseReleased(GuiMachine gui, int x, int y, int button) {}
}
