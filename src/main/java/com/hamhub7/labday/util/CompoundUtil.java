package com.hamhub7.labday.util;

import com.google.common.collect.Lists;

import net.minecraft.util.NonNullList;

public class CompoundUtil 
{
	private static NonNullList<String> fullName = NonNullList.<String>withSize(Compounds.values().length, "");
	private static NonNullList<String> formulas = NonNullList.<String>withSize(Compounds.values().length, "");
	private static NonNullList<Integer> meltingPoints = NonNullList.<Integer>withSize(Compounds.values().length, 0);
	private static NonNullList<Integer> boilingPoints = NonNullList.<Integer>withSize(Compounds.values().length, 0);
	private static NonNullList<Double> molarMasses = NonNullList.<Double>withSize(Compounds.values().length, 0.0);
	private static NonNullList<Double> densities = NonNullList.<Double>withSize(Compounds.values().length, 0.0);
	private static NonNullList<String> models = NonNullList.<String>withSize(Compounds.values().length, "compound_1");
	
	public enum Compounds
	{
		C5H8,
		SiO2,
		Ag2S,
		BaSO4,
		Al$OH$3,
		AlO$OH$,
		Be3Al2$SiO3$6,
		Cu5FeS4,
		SnO2,
		Cu2S,
		CuFeS2,
		MgCr2O4,
		FeCr2O4,
		HgS,
		CoAsS,
		FeAsS4,
		FeNb2O6,
		FeTa2O6,
		MnNb2O6,
		MnTa2O6,
		CaMg$CO3$2,
		PbS,
		Fe2O3,
		FeTiO3,
		Fe3O4,
		Cu2CO3$OH$2,
		MoS2,
		Fe9S8,
		Ni9S8,
		MnO,
		CaWO4,
		PtAs2,
		ZnS,
		UO2,
		FeO4W,
		W$MnO4$4;
	}
	
	public static void init()
	{
		setData(0, "Isoprene", "C5H8", 129, 307, 68.12, 0.681);
		setData(1, "Silicon Dioxide", "SiO2", 1986, 3220, 60.08, 2.196);
		setData(2, "Silver Sulfide", "Ag2S", 1109, 0, 247.80, 7.234);
		setData(3, "Barite", "BaSO4", 0, 0, 0, 4.48);
		setData(4, "Aluminum Hydroxide", "Al(OH)3", 0, 0, 78.00, 2.42);
		setData(5, "Aluminum Oxyhydroxide", "AlO(OH)", 0, 0, 59.99, 3.01);
		setData(6, "Beryl", "Be3Al2(SiO3)6", 0, 0, 537.50, 0);
		setData(7, "Bornite", "Cu5FeS4", 0, 0, 501.88, 0);
		setData(8, "Tin Dioxide", "SnO2", 1900, 2170, 150.71, 6.95);
		setData(9, "Copper(I) SUlfide", "Cu2S", 1400, 0, 159.16, 5.6);
		setData(10, "Chalcopyrite", "CuFeS2", 0, 0, 183.54, 0);
		setData(11, "Chromite", "MgCr2O4", 0, 0, 0, 0);
		setData(12, "Chromite", "FeCr2O4", 0, 0, 0, 0);
		setData(13, "Mercury Sulfide", "HgS", 853, 0, 232.66, 8.10);
		setData(14, "SiliconDioxide", "SiO2", 1986, 3220, 6008, 2196);
		setData(15, "SiliconDioxide", "SiO2", 1986, 3220, 6008, 2196);
		setData(16, "SiliconDioxide", "SiO2", 1986, 3220, 6008, 2196);
		setData(17, "SiliconDioxide", "SiO2", 1986, 3220, 6008, 2196);
		setData(18, "SiliconDioxide", "SiO2", 1986, 3220, 6008, 2196);
		setData(19, "SiliconDioxide", "SiO2", 1986, 3220, 6008, 2196);
		setData(20, "SiliconDioxide", "SiO2", 1986, 3220, 6008, 2196);
		setData(21, "SiliconDioxide", "SiO2", 1986, 3220, 6008, 2196);
		setData(22, "SiliconDioxide", "SiO2", 1986, 3220, 6008, 2196);
		setData(23, "SiliconDioxide", "SiO2", 1986, 3220, 6008, 2196);
		setData(24, "SiliconDioxide", "SiO2", 1986, 3220, 6008, 2196);
		setData(25, "SiliconDioxide", "SiO2", 1986, 3220, 6008, 2196);
		setData(26, "SiliconDioxide", "SiO2", 1986, 3220, 6008, 2196);
		setData(27, "SiliconDioxide", "SiO2", 1986, 3220, 6008, 2196);
		setData(28, "SiliconDioxide", "SiO2", 1986, 3220, 6008, 2196);
		setData(29, "SiliconDioxide", "SiO2", 1986, 3220, 6008, 2196);
		setData(30, "SiliconDioxide", "SiO2", 1986, 3220, 6008, 2196);
		setData(31, "SiliconDioxide", "SiO2", 1986, 3220, 6008, 2196);
		setData(32, "SiliconDioxide", "SiO2", 1986, 3220, 6008, 2196);
		setData(33, "SiliconDioxide", "SiO2", 1986, 3220, 6008, 2196);
		setData(34, "SiliconDioxide", "SiO2", 1986, 3220, 6008, 2196);
		setData(35, "SiliconDioxide", "SiO2", 1986, 3220, 6008, 2196);
	}
	
	private static void setData(int index, String name, String formula, int meltingPoint, int boilingPoint, double molarMass, double density)
	{
		fullName.set(index, name);
		formulas.set(index, formula);
		meltingPoints.set(index, meltingPoint);
		boilingPoints.set(index, boilingPoint);
		molarMasses.set(index, molarMass);
		densities.set(index, density);
	}
	
	public static void setModels()
	{
		models.set(0, "compound_1");
		models.set(1, "compound_1");
		models.set(2, "compound_1");
		models.set(3, "compound_1");
		models.set(4, "compound_1");
		models.set(5, "compound_1");
		models.set(6, "compound_1");
		models.set(7, "compound_1");
		models.set(8, "compound_1");
		models.set(9, "compound_1");
		models.set(10, "compound_1");
		models.set(11, "compound_1");
		models.set(12, "compound_1");
		models.set(13, "compound_1");
		models.set(14, "compound_1");
		models.set(15, "compound_1");
		models.set(16, "compound_1");
		models.set(17, "compound_1");
		models.set(18, "compound_1");
		models.set(19, "compound_1");
		models.set(20, "compound_1");
		models.set(21, "compound_1");
		models.set(22, "compound_1");
		models.set(23, "compound_1");
		models.set(24, "compound_1");
		models.set(25, "compound_1");
		models.set(26, "compound_1");
		models.set(27, "compound_1");
		models.set(28, "compound_1");
		models.set(29, "compound_1");
		models.set(30, "compound_1");
		models.set(31, "compound_1");
		models.set(32, "compound_1");
		models.set(33, "compound_1");
		models.set(34, "compound_1");
		models.set(35, "compound_1");
	}
	
	public static String getModel(int meta)
	{
		return models.get(meta);
	}
}
