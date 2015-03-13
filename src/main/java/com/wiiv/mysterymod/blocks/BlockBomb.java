package com.wiiv.mysterymod.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

import com.wiiv.mysterymod.reference.BlocksMM;
import com.wiiv.mysterymod.tabs.TabsMMGeneric;
import com.wiiv.mysterymod.tileentities.TileEntityBomb;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockBomb extends BlockTileEntityMMGeneric {
	
	public BlockBomb() {
	
		super(Material.iron);
		
		setBlockName(BlocksMM.UNLOCALIZED_BOMB_NAME);
		setCreativeTab(TabsMMGeneric.tabBlocks);
		setHardness(2F);
		setStepSound(Block.soundTypeMetal);
	}
	
	@SideOnly(Side.CLIENT)
	private IIcon[] activestateIcons;
	
	@SideOnly(Side.CLIENT)
	private IIcon idleIcon;
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister register) {
	
		blockIcon = register.registerIcon(BlocksMM.TEXTURE_LOCATION + ":" + BlocksMM.BOMB_TEXTURE + BlocksMM.BOMB_TEXTURE_STATES[0]);
		activestateIcons = new IIcon[BlocksMM.BOMB_TEXTURE_ACTIVE_STAGES.length];
		for (int i = 0; i < activestateIcons.length; i++) {
			activestateIcons[i] = register.registerIcon(BlocksMM.TEXTURE_LOCATION + ":" + BlocksMM.BOMB_TEXTURE + BlocksMM.BOMB_TEXTURE_STATES[1] + BlocksMM.BOMB_TEXTURE_ACTIVE_STAGES[i]);
		}
		idleIcon = register.registerIcon(BlocksMM.TEXTURE_LOCATION + ":"
				+ BlocksMM.BOMB_TEXTURE + BlocksMM.BOMB_TEXTURE_STATES[0]);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int side, int meta) {
	
		if (meta == 1) {
			return activestateIcons[0];
		}
		else if (meta == 2) {
			return activestateIcons[1];
		}
		else if (meta == 3) {
			return activestateIcons[2];
		}
		else return blockIcon;
	}
	
	@Override
	public TileEntity createNewTileEntity(World world, int meta) {
	
		return new TileEntityBomb();
	}
	
}
