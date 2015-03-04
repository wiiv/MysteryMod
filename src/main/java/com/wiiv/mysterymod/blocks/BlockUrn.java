package com.wiiv.mysterymod.blocks;

import com.wiiv.mysterymod.reference.BlocksMM;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class BlockUrn extends BlockMMGeneric{

	protected BlockUrn(Material material) {
		
		super(material.glass);
		
		//setBlockName(BlocksMM.UNLOCALIZED_URN_NAME);
		setCreativeTab(CreativeTabs.tabDecorations);
		setHardness(1F);
		setStepSound(Block.soundTypeGlass);
	}

}
