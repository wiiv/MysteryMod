package com.wiiv.mysterymod.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;

import com.wiiv.mysterymod.reference.BlocksMM;
import com.wiiv.mysterymod.tabs.TabsMMGeneric;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockSalt extends BlockMMGeneric {
	
	public BlockSalt() {
	
		super(Material.sand);
		
		setBlockName(BlocksMM.UNLOCALIZED_SALT_NAME);
		setCreativeTab(TabsMMGeneric.tabBlocks);
		setHardness(2F);
		setStepSound(Block.soundTypeGravel);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister register) {
	
		blockIcon = register.registerIcon(BlocksMM.TEXTURE_LOCATION + ":" + BlocksMM.SALT_TEXTURE);
	}
}