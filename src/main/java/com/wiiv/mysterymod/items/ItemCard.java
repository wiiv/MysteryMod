package com.wiiv.mysterymod.items;

import java.util.List;

import com.wiiv.mysterymod.reference.BlocksMM;
import com.wiiv.mysterymod.reference.ItemsMM;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
//import example.blocks.BlockInfo;
//import example.tabs.TabsWIIV;

public class ItemCard extends ItemMMGeneric {
	
	@SideOnly(Side.CLIENT)
	private IIcon[] icons;

	public ItemCard() {
		super();
		//setCreativeTab(TabsWIIV.tabMiscellaneous);
		setHasSubtypes(true);
		setMaxStackSize(1);
		setUnlocalizedName(ItemsMM.UNLOCALIZED_CARD_NAME);
	}
	
	@Override
	public String getUnlocalizedName(ItemStack itemstack){
		return ItemsMM.UNLOCALIZED_CARD_NAME + itemstack.getItemDamage();
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister register) {
		icons = new IIcon[ItemsMM.CARD_ICONS.length];	
		for (int i = 0; i < icons.length; i++){
			icons[i] = register.registerIcon(ItemsMM.TEXTURE_LOCATION + ":" + ItemsMM.CARD_ICONS[i]);
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
		for (int i = 0; i < ItemInfo.CARD_NAMES.length; i++) {
			ItemStack stack = new ItemStack(id, 1, i);
			list.add(stack);
		}
	}*/
	
	@Override
	@SideOnly(Side.CLIENT)
	public boolean onItemUseFirst(ItemStack itemstack, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ){
		if(!world.isRemote && world.getBlockMetadata(x, y, z) == BlocksMM.MACHINE_ID){
			int meta = world.getBlockMetadata(x, y, z);
			
			int disabled =  meta % 2;
			int type = itemstack.getItemDamage() + 1;
			int newMeta = type * 2 + disabled;
			
			world.setBlockMetadataWithNotify(x, y, z, newMeta, 3);
			
			//itemstack.stackSize--;
	
			return true;
		}else{
			return false;
		}
	}
	
}
