package com.hamhub7.labday.item;

import net.minecraft.item.Item;

public class ItemUpgrade extends ItemBase
{

	public ItemUpgrade(UpgradeType type) 
	{
		super(type.toString() + "_upgrade");
	}
	
	@Override
	public int getItemStackLimit() 
	{
		return 1;
	}

	public enum UpgradeType
	{
		speed,
		efficiency,
		base
	}
}
