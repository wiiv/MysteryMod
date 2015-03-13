package com.wiiv.mysterymod.proxy;

import net.minecraft.entity.player.EntityPlayer;

public abstract class CommonProxy {

	public void initRenders(){
		
	}
	
	public void initKeybindings() {

	}
	
	public abstract EntityPlayer getClientPlayer();
}
