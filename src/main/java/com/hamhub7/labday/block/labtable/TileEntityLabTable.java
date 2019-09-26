package com.hamhub7.labday.block.labtable;

import java.util.Random;

import javax.annotation.Nullable;

import com.hamhub7.labday.LabDay;
import com.hamhub7.labday.block.labtable.packet.PacketRequestUpdateLabTable;
import com.hamhub7.labday.block.labtable.packet.PacketUpdateLabTable;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ITickable;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.ItemStackHandler;

public class TileEntityLabTable extends TileEntity
{
	private Random rand = new Random();
	
	public ItemStackHandler inventory = new ItemStackHandler(9)
	{
		protected void onContentsChanged(int slot) 
		{
			if(!world.isRemote)
			{
				LabDay.network.sendToAllAround(new PacketUpdateLabTable(TileEntityLabTable.this), new NetworkRegistry.TargetPoint(world.provider.getDimension(), pos.getX(), pos.getY(), pos.getZ(), 64));
			}
		};
	};
	
	@Override
	public void onLoad() 
	{
		if(world.isRemote)
		{
			LabDay.network.sendToServer(new PacketRequestUpdateLabTable(this));
		}
	}
	
	@Override
	public AxisAlignedBB getRenderBoundingBox() 
	{
		return new AxisAlignedBB(getPos(), getPos().add(1, 2, 1));
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
