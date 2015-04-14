package com.wiiv.mysterymod.client.gui.container;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

import com.wiiv.mysterymod.client.gui.slot.SlotItemBlock;
import com.wiiv.mysterymod.tileentities.TileEntityCamo;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ContainerCamo extends ContainerMMGeneric{
	
	private TileEntityCamo camo;
	
	public ContainerCamo(InventoryPlayer playerInv, TileEntityCamo camo) {
		this.camo = camo;
		
		addSlotToContainer(new SlotItemBlock(camo, 0, 80, 58));
		addSlotToContainer(new SlotItemBlock(camo, 1, 80, 22));
		addSlotToContainer(new SlotItemBlock(camo, 2, 80, 40));
		addSlotToContainer(new SlotItemBlock(camo, 3, 62, 40));
		addSlotToContainer(new SlotItemBlock(camo, 4, 98, 40));
		addSlotToContainer(new SlotItemBlock(camo, 5, 102, 18));
		
		this.addPlayerSlots(playerInv, 8, 84);
	}
	
	@Override
	public boolean canInteractWith(EntityPlayer player) {
		return camo.isUseableByPlayer(player);
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
                if (slot < 6) {
                        if (!this.mergeItemStack(stackInSlot, 6, 42, true)) {
                                return null;
                        }
                }
                //places it into the tileEntity is possible since its in the player inventory
                //Shift click single items only.
                if(stackInSlot.stackSize == 1) {
                    for(int i = 0; i < 6; i++) {
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

	public TileEntityCamo getTileEntity() {
		return camo;
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
