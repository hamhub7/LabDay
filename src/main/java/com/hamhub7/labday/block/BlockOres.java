package com.hamhub7.labday.block;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BlockOres extends BlockOre
{	
	public BlockOres(String name, String oreName) 
	{
		super(Material.ROCK, name, oreName);
		setHardness(3.0F);
		setResistance(5.0F);
	}
}
