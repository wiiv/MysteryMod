package com.wiiv.mysterymod.tabs;

import com.wiiv.mysterymod.init.BlocksMMInit;
import com.wiiv.mysterymod.init.ItemsMMInit;
import com.wiiv.mysterymod.reference.TabsMM;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class TabBlocks extends CreativeTabs{

	public TabBlocks(int id, String name) {
		super(id, TabsMM.TABS_NAMES[1]);
	}

	@Override
	public Item getTabIconItem() {
		// TODO Auto-generated method stub
		return Item.getItemFromBlock(BlocksMMInit.bomb);
	}
	
}