package com.hamhub7.labday.item;

import com.hamhub7.labday.item.ItemUpgrade.UpgradeType;
import com.hamhub7.labday.util.ElementUtil;

import net.minecraft.item.Item;
import net.minecraftforge.registries.IForgeRegistry;

public class ModItems
{	
	public static ItemUpgrade speedUpgrade = new ItemUpgrade(UpgradeType.speed);
	public static ItemUpgrade efficiencyUpgrade = new ItemUpgrade(UpgradeType.efficiency);
	public static ItemUpgrade baseUpgrade = new ItemUpgrade(UpgradeType.base);
	public static ItemElement element = new ItemElement();
	public static ItemCompound compound = new ItemCompound();
	public static UnstackableItemBase wrench = new UnstackableItemBase("wrench");
	
	public static void register(IForgeRegistry<Item> registry)
	{
		registry.registerAll
		(
			speedUpgrade,
			efficiencyUpgrade,
			baseUpgrade,
			element,
			compound,
			wrench
		);
	}

	public static void registerModels()
	{
		speedUpgrade.registerItemModel();
		efficiencyUpgrade.registerItemModel();
		baseUpgrade.registerItemModel();
		element.registerItemModel();
		compound.registerItemModel();
		wrench.registerItemModel();
	}
}
