package com.wiiv.mysterymod.itemblocks;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;

import com.wiiv.mysterymod.init.BlocksMMInit;

public class ItemBlockMachine extends ItemBlock{
	
	public ItemBlockMachine(Block block) {
		
		super(BlocksMMInit.machine);
		setHasSubtypes(true);
	}
	
	@Override
	public int getMetadata(int dmg){
		return dmg;
	}
}
