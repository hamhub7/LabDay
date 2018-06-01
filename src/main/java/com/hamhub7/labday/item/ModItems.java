package com.hamhub7.labday.item;

import com.hamhub7.labday.util.ElementUtil;

import net.minecraft.item.Item;
import net.minecraftforge.registries.IForgeRegistry;

public class ModItems
{	
	public static ItemBase speedUpgrade = new ItemBase("speed_upgrade");
	public static ItemElement element = new ItemElement();
	
	//Ore Products
	public static ItemBase silverSulfide = new ItemBase("silver_sulfide");
	public static ItemBase bariumSulfate = new ItemBase("barium_sulfate");
	public static ItemBase aluminumHydroxide = new ItemBase("aluminum_hydroxide");
	public static ItemBase AlOOH = new ItemBase("AlOOH");
	public static ItemBase berylliumAluminumMetasilicate = new ItemBase("beryllium_aluminum_metasilicate");
	public static ItemBase Cu5FeS4 = new ItemBase("Cu5FeS4");
	public static ItemBase stannicOxide = new ItemBase("stannic_oxide");
	public static ItemBase cuprousSulfide = new ItemBase("cuprous_sulfide");
	public static ItemBase copperIronSulfide = new ItemBase("copper_iron_sulfide");
	public static ItemBase MgCr2O4 = new ItemBase("MgCr2O4");
	public static ItemBase ferrousChromite = new ItemBase("ferrous_chromite");
	public static ItemBase mercurousSulfide = new ItemBase("mercurous_sulfide");
	public static ItemBase CoAsS = new ItemBase("CoAsS");
	public static ItemBase ferricSulfoarsenate = new ItemBase("ferric_sulfoarsenate");
	public static ItemBase FeNb2O6 = new ItemBase("FeNb2O6");
	public static ItemBase FeTa2O6 = new ItemBase("FeTa2O6");
	public static ItemBase MnNb2O6 = new ItemBase("MnNb2O6");
	public static ItemBase MnTa2O6 = new ItemBase("MnTa2O6");
	public static ItemBase dolomiteRock = new ItemBase("dolomite_rock");
	public static ItemBase plumbousSulfide = new ItemBase("plumbous_sulfide");
	public static ItemBase ferricOxide = new ItemBase("ferric_oxide");
	public static ItemBase ferrousTitanate = new ItemBase("ferrous_titanate");
	public static ItemBase ironOxide = new ItemBase("iron_oxide");
	public static ItemBase malachite = new ItemBase("malachite");
	public static ItemBase molybdenumSulfide = new ItemBase("molybdenum_sulfide");
	public static ItemBase Fe9S8 = new ItemBase("Fe9S8");
	public static ItemBase Ni9S8 = new ItemBase("Ni9S8");
	public static ItemBase manganeseOxide = new ItemBase("manganese_oxide");
	public static ItemBase calciumTungstate = new ItemBase("calcium_tungstate");
	public static ItemBase platinumArsenide = new ItemBase("platinum_arsenide");
	public static ItemBase zincSulfide = new ItemBase("zinc_sulfide");
	public static ItemBase uraniumDioxide = new ItemBase("uranium_dioxide");
	public static ItemBase ferrousTungstate = new ItemBase("ferrous_tungstate");
	public static ItemBase tungstenPermanganate = new ItemBase("tungsten_permanganate");
	
	public static void register(IForgeRegistry<Item> registry)
	{
		registry.registerAll
		(
			silverSulfide,
			bariumSulfate,
			aluminumHydroxide,
			AlOOH,
			berylliumAluminumMetasilicate,
			Cu5FeS4,
			stannicOxide,
			cuprousSulfide,
			copperIronSulfide,
			MgCr2O4,
			ferrousChromite,
			mercurousSulfide,
			CoAsS,
			ferricSulfoarsenate,
			FeNb2O6,
			FeTa2O6,
			MnNb2O6,
			MnTa2O6,
			dolomiteRock,
			plumbousSulfide,
			ferricOxide,
			ferrousTitanate,
			ironOxide,
			malachite,
			molybdenumSulfide,
			Fe9S8,
			Ni9S8,
			manganeseOxide,
			calciumTungstate,
			platinumArsenide,
			zincSulfide,
			uraniumDioxide,
			ferrousTungstate,
			tungstenPermanganate,
			speedUpgrade,
			element
		);
	}

	public static void registerModels()
	{
		silverSulfide.registerItemModel();
		bariumSulfate.registerItemModel();
		aluminumHydroxide.registerItemModel();
		AlOOH.registerItemModel();
		berylliumAluminumMetasilicate.registerItemModel();
		Cu5FeS4.registerItemModel();
		stannicOxide.registerItemModel();
		cuprousSulfide.registerItemModel();
		copperIronSulfide.registerItemModel();
		MgCr2O4.registerItemModel();
		ferrousChromite.registerItemModel();
		mercurousSulfide.registerItemModel();
		CoAsS.registerItemModel();
		ferricSulfoarsenate.registerItemModel();
		FeNb2O6.registerItemModel();
		FeTa2O6.registerItemModel();
		MnNb2O6.registerItemModel();
		MnTa2O6.registerItemModel();
		dolomiteRock.registerItemModel();
		plumbousSulfide.registerItemModel();
		ferricOxide.registerItemModel();
		ferrousTitanate.registerItemModel();
		ironOxide.registerItemModel();
		malachite.registerItemModel();
		molybdenumSulfide.registerItemModel();
		Fe9S8.registerItemModel();
		Ni9S8.registerItemModel();
		manganeseOxide.registerItemModel();
		calciumTungstate.registerItemModel();
		platinumArsenide.registerItemModel();
		zincSulfide.registerItemModel();
		uraniumDioxide.registerItemModel();
		ferrousTungstate.registerItemModel();
		tungstenPermanganate.registerItemModel();
		speedUpgrade.registerItemModel();
		element.registerItemModel();
	}
}
