package com.wiiv.mysterymod.client.gui;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class SlotAnvil extends Slot{

	public SlotAnvil(IInventory inventory, int id, int x, int y) {
		super(inventory, id, x, y);

	}
	
	@Override
	public boolean isItemValid(ItemStack itemstack) {
		return false/*itemstack.equals(Blocks.anvil)/*itemstack.itemID == Block.anvil.blockID*/;
	}
}
