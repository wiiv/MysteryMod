package com.wiiv.mysterymod.tabs;

import com.wiiv.mysterymod.reference.Core;

import net.minecraft.creativetab.CreativeTabs;

public class TabsMMGeneric {
	
	public static CreativeTabs tabItems = new TabItems(CreativeTabs.getNextID(), Core.NAME);
	public static CreativeTabs tabBlocks = new TabBlocks(CreativeTabs.getNextID(), Core.NAME);
	public static CreativeTabs tabMiscellaneous = new TabMisc(CreativeTabs.getNextID(), Core.NAME);
}
