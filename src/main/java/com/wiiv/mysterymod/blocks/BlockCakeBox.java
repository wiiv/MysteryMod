package com.wiiv.mysterymod.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

import com.wiiv.mysterymod.mysteryMod;
import com.wiiv.mysterymod.handler.GuiHandler;
import com.wiiv.mysterymod.reference.BlocksMM;
import com.wiiv.mysterymod.tabs.TabsMMGeneric;
import com.wiiv.mysterymod.tileentities.TileEntityCakeBox;

import cpw.mods.fml.common.network.internal.FMLNetworkHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockCakeBox extends BlockTileEntityMMGeneric {
	
	public BlockCakeBox() {
		super(Material.cloth);
		
		setBlockName(BlocksMM.UNLOCALIZED_CAKEBOX_NAME);
		setCreativeTab(TabsMMGeneric.tabBlocks);
		setHardness(0F);
		setStepSound(Block.soundTypeCloth);
		
		setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, (1.0F / 16.0F * 10.0F), 1.0F);
	}
	
	@SideOnly(Side.CLIENT)
	private IIcon[] cakeBoxIcons;
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister register) {
	
		cakeBoxIcons = new IIcon[BlocksMM.CAKEBOX_TEXTURES.length];
		for (int i = 0; i < cakeBoxIcons.length; i++) {
			cakeBoxIcons[i] = register.registerIcon(BlocksMM.TEXTURE_LOCATION + ":" + BlocksMM.CAKEBOX_TEXTURES[i]);
		}
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int side, int meta) {
	
		if (side == 0 || side == 1) {
			
			return cakeBoxIcons[0];
			
		}else {
			
			return cakeBoxIcons[1];
		}
	}
	
	@Override
	public boolean isOpaqueCube() {
	
		return false;
	}
	
	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ) {
	
		if (!world.isRemote) {
			
			FMLNetworkHandler.openGui(player, mysteryMod.instance, GuiHandler.GuiID.CAKE_BOX.ordinal(), world, x, y, z);
			//world.playSoundAtEntity(player, "random.click", 0.3F, 0.1F);
		}
		
		return true;
	}
	
	@Override
	public TileEntity createNewTileEntity(World world, int metadata) {
	
		return new TileEntityCakeBox();
	}
	
}
