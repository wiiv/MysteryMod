package com.wiiv.mysterymod.init;

import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;

import com.wiiv.mysterymod.blocks.BlockAlembic;
import com.wiiv.mysterymod.blocks.BlockBomb;
import com.wiiv.mysterymod.blocks.BlockChandelier;
import com.wiiv.mysterymod.blocks.BlockMachine;
import com.wiiv.mysterymod.blocks.BlockPoison;
import com.wiiv.mysterymod.blocks.BlockRainbow;
import com.wiiv.mysterymod.blocks.BlockRotational;
import com.wiiv.mysterymod.blocks.BlockUrn;
import com.wiiv.mysterymod.reference.BlocksMM;
import com.wiiv.mysterymod.tileentities.TileEntityAlembic;
import com.wiiv.mysterymod.tileentities.TileEntityBomb;
import com.wiiv.mysterymod.tileentities.TileEntityChandelier;
import com.wiiv.mysterymod.tileentities.TileEntityMachine;
import com.wiiv.mysterymod.tileentities.TileEntityRotational;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class BlocksMMInit {
	
	public static Block machine = new BlockMachine();;
	public static Block rainbow = new BlockRainbow();;
	public static Block rotational = new BlockRotational();;
	public static Block bomb = new BlockBomb();;
	public static Block poison = new BlockPoison();;
	public static Block alembic = new BlockAlembic();;
	public static Block chandelier = new BlockChandelier();;
	//public static Block urn = new BlockUrn();
	
	public static void init() {
 
		GameRegistry.registerBlock(machine, BlocksMM.UNLOCALIZED_MACHINE_NAME);
		GameRegistry.registerBlock(rainbow, BlocksMM.UNLOCALIZED_RAINBOW_NAME);
		GameRegistry.registerBlock(rotational, BlocksMM.UNLOCALIZED_ROTATIONAL_NAME);
		GameRegistry.registerBlock(bomb, BlocksMM.UNLOCALIZED_BOMB_NAME);
		GameRegistry.registerBlock(poison, BlocksMM.UNLOCALIZED_POISON_NAME);
		GameRegistry.registerBlock(alembic, BlocksMM.UNLOCALIZED_ALEMBIC_NAME);
		GameRegistry.registerBlock(chandelier, BlocksMM.UNLOCALIZED_CHANDELIER_NAME);
		//urn;
	}
}
