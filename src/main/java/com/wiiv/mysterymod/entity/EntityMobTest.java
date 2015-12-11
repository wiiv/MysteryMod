package com.wiiv.mysterymod.entity;

import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.ai.EntityAIFollowParent;
import net.minecraft.entity.ai.EntityAIPanic;
import net.minecraft.entity.ai.EntityAITempt;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.init.Items;
import net.minecraft.world.World;


public class EntityMobTest extends EntityAnimal{

	public EntityMobTest(World world) {
	
		super(world);
		setSize(1, 2);
		preventEntitySpawning = true;
		this.tasks.addTask(0, new EntityAIWander(this, 0.5D));
		this.tasks.addTask(1, new EntityAIPanic(this, 1.0D));
		this.tasks.addTask(2, new EntityAITempt(this, 1.0D, Items.iron_ingot, false));
		this.tasks.addTask(3, new EntityAIFollowParent(this, 0.5D));
	}
	
	public EntityMobTest(World world, double x, double y, double z) {
		
		this(world);
		setPosition(x, y, z);
	}
	
	@Override
	public boolean isAIEnabled(){
		
		return true;
	}

	@Override
	public EntityAgeable createChild(EntityAgeable entity) {

		return new EntityMobTest(worldObj);
	}
	
}
