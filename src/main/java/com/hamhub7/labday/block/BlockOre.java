package com.hamhub7.labday.block;

import net.minecraft.block.material.Material;
import net.minecraftforge.oredict.OreDictionary;

public class BlockOre extends BlockBase
{
	private String oreName;
	
	public BlockOre(Material material, String name, String oreName)
	{
		super(material, name);
		this.oreName = oreName;
	}
	
	public void initOreDict()
	{
		OreDictionary.registerOre(oreName, this);
	}
}
