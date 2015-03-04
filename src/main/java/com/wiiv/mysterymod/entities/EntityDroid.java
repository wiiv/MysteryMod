package com.wiiv.mysterymod.entities;

import net.minecraft.entity.Entity;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

public class EntityDroid extends Entity {
	
	private double startX;
	private double targetX;
	
	private double startY;
	private double targetY;
	
	private double startZ;
	private double targetZ;
	
	private float helmetPositionCycle = 6.0F;
	
	private float coreRotation;
	
	private float r;
	private float g;
	private float b;
	
	private float innerPanelRotation;
	private float outerPanelRotation = -(float)Math.PI / 2;
	
	
	public EntityDroid(World world) {
		super(world);
		
		r = world.rand.nextFloat();
		g = world.rand.nextFloat();
		b = world.rand.nextFloat();
	}

	public EntityDroid(World world, double x, double y, double z) {
		this(world);
		
		posX = x;
		posY = startY = y;
		posZ = z;
	}
	
	
	@Override
	protected void entityInit() {
		
		dataWatcher.addObject(20, (byte)(0));
		dataWatcher.addObject(21, (byte)(0));
	}

	@Override
	protected void readEntityFromNBT(NBTTagCompound nbttagcompound) {

		startY = nbttagcompound.getShort("start");
		targetY = nbttagcompound.getShort("target");	
	}

	@Override
	protected void writeEntityToNBT(NBTTagCompound nbttagcompound) {
	
		nbttagcompound.setShort("start",(short)startY);
		nbttagcompound.setShort("target",(short)targetY);
	}
	
	@Override
	public void onUpdate() {
		super.onUpdate();
		
		if(!worldObj.isRemote) {
			
			if(targetY == 0 || Math.abs(posY - targetY) < 0.24) {
				
				targetY = startY + worldObj.rand.nextDouble() * 4;
			}
			
			if (posY < targetY) {
				
				motionY = 0.04F;
				
			}else {
				
				motionY = -0.04F;
			}
			
			boolean lightLevel = worldObj.getBlockLightValue((int)posX, (int)posY, (int)posZ) == 15;
			
			dataWatcher.updateObject(20, lightLevel ? (byte)1 : (byte)0);
			
		}else {
			
			coreRotation += 0.04F;
		
			helmetPositionCycle += 0.02F;
					
			if(dataWatcher.getWatchableObjectByte(20) != 0) {
				
				float openInnerPanelRotation = (float)Math.PI / 2;
				
				innerPanelRotation = Math.min(openInnerPanelRotation, innerPanelRotation + 0.02F);//-
				
				if (innerPanelRotation == openInnerPanelRotation) {
					
					outerPanelRotation = Math.min(0, outerPanelRotation + 0.02F);//--
					
				}
				
			}else {
				
				float closedOuterPanelRotation = -(float)Math.PI / 2;
				
				outerPanelRotation = Math.max(closedOuterPanelRotation, outerPanelRotation - 0.02F);//--
				
				if (outerPanelRotation == closedOuterPanelRotation) {
					
					innerPanelRotation = Math.min(0, innerPanelRotation + 0.02F);//-
				}
			}
			
		setPosition(posX + motionX, posY + motionY, posZ + motionZ);
		}
	}
	
	public float getHelmetRotationPosition() {
		
		return -6.0F - Math.abs((float)Math.sin(helmetPositionCycle)) * 5.5F;
	}
	
	public float getCoreRotation () {
		
		return coreRotation;
	}
	
	public float getInnerPanelRotation () {
		
		return innerPanelRotation;
	}

	public float getOuterPanelRotation() {
		
		return outerPanelRotation;
	}
	

	public float getRedCoreColor() {
		
		return r;
	}
	
	public float getGreenCoreColor() {

		return g;
	}
	
	public float getBlueCoreColor() {
		
		return b;
	}

	
}
