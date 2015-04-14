package com.wiiv.mysterymod.client.gui.slot;

import net.minecraft.init.Blocks;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class SlotAnvil extends Slot{

	public SlotAnvil(IInventory inventory, int id, int x, int y) {
		super(inventory, id, x, y);
	}
	
	@Override
	public boolean isItemValid(ItemStack itemstack) {
		return itemstack.getItem() == Item.getItemFromBlock(Blocks.anvil);
	}
}
