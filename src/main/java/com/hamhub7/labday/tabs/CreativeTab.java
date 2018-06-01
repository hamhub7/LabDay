package com.hamhub7.labday.tabs;

import com.hamhub7.labday.LabDay;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class CreativeTab extends CreativeTabs
{
	public CreativeTab() 
	{
		super(LabDay.modid);
	}
	
	@Override
	public ItemStack getTabIconItem() 
	{
		return new ItemStack(Items.ACACIA_BOAT);
	}
}
