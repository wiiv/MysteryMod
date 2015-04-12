package com.wiiv.mysterymod.tileentities;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.network.Packet;
import net.minecraft.tileentity.TileEntity;

import com.wiiv.mysterymod.handler.DescriptionHandler;

import cpw.mods.fml.common.network.internal.FMLProxyPacket;


public class TileEntityMMGeneric extends TileEntity implements IInventory{
	
	@Override
	public Packet getDescriptionPacket() {
		
		ByteBuf buf = Unpooled.buffer();
		
		buf.writeInt(xCoord);
		buf.writeInt(yCoord);
		buf.writeInt(zCoord);
		
		writeToPacket(buf);
		
		return new FMLProxyPacket(buf, DescriptionHandler.CHANNEL);
	}
	
	public void writeToPacket(ByteBuf buf) {
		
	}

	public void readFromPacket(ByteBuf buf) {

	}

	@Override
	public int getSizeInventory() {
	
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ItemStack getStackInSlot(int p_70301_1_) {
	
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ItemStack decrStackSize(int p_70298_1_, int p_70298_2_) {
	
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ItemStack getStackInSlotOnClosing(int p_70304_1_) {
	
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setInventorySlotContents(int p_70299_1_, ItemStack p_70299_2_) {
	
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getInventoryName() {
	
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean hasCustomInventoryName() {
	
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int getInventoryStackLimit() {
	
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isUseableByPlayer(EntityPlayer p_70300_1_) {
	
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void openInventory() {
	
		// TODO Auto-generated method stub
		
	}

	@Override
	public void closeInventory() {
	
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isItemValidForSlot(int p_94041_1_, ItemStack p_94041_2_) {
	
		// TODO Auto-generated method stub
		return false;
	}
}
