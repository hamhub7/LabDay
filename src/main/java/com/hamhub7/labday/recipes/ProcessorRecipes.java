package com.hamhub7.labday.recipes;

import java.util.List;

import com.hamhub7.labday.block.ModBlocks;
import com.hamhub7.labday.item.ModItems;

import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;

public class ProcessorRecipes 
{
	private static final ProcessorRecipes instance = new ProcessorRecipes();
	private NonNullList<ItemStack> inputList = NonNullList.<ItemStack>withSize(26, ItemStack.EMPTY);
	private NonNullList<ItemStack> outputList1 = NonNullList.<ItemStack>withSize(26, ItemStack.EMPTY);
	private NonNullList<ItemStack> outputList2 = NonNullList.<ItemStack>withSize(26, ItemStack.EMPTY);
	private NonNullList<ItemStack> outputList3 = NonNullList.<ItemStack>withSize(26, ItemStack.EMPTY);
	
	public static ProcessorRecipes getInstance()
	{
		return instance;
	}
	
	public ProcessorRecipes() 
	{
		this.init();
	}
	
	public void init() 
	{
		addProcessorRecipe(new ItemStack(ModBlocks.oreAcanthite, 1), new ItemStack(ModItems.compound, 1, 3), ItemStack.EMPTY, ItemStack.EMPTY, 0);
		addProcessorRecipe(new ItemStack(ModBlocks.oreBarite, 1), new ItemStack(ModItems.compound, 1, 4), ItemStack.EMPTY, ItemStack.EMPTY, 1);
		addProcessorRecipe(new ItemStack(Blocks.EMERALD_ORE, 1), new ItemStack(ModItems.compound, 1, 7), ItemStack.EMPTY, ItemStack.EMPTY, 2);
		addProcessorRecipe(new ItemStack(ModBlocks.oreBornite, 1), new ItemStack(ModItems.compound, 1, 8), ItemStack.EMPTY, ItemStack.EMPTY, 3);
		addProcessorRecipe(new ItemStack(ModBlocks.oreCassiterite, 1), new ItemStack(ModItems.compound, 1, 10), ItemStack.EMPTY, ItemStack.EMPTY, 4);
		addProcessorRecipe(new ItemStack(ModBlocks.oreChalcocite, 1), new ItemStack(ModItems.compound, 1), ItemStack.EMPTY, ItemStack.EMPTY, 5);
		addProcessorRecipe(new ItemStack(ModBlocks.oreChalcopyrite, 1), new ItemStack(ModItems.compound, 1, 11), ItemStack.EMPTY, ItemStack.EMPTY, 6);
		addProcessorRecipe(new ItemStack(ModBlocks.oreCinnabar, 1), new ItemStack(ModItems.compound, 1, 15), ItemStack.EMPTY, ItemStack.EMPTY, 7);
		addProcessorRecipe(new ItemStack(ModBlocks.oreDolomite, 1), new ItemStack(ModItems.compound, 1, 22), ItemStack.EMPTY, ItemStack.EMPTY, 8);
		addProcessorRecipe(new ItemStack(ModBlocks.oreGalena, 1), new ItemStack(ModItems.compound, 1, 23), ItemStack.EMPTY, ItemStack.EMPTY, 9);
		addProcessorRecipe(new ItemStack(ModBlocks.oreHematite, 1), new ItemStack(ModItems.compound, 1, 24), ItemStack.EMPTY, ItemStack.EMPTY, 10);
		addProcessorRecipe(new ItemStack(ModBlocks.oreIlmenite, 1), new ItemStack(ModItems.compound, 1, 25), ItemStack.EMPTY, ItemStack.EMPTY, 11);
		addProcessorRecipe(new ItemStack(ModBlocks.oreMagnetite, 1), new ItemStack(ModItems.compound, 1, 26), ItemStack.EMPTY, ItemStack.EMPTY, 12);
		addProcessorRecipe(new ItemStack(ModBlocks.oreMalachite, 1), new ItemStack(ModItems.compound, 1, 27), ItemStack.EMPTY, ItemStack.EMPTY, 13);
		addProcessorRecipe(new ItemStack(ModBlocks.oreMolybdenite, 1), new ItemStack(ModItems.compound, 1, 28), ItemStack.EMPTY, ItemStack.EMPTY, 14);
		addProcessorRecipe(new ItemStack(ModBlocks.orePyrolusite, 1), new ItemStack(ModItems.compound, 1, 31), ItemStack.EMPTY, ItemStack.EMPTY, 15);
		addProcessorRecipe(new ItemStack(ModBlocks.oreScheelite, 1), new ItemStack(ModItems.compound, 1, 32), ItemStack.EMPTY, ItemStack.EMPTY, 16);
		addProcessorRecipe(new ItemStack(ModBlocks.oreSperrylite, 1), new ItemStack(ModItems.compound, 1, 33), ItemStack.EMPTY, ItemStack.EMPTY, 17);
		addProcessorRecipe(new ItemStack(ModBlocks.oreSphalerite, 1), new ItemStack(ModItems.compound, 1, 34), ItemStack.EMPTY, ItemStack.EMPTY, 18);
		addProcessorRecipe(new ItemStack(ModBlocks.oreUraninite, 1), new ItemStack(ModItems.compound, 1, 35), ItemStack.EMPTY, ItemStack.EMPTY, 19);
		addProcessorRecipe(new ItemStack(ModBlocks.oreBauxite, 1), new ItemStack(ModItems.compound, 1, 5), new ItemStack(ModItems.compound, 1, 6), ItemStack.EMPTY, 20);
		addProcessorRecipe(new ItemStack(ModBlocks.oreChromite, 1), new ItemStack(ModItems.compound, 1, 12), new ItemStack(ModItems.compound, 1, 13), ItemStack.EMPTY, 21);
		addProcessorRecipe(new ItemStack(ModBlocks.oreCobaltite, 1), new ItemStack(ModItems.compound, 1, 15), new ItemStack(ModItems.compound, 1, 16), ItemStack.EMPTY, 22);
		addProcessorRecipe(new ItemStack(ModBlocks.oreColtan, 1), new ItemStack(ModItems.compound, 1, 17), new ItemStack(ModItems.compound, 1, 18), new ItemStack(ModItems.compound, 1, 19), 23);
		addProcessorRecipe(new ItemStack(ModBlocks.orePentlandite, 1), new ItemStack(ModItems.compound, 1, 29), new ItemStack(ModItems.compound, 1, 30), ItemStack.EMPTY, 24);
		addProcessorRecipe(new ItemStack(ModBlocks.oreWolframite, 1), new ItemStack(ModItems.compound, 1, 36), new ItemStack(ModItems.compound, 1, 37), ItemStack.EMPTY, 25);
	}
	
	public void addProcessorRecipe(ItemStack input, ItemStack output1, ItemStack output2, ItemStack output3, int index)
	{
		if(getProcessorResult1(input) != ItemStack.EMPTY || getProcessorResult2(input) != ItemStack.EMPTY || getProcessorResult3(input) != ItemStack.EMPTY) return;
		this.inputList.set(index, input);
		this.outputList1.set(index, output1);
		this.outputList2.set(index, output2);
		this.outputList3.set(index, output3);
	}
	
	public ItemStack getProcessorResult1(ItemStack input)
	{
		if(this.inputList == null || this.outputList1 == null)
		{
			return ItemStack.EMPTY;
		}
		for(int index = 0; index < this.inputList.size(); index++)
		{
			if(this.outputList1.get(index) != ItemStack.EMPTY)
			{
				if(compareItemStacks(this.inputList.get(index), input))
				{
					return this.outputList1.get(index);
				}
			}
		}
		return ItemStack.EMPTY;
	}
	
	public ItemStack getProcessorResult2(ItemStack input)
	{
		if(this.inputList == null || this.outputList2 == null)
		{
			return ItemStack.EMPTY;
		}
		for(int index = 0; index < this.inputList.size(); index++)
		{
			if(this.outputList1.get(index) != ItemStack.EMPTY)
			{
				if(compareItemStacks(this.inputList.get(index), input))
				{
					return this.outputList2.get(index);
				}
			}
		}
		return ItemStack.EMPTY;
	}
	
	public ItemStack getProcessorResult3(ItemStack input)
	{
		if(this.inputList == null || this.outputList3 == null)
		{
			return ItemStack.EMPTY;
		}
		for(int index = 0; index < this.inputList.size(); index++)
		{
			if(this.outputList1.get(index) != ItemStack.EMPTY)
			{
				if(compareItemStacks(this.inputList.get(index), input))
				{
					return this.outputList3.get(index);
				}
			}
		}
		return ItemStack.EMPTY;
	}
	
	private boolean compareItemStacks(ItemStack stack1, ItemStack stack2)
	{
		if(stack1 == ItemStack.EMPTY || stack2 == ItemStack.EMPTY || stack1 == null || stack2 == null)
		{
			return false;
		}
		else
		{
			
			return stack2.getItem() == stack1.getItem() && (stack2.getMetadata() == stack1.getMetadata());
		}
	}
}
