package com.wiiv.mysterymod.client.gui;

import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

import com.wiiv.mysterymod.init.ItemsMMInit;
import com.wiiv.mysterymod.reference.ItemsMM;

public class SlotCard extends Slot{

	public SlotCard(IInventory inventory, int id, int x, int y) {
		super(inventory, id, x, y);

	}
	
	@Override
	public boolean isItemValid(ItemStack itemstack) {
		return false/*itemstack.equals(ItemsMMInit.card)/*itemstack.itemID == Items.card.itemID*/;
	}
}
