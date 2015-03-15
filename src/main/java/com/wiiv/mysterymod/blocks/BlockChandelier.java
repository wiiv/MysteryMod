package com.wiiv.mysterymod.blocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import com.wiiv.mysterymod.reference.BlocksMM;
import com.wiiv.mysterymod.tabs.TabsMMGeneric;
import com.wiiv.mysterymod.tileentities.TileEntityChandelier;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockChandelier extends BlockTileEntityMMGeneric {
	
	public BlockChandelier() {
	
		super(Material.iron);
		
		setBlockName(BlocksMM.UNLOCALIZED_CHANDELIER_NAME);
		setCreativeTab(TabsMMGeneric.tabBlocks);
		setHardness(1.0F);
		setStepSound(Block.soundTypeGlass);
		setLightLevel(1.0F);
		setBlockBounds(0.0F, 1.0F / 16.0F * 2.0F, 0.0F, 1.0F, 1.0F, 1.0F);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister register) {
	
		blockIcon = register.registerIcon(BlocksMM.TEXTURE_LOCATION + ":" + BlocksMM.CHANDELIER_TEXTURE);
	}
	
	@Override
	public TileEntity createNewTileEntity(World world, int id) {
	
		return new TileEntityChandelier();
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
	
	 @Override
	@SideOnly(Side.CLIENT)
	    public void randomDisplayTick(World world, int x, int y, int z, Random rand) {
		 
	        int l = world.getBlockMetadata(x, y, z);
	        
	        double d0 = x + 0.5F;
	        double d1 = y + 0.3F;
	        double d2 = z + 0.5F;
	        double d3 = 0.31250F;
	        double d4 = 0.37500F;

	            //world.spawnParticle("smoke", d0 - d4, d1 + d3, d2, 0.0D, 0.0D, 0.0D);
	            world.spawnParticle("flame", d0 - d4, d1 + d3, d2, 0.0D, 0.0D, 0.0D);

	        	//world.spawnParticle("smoke", d0 + d4, d1 + d3, d2, 0.0D, 0.0D, 0.0D);
	        	world.spawnParticle("flame", d0 + d4, d1 + d3, d2, 0.0D, 0.0D, 0.0D);

	        	//world.spawnParticle("smoke", d0, d1 + d3, d2 - d4, 0.0D, 0.0D, 0.0D);
	        	world.spawnParticle("flame", d0, d1 + d3, d2 - d4, 0.0D, 0.0D, 0.0D);

	        	//world.spawnParticle("smoke", d0, d1 + d3, d2 + d4, 0.0D, 0.0D, 0.0D);
	        	world.spawnParticle("flame", d0, d1 + d3, d2 + d4, 0.0D, 0.0D, 0.0D);
	    }
	
	public TileEntity getBlockEntity() {
	
		return new TileEntityChandelier();
	}
}
