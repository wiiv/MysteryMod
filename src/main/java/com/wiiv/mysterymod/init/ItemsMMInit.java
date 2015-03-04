package com.wiiv.mysterymod.init;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

import com.wiiv.mysterymod.items.ItemCard;
import com.wiiv.mysterymod.items.ItemDeathstone;
import com.wiiv.mysterymod.items.ItemDroid;
import com.wiiv.mysterymod.items.ItemHandBlaster;
import com.wiiv.mysterymod.items.ItemMMGeneric;
import com.wiiv.mysterymod.items.ItemPrism;
import com.wiiv.mysterymod.items.ItemWand;
import com.wiiv.mysterymod.reference.ItemsMM;

import cpw.mods.fml.common.registry.GameRegistry;

public class ItemsMMInit {

	public static ItemMMGeneric wand = new ItemWand();
	public static ItemMMGeneric card = new ItemCard();
	public static ItemMMGeneric deathstone = new ItemDeathstone();
	public static ItemMMGeneric prism = new ItemPrism();
	public static ItemMMGeneric droid = new ItemDroid();
	public static ItemMMGeneric handblaster = new ItemHandBlaster();
	
	public static void init(){

		GameRegistry.registerItem(wand, ItemsMM.UNLOCALIZED_WAND_NAME);
		GameRegistry.registerItem(card, ItemsMM.UNLOCALIZED_CARD_NAME);
		GameRegistry.registerItem(deathstone, ItemsMM.UNLOCALIZED_DEATHSTONE_NAME);
		GameRegistry.registerItem(prism, ItemsMM.UNLOCALIZED_PRISM_NAME);
		GameRegistry.registerItem(droid, ItemsMM.UNLOCALIZED_DROID_NAME);
		GameRegistry.registerItem(handblaster, ItemsMM.UNLOCALIZED_HANDBLASTER_NAME);
	}
}
