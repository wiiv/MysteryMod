package com.wiiv.mysterymod.client.gui;

import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.common.config.ConfigElement;
import net.minecraftforge.common.config.Configuration;

import com.wiiv.mysterymod.handler.ConfigurationHandler;
import com.wiiv.mysterymod.reference.Core;

import cpw.mods.fml.client.config.GuiConfig;

public class CoreGuiConfig extends GuiConfig{

	public CoreGuiConfig(GuiScreen parentScreen){
		
		super(parentScreen, 
				new ConfigElement(ConfigurationHandler.configuration.getCategory(Configuration.CATEGORY_GENERAL)).getChildElements(), 
				Core.MOD_ID, 
				false,
				false, 
				GuiConfig.getAbridgedConfigPath(ConfigurationHandler.configuration.toString()));
	}

}

