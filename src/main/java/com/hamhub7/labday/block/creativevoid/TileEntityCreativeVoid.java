package com.hamhub7.labday.block.creativevoid;

import net.darkhax.tesla.api.implementation.InfiniteTeslaConsumer;
import net.darkhax.tesla.capability.TeslaCapabilities;
import net.darkhax.tesla.lib.TeslaUtils;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ITickable;
import net.minecraftforge.common.capabilities.Capability;

public class TileEntityCreativeVoid extends TileEntity implements ITickable
{
	@Override
	public <T> T getCapability(Capability<T> capability, EnumFacing facing) 
	{
		if(capability == TeslaCapabilities.CAPABILITY_CONSUMER)
		{
			return (T) new InfiniteTeslaConsumer();
		}
		return super.getCapability(capability, facing);
	}
	
	@Override
	public boolean hasCapability(Capability<?> capability, EnumFacing facing) 
	{
		if(capability == TeslaCapabilities.CAPABILITY_CONSUMER)
		{
			return true;
		}
		return super.hasCapability(capability, facing);
	}
	
	@Override
	public void update() 
	{
		TeslaUtils.consumePowerFromAllFaces(this.world, this.pos, 50, false);
	}
}
