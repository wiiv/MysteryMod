package com.wiiv.mysterymod.client.gui.container;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.Slot;

import com.wiiv.mysterymod.tileentities.TileEntityCamo;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ContainerCamo extends ContainerMMGeneric{
	
	private TileEntityCamo camo;
	
	public ContainerCamo(InventoryPlayer playerInv, TileEntityCamo camo) {
		this.camo = camo;
		
		addSlotToContainer(new Slot(camo, 0, 80, 58));
		addSlotToContainer(new Slot(camo, 1, 80, 22));
		addSlotToContainer(new Slot(camo, 2, 80, 40));
		addSlotToContainer(new Slot(camo, 3, 62, 40));
		addSlotToContainer(new Slot(camo, 4, 98, 40));
		addSlotToContainer(new Slot(camo, 5, 102, 18));
		
		this.addPlayerSlots(playerInv, 8, 84);
	}
	
	@Override
	public boolean canInteractWith(EntityPlayer player) {
		return camo.isUseableByPlayer(player);
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
