package com.hamhub7.labday.block.temperature.icebox;

import com.hamhub7.labday.LabDay;
import com.hamhub7.labday.block.BlockTileEntity;
import com.hamhub7.labday.block.temperature.bunsen.TileEntityBunsenBurner;
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

public class BlockIcebox extends BlockTileEntity
{
	public BlockIcebox() 
	{
		super(Material.CRAFTED_SNOW, "icebox");
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
		return new AxisAlignedBB(0.125D, 0.0D, 0.125D, 0.875D, 0.5625D, 0.875D);
	}
	
	@Override
	public Class<TileEntityIcebox> getTileEntityClass() 
	{
		return TileEntityIcebox.class;
	}
	
	@Override
	public TileEntityIcebox createTileEntity(World world, IBlockState state) 
	{
		return new TileEntityIcebox();
	}
	
	@Override
	public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) 
	{
		if(!world.isRemote)
		{
			player.openGui(LabDay.instance, GuiHandler.GuiList.ICEBOX.ordinal(), world, pos.getX(), pos.getY(), pos.getZ());
		}
		return true;
	}
}
