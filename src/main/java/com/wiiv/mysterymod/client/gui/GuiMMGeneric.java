package com.wiiv.mysterymod.client.gui;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.inventory.Container;


public abstract class GuiMMGeneric extends GuiContainer{

	public GuiMMGeneric(Container container) {
		super(container);

	}
	
	public void onTextfieldUpdate(int id){}

}
