package com.wiiv.mysterymod.client.handler;

import com.wiiv.mysterymod.reference.KeysMM;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.InputEvent;


public class KeyInputHandler{
	
	private KeysMM getPressedKey(){
		
		for(KeysMM keybind : KeysMM.values()){
			if(keybind.isPressed()){
				return keybind;
			}
		}
		return null;
	}
	
	@SubscribeEvent
	public void handleKeyInputEvent(InputEvent.KeyInputEvent event){
		
		KeysMM keybind = getPressedKey();
		
		if(keybind != null){
			switch(keybind){
				case CHARGE:
					//Log.info("CHARGE");
					break;
				case RELEASE:
					//Log.info("RELEASE");
					break;
				case EXPLODE:
					//Log.info("BOOM!");
					break;
			}
		}
		
	}
}
