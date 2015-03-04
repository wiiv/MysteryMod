package com.wiiv.mysterymod.entities;

import com.wiiv.mysterymod.init.BlocksMMInit;
import com.wiiv.mysterymod.reference.BlocksMM;

import net.minecraft.entity.Entity;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

public class EntityBomb extends Entity {

	public EntityBomb(World world) {
		super(world);
		setSize(1.0F, 1.0F);
		
		motionY = -0.6;
	}
	
	@Override
	protected void entityInit() {
	}

	@Override
	protected void readEntityFromNBT(NBTTagCompound nbttagcompound) {
	}

	@Override
	protected void writeEntityToNBT(NBTTagCompound nbttagcompound) {
	}
	
	public void onUpdate() {
		super.onUpdate();
		
		if (!worldObj.isRemote) {
			if (worldObj.isAirBlock((int)posX, (int)posY, (int)posZ) && !worldObj.isAirBlock((int)posX, (int)posY - 1, (int)posZ)) {
				
				worldObj.setBlock((int)posX, (int)posY, (int)posZ, BlocksMMInit.bomb);
				setDead();
			}
		}
		
		setPosition(posX + motionX, posY + motionY, posZ + motionZ);
	}

}
