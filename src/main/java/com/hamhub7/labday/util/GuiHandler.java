package com.hamhub7.labday.util;

import com.hamhub7.labday.block.labtable.ContainerLabTable;
import com.hamhub7.labday.block.labtable.GuiLabTable;
import com.hamhub7.labday.block.notebook.GuiTextbook;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

public class GuiHandler implements IGuiHandler
{	
	@Override
	public Container getServerGuiElement(int id, EntityPlayer player, World world, int x, int y, int z) 
	{	
		TileEntity tile = null;
		if(GuiList.values()[id].checkTileEntity)
		{
			tile = (TileEntity)world.getTileEntity(new BlockPos(x, y, z));
		}
		switch(GuiList.values()[id])
		{
		case LABTABLE:
			return new ContainerLabTable(player.inventory, tile);
		case TEXTBOOK:
			return null;
		default:
			return null;
		}
	}
	
	@Override
	public Object getClientGuiElement(int id, EntityPlayer player, World world, int x, int y, int z) 
	{
		TileEntity tile = null;
		if(GuiList.values()[id].checkTileEntity)
		{
			tile = (TileEntity)world.getTileEntity(new BlockPos(x, y, z));
		}
		switch(GuiList.values()[id])
		{
		case LABTABLE:
			return new GuiLabTable(player.inventory, tile);
		case TEXTBOOK:
			return new GuiTextbook();
		default:
			return null;
		}
	}
	
	public enum GuiList
	{
		LABTABLE,
		TEXTBOOK;
		
		public final boolean checkTileEntity;
		
		GuiList()
		{
			this(true);
		}
		
		GuiList(boolean checkTileEntity)
		{
			this.checkTileEntity = checkTileEntity;
		}
	}
}
