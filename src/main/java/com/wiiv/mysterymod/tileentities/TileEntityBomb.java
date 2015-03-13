package com.wiiv.mysterymod.tileentities;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;

import com.wiiv.mysterymod.init.BlocksMMInit;

public class TileEntityBomb extends TileEntity {
	
	private static final int SPREAD_TIME = 60;
	private static final int SPREAD_LEVELS = 4;
	
	private int timer;
	private int level;
	
	public TileEntityBomb() {
		timer = SPREAD_TIME;
		level = 0;
	}
	
	public boolean isIdle() {
		return timer < 0;
	}
	
	@Override 
	public void updateEntity() {
		
		if(!worldObj.isRemote) {
			
			if(timer <= 60 && timer > 40) {
				worldObj.setBlockMetadataWithNotify(xCoord, yCoord, zCoord, 1, 3);
				
			}else if(timer <= 40 && timer > 20) {
				worldObj.setBlockMetadataWithNotify(xCoord, yCoord, zCoord, 2, 3);
				
			}else if(timer <= 20 && timer > 0) {
				worldObj.setBlockMetadataWithNotify(xCoord, yCoord, zCoord, 3, 3);
				
			}else if(timer == 0 && level < SPREAD_LEVELS) {	
				
				spread(xCoord + 1, yCoord, zCoord);
				spread(xCoord - 1, yCoord, zCoord);
				spread(xCoord, yCoord, zCoord + 1);
				spread(xCoord, yCoord, zCoord - 1);
				spread(xCoord, yCoord + 1, zCoord);
				spread(xCoord, yCoord - 1, zCoord);
				worldObj.setBlockMetadataWithNotify(xCoord, yCoord, zCoord, 0, 3);
				
				worldObj.playSoundEffect(xCoord, yCoord, zCoord, "example:beep", 1.0F, 1.0F);
				
				worldObj.addBlockEvent(xCoord, yCoord, zCoord, BlocksMMInit.bomb, 1, 0);
				
			}else if(timer == (SPREAD_TIME * ( level - SPREAD_LEVELS))) {
				worldObj.createExplosion(null, xCoord + 0.5, yCoord + 0.5, zCoord + 0.5, 4, true);		
			}
			timer--;		
		}
			
	}

	private void spread(int x, int y, int z) {
		
		if(worldObj.isAirBlock(x, y, z)) {
			worldObj.setBlock(x, y, z, BlocksMMInit.bomb); 
			
			TileEntity test = worldObj.getTileEntity(x, y, z);
			
			if(test != null && test instanceof TileEntityBomb){
				TileEntityBomb bomb = (TileEntityBomb)test;
				
				bomb.level = level + 1;
			}
		}
	}
	
	@Override
	public void writeToNBT(NBTTagCompound compound){	
		super.writeToNBT(compound);
		
		compound.setShort("Timer", (short)timer);
		compound.setShort("Level", (byte)level);
	}
	
	@Override
	public void readFromNBT(NBTTagCompound compound){	
		super.readFromNBT(compound);
		
		timer = compound.getShort("Timer");
		level = compound.getByte("Level");
	}
	
	@Override
	public boolean receiveClientEvent(int id, int value){
		if(worldObj.isRemote && id == 1) {
			if(value == 0) {
				timer = -1;
			}else{
				timer = 60;
			}
			worldObj.markBlockForUpdate(xCoord, yCoord, zCoord);
		}
		return true;
	}
}
