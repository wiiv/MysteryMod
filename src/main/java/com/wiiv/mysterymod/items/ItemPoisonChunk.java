package com.wiiv.mysterymod.items;

import java.util.List;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

import com.wiiv.mysterymod.reference.ItemsMM;
import com.wiiv.mysterymod.tabs.TabsMMGeneric;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemPoisonChunk extends ItemMMGeneric {
	
	public ItemPoisonChunk() {
	
		super();
		
		setCreativeTab(TabsMMGeneric.tabItems);
		setMaxStackSize(64);
		setUnlocalizedName(ItemsMM.UNLOCALIZED_POISONCHUNK_NAME);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister register) {
	
		itemIcon = register.registerIcon(ItemsMM.TEXTURE_LOCATION + ":" + ItemsMM.POISONCHUNK_ICON);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack itemstack, EntityPlayer player, List info, boolean useExtraInformation) {
		
		info.add("Use it for brewing.");
	}
}
