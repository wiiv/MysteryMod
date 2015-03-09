package com.wiiv.mysterymod.item;

import java.util.List;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

import com.wiiv.mysterymod.init.BlocksMMInit;
import com.wiiv.mysterymod.reference.ItemsMM;
import com.wiiv.mysterymod.tabs.TabsMMGeneric;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemCard extends ItemMMGeneric {
	
	@SideOnly(Side.CLIENT)
	private IIcon[] icons;
	
	public ItemCard() {
	
		super();
		
		setCreativeTab(TabsMMGeneric.tabItems);
		setMaxStackSize(1);
		setUnlocalizedName(ItemsMM.UNLOCALIZED_CARD_NAME);
		setHasSubtypes(true);
		setMaxDamage(0);
	}
	
	@Override
	public String getUnlocalizedName(ItemStack itemstack) {
	
		switch (itemstack.getItemDamage()) {
		
			case 0:
				return getUnlocalizedName() + ItemsMM.UNLOCALIZED_CARD_NAMES[0];
			case 1:
				return getUnlocalizedName() + ItemsMM.UNLOCALIZED_CARD_NAMES[1];
			case 2:
				return getUnlocalizedName() + ItemsMM.UNLOCALIZED_CARD_NAMES[2];
			case 3:
				return getUnlocalizedName() + ItemsMM.UNLOCALIZED_CARD_NAMES[3];
			case 4:
				return getUnlocalizedName() + ItemsMM.UNLOCALIZED_CARD_NAMES[4];
			default:
				return ItemsMM.UNLOCALIZED_CARD_NAME;
		}
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister register) {
	
		icons = new IIcon[ItemsMM.CARD_ICONS.length];
		for (int i = 0; i < icons.length; i++) {
			icons[i] = register.registerIcon(ItemsMM.TEXTURE_LOCATION + ":"
					+ ItemsMM.CARD_ICONS[i]);
		}
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIconFromDamage(int dmg) {
	
		if (dmg > 4)
			dmg = 0;
		
		return icons[dmg];
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void getSubItems(Item id, CreativeTabs tab, List list) {
	
		for (int i = 0; i < ItemsMM.UNLOCALIZED_CARD_NAMES.length; ++i) {
			list.add(new ItemStack(this, 1, i));
		}
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public boolean onItemUseFirst(ItemStack itemstack, EntityPlayer player,
			World world, int x, int y, int z, int side, float hitX, float hitY,
			float hitZ) {
	
		if (!world.isRemote && world.getBlock(x, y, z) == BlocksMMInit.machine) {
			int meta = world.getBlockMetadata(x, y, z);
			
			int disabled = meta % 2;
			int type = itemstack.getItemDamage() + 1;
			int newMeta = type * 2 + disabled;
			
			world.setBlockMetadataWithNotify(x, y, z, newMeta, 3);
			
			itemstack.stackSize--;
			
			return true;
		}
		else {
			return false;
		}
	}
	
}
