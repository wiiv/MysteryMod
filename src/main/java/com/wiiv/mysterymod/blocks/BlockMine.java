package com.wiiv.mysterymod.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import com.wiiv.mysterymod.reference.BlocksMM;
import com.wiiv.mysterymod.tabs.TabsMMGeneric;
import com.wiiv.mysterymod.tileentities.TileEntityMine;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;


public class BlockMine extends BlockTileEntityMMGeneric {

	public BlockMine() {
		super(Material.iron);
		
		setBlockName(BlocksMM.UNLOCALIZED_MINE_NAME);
		setCreativeTab(TabsMMGeneric.tabBlocks);
		setHardness(2F);
		setStepSound(Block.soundTypeMetal);
		
		setBlockBounds(1.0F / 16.0F * 2.0F, 0.0F, 1.0F / 16.0F * 2.0F, 1.0F - (1.0F / 16.0F * 2.0F), 1.0F - (1.0F / 16.0F * 14.0F), 1.0F - (1.0F / 16.0F * 2.0F));
	}
	
	@SideOnly(Side.CLIENT)
	private IIcon[] mineIcons;
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister register) {
	
		mineIcons = new IIcon[BlocksMM.MINE_TEXTURES.length];
		for (int i = 0; i < mineIcons.length; i++) {
			mineIcons[i] = register.registerIcon(BlocksMM.TEXTURE_LOCATION + ":" + BlocksMM.MINE_TEXTURES[i]);
		}
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int side, int meta) {
	
		if (side == 0) {
			return mineIcons[0];
		}
		else if (side == 1) {
			return mineIcons[1];
		}
		else {
			return mineIcons[2];
		}
	}
	
	//returns the texture of the camouflage or the default texture
	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(IBlockAccess world, int x, int y, int z, int side) {
	
		TileEntityMine TEMine = (TileEntityMine)world.getTileEntity(x, y, z);
		
		ItemStack stack = TEMine.getCamouflage();
		
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
	
			TileEntityMine TEMine = (TileEntityMine)world.getTileEntity(x, y, z);
			
			if(TEMine.getCamouflage() != null) {
				
				ItemStack camoStack = TEMine.getCamouflage();
				TEMine.setCamouflage(null);
				
				EntityItem itemEntity = new EntityItem(world, x + 0.5F, y + 0.5F, z + 0.5F, camoStack);
				world.spawnEntityInWorld(itemEntity);
						
			}else {
			
				ItemStack playerItem = player.getCurrentEquippedItem();
				
				if( playerItem != null) {
	
					ItemStack camoStack = playerItem.splitStack(1);
					TEMine.setCamouflage(camoStack);
				}
			}
		}
		
		return true;
	}
	
	@Override
	public boolean isOpaqueCube() {
		
		return false;
	}
	
	@Override
	public boolean getUseNeighborBrightness() {
		
        return true;
    }
	
	
	@Override
	public TileEntity createNewTileEntity(World world, int metadata) {
		
		return new TileEntityMine();
	}
}
