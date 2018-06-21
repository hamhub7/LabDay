package com.hamhub7.labday.block.temperature.bunsen;

import com.hamhub7.labday.LabDay;
import com.hamhub7.labday.block.BlockTileEntity;
import com.hamhub7.labday.util.GuiHandler;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockBunsenBurner extends BlockTileEntity
{
	public BlockBunsenBurner() 
	{
		super(Material.IRON, "bunsen_burner");
	}
	
	@Override
	public boolean isFullBlock(IBlockState state) 
	{
		return false;
	}
	
	@Override
	public boolean isOpaqueCube(IBlockState state) 
	{
		return false;
	}
	
	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) 
	{
		return new AxisAlignedBB(0.375D, 0.0D, 0.375D, 0.625D, 0.5D, 0.625D);
	}
	
	@Override
	public Class<TileEntityBunsenBurner> getTileEntityClass() 
	{
		return TileEntityBunsenBurner.class;
	}
	
	@Override
	public TileEntityBunsenBurner createTileEntity(World world, IBlockState state) 
	{
		return new TileEntityBunsenBurner();
	}
	
	@Override
	public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) 
	{
		if(!world.isRemote)
		{
			player.openGui(LabDay.instance, GuiHandler.GuiList.BUNSENBURNER.ordinal(), world, pos.getX(), pos.getY(), pos.getZ());
		}
		return true;
	}
}
