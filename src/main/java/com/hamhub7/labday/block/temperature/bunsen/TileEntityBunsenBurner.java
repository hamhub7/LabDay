package com.hamhub7.labday.block.temperature.bunsen;

import javax.annotation.Nullable;

import com.hamhub7.labday.item.ItemElement;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ITickable;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.ItemStackHandler;

public class TileEntityBunsenBurner extends TileEntity implements ITickable
{
	private ItemStackHandler inventory = new ItemStackHandler(1);
	public static final int RATE = 1;
	
	public TileEntityBunsenBurner() 
	{
		
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
	
	@Override
	public void update() 
	{
		ItemStack stack = inventory.getStackInSlot(0);
		if(stack.getItem() instanceof ItemElement)
		{
			ItemElement element = (ItemElement)stack.getItem();
			element.setTemp(stack, element.getTemp(stack) + RATE);
		}
	}
}
