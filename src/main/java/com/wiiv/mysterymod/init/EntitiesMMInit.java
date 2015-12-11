package com.wiiv.mysterymod.init;

import com.wiiv.mysterymod.mysteryMod;
import com.wiiv.mysterymod.entity.EntityBomb;
import com.wiiv.mysterymod.entity.EntityDroid;
import com.wiiv.mysterymod.entity.EntityMobTest;
import com.wiiv.mysterymod.entity.EntitySpaceship;

import cpw.mods.fml.common.registry.EntityRegistry;

public class EntitiesMMInit {
	
	static int ModEntityID;
	
	public static void init() {
		
		ModEntityID = EntityRegistry.findGlobalUniqueEntityId();
		
		EntityRegistry.registerModEntity(EntitySpaceship.class, "EntitySpaceship", ModEntityID, mysteryMod.instance, 80, 3, true);
		EntityRegistry.registerModEntity(EntityBomb.class, "EntityBomb", ModEntityID++, mysteryMod.instance, 80, 3, true);
		EntityRegistry.registerModEntity(EntityDroid.class, "EntityDroid", ModEntityID++, mysteryMod.instance, 80, 3, true);
		
		EntityRegistry.registerModEntity(EntityMobTest.class, "EntityMobTest", ModEntityID++, mysteryMod.instance, 80, 3, true);
	}

}
