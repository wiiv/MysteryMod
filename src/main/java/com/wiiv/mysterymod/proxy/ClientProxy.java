package com.wiiv.mysterymod.proxy;

import cpw.mods.fml.client.registry.RenderingRegistry;
import net.minecraft.client.audio.SoundHandler;

public class ClientProxy extends CommonProxy{
	
	@Override
	public void initSounds() {
		//new SoundHandler(null, null);
	}
	
	@Override
	public void initRenderers() {
		/*RenderingRegistry.registerEntityRenderingHandler(EntitySpaceship.class, new RenderSpaceship());
		
		ModelDroid model = new ModelDroid();
		RenderingRegistry.registerEntityRenderingHandler(EntityDroid.class, new RenderDroid(model));
		MinecraftForgeClient.registerItemRenderer(ItemInfo.DROID_ID + 256, new RenderDroidItem(model));
		
		//machine block
		
		RenderMachineBlock machineRender =  new RenderMachineBlock();
		BlockInfo.MACHINE_RENDER_ID = machineRender.getRenderId();
		RenderingRegistry.registerBlockHandler(machineRender);
		
		//bomb entity
		
		RenderingRegistry.registerEntityRenderingHandler(EntityBomb.class, new RenderBomb());
		
		//alembic te
		RenderAlembicTileEntity alembicRender =  new RenderAlembicTileEntity();
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityAlembic.class, alembicRender);
		
		//chandelier te
		RenderChandelierTileEntity chandelierRender =  new RenderChandelierTileEntity();
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityChandelier.class, chandelierRender);*/
	}

}
