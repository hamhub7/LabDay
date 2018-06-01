package com.hamhub7.labday.item.tools;

import com.hamhub7.labday.LabDay;

import net.minecraft.item.ItemPickaxe;

public class ItemPickaxeBase extends ItemPickaxe
{
	private String name;
	
	public ItemPickaxeBase(ToolMaterial material, String name) 
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
