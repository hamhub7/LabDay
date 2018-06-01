package com.hamhub7.labday.slots;

import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.SlotItemHandler;

public class SlotOne extends SlotItemHandler
{
	public SlotOne(IItemHandler itemHandler, int index, int xPosition, int yPosition) 
	{
		super(itemHandler, index, xPosition, yPosition);
	}

	@Override
	public int getSlotStackLimit() 
	{
		return 1;
	}
}
