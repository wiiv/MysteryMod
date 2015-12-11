package com.wiiv.mysterymod.client.gui.container;

import java.util.Arrays;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

import com.wiiv.mysterymod.client.gui.slot.SlotAnvil;
import com.wiiv.mysterymod.client.gui.slot.SlotCard;
import com.wiiv.mysterymod.tileentities.TileEntityMachine;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ContainerMachine extends ContainerMMGeneric{
	
	private TileEntityMachine machine;
	
	public ContainerMachine(InventoryPlayer playerInv, TileEntityMachine machine) {
		this.machine = machine;
		
		for (int x = 0; x < 3; x++) {//anvil slots
			addSlotToContainer(new SlotAnvil(machine, x, 8 + 18 * x, 18));
		}
		
		addSlotToContainer(new SlotCard(machine, 3, 8 + 18 * 3, 18));//card slot
		
		this.addPlayerSlots(playerInv, 8, 136);
	}
	
	@Override
	public boolean canInteractWith(EntityPlayer entityplayer) {
		return machine.isUseableByPlayer(entityplayer);
	}
	
	@Override
	public ItemStack transferStackInSlot(EntityPlayer player, int slot) {//enable shift-click
		
		ItemStack stack = null;
        Slot slotObject = (Slot) inventorySlots.get(slot);

        //null checks and checks if the item can be stacked (maxStackSize > 1)
        if (slotObject != null && slotObject.getHasStack()) {
                ItemStack stackInSlot = slotObject.getStack();
                stack = stackInSlot.copy();

                //merges the item into player inventory since its in the tileEntity
                if (slot < 4) {
                        if (!this.mergeItemStack(stackInSlot, 4, 40, true)) {
                                return null;
                        }
                }
                //places it into the tileEntity is possible since its in the player inventory
                else if (!this.mergeItemStack(stackInSlot, 0, 4, false)) {
                        return null;
                }

                if (stackInSlot.stackSize == 0) {
                        slotObject.putStack(null);
                } else {
                        slotObject.onSlotChanged();
                }

                if (stackInSlot.stackSize == stack.stackSize) {
                        return null;
                }
                slotObject.onPickupFromSlot(player, stackInSlot);
        }
        return stack;
	}
		
	
		
	public TileEntityMachine getTileEntity() {
		return machine;
	}
	
	//synchronize buttons with each client
	//sends
	
	@Override
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
		super.updateProgressBar(id, data);
		
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
