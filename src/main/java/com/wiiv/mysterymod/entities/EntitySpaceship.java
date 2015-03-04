package com.wiiv.mysterymod.entities;

import io.netty.buffer.ByteBuf;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;

import com.google.common.io.ByteArrayDataInput;
import com.google.common.io.ByteArrayDataOutput;

import cpw.mods.fml.common.registry.IEntityAdditionalSpawnData;

public abstract class EntitySpaceship extends Entity implements IEntityAdditionalSpawnData,IInventory{

	private boolean charged;
	
	public EntitySpaceship(World world) {
		super(world);
		setSize(1.5F, 0.6F);
	}


	public boolean isCharged() {
		return charged;
	}
	
	public void setCharged() {
		charged = true;
	}
	
	@Override
	public AxisAlignedBB getBoundingBox() {
		return boundingBox;
	}
	
	@Override
	public AxisAlignedBB getCollisionBox(Entity entity) {
		if (entity != riddenByEntity) {
			return entity.boundingBox;
		}else{
			return null;
		}
	}
	
	@Override
	public boolean canBeCollidedWith(){
		return !isDead;
	}
	
	@Override
	public boolean interactFirst(EntityPlayer player) {
		if (!worldObj.isRemote && riddenByEntity == null) {
			player.mountEntity(this);
		}
		return true;
	}
	
	@Override
	public double getMountedYOffset() {
		return -0.20;
	}
	
	@Override
	public void onUpdate() {
		super.onUpdate();
		
		if (!worldObj.isRemote) {
			if (riddenByEntity != null) {
				motionY = 0.2;
			}else if (worldObj.isAirBlock((int)posX, (int)posY - 1, (int)posZ)) {
				motionY = -0.2;
			}else{
				motionY = 0;
			}
		}else{
    		//sendInformation();
		}
		setPosition(posX + motionX, posY + motionY, posZ + motionZ);
	}
	
	
	private boolean lastPressedState;
	/*
	private void sendInformation() {
		boolean state = Minecraft.getMinecraft().gameSettings.keyBindJump.isPressed();
		
		if(state && !lastPressedState && charged && riddenByEntity == Minecraft.getMinecraft().thePlayer) {
			if (getAmmunition() == 0 ) {
				Minecraft.getMinecraft().thePlayer.sendChatMessage("no ammunition left");
				worldObj.playSoundAtEntity(ridingEntity, "example:emptyclip", 0.2F, 0.4F);
			}else{
				PacketHandler.sendShipPacket(this);
			}
		}
		lastPressedState = state;
	}
	*/
	@Override
	protected void entityInit() {	
		dataWatcher.addObject(4, (byte)8);/*id(4) 4-31 for each instance of the entity*/
	}
	
	public int getAmmunition() {
		return dataWatcher.getWatchableObjectByte(4);
	}
	
	public void setAmmunition(int val) {
		dataWatcher.updateObject(4, (byte)val);
	}
	
	@Override
	protected void readEntityFromNBT(NBTTagCompound compound) {
		charged = compound.getBoolean("Charged");
		setAmmunition(compound.getByte("ammo"));
	}

	@Override
	protected void writeEntityToNBT(NBTTagCompound compound) {
		compound.setBoolean("Charged", charged);
		compound.setByte("ammo", (byte)getAmmunition());
	}

	@Override
	public void writeSpawnData(ByteBuf data) {
		data.writeBoolean(charged);
	}

	@Override
	public void readSpawnData(ByteBuf data){
		charged = data.readBoolean();
	}
	
	public void doDrop() {
		if (getAmmunition() > 0) {
			EntityBomb bomb = new EntityBomb(worldObj);
		
			bomb.posX = posX;
			bomb.posY = posY - 1.5;
			bomb.posZ = posZ;
		
			worldObj.spawnEntityInWorld(bomb);
			setAmmunition(getAmmunition() - 1);
			worldObj.playSoundAtEntity(bomb, "example:bomb", 0.2F, 0.4F);
		}
	}

	@Override
	public int getSizeInventory() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ItemStack getStackInSlot(int i) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ItemStack decrStackSize(int i, int j) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ItemStack getStackInSlotOnClosing(int i) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setInventorySlotContents(int i, ItemStack itemstack) {
		// TODO Auto-generated method stub
	}

	@Override
	public String getInventoryName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getInventoryStackLimit() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isUseableByPlayer(EntityPlayer entityplayer) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void openInventory(){
		// TODO Auto-generated method stub
		
	}

	@Override
	public void closeInventory(){
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public boolean isItemValidForSlot(int i, ItemStack itemstack) {
		// TODO Auto-generated method stub
		return false;
	}
}
