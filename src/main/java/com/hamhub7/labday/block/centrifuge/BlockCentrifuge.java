package com.hamhub7.labday.block.centrifuge;

import com.hamhub7.labday.block.BlockTileEntity;
import com.hamhub7.labday.block.ModBlocks;
import com.hamhub7.labday.block.processor.TileEntityProcessor;

import net.minecraft.block.BlockHorizontal;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BlockCentrifuge extends BlockTileEntity<TileEntityCentrifuge>
{
	public static final PropertyDirection FACING = BlockHorizontal.FACING;
	public static final PropertyBool ACTIVE = PropertyBool.create("active");
	
	public BlockCentrifuge() 
	{
		super(Material.IRON, "centrifuge");
		this.setDefaultState(this.blockState.getBaseState().withProperty(FACING, EnumFacing.NORTH).withProperty(ACTIVE, false));
	}
	
	@Override
	public Class<TileEntityCentrifuge> getTileEntityClass() 
	{
		return TileEntityCentrifuge.class;
	}
	
	@Override
	public TileEntityCentrifuge createTileEntity(World world, IBlockState state) 
	{
		return new TileEntityCentrifuge();
	}
	
	@Override
	public void onBlockAdded(World world, BlockPos pos, IBlockState state) 
	{
		if(!world.isRemote)
		{
			IBlockState north = world.getBlockState(pos.north());
			IBlockState south = world.getBlockState(pos.south());
			IBlockState west = world.getBlockState(pos.west());
			IBlockState east = world.getBlockState(pos.east());
			EnumFacing face = (EnumFacing) state.getValue(FACING);
			
			if(face == EnumFacing.NORTH && north.isFullBlock() && !south.isFullBlock())
			{
				face = EnumFacing.SOUTH;
			}
			else if(face == EnumFacing.SOUTH && south.isFullBlock() && !north.isFullBlock())
			{
				face = EnumFacing.NORTH;
			}
			else if(face == EnumFacing.WEST && west.isFullBlock() && !east.isFullBlock())
			{
				face = EnumFacing.EAST;
			}
			else if(face == EnumFacing.EAST && east.isFullBlock() && !west.isFullBlock())
			{
				face = EnumFacing.WEST;
			}
			world.setBlockState(pos, state.withProperty(FACING, face), 2);
		}
	}
	
	public static void setState(boolean active, World world, BlockPos pos)
	{
		IBlockState state = world.getBlockState(pos);
		TileEntity tileentity = world.getTileEntity(pos);
		
		if(active)
		{
			world.setBlockState(pos, ModBlocks.centrifuge.getDefaultState().withProperty(FACING, state.getValue(FACING)).withProperty(ACTIVE, true), 3);
		}
		else
		{
			world.setBlockState(pos, ModBlocks.centrifuge.getDefaultState().withProperty(FACING, state.getValue(FACING)).withProperty(ACTIVE, false), 3);
		}
		
		if(tileentity != null)
		{
			tileentity.validate();
			world.setTileEntity(pos, tileentity);
		}
	}
	
	@Override
	public IBlockState getStateForPlacement(World world, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer, EnumHand hand) 
	{
		return this.getDefaultState().withProperty(FACING, placer.getHorizontalFacing().getOpposite());
	}
	
	@Override
	public void onBlockPlacedBy(World world, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack) 
	{
		world.setBlockState(pos, this.getDefaultState().withProperty(FACING, placer.getHorizontalFacing().getOpposite()), 2);
	}
	
	@Override
	public IBlockState withRotation(IBlockState state, Rotation rot) 
	{
		return state.withProperty(FACING, rot.rotate((EnumFacing) state.getValue(FACING)));
	}
	
	@Override
	public IBlockState withMirror(IBlockState state, Mirror mirror) 
	{
		return state.withRotation(mirror.toRotation((EnumFacing) state.getValue(FACING)));
	}
	
	@Override
	protected BlockStateContainer createBlockState() 
	{
		return new BlockStateContainer(this, new IProperty[] {ACTIVE,FACING});
	}
	
	@Override
	public IBlockState getStateFromMeta(int meta) 
	{
		EnumFacing facing = EnumFacing.getFront(meta);
		if(facing.getAxis() == EnumFacing.Axis.Y)
		{
			facing = EnumFacing.NORTH;
		}
		return this.getDefaultState().withProperty(FACING, facing);
	}
	
	@Override
	public int getMetaFromState(IBlockState state) 
	{
		return ((EnumFacing) state.getValue(FACING)).getIndex();
	}
}
