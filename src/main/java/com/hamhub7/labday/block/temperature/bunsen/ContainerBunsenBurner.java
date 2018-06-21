package com.hamhub7.labday.block.temperature.bunsen;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.SlotItemHandler;

public class ContainerBunsenBurner extends Container
{
	public TileEntityBunsenBurner bunsen;
	
	public ContainerBunsenBurner(InventoryPlayer playerInv, final TileEntity bunsen) 
	{
		IItemHandler inventory = bunsen.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, EnumFacing.NORTH);
		this.bunsen = (TileEntityBunsenBurner)bunsen;
		addSlotToContainer(new SlotItemHandler(inventory, 0, 44, 26) 
		{
			@Override
			public void onSlotChanged() 
			{
				bunsen.markDirty();
			}
		});
		
		for (int i = 0; i < 3; i++) 
		{
			for (int j = 0; j < 9; j++) 
			{
				addSlotToContainer(new Slot(playerInv, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
			}
		}
	
		for (int k = 0; k < 9; k++) 
		{
			addSlotToContainer(new Slot(playerInv, k, 8 + k * 18, 142));
		}
	}
	
	@Override
	public boolean canInteractWith(EntityPlayer playerIn) 
	{
		return true;
	}
	
	@Override
	public ItemStack transferStackInSlot(EntityPlayer player, int index) 
	{
		ItemStack itemstack = ItemStack.EMPTY;
		Slot slot = inventorySlots.get(index);
	
		if (slot != null && slot.getHasStack()) 
		{
			ItemStack itemstack1 = slot.getStack();
			itemstack = itemstack1.copy();
	
			int containerSlots = inventorySlots.size() - player.inventory.mainInventory.size();
	
			if (index < containerSlots) 
			{
				if (!this.mergeItemStack(itemstack1, containerSlots, inventorySlots.size(), true)) 
				{
					return ItemStack.EMPTY;
				}
			} 
			else if (!this.mergeItemStack(itemstack1, 0, containerSlots, false)) 
			{
				return ItemStack.EMPTY;
			}
	
			if (itemstack1.getCount() == 0) 
			{
				slot.putStack(ItemStack.EMPTY);
			} else 
			{
				slot.onSlotChanged();
			}
	
			if (itemstack1.getCount() == itemstack.getCount()) 
			{
				return ItemStack.EMPTY;
			}
	
			slot.onTake(player, itemstack1);
		}
		return itemstack;
	}
}
