package com.wiiv.mysterymod.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;

import com.wiiv.mysterymod.reference.BlocksMM;
import com.wiiv.mysterymod.tileentities.TileEntityRotational;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockRotational extends BlockMMGeneric {
	
	public BlockRotational() {
	
		super(Material.rock);
		
		setCreativeTab(CreativeTabs.tabDecorations);
		setHardness(2F);
		setStepSound(Block.soundTypeStone);
	}
	
	@SideOnly(Side.CLIENT)
	private IIcon[] rotationalIcons;
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister register) {
	
		rotationalIcons = new IIcon[BlocksMM.ROTATIONAL_SIDES.length];
		for (int i = 0; i < rotationalIcons.length; i++) {
			rotationalIcons[i] = register.registerIcon(BlocksMM.TEXTURE_LOCATION + ":" + BlocksMM.ROTATIONAL_TEXTURE + BlocksMM.ROTATIONAL_SIDES[i]);
		}
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int side, int meta) {
	
		if (side == 1) {
			return rotationalIcons[1];
		}
		else if (side == 2) {
			return rotationalIcons[2];
		}
		else if (side == 3) {
			return rotationalIcons[3];
		}
		else if (side == 4) {
			return rotationalIcons[4];
		}
		else if (side == 5) {
			return rotationalIcons[5];
		}
		else return rotationalIcons[0];
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer entityplayer, int l, float hitX, float hitY, float hitZ) {
	
		world.playSoundAtEntity(entityplayer, "random.click", 0.3F, 0.1F);
		
		TileEntity te = world.getTileEntity(x, y, z);
		
		int facing = world.getBlockMetadata(x, y, z);
		
		if (facing < 6) {
			
			world.setBlockMetadataWithNotify(x, y, z, facing + 1, 3);
			
		}else if (facing == 6) {
			
			world.setBlockMetadataWithNotify(x, y, z, 0, 3);
		}
		
		return true;
	}
	
	@Override
	public boolean rotateBlock(World world, int x, int y, int z, ForgeDirection axis) {
	
		TileEntity rotational = world.getTileEntity(x, y, z);
		
		if (rotational instanceof TileEntityRotational) {
			return ((TileEntityRotational) rotational).switchOrientation(false);
		}
		else {
			return false;
		}
	}
	
	public TileEntity createNewTileEntity(World world) {
	
		return new TileEntityRotational();
	}
	
}
