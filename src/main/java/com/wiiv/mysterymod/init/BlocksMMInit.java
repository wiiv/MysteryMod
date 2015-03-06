package com.wiiv.mysterymod.init;

import net.minecraft.block.Block;

import com.wiiv.mysterymod.blocks.BlockAlembic;
import com.wiiv.mysterymod.blocks.BlockBomb;
import com.wiiv.mysterymod.blocks.BlockChandelier;
import com.wiiv.mysterymod.blocks.BlockMachine;
import com.wiiv.mysterymod.blocks.BlockRainbow;
import com.wiiv.mysterymod.blocks.BlockRotational;
import com.wiiv.mysterymod.blocks.BlockSalt;
import com.wiiv.mysterymod.blocks.PoisonBlock;
import com.wiiv.mysterymod.blocks.PoisonOre;
import com.wiiv.mysterymod.reference.BlocksMM;

import cpw.mods.fml.common.registry.GameRegistry;

public class BlocksMMInit {
	
	public static Block machine = new BlockMachine();
	public static Block rainbow = new BlockRainbow();
	public static Block rotational = new BlockRotational();
	public static Block bomb = new BlockBomb();
	public static Block poisonOre = new PoisonOre();
	public static Block poisonBlock = new PoisonBlock();
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
