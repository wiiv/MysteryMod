package com.wiiv.mysterymod.items;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;

public class ItemMachine extends ItemBlock{
	public ItemMachine(Block id) {
		super(id);
		setHasSubtypes(true);
	}
	
	@Override
	public int getMetadata(int dmg){
		return dmg;
	}
}
