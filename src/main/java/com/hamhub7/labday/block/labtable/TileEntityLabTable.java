package com.hamhub7.labday.block.labtable;

import java.util.List;

import javax.annotation.Nullable;

import com.google.common.collect.Lists;
import com.hamhub7.labday.block.notebook.BlockTextbook;

import net.darkhax.tesla.capability.TeslaCapabilities;
import net.minecraft.block.Block;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.ItemStackHandler;

public class TileEntityLabTable extends TileEntity
{
	private ItemStackHandler inventory = new ItemStackHandler(9);
	private BlockPos masterPos;
	
	public void deleteMaster()
	{
		this.masterPos = null;
	}
	
	public void addMaster(BlockPos masterPos)
	{
		this.masterPos = masterPos;
	}
	
	public boolean hasMaster()
	{
		return this.masterPos != null;
	}
	
	public BlockPos getMaster()
	{
		return masterPos;
	}
	
	@Override
	public NBTTagCompound writeToNBT(NBTTagCompound compound) 
	{
		compound.setTag("inventory", inventory.serializeNBT());
		return super.writeToNBT(compound);
	}
	
	@Override
	public void readFromNBT(NBTTagCompound compound) 
	{
		inventory.deserializeNBT(compound.getCompoundTag("inventory"));
		super.readFromNBT(compound);
	}
	
	@Override
	public boolean hasCapability(Capability<?> capability, @Nullable EnumFacing facing) 
	{
		if(capability == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY)
		{
			return true;
		}
		return super.hasCapability(capability, facing);
	}
	
	@Nullable
	@Override
	public <T> T getCapability(Capability<T> capability, @Nullable EnumFacing facing) 
	{
		if(capability == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY)
		{
			return (T)this.inventory;
		}
		return super.getCapability(capability, facing);
	}
}
