package com.hamhub7.labday.block.processor;

import javax.annotation.Nullable;

import com.hamhub7.labday.item.ModItems;
import com.hamhub7.labday.recipes.ProcessorRecipes;

import net.darkhax.tesla.api.ITeslaHolder;
import net.darkhax.tesla.api.ITeslaProducer;
import net.darkhax.tesla.api.implementation.BaseTeslaContainer;
import net.darkhax.tesla.capability.TeslaCapabilities;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ITickable;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.ItemStackHandler;

public class TileEntityProcessor extends TileEntity implements ITickable
{
	private ItemStackHandler inventory = new ItemStackHandler(6);
	private static BaseTeslaContainer container;
	public static int COOK_TIMER = 200;
	public static int POWER_USAGE = 40;
	public static final int MAX_CAPACITY = 1000000;
	public static final int RATE = 1000;
	public static int cookTime;
	private int lastCookTime;
	public boolean burnFlag = false;
	public static ItemStack input;
	
	private SoundEvent sound;
	
	public TileEntityProcessor() 
	{
		this.container = new BaseTeslaContainer(MAX_CAPACITY, RATE, RATE);
	}
	
	@Override
	public NBTTagCompound writeToNBT(NBTTagCompound compound) 
	{
		compound.setTag("inventory", inventory.serializeNBT());
		compound.setTag("TeslaContainer", this.container.serializeNBT());
		compound.setInteger("cookTime", cookTime);
		return super.writeToNBT(compound);
	}
	
	@Override
	public void readFromNBT(NBTTagCompound compound) 
	{
		inventory.deserializeNBT(compound.getCompoundTag("inventory"));
		this.container = new BaseTeslaContainer(compound.getCompoundTag("TeslaContainer"));
		this.cookTime = compound.getInteger("cookTime");
		super.readFromNBT(compound);
	}
	
	@Override
	public boolean hasCapability(Capability<?> capability, @Nullable EnumFacing facing) 
	{
		if(capability == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY || capability == TeslaCapabilities.CAPABILITY_CONSUMER || capability == TeslaCapabilities.CAPABILITY_PRODUCER || capability == TeslaCapabilities.CAPABILITY_HOLDER)
		{
			return true;
		}
		return super.hasCapability(capability, facing);
	}
	
	@Nullable
	@Override
	public <T> T getCapability(Capability<T> capability, @Nullable EnumFacing facing) 
	{
		if(capability == TeslaCapabilities.CAPABILITY_CONSUMER || capability == TeslaCapabilities.CAPABILITY_PRODUCER || capability == TeslaCapabilities.CAPABILITY_HOLDER)
		{
			return (T)this.container;
		}
		else if(capability == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY)
		{
			return (T)this.inventory;
		}
		return super.getCapability(capability, facing);
	}
	
	@Override
	public void update()
	{
		if(!world.isRemote)
		{
			final ITeslaProducer producer = this.getCapability(TeslaCapabilities.CAPABILITY_PRODUCER, EnumFacing.NORTH);
			ItemStack inputSlot = inventory.getStackInSlot(0);
			ItemStack outputSlot1 = inventory.getStackInSlot(1);
			ItemStack outputSlot2 = inventory.getStackInSlot(2);
			ItemStack outputSlot3 = inventory.getStackInSlot(3);
			if(!inputSlot.isEmpty() && producer.takePower(POWER_USAGE, true) == this.POWER_USAGE && this.canProcess1(inputSlot, outputSlot1) && this.canProcess2(inputSlot, outputSlot2) && this.canProcess3(inputSlot, outputSlot3))
			{
				this.input = inputSlot;
				burnFlag = true;
				this.cookTime++;
				producer.takePower(this.POWER_USAGE, false);
				if(this.cookTime >= COOK_TIMER)
				{
					finishCooking(0, 1, 2, 3);
					this.cookTime = 0;
				}	
			}
			else
			{
				if(inputSlot.isEmpty())
				{
					this.cookTime = 0;
				}
				burnFlag = false;
			}
			
			if(this.lastCookTime != this.cookTime)
			{
				this.lastCookTime = this.cookTime;
			}
	
			BlockProcessor.setState(burnFlag, world, pos);
			
			if(burnFlag)
			{
				//Play Sound Somehow *Implement Later*
			}
		}
		
		ItemStack upgrade1 = inventory.getStackInSlot(4);
		ItemStack upgrade2 = inventory.getStackInSlot(5);
		if(upgrade1.getItem() == ModItems.speedUpgrade || upgrade2.getItem() == ModItems.speedUpgrade)
		{
			if(upgrade1.getItem() == ModItems.speedUpgrade && upgrade2.getItem() == ModItems.speedUpgrade)
			{
				this.COOK_TIMER = 50;
			}
			else
			{
				this.COOK_TIMER = 100;
			}
		}
	}
	
	public boolean canProcess1(ItemStack inputSlot, ItemStack outputSlot1)
	{
		ItemStack output1 = ProcessorRecipes.getInstance().getProcessorResult1(inputSlot);
		output1.setCount(1);
		if(output1.isEmpty())
		{
			return false;
		}
		if(outputSlot1.isEmpty())
		{
			return true;
		}
		if(!outputSlot1.isItemEqual(output1))
		{
			return false;
		}
		int totalItems = 1 + outputSlot1.getCount();
		return totalItems <= 64;
	}
	
	public boolean canProcess2(ItemStack inputSlot, ItemStack outputSlot2)
	{
		ItemStack output2 = ProcessorRecipes.getInstance().getProcessorResult2(inputSlot);
		output2.setCount(1);
		if(output2.isEmpty())
		{
			if(ProcessorRecipes.getInstance().getProcessorResult1(inputSlot) == ItemStack.EMPTY)
			{
				return false;
			}
			else
			{
				return true;
			}
		}
		if(outputSlot2.isEmpty())
		{
			return true;
		}
		if(!outputSlot2.isItemEqual(output2))
		{
			return false;
		}
		int totalItems = 1 + outputSlot2.getCount();
		return totalItems <= 64;
	}
	
	public boolean canProcess3(ItemStack inputSlot, ItemStack outputSlot3)
	{
		ItemStack output3 = ProcessorRecipes.getInstance().getProcessorResult3(inputSlot);
		output3.setCount(1);
		if(output3.isEmpty())
		{
			if(ProcessorRecipes.getInstance().getProcessorResult1(inputSlot) == ItemStack.EMPTY)
			{
				return false;
			}
			else
			{
				return true;
			}
		}
		if(outputSlot3.isEmpty())
		{
			return true;
		}
		if(!outputSlot3.isItemEqual(output3))
		{
			return false;
		}
		int totalItems = 1 + outputSlot3.getCount();
		return totalItems <= 64;
	}
	
	public void finishCooking(int inputSlot, int outputSlot1, int outputSlot2, int outputSlot3)
	{
		ItemStack result1 = ProcessorRecipes.getInstance().getProcessorResult1(this.inventory.getStackInSlot(inputSlot));
		if(this.inventory.getStackInSlot(outputSlot1).isEmpty())
		{
			this.inventory.setStackInSlot(outputSlot1, result1.copy());
		}
		else if(this.inventory.getStackInSlot(outputSlot1).getItem() == result1.getItem())
		{
			this.inventory.setStackInSlot(outputSlot1, new ItemStack(result1.getItem(), this.inventory.getStackInSlot(outputSlot1).getCount() + 1));
		}
		
		ItemStack result2 = ProcessorRecipes.getInstance().getProcessorResult2(this.inventory.getStackInSlot(inputSlot));
		if(recipeAmount() >= 2)
		{
			if(this.inventory.getStackInSlot(outputSlot2).isEmpty())
			{
				this.inventory.setStackInSlot(outputSlot2, result2.copy());
			}
			else if(this.inventory.getStackInSlot(outputSlot2).getItem() == result2.getItem())
			{
				this.inventory.setStackInSlot(outputSlot2, new ItemStack(result2.getItem(), this.inventory.getStackInSlot(outputSlot2).getCount() + 1));
			}
		}
		
		ItemStack result3 = ProcessorRecipes.getInstance().getProcessorResult3(this.inventory.getStackInSlot(inputSlot));
		if(recipeAmount() >= 3)
		{
			if(this.inventory.getStackInSlot(outputSlot3).isEmpty())
			{
				this.inventory.setStackInSlot(outputSlot3, result3.copy());
			}
			else if(this.inventory.getStackInSlot(outputSlot3).getItem() == result3.getItem())
			{
				this.inventory.setStackInSlot(outputSlot3, new ItemStack(result3.getItem(), this.inventory.getStackInSlot(outputSlot3).getCount() + 1));
			}
		}
		
		this.inventory.setStackInSlot(inputSlot, new ItemStack(this.inventory.getStackInSlot(inputSlot).getItem(), this.inventory.getStackInSlot(inputSlot).getCount() - 1));
	}
	
	public static int getCookProgressScaled(int pixels)
	{
		int i = cookTime;
		return i != 0 ? i * pixels / COOK_TIMER : 0;
	}
	
	public static int getEnergyScaled(int pixels)
	{
		int j = (int)container.getStoredPower();
		return j != 0 ? (MAX_CAPACITY - j) * pixels / MAX_CAPACITY : 0;
	}
	
	public static int recipeAmount()
	{
		ItemStack result1 = ProcessorRecipes.getInstance().getProcessorResult1(input);
		ItemStack result2 = ProcessorRecipes.getInstance().getProcessorResult2(input);
		ItemStack result3 = ProcessorRecipes.getInstance().getProcessorResult3(input);
		if(result1 == ItemStack.EMPTY)
		{
			return 0;
		}
		if(result2 == ItemStack.EMPTY)
		{
			return 1;
		}
		if(result3 == ItemStack.EMPTY)
		{
			return 2;
		}
		return 3;
	}
}
