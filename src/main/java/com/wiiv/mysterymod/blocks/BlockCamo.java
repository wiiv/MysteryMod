package com.wiiv.mysterymod.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import com.wiiv.mysterymod.mysteryMod;
import com.wiiv.mysterymod.handler.GuiHandler;
import com.wiiv.mysterymod.reference.BlocksMM;
import com.wiiv.mysterymod.tabs.TabsMMGeneric;
import com.wiiv.mysterymod.tileentities.TileEntityCamo;

import cpw.mods.fml.common.network.internal.FMLNetworkHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;


public class BlockCamo extends BlockTileEntityMMGeneric {

	public BlockCamo() {
		super(Material.iron);
		
		setBlockName(BlocksMM.UNLOCALIZED_CAMO_NAME);
		setCreativeTab(TabsMMGeneric.tabBlocks);
		setHardness(2F);
		setStepSound(Block.soundTypeMetal);
	}
	
	@SideOnly(Side.CLIENT)
	private IIcon camoIcon;
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister register) {
	
		camoIcon = register.registerIcon(BlocksMM.TEXTURE_LOCATION + ":" + BlocksMM.CAMO_TEXTURE);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int side, int meta) {
		
		return camoIcon;
	}
	
	//returns the texture of the camouflage or the default texture
	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(IBlockAccess world, int x, int y, int z, int side) {
	
		TileEntityCamo TECamo = (TileEntityCamo)world.getTileEntity(x, y, z);
		
		ItemStack stack = TECamo.getCamouflage(side);
		
		if(stack != null && stack.getItem() instanceof ItemBlock) {
			
			Block block = ((ItemBlock)stack.getItem()).field_150939_a;
			
			return block.getIcon(side, stack.getItemDamage());
			
		}else {
			
			return super.getIcon(world, x, y, z, side);
		}
	}
	
	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ) {
		
		if(!world.isRemote) {
	/*
			TileEntityCamo TECamo = (TileEntityCamo)world.getTileEntity(x, y, z);
			
			if(TECamo.getCamouflage(side) != null) {
				
				ItemStack camoStack = TECamo.getCamouflage(side);
				TECamo.setCamouflage(side, null);
				
				EntityItem itemEntity = new EntityItem(world, x + 0.5F, y + 1.25F, z + 0.5F, camoStack);
				world.spawnEntityInWorld(itemEntity);
						
			}else {
			
				ItemStack playerItem = player.getCurrentEquippedItem();
				
				if( playerItem != null) {
	
					ItemStack camoStack = playerItem.splitStack(1);
					TECamo.setCamouflage(side, camoStack);
				}
			}*/
			FMLNetworkHandler.openGui(player, mysteryMod.instance, GuiHandler.GuiID.CAMO.ordinal(), world, x, y, z);
		}
		
		return true;
	}
	
	@Override
	public boolean getUseNeighborBrightness() {
		
        return true;
    }
	
	@Override
	public TileEntity createNewTileEntity(World world, int metadata) {
		
		return new TileEntityCamo();
	}
}
