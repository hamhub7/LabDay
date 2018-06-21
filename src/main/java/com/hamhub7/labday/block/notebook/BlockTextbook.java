package com.hamhub7.labday.block.notebook;

import com.hamhub7.labday.block.BlockTileEntity;

import net.minecraft.block.Block;
import net.minecraft.block.BlockHorizontal;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockTextbook extends BlockTileEntity<TileEntityTextbook>
{
	public static final PropertyDirection FACING = BlockHorizontal.FACING;
	
	public BlockTextbook() 
	{
		super(Material.CIRCUITS, "textbook");
	}
	
	@Override
	public Class<TileEntityTextbook> getTileEntityClass() 
	{
		return TileEntityTextbook.class;
	}
	
	@Override
	public TileEntityTextbook createTileEntity(World world, IBlockState state) 
	{
		return new TileEntityTextbook();
	}
	
	@Override
	public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) 
	{
		if(!world.isRemote)
		{
			player.sendMessage(new TextComponentString("Slaves:"));
			TileEntityTextbook tile = (TileEntityTextbook)world.getTileEntity(pos);
			for(BlockPos table : tile.tables) 
			{
				player.sendMessage(new TextComponentString("Pos: " + table.getX() + ", " + table.getZ()));
			}
		}
		return true;
	}
	
	@Override
	public void breakBlock(World world, BlockPos pos, IBlockState state) 
	{
		TileEntityTextbook tile = (TileEntityTextbook)world.getTileEntity(pos);
		tile.destroyMulitblock();
	}
	
	@Override
	public boolean isOpaqueCube(IBlockState state) 
	{
		return false;
	}
	
	@Override
	public boolean isFullBlock(IBlockState state) 
	{
		return false;
	}
	
	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) 
	{
		EnumFacing facing = state.getValue(FACING);
		if(facing == EnumFacing.NORTH)
		{
			return new AxisAlignedBB(0.4375D, 0.0D, 0.3125D, 0.8125D, 0.0625D, 0.8125D);
		}
		if(facing == EnumFacing.SOUTH)
		{
			return new AxisAlignedBB(0.1875D, 0.0D, 0.1875D, 0.5625D, 0.0625D, 0.6875D);
		}
		if(facing == EnumFacing.EAST)
		{
			return new AxisAlignedBB(0.1875D, 0.0D, 0.4375D, 0.6875D, 0.0625D, 0.8125D);
		}
		if(facing == EnumFacing.WEST)
		{
			return new AxisAlignedBB(0.3125D, 0.0D, 0.1875, 0.8125D, 0.0625D, 0.5625D);
		}
		return NULL_AABB;
	}
	
	@Override
	public boolean isPassable(IBlockAccess worldIn, BlockPos pos) 
	{
		return true;
	}
	
	@Override
	public boolean causesSuffocation(IBlockState state) 
	{
		return false;
	}
	
	@Override
	public boolean isNormalCube(IBlockState state) 
	{
		return false;
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
		return new BlockStateContainer(this, new IProperty[] {FACING});
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
	
	private boolean canBlockStay(World worldIn, BlockPos pos)
    {
        return worldIn.getBlockState(pos.down()).getMaterial().isSolid();
    }
	
	@Override
	public boolean canPlaceBlockAt(World worldIn, BlockPos pos)
    {
        return super.canPlaceBlockAt(worldIn, pos) ? this.canBlockStay(worldIn, pos) : false;
    }
	
	@Override
	public void neighborChanged(IBlockState state, World world, BlockPos pos, Block block, BlockPos fromPos)
    {
        if (!this.canBlockStay(world, pos))
        {
        	dropBlockAsItem(world, pos, state, 1);
        	breakBlock(world, pos, state);
        	world.setBlockState(pos, Blocks.AIR.getDefaultState());
        }
    }
}
