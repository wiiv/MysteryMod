package com.wiiv.mysterymod.init;

import com.wiiv.mysterymod.item.ItemCard;
import com.wiiv.mysterymod.item.ItemDeathstone;
import com.wiiv.mysterymod.item.ItemDroid;
import com.wiiv.mysterymod.item.ItemHandBlaster;
import com.wiiv.mysterymod.item.ItemMMGeneric;
import com.wiiv.mysterymod.item.ItemPrism;
import com.wiiv.mysterymod.item.ItemSalt;
import com.wiiv.mysterymod.item.ItemWand;
import com.wiiv.mysterymod.reference.ItemsMM;

import cpw.mods.fml.common.registry.GameRegistry;

public class ItemsMMInit {

	public static ItemMMGeneric wand = new ItemWand();
	public static ItemMMGeneric card = new ItemCard();
	public static ItemMMGeneric deathstone = new ItemDeathstone();
	public static ItemMMGeneric prism = new ItemPrism();
	public static ItemMMGeneric droid = new ItemDroid();
	public static ItemMMGeneric handblaster = new ItemHandBlaster();
	public static ItemMMGeneric salt = new ItemSalt();
	
	public static void init(){

		GameRegistry.registerItem(wand, ItemsMM.UNLOCALIZED_WAND_NAME);
		GameRegistry.registerItem(card, ItemsMM.UNLOCALIZED_CARD_NAME);
		GameRegistry.registerItem(deathstone, ItemsMM.UNLOCALIZED_DEATHSTONE_NAME);
		GameRegistry.registerItem(prism, ItemsMM.UNLOCALIZED_PRISM_NAME);
		GameRegistry.registerItem(droid, ItemsMM.UNLOCALIZED_DROID_NAME);
		GameRegistry.registerItem(handblaster, ItemsMM.UNLOCALIZED_HANDBLASTER_NAME);
		GameRegistry.registerItem(salt, ItemsMM.UNLOCALIZED_SALT_NAME);
	}
}
