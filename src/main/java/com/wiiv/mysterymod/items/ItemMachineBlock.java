package com.wiiv.mysterymod.items;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;

public class ItemMachineBlock extends ItemBlock{
	public ItemMachineBlock(Block id) {
		super(id);
		setHasSubtypes(true);
	}
	
	@Override
	public int getMetadata(int dmg){
		return dmg;
	}
}
