package com.wiiv.mysterymod.handler;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import com.wiiv.mysterymod.client.gui.ContainerMachine;
import com.wiiv.mysterymod.client.gui.GuiMachine;
import com.wiiv.mysterymod.reference.CoreMM;
import com.wiiv.mysterymod.tileentities.TileEntityMachine;

import cpw.mods.fml.common.network.IGuiHandler;
import cpw.mods.fml.common.network.NetworkRegistry;

public class GuiHandler implements IGuiHandler{
	
	public GuiHandler(){
		NetworkRegistry.INSTANCE.registerGuiHandler(CoreMM.MOD_ID, this);
	}

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		switch(ID) {//container
			case 0:
				TileEntity te = world.getTileEntity(x, y, z);
				if(te != null && te instanceof TileEntityMachine){
					return new ContainerMachine(player.inventory, (TileEntityMachine)te);
				}
				break;
		}
		return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		switch(ID) {//gui
			case 0:
				TileEntity te = world.getTileEntity(x, y, z);
				if(te != null && te instanceof TileEntityMachine){
					return new GuiMachine(player.inventory, (TileEntityMachine)te);
				}
				break;
		}
		return null;
	}
}
