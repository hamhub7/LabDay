package com.hamhub7.labday.proxy;

import com.hamhub7.labday.LabDay;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.resources.I18n;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;

public class ClientProxy extends CommonProxy
{
	@Override
	public void registerItemRenderer(Item item, int meta, String id)
	{
		ModelLoader.setCustomModelResourceLocation(item, meta, new ModelResourceLocation(LabDay.modid + ":" + id, "inventory"));
	}
	
	@Override
	public void registerVariantRenderer(Item item, int meta, String filename, String id) 
	{
		ModelLoader.setCustomModelResourceLocation(item, meta, new ModelResourceLocation(new ResourceLocation(LabDay.modid, filename), id));
	}
	
	public void registerRenderers() 
	{
		
	}
	
	@Override
	public String localize(String unlocalized, Object... args)
	{
		return I18n.format(unlocalized, args);
	}
}
