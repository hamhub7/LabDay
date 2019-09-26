package com.hamhub7.labday.block.labtable.packet;

import com.hamhub7.labday.block.labtable.TileEntityLabTable;

import io.netty.buffer.ByteBuf;
import net.minecraft.client.Minecraft;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.fml.common.network.ByteBufUtils;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
import net.minecraftforge.items.ItemStackHandler;

public class PacketUpdateLabTable implements IMessage
{
	private BlockPos pos;
	private ItemStackHandler stacks;
	
	public PacketUpdateLabTable(BlockPos pos, ItemStackHandler stacks)
	{
		this.pos = pos;
		this.stacks = stacks;
	}
	
	public PacketUpdateLabTable(TileEntityLabTable te) 
	{
		this(te.getPos(), te.inventory);
	}
	
	public PacketUpdateLabTable() {}

	@Override
	public void fromBytes(ByteBuf buf) 
	{
		buf.writeLong(pos.toLong());
		for(int i = 0; i < stacks.getSlots(); i++)
		{
			ByteBufUtils.writeItemStack(buf, stacks.getStackInSlot(i));
		}
		
	}

	@Override
	public void toBytes(ByteBuf buf) 
	{
		pos = BlockPos.fromLong(buf.readLong());
		for(int i = 0; i < stacks.getSlots(); i++)
		{
			stacks.setStackInSlot(i, ByteBufUtils.readItemStack(buf));
		}
	}
	
	public static class Handler implements IMessageHandler<PacketUpdateLabTable, IMessage>
	{
		@Override
		public IMessage onMessage(PacketUpdateLabTable message, MessageContext ctx) 
		{
			Minecraft.getMinecraft().addScheduledTask(() ->
			{
				TileEntityLabTable te = (TileEntityLabTable)Minecraft.getMinecraft().world.getTileEntity(message.pos);
				for(int i = 0; i < message.stacks.getSlots(); i++)
				{
					te.inventory.setStackInSlot(i, message.stacks.getStackInSlot(i));
				}
			});
			return null;
		}
	}
}
