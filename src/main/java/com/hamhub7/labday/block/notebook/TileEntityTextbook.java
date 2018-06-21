package com.hamhub7.labday.block.notebook;

import java.util.List;

import javax.annotation.Nullable;

import com.google.common.collect.Lists;
import com.hamhub7.labday.block.labtable.BlockLabTable;
import com.hamhub7.labday.block.labtable.TileEntityLabTable;

import net.darkhax.tesla.api.implementation.BaseTeslaContainer;
import net.darkhax.tesla.capability.TeslaCapabilities;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.I18n;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ITickable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.ItemStackHandler;

public class TileEntityTextbook extends TileEntity
{
	public static List<BlockPos> tables = Lists.newArrayList();
	
	public TileEntityTextbook()
	{
		
	}
	
	@Override
	public void onLoad() 
	{
		recalculateMultiblock();
	}
	
	public void recalculateMultiblock() 
	{
		this.destroyMulitblock();
		if(getWorld().getBlockState(getPos().down()).getBlock() instanceof BlockLabTable)
		{
			BlockPos labBelow = getPos().down();
			this.tables.add(labBelow);
			this.findAndAddTables(labBelow);
		}
		this.createMultiblock();
	}
	
	private void findAndAddTables(BlockPos startPos)
	{
		List<BlockPos> tablesAround = searchForTablesAround(startPos);
		addToTables(tablesAround);
		if(!tablesAround.isEmpty())
		{
			for(BlockPos newPos : tablesAround)
			{
				findAndAddTables(newPos);
			}
		}
	}
	
	private List<BlockPos> searchForTablesAround(BlockPos startPos)
	{
		List<BlockPos> list = Lists.newArrayList();
		
		BlockPos posNorth = startPos.north();
		if(getWorld().getBlockState(posNorth).getBlock() instanceof BlockLabTable && verifyAgainstList(posNorth, this.tables))
		{
			list.add(posNorth);
		}
		
		BlockPos posSouth = startPos.south();
		if(getWorld().getBlockState(posSouth).getBlock() instanceof BlockLabTable && verifyAgainstList(posSouth, this.tables))
		{
			list.add(posSouth);
		}
		
		BlockPos posEast = startPos.east();
		if(getWorld().getBlockState(posEast).getBlock() instanceof BlockLabTable && verifyAgainstList(posEast, this.tables))
		{
			list.add(posEast);
		}
		
		BlockPos posWest = startPos.west();
		if(getWorld().getBlockState(posWest).getBlock() instanceof BlockLabTable && verifyAgainstList(posWest, this.tables))
		{
			list.add(posWest);
		}
		
		return list;
	}
	
	private boolean addToTables(List<BlockPos> listToAdd)
	{
		List<BlockPos> list = this.tables;
		for(BlockPos pos : listToAdd)
		{
			if(verifyAgainstList(pos, this.tables))
			{
				this.tables.add(pos);
			}
		}
		
		if(this.tables == list)
		{
			return false;
		}
		return true;
	}
	
	private boolean verifyAgainstList(BlockPos test, List<BlockPos> list)
	{
		for(BlockPos pos : list)
		{
			if(test.getX() == pos.getX() && test.getZ() == pos.getZ())
			{
				return false;
			}
		}
		return true;
	}
	
	public void createMultiblock()
	{
		for(BlockPos pos : this.tables)
		{
			Block block = getWorld().getBlockState(pos).getBlock();
			if(!(block instanceof BlockLabTable))
			{
				destroyMulitblock();
			}
			TileEntityLabTable tile = (TileEntityLabTable)getWorld().getTileEntity(pos);
			tile.addMaster(getPos());
		}
	}
	
	public void destroyMulitblock()
	{
		for(BlockPos pos : this.tables)
		{
			Block block = getWorld().getBlockState(pos).getBlock();
			if(block instanceof BlockLabTable)
			{
				TileEntityLabTable tile = (TileEntityLabTable)getWorld().getTileEntity(pos);
				tile.deleteMaster();
			}
		}
		this.tables.clear();
	}
}
