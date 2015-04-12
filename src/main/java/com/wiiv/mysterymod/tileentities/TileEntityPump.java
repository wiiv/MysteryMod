package com.wiiv.mysterymod.tileentities;

public class TileEntityPump extends TileEntityMMGeneric {

	private float innerRingPositionCycle;
	private float outerRingPositionCycle;
	int ticks = 0;
	
	public float getInnerRingPosition() {
		
		return - Math.abs((float)Math.sin(innerRingPositionCycle)) * 5.5F;
	}
	
	public float getOuterRingPosition() {
		
		return Math.abs((float)Math.sin(outerRingPositionCycle)) * 5.5F;
	}
}
