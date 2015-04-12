package com.wiiv.mysterymod.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;

import com.wiiv.mysterymod.reference.BlocksMM;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockUrn extends BlockTileEntityMMGeneric {
	
	public BlockUrn() {
	
		super(Material.glass);
		
		setBlockName(BlocksMM.UNLOCALIZED_URN_NAME);
		setCreativeTab(CreativeTabs.tabDecorations);
		setHardness(1F);
		setStepSound(Block.soundTypeGlass);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister register) {
	
		blockIcon = register.registerIcon(BlocksMM.TEXTURE_LOCATION + ":" + BlocksMM.URN_TEXTURE);
	}
}
