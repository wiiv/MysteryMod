package com.wiiv.mysterymod.init;

import com.wiiv.mysterymod.mysteryMod;
import com.wiiv.mysterymod.entities.EntityBomb;
import com.wiiv.mysterymod.entities.EntityDroid;

import cpw.mods.fml.common.registry.EntityRegistry;

public class EntitiesMMInit {
	
	public static void init() {
		//EntityRegistry.registerModEntity(EntitySpaceship.class, "EntitySpaceship", 0, mysteryMod.instance, 80, 3, true);
		EntityRegistry.registerModEntity(EntityBomb.class, "EntityBomb", 1, mysteryMod.instance, 80, 3, true);
		EntityRegistry.registerModEntity(EntityDroid.class, "EntityDroid", 2, mysteryMod.instance, 80, 3, true);
	}

}
