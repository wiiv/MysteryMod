package com.wiiv.mysterymod.client.gui.container;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

import com.wiiv.mysterymod.client.gui.slot.SlotCake;
import com.wiiv.mysterymod.tileentities.TileEntityCakeBox;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ContainerCakeBox extends ContainerMMGeneric{
	
	private TileEntityCakeBox cakeBox;
	
	public ContainerCakeBox(InventoryPlayer playerInv, TileEntityCakeBox cakeBox) {
		this.cakeBox = cakeBox;
		
		for (int i = 0; i < 6; i++) {//cake slots
			for (int j = 0; j < 9; j++) {
				addSlotToContainer(new SlotCake(cakeBox, j + i * 9, j * 18 + 8, i * 18 + 18));
			}
		}
		
		this.addPlayerSlots(playerInv, 8, 136);
	}
	
	@Override
	public boolean canInteractWith(EntityPlayer player) {
		return cakeBox.isUseableByPlayer(player);
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
                if (slot < 54) {
                        if (!this.mergeItemStack(stackInSlot, 54, 90, true)) {
                                return null;
                        }
                }
                //places it into the tileEntity is possible since its in the player inventory
                //Shift click single items only.
                if(stackInSlot.stackSize == 1) {
                    for(int i = 0; i < 54; i++) {
                        Slot shiftedInSlot = (Slot)inventorySlots.get(i);
                        if(!shiftedInSlot.getHasStack() && shiftedInSlot.isItemValid(stackInSlot)) mergeItemStack(stackInSlot, i, i + 1, false);
                    }
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


	public TileEntityCakeBox getTileEntity() {
		return cakeBox;
	}
	
	//synchronize buttons with each client
	
	//sends
	@Override
	public void addCraftingToCrafters(ICrafting player) {

	}
	
	//receives
	@Override
	@SideOnly(Side.CLIENT)
	public void updateProgressBar(int id, int data) {

	}

	@Override
	public void detectAndSendChanges() {

	}
}
