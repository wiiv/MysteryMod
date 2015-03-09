package com.wiiv.mysterymod.item;

import java.util.List;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

import com.wiiv.mysterymod.entity.EntitySpaceship;
import com.wiiv.mysterymod.reference.ItemsMM;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemWand extends ItemMMGeneric {
	
	@SideOnly(Side.CLIENT)
	private IIcon chargedIcon;

	public ItemWand() {
		
		super();
		setCreativeTab(CreativeTabs.tabMisc);
		setMaxStackSize(1);
		setUnlocalizedName(ItemsMM.UNLOCALIZED_WAND_NAME);
	}
	
	
	@Override
	public boolean itemInteractionForEntity(ItemStack itemStack, EntityPlayer player, EntityLivingBase target){
		
		if(!target.worldObj.isRemote){
			
			target.motionY = 2;
		
			if(isCharged(itemStack.getItemDamage())){
				
				target.motionX = (target.posX - player.posX) * 2;
				target.motionZ = (target.posZ - player.posZ) * 2;
				player.worldObj.playSoundAtEntity(target, "mm:wand", 0.4F, 0.8F);
				
				itemStack.setItemDamage(0);
				
			}else{

				player.worldObj.playSoundAtEntity(target, "mm:wand", 0.2F, 0.4F);
				
				itemStack.setItemDamage(itemStack.getItemDamage() + 1);
			}
			return true;
			
		}else{	
		
			return false;
		}
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
		return dmg >= 10;
	}
	
	@Override
	public boolean isFull3D() {
		return true;
	}
	
	
	@Override
	@SideOnly(Side.CLIENT)
	public boolean onItemUseFirst(ItemStack itemstack, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ){

		if(!world.isRemote && player.isSneaking()) {
			
			EntitySpaceship ship = new EntitySpaceship(world);
			
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
	}
}
