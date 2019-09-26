package com.hamhub7.labday.block.labtable.packet;

import com.hamhub7.labday.block.labtable.TileEntityLabTable;

import io.netty.buffer.ByteBuf;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class PacketRequestUpdateLabTable implements IMessage
{
	private BlockPos pos;
	private int dimension;
	
	public PacketRequestUpdateLabTable(BlockPos pos, int dimension) 
	{
		this.pos = pos;
		this.dimension = dimension;
	}
	
	public PacketRequestUpdateLabTable(TileEntityLabTable te) 
	{
		this(te.getPos(), te.getWorld().provider.getDimension());
	}
	
	public PacketRequestUpdateLabTable() {}
	
	@Override
	public void fromBytes(ByteBuf buf) 
	{
		buf.writeLong(pos.toLong());
		buf.writeInt(dimension);
	}

	@Override
	public void toBytes(ByteBuf buf) 
	{
		pos = BlockPos.fromLong(buf.readLong());
		dimension = buf.readInt();
	}
	
	public static class Handler implements IMessageHandler<PacketRequestUpdateLabTable, PacketUpdateLabTable>
	{

		@Override
		public PacketUpdateLabTable onMessage(PacketRequestUpdateLabTable message, MessageContext ctx) 
		{
			World world = FMLCommonHandler.instance().getMinecraftServerInstance().getWorld(message.dimension);
			TileEntityLabTable te = (TileEntityLabTable)world.getTileEntity(message.pos);
			if(te != null)
			{
				return new PacketUpdateLabTable(te);
			}
			return null;
		}
		
	}
}
