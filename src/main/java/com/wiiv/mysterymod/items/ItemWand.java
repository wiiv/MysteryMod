package com.wiiv.mysterymod.items;

import java.util.List;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

import com.wiiv.mysterymod.reference.ItemsMM;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemWand extends ItemMMGeneric {
	
	@SideOnly(Side.CLIENT)
	private IIcon chargedIcon;

	public ItemWand() {
		super();
		//setCreativeTab(TabsWIIV.tabItems);
		setCreativeTab(CreativeTabs.tabMisc);
		setMaxStackSize(1);
		setUnlocalizedName(ItemsMM.UNLOCALIZED_WAND_NAME);
		setMaxDamage(10);
	}
	
	@Override
	public boolean itemInteractionForEntity(ItemStack itemStack, EntityPlayer player, EntityLivingBase target){
		
		if(!target.worldObj.isRemote){
			
			target.motionY = 2;
		
			if (isCharged(itemStack.getItemDamage())){
				target.motionX = (target.posX - player.posX) * 2;
				target.motionZ = (target.posZ - player.posZ) * 2;
				
				itemStack.setItemDamage(0);
				player.worldObj.playSoundAtEntity(target, "example:wand", 0.4F, 0.8F);
				
			}else{
				itemStack.setItemDamage(itemStack.getItemDamage() + 1);
				player.worldObj.playSoundAtEntity(target, "example:wand", 0.2F, 0.4F);
			}
		}	
		
		return false;
	}
	
	@Override	
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister register){
		itemIcon = register.registerIcon(ItemsMM.TEXTURE_LOCATION + ":" + ItemsMM.WAND_ICON);
		chargedIcon = register.registerIcon(ItemsMM.TEXTURE_LOCATION + ":" + ItemsMM.WAND_CHARGED_ICON);
		
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack itemstack, EntityPlayer player, List info, boolean useExtraInformation){
		info.add("this has been used " + itemstack.getItemDamage() + " times");
		
		if (isCharged(itemstack.getItemDamage())) {
			info.add("this item is charged");
		}
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIconFromDamage(int dmg){
		if (isCharged(dmg)){
			return chargedIcon;
		}else{
			return itemIcon;
		}
	}
	
	private boolean isCharged(int dmg){
		return dmg <= 10;
	}
	
	@Override
	public boolean isFull3D() {
		return true;
	}
	
	/*
	@Override
	@SideOnly(Side.CLIENT)
	public boolean onItemUseFirst(ItemStack itemstack, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ){
		if(!world.isRemote && player.isSneaking()) {
			
			EntitySpaceship ship = new EntitySpaceship();
			
			if(side == 1) {
				ship.posX = x + 0.5F;
				ship.posY = y + 1.5F;
				ship.posZ = z + 0.5F;
				
				if(isCharged(itemstack.getItemDamage())) {
					ship.setCharged();
					
					itemstack.setItemDamage(0);
				}else{
					itemstack.setItemDamage(itemstack.getItemDamage() + 1);
					}
				world.spawnEntityInWorld(ship);
			}
			return true;
			
		}else{ 
			
			return false;
		}
	}*/
}
