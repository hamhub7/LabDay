package com.hamhub7.labday.util;

import java.util.List;

import javax.annotation.Nullable;

import com.google.common.collect.Lists;
import com.hamhub7.labday.recipes.ProcessorRecipes;

import net.minecraft.util.NonNullList;

public class ElementUtil 
{	
	private static NonNullList<Integer> boilingPoint = NonNullList.<Integer>withSize(PeriodicTable.values().length, 0);
	private static NonNullList<Integer> meltingPoint = NonNullList.<Integer>withSize(PeriodicTable.values().length, 0);
	private static NonNullList<Double> molarMass = NonNullList.<Double>withSize(PeriodicTable.values().length, 0.0);
	private static NonNullList<Double> density = NonNullList.<Double>withSize(PeriodicTable.values().length, 0.0);
	private static NonNullList<Double> specificHeat = NonNullList.<Double>withSize(PeriodicTable.values().length, 0.0);
	private static NonNullList<Double> electronegativity = NonNullList.<Double>withSize(PeriodicTable.values().length, 0.0);
	
	public enum PeriodicTable
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
	
	public static void init()
	{
		setData(0, 0, 0, 0, 0, 0, 0);
		setData(1, 0, 0, 0, 0, 0, 0);
		setData(2, 0, 0, 0, 0, 0, 0);
		setData(3, 0, 0, 0, 0, 0, 0);
		setData(4, 0, 0, 0, 0, 0, 0);
		setData(5, 0, 0, 0, 0, 0, 0);
		setData(6, 0, 0, 0, 0, 0, 0);
		setData(7, 0, 0, 0, 0, 0, 0);
		setData(8, 0, 0, 0, 0, 0, 0);
		setData(9, 0, 0, 0, 0, 0, 0);
		setData(10, 0, 0, 0, 0, 0, 0);
		setData(11, 0, 0, 0, 0, 0, 0);
		setData(12, 0, 0, 0, 0, 0, 0);
		setData(13, 0, 0, 0, 0, 0, 0);
		setData(14, 0, 0, 0, 0, 0, 0);
		setData(15, 0, 0, 0, 0, 0, 0);
		setData(16, 0, 0, 0, 0, 0, 0);
		setData(17, 0, 0, 0, 0, 0, 0);
		setData(18, 0, 0, 0, 0, 0, 0);
		setData(19, 0, 0, 0, 0, 0, 0);
		setData(20, 0, 0, 0, 0, 0, 0);
		setData(21, 0, 0, 0, 0, 0, 0);
		setData(22, 0, 0, 0, 0, 0, 0);
		setData(23, 0, 0, 0, 0, 0, 0);
		setData(24, 0, 0, 0, 0, 0, 0);
		setData(25, 0, 0, 0, 0, 0, 0);
		setData(26, 0, 0, 0, 0, 0, 0);
		setData(27, 0, 0, 0, 0, 0, 0);
		setData(28, 0, 0, 0, 0, 0, 0);
		setData(29, 0, 0, 0, 0, 0, 0);
		setData(30, 0, 0, 0, 0, 0, 0);
		setData(31, 0, 0, 0, 0, 0, 0);
		setData(32, 0, 0, 0, 0, 0, 0);
		setData(33, 0, 0, 0, 0, 0, 0);
		setData(34, 0, 0, 0, 0, 0, 0);
		setData(35, 0, 0, 0, 0, 0, 0);
		setData(36, 0, 0, 0, 0, 0, 0);
		setData(37, 0, 0, 0, 0, 0, 0);
		setData(38, 0, 0, 0, 0, 0, 0);
		setData(39, 0, 0, 0, 0, 0, 0);
		setData(40, 0, 0, 0, 0, 0, 0);
		setData(41, 0, 0, 0, 0, 0, 0);
		setData(42, 0, 0, 0, 0, 0, 0);
		setData(43, 0, 0, 0, 0, 0, 0);
		setData(44, 0, 0, 0, 0, 0, 0);
		setData(45, 0, 0, 0, 0, 0, 0);
		setData(46, 0, 0, 0, 0, 0, 0);
		setData(47, 0, 0, 0, 0, 0, 0);
		setData(48, 0, 0, 0, 0, 0, 0);
		setData(49, 0, 0, 0, 0, 0, 0);
		setData(50, 0, 0, 0, 0, 0, 0);
		setData(51, 0, 0, 0, 0, 0, 0);
		setData(52, 0, 0, 0, 0, 0, 0);
		setData(53, 0, 0, 0, 0, 0, 0);
		setData(54, 0, 0, 0, 0, 0, 0);
		setData(55, 0, 0, 0, 0, 0, 0);
		setData(56, 0, 0, 0, 0, 0, 0);
		setData(57, 0, 0, 0, 0, 0, 0);
		setData(58, 0, 0, 0, 0, 0, 0);
		setData(59, 0, 0, 0, 0, 0, 0);
		setData(60, 0, 0, 0, 0, 0, 0);
		setData(61, 0, 0, 0, 0, 0, 0);
		setData(62, 0, 0, 0, 0, 0, 0);
		setData(63, 0, 0, 0, 0, 0, 0);
		setData(64, 0, 0, 0, 0, 0, 0);
		setData(65, 0, 0, 0, 0, 0, 0);
		setData(66, 0, 0, 0, 0, 0, 0);
		setData(67, 0, 0, 0, 0, 0, 0);
		setData(68, 0, 0, 0, 0, 0, 0);
		setData(69, 0, 0, 0, 0, 0, 0);
		setData(70, 0, 0, 0, 0, 0, 0);
		setData(71, 0, 0, 0, 0, 0, 0);
		setData(72, 0, 0, 0, 0, 0, 0);
		setData(73, 0, 0, 0, 0, 0, 0);
		setData(74, 0, 0, 0, 0, 0, 0);
		setData(75, 0, 0, 0, 0, 0, 0);
		setData(76, 0, 0, 0, 0, 0, 0);
		setData(77, 0, 0, 0, 0, 0, 0);
		setData(78, 0, 0, 0, 0, 0, 0);
		setData(79, 0, 0, 0, 0, 0, 0);
		setData(80, 0, 0, 0, 0, 0, 0);
		setData(81, 0, 0, 0, 0, 0, 0);
		setData(82, 0, 0, 0, 0, 0, 0);
		setData(83, 0, 0, 0, 0, 0, 0);
		setData(84, 0, 0, 0, 0, 0, 0);
		setData(85, 0, 0, 0, 0, 0, 0);
		setData(86, 0, 0, 0, 0, 0, 0);
		setData(87, 0, 0, 0, 0, 0, 0);
		setData(88, 0, 0, 0, 0, 0, 0);
		setData(89, 0, 0, 0, 0, 0, 0);
		setData(90, 0, 0, 0, 0, 0, 0);
		setData(91, 0, 0, 0, 0, 0, 0);
		setData(92, 0, 0, 0, 0, 0, 0);
		setData(93, 0, 0, 0, 0, 0, 0);
		setData(94, 0, 0, 0, 0, 0, 0);
		setData(95, 0, 0, 0, 0, 0, 0);
		setData(96, 0, 0, 0, 0, 0, 0);
		setData(97, 0, 0, 0, 0, 0, 0);
		setData(98, 0, 0, 0, 0, 0, 0);
		setData(99, 0, 0, 0, 0, 0, 0);
		setData(100, 0, 0, 0, 0, 0, 0);
		setData(101, 0, 0, 0, 0, 0, 0);
		setData(102, 0, 0, 0, 0, 0, 0);
		setData(103, 0, 0, 0, 0, 0, 0);
		setData(104, 0, 0, 0, 0, 0, 0);
		setData(105, 0, 0, 0, 0, 0, 0);
		setData(106, 0, 0, 0, 0, 0, 0);
		setData(107, 0, 0, 0, 0, 0, 0);
		setData(108, 0, 0, 0, 0, 0, 0);
		setData(109, 0, 0, 0, 0, 0, 0);
		setData(110, 0, 0, 0, 0, 0, 0);
		setData(111, 0, 0, 0, 0, 0, 0);
		setData(112, 0, 0, 0, 0, 0, 0);
		setData(113, 0, 0, 0, 0, 0, 0);
		setData(114, 0, 0, 0, 0, 0, 0);
		setData(115, 0, 0, 0, 0, 0, 0);
		setData(116, 0, 0, 0, 0, 0, 0);
		setData(117, 0, 0, 0, 0, 0, 0);
		setData(118, 0, 0, 0, 0, 0, 0);
	}
	
	private static void setData(int meta, int meltingPoint, int boilingPoint, double molarMass, double density, double specificHeat, double electronegativity) 
	{
		ElementUtil.meltingPoint.set(meta, meltingPoint);
		ElementUtil.meltingPoint.set(meta, boilingPoint);
		ElementUtil.molarMass.set(meta, molarMass);
		ElementUtil.density.set(meta, density);
		ElementUtil.specificHeat.set(meta, specificHeat);
		ElementUtil.electronegativity.set(meta, electronegativity);
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
	
	public enum Phase
	{
		Solid,
		Liquid,
		Gas
	}
	
	public static double getWeight(int meta)
	{
		return molarMass.get(meta);
	}
	
	public static double getDensity(int meta)
	{
		return density.get(meta);
	}
	
	public static double getSpecHeat(int meta)
	{
		return specificHeat.get(meta);
	}
	
	public static double getElecNeg(int meta)
	{
		return electronegativity.get(meta);
	}
}
