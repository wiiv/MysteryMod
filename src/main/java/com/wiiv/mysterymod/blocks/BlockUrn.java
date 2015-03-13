package com.wiiv.mysterymod.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

import com.wiiv.mysterymod.reference.BlocksMM;

public class BlockUrn extends BlockTileEntityMMGeneric {
	
	public BlockUrn() {
	
		super(Material.glass);
		
		setBlockName(BlocksMM.UNLOCALIZED_URN_NAME);
		setCreativeTab(CreativeTabs.tabDecorations);
		setHardness(1F);
		setStepSound(Block.soundTypeGlass);
	}
}
