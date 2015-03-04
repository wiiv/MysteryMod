package com.wiiv.mysterymod.tabs;

import com.wiiv.mysterymod.mysteryMod;
import com.wiiv.mysterymod.init.ItemsMMInit;
import com.wiiv.mysterymod.reference.TabsMM;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class TabMisc extends CreativeTabs{

	public TabMisc(int id, String name) {
		super(id, TabsMM.TABS_NAMES[2]);
	}
	
	@Override
	public Item getTabIconItem() {
		
		return ItemsMMInit.prism;
	}
}