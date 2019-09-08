package com.hamhub7.labday.block;

import com.hamhub7.labday.block.creativepower.BlockCreativePower;
import com.hamhub7.labday.block.creativevoid.BlockCreativeVoid;
import com.hamhub7.labday.block.labtable.BlockLabTable;
import com.hamhub7.labday.block.notebook.BlockTextbook;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.registries.IForgeRegistry;

public class ModBlocks 
{
	//Ores
	public static BlockOres oreAcanthite = new BlockOres("ore_acanthite", "oreAcanthite");
	public static BlockOres oreBarite = new BlockOres("ore_barite", "oreBarite");
	public static BlockOres oreBauxite = new BlockOres("ore_bauxite", "oreBauxite");
	public static BlockOres oreBeryl = new BlockOres("ore_beryl", "oreBeryl");
	public static BlockOres oreBornite = new BlockOres("ore_bornite", "oreBornite");
	public static BlockOres oreCassiterite = new BlockOres("ore_cassiterite", "oreCassiterite");
	public static BlockOres oreChalcocite = new BlockOres("ore_chalcocite", "oreChalcocite");
	public static BlockOres oreChalcopyrite = new BlockOres("ore_chalcopyrite", "oreChalcopyrite");
	public static BlockOres oreChromite = new BlockOres("ore_chromite", "oreChromite");
	public static BlockOres oreCinnabar = new BlockOres("ore_cinnabar", "oreCinnabar");
	public static BlockOres oreCobaltite = new BlockOres("ore_cobaltite", "oreCobaltite");
	public static BlockOres oreColtan = new BlockOres("ore_coltan", "oreColtan");
	public static BlockOres oreDolomite = new BlockOres("ore_dolomite", "oreDolomite");
	public static BlockOres oreGalena = new BlockOres("ore_galena", "oreGalena");
	public static BlockOres oreHematite = new BlockOres("ore_hematite", "oreHematite");
	public static BlockOres oreIlmenite = new BlockOres("ore_ilmenite", "oreIlmenite");
	public static BlockOres oreMagnetite = new BlockOres("ore_magnetite", "oreMagnetite");
	public static BlockOres oreMalachite = new BlockOres("ore_malachite", "oreMalachite");
	public static BlockOres oreMolybdenite = new BlockOres("ore_molybdenite", "oreMolybdenite");
	public static BlockOres orePentlandite = new BlockOres("ore_pentlandite", "orePentlandite");
	public static BlockOres orePyrolusite = new BlockOres("ore_pyrolusite", "orePyrolusite");
	public static BlockOres oreScheelite = new BlockOres("ore_scheelite", "oreScheelite");
	public static BlockOres oreSperrylite = new BlockOres("ore_sperrylite", "oreSperrylite");
	public static BlockOres oreSphalerite = new BlockOres("ore_sphalerite", "oreSphalerite");
	public static BlockOres oreUraninite = new BlockOres("ore_uraninite", "oreUraninite");
	public static BlockOres oreWolframite = new BlockOres("ore_wolframite", "oreWolframite");
	
	//Machines
	public static BlockCreativePower creativePower = new BlockCreativePower();
	public static BlockCreativeVoid creativeVoid = new BlockCreativeVoid();
	public static BlockLabTable labTable = new BlockLabTable();
	public static BlockTextbook notebook = new BlockTextbook();
	
	//Extra
	
	public static void register(IForgeRegistry<Block> registry)
	{
		GameRegistry.registerTileEntity(creativePower.getTileEntityClass(), creativePower.getRegistryName().toString());
		GameRegistry.registerTileEntity(creativeVoid.getTileEntityClass(), creativeVoid.getRegistryName().toString());
		GameRegistry.registerTileEntity(labTable.getTileEntityClass(), labTable.getRegistryName().toString());
		GameRegistry.registerTileEntity(notebook.getTileEntityClass(), notebook.getRegistryName().toString());
		registry.registerAll
		(
			oreAcanthite,
			oreBarite,
			oreBauxite,
			oreBeryl,
			oreBornite,
			oreCassiterite,
			oreChalcocite,
			oreChalcopyrite,
			oreChromite,
			oreCinnabar,
			oreCobaltite,
			oreColtan,
			oreDolomite,
			oreGalena,
			oreHematite,
			oreIlmenite,
			oreMagnetite,
			oreMalachite,
			oreMolybdenite,
			orePentlandite,
			orePyrolusite,
			oreScheelite,
			oreSperrylite,
			oreSphalerite,
			oreUraninite,
			oreWolframite,
			creativePower,
			creativeVoid,
			labTable,
			notebook
		);
	}
	
	public static void registerItemBlocks(IForgeRegistry<Item> registry)
	{	
		registry.registerAll
		(
			oreAcanthite.createItemBlock(),
			oreBarite.createItemBlock(),
			oreBauxite.createItemBlock(),
			oreBeryl.createItemBlock(),
			oreBornite.createItemBlock(),
			oreCassiterite.createItemBlock(),
			oreChalcocite.createItemBlock(),
			oreChalcopyrite.createItemBlock(),
			oreChromite.createItemBlock(),
			oreCinnabar.createItemBlock(),
			oreCobaltite.createItemBlock(),
			oreColtan.createItemBlock(),
			oreDolomite.createItemBlock(),
			oreGalena.createItemBlock(),
			oreHematite.createItemBlock(),
			oreIlmenite.createItemBlock(),
			oreMagnetite.createItemBlock(),
			oreMalachite.createItemBlock(),
			oreMolybdenite.createItemBlock(),
			orePentlandite.createItemBlock(),
			orePyrolusite.createItemBlock(),
			oreScheelite.createItemBlock(),
			oreSperrylite.createItemBlock(),
			oreSphalerite.createItemBlock(),
			oreUraninite.createItemBlock(),
			oreWolframite.createItemBlock(),
			creativePower.createItemBlock(),
			creativeVoid.createItemBlock(),
			labTable.createItemBlock(),
			notebook.createItemBlock()
		);
	}
	
	public static void registerModels()
	{
		oreAcanthite.registerItemModel(Item.getItemFromBlock(oreAcanthite));
		oreBarite.registerItemModel(Item.getItemFromBlock(oreBarite));
		oreBauxite.registerItemModel(Item.getItemFromBlock(oreBauxite));
		oreBeryl.registerItemModel(Item.getItemFromBlock(oreBeryl));
		oreBornite.registerItemModel(Item.getItemFromBlock(oreBornite));
		oreCassiterite.registerItemModel(Item.getItemFromBlock(oreCassiterite));
		oreChalcocite.registerItemModel(Item.getItemFromBlock(oreChalcocite));
		oreChalcopyrite.registerItemModel(Item.getItemFromBlock(oreChalcopyrite));
		oreChromite.registerItemModel(Item.getItemFromBlock(oreChromite));
		oreCinnabar.registerItemModel(Item.getItemFromBlock(oreCinnabar));
		oreCobaltite.registerItemModel(Item.getItemFromBlock(oreCobaltite));
		oreColtan.registerItemModel(Item.getItemFromBlock(oreColtan));
		oreDolomite.registerItemModel(Item.getItemFromBlock(oreDolomite));
		oreGalena.registerItemModel(Item.getItemFromBlock(oreGalena));
		oreHematite.registerItemModel(Item.getItemFromBlock(oreHematite));
		oreIlmenite.registerItemModel(Item.getItemFromBlock(oreIlmenite));
		oreMagnetite.registerItemModel(Item.getItemFromBlock(oreMagnetite));
		oreMalachite.registerItemModel(Item.getItemFromBlock(oreMalachite));
		oreMolybdenite.registerItemModel(Item.getItemFromBlock(oreMolybdenite));
		orePentlandite.registerItemModel(Item.getItemFromBlock(orePentlandite));
		orePyrolusite.registerItemModel(Item.getItemFromBlock(orePyrolusite));
		oreScheelite.registerItemModel(Item.getItemFromBlock(oreScheelite));
		oreSperrylite.registerItemModel(Item.getItemFromBlock(oreSperrylite));
		oreSphalerite.registerItemModel(Item.getItemFromBlock(oreSphalerite));
		oreUraninite.registerItemModel(Item.getItemFromBlock(oreUraninite));
		oreWolframite.registerItemModel(Item.getItemFromBlock(oreWolframite));
		creativePower.registerItemModel(Item.getItemFromBlock(creativePower));
		creativeVoid.registerItemModel(Item.getItemFromBlock(creativeVoid));
		labTable.registerItemModel(Item.getItemFromBlock(labTable));
		notebook.registerItemModel(Item.getItemFromBlock(notebook));
	}
}
