package com.wiiv.mysterymod.items;

import java.util.List;

import com.wiiv.mysterymod.reference.BlocksMM;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;


public class ItemRainbow extends ItemBlock{
	public ItemRainbow(Block id) {
		super(id);
		setHasSubtypes(true);
	}
	
	@Override
	public int getMetadata(int dmg){
		return dmg;
	}
	
	@Override
	public String getUnlocalizedName(ItemStack stack) {
	return BlocksMM.UNLOCALIZED_RAINBOW_NAME + stack.getItemDamage() / 2;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean extraInfo) {
		if (stack.getItemDamage() % 2 == 1) {
			list.add("FADING");
		}
	}
}
