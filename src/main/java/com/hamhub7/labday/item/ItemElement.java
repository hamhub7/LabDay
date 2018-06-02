package com.hamhub7.labday.item;

import java.util.List;

import javax.annotation.Nullable;

import com.hamhub7.labday.LabDay;
import com.hamhub7.labday.util.ElementUtil;
import com.hamhub7.labday.util.ItemNBTHelper;

import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.GameSettings;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ITickable;
import net.minecraft.util.NonNullList;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;

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
	
	@Override
	public void addInformation(ItemStack stack, @Nullable World world, List<String> tooltip, ITooltipFlag flag) 
	{
		if(ElementUtil.getPhase(stack.getMetadata(), getTemp(stack)).equals(ElementUtil.Phase.Gas))
		{
			tooltip.add(TextFormatting.RED.toString() + "Temperature: " + getTemp(stack) + " K");
		}
		else if(ElementUtil.getPhase(stack.getMetadata(), getTemp(stack)).equals(ElementUtil.Phase.Liquid))
		{
			tooltip.add(TextFormatting.AQUA.toString() + "Temperature: " + getTemp(stack) + " K");
		}
		else if(ElementUtil.getPhase(stack.getMetadata(), getTemp(stack)).equals(ElementUtil.Phase.Solid))
		{
			tooltip.add(TextFormatting.DARK_GREEN.toString() + "Temperature: " + getTemp(stack) + " K");
		}
		
		final KeyBinding keyBindSneak = Minecraft.getMinecraft().gameSettings.keyBindSneak;
		
		if(GameSettings.isKeyDown(keyBindSneak))
		{
			tooltip.add(TextFormatting.GRAY.toString() + "Atomic Number: " + stack.getMetadata());
			tooltip.add(TextFormatting.GRAY.toString() + "Atomic Weight: " + Double.toString(ElementUtil.getWeight(stack.getMetadata())) + " amu");
			tooltip.add(TextFormatting.GRAY.toString() + "Melting Point: " + ElementUtil.getMeltingPoint(stack.getMetadata()) + " K");
			tooltip.add(TextFormatting.GRAY.toString() + "Boiling Point: " + ElementUtil.getBoilingPoint(stack.getMetadata()) + " K");
			tooltip.add(TextFormatting.GRAY.toString() + "Phase: " + ElementUtil.getPhase(stack.getMetadata(), getTemp(stack)));
			tooltip.add(TextFormatting.GRAY.toString() + "Specific Heat: " + Double.toString(ElementUtil.getSpecHeat(stack.getMetadata())));
			tooltip.add(TextFormatting.GRAY.toString() + "Density: " + Double.toString(ElementUtil.getDensity(stack.getMetadata())));
			tooltip.add(TextFormatting.GRAY.toString() + "Electronegativity: " + Double.toString(ElementUtil.getElecNeg(stack.getMetadata())));
		}
		else
		{
			tooltip.add(TextFormatting.GRAY.toString() + "Hold " + keyBindSneak.getDisplayName() + " for more info");
		}
	}
	
	@Override
	public void registerItemModel() 
	{
		for(int meta = 0; meta < ElementUtil.PeriodicTable.values().length; meta++)
		{
			LabDay.proxy.registerVariantRenderer(this, meta, "element_" + ElementUtil.PeriodicTable.values()[meta].toString(), "inventory");
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
