package com.wiiv.mysterymod.proxy;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.client.MinecraftForgeClient;

import com.wiiv.mysterymod.client.model.ModelDroid;
import com.wiiv.mysterymod.client.render.block.RenderMachineBlock;
import com.wiiv.mysterymod.client.render.entity.RenderBomb;
import com.wiiv.mysterymod.client.render.entity.RenderDroid;
import com.wiiv.mysterymod.client.render.entity.RenderSpaceship;
import com.wiiv.mysterymod.client.render.item.RenderDroidItem;
import com.wiiv.mysterymod.client.render.tileentity.RenderAlembicTileEntity;
import com.wiiv.mysterymod.client.render.tileentity.RenderChandelierTileEntity;
import com.wiiv.mysterymod.entity.EntityBomb;
import com.wiiv.mysterymod.entity.EntityDroid;
import com.wiiv.mysterymod.entity.EntitySpaceship;
import com.wiiv.mysterymod.init.ItemsMMInit;
import com.wiiv.mysterymod.reference.BlocksMM;
import com.wiiv.mysterymod.reference.KeysMM;
import com.wiiv.mysterymod.tileentities.TileEntityAlembic;
import com.wiiv.mysterymod.tileentities.TileEntityChandelier;

import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;

public class ClientProxy extends CommonProxy{

	@Override
	public void initRenders() {
		
		RenderingRegistry.registerEntityRenderingHandler(EntitySpaceship.class, new RenderSpaceship());
		
		ModelDroid model = new ModelDroid();
		RenderingRegistry.registerEntityRenderingHandler(EntityDroid.class, new RenderDroid(model));
		MinecraftForgeClient.registerItemRenderer(ItemsMMInit.droid, new RenderDroidItem(model));
		
		//machine block
		
		RenderMachineBlock machineRender =  new RenderMachineBlock();
		BlocksMM.MACHINE_RENDER_ID = machineRender.getRenderId();
		RenderingRegistry.registerBlockHandler(machineRender);
		
		//bomb entity
		
		RenderingRegistry.registerEntityRenderingHandler(EntityBomb.class, new RenderBomb());
		
		//alembic te
		RenderAlembicTileEntity alembicRender =  new RenderAlembicTileEntity();
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityAlembic.class, alembicRender);
		
		//chandelier te
		RenderChandelierTileEntity chandelierRender =  new RenderChandelierTileEntity();
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityChandelier.class, chandelierRender);
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
