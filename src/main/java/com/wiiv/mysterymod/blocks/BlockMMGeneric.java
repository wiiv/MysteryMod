package com.wiiv.mysterymod.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;

import com.wiiv.mysterymod.reference.CoreMM;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockMMGeneric extends Block{
	
	protected BlockMMGeneric(Material material) {
	
		super(material.rock);
	}
	
	@Override
	public String getUnlocalizedName() {
	
		return String.format("tile.%s%s", CoreMM.MOD_ID.toLowerCase() + ":", getUnwrappedUnlocalizedName(super.getUnlocalizedName()));
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister iconRegister) {
	
		blockIcon = iconRegister.registerIcon(this.getUnlocalizedName().substring(this.getUnlocalizedName().indexOf(".") + 1));
	}
	
	protected String getUnwrappedUnlocalizedName(String unlocalizedName) {
	
		return unlocalizedName.substring(unlocalizedName.indexOf(".") + 1);
	}
}
