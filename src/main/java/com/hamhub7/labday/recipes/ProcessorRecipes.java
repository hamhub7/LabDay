package com.hamhub7.labday.recipes;

import java.util.List;

import com.hamhub7.labday.block.ModBlocks;
import com.hamhub7.labday.item.ModItems;

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
		addProcessorRecipe(new ItemStack(ModBlocks.oreAcanthite, 1), new ItemStack(ModItems.silverSulfide, 1), ItemStack.EMPTY, ItemStack.EMPTY, 0);
		addProcessorRecipe(new ItemStack(ModBlocks.oreBarite, 1), new ItemStack(ModItems.bariumSulfate, 1), ItemStack.EMPTY, ItemStack.EMPTY, 1);
		addProcessorRecipe(new ItemStack(ModBlocks.oreBeryl, 1), new ItemStack(ModItems.berylliumAluminumMetasilicate, 1), ItemStack.EMPTY, ItemStack.EMPTY, 2);
		addProcessorRecipe(new ItemStack(ModBlocks.oreBornite, 1), new ItemStack(ModItems.Cu5FeS4, 1), ItemStack.EMPTY, ItemStack.EMPTY, 3);
		addProcessorRecipe(new ItemStack(ModBlocks.oreCassiterite, 1), new ItemStack(ModItems.stannicOxide, 1), ItemStack.EMPTY, ItemStack.EMPTY, 4);
		addProcessorRecipe(new ItemStack(ModBlocks.oreChalcocite, 1), new ItemStack(ModItems.cuprousSulfide, 1), ItemStack.EMPTY, ItemStack.EMPTY, 5);
		addProcessorRecipe(new ItemStack(ModBlocks.oreChalcopyrite, 1), new ItemStack(ModItems.copperIronSulfide, 1), ItemStack.EMPTY, ItemStack.EMPTY, 6);
		addProcessorRecipe(new ItemStack(ModBlocks.oreCinnabar, 1), new ItemStack(ModItems.mercurousSulfide, 1), ItemStack.EMPTY, ItemStack.EMPTY, 7);
		addProcessorRecipe(new ItemStack(ModBlocks.oreDolomite, 1), new ItemStack(ModItems.dolomiteRock, 1), ItemStack.EMPTY, ItemStack.EMPTY, 8);
		addProcessorRecipe(new ItemStack(ModBlocks.oreGalena, 1), new ItemStack(ModItems.plumbousSulfide, 1), ItemStack.EMPTY, ItemStack.EMPTY, 9);
		addProcessorRecipe(new ItemStack(ModBlocks.oreHematite, 1), new ItemStack(ModItems.ferricOxide, 1), ItemStack.EMPTY, ItemStack.EMPTY, 10);
		addProcessorRecipe(new ItemStack(ModBlocks.oreIlmenite, 1), new ItemStack(ModItems.ferrousTitanate, 1), ItemStack.EMPTY, ItemStack.EMPTY, 11);
		addProcessorRecipe(new ItemStack(ModBlocks.oreMagnetite, 1), new ItemStack(ModItems.ironOxide, 1), ItemStack.EMPTY, ItemStack.EMPTY, 12);
		addProcessorRecipe(new ItemStack(ModBlocks.oreMalachite, 1), new ItemStack(ModItems.malachite, 1), ItemStack.EMPTY, ItemStack.EMPTY, 13);
		addProcessorRecipe(new ItemStack(ModBlocks.oreMolybdenite, 1), new ItemStack(ModItems.molybdenumSulfide, 1), ItemStack.EMPTY, ItemStack.EMPTY, 14);
		addProcessorRecipe(new ItemStack(ModBlocks.orePyrolusite, 1), new ItemStack(ModItems.manganeseOxide, 1), ItemStack.EMPTY, ItemStack.EMPTY, 15);
		addProcessorRecipe(new ItemStack(ModBlocks.oreScheelite, 1), new ItemStack(ModItems.calciumTungstate, 1), ItemStack.EMPTY, ItemStack.EMPTY, 16);
		addProcessorRecipe(new ItemStack(ModBlocks.oreSperrylite, 1), new ItemStack(ModItems.platinumArsenide, 1), ItemStack.EMPTY, ItemStack.EMPTY, 17);
		addProcessorRecipe(new ItemStack(ModBlocks.oreSphalerite, 1), new ItemStack(ModItems.zincSulfide, 1), ItemStack.EMPTY, ItemStack.EMPTY, 18);
		addProcessorRecipe(new ItemStack(ModBlocks.oreUraninite, 1), new ItemStack(ModItems.uraniumDioxide, 1), ItemStack.EMPTY, ItemStack.EMPTY, 19);
		addProcessorRecipe(new ItemStack(ModBlocks.oreBauxite, 1), new ItemStack(ModItems.aluminumHydroxide, 1), new ItemStack(ModItems.AlOOH, 1), ItemStack.EMPTY, 20);
		addProcessorRecipe(new ItemStack(ModBlocks.oreChromite, 1), new ItemStack(ModItems.ferrousChromite, 1), new ItemStack(ModItems.MgCr2O4, 1), ItemStack.EMPTY, 21);
		addProcessorRecipe(new ItemStack(ModBlocks.oreCobaltite, 1), new ItemStack(ModItems.CoAsS, 1), new ItemStack(ModItems.ferricSulfoarsenate, 1), ItemStack.EMPTY, 22);
		addProcessorRecipe(new ItemStack(ModBlocks.oreColtan, 1), new ItemStack(ModItems.FeNb2O6, 1), new ItemStack(ModItems.FeTa2O6, 1), new ItemStack(ModItems.MnNb2O6, 1), 23);
		addProcessorRecipe(new ItemStack(ModBlocks.orePentlandite, 1), new ItemStack(ModItems.Fe9S8, 1), new ItemStack(ModItems.Ni9S8, 1), ItemStack.EMPTY, 24);
		addProcessorRecipe(new ItemStack(ModBlocks.oreWolframite, 1), new ItemStack(ModItems.ferrousTungstate, 1), new ItemStack(ModItems.tungstenPermanganate, 1), ItemStack.EMPTY, 25);
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
			
			return stack2.getItem() == stack1.getItem() && (stack2.getMetadata() == 32767 || stack2.getMetadata() == stack1.getMetadata());
		}
	}
}
