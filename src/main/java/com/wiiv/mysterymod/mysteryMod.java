package com.wiiv.mysterymod;

import com.wiiv.mysterymod.client.handler.KeyInputHandler;
import com.wiiv.mysterymod.handler.ConfigurationHandler;
import com.wiiv.mysterymod.handler.DescriptionHandler;
import com.wiiv.mysterymod.handler.GenerationHandler;
import com.wiiv.mysterymod.handler.GuiHandler;
import com.wiiv.mysterymod.handler.NetworkHandler;
import com.wiiv.mysterymod.init.BlocksMMInit;
import com.wiiv.mysterymod.init.EntitiesMMInit;
import com.wiiv.mysterymod.init.ItemsMMInit;
import com.wiiv.mysterymod.init.RecipesMMInit;
import com.wiiv.mysterymod.init.TilesMMInit;
import com.wiiv.mysterymod.proxy.CommonProxy;
import com.wiiv.mysterymod.reference.CoreMM;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;



@Mod(modid = CoreMM.MOD_ID, name = CoreMM.NAME, version = CoreMM.VERSION, guiFactory = CoreMM.GUI_FACTORY_CLASS)

public class mysteryMod {
	
	@Mod.Instance(CoreMM.MOD_ID)
	public static mysteryMod instance;
	
	@SidedProxy(clientSide = CoreMM.CLIENT_PROXY_CLASS, serverSide = CoreMM.SERVER_PROXY_CLASS)
	public static CommonProxy proxy;
	

	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent event){
		
		//configuration, items, blocks
		ConfigurationHandler.init(event.getSuggestedConfigurationFile());
		FMLCommonHandler.instance().bus().register(new ConfigurationHandler());
		
		ItemsMMInit.init();
		BlocksMMInit.init();
		
		GameRegistry.registerWorldGenerator(new GenerationHandler(), 0);
		
		//network
		NetworkHandler.init();
		DescriptionHandler.init();
		
		proxy.initKeybindings();
		proxy.initRenders();
		
		//gui
		NetworkRegistry.INSTANCE.registerGuiHandler(CoreMM.MOD_ID, new GuiHandler());
	}
	
	@Mod.EventHandler
	public void init(FMLInitializationEvent event){
		
		//guis, tes, entities, recipes
		FMLCommonHandler.instance().bus().register(new KeyInputHandler());
		
		EntitiesMMInit.init();
		TilesMMInit.init();
		
		RecipesMMInit.init();
	}
	
	@Mod.EventHandler
	public void postInit(FMLPostInitializationEvent event){
		
		//after other mods
	}
}
