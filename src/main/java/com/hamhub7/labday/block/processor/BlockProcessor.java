package com.hamhub7.labday.block.processor;

import com.hamhub7.labday.LabDay;
import com.hamhub7.labday.block.BlockTileEntity;
import com.hamhub7.labday.block.ModBlocks;
import com.hamhub7.labday.util.GuiHandler;

import net.darkhax.tesla.api.ITeslaHolder;
import net.darkhax.tesla.capability.TeslaCapabilities;
import net.minecraft.block.BlockHorizontal;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;

public class BlockProcessor extends BlockTileEntity<TileEntityProcessor>
{
	public static final PropertyDirection FACING = BlockHorizontal.FACING;
	public static final PropertyBool PROCESSING = PropertyBool.create("processing");
	
	public BlockProcessor() 
	{
		super(Material.IRON, "processor");
		this.setDefaultState(this.blockState.getBaseState().withProperty(FACING, EnumFacing.NORTH).withProperty(PROCESSING, false));
	}
	
	@Override
	public Class<TileEntityProcessor> getTileEntityClass() 
	{
		return TileEntityProcessor.class;
	}
	
	@Override
	public TileEntityProcessor createTileEntity(World world, IBlockState state) 
	{
		return new TileEntityProcessor();
	}
	
	@Override
	public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) 
	{
		if(!world.isRemote)
		{
			if(!player.isSneaking())
			{
				player.openGui(LabDay.instance, GuiHandler.GuiList.PROCESSOR.ordinal(), world, pos.getX(), pos.getY(), pos.getZ());
			}
			else
			{
				final TileEntity tile = world.getTileEntity(pos);
				if(tile.hasCapability(TeslaCapabilities.CAPABILITY_HOLDER, facing))
				{
					final ITeslaHolder holder = tile.getCapability(TeslaCapabilities.CAPABILITY_HOLDER, facing);
					Minecraft.getMinecraft().ingameGUI.getChatGUI().printChatMessageWithOptionalDeletion(new TextComponentString(I18n.format("tooltip.labday.battery.normal", holder.getStoredPower(), holder.getCapacity())), 14940026);
				}
			}
		}
		return true;
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
			world.setBlockState(pos, ModBlocks.processor.getDefaultState().withProperty(FACING, state.getValue(FACING)).withProperty(PROCESSING, true), 3);
		}
		else
		{
			world.setBlockState(pos, ModBlocks.processor.getDefaultState().withProperty(FACING, state.getValue(FACING)).withProperty(PROCESSING, false), 3);
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
		return new BlockStateContainer(this, new IProperty[] {PROCESSING,FACING});
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
	
	@Override
	public void breakBlock(World world, BlockPos pos, IBlockState state) 
	{
		TileEntityProcessor tile = getTileEntity(world, pos);
		IItemHandler itemHandler = tile.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, EnumFacing.NORTH);
		ItemStack stack0 = itemHandler.getStackInSlot(0);
		ItemStack stack1 = itemHandler.getStackInSlot(1);
		ItemStack stack2 = itemHandler.getStackInSlot(2);
		ItemStack stack3 = itemHandler.getStackInSlot(3);
		ItemStack stack4 = itemHandler.getStackInSlot(4);
		ItemStack stack5 = itemHandler.getStackInSlot(5);
		if(!stack0.isEmpty())
		{
			EntityItem item0 = new EntityItem(world, pos.getX(), pos.getY(), pos.getZ(), stack0);
			world.spawnEntity(item0);
		}
		if(!stack1.isEmpty())
		{
			EntityItem item1 = new EntityItem(world, pos.getX(), pos.getY(), pos.getZ(), stack1);
			world.spawnEntity(item1);
		}
		if(!stack2.isEmpty())
		{
			EntityItem item2 = new EntityItem(world, pos.getX(), pos.getY(), pos.getZ(), stack2);
			world.spawnEntity(item2);
		}
		if(!stack3.isEmpty())
		{
			EntityItem item3 = new EntityItem(world, pos.getX(), pos.getY(), pos.getZ(), stack3);
			world.spawnEntity(item3);
		}
		if(!stack4.isEmpty())
		{
			EntityItem item4 = new EntityItem(world, pos.getX(), pos.getY(), pos.getZ(), stack4);
			world.spawnEntity(item4);
		}
		if(!stack5.isEmpty())
		{
			EntityItem item5 = new EntityItem(world, pos.getX(), pos.getY(), pos.getZ(), stack5);
			world.spawnEntity(item5);
		}
		super.breakBlock(world, pos, state);
	}
}
