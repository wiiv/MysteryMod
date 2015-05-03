package com.wiiv.mysterymod.client.gui.container;

import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

import com.wiiv.mysterymod.client.gui.slot.SlotItemBlock;
import com.wiiv.mysterymod.tileentities.TileEntityMine;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ContainerMine extends ContainerMMGeneric{
	
	private TileEntityMine mine;
	private int lastTimer = -1;
	
	public ContainerMine(InventoryPlayer playerInv, TileEntityMine mine) {
		this.mine = mine;
		
		addSlotToContainer(new SlotItemBlock(mine, 0, 8, 26));
		
		this.addPlayerSlots(playerInv, 8, 62);
	}
	
	@Override
	public boolean canInteractWith(EntityPlayer player) {
		return mine.isUseableByPlayer(player);
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
                if (slot < 1) {
                        if (!this.mergeItemStack(stackInSlot, 1, 37, true)) {
                                return null;
                        }
                }
                //places it into the tileEntity is possible since its in the player inventory
                //Shift click single items only.
                if(stackInSlot.stackSize == 1) {
                    for(int i = 0; i < 1; i++) {
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

	public TileEntityMine getTileEntity() {
		return mine;
	}
	
	//synchronize buttons with each client
	
	//sends
	@Override
	public void addCraftingToCrafters(ICrafting player) {

	}
	
	//receives
	@Override
	@SideOnly(Side.CLIENT)
	public void updateProgressBar(int id, int value) {
		super.updateProgressBar(id, value);
		
		if(id == 0){
			
			mine.setTimer(value);
		}
	}

	@Override
	public void detectAndSendChanges() {
		super.detectAndSendChanges();
		
		if(lastTimer != mine.getTimer()){
			
			for(ICrafting crafter : (List<ICrafting>) crafters) {
				
				crafter.sendProgressBarUpdate(this, 0, mine.getTimer());
			}
			
			lastTimer = mine.getTimer();
		}
	}
	
}
