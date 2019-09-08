package com.hamhub7.labday.block.creativevoid;

import com.hamhub7.labday.LabDay;
import com.hamhub7.labday.block.BlockTileEntity;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockCreativeVoid extends BlockTileEntity<TileEntityCreativeVoid>
{
	public BlockCreativeVoid() 
	{
		super(Material.ANVIL, "creativevoid");
	}
	
	@Override
	public Class<TileEntityCreativeVoid> getTileEntityClass() 
	{
		return TileEntityCreativeVoid.class;
	}
	
	public void registerItemModel(Item itemBlock)
	{
		LabDay.proxy.registerItemRenderer(itemBlock, 0, "creativevoid");
	}
	
	public Item createItemBlock()
	{
		return new ItemBlock(this).setRegistryName(getRegistryName());
	}

	@Override
	public TileEntityCreativeVoid createTileEntity(World world, IBlockState state) 
	{
		return new TileEntityCreativeVoid();
	}
}
