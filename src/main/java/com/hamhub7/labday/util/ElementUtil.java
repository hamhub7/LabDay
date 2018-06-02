package com.hamhub7.labday.util;

import javax.annotation.Nullable;

import com.hamhub7.labday.recipes.ProcessorRecipes;

import net.minecraft.util.NonNullList;

public class ElementUtil 
{
	private static final ElementUtil instance = new ElementUtil();
	
	public static ElementUtil getInstance()
	{
		return instance;
	}
	
	public void init()
	{
		addTemps();
		addWeights();
		addDensities();
		addSpecHeats();
		addElecNegs();
	}
	
	public static enum PeriodicTable
	{
		generic,
		h,
		he,
		li,
		be,
		b,
		c,
		n,
		o,
		f,
		ne,
		na,
		mg,
		al,
		si,
		p,
		s,
		cl,
		ar,
		k,
		ca,
		sc,
		ti,
		v,
		cr,
		mn,
		fe,
		co,
		ni,
		cu,
		zn,
		ga,
		ge,
		as,
		se,
		br,
		kr,
		rb,
		sr,
		y,
		zr,
		nb,
		mo,
		tc,
		ru,
		rh,
		pd,
		ag,
		cd,
		in,
		sn,
		sb,
		te,
		i,
		xe,
		cs,
		ba,
		la,
		ce,
		pr,
		nd,
		pm,
		sm,
		eu,
		gd,
		tb,
		dy,
		ho,
		er,
		tm,
		yb,
		lu,
		hf,
		ta,
		w,
		re,
		os,
		ir,
		pt,
		au,
		hg,
		tl,
		pb,
		bi,
		po,
		at,
		rn,
		fr,
		ra,
		ac,
		th,
		pa,
		u,
		np,
		pu,
		am,
		cm,
		bk,
		cf,
		es,
		fm,
		md,
		no,
		lr,
		rf,
		db,
		sg,
		bh,
		hs,
		mt,
		ds,
		rg,
		cn,
		nh,
		fl,
		mc,
		lv,
		ts,
		og;
		
		
	}
	
	private static NonNullList<Integer> boilingPoint = NonNullList.<Integer>withSize(119, 0);
	private static NonNullList<Integer> meltingPoint = NonNullList.<Integer>withSize(119, 0);
	
	public void addTemps()
	{
		addTemperatures(0, 1, 0);
		addTemperatures(14, 20, 1);
		addTemperatures(0000, 4, 2);
		addTemperatures(454, 1560, 3);
		addTemperatures(1560, 2742, 4);
		addTemperatures(2349, 4200, 5);
		addTemperatures(3800, 4300, 6);
		addTemperatures(63, 77, 7);
		addTemperatures(54, 90, 8);
		addTemperatures(53, 85, 9);
		addTemperatures(25, 27, 10);
		addTemperatures(371, 1156, 11);
		addTemperatures(923, 1363, 12);
		addTemperatures(933, 2792, 13);
		addTemperatures(1687, 3538, 14);
		addTemperatures(317, 550, 15);
		addTemperatures(388, 718, 16);
		addTemperatures(172, 239, 17);
		addTemperatures(84, 87, 18);
		addTemperatures(337, 1032, 19);
		addTemperatures(1115, 1757, 20);
		addTemperatures(1814, 3109, 21);
		addTemperatures(1941, 3560, 22);
		addTemperatures(2183, 3680, 23);
		addTemperatures(2180, 2944, 24);
		addTemperatures(1519, 2334, 25);
		addTemperatures(1811, 3134, 26);
		addTemperatures(1768, 3200, 27);
		addTemperatures(1728, 3186, 28);
		addTemperatures(1358, 2835, 29);
		addTemperatures(693, 1180, 30);
		addTemperatures(303, 2673, 31);
		addTemperatures(1211, 3106, 32);
		addTemperatures(1090, 887, 33);
		addTemperatures(453, 958, 34);
		addTemperatures(266, 332, 35);
		addTemperatures(116, 120, 36);
		addTemperatures(312, 961, 37);
		addTemperatures(1050, 1655, 38);
		addTemperatures(1799, 3609, 39);
		addTemperatures(2128, 4682, 40);
		addTemperatures(2750, 5017, 41);
		addTemperatures(2896, 4912, 42);
		addTemperatures(2430, 4538, 43);
		addTemperatures(2607, 4423, 44);
		addTemperatures(2237, 3968, 45);
		addTemperatures(1828, 3236, 46);
		addTemperatures(1235, 2435, 47);
		addTemperatures(594, 1040, 48);
		addTemperatures(430, 2345, 49);
		addTemperatures(505, 2875, 50);
		addTemperatures(904, 1860, 51);
		addTemperatures(723, 1261, 52);
		addTemperatures(387, 457, 53);
		addTemperatures(161, 165, 54);
		addTemperatures(301, 944, 55);
		addTemperatures(1000, 2170, 56);
		addTemperatures(1193, 3737, 57);
		addTemperatures(1068, 3716, 58);
		addTemperatures(1208, 3793, 59);
		addTemperatures(1297, 3347, 60);
		addTemperatures(1315, 3273, 61);
		addTemperatures(1345, 2067, 62);
		addTemperatures(1099, 1802, 63);
		addTemperatures(1585, 3546, 64);
		addTemperatures(1629, 3503, 65);
		addTemperatures(1680, 2840, 66);
		addTemperatures(1734, 2993, 67);
		addTemperatures(1802, 3141, 68);
		addTemperatures(1818, 2223, 69);
		addTemperatures(1097, 1469, 70);
		addTemperatures(1925, 3675, 71);
		addTemperatures(2506, 4876, 72);
		addTemperatures(3290, 5731, 73);
		addTemperatures(3695, 5828, 74);
		addTemperatures(3459, 5869, 75);
		addTemperatures(3306, 5285, 76);
		addTemperatures(2719, 4701, 77);
		addTemperatures(2041, 4098, 78);
		addTemperatures(1337, 3129, 79);
		addTemperatures(234, 630, 80);
		addTemperatures(577, 1746, 81);
		addTemperatures(601, 2022, 82);
		addTemperatures(545, 1837, 83);
		addTemperatures(527, 1235, 84);
		addTemperatures(575, 610, 85);
		addTemperatures(202, 211, 86);
		addTemperatures(300, 950, 87);
		addTemperatures(973, 2010, 88);
		addTemperatures(1323, 3471, 89);
		addTemperatures(2115, 5061, 90);
		addTemperatures(1841, 4300, 91);
		addTemperatures(1405, 4404, 92);
		addTemperatures(917, 4273, 93);
		addTemperatures(912, 3501, 94);
		addTemperatures(1449, 2880, 95);
		addTemperatures(1613, 3383, 96);
		addTemperatures(1259, 2900, 97);
		addTemperatures(1173, 1743, 98);
		addTemperatures(1133, 1269, 99);
		addTemperatures(1125, 1000000, 100);
		addTemperatures(1100, 1000000, 101);
		addTemperatures(1100, 1000000, 102);
		addTemperatures(1900, 1000000, 103);
		addTemperatures(2400, 5800, 104);
		addTemperatures(0000, 1000000, 105);
		addTemperatures(0000, 1000000, 106);
		addTemperatures(0000, 1000000, 107);
		addTemperatures(0000, 1000000, 108);
		addTemperatures(0000, 1000000, 109);
		addTemperatures(0000, 1000000, 110);
		addTemperatures(0000, 1000000, 111);
		addTemperatures(0000, 357, 112);
		addTemperatures(700, 1400, 113);
		addTemperatures(0000, 210, 114);
		addTemperatures(700, 1400, 115);
		addTemperatures(709, 1085, 116);
		addTemperatures(723, 883, 117);
		addTemperatures(0000, 350, 118);
	}
	
	public static int getBoilingPoint(int meta)
	{
		return boilingPoint.get(meta);
	}
	
	public static int getMeltingPoint(int meta)
	{
		return meltingPoint.get(meta);
	}
	
	public static Phase getPhase(int meta, int temp)
	{
		int boil = getBoilingPoint(meta);
		int melt = getMeltingPoint(meta);
		if(temp <= melt)
		{
			return Phase.Solid;
		}
		if(temp <= boil)
		{
			return Phase.Liquid;
		}
		return Phase.Gas;
	}
	
	public void addTemperatures(int melt, int boil, int index)
	{
		this.meltingPoint.set(index, melt);
		this.boilingPoint.set(index, boil);
	}
	
	public enum Phase
	{
		Solid,
		Liquid,
		Gas
	}
	
	private static NonNullList<Float> atomicWeights = NonNullList.<Float>withSize(119, 0F);
	
	public void addWeights()
	{
		addWeight(0F, 0);
		addWeight(1.01F, 1);
		addWeight(4F, 2);
		addWeight(6.94F, 3);
		addWeight(9.01F, 4);
		addWeight(10.81F, 5);
		addWeight(12.01F, 6);
		addWeight(14.01F, 7);
		addWeight(16F, 8);
		addWeight(19F, 9);
		addWeight(20.18F, 10);
		addWeight(22.99F, 11);
		addWeight(24.31F, 12);
		addWeight(26.98F, 13);
		addWeight(28.09F, 14);
		addWeight(30.97F, 15);
		addWeight(32.06F, 16);
		addWeight(35.45F, 17);
		addWeight(39.95F, 18);
		addWeight(39.2F, 19);
		addWeight(40.08F, 20);
		addWeight(44.96F, 21);
		addWeight(47.87F, 22);
		addWeight(50.94F, 23);
		addWeight(52F, 24);
		addWeight(54.94F, 25);
		addWeight(55.85F, 26);
		addWeight(58.93F, 27);
		addWeight(58.69F, 28);
		addWeight(63.55F, 29);
		addWeight(65.38F, 30);
		addWeight(69.72F, 31);
		addWeight(72.63F, 32);
		addWeight(74.92F, 33);
		addWeight(78.97F, 34);
		addWeight(79.9F, 35);
		addWeight(83.8F, 36);
		addWeight(85.47F, 37);
		addWeight(87.62F, 38);
		addWeight(88.91F, 39);
		addWeight(91.22F, 40);
		addWeight(92.91F, 41);
		addWeight(95.95F, 42);
		addWeight(98F, 43);
		addWeight(101.07F, 44);
		addWeight(102.91F, 45);
		addWeight(106.42F, 46);
		addWeight(107.87F, 47);
		addWeight(112.41F, 48);
		addWeight(114.82F, 49);
		addWeight(118.71F, 50);
		addWeight(121.76F, 51);
		addWeight(127.6F, 52);
		addWeight(126.9F, 53);
		addWeight(131.29F, 54);
		addWeight(132.91F, 55);
		addWeight(137.33F, 56);
		addWeight(138.91F, 57);
		addWeight(140.12F, 58);
		addWeight(140.91F, 59);
		addWeight(144.24F, 60);
		addWeight(145F, 61);
		addWeight(150.36F, 62);
		addWeight(151.96F, 63);
		addWeight(157.25F, 64);
		addWeight(158.93F, 65);
		addWeight(162.5F, 66);
		addWeight(164.93F, 67);
		addWeight(167.26F, 68);
		addWeight(168.93F, 69);
		addWeight(173.05F, 70);
		addWeight(174.97F, 71);
		addWeight(178.49F, 72);
		addWeight(180.95F, 73);
		addWeight(183.84F, 74);
		addWeight(186.21F, 75);
		addWeight(190.23F, 76);
		addWeight(192.22F, 77);
		addWeight(195.08F, 78);
		addWeight(196.97F, 79);
		addWeight(200.59F, 80);
		addWeight(204.38F, 81);
		addWeight(207.2F, 82);
		addWeight(208.98F, 83);
		addWeight(209F, 84);
		addWeight(210F, 85);
		addWeight(222F, 86);
		addWeight(223F, 87);
		addWeight(226F, 88);
		addWeight(227F, 89);
		addWeight(232.04F, 90);
		addWeight(231.04F, 91);
		addWeight(238.03F, 92);
		addWeight(237F, 93);
		addWeight(244F, 94);
		addWeight(243F, 95);
		addWeight(247F, 96);
		addWeight(247F, 97);
		addWeight(251F, 98);
		addWeight(252F, 99);
		addWeight(257F, 100);
		addWeight(258F, 101);
		addWeight(259F, 102);
		addWeight(266F, 103);
		addWeight(267F, 104);
		addWeight(268F, 105);
		addWeight(269F, 106);
		addWeight(270F, 107);
		addWeight(277F, 108);
		addWeight(278F, 109);
		addWeight(281F, 110);
		addWeight(282F, 111);
		addWeight(285F, 112);
		addWeight(286F, 113);
		addWeight(289F, 114);
		addWeight(290F, 115);
		addWeight(293F, 116);
		addWeight(294F, 117);
		addWeight(294F, 118);
	}
	
	public void addWeight(float weight, int index)
	{
		atomicWeights.set(index, weight);
	}
	
	public static double getWeight(int meta)
	{
		return atomicWeights.get(meta);
	}
	
	private static NonNullList<Double> density = NonNullList.<Double>withSize(119, 0.0);
	
	public void addDensities()
	{
		addDensity(0, 0);
		addDensity(1.01, 1);
		addDensity(4, 2);
		addDensity(6.94, 3);
		addDensity(9.01, 4);
		addDensity(10.81, 5);
		addDensity(12.01, 6);
		addDensity(14.01, 7);
		addDensity(16, 8);
		addDensity(19, 9);
		addDensity(20.18, 10);
		addDensity(22.99, 11);
		addDensity(24.31, 12);
		addDensity(26.98, 13);
		addDensity(28.09, 14);
		addDensity(30.97, 15);
		addDensity(32.06, 16);
		addDensity(35.45, 17);
		addDensity(39.95, 18);
		addDensity(39.2, 19);
		addDensity(40.08, 20);
		addDensity(44.96, 21);
		addDensity(47.87, 22);
		addDensity(50.94, 23);
		addDensity(52, 24);
		addDensity(54.94, 25);
		addDensity(55.85, 26);
		addDensity(58.93, 27);
		addDensity(58.69, 28);
		addDensity(63.55, 29);
		addDensity(65.38, 30);
		addDensity(69.72, 31);
		addDensity(72.63, 32);
		addDensity(74.92, 33);
		addDensity(78.97, 34);
		addDensity(79.9, 35);
		addDensity(83.8, 36);
		addDensity(85.47, 37);
		addDensity(87.62, 38);
		addDensity(88.91, 39);
		addDensity(91.22, 40);
		addDensity(92.91, 41);
		addDensity(95.95, 42);
		addDensity(98, 43);
		addDensity(101.07, 44);
		addDensity(102.91, 45);
		addDensity(106.42, 46);
		addDensity(107.87, 47);
		addDensity(112.41, 48);
		addDensity(114.82, 49);
		addDensity(118.71, 50);
		addDensity(121.76, 51);
		addDensity(127.6, 52);
		addDensity(126.9, 53);
		addDensity(131.29, 54);
		addDensity(132.91, 55);
		addDensity(137.33, 56);
		addDensity(138.91, 57);
		addDensity(140.12, 58);
		addDensity(140.91, 59);
		addDensity(144.24, 60);
		addDensity(145, 61);
		addDensity(150.36, 62);
		addDensity(151.96, 63);
		addDensity(157.25, 64);
		addDensity(158.93, 65);
		addDensity(162.5, 66);
		addDensity(164.93, 67);
		addDensity(167.26, 68);
		addDensity(168.93, 69);
		addDensity(173.05, 70);
		addDensity(174.97, 71);
		addDensity(178.49, 72);
		addDensity(180.95, 73);
		addDensity(183.84, 74);
		addDensity(186.21, 75);
		addDensity(190.23, 76);
		addDensity(192.22, 77);
		addDensity(195.08, 78);
		addDensity(196.97, 79);
		addDensity(200.59, 80);
		addDensity(204.38, 81);
		addDensity(207.2, 82);
		addDensity(208.98, 83);
		addDensity(209, 84);
		addDensity(210, 85);
		addDensity(222, 86);
		addDensity(223, 87);
		addDensity(226, 88);
		addDensity(227, 89);
		addDensity(232.04, 90);
		addDensity(231.04, 91);
		addDensity(238.03, 92);
		addDensity(237, 93);
		addDensity(244, 94);
		addDensity(243, 95);
		addDensity(247, 96);
		addDensity(247, 97);
		addDensity(251, 98);
		addDensity(252, 99);
		addDensity(257, 100);
		addDensity(258, 101);
		addDensity(259, 102);
		addDensity(266, 103);
		addDensity(267, 104);
		addDensity(268, 105);
		addDensity(269, 106);
		addDensity(270, 107);
		addDensity(277, 108);
		addDensity(278, 109);
		addDensity(281, 110);
		addDensity(282, 111);
		addDensity(285, 112);
		addDensity(286, 113);
		addDensity(289, 114);
		addDensity(290, 115);
		addDensity(293, 116);
		addDensity(294, 117);
		addDensity(294, 118);
	}
	
	public void addDensity(double density, int index)
	{
		this.density.set(index, density);
	}
	
	public static double getDensity(int meta)
	{
		return density.get(meta);
	}
	
	private static NonNullList<Double> specificHeat = NonNullList.<Double>withSize(119, 0.0);
	
	public void addSpecHeats()
	{
		addSpecHeat(0, 0);
		addSpecHeat(1.01, 1);
		addSpecHeat(4, 2);
		addSpecHeat(6.94, 3);
		addSpecHeat(9.01, 4);
		addSpecHeat(10.81, 5);
		addSpecHeat(12.01, 6);
		addSpecHeat(14.01, 7);
		addSpecHeat(16, 8);
		addSpecHeat(19, 9);
		addSpecHeat(20.18, 10);
		addSpecHeat(22.99, 11);
		addSpecHeat(24.31, 12);
		addSpecHeat(26.98, 13);
		addSpecHeat(28.09, 14);
		addSpecHeat(30.97, 15);
		addSpecHeat(32.06, 16);
		addSpecHeat(35.45, 17);
		addSpecHeat(39.95, 18);
		addSpecHeat(39.2, 19);
		addSpecHeat(40.08, 20);
		addSpecHeat(44.96, 21);
		addSpecHeat(47.87, 22);
		addSpecHeat(50.94, 23);
		addSpecHeat(52, 24);
		addSpecHeat(54.94, 25);
		addSpecHeat(55.85, 26);
		addSpecHeat(58.93, 27);
		addSpecHeat(58.69, 28);
		addSpecHeat(63.55, 29);
		addSpecHeat(65.38, 30);
		addSpecHeat(69.72, 31);
		addSpecHeat(72.63, 32);
		addSpecHeat(74.92, 33);
		addSpecHeat(78.97, 34);
		addSpecHeat(79.9, 35);
		addSpecHeat(83.8, 36);
		addSpecHeat(85.47, 37);
		addSpecHeat(87.62, 38);
		addSpecHeat(88.91, 39);
		addSpecHeat(91.22, 40);
		addSpecHeat(92.91, 41);
		addSpecHeat(95.95, 42);
		addSpecHeat(98, 43);
		addSpecHeat(101.07, 44);
		addSpecHeat(102.91, 45);
		addSpecHeat(106.42, 46);
		addSpecHeat(107.87, 47);
		addSpecHeat(112.41, 48);
		addSpecHeat(114.82, 49);
		addSpecHeat(118.71, 50);
		addSpecHeat(121.76, 51);
		addSpecHeat(127.6, 52);
		addSpecHeat(126.9, 53);
		addSpecHeat(131.29, 54);
		addSpecHeat(132.91, 55);
		addSpecHeat(137.33, 56);
		addSpecHeat(138.91, 57);
		addSpecHeat(140.12, 58);
		addSpecHeat(140.91, 59);
		addSpecHeat(144.24, 60);
		addSpecHeat(145, 61);
		addSpecHeat(150.36, 62);
		addSpecHeat(151.96, 63);
		addSpecHeat(157.25, 64);
		addSpecHeat(158.93, 65);
		addSpecHeat(162.5, 66);
		addSpecHeat(164.93, 67);
		addSpecHeat(167.26, 68);
		addSpecHeat(168.93, 69);
		addSpecHeat(173.05, 70);
		addSpecHeat(174.97, 71);
		addSpecHeat(178.49, 72);
		addSpecHeat(180.95, 73);
		addSpecHeat(183.84, 74);
		addSpecHeat(186.21, 75);
		addSpecHeat(190.23, 76);
		addSpecHeat(192.22, 77);
		addSpecHeat(195.08, 78);
		addSpecHeat(196.97, 79);
		addSpecHeat(200.59, 80);
		addSpecHeat(204.38, 81);
		addSpecHeat(207.2, 82);
		addSpecHeat(208.98, 83);
		addSpecHeat(209, 84);
		addSpecHeat(210, 85);
		addSpecHeat(222, 86);
		addSpecHeat(223, 87);
		addSpecHeat(226, 88);
		addSpecHeat(227, 89);
		addSpecHeat(232.04, 90);
		addSpecHeat(231.04, 91);
		addSpecHeat(238.03, 92);
		addSpecHeat(237, 93);
		addSpecHeat(244, 94);
		addSpecHeat(243, 95);
		addSpecHeat(247, 96);
		addSpecHeat(247, 97);
		addSpecHeat(251, 98);
		addSpecHeat(252, 99);
		addSpecHeat(257, 100);
		addSpecHeat(258, 101);
		addSpecHeat(259, 102);
		addSpecHeat(266, 103);
		addSpecHeat(267, 104);
		addSpecHeat(268, 105);
		addSpecHeat(269, 106);
		addSpecHeat(270, 107);
		addSpecHeat(277, 108);
		addSpecHeat(278, 109);
		addSpecHeat(281, 110);
		addSpecHeat(282, 111);
		addSpecHeat(285, 112);
		addSpecHeat(286, 113);
		addSpecHeat(289, 114);
		addSpecHeat(290, 115);
		addSpecHeat(293, 116);
		addSpecHeat(294, 117);
		addSpecHeat(294, 118);
	}
	
	public void addSpecHeat(double specificHeat, int index)
	{
		this.specificHeat.set(index, specificHeat);
	}
	
	public static double getSpecHeat(int meta)
	{
		return specificHeat.get(meta);
	}
	
	private static NonNullList<Double> electronegativity = NonNullList.<Double>withSize(119, 0.0);
	
	public void addElecNegs()
	{
		addElecNeg(0, 0);
		addElecNeg(1.01, 1);
		addElecNeg(4, 2);
		addElecNeg(6.94, 3);
		addElecNeg(9.01, 4);
		addElecNeg(10.81, 5);
		addElecNeg(12.01, 6);
		addElecNeg(14.01, 7);
		addElecNeg(16, 8);
		addElecNeg(19, 9);
		addElecNeg(20.18, 10);
		addElecNeg(22.99, 11);
		addElecNeg(24.31, 12);
		addElecNeg(26.98, 13);
		addElecNeg(28.09, 14);
		addElecNeg(30.97, 15);
		addElecNeg(32.06, 16);
		addElecNeg(35.45, 17);
		addElecNeg(39.95, 18);
		addElecNeg(39.2, 19);
		addElecNeg(40.08, 20);
		addElecNeg(44.96, 21);
		addElecNeg(47.87, 22);
		addElecNeg(50.94, 23);
		addElecNeg(52, 24);
		addElecNeg(54.94, 25);
		addElecNeg(55.85, 26);
		addElecNeg(58.93, 27);
		addElecNeg(58.69, 28);
		addElecNeg(63.55, 29);
		addElecNeg(65.38, 30);
		addElecNeg(69.72, 31);
		addElecNeg(72.63, 32);
		addElecNeg(74.92, 33);
		addElecNeg(78.97, 34);
		addElecNeg(79.9, 35);
		addElecNeg(83.8, 36);
		addElecNeg(85.47, 37);
		addElecNeg(87.62, 38);
		addElecNeg(88.91, 39);
		addElecNeg(91.22, 40);
		addElecNeg(92.91, 41);
		addElecNeg(95.95, 42);
		addElecNeg(98, 43);
		addElecNeg(101.07, 44);
		addElecNeg(102.91, 45);
		addElecNeg(106.42, 46);
		addElecNeg(107.87, 47);
		addElecNeg(112.41, 48);
		addElecNeg(114.82, 49);
		addElecNeg(118.71, 50);
		addElecNeg(121.76, 51);
		addElecNeg(127.6, 52);
		addElecNeg(126.9, 53);
		addElecNeg(131.29, 54);
		addElecNeg(132.91, 55);
		addElecNeg(137.33, 56);
		addElecNeg(138.91, 57);
		addElecNeg(140.12, 58);
		addElecNeg(140.91, 59);
		addElecNeg(144.24, 60);
		addElecNeg(145, 61);
		addElecNeg(150.36, 62);
		addElecNeg(151.96, 63);
		addElecNeg(157.25, 64);
		addElecNeg(158.93, 65);
		addElecNeg(162.5, 66);
		addElecNeg(164.93, 67);
		addElecNeg(167.26, 68);
		addElecNeg(168.93, 69);
		addElecNeg(173.05, 70);
		addElecNeg(174.97, 71);
		addElecNeg(178.49, 72);
		addElecNeg(180.95, 73);
		addElecNeg(183.84, 74);
		addElecNeg(186.21, 75);
		addElecNeg(190.23, 76);
		addElecNeg(192.22, 77);
		addElecNeg(195.08, 78);
		addElecNeg(196.97, 79);
		addElecNeg(200.59, 80);
		addElecNeg(204.38, 81);
		addElecNeg(207.2, 82);
		addElecNeg(208.98, 83);
		addElecNeg(209, 84);
		addElecNeg(210, 85);
		addElecNeg(222, 86);
		addElecNeg(223, 87);
		addElecNeg(226, 88);
		addElecNeg(227, 89);
		addElecNeg(232.04, 90);
		addElecNeg(231.04, 91);
		addElecNeg(238.03, 92);
		addElecNeg(237, 93);
		addElecNeg(244, 94);
		addElecNeg(243, 95);
		addElecNeg(247, 96);
		addElecNeg(247, 97);
		addElecNeg(251, 98);
		addElecNeg(252, 99);
		addElecNeg(257, 100);
		addElecNeg(258, 101);
		addElecNeg(259, 102);
		addElecNeg(266, 103);
		addElecNeg(267, 104);
		addElecNeg(268, 105);
		addElecNeg(269, 106);
		addElecNeg(270, 107);
		addElecNeg(277, 108);
		addElecNeg(278, 109);
		addElecNeg(281, 110);
		addElecNeg(282, 111);
		addElecNeg(285, 112);
		addElecNeg(286, 113);
		addElecNeg(289, 114);
		addElecNeg(290, 115);
		addElecNeg(293, 116);
		addElecNeg(294, 117);
		addElecNeg(294, 118);
	}
	
	public void addElecNeg(double electronegativity, int index)
	{
		this.electronegativity.set(index, electronegativity);
	}
	
	public static double getElecNeg(int meta)
	{
		return electronegativity.get(meta);
	}
}
