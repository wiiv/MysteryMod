package com.wiiv.mysterymod.blocks;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

import com.wiiv.mysterymod.reference.BlocksMM;
import com.wiiv.mysterymod.tabs.TabsMMGeneric;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockRainbow extends BlockMMGeneric {
	
	public BlockRainbow() {
	
		super(Material.cloth);
		
		setBlockName(BlocksMM.UNLOCALIZED_RAINBOW_NAME);
		setCreativeTab(TabsMMGeneric.tabMiscellaneous);
		setHardness(0.4F);
		setStepSound(Block.soundTypeCloth);
	}
	
	@SideOnly(Side.CLIENT)
	private IIcon[] rainbowColorIcons;
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister register) {
	
		rainbowColorIcons = new IIcon[BlocksMM.RAINBOW_COLORS.length * 2];
		for (int i = 0; i < BlocksMM.RAINBOW_COLORS.length; i++) {
			rainbowColorIcons[i * 2] = register.registerIcon(BlocksMM.TEXTURE_LOCATION + ":" + BlocksMM.RAINBOW_TEXTURE + BlocksMM.RAINBOW_COLORS[i].toLowerCase());
			rainbowColorIcons[(i * 2) + 1] = register.registerIcon(BlocksMM.TEXTURE_LOCATION + ":" + BlocksMM.RAINBOW_TEXTURE + BlocksMM.RAINBOW_FADING_TEXTURE + BlocksMM.RAINBOW_COLORS[i].toLowerCase());
		}
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int side, int meta) {
	
		return rainbowColorIcons[meta];
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void getSubBlocks(Item id, CreativeTabs tab, List list) {
	
		for (int i = 0; i < BlocksMM.RAINBOW_COLORS.length; i++) {
			list.add(new ItemStack(id, 1, i * 2));
		}
	}
	
	@Override
	public int damageDropped(int meta) {
	
		return meta;
	}
	
	@Override
	public boolean onBlockActivated(World world, int x, int y, int z,
			EntityPlayer player, int side, float hitX, float hitY, float hitZ) {
	
		if (!world.isRemote) {
			int meta = world.getBlockMetadata(x, y, z);
			
			int type = meta / 2;
			int state = meta % 2 == 0 ? 1 : 0;
			int newMeta = type * 2 + state;
			
			world.setBlockMetadataWithNotify(x, y, z, newMeta, 3);
		}
		return true;
	}
	
	/*
	@Override
	public int getExpDrop(World world, int data, int enchantmentLevel){ 
		int exp = 0; 
		if (this.getIdFromBlock(this) == BlocksMM.RAINBOW_ID){ 
			exp = MathHelper.getRandomIntegerInRange(world.rand, 4, 9); 
			} 
	 	return exp; 
	 }
	*/
}
