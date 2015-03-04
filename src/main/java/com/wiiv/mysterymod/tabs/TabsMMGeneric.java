package com.wiiv.mysterymod.tabs;

import com.wiiv.mysterymod.reference.CoreReferences;

import net.minecraft.creativetab.CreativeTabs;

public class TabsMMGeneric {
	
	public static CreativeTabs tabItems = new TabItems(CreativeTabs.getNextID(), CoreReferences.NAME);
	public static CreativeTabs tabBlocks = new TabBlocks(CreativeTabs.getNextID(), CoreReferences.NAME);
	public static CreativeTabs tabMiscellaneous = new TabMisc(CreativeTabs.getNextID(), CoreReferences.NAME);
}
