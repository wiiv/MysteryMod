package com.wiiv.mysterymod.init;

import com.wiiv.mysterymod.items.ItemCard;
import com.wiiv.mysterymod.items.ItemDeathstone;
import com.wiiv.mysterymod.items.ItemDroid;
import com.wiiv.mysterymod.items.ItemHandBlaster;
import com.wiiv.mysterymod.items.ItemMMGeneric;
import com.wiiv.mysterymod.items.ItemPrism;
import com.wiiv.mysterymod.items.ItemWand;
import com.wiiv.mysterymod.reference.ItemsMM;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class ItemsMMInit {

	public static ItemMMGeneric wand = new ItemWand();
	public static ItemMMGeneric card = new ItemCard();
	public static ItemMMGeneric deathstone = new ItemDeathstone();
	public static ItemMMGeneric prism = new ItemPrism();
	public static ItemMMGeneric droid = new ItemDroid();
	public static ItemMMGeneric handblaster = new ItemHandBlaster();
	
	public static void init(){

		GameRegistry.registerItem(wand, ItemsMM.WAND_NAME);
		
		/*for (int i = 0; i < ItemsMM.CARD_NAMES.length; i++){
			GameRegistry.registerItem(new ItemStack(card, 1, i), ItemsMM.CARD_NAMES[i]);
		}*/
		
		GameRegistry.registerItem(prism, ItemsMM.PRISM_NAME);
	}
	
	public static void addNames(){
		/*LanguageRegistry.addName(wand, ItemsMM.WAND_NAME);
		
		for (int i = 0; i < ItemsMM.CARD_NAMES.length; i++){
			LanguageRegistry.addName(new ItemStack(card, 1, i), ItemsMM.CARD_NAMES[i]);
		}
		
		for (int i = 0; i < ItemsMM.DEATHSTONE_NAMES.length; i++){
			LanguageRegistry.addName(new ItemStack(deathstone, 1, i), ItemsMM.DEATHSTONE_NAMES[i]);
		}*/
		
		//LanguageRegistry.addName(prism, ItemsMM.PRISM_NAME);
		
		
		/*LanguageRegistry.addName(droid, ItemsMM.DROID_NAME);
		
		LanguageRegistry.addName(handblaster, ItemsMM.HANDBLASTER_NAME);*/
	}

	/*public static void registerRecipes(){
		GameRegistry.addRecipe(new ItemStack(wand),
				new Object[]{"  G", 
						     " / ", 
						     "/  ", 
						     'G', Item.goldenCarrot, 
						     '/', Item.stick}
		);
		
		for (int i = 0; i < ItemsMM.DEATHSTONE_NAMES.length; i++){
			ItemStack current = new ItemStack(deathstone, 1, i);
			ItemStack next = new ItemStack(deathstone, 1, (i + 1) %
			ItemsMM.DEATHSTONE_NAMES.length);
			
			GameRegistry.addRecipe(next, "S", 'S', current);
			}
		
		GameRegistry.addRecipe(new ItemStack(wand),
				new Object[]{" P ", 
						     "PPP",  
						     'P', Block.thinGlass}
		);
	}*/
}
