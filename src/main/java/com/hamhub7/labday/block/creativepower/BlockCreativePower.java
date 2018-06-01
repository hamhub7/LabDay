package com.hamhub7.labday.block.creativepower;

import com.hamhub7.labday.LabDay;
import com.hamhub7.labday.block.BlockTileEntity;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockCreativePower extends BlockTileEntity<TileEntityCreativePower>
{
	public BlockCreativePower() 
	{
		super(Material.ANVIL, "creativepower");
	}
	
	@Override
	public Class<TileEntityCreativePower> getTileEntityClass() 
	{
		return TileEntityCreativePower.class;
	}
	
	public void registerItemModel(Item itemBlock)
	{
		LabDay.proxy.registerItemRenderer(itemBlock, 0, "creativepower");
	}
	
	public Item createItemBlock()
	{
		return new ItemBlock(this).setRegistryName(getRegistryName());
	}

	@Override
	public TileEntityCreativePower createTileEntity(World world, IBlockState state) 
	{
		return new TileEntityCreativePower();
	}
}
