package com.hamhub7.labday.block.furnace;

import com.hamhub7.labday.block.BlockTileEntity;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockPoweredFurnace extends BlockTileEntity
{

	public BlockPoweredFurnace() 
	{
		super(Material.IRON, "powered_furnace");
	}

	@Override
	public Class<TileEntityPoweredFurnace> getTileEntityClass() 
	{
		return TileEntityPoweredFurnace.class;
	}

	@Override
	public TileEntityPoweredFurnace createTileEntity(World world, IBlockState state) 
	{
		return new TileEntityPoweredFurnace();
	}

}