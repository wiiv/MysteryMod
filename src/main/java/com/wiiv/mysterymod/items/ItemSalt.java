package com.wiiv.mysterymod.items;

import java.util.List;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

import com.wiiv.mysterymod.reference.ItemsMM;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemSalt extends ItemMMGeneric {
	
	public ItemSalt() {
	
		super();
		
		setCreativeTab(CreativeTabs.tabFood);
		setMaxStackSize(64);
		setUnlocalizedName(ItemsMM.UNLOCALIZED_SALT_NAME);
		setHasSubtypes(true);
		setMaxDamage(0);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister register) {
	
		itemIcon = register.registerIcon(ItemsMM.TEXTURE_LOCATION + ":" + ItemsMM.SALT_ICON);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack itemstack, EntityPlayer player, List info, boolean useExtraInformation) {
		
		info.add("Use it for cooking.");
	}
}
