package com.wiiv.mysterymod.init;

import net.minecraft.block.Block;

import com.wiiv.mysterymod.block.BlockAlembic;
import com.wiiv.mysterymod.block.BlockBomb;
import com.wiiv.mysterymod.block.BlockChandelier;
import com.wiiv.mysterymod.block.BlockMachine;
import com.wiiv.mysterymod.block.BlockRainbow;
import com.wiiv.mysterymod.block.BlockRotational;
import com.wiiv.mysterymod.block.BlockSalt;
import com.wiiv.mysterymod.block.BlockPoison;
import com.wiiv.mysterymod.block.BlockPoisonOre;
import com.wiiv.mysterymod.reference.BlocksMM;

import cpw.mods.fml.common.registry.GameRegistry;

public class BlocksMMInit {
	
	public static Block machine = new BlockMachine();
	public static Block rainbow = new BlockRainbow();
	public static Block rotational = new BlockRotational();
	public static Block bomb = new BlockBomb();
	public static Block poisonOre = new BlockPoisonOre();
	public static Block poisonBlock = new BlockPoison();
	public static Block alembic = new BlockAlembic();
	public static Block chandelier = new BlockChandelier();
	//public static Block urn = new BlockUrn();
	public static Block rocksalt = new BlockSalt();
	
	public static void init() {
 
		GameRegistry.registerBlock(machine, BlocksMM.UNLOCALIZED_MACHINE_NAME);
		GameRegistry.registerBlock(rainbow, BlocksMM.UNLOCALIZED_RAINBOW_NAME);
		GameRegistry.registerBlock(rotational, BlocksMM.UNLOCALIZED_ROTATIONAL_NAME);
		GameRegistry.registerBlock(bomb, BlocksMM.UNLOCALIZED_BOMB_NAME);
		GameRegistry.registerBlock(poisonOre, BlocksMM.UNLOCALIZED_POISONORE_NAME);
		GameRegistry.registerBlock(poisonBlock, BlocksMM.UNLOCALIZED_POISONBLOCK_NAME);
		GameRegistry.registerBlock(alembic, BlocksMM.UNLOCALIZED_ALEMBIC_NAME);
		GameRegistry.registerBlock(chandelier, BlocksMM.UNLOCALIZED_CHANDELIER_NAME);
		//urn;
		GameRegistry.registerBlock(rocksalt, BlocksMM.UNLOCALIZED_SALT_NAME);
	}
}
