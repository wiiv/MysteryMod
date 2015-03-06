package com.wiiv.mysterymod.world.gen;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.feature.WorldGenerator;

import com.wiiv.mysterymod.init.BlocksMMInit;


public class worldGenFlag {
	
	public static void generatePrideFlag(Random rand, int chunkX, int chunkZ, World world, int iterations, WorldGenerator gen, int lowestY, int highestY){
		
		if (rand.nextInt(10) == 0){
			
			int x = chunkX * 16 + rand.nextInt(16);
			int z = chunkZ * 16 + rand.nextInt(16);
			int y = world.getHeightValue(x, z);
			
			if(world.getBiomeGenForCoords(x, z) != BiomeGenBase.river && world.getBiomeGenForCoords(x, z) != BiomeGenBase.ocean){
				
				Block blockSeed = world.getBlock(x, y-1, z);
				
				if( blockSeed != Blocks.lava && blockSeed != Blocks.water && blockSeed != Blocks.leaves && blockSeed != Blocks.leaves2){
				
					for(int i = 0; i < 10; i++){
						world.setBlock(x, y + i, z, Blocks.log, 1, 2);
					}
					
					for (int j = 9 ; j > 3; j--){
						for (int i = 1 ; i < 9; i++){
						world.setBlock(x + i, y + j, z,	BlocksMMInit.rainbow, 2, 2);		
						}
					
						for (int i = 1 ; i < 9; i++){
							world.setBlock(x + i, y + 8, z,	BlocksMMInit.rainbow, 4, 2);
						}
						
						for (int i = 1 ; i < 9; i++){
							world.setBlock(x + i, y + 7, z,	BlocksMMInit.rainbow, 6, 2);
						}
						
						for (int i = 1 ; i < 9; i++){
							world.setBlock(x + i, y + 6, z,	BlocksMMInit.rainbow, 8, 2);
						}
						
						for (int i = 1 ; i < 9; i++){
							world.setBlock(x + i, y + 5, z,	BlocksMMInit.rainbow, 10, 2);
						}
						
						for (int i = 1 ; i < 9; i++){
							world.setBlock(x + i, y + 4, z,	BlocksMMInit.rainbow, 12, 2);
						}	
					}
				}
			}
		}
	}
}
