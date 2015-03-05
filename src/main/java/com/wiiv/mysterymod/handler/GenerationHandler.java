package com.wiiv.mysterymod.handler;

import java.util.Random;

import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraft.world.gen.feature.WorldGenerator;

import com.wiiv.mysterymod.init.BlocksMMInit;
import com.wiiv.mysterymod.world.gen.worldGenPoison;
import com.wiiv.mysterymod.world.gen.worldGenSalt;

import cpw.mods.fml.common.IWorldGenerator;
import cpw.mods.fml.common.registry.GameRegistry;

public class GenerationHandler implements IWorldGenerator {

	private WorldGenerator poisonGen;
	private WorldGenerator saltGen;
	
	public GenerationHandler() {
		
		GameRegistry.registerWorldGenerator(this, 0);
		poisonGen = new WorldGenMinable(BlocksMMInit.poison, 16);
		saltGen = new WorldGenMinable(BlocksMMInit.rocksalt, 16);
	}
		   
	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
		
		worldGenPoison.generatePoisonOre(random, chunkX, chunkZ, world, 20, poisonGen, 0, 128);
		worldGenSalt.generateSaltOre(random, chunkX, chunkZ, world, 1, saltGen, 0, 128);
	}
	
}
	

