package com.wiiv.mysterymod.client.gui.container;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;


public class ContainerMMGeneric extends Container{

	@Override
	public boolean canInteractWith(EntityPlayer player) {
	
		// TODO Auto-generated method stub
		return false;
	}
	
	protected void addPlayerSlots(InventoryPlayer playerInv, int x, int y) {

		for (int j = 0; j < 3; j++) {//inventory
			for (int i = 0; i < 9; i++) {
				addSlotToContainer(new Slot(playerInv, i + j * 9 + 9, x + i * 18, y + j * 18));
			}
		}
		
		for (int i = 0; i < 9; i++) {//player hotbar
			addSlotToContainer(new Slot(playerInv, i, x + i * 18, y + 58));
		}
	}
	
	@Override
	public ItemStack transferStackInSlot(EntityPlayer player, int i) {//enable shift-click
	
		return null;
	}
		
	
}
