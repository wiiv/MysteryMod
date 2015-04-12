package com.wiiv.mysterymod.init;

import net.minecraft.block.Block;

import com.wiiv.mysterymod.blocks.BlockAlembic;
import com.wiiv.mysterymod.blocks.BlockBomb;
import com.wiiv.mysterymod.blocks.BlockCakeBox;
import com.wiiv.mysterymod.blocks.BlockCamo;
import com.wiiv.mysterymod.blocks.BlockChandelier;
import com.wiiv.mysterymod.blocks.BlockMachine;
import com.wiiv.mysterymod.blocks.BlockMine;
import com.wiiv.mysterymod.blocks.BlockPoison;
import com.wiiv.mysterymod.blocks.BlockPoisonOre;
import com.wiiv.mysterymod.blocks.BlockPump;
import com.wiiv.mysterymod.blocks.BlockRainbow;
import com.wiiv.mysterymod.blocks.BlockRotational;
import com.wiiv.mysterymod.blocks.BlockSalt;
import com.wiiv.mysterymod.blocks.BlockUrn;
import com.wiiv.mysterymod.itemblocks.ItemBlockMachine;
import com.wiiv.mysterymod.itemblocks.ItemBlockRainbow;
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
	public static Block urn = new BlockUrn();
	public static Block rocksalt = new BlockSalt();
	public static Block mine = new BlockMine();
	public static Block camo = new BlockCamo();
	public static Block cakeBox = new BlockCakeBox();
	public static Block pump = new BlockPump();
	
	public static void init() {
 
		GameRegistry.registerBlock(machine, ItemBlockMachine.class, BlocksMM.UNLOCALIZED_MACHINE_NAME);
		GameRegistry.registerBlock(rainbow, ItemBlockRainbow.class, BlocksMM.UNLOCALIZED_RAINBOW_NAME);
		
		GameRegistry.registerBlock(rotational, BlocksMM.UNLOCALIZED_ROTATIONAL_NAME);
		GameRegistry.registerBlock(bomb, BlocksMM.UNLOCALIZED_BOMB_NAME);
		GameRegistry.registerBlock(poisonOre, BlocksMM.UNLOCALIZED_POISONORE_NAME);
		GameRegistry.registerBlock(poisonBlock, BlocksMM.UNLOCALIZED_POISONBLOCK_NAME);
		GameRegistry.registerBlock(alembic, BlocksMM.UNLOCALIZED_ALEMBIC_NAME);
		GameRegistry.registerBlock(chandelier, BlocksMM.UNLOCALIZED_CHANDELIER_NAME);
		GameRegistry.registerBlock(urn, BlocksMM.UNLOCALIZED_URN_NAME);
		GameRegistry.registerBlock(rocksalt, BlocksMM.UNLOCALIZED_SALT_NAME);
		GameRegistry.registerBlock(mine, BlocksMM.UNLOCALIZED_MINE_NAME);
		GameRegistry.registerBlock(camo, BlocksMM.UNLOCALIZED_CAMO_NAME);
		GameRegistry.registerBlock(cakeBox, BlocksMM.UNLOCALIZED_CAKEBOX_NAME);
		GameRegistry.registerBlock(pump, BlocksMM.UNLOCALIZED_PUMP_NAME);
	}
}
