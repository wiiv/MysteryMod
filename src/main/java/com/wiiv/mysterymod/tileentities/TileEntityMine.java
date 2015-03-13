package com.wiiv.mysterymod.tileentities;

import java.util.List;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;

import com.wiiv.mysterymod.utility.Log;


public class TileEntityMine extends TileEntity{
	
	private int timer = 80;
	private ItemStack camoStack;
	
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

	
	@Override
	public void writeToNBT(NBTTagCompound compound){	
		super.writeToNBT(compound);
		
		compound.setShort("Timer", (short)timer);
	}
	
	@Override
	public void readFromNBT(NBTTagCompound compound){	
		super.readFromNBT(compound);
		
		timer = compound.getShort("Timer");
	}
}
