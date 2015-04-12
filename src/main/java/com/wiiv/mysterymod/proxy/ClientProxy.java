package com.wiiv.mysterymod.proxy;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraftforge.client.MinecraftForgeClient;

import com.wiiv.mysterymod.client.model.ModelDroid;
import com.wiiv.mysterymod.client.renderer.block.RenderBlockMachine;
import com.wiiv.mysterymod.client.renderer.entity.RenderBomb;
import com.wiiv.mysterymod.client.renderer.entity.RenderDroid;
import com.wiiv.mysterymod.client.renderer.entity.RenderSpaceship;
import com.wiiv.mysterymod.client.renderer.item.RenderItemDroid;
import com.wiiv.mysterymod.client.renderer.itemblocks.RenderItemBlockAlembic;
import com.wiiv.mysterymod.client.renderer.itemblocks.RenderItemBlockChandelier;
import com.wiiv.mysterymod.client.renderer.tileentity.RenderAlembicTileEntity;
import com.wiiv.mysterymod.client.renderer.tileentity.RenderChandelierTileEntity;
import com.wiiv.mysterymod.client.renderer.tileentity.RenderPumpTileEntity;
import com.wiiv.mysterymod.entity.EntityBomb;
import com.wiiv.mysterymod.entity.EntityDroid;
import com.wiiv.mysterymod.entity.EntitySpaceship;
import com.wiiv.mysterymod.init.BlocksMMInit;
import com.wiiv.mysterymod.init.ItemsMMInit;
import com.wiiv.mysterymod.reference.BlocksMM;
import com.wiiv.mysterymod.reference.KeysMM;
import com.wiiv.mysterymod.tileentities.TileEntityAlembic;
import com.wiiv.mysterymod.tileentities.TileEntityChandelier;
import com.wiiv.mysterymod.tileentities.TileEntityPump;

import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;

public class ClientProxy extends CommonProxy{

	@Override
	public void initRenders() {
		
		RenderingRegistry.registerEntityRenderingHandler(EntitySpaceship.class, new RenderSpaceship());
		
		ModelDroid model = new ModelDroid();
		RenderingRegistry.registerEntityRenderingHandler(EntityDroid.class, new RenderDroid(model));
		MinecraftForgeClient.registerItemRenderer(ItemsMMInit.droid, new RenderItemDroid(model));
		
		//machine block
		
		RenderBlockMachine machineRender =  new RenderBlockMachine();
		BlocksMM.MACHINE_RENDER_ID = machineRender.getRenderId();
		RenderingRegistry.registerBlockHandler(machineRender);
		
		//bomb entity
		RenderingRegistry.registerEntityRenderingHandler(EntityBomb.class, new RenderBomb());
		
		//alembic te
		RenderAlembicTileEntity alembicRender =  new RenderAlembicTileEntity();
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityAlembic.class, alembicRender);
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(BlocksMMInit.alembic), new RenderItemBlockAlembic(alembicRender, new TileEntityAlembic()));
		
		//chandelier te
		RenderChandelierTileEntity chandelierRender =  new RenderChandelierTileEntity();
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityChandelier.class, chandelierRender);
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(BlocksMMInit.chandelier), new RenderItemBlockChandelier(chandelierRender, new TileEntityChandelier()));
		
		//pump te
		RenderPumpTileEntity pumpRender =  new RenderPumpTileEntity();
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityPump.class, pumpRender);
		//MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(BlocksMMInit.pump), new RenderItemBlockChandelier(pumpRender, new TileEntityPump()));
	}

	@Override
	public void initKeybindings() {
	
		for (KeysMM keybind :  KeysMM.values()){
			ClientRegistry.registerKeyBinding(keybind.getKeyBind());
		}
	}

	@Override
	public EntityPlayer getClientPlayer() {
		
		return Minecraft.getMinecraft().thePlayer;
	}
}
