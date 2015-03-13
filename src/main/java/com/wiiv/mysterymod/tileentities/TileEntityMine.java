package com.wiiv.mysterymod.tileentities;

import io.netty.buffer.ByteBuf;

import java.util.List;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.AxisAlignedBB;

import com.wiiv.mysterymod.utility.Log;

import cpw.mods.fml.common.network.ByteBufUtils;


public class TileEntityMine extends TileEntityMMGeneric{
	
	private int timer = 80;
	private ItemStack camoStack;//null may cause null pointer exception
	
	@Override
	public void updateEntity(){
		
		List <Entity> entities = worldObj.getEntitiesWithinAABB(EntityPlayer.class, AxisAlignedBB.getBoundingBox(xCoord - 1, yCoord - 1, zCoord - 1, xCoord + 2, yCoord + 2, zCoord + 2));

		if(entities.size() > 0 && !worldObj.isRemote){
			
			if (timer == 80){
				
				worldObj.playSoundEffect(xCoord + 0.5, yCoord + 0.25, zCoord + 0.5, "game.tnt.primed", 1.0F, worldObj.rand.nextFloat() * 0.1F + 0.9F);
			}
			
			timer--;
			Log.info(timer);
			
			if (timer == 0){
					
				worldObj.createExplosion(null, xCoord + 0.5, yCoord + 0.25, zCoord + 0.5, 3.0F, true);
			}
		}	
	}
	
	public void setCamouflage(ItemStack stack){
		camoStack = stack;
		worldObj.markBlockForUpdate(xCoord, yCoord, zCoord);
	}
	
	public ItemStack getCamouflage(){
		return camoStack;
	}

	@Override
	public void writeToPacket(ByteBuf buf) {
		
		ByteBufUtils.writeItemStack(buf, camoStack);
		Log.info("writing to packet");
	}
	
	@Override
	public void readFromPacket(ByteBuf buf) {
		
		camoStack = ByteBufUtils.readItemStack(buf);
		Log.info("reading from packet");
		
		worldObj.markBlockRangeForRenderUpdate(xCoord, yCoord, zCoord, xCoord, yCoord, zCoord);
	}

	@Override
	public void writeToNBT(NBTTagCompound compound) {	
		super.writeToNBT(compound);
		
		//
		compound.setShort("Timer", (short)timer);
	
		//
		if(camoStack != null) {
			
			NBTTagCompound compound0 = new NBTTagCompound();//creates a new tab inside a tag
			camoStack.writeToNBT(compound0);
			compound.setTag("camoStack", compound0);//adds compound0 to compound
		}
	}
	
	@Override
	public void readFromNBT(NBTTagCompound compound){	
		super.readFromNBT(compound);
		
		//
		timer = compound.getShort("Timer");
		
		//
		if(compound.hasKey("camoStack")) {
			camoStack = ItemStack.loadItemStackFromNBT(compound.getCompoundTag("camoStack"));
		}else {
			camoStack = null;
		}
	}
}
