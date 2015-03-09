package com.wiiv.mysterymod.item;

import java.util.List;

import com.wiiv.mysterymod.reference.Core;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemMMGeneric extends Item{

	public ItemMMGeneric(){
		
		super();
	}
	
	@Override
    public String getUnlocalizedName()
    {
        return String.format("item.%s%s", Core.MOD_ID.toLowerCase() + ":", getUnwrappedUnlocalizedName(super.getUnlocalizedName()));
    }

    @Override
    public String getUnlocalizedName(ItemStack itemStack)
    {
        return String.format("item.%s%s", Core.MOD_ID.toLowerCase() + ":", getUnwrappedUnlocalizedName(super.getUnlocalizedName()));
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister iconRegister)
    {
        itemIcon = iconRegister.registerIcon(this.getUnlocalizedName().substring(this.getUnlocalizedName().indexOf(".") + 1));
    }

    protected String getUnwrappedUnlocalizedName(String unlocalizedName)
    {
        return unlocalizedName.substring(unlocalizedName.indexOf(".") + 1);
    }

    public boolean itemInteractionForEntity(ItemStack itemStack, EntityPlayer player, World world, EntityLivingBase target) {
		// TODO Auto-generated method stub
		return false;
	}

	public void getSubItems(int id, CreativeTabs tab, List list) {
		// TODO Auto-generated method stub
		
	}
}
