package com.wiiv.mysterymod.items;

import com.wiiv.mysterymod.reference.ItemsMM;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
//import example.tabs.TabsWIIV;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;

public class ItemHandBlaster extends ItemMMGeneric{

	public ItemHandBlaster() {
		super();
		//setCreativeTab(TabsWIIV.tabMiscellaneous);
		setMaxStackSize(16);
		setUnlocalizedName(ItemsMM.UNLOCALIZED_HANDBLASTER_NAME);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister register) {
		itemIcon = register.registerIcon(ItemsMM.TEXTURE_LOCATION + ":" + ItemsMM.HANDBLASTER_ICON);
	}

}
