package com.wiiv.mysterymod.tabs;

import com.wiiv.mysterymod.init.ItemsMMInit;
import com.wiiv.mysterymod.reference.TabsMM;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class TabItems extends CreativeTabs{

	public TabItems(int id, String name) {
		super(id, TabsMM.TABS_NAMES[0]);
	}
	
	@Override
	public Item getTabIconItem() {
		
		return ItemsMMInit.prism;
	}
	
}
