package com.wiiv.mysterymod.client.particle;

import net.minecraft.client.Minecraft;
import net.minecraft.world.World;

public enum Particles {
	
	POISON;
	
	public void spawnParticle(World world, double x, double y, double z, double motionX, double motionY, double motionZ){
		
		Minecraft mc = Minecraft.getMinecraft();
		
		if (mc != null && mc.renderViewEntity != null && mc.effectRenderer != null) {
			
			int particleSetting = mc.gameSettings.particleSetting;
			
			if (particleSetting == 2 ||  particleSetting == 1 && world.rand.nextInt(3) == 0) {
				return;
			}
			
			double distanceX = mc.renderViewEntity.posX - x;
			double distanceY = mc.renderViewEntity.posX - y;
			double distanceZ = mc.renderViewEntity.posX - z;
			
			double maxDistance = 16;
			
			if ((Math.pow(distanceX, 2) + Math.pow(distanceY, 2) + Math.pow(distanceZ, 2)) > Math.pow(maxDistance, 2)){
				return;
			}
			
			
		}
	}
}
