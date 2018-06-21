package com.hamhub7.labday.slots;

import com.hamhub7.labday.item.ItemUpgrade;

import net.minecraft.item.ItemStack;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.SlotItemHandler;

public class SlotUpgrade extends SlotItemHandler
{
	public SlotUpgrade(IItemHandler itemHandler, int index, int xPosition, int yPosition) 
	{
		super(itemHandler, index, xPosition, yPosition);
	}

	@Override
	public boolean isItemValid(ItemStack stack) 
	{
		return stack.getItem() instanceof ItemUpgrade;
	}
}
