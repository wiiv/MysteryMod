package com.wiiv.mysterymod.handler;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandler.Sharable;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import net.minecraft.tileentity.TileEntity;

import com.wiiv.mysterymod.mysteryMod;
import com.wiiv.mysterymod.reference.CoreMM;
import com.wiiv.mysterymod.tileentities.TileEntityMMGeneric;

import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.network.internal.FMLProxyPacket;

@Sharable
public class DescriptionHandler extends SimpleChannelInboundHandler<FMLProxyPacket> {
	
	public static final String CHANNEL = CoreMM.CHANNELS[1];

	public static void init(){
		
		NetworkRegistry.INSTANCE.newChannel(CHANNEL, new DescriptionHandler());
	}
	
	@Override
	protected void channelRead0(ChannelHandlerContext ctx, FMLProxyPacket msg) throws Exception {
		
		ByteBuf buf = msg.payload();
		
		int x = buf.readInt();
		int y = buf.readInt();
		int z = buf.readInt();
		
		TileEntity TE = mysteryMod.proxy.getClientPlayer().worldObj.getTileEntity(x, y, z);
		
		if(TE instanceof TileEntityMMGeneric) {
			
			((TileEntityMMGeneric)TE).readFromPacket(buf);
		}
	}
}
