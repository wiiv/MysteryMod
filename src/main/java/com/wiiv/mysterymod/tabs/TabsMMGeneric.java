package com.wiiv.mysterymod.tabs;

import com.wiiv.mysterymod.reference.CoreMM;

import net.minecraft.creativetab.CreativeTabs;

public class TabsMMGeneric {
	
	public static CreativeTabs tabItems = new TabItems(CreativeTabs.getNextID(), CoreMM.NAME);
	public static CreativeTabs tabBlocks = new TabBlocks(CreativeTabs.getNextID(), CoreMM.NAME);
	public static CreativeTabs tabMiscellaneous = new TabMisc(CreativeTabs.getNextID(), CoreMM.NAME);
}
