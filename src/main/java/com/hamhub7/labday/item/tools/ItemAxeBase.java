package com.hamhub7.labday.item.tools;

import com.hamhub7.labday.LabDay;

import net.minecraft.item.ItemAxe;

public class ItemAxeBase extends ItemAxe
{
	private String name;
	
	public ItemAxeBase(ToolMaterial material, String name) 
	{
		super(material);
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(LabDay.creativeTab);
		this.name = name;
	}
	
	public void registerItemModel()
	{
		LabDay.proxy.registerItemRenderer(this, 0, name);
	}
}
