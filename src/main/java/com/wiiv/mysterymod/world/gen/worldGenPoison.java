package com.wiiv.mysterymod.world.gen;

import java.util.Random;

import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class worldGenPoison {
	
	public static void generatePoisonOre(Random rand, int chunkX, int chunkZ, World world, int iterations, WorldGenerator gen, int lowestY, int highestY){
		
		for (int i = 0; i < iterations; i++) {
			int x = chunkX * 16 + rand.nextInt(16);
			int y = rand.nextInt(highestY - lowestY) + lowestY;
			int z = chunkZ * 16 + rand.nextInt(16);
			
			gen.generate(world, rand, x, y, z);
		}
	}
	
}
