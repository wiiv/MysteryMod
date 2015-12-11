package com.wiiv.mysterymod.network;

import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;

public class MessageExplode extends MessageMMGeneric<MessageExplode> {
	
	private double explosionHeight;
	private float explosionSize;
	
	public MessageExplode(){}
		
	public MessageExplode(double exHeigth, float exSize){
		
		explosionHeight = exHeigth;
		explosionSize = exSize;
	}
	
	@Override
	public void fromBytes(ByteBuf buf) {
		
		explosionHeight = buf.readDouble();
		explosionSize = buf.readFloat();
	}
	
	@Override
	public void toBytes(ByteBuf buf) {
		
		buf.writeDouble(explosionHeight);
		buf.writeFloat(explosionSize);
	}
		
	//handling
	
	@Override
	public void handleClientSide(MessageExplode message, EntityPlayer player) {

	}
	
	@Override
	public void handleServerSide(MessageExplode message, EntityPlayer player){

		player.worldObj.createExplosion(player, player.posX, player.posY - 2 - (Math.random() * message.explosionHeight), player.posZ, (float) (Math.random() * message.explosionSize), true);
	}


}
