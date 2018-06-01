package com.hamhub7.labday.item;

import com.hamhub7.labday.LabDay;

import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;

public class ItemArmorBase extends ItemArmor
{
	private String name;
	
	public ItemArmorBase(ArmorMaterial material, EntityEquipmentSlot slot, String name) 
	{
		super(material, 0, slot);
		setRegistryName(name);
		setUnlocalizedName(name);
		setCreativeTab(LabDay.creativeTab);
		this.name = name;
	}
	
	public void registerItemModel() 
	{
		LabDay.proxy.registerItemRenderer(this, 0, name);
	}
}
