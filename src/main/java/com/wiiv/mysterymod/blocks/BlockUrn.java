package com.wiiv.mysterymod.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import com.wiiv.mysterymod.reference.BlocksMM;
import com.wiiv.mysterymod.tabs.TabsMMGeneric;
import com.wiiv.mysterymod.tileentities.TileEntityUrn;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockUrn extends BlockTileEntityMMGeneric {
	
	public BlockUrn() {
	
		super(Material.glass);
		
		setBlockName(BlocksMM.UNLOCALIZED_URN_NAME);
		setCreativeTab(TabsMMGeneric.tabBlocks);
		setHardness(1F);
		setStepSound(Block.soundTypeGlass);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister register) {
	
		blockIcon = register.registerIcon(BlocksMM.TEXTURE_LOCATION + ":" + BlocksMM.URN_TEXTURE);
	}
	
	@Override
	public TileEntity createNewTileEntity(World world, int i) {
	
		return new TileEntityUrn();
	}
	
	@Override
	public int getRenderType() {
	
		return -1;
	}
	
	@Override
	public boolean isOpaqueCube() {
	
		return false;
	}
	
	@Override
	public boolean renderAsNormalBlock() {
	
		return false;
	}
}
