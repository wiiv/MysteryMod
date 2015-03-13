package com.wiiv.mysterymod.network;

import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayerMP;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import cpw.mods.fml.relauncher.Side;


public class MessageMMGeneric<REQ extends IMessage>implements IMessage, IMessageHandler<REQ, REQ> {
	
	
	@Override
	public REQ onMessage(REQ message, MessageContext ctx) {
		if(ctx.side == Side.SERVER){
			handleServerSide(message, ctx.getServerHandler().playerEntity);
		}else{
			handleClientSide(message, null);
		}
		return null;
	}

	public void handleClientSide(REQ message, Object object) {

	}
	
	
	public void handleServerSide(REQ message, EntityPlayerMP playerEntity) {

	}

	@Override
	public void fromBytes(ByteBuf buf) {

	}
	
	@Override
	public void toBytes(ByteBuf buf) {

	}
}
