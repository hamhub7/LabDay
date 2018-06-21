package com.hamhub7.labday.item;

import net.minecraft.item.Item;

public class UnstackableItemBase extends ItemBase
{

	public UnstackableItemBase(String name) 
	{
		super(name);
	}
	
	@Override
	public int getItemStackLimit() 
	{
		return 1;
	}
}
