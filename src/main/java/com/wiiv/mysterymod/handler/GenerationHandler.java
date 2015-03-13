package com.wiiv.mysterymod.handler;

import java.util.Random;

import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraft.world.gen.feature.WorldGenerator;

import com.wiiv.mysterymod.init.BlocksMMInit;
import com.wiiv.mysterymod.world.gen.worldGenFlag;
import com.wiiv.mysterymod.world.gen.worldGenPoison;
import com.wiiv.mysterymod.world.gen.worldGenSalt;

import cpw.mods.fml.common.IWorldGenerator;

public class GenerationHandler implements IWorldGenerator {

	private WorldGenerator poisonOreGen;
	private WorldGenerator saltOreGen;
	private WorldGenerator flagStructGen;
	
	public GenerationHandler() {
		
		poisonOreGen = new WorldGenMinable(BlocksMMInit.poisonOre, 16);
		saltOreGen = new WorldGenMinable(BlocksMMInit.rocksalt, 32);
	}
		   
	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
		
		switch(world.provider.dimensionId){
			case 0:
				generateSurface(random, chunkX,chunkZ, world);
			case -1:
				generateNether(random, chunkX,chunkZ, world);
			case 1:
				generateEnd(random, chunkX,chunkZ, world);
			default:
				generateSurface(random, chunkX,chunkZ, world);
		}
	}
	
	public void generateSurface(Random random, int chunkX, int chunkZ, World world){
		worldGenPoison.generatePoisonOre(random, chunkX, chunkZ, world, 20, poisonOreGen, 0, 128);
		worldGenSalt.generateSaltOre(random, chunkX, chunkZ, world, 1, saltOreGen, 0, 96);
		worldGenFlag.generatePrideFlag(random, chunkX, chunkZ, world, 1, flagStructGen, 0, 128);
	}
	
	public void generateNether(Random random, int chunkX, int chunkZ, World world){
		
	}
	
	public void generateEnd(Random random, int chunkX, int chunkZ, World world){
		
	}
	
}
	

