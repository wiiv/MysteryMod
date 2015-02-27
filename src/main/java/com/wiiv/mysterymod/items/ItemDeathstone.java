package com.wiiv.mysterymod.items;

import java.util.List;

import com.wiiv.mysterymod.reference.ItemsMM;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.entity.monster.EntityPigZombie;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
//import example.tabs.TabsWIIV;

public class ItemDeathstone extends ItemMMGeneric {
	
	@SideOnly(Side.CLIENT)
	private IIcon[] icons;
	
	public ItemDeathstone() {
		super();
		setCreativeTab(CreativeTabs.tabRedstone);
		setHasSubtypes(true);
		this.setUnlocalizedName(ItemsMM.UNLOCALIZED_DEATHSTONE_NAME);
	}
	
	
	public boolean onItemUse(ItemStack itemstack, EntityPlayer player, World world, int x, int y, int z, int par7, float par8, float par9, float par10)
    {
        return false;
    }
	
	public boolean hitEntity(ItemStack itemstack, EntityLivingBase target, EntityLivingBase targetEntity){
		
		
		int meta = itemstack.getItemDamage();
		
		if(!target.worldObj.isRemote){
		if (target instanceof EntityPlayer && meta == 0) {
			target.setHealth(0);
		}else if(target instanceof EntityCreeper && meta == 1){
			target.setHealth(0);
		}else if(target instanceof EntityEnderman && meta == 2){
			target.setHealth(0);
		}else if(target instanceof EntityPigZombie && meta == 3){ 
			target.setHealth(0);
		}else if(target instanceof EntitySkeleton && meta == 4){ 
			target.setHealth(0);
		}
		itemstack.damageItem(1, targetEntity);
		}
		return false;
	}
	
	@Override
	public String getUnlocalizedName(ItemStack itemstack){
		return ItemsMM.UNLOCALIZED_DEATHSTONE_NAME + itemstack.getItemDamage();
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister register) {
		icons = new IIcon[ItemsMM.DEATHSTONE_ICONS.length];
		
		for (int i = 0; i < icons.length; i++){
			icons[i] = register.registerIcon(ItemsMM.TEXTURE_LOCATION + ":" + ItemsMM.DEATHSTONE_ICONS[i]);
		}
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIconFromDamage(int dmg) {
		return icons[dmg];	
	}
	
	/*@Override
	@SideOnly(Side.CLIENT)
	public void getSubItems(int id, CreativeTabs tab, List list) {
		
		for (int i = 0; i < ItemsMM.DEATHSTONE_NAMES.length; i++) {
			ItemStack stack = new ItemStack(id, 1, i);
			list.add(stack);
		}
	}*/
	
	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack itemstack, EntityPlayer player, List info, boolean useExtraInformation){
		
		int dmg = itemstack.getItemDamage();
		
		if (dmg == 4) {
		info.add("to get " + ItemsMM.DEATHSTONE_NAMES[0] + " put this in a crafting area");
		}else{
			info.add("to get " + ItemsMM.DEATHSTONE_NAMES[dmg + 1] + " put this in a crafting area");
		}
	}
	
	

}
