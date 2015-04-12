package com.wiiv.mysterymod.tileentities;

import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;

import com.wiiv.mysterymod.init.BlocksMMInit;

import cpw.mods.fml.common.network.ByteBufUtils;


public class TileEntityCakeBox extends TileEntityMMGeneric{

private ItemStack[] cakes;//null may cause null pointer exception
	
	public TileEntityCakeBox() {
		
		cakes = new ItemStack[54];
	}
	
	public void setCamouflage(int side, ItemStack stack){
		
		//camoStacks[side] = stack;
		setInventorySlotContents(side, stack);
	}
	
	public ItemStack getCamouflage(int side){
		
		//return camoStacks[side];
		return getStackInSlot(side);
	}

	@Override
	public void writeToPacket(ByteBuf buf) {
		
		for(ItemStack camoStack : cakes) {
			ByteBufUtils.writeItemStack(buf, camoStack);
		}
		
		//Log.info("writing to packet");
	}

	@Override
	public void readFromPacket(ByteBuf buf) {
		
		for(int i = 0; i < cakes.length; i++) {
			cakes[i] = ByteBufUtils.readItemStack(buf);
		}
		
		//Log.info("reading from packet");
		
		worldObj.markBlockRangeForRenderUpdate(xCoord, yCoord, zCoord, xCoord, yCoord, zCoord);
	}

	@Override
	public void writeToNBT(NBTTagCompound compound) {	
		super.writeToNBT(compound);

		//
		NBTTagList camoStacksCompound = new NBTTagList();
		
		for(int i = 0; i < cakes.length; i++){
			
			ItemStack camoStack = cakes[i];
			if(camoStack != null) {
				
				NBTTagCompound compound0 = new NBTTagCompound();//creates a new tag inside a tag
				camoStack.writeToNBT(compound0);
				compound0.setByte("side", (byte)i);
				camoStacksCompound.appendTag(compound0);//adds compound0 to compound
			}
		}
		
		compound.setTag("camoStacks", camoStacksCompound);
		
	}
	
	@Override
	public void readFromNBT(NBTTagCompound compound){	
		super.readFromNBT(compound);
		
		cakes = new ItemStack[54];
		//
		NBTTagList camoStacksCompound = compound.getTagList("camoStacks", 10);
		
		for (int i = 0; i < camoStacksCompound.tagCount(); i++) {
			
			NBTTagCompound compound0 = camoStacksCompound.getCompoundTagAt(i);
			byte side = compound0.getByte("side");
			
			if(side >= 0 && side < cakes.length) {
				cakes[side] = ItemStack.loadItemStackFromNBT(compound0);
			}
		}
	}
	
	@Override
	public int getSizeInventory()
    {
        return cakes.length;
    }
    
	@Override
	public ItemStack getStackInSlot(int slot)
    {
        return this.cakes[slot];
    }

    /**
     * Removes from an inventory slot (first arg) up to a specified number (second arg) of items and returns them in a
     * new stack.
     */
    @Override
	public ItemStack decrStackSize(int slot, int decreaseAmount)
    {
        if (cakes[slot] != null)
        {
            ItemStack itemstack;

            if (cakes[slot].stackSize <= decreaseAmount)
            {
                itemstack = cakes[slot];
                setInventorySlotContents(slot, null);
                this.markDirty();
                return itemstack;
            }
            else
            {
                itemstack = cakes[slot].splitStack(decreaseAmount);

                if (cakes[slot].stackSize == 0)
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
    	
        if (this.cakes[slot] != null) {
        	
            ItemStack itemstack = this.cakes[slot];
            this.cakes[slot] = null;
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
    	
        this.cakes[slot] = stack;

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
    	
        return BlocksMMInit.camo.getUnlocalizedName() + ".name";
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
    	
        return stack.getItem() == Items.cake;
    }

}
