package com.wiiv.mysterymod.init;

import com.wiiv.mysterymod.reference.BlocksMM;
import com.wiiv.mysterymod.tileentities.TileEntityAlembic;
import com.wiiv.mysterymod.tileentities.TileEntityBomb;
import com.wiiv.mysterymod.tileentities.TileEntityCakeBox;
import com.wiiv.mysterymod.tileentities.TileEntityCamo;
import com.wiiv.mysterymod.tileentities.TileEntityChandelier;
import com.wiiv.mysterymod.tileentities.TileEntityMachine;
import com.wiiv.mysterymod.tileentities.TileEntityMine;
import com.wiiv.mysterymod.tileentities.TileEntityPump;
import com.wiiv.mysterymod.tileentities.TileEntityRotational;

import cpw.mods.fml.common.registry.GameRegistry;

public class TilesMMInit {
	
	public static void init(){
			
		GameRegistry.registerTileEntity(TileEntityBomb.class, BlocksMM.BOMB_TE_KEY);
		GameRegistry.registerTileEntity(TileEntityRotational.class, BlocksMM.ROTATIONAL_TE_KEY);
		GameRegistry.registerTileEntity(TileEntityMachine.class, BlocksMM.MACHINE_TE_KEY);
		GameRegistry.registerTileEntity(TileEntityAlembic.class, BlocksMM.ALEMBIC_TE_KEY);
		GameRegistry.registerTileEntity(TileEntityChandelier.class, BlocksMM.CHANDELIER_TE_KEY);
		GameRegistry.registerTileEntity(TileEntityMine.class, BlocksMM.MINE_TE_KEY);
		GameRegistry.registerTileEntity(TileEntityPump.class, BlocksMM.PUMP_TE_KEY);
		GameRegistry.registerTileEntity(TileEntityCamo.class, BlocksMM.CAMO_TE_KEY);
		GameRegistry.registerTileEntity(TileEntityCakeBox.class, BlocksMM.CAKEBOX_TE_KEY);
	}

}
