package com.wiiv.mysterymod.handler;

import java.io.File;

import net.minecraftforge.common.config.Configuration;

import com.wiiv.mysterymod.reference.BlocksMM;
import com.wiiv.mysterymod.reference.CoreReferences;
import com.wiiv.mysterymod.reference.ItemsMM;

import cpw.mods.fml.client.event.ConfigChangedEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class ConfigurationHandler {
	
	public static Configuration configuration;
	public static boolean testValue = false;
	
	public static void init(File configFile){
	
		if (configuration == null){
			
			configuration = new Configuration(configFile);
			loadConfiguration();
		}
		
		//System.out.println("Configuration test:" + configValue);
	}
	
	@SubscribeEvent
	public void onConfigurationChangedEvent(ConfigChangedEvent.OnConfigChangedEvent event){
		
		if (event.modID.equalsIgnoreCase(CoreReferences.MOD_ID)){
			
			//resync config
		}
	}
	
	private static void loadConfiguration(){
		
		testValue = configuration.getBoolean("configValue", Configuration.CATEGORY_GENERAL, false, "something");
		
		if (configuration.hasChanged()){
			
			configuration.save();
		}
	}
}

