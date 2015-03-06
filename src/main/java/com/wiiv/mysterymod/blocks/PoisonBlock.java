package com.wiiv.mysterymod.blocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

import com.wiiv.mysterymod.client.particles.EntityPoisonFX;
import com.wiiv.mysterymod.reference.BlocksMM;
import com.wiiv.mysterymod.tabs.TabsMMGeneric;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class PoisonBlock extends BlockMMGeneric {
	
	public PoisonBlock() {
	
		super(Material.rock);
		
		setBlockName(BlocksMM.UNLOCALIZED_POISONBLOCK_NAME);
		setCreativeTab(TabsMMGeneric.tabBlocks);
		setHardness(1F);
		setStepSound(Block.soundTypeGravel);
	}
	
	@SideOnly(Side.CLIENT)
	public static IIcon particleIcon;
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister register) {
	
		blockIcon = register.registerIcon(BlocksMM.TEXTURE_LOCATION + ":" + BlocksMM.POISONBLOCK_TEXTURE);
		particleIcon = register.registerIcon(BlocksMM.TEXTURE_LOCATION + ":" + BlocksMM.POISON_PARTICLE_TEXTURE);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void randomDisplayTick(World world, int x, int y, int z, Random rand) {
	
		for (int i = 0; i < 4; i++) {
			float particleX = x + rand.nextFloat();
			float particleY = y + rand.nextFloat();
			float particleZ = z + rand.nextFloat();
			
			float particleMotionX = -0.5F + rand.nextFloat();
			float particleMotionY = -0.5F + rand.nextFloat();
			float particleMotionZ = -0.5F + rand.nextFloat();
			
			Minecraft.getMinecraft().effectRenderer.addEffect(new EntityPoisonFX(world, particleX, particleY, particleZ, particleMotionX, particleMotionY, particleMotionZ));
		}
	}
	
	/*
	@Override
	public void onBlockClicked(World world, int x, int y, int z, EntityPlayer player) {
	
		if (!world.isRemote) {
			player.addPotionEffect(new PotionEffect(Potion.poison.id, 40, 1));
		}
	}
	*/
}