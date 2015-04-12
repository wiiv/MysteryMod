package com.wiiv.mysterymod.client.gui.container;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.ICrafting;

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
