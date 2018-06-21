package com.hamhub7.labday.block.labtable;

import java.util.List;
import java.util.Random;

import com.google.common.collect.Lists;
import com.hamhub7.labday.LabDay;
import com.hamhub7.labday.block.BlockTileEntity;
import com.hamhub7.labday.block.ModBlocks;
import com.hamhub7.labday.block.notebook.BlockTextbook;
import com.hamhub7.labday.block.notebook.TileEntityTextbook;
import com.hamhub7.labday.item.ModItems;
import com.hamhub7.labday.util.GuiHandler;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;

public class BlockLabTable extends BlockTileEntity<TileEntityLabTable>
{
	public static final PropertyBool NORTH = PropertyBool.create("north");
	public static final PropertyBool SOUTH = PropertyBool.create("south");
	public static final PropertyBool EAST = PropertyBool.create("east");
	public static final PropertyBool WEST = PropertyBool.create("west");
	
	public BlockLabTable() 
	{
		super(Material.WOOD, "lab_table");
		this.setDefaultState(this.blockState.getBaseState().withProperty(NORTH, false).withProperty(SOUTH, false).withProperty(EAST, false).withProperty(WEST, false));
	}
	
	@Override
	public Class<TileEntityLabTable> getTileEntityClass() 
	{
		return TileEntityLabTable.class;
	}
	
	@Override
	public TileEntityLabTable createTileEntity(World world, IBlockState state) 
	{
		return new TileEntityLabTable();
	}
	
	@Override
	public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) 
	{
		if(!world.isRemote)
		{
			player.openGui(LabDay.instance, GuiHandler.GuiList.LABTABLE.ordinal(), world, pos.getX(), pos.getY(), pos.getZ());
		}
		return true;
	}
	
	@Override
	public void neighborChanged(IBlockState state, World world, BlockPos pos, Block block, BlockPos fromPos) 
	{
		TileEntityLabTable tile = (TileEntityLabTable)world.getTileEntity(pos);
		if(tile.hasMaster())
		{
			TileEntityTextbook masterTile = (TileEntityTextbook)world.getTileEntity(tile.getMaster());
			masterTile.recalculateMultiblock();
		}
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
	
	public boolean canConnectTo(IBlockAccess world, BlockPos pos, EnumFacing facing)
	{
		IBlockState iblockstate = world.getBlockState(pos);
        Block block = iblockstate.getBlock();
        return block instanceof BlockLabTable;
	}
	
	@Override
	public int getMetaFromState(IBlockState state) 
	{
		return 0;
	}
	
	public IBlockState getActualState(IBlockState state, IBlockAccess worldIn, BlockPos pos)
    {
        return state.withProperty(NORTH, canFenceConnectTo(worldIn, pos, EnumFacing.NORTH))
                    .withProperty(EAST,  canFenceConnectTo(worldIn, pos, EnumFacing.EAST))
                    .withProperty(SOUTH, canFenceConnectTo(worldIn, pos, EnumFacing.SOUTH))
                    .withProperty(WEST,  canFenceConnectTo(worldIn, pos, EnumFacing.WEST));
    }
	
	public IBlockState withRotation(IBlockState state, Rotation rot)
	{
		switch (rot)
		{
			case CLOCKWISE_180:
				return state.withProperty(NORTH, state.getValue(SOUTH)).withProperty(EAST, state.getValue(WEST)).withProperty(SOUTH, state.getValue(NORTH)).withProperty(WEST, state.getValue(EAST));
			case COUNTERCLOCKWISE_90:
				return state.withProperty(NORTH, state.getValue(EAST)).withProperty(EAST, state.getValue(SOUTH)).withProperty(SOUTH, state.getValue(WEST)).withProperty(WEST, state.getValue(NORTH));
			case CLOCKWISE_90:
				return state.withProperty(NORTH, state.getValue(WEST)).withProperty(EAST, state.getValue(NORTH)).withProperty(SOUTH, state.getValue(EAST)).withProperty(WEST, state.getValue(SOUTH));
			default:
				return state;
		}
	}
	
	public IBlockState withMirror(IBlockState state, Mirror mirrorIn)
    {
        switch (mirrorIn)
        {
            case LEFT_RIGHT:
                return state.withProperty(NORTH, state.getValue(SOUTH)).withProperty(SOUTH, state.getValue(NORTH));
            case FRONT_BACK:
                return state.withProperty(EAST, state.getValue(WEST)).withProperty(WEST, state.getValue(EAST));
            default:
                return super.withMirror(state, mirrorIn);
        }
    }
	
	protected BlockStateContainer createBlockState()
    {
        return new BlockStateContainer(this, new IProperty[] {NORTH, EAST, WEST, SOUTH});
    }
	
	@Override
	public boolean canBeConnectedTo(IBlockAccess world, BlockPos pos, EnumFacing facing) 
	{
		return canConnectTo(world, pos.offset(facing), facing.getOpposite());
	}
	
	private boolean canFenceConnectTo(IBlockAccess world, BlockPos pos, EnumFacing facing)
    {
        BlockPos other = pos.offset(facing);
        Block block = world.getBlockState(other).getBlock();
        return block.canBeConnectedTo(world, other, facing.getOpposite()) || canConnectTo(world, other, facing.getOpposite());
    }
	
	@Override
	public void breakBlock(World world, BlockPos pos, IBlockState state) 
	{
		TileEntityLabTable tile = getTileEntity(world, pos);
		IItemHandler itemHandler = tile.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, EnumFacing.NORTH);
		for(int i = 0; i < itemHandler.getSlots(); i++)
		{
			ItemStack stack = itemHandler.getStackInSlot(i);
			if(!stack.isEmpty())
			{
				EntityItem item = new EntityItem(world, pos.getX(), pos.getY(), pos.getZ(), stack);
				world.spawnEntity(item);
			}
		}
		super.breakBlock(world, pos, state);
	}
}
