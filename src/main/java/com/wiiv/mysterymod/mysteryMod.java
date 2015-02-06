package com.wiiv.mysterymod;

import com.wiiv.mysterymod.proxy.IProxy;
import com.wiiv.mysterymod.reference.References;

import config.ConfigHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;


@Mod(modid = References.MOD_ID, name = References.NAME, version = References.VERSION)

public class mysteryMod 
{
	@Mod.Instance(References.MOD_ID)
	public static mysteryMod instance;
	
	@SidedProxy(clientSide = "com.wiiv.mysterymod.proxy.ClientProxy", serverSide = "com.wiiv.mysterymod.proxy.ServerProxy")
	public static IProxy proxy;
	

	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
		//configuration, items, blocks
		ConfigHandler.init(event.getSuggestedConfigurationFile());
	}
	
	public void init(FMLInitializationEvent event)
	{
		//guis, tes, recipes
	}
	
	public void postInit(FMLPostInitializationEvent event)
	{
		//after other mods
	}
}