package com.wiiv.mysterymod.items;

import java.util.List;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

import com.wiiv.mysterymod.init.BlocksMMInit;
import com.wiiv.mysterymod.reference.BlocksMM;
import com.wiiv.mysterymod.reference.ItemsMM;
import com.wiiv.mysterymod.tabs.TabsMMGeneric;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
//import example.blocks.BlockInfo;
//import example.tabs.TabsWIIV;

public class ItemPrism extends ItemMMGeneric {
	
	/*
	 * @SideOnly(Side.CLIENT) private Icon itemOverlay[];
	 */
	
	@SideOnly(Side.CLIENT)
	private IIcon itemOverlay;
	
	public ItemPrism() {
	
		super();
		
		setCreativeTab(TabsMMGeneric.tabMiscellaneous);
		setMaxStackSize(1);
		setUnlocalizedName(ItemsMM.UNLOCALIZED_PRISM_NAME);
		setHasSubtypes(true);
		setMaxDamage(0);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister register) {
	
		itemIcon = register.registerIcon(ItemsMM.TEXTURE_LOCATION + ":"
				+ ItemsMM.PRISM_ICON);
		// for (int i = 0; i < ItemsMM.PRISM_ICON_BENDING_COLORS.length; i++) {
		// itemOverlay[i] = register.registerIcon(ItemsMM.TEXTURE_LOCATION + ":"
		// + ItemsMM.PRISM_ICON + ItemsMM.PRISM_ICON_BENDING_COLORS +
		// "_overlay");
		itemOverlay = register.registerIcon(ItemsMM.TEXTURE_LOCATION + ":"
				+ ItemsMM.PRISM_ICON + "_overlay");
	}
	
	@Override
	public IIcon getIconFromDamageForRenderPass(int dmg, int renderpass) {
	
		return renderpass == 0 ? itemIcon : itemOverlay;
	}
	
	public static int calcPrismBendingColor(int i) {
	
		i = 3694022;
		return i;
	}
	
	/*
	 * @SideOnly(Side.CLIENT) public int getColorFromDamage(int color) { int
	 * prismcolor = calcPrismBendingColor(c); return prismcolor; }
	 */
	
	@Override
	@SideOnly(Side.CLIENT)
	public boolean requiresMultipleRenderPasses() {
	
		return true;
	}
	
	/*
	 * @Override
	 * 
	 * @SideOnly(Side.CLIENT) public void getSubItems(Item id, CreativeTabs tab,
	 * List list) { for (int i = 0; i < BlocksMM.RAINBOW_COLORS.length; ++i) {
	 * list.add(new ItemStack(this, 1, i)); } }
	 */
	@Override
	@SideOnly(Side.CLIENT)
	public boolean onItemUseFirst(ItemStack itemstack, EntityPlayer player,
			World world, int x, int y, int z, int side, float hitX, float hitY,
			float hitZ) {
	
		if (!world.isRemote && world.getBlock(x, y, z) == BlocksMMInit.rainbow) {
			
			int meta = world.getBlockMetadata(x, y, z);
			
			int color = itemstack.getItemDamage();
			int newMeta = color * 2;
			
			world.setBlockMetadataWithNotify(x, y, z, newMeta, 3);
			
			return true;
		}
		else {
			return false;
		}
	}
	
	@Override
	public ItemStack onItemRightClick(ItemStack itemstack, World world,
			EntityPlayer player) {
	
		if (player.isSneaking()) {
			
			int dmg = itemstack.getItemDamage() + 1;
			
			if (dmg == 8) {
				itemstack.setItemDamage(0);
				world.playSoundAtEntity(player, "random.orb", 0.4F, 0.8F);
			}
			else {
				itemstack.setItemDamage(dmg);
				world.playSoundAtEntity(player, "random.orb", 0.2F, 0.4F);
			}
		}
		return itemstack;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack itemstack, EntityPlayer player,
			List info, boolean useExtraInformation) {
	
		int dmg = itemstack.getItemDamage();
		
		if (dmg == 8) {
			info.add("The " + ItemsMM.UNLOCALIZED_PRISM_NAME.toUpperCase()
					+ " will bend light to color "
					+ BlocksMM.RAINBOW_COLORS[0].toUpperCase());
		}
		else {
			info.add("The " + ItemsMM.UNLOCALIZED_PRISM_NAME.toUpperCase()
					+ " will bend light to color "
					+ BlocksMM.RAINBOW_COLORS[dmg].toUpperCase());
		}
	}
}
