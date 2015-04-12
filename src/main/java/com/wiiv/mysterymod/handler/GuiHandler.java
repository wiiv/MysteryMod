package com.wiiv.mysterymod.handler;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import com.wiiv.mysterymod.client.gui.GuiCakeBox;
import com.wiiv.mysterymod.client.gui.GuiCamo;
import com.wiiv.mysterymod.client.gui.GuiMachine;
import com.wiiv.mysterymod.client.gui.container.ContainerCakeBox;
import com.wiiv.mysterymod.client.gui.container.ContainerCamo;
import com.wiiv.mysterymod.client.gui.container.ContainerMachine;
import com.wiiv.mysterymod.tileentities.TileEntityCakeBox;
import com.wiiv.mysterymod.tileentities.TileEntityCamo;
import com.wiiv.mysterymod.tileentities.TileEntityMachine;

import cpw.mods.fml.common.network.IGuiHandler;

public class GuiHandler implements IGuiHandler{
	
	public enum GuiID{
		MACHINE,
		CAKE_BOX,
		CAMO
	}
	
	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		
		switch(GuiID.values()[ID]) {//container
			
			case MACHINE:
				TileEntity te0 = world.getTileEntity(x, y, z);
				if(te0 != null && te0 instanceof TileEntityMachine){
					return new ContainerMachine(player.inventory, (TileEntityMachine)te0);
				}
				break;
				
			case CAKE_BOX:
				TileEntity te1 = world.getTileEntity(x, y, z);
				if(te1 != null && te1 instanceof TileEntityCakeBox){
					return new ContainerCakeBox(player.inventory, (TileEntityCakeBox)te1);
				}
				break;
				
			case CAMO:
				TileEntity te2 = world.getTileEntity(x, y, z);
				if(te2 != null && te2 instanceof TileEntityCamo){
					return new ContainerCamo(player.inventory, (TileEntityCamo)te2);
				}
				break;	
				
		}
		throw new IllegalArgumentException("No CONTAINER wit id " + ID);
		//return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		
		switch(GuiID.values()[ID]) {//gui
			
			case MACHINE:
				
				TileEntity te0 = world.getTileEntity(x, y, z);
				if(te0 != null && te0 instanceof TileEntityMachine){
					return new GuiMachine(player.inventory, (TileEntityMachine)te0);
				}
				break;
				
			case CAKE_BOX:
				
				TileEntity te1 = world.getTileEntity(x, y, z);
				if(te1 != null && te1 instanceof TileEntityCakeBox){
					return new GuiCakeBox(player.inventory, (TileEntityCakeBox)te1);
				}
				break;
				
			case CAMO:
				
				TileEntity te2 = world.getTileEntity(x, y, z);
				if(te2 != null && te2 instanceof TileEntityCamo){
					return new GuiCamo(player.inventory, (TileEntityCamo)te2);
				}
				break;
		}
		throw new IllegalArgumentException("No GUI wit id " + ID);
		//return null;
	}
}
