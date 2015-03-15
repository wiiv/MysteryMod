package com.wiiv.mysterymod.itemblocks;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;

import com.wiiv.mysterymod.init.BlocksMMInit;

public class ItemBlockRainbow extends ItemBlock{
	
	public ItemBlockRainbow(Block block) {
		
		super(BlocksMMInit.rainbow);
		setHasSubtypes(true);
	}
	
	@Override
	public int getMetadata(int dmg){
		return dmg;
	}
}
