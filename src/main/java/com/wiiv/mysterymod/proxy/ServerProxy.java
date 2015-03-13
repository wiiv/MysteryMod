package com.wiiv.mysterymod.proxy;

import net.minecraft.entity.player.EntityPlayer;

public class ServerProxy extends CommonProxy{

	@Override
	public void initKeybindings() {
		//NOOP
	}

	@Override
	public EntityPlayer getClientPlayer() {

		return null;
	}
}
