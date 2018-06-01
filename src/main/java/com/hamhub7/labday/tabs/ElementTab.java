package com.hamhub7.labday.tabs;

import com.hamhub7.labday.LabDay;
import com.hamhub7.labday.item.ModItems;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class ElementTab extends CreativeTabs
{
	public ElementTab() 
	{
		super(LabDay.modid);
	}
	
	@Override
	public ItemStack getTabIconItem() 
	{
		return new ItemStack(ModItems.element, 1, 0);
	}
}
