package com.wiiv.mysterymod.network;

import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayerMP;

public class MessageExplode extends MessageMMGeneric<MessageExplode> {
	
	private double explosionHeight;
	private float explosionSize;
	
	public MessageExplode(){}
		
	public MessageExplode(double explosionHeigth, float explosionSize){
		
		this.explosionHeight = explosionHeigth;
		this.explosionSize = explosionSize;
	}
	
	@Override
	public void toBytes(ByteBuf buf) {
		buf.writeDouble(explosionHeight);
		buf.writeFloat(explosionSize);
	}
	
	@Override
	public void fromBytes(ByteBuf buf) {
		explosionHeight = buf.readDouble();
		explosionSize = buf.readFloat();
	}
	
	//handling
	
	@Override
	public void handleClientSide(MessageExplode message, Object object) {

	}
	
	@Override
	public void handleServerSide(MessageExplode message, EntityPlayerMP player){

		player.worldObj.createExplosion(player, player.posX, player.posY - 2 - (Math.random() * message.explosionHeight), player.posZ, (float) (Math.random() * message.explosionSize), true);
	}


}
