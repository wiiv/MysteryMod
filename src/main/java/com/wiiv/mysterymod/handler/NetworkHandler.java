package com.wiiv.mysterymod.handler;

import com.wiiv.mysterymod.network.MessageExplode;
import com.wiiv.mysterymod.reference.CoreMM;

import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import cpw.mods.fml.relauncher.Side;


public class NetworkHandler {
	
	private static SimpleNetworkWrapper INSTANCE;
	
	public static void init(){
		
		 INSTANCE = NetworkRegistry.INSTANCE.newSimpleChannel(CoreMM.CHANNEL);
		 
		 INSTANCE.registerMessage(MessageExplode.class, MessageExplode.class, 0, Side.SERVER);
	}
	
	public static void sendToServer(IMessage message){
		
		INSTANCE.sendToServer(message);
	}
	
}
