package com.wiiv.mysterymod.reference;

import net.minecraft.client.settings.KeyBinding;

import org.lwjgl.input.Keyboard;

public enum KeysMM{
	
	CHARGE("key.mystery.charge", Keyboard.KEY_C),
	RELEASE("key.mystery.release", Keyboard.KEY_R),
	EXPLODE("key.mystery.explode", Keyboard.KEY_B);
	
	private final KeyBinding keybind;
	
	private KeysMM(String keyBName, int defaultKeyCode){
		
		keybind = new KeyBinding(keyBName, defaultKeyCode, "key.mystery.category");
	}
	
	public KeyBinding getKeyBind(){
		return keybind;
	}
	
	public boolean isPressed(){
		return keybind.isPressed();
	}
}
