package com.hamhub7.labday.util;

import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.oredict.OreDictionary;

public class ModUtils 
{
	public static boolean ingredientApplyWithNBT(Ingredient ingredient, ItemStack toMatch)
	{
		if(toMatch == null)
		{
			return false;
		}
		
		ItemStack[] matchingStacks = ingredient.getMatchingStacks();
		
		for(int i = 0; i < matchingStacks.length; i++)
		{
			if(matchingStacks[i].getItem() != toMatch.getItem())
			{
				continue;
			}
			
			int meta = matchingStacks[i].getMetadata();
			
			if(meta != OreDictionary.WILDCARD_VALUE && meta != toMatch.getMetadata())
			{
				continue;
			}
			
			if(!ItemStack.areItemStacksEqual(matchingStacks[i], toMatch))
			{
				continue;
			}
			return true;
		}
		return false;
	}
	
	public static void spawnStackOnTopOfBlock(World world, ItemStack stack, BlockPos pos)
	{
		if(!world.isRemote)
		{
			double yOffset = 0.0D;
		
			EntityItem item = new EntityItem(world, pos.getX() + 0.5, pos.getY() + 0.5 + yOffset, pos.getZ()+ 0.5, stack);
			item.motionX = 0.0;
			item.motionY = 0.1;
			item.motionZ = 0.0;
		
			world.spawnEntity(item);
		}
	}
}
