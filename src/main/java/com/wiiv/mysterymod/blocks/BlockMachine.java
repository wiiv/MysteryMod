package com.wiiv.mysterymod.blocks;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.IIcon;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import com.wiiv.mysterymod.mysteryMod;
import com.wiiv.mysterymod.reference.BlocksMM;
import com.wiiv.mysterymod.tabs.TabsMMGeneric;
import com.wiiv.mysterymod.tileentities.TileEntityMachine;

import cpw.mods.fml.common.network.internal.FMLNetworkHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockMachine extends BlockTileEntityMMGeneric {
	
	public BlockMachine() {
	
		super(Material.iron);
		
		setBlockName(BlocksMM.UNLOCALIZED_MACHINE_NAME);
		setCreativeTab(TabsMMGeneric.tabBlocks);
		setHardness(2F);
		setStepSound(Block.soundTypeMetal);
	}
	
	@SideOnly(Side.CLIENT)
	private IIcon topIcon;
	@SideOnly(Side.CLIENT)
	private IIcon botIcon;
	@SideOnly(Side.CLIENT)
	private IIcon[] sideIcons;
	@SideOnly(Side.CLIENT)
	private IIcon disabledIcon;
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister register) {
	
		topIcon = register.registerIcon(BlocksMM.TEXTURE_LOCATION + ":" + BlocksMM.MACHINE_TOP);
		botIcon = register.registerIcon(BlocksMM.TEXTURE_LOCATION + ":" + BlocksMM.MACHINE_BOT);
		sideIcons = new IIcon[BlocksMM.MACHINE_SIDES.length];
		for (int i = 0; i < sideIcons.length; i++) {
			sideIcons[i] = register.registerIcon(BlocksMM.TEXTURE_LOCATION + ":" + BlocksMM.MACHINE_SIDES[i]);
		}
		disabledIcon = register.registerIcon(BlocksMM.TEXTURE_LOCATION + ":" + BlocksMM.MACHINE_DISABLED);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int side, int meta) {
	
		if (side == 0) {
			return botIcon;
		}
		else if (side == 1) {
			return isDisabled(meta) ? disabledIcon : topIcon;
		}
		else {
			int type = meta / 2;
			return sideIcons[type];
		}
	}
	
	private boolean isDisabled(int meta) {
	
		return meta % 2 == 1;
	}
	
	@Override
	public void onEntityWalking(World world, int x, int y, int z, Entity entity) {
	
		if (!world.isRemote && !isDisabled(world.getBlockMetadata(x, y, z))) {
			
			TileEntity te = world.getTileEntity(x, y, z);
			
			if (te != null && te instanceof TileEntityMachine) {
				
				TileEntityMachine machine = (TileEntityMachine) te;
				
				spawnAnvil(world, machine, x, y + 20, z);
			}
		}
	}
	
	@Override
	public void onNeighborBlockChange(World world, int x, int y, int z, Block id) {
	
		int meta = world.getBlockMetadata(x, y, z);
		
		if (!world.isRemote && world.isBlockIndirectlyGettingPowered(x, y, z) && !isDisabled(meta)) {
			
			TileEntity te = world.getTileEntity(x, y, z);
			
			if (te != null && te instanceof TileEntityMachine) {
				
				TileEntityMachine machine = (TileEntityMachine) te;
				
				switch (meta / 2) {
				
					case 0:
						
						for (int i = -2; i <= 2; i++) {
							
							for (int j = -2; j <= 2; j++) {
								
								spawnAnvil(world, machine, x + i, y + 20, z + j);
							}
						}
						break;
					
					case 1:
						
						for (int i = 0; i < 5; i++) {
							
							spawnAnvil(world, machine, x, y + 20 + i, z);
						}
						break;
					
					case 2:
						
						for (int i = -1; i <= 1; i++) {
							
							spawnAnvil(world, machine, x + i, y + 20, z - 2);
							spawnAnvil(world, machine, x + i, y + 20, z + 2);
							spawnAnvil(world, machine, x - 2, y + 20, z + i);
							spawnAnvil(world, machine, x + 2, y + 20, z + i);
						}
						break;
					
					case 3:
						
						for (int i = 1; i <= 3; i++) {
							
							spawnAnvil(world, machine, x + i, y + 20, z);
							spawnAnvil(world, machine, x - i, y + 20, z);
							spawnAnvil(world, machine, x, y + 20, z + i);
							spawnAnvil(world, machine, x, y + 20, z - i);
						}
						break;
					
					case 4:
						
						for (int i = 0; i < machine.customSetup.length; i++) {
							
							if (machine.customSetup[i]) {
								
								int dropX = x + i / 5 - 2;
								int dropZ = z + i % 5 - 2;
								
								spawnAnvil(world, machine, dropX, y + 20, dropZ);
							}
						}
						
						break;
				}
				
			}
		}
	}
	
	private void spawnAnvil(World world, IInventory inventory, int x, int y,
			int z) {
	
		if (world.isAirBlock(x, y, z)) {
			
			for (int i = 0; i < inventory.getSizeInventory(); i++) {
				
				ItemStack itemstack = inventory.getStackInSlot(i);
				
				if (itemstack != null && itemstack.equals(Blocks.anvil)) {
					
					inventory.decrStackSize(i, 1);
					world.setBlock(x, y, z, Blocks.anvil);
					
					return;
				}
			}
		}
	}
	
	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ) {
	
		if (!world.isRemote) {
			
			FMLNetworkHandler.openGui(player, mysteryMod.instance, 0, world, x, y, z);
		}
		return true;
	}
	
	@Override
	public int damageDropped(int meta) {
	
		return meta;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void getSubBlocks(Item id, CreativeTabs tab, List list) {
	
		for (int i = 0; i < BlocksMM.MACHINE_SIDES.length; i++) {
			list.add(new ItemStack(id, 1, i * 2));
		}
	}
	
	@Override
	public void breakBlock(World world, int x, int y, int z, Block id, int meta) {
	
		TileEntity TEMachine = world.getTileEntity(x, y, z);
		
		if (TEMachine != null && TEMachine instanceof IInventory) {
			IInventory inventory = (IInventory) TEMachine;
			
			for (int i = 0; i < inventory.getSizeInventory(); i++) {
				ItemStack itemstack = inventory.getStackInSlotOnClosing(i);
				
				if (itemstack != null) {
					float spawnX = x + world.rand.nextFloat();
					float spawnY = y + world.rand.nextFloat();
					float spawnZ = z + world.rand.nextFloat();
					
					Entity droppedItem = new EntityItem(world, spawnX, spawnY, spawnZ, itemstack);
					
					float mult = 0.05F;// decrease motion
					
					droppedItem.motionX = (-0.5F + world.rand.nextFloat()) * mult;
					droppedItem.motionY = (4.0F + world.rand.nextFloat()) * mult;
					droppedItem.motionZ = (-0.5F + world.rand.nextFloat()) * mult;
					
					world.spawnEntityInWorld(droppedItem);
				}
			}
		}
		
		super.breakBlock(world, x, y, y, id, meta);
	}
	
	@Override
	public void setBlockBoundsBasedOnState(IBlockAccess world, int x, int y,
			int z) {
	
		if (world.getBlockMetadata(x, y, z) % 2 == 0) {
			
			setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);// enabled
			
		}
		else {
			
			setBlockBounds(0.25F, 0.25F, 0.25F, 0.75F, 0.75F, 0.75F);// disabled
		}
	}
	
	@Override
	public boolean isOpaqueCube() {
	
		return false;
	}
	
	// bounding box calculations
	
	@Override
	public AxisAlignedBB getSelectedBoundingBoxFromPool(World world, int x, int y, int z) {
	
		setBlockBoundsBasedOnState(world, x, y, z);
		
		return super.getSelectedBoundingBoxFromPool(world, x, y, z);
	}
	
	@Override
	public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int x, int y, int z) {
	
		setBlockBoundsBasedOnState(world, x, y, z);
		
		return super.getSelectedBoundingBoxFromPool(world, x, y, z);
	}
	
	@Override
	public MovingObjectPosition collisionRayTrace(World world, int x, int y, int z, Vec3 start, Vec3 end) {
	
		setBlockBoundsBasedOnState(world, x, y, z);
		
		return super.collisionRayTrace(world, x, y, z, start, end);
	}
	
	@Override
	public void setBlockBoundsForItemRender() {
	
		// if(world.getBlockMetadata(x, y, z) % 2 == 0) {
		
		setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);// enabled
		
		// }else {
		
		// setBlockBounds(0.25F, 0.25F, 0.25F, 0.75F, 0.75F, 0.75F);//disbled
		// }
	}
	
	@Override
	public TileEntity createNewTileEntity(World world, int id) {

		return new TileEntityMachine();
	}
}
