package com.wiiv.mysterymod.block;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

import com.wiiv.mysterymod.client.particle.EntityPoisonFX;
import com.wiiv.mysterymod.reference.BlocksMM;
import com.wiiv.mysterymod.tabs.TabsMMGeneric;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockPoisonOre extends BlockMMGeneric {
	
	public BlockPoisonOre() {
	
		super(Material.rock);
		
		setBlockName(BlocksMM.UNLOCALIZED_POISONORE_NAME);
		setCreativeTab(TabsMMGeneric.tabBlocks);
		setHardness(1F);
		setStepSound(Block.soundTypeGravel);
	}
	
	@SideOnly(Side.CLIENT)
	public static IIcon particleIcon;
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister register) {
	
		blockIcon = register.registerIcon(BlocksMM.TEXTURE_LOCATION + ":" + BlocksMM.POISONORE_TEXTURE);
		particleIcon = register.registerIcon(BlocksMM.TEXTURE_LOCATION + ":" + BlocksMM.POISON_PARTICLE_TEXTURE);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void randomDisplayTick(World world, int x, int y, int z, Random rand) {
	
		for (int i = 0; i < 2; i++) {
			float particleX = x + rand.nextFloat();
			float particleY = y + rand.nextFloat();
			float particleZ = z + rand.nextFloat();
			
			float particleMotionX = -0.2F + rand.nextFloat();
			float particleMotionY = -0.2F + rand.nextFloat();
			float particleMotionZ = -0.2F + rand.nextFloat();
			
			Minecraft.getMinecraft().effectRenderer.addEffect(new EntityPoisonFX(world, particleX, particleY, particleZ, particleMotionX, particleMotionY, particleMotionZ));
		}
	}
}