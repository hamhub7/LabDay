package com.hamhub7.labday.item;

import com.hamhub7.labday.LabDay;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ItemBase extends Item
{
	protected String name;
	
	public ItemBase(String name) 
	{
		this.name = name;
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(LabDay.creativeTab);
	}
	
	public void registerItemModel() 
	{
		LabDay.proxy.registerItemRenderer(this, 0, name);
	}
}
