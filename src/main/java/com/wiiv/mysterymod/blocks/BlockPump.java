package com.wiiv.mysterymod.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import com.wiiv.mysterymod.reference.BlocksMM;
import com.wiiv.mysterymod.tabs.TabsMMGeneric;
import com.wiiv.mysterymod.tileentities.TileEntityPump;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockPump extends BlockTileEntityMMGeneric {
	
	public BlockPump() {
	
		super(Material.iron);
		
		setBlockName(BlocksMM.UNLOCALIZED_PUMP_NAME);
		setCreativeTab(TabsMMGeneric.tabBlocks);
		setHardness(2F);
		setStepSound(Block.soundTypeMetal);
		
		setBlockBounds(1.0F / 16.0F * 4.0F, 0.0F, 0.0F, 1.0F - (1.0F / 16.0F * 4.0F), 1.0F / 16.0F * 8.0F, 1.0F);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister register) {
	
		blockIcon = register.registerIcon(BlocksMM.TEXTURE_LOCATION + ":" + BlocksMM.ALEMBIC_TEXTURE);
	}
	
	@Override
	public TileEntity createNewTileEntity(World world, int i) {
	
		return new TileEntityPump();
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
