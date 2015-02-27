package com.wiiv.mysterymod;

import com.wiiv.mysterymod.handler.ConfigurationHandler;
import com.wiiv.mysterymod.init.ItemsMMInit;
import com.wiiv.mysterymod.proxy.IProxy;
import com.wiiv.mysterymod.reference.CoreReferences;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;



@Mod(modid = CoreReferences.MOD_ID, name = CoreReferences.NAME, version = CoreReferences.VERSION, guiFactory = CoreReferences.GUI_FACTORY_CLASS)

public class mysteryMod {
	
	@Mod.Instance(CoreReferences.MOD_ID)
	public static mysteryMod instance;
	
	@SidedProxy(clientSide = CoreReferences.CLIENT_PROXY_CLASS, serverSide = CoreReferences.SERVER_PROXY_CLASS)
	public static IProxy proxy;
	

	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent event){
		
		//configuration, items, blocks
		ConfigurationHandler.init(event.getSuggestedConfigurationFile());
		FMLCommonHandler.instance().bus().register(new ConfigurationHandler());
		
		ItemsMMInit.init();
	}
	
	public void init(FMLInitializationEvent event){
		
		//guis, tes, recipes
	}
	
	public void postInit(FMLPostInitializationEvent event){
		
		//after other mods
	}
}
