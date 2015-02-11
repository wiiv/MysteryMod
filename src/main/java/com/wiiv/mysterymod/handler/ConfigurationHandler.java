package com.wiiv.mysterymod.handler;

import java.io.File;

import net.minecraftforge.common.config.Configuration;

import com.wiiv.mysterymod.reference.Blocks;
import com.wiiv.mysterymod.reference.CoreReferences;
import com.wiiv.mysterymod.reference.Items;

import cpw.mods.fml.client.event.ConfigChangedEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class ConfigurationHandler {
	
	public static Configuration configuration;
	public static boolean testValue;
	
	public static void init(File configFile){
	
		configuration = new Configuration(configFile);
		boolean configValue = false;
		
		try{
			
			configuration.load();
			
			configValue = configuration.get("Lock"/*Configuration.CATEGORY_GENERAL*/, "configValue", true, "ex config value").getBoolean(true);
		}
		
		catch(Exception e){
			
		}
		
		finally{
			
			if (configuration.hasChanged()){
				
				configuration.save();
			}
	}
		
		//System.out.println("Configuration test:" + configValue);
	}
	
	@SubscribeEvent
	public void onConfigurationChangedEvent(ConfigChangedEvent.OnConfigChangedEvent event){
		
	}
}

