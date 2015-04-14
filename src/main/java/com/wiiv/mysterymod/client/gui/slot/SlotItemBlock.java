package com.wiiv.mysterymod.client.gui.slot;

import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class SlotItemBlock extends Slot{

	public SlotItemBlock(IInventory inventory, int inventoryIndex, int x, int y) {
		super(inventory, inventoryIndex, x, y);
	}
	
	@Override
	public boolean isItemValid(ItemStack itemstack) {
		return inventory.isItemValidForSlot(getSlotIndex(), itemstack);
	}
}
