package com.wiiv.mysterymod.tileentities;

import net.minecraft.tileentity.TileEntity;

public class TileEntityAlembic extends TileEntity {

	/** Determines if the check for adjacent alembics has taken place. */
    public boolean adjacentAlembicChecked;

    /** Contains the alembic tile located adjacent to this one (if any) */
    public TileEntityAlembic adjacentAlembicYPos;
    
}
