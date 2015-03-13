package com.wiiv.mysterymod.items;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import com.wiiv.mysterymod.entity.EntityDroid;
import com.wiiv.mysterymod.reference.ItemsMM;
import com.wiiv.mysterymod.tabs.TabsMMGeneric;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemDroid extends ItemMMGeneric{
	
	public ItemDroid(){
		super();
		setCreativeTab(TabsMMGeneric.tabMiscellaneous);
		setMaxStackSize(16);
		setUnlocalizedName(ItemsMM.UNLOCALIZED_DROID_NAME);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister register) {
		itemIcon = register.registerIcon(ItemsMM.TEXTURE_LOCATION + ":" + ItemsMM.DROID_ICON);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public boolean onItemUseFirst(ItemStack itemstack, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ){
		
		if(!world.isRemote && player.isSneaking()) {
			
			world.spawnEntityInWorld(new EntityDroid(world, x + 0.5F, y + 1.5F, z + 0.5F));
			
			itemstack.stackSize--;
			
			return true;
			
		}else{ 
			
			return false;
		}
	}
}
