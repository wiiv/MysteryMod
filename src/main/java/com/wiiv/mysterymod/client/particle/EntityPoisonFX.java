package com.wiiv.mysterymod.client.particle;

import net.minecraft.client.particle.EntityFX;
import net.minecraft.world.World;

import com.wiiv.mysterymod.block.BlockPoisonOre;

public class EntityPoisonFX extends EntityFX{
	
	
	public EntityPoisonFX(World world, double x, double y, double z, double motionX, double motionY, double motionZ) {
		super(world, x, y, z, motionX, motionY, motionZ);
		
		setParticleIcon(BlockPoisonOre.particleIcon);
		
		particleScale = 2;
		particleAlpha = rand.nextFloat();
		particleRed = rand.nextFloat() * 0.5F;
		particleGreen = rand.nextFloat() * 0.5F + 0.5F;
		particleBlue = 0;
		
	}
	
	@Override
	public void onUpdate() {
		super.onUpdate();
		
		particleScale = (1 - (float)particleAge / particleMaxAge * 2);
		
	}
	
	public int getFXLayer() {
		return 1;
	}
}
