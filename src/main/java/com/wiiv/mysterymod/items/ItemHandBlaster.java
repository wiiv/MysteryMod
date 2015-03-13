package com.wiiv.mysterymod.items;

import com.wiiv.mysterymod.reference.ItemsMM;
import com.wiiv.mysterymod.tabs.TabsMMGeneric;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
//import example.tabs.TabsWIIV;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;

public class ItemHandBlaster extends ItemMMGeneric{

	public ItemHandBlaster() {
		super();
		setCreativeTab(TabsMMGeneric.tabMiscellaneous);
		setMaxStackSize(16);
		setUnlocalizedName(ItemsMM.UNLOCALIZED_HANDBLASTER_NAME);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister register) {
		itemIcon = register.registerIcon(ItemsMM.TEXTURE_LOCATION + ":" + ItemsMM.HANDBLASTER_ICON);
	}

}
