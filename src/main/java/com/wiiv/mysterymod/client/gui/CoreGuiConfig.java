package com.wiiv.mysterymod.client.gui;

import java.util.List;

import com.wiiv.mysterymod.handler.ConfigurationHandler;
import com.wiiv.mysterymod.reference.CoreReferences;

import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.common.config.ConfigElement;
import net.minecraftforge.common.config.Configuration;
import cpw.mods.fml.client.config.GuiConfig;
import cpw.mods.fml.client.config.IConfigElement;

public class CoreGuiConfig extends GuiConfig{

	public CoreGuiConfig(GuiScreen parentScreen){
		
		super(parentScreen, 
				new ConfigElement(ConfigurationHandler.configuration.getCategory(Configuration.CATEGORY_GENERAL)).getChildElements(), CoreReferences.MOD_ID, 
				false,
				false, 
				GuiConfig.getAbridgedConfigPath(ConfigurationHandler.configuration.toString()));
	}

}
