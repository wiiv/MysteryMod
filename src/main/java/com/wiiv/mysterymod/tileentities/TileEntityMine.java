package com.wiiv.mysterymod.tileentities;

import io.netty.buffer.ByteBuf;

import java.util.List;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.AxisAlignedBB;

import com.wiiv.mysterymod.init.BlocksMMInit;

import cpw.mods.fml.common.network.ByteBufUtils;


public class TileEntityMine extends TileEntityMMGeneric{
	
	private int timer = 80;
	private String target = "";
	private ItemStack camoStack;//null may cause null pointer exception
	
	@Override
	public void updateEntity(){
		
		List <Entity> entities = worldObj.getEntitiesWithinAABB(EntityPlayer.class, AxisAlignedBB.getBoundingBox(xCoord - 1, yCoord - 1, zCoord - 1, xCoord + 2, yCoord + 2, zCoord + 2));

		if(timer > 0 && entities.size() > 0){
			
			if (timer == 80){
				
				worldObj.playSoundEffect(xCoord + 0.5, yCoord + 0.25, zCoord + 0.5, "game.tnt.primed", 1.0F, worldObj.rand.nextFloat() * 0.1F + 0.9F);
				worldObj.setBlockMetadataWithNotify(xCoord, yCoord, zCoord, 0, 3);
				
			} else if (timer < 80){
				worldObj.setBlockMetadataWithNotify(xCoord, yCoord, zCoord, 1, 3);
			}
			
			timer--;
			//Log.info(timer);
			
			if (timer == 0 && !worldObj.isRemote){
					
				worldObj.createExplosion(null, xCoord + 0.5, yCoord + 0.25, zCoord + 0.5, 3.0F, true);
			}
		}	
	}
	
	public int getTimer(){
		return timer;
	}
	
	public void setTimer(int value){
		timer = value;
		markDirty();
	}
	
	public String getTarget() {
	
		return target;
	}

	public void setTarget(String target) {
	
		this.target = target;
		markDirty();
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
		//Log.info("writing to packet");
	}
	
	@Override
	public void writeToNBT(NBTTagCompound compound) {	
		super.writeToNBT(compound);
		
		//
		compound.setShort("Timer", (short)timer);
		compound.setString("Target", target);
		//
		if(camoStack != null) {
			
			NBTTagCompound compound0 = new NBTTagCompound();//creates a new tab inside a tag
			camoStack.writeToNBT(compound0);
			compound.setTag("camoStack", compound0);//adds compound0 to compound
		}
	}
	
	@Override
	public void readFromPacket(ByteBuf buf) {
		
		camoStack = ByteBufUtils.readItemStack(buf);
		//Log.info("reading from packet");
		
		worldObj.markBlockRangeForRenderUpdate(xCoord, yCoord, zCoord, xCoord, yCoord, zCoord);
	}
	
	@Override
	public void readFromNBT(NBTTagCompound compound){	
		super.readFromNBT(compound);
		
		//
		timer = compound.getShort("Timer");
		target = compound.getString("Target");
		
		//
		if(compound.hasKey("camoStack")) {
			camoStack = ItemStack.loadItemStackFromNBT(compound.getCompoundTag("camoStack"));
		}else {
			camoStack = null;
		}
	}
	
	@Override
	public void onGuiButtonPressed(int id){
		
		if (id == 0){
			
			if(timer == -1){
			
			timer = 80;
			
			}else{
				
				timer = -1;
			}
		}
	}
	
	@Override
	public void onGuiTextfieldUpdate(int id, String text){
		
		if (id == 0){
			target = text;
			markDirty();
		}
	}
	
	@Override
	public int getSizeInventory()
    {
        return 1;
    }
    
	@Override
	public ItemStack getStackInSlot(int slot)
    {
        return camoStack;
    }
	
	/**
     * Removes from an inventory slot (first arg) up to a specified number (second arg) of items and returns them in a
     * new stack.
     */
    @Override
	public ItemStack decrStackSize(int slot, int decreaseAmount)
    {
        if (camoStack != null)
        {
            ItemStack itemstack;

            if (camoStack.stackSize <= decreaseAmount)
            {
                itemstack = camoStack;
                setInventorySlotContents(slot, null);
                this.markDirty();
                return itemstack;
            }
            else
            {
                itemstack = camoStack.splitStack(decreaseAmount);

                if (camoStack.stackSize == 0)
                {
                	setInventorySlotContents(slot, null);
                }

                this.markDirty();
                return itemstack;
            }
        }
        else
        {
            return null;
        }
    }

    /**
     * When some containers are closed they call this on each slot, then drop whatever it returns as an EntityItem -
     * like when you close a workbench GUI.
     */
    @Override
	public ItemStack getStackInSlotOnClosing(int slot) {
    	
        if (this.camoStack != null) {
        	
            ItemStack itemstack = this.camoStack;
            this.camoStack = null;
            return itemstack;
            
        }else {
        	
            return null;
        }
    }

    /**
     * Sets the given item stack to the specified slot in the inventory (can be crafting or armor sections).
     */
    @Override
	public void setInventorySlotContents(int slot, ItemStack stack) {
    	
        this.camoStack = stack;

        if (stack != null && stack.stackSize > this.getInventoryStackLimit())
        {
            stack.stackSize = this.getInventoryStackLimit();
        }

        this.markDirty();
        worldObj.markBlockForUpdate(xCoord, yCoord, zCoord);
    }

    /**
     * Returns the name of the inventory
     */
    @Override
	public String getInventoryName() {
    	
        return BlocksMMInit.mine.getUnlocalizedName() + ".name";
    }

    /**
     * Returns if the inventory is named
     */
    @Override
	public boolean hasCustomInventoryName() {
    	
        return false;
    }

    /**
     * Returns the maximum stack size for a inventory slot.
     */
    @Override
	public int getInventoryStackLimit() {
    	
        return 1;
    }

    /**
     * Do not make give this method the name canInteractWith because it clashes with Container
     */
    @Override
	public boolean isUseableByPlayer(EntityPlayer player) {
    	
        return this.worldObj.getTileEntity(this.xCoord, this.yCoord, this.zCoord) != this ? false : player.getDistanceSq(this.xCoord + 0.5D, this.yCoord + 0.5D, this.zCoord + 0.5D) <= 64.0D;
    }

    @Override
	public void openInventory() {}

    @Override
	public void closeInventory() {}

    /**
     * Returns true if automation is allowed to insert the given stack (ignoring stack size) into the given slot.
     */
    @Override
	public boolean isItemValidForSlot(int slot, ItemStack stack) {
    	
        return stack != null && stack.getItem() instanceof ItemBlock;
    }
}
