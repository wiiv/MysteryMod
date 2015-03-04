package com.wiiv.mysterymod.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import com.wiiv.mysterymod.reference.BlocksMM;
import com.wiiv.mysterymod.tabs.TabsMMGeneric;
import com.wiiv.mysterymod.tileentities.TileEntityChandelier;

public class BlockChandelier extends BlockMMGeneric{

	public BlockChandelier() {
		super(Material.iron);
		
		setBlockName(BlocksMM.UNLOCALIZED_CHANDELIER_NAME);
		setCreativeTab(TabsMMGeneric.tabBlocks);
		setHardness(2F);
		setStepSound(Block.soundTypeMetal);
			
		setBlockBounds(0.0F, 1.0F / 16.0F*2.0F, 0.0F, 1.0F, 1.0F, 1.0F);
	}
	
	@Override
	public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_) {
		// TODO Auto-generated method stub
		return new TileEntityChandelier();
	}

	public int getRenderType() {
			
		return -1;
	}
		
	public boolean isOpaqueCube() {
			
		return false;
	}
		
	public boolean renderAsNormalBlock() {
			
		return false;
	}
		
	public TileEntity getBlockEntity() {
			
		return new TileEntityChandelier();
	}
}


