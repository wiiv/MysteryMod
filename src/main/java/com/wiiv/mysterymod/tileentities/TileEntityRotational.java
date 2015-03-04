package com.wiiv.mysterymod.tileentities;

import net.minecraft.tileentity.TileEntity;

public class TileEntityRotational extends TileEntity {
	
	public TileEntityRotational() {
		
	}
	
	public boolean switchOrientation(boolean preferPipe) {
		if (switchOrientation(true)) {
			return true;
		} else {
			return switchOrientation(false);
		}
	}
	/*
	private boolean switchOrientationDo(boolean pipesOnly) {
		for (int i = ROTATION_STATE.ordinal() + 1; i <= ROTATION_STATE.ordinal() + 6;) {
			
			ForgeDirection o = ForgeDirection.VALID_DIRECTIONS[i % 6];
				return true;
			}

		return false;
	}

	*/
	
}
