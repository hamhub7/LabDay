package com.hamhub7.labday.item;

import java.util.function.Function;

import com.google.common.collect.ImmutableMap;
import com.hamhub7.labday.LabDay;
import com.hamhub7.labday.util.ElementUtil;
import com.hamhub7.labday.util.ItemNBTHelper;

import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.client.renderer.block.model.IBakedModel;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.renderer.vertex.VertexFormat;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.IModel;
import net.minecraftforge.common.model.IModelState;

public class ItemElement extends ItemBase
{	
	public ItemElement() 
	{
		super("element");
		this.setCreativeTab(LabDay.elementTab);
		this.setHasSubtypes(true);
	}
	
	@Override
	public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> items) 
	{
		if(this.isInCreativeTab(tab))
		{
			for(ElementUtil.PeriodicTable type : ElementUtil.PeriodicTable.values())
			{
				items.add(new ItemStack(this, 1, type.ordinal()));
			}
		}
	}
	
	@Override
	public String getUnlocalizedName(ItemStack stack) 
	{
		int meta = stack.getMetadata();
		if(meta < ElementUtil.PeriodicTable.values().length)
		{
			return super.getUnlocalizedName(stack) + "." + ElementUtil.PeriodicTable.values()[meta].name();
		}
		else
		{
			return super.getUnlocalizedName(stack);
		}
	}
	
	public static int getTemp(ItemStack stack)
	{
		return ItemNBTHelper.getInt(stack, "temp", 0);
	}
	
	public static void setTemp(ItemStack stack, int kelvin)
	{
		ItemNBTHelper.setInt(stack, "temp", kelvin);
	}
}
