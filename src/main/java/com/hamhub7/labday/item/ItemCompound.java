package com.hamhub7.labday.item;

import com.hamhub7.labday.LabDay;
import com.hamhub7.labday.util.CompoundUtil;
import com.hamhub7.labday.util.ElementUtil;
import com.hamhub7.labday.util.ItemNBTHelper;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;

public class ItemCompound extends ItemBase
{
	float temp;
	
	public ItemCompound() 
	{
		super("compound");
		this.setCreativeTab(LabDay.elementTab);
		this.setHasSubtypes(true);
	}
	
	@Override
	public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> items) 
	{
		if(this.isInCreativeTab(tab))
		{
			for(CompoundUtil.Compounds type : CompoundUtil.Compounds.values())
			{
				items.add(new ItemStack(this, 1, type.ordinal()));
			}
		}
	}
	
	@Override
	public String getUnlocalizedName(ItemStack stack) 
	{
		int meta = stack.getMetadata();
		if(meta < CompoundUtil.Compounds.values().length)
		{
			return super.getUnlocalizedName(stack) + "." + CompoundUtil.Compounds.values()[meta].toString();
		}
		else
		{
			return super.getUnlocalizedName(stack);
		}
	}
	
	@Override
	public void registerItemModel() 
	{
		for(int meta = 0; meta < CompoundUtil.Compounds.values().length; meta++)
		{
			LabDay.proxy.registerVariantRenderer(this, meta, CompoundUtil.getModel(meta), "inventory");
		}
	}
	
	public static int getTemp(ItemStack stack)
	{
		return ItemNBTHelper.getInt(stack, "temp", 294);
	}
	
	public static void setTemp(ItemStack stack, int kelvin)
	{
		ItemNBTHelper.setInt(stack, "temp", kelvin);
	}
}
