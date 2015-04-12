package com.wiiv.mysterymod.tileentities;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;

import com.wiiv.mysterymod.init.ItemsMMInit;

public class TileEntityMachine extends TileEntityMMGeneric{

	private ItemStack[] items;
	public final boolean[] customSetup;
	public int heightSetting = 20;
	
	public TileEntityMachine() {
		
		items = new ItemStack[4];
		customSetup = new boolean[25];
	}
	
	@Override
	public int getSizeInventory() {
		return items.length;
	}

	@Override
	public ItemStack getStackInSlot(int i) {
		return items[i];
	}

	@Override
	public ItemStack decrStackSize(int slot, int decreaseAmount) {
		
		ItemStack itemstack = getStackInSlot(slot);
		
		if (itemstack != null){
			if (itemstack.stackSize <= decreaseAmount) {
				setInventorySlotContents(slot, null);
			}else{
				itemstack = itemstack.splitStack(decreaseAmount);
				//onInventoryChanged();
			}
		}
		return itemstack;
	}

	@Override
	public ItemStack getStackInSlotOnClosing(int slot) {
		
		ItemStack itemstack = getStackInSlot(slot);
		
		setInventorySlotContents(slot, null);
		
		return itemstack;
	}

	@Override
	public void setInventorySlotContents(int slot, ItemStack itemstack) {
		
		items[slot] = itemstack;
		
		if (itemstack != null && itemstack.stackSize > getInventoryStackLimit()){
			itemstack.stackSize = getInventoryStackLimit();
		}
	} 
	
	@Override
	public String getInventoryName() {
		return "Anvil Machine";
	}

	@Override
	public boolean hasCustomInventoryName() {
		return false;
	}

	@Override
	public int getInventoryStackLimit() {
		return 64;
	}

	@Override
	public boolean isUseableByPlayer(EntityPlayer player) {
    	
        return this.worldObj.getTileEntity(this.xCoord, this.yCoord, this.zCoord) != this ? false : player.getDistanceSq(this.xCoord + 0.5D, this.yCoord + 0.5D, this.zCoord + 0.5D) <= 64.0D;
    }

	@Override
	public void openInventory() {
	}

	@Override
	public void closeInventory() {
	}
	
	@Override
	public boolean isItemValidForSlot(int i, ItemStack stack) {
		
		if(i >= 0 && i < 3){
			
			return stack.getItem() == Item.getItemFromBlock(Blocks.anvil);
			
		}else {
			
			return stack.getItem() == ItemsMMInit.card;
		}
	}
	
	@Override
	public void writeToNBT(NBTTagCompound compound) {	
		super.writeToNBT(compound);
		
		//anvil and card slots
		NBTTagList items = new NBTTagList();
		
		for (int i = 0; i < getSizeInventory(); i++) {
			ItemStack stack = getStackInSlot(i);
			
			if (stack != null) {
				NBTTagCompound item = new NBTTagCompound();
				item.setByte("Slot", (byte)i);
				stack.writeToNBT(item);
				items.appendTag(item);
			}
		}
		
		compound.setTag("Items", items);	
		
		//custom setup
		for (int i = 0; i < customSetup.length; i++) {
			compound.setBoolean("Custom" + i, customSetup[i]);
		}
		
		//height tab
		compound.setByte("Height", (byte)heightSetting);
	}
	
	@Override
	public void readFromNBT(NBTTagCompound compound) {	
		super.readFromNBT(compound);
		
		items = new ItemStack[4];
		
		NBTTagList items = compound.getTagList("Items", 10);
		
		for (int i = 0; i < items.tagCount(); i++) {
			NBTTagCompound item = items.getCompoundTagAt(i);
			byte slot = item.getByte("Slot");
			
			if (slot >= 0 && slot < getSizeInventory()) {
				setInventorySlotContents(slot, ItemStack.loadItemStackFromNBT(item));
			}
		}
		
		//custom setup
		for (int i = 0; i < customSetup.length; i++) {
			setCustomAnvil(i, compound.getBoolean("Custom" + i));
		}
		
		//height tab
		heightSetting = compound.getByte("Height");
		
	}
	
	public void receiveInterfaceEvent(byte eventId, byte value) {
		
		switch (eventId) {
			
			case 0:
				
				switch (value) {
					
					case 0:
						
						int meta = worldObj.getBlockMetadata(xCoord, yCoord, zCoord);
						int type = meta/2;
						int disabled = meta % 2 == 0 ? 1 : 0;
						int newMeta = type * 2 + disabled;
						
						worldObj.setBlockMetadataWithNotify(xCoord, yCoord, zCoord, newMeta, 3);
						
						break;	
						
					case 1:
						
						int meta2 = worldObj.getBlockMetadata(xCoord, yCoord, zCoord);
						
						worldObj.setBlockMetadataWithNotify(xCoord, yCoord, zCoord, meta2 % 2, 3);
						
						break;
				}
				
				break;
				
			case 1:
				
				setCustomAnvil(value, !customSetup[value]);
				
				break;
				
			case 2:
				
				heightSetting = value;
				
				break;
		}
				
	}
	
	private int anvils = -1;
	
	public int getAnvils() {
		
		if (anvils == -1) {
			calculateAnvilCount();
		}
		
		return anvils;
	}
	
	private void calculateAnvilCount() {

		anvils = 0;
		
		for (int i = 0; i < getSizeInventory(); i++) {
			
			ItemStack itemstack = getStackInSlot(i);
			
			if (itemstack != null && isItemValidForSlot(i, itemstack)) {
				anvils += itemstack.stackSize;
			}
		}
	}
	
	/*
	@Override
	public void onInventoryChanged() {
		super.onInventoryChanged();
		
		anvils = -1;
	}
	*/
	
	private int customAnvils = 0;

	public int getCustomAnvils() {
		return customAnvils;
	}
	
	public void setCustomAnvil(int i, boolean val) {
		boolean oldVal = customSetup[i];
		if (oldVal && !val) {
			customAnvils--;
		}else if(!oldVal && val){
			customAnvils++;
		}
		customSetup[i] = val;
	}
}
