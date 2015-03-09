package com.wiiv.mysterymod.init;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

import com.wiiv.mysterymod.reference.ItemsMM;

import cpw.mods.fml.common.registry.GameRegistry;

public class RecipesMMInit{
	
	public static void init(){
		
		//wand
		GameRegistry.addRecipe(new ItemStack(ItemsMMInit.wand),
				new Object[]{"  G", 
						     " / ", 
						     "/  ", 
						     'G', Items.golden_carrot, 
						     '/', Items.stick}
				);
		
		for (int i = 0; i < ItemsMM.UNLOCALIZED_DEATHSTONE_NAMES.length; i++){
			ItemStack current = new ItemStack(ItemsMMInit.deathstone, 1, i);
			ItemStack next = new ItemStack(ItemsMMInit.deathstone, 1, (i + 1) %
			ItemsMM.UNLOCALIZED_DEATHSTONE_NAMES.length);
			
			GameRegistry.addRecipe(next, "S", 'S', current);
			}
		
		//prism
		GameRegistry.addRecipe(new ItemStack(ItemsMMInit.prism),
				new Object[]{" P ", 
						     "PPP",  
						     'P', Blocks.glass_pane}
				);
		
		//saltblock
		GameRegistry.addRecipe(new ItemStack(BlocksMMInit.rocksalt),
				new Object[]{"sss", 
						     "sss", 
						     "sss", 
						     's', ItemsMMInit.salt 
						     }
				);
	}
}
