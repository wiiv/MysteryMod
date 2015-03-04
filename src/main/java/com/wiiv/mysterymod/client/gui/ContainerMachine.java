package com.wiiv.mysterymod.client.gui;

import java.util.Arrays;

import com.wiiv.mysterymod.tileentities.TileEntityMachine;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ContainerMachine extends Container{
	
	private TileEntityMachine machine;
	
	public ContainerMachine(InventoryPlayer invPlayer, TileEntityMachine machine) {
		this.machine = machine;
		
		for (int x = 0; x < 9; x++) {//player hotbar
			addSlotToContainer(new Slot(invPlayer, x, 8 + 18 * x, 194));
		}
		
		for (int y = 0; y < 3; y++) {//inventory
			for (int x = 0; x < 9; x++) {
				addSlotToContainer(new Slot(invPlayer, x + y * 9 + 9, 8 + 18 * x, 136 + y * 18));
			}
		}
		
		for (int x = 0; x < 3; x++) {//anvil slots
			addSlotToContainer(new SlotAnvil(machine, x, 8 + 18 * x, 18));
		}
		
		addSlotToContainer(new SlotCard(machine, 1, 8 + 18 * 3, 18));//card slot
	}
	
	@Override
	public boolean canInteractWith(EntityPlayer entityplayer) {
		return machine.isUseableByPlayer(entityplayer);
	}
	
	@Override
	public ItemStack transferStackInSlot(EntityPlayer player, int i) {//enable shift-click
		
		Slot slot = getSlot(i);
		
		ItemStack itemstack = slot.getStack();
		ItemStack result = itemstack.copy();
		
		if (slot != null && slot.getHasStack()) {
	
			if (i >= 36) {
				
				if (!mergeItemStack(itemstack, 0, 36, false)) {
					return null;
				}
			}else if (!itemstack.equals(Blocks.anvil) || !mergeItemStack(itemstack, 36, 36 + machine.getSizeInventory(), false)) {
				return null;
			}
			
				if (itemstack.stackSize == 0) {
				slot.putStack(null);
				}else {
				slot.onSlotChanged();
				}
				
				slot.onPickupFromSlot(player, itemstack);
			
		}
		return result;
	}
		
	
		
	public TileEntityMachine getMachine() {
		return machine;
	}
	
	//synchronize buttons with each client
	//sends
	
	public void addCraftingToCrafters(ICrafting player) {
		super.addCraftingToCrafters(player);
		
		//custom tab
		for (int i = 0; i < machine.customSetup.length; i++) {
			player.sendProgressBarUpdate(this, i, machine.customSetup[i] ? 1 : 0);
		}
		
		//height tab
		player.sendProgressBarUpdate(this, 25, machine.heightSetting);
	}
	
	//receives
	
	@Override
	@SideOnly(Side.CLIENT)
	public void updateProgressBar(int id, int data) {
		
		if (id < machine.customSetup.length) {
			
			machine.setCustomAnvil(id, data != 0);
			
		}else {
			
			machine.heightSetting = data;
		}
	}
	
	private boolean[] oldData = new boolean[25];
	private int oldHeight;
	
	@Override
	public void detectAndSendChanges() {
		super.detectAndSendChanges();
		
		for (Object player : crafters) {
			
			for (int i = 0; i < machine.customSetup.length; i++) {
				
				if (machine.customSetup[i] != oldData[i]) {
					
					((ICrafting)player).sendProgressBarUpdate(this, i, machine.customSetup[i] ? 1 : 0);
				}
			}
			
			if (machine.heightSetting != oldHeight) {
				
				((ICrafting)player).sendProgressBarUpdate(this, 25, machine.heightSetting);
			}
		}
		
		oldData = Arrays.copyOf(machine.customSetup, machine.customSetup.length);
		oldHeight = machine.heightSetting;
	}
	
}
