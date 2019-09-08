package com.hamhub7.labday.block.tank;

import com.hamhub7.labday.block.BlockTileEntity;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.world.World;

public class BlockTank extends BlockTileEntity<TileEntityTank>
{
	public BlockTank() 
	{
		super(Material.IRON, "tank");
	}
	
	@Override
	public Class<TileEntityTank> getTileEntityClass() 
	{
		return TileEntityTank.class;
	}
	
	@Override
	public TileEntityTank createTileEntity(World world, IBlockState state) 
	{
		return new TileEntityTank();
	}
}
