package com.hamhub7.labday.item;

import java.util.List;

import javax.annotation.Nullable;

import com.hamhub7.labday.LabDay;
import com.hamhub7.labday.util.ItemNBTHelper;

import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.settings.GameSettings;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ITickable;
import net.minecraft.util.NonNullList;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import scala.Float;

public class ItemElement extends ItemBase
{
	float temp;
	
	public ItemElement() 
	{
		super("element");
		this.setCreativeTab(LabDay.elementTab);
		this.setHasSubtypes(true);
	}
	
	@Override
	public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> items) 
	{
		if(this.isInCreativeTab(tab))
		{
			for(Element type : Element.values())
			{
				items.add(new ItemStack(this, 1, type.ordinal()));
			}
		}
	}
	
	@Override
	public String getUnlocalizedName(ItemStack stack) 
	{
		int meta = stack.getMetadata();
		if(meta < Element.values().length)
		{
			//This has some jank in it bc i changed implementations and everything was the the lowercase symbol. now its an uppercase name as the enum type, so its gotta use the symbol
			return super.getUnlocalizedName(stack) + "." + Element.values()[meta].getSymbol().toLowerCase();
		}
		else
		{
			return super.getUnlocalizedName(stack);
		}
	}
	
	@Override
	public void addInformation(ItemStack stack, @Nullable World world, List<String> tooltip, ITooltipFlag flag) 
	{
		if(Element.values()[stack.getMetadata()].getPhase(getTemp(stack)).equals(Phase.Gas))
		{
			tooltip.add(TextFormatting.RED.toString() + "Temperature: " + getTemp(stack) + " K");
		}
		else if(Element.values()[stack.getMetadata()].getPhase(getTemp(stack)).equals(Phase.Liquid))
		{
			tooltip.add(TextFormatting.AQUA.toString() + "Temperature: " + getTemp(stack) + " K");
		}
		else if(Element.values()[stack.getMetadata()].getPhase(getTemp(stack)).equals(Phase.Solid))
		{
			tooltip.add(TextFormatting.DARK_GREEN.toString() + "Temperature: " + getTemp(stack) + " K");
		}
		
		final KeyBinding keyBindSneak = Minecraft.getMinecraft().gameSettings.keyBindSneak;
		
		if(GameSettings.isKeyDown(keyBindSneak))
		{
			tooltip.add(TextFormatting.GRAY.toString() + "Symbol: " + Element.values()[stack.getMetadata()].getSymbol());
			tooltip.add(TextFormatting.GRAY.toString() + "Atomic Number: " + stack.getMetadata());
			tooltip.add(TextFormatting.GRAY.toString() + "Atomic Weight: " + Element.values()[stack.getMetadata()].getMolarString());
			tooltip.add(TextFormatting.GRAY.toString() + "Melting Point: " + Element.values()[stack.getMetadata()].getMeltingString());
			tooltip.add(TextFormatting.GRAY.toString() + "Boiling Point: " + Element.values()[stack.getMetadata()].getBoilingString());
			tooltip.add(TextFormatting.GRAY.toString() + "Phase: " + Element.values()[stack.getMetadata()].getPhase(getTemp(stack)));
		}
		else
		{
			tooltip.add(TextFormatting.GRAY.toString() + "Hold " + keyBindSneak.getDisplayName() + " for more info");
		}
	}
	
	@Override
	public void registerItemModel() 
	{
		for(int meta = 0; meta < Element.values().length; meta++)
		{
			//This has some jank in it bc i changed implementations and everything was the the lowercase symbol. now its an uppercase name as the enum type, so its gotta use the symbol
			LabDay.proxy.registerVariantRenderer(this, meta, "element_" + Element.values()[meta].getSymbol().toLowerCase(), "inventory");
		}
	}
	
	public static int getTemp(ItemStack stack)
	{
		return ItemNBTHelper.getInt(stack, "temp", 294);
	}
	
	public static void setTemp(ItemStack stack, int kelvin)
	{
		ItemNBTHelper.setInt(stack, "temp", kelvin);
	}
	
	public enum Element
	{
		GENERIC("GENERIC", 0, 0, 0),
		HYDROGEN("H", 13.99, 20.28, 1.008),
		HELIUM("He", 0.95, 4.216, 4.002),
		LITHIUM("Li", 453.7, 1615, 6.941),
		BERYLLIUM("Be", 1560, 3243, 9.012),
		BORON("B", 2365, 4275, 10.81),
		CARBON("C", 3825, 5100, 12.01),
		NITROGEN("N", 63.15, 77.34, 14.01),
		OXYGEN("O", 54.8, 90.19, 16.00),
		FLOURINE("F", 54.8, 90.19, 19.00),
		NEON("Ne", 24.55, 27.1, 20.18),
		SODIUM("Na", 371, 1156, 22.99),
		MAGNESIUM("Mg", 922, 1380, 24.305),
		ALUMINUM("Al", 933.5, 2740, 26.98),
		SILICON("Si", 1683, 2630, 28.09),
		PHOSPHORUS("P", 317.3, 533, 30.97),
		SULFUR("S", 392.2, 717.82, 32.07),
		CHOLRINE("Cl", 172.2, 239.2, 35.45),
		ARGON("Ar", 83.95, 87.45, 39.95),
		POTASSIUM("K", 336.8, 1033, 39.10),
		CALCIUM("Ca", 1112, 1757, 40.08),
		SCANDIUM("Sc", 1814, 3109, 44.96),
		TITANIUM("Ti", 1945, 3560, 47.88),
		VANADIUM("V", 2163, 3650, 50.94),
		CHROMIUM("Cr", 2130, 2945, 52.00),
		MANGANESE("Mn", 1518, 2335, 54.94),
		IRON("Fe", 1808, 3202, 55.85),
		COBALT("Co", 1768, 3143, 58.93),
		NICKEL("Ni", 1726, 3005, 58.69),
		COPPER("Cu", 1357, 2840, 63.55),
		ZINC("Zn", 692.7, 1180, 65.39),
		GALLIUM("Ga", 302.9, 2478, 69.72),
		GERMANIUM("Ge", 1212, 3107, 72.61),
		ARSENIC("As", 1090, 876, 74.92),
		SELENIUM("Se", 494, 958, 78.96),
		BROMINE("Br", 266.0, 331.9, 79.90),
		KRYPTON("Kr", 116, 120.85, 83.8),
		RUBIDIUM("Rb", 312.6, 961, 85.47),
		STRONTIUM("Sr", 1042, 1655, 87.62),
		YTTRIUM("Y", 1795, 3611, 88.91),
		ZIRCONIUM("Zr", 2128, 4682, 91.22),
		NIOBIUM("Nb", 2742, 5105, 92.91),
		MOLYBDENUM("Mo", 2896, 4912, 95.94),
		TECHNETIUM("Tc", 2477, 4538, 98),
		RUTHENIUM("Ru", 2610, 4425, 101.1),
		RHODIUM("Rh", 2236, 3970, 102.9),
		PALLADIUM("Pd", 1825, 3240, 106.4),
		SILVER("Ag", 1235, 2436, 107.9),
		CADMIUM("Cd", 594.3, 1040, 112.4),
		INDIUM("In", 429.8, 2350, 114.8),
		TIN("Sn", 505.1, 2876, 118.7),
		ANTIMONY("Sb", 903.9, 1860, 121.8),
		TELLURIUM("Te", 722.7, 1261, 127.6),
		IODINE("I", 386.7, 457.5, 126.9),
		XENON("Xe", 161.4, 165.1, 131.3),
		CESIUM("Cs", 301.5, 944, 132.9),
		BARIUM("Ba", 1002, 2078, 137.3),
		LANTHANUM("La", 1191, 3737, 138.9),
		CERIUM("Ce", 1071, 3715, 140.1),
		PRASEODYMIUM("Pr", 1204, 3785, 140.9),
		NEODYMIUM("Nd", 1294, 3347, 144.2),
		PROMETHIUM("Pm", 1315, 3273, 145),
		SAMARIUM("Sm", 1347, 2067, 150.36),
		EUROPIUM("Eu", 1095, 1800, 152.0),
		GADOLINIUM("Gd", 1585, 3545, 157.3),
		TERBIUM("Tb", 1629, 3500, 158.9),
		DYSPROSIUM("Dy", 1685, 2840, 162.5),
		HOLMIUM("Ho", 1747, 2968, 164.9),
		ERBIUM("Er", 1802, 3140, 167.3),
		THULIUM("Tm", 1818, 2223, 168.9),
		YTTERBIUM("Yb", 1092, 1469, 173.0),
		LUTETIUM("Lu", 1936, 3668, 175.0),
		HAFNIUM("Hf", 2504, 4875, 178.5),
		TANTALUM("Ta", 3293, 5730, 180.9),
		TUNGSTEN("W", 3695, 5825, 183.9),
		RHENIUM("Re", 3455, 5870, 186.2),
		OSMIUM("Os", 3300, 5300, 190.2),
		IRIDIUM("Ir", 2720, 4700, 192.2),
		PLATINUM("Pt", 2042, 4100, 195.1),
		GOLD("Au", 1338, 3130, 197.0),
		MERCURY("Hg", 234.3, 630.0, 200.6),
		THALLIUM("Tl", 577, 1746, 204.4),
		LEAD("Pb", 600.7, 2023, 207.2),
		BISMUTH("Bi", 544.6, 1837, 209.0),
		POLONIUM("Po", 527, 1235, 209),
		ASTATINE("At", 1560, 3243, 210),
		RADON("Rn", 202, 211.4, 222),
		FRANCIUM("Fr", 300, 950, 223),
		RADIUM("Ra", 202, 211.4, 226.0),
		ACTINIUM("Ac", 1500, 3500, 227),
		THORIUM("Th", 2028, 5060, 232.0),
		PROTACTINIUM("Pa", 1845, 4300, 231.0),
		URANIUM("U", 1408, 4407, 238.0),
		NEPTUNIUM("Np", 912, 4175, 237.0),
		PLUTONIUM("Pu", 913, 3505, 244),
		AMERICIUM("Am", 1449, 2880, 243),
		CURIUM("Cm", 1613, 3383, 247.1),
		BERKELIUM("Bk", 1259, 2900, 247.1),
		CALIFORNIUM("Cf", 1173, 1743, 251.1),
		EINSTEINIUM("Es", 1133, 1269, 252),
		FERMIUM("Fm", 1800, Double.MAX_VALUE, 257.1),
		MENDELEVIUM("Md", 1100, Double.MAX_VALUE, 258.1),
		NOBELLIUM("No", 1100, Double.MAX_VALUE, 259.1),
		LAWRENCIUM("Lr", 1900, Double.MAX_VALUE, 262),
		RUTHERFORDIUM("Rf", Double.MAX_VALUE, Double.MAX_VALUE, 267),
		DUBNIUM("Db", Double.MAX_VALUE, Double.MAX_VALUE, 268),
		SEABORGIUM("Sg", Double.MAX_VALUE, Double.MAX_VALUE, 269),
		BOHRIUM("Bh", Double.MAX_VALUE, Double.MAX_VALUE, 270),
		HASSIUM("Hs", Double.MAX_VALUE, Double.MAX_VALUE, 269),
		MEITNERIUM("Mt", Double.MAX_VALUE, Double.MAX_VALUE, 278),
		DARMSTADTIUM("Ds", Double.MAX_VALUE, Double.MAX_VALUE, 281),
		ROENTGENIUM("Rg", Double.MAX_VALUE, Double.MAX_VALUE, 280),
		COPERNICIUM("Cn", Double.MAX_VALUE, Double.MAX_VALUE, 285),
		NIHONIUM("Nh", Double.MAX_VALUE, Double.MAX_VALUE, 286),
		FLEROVIUM("Fl", Double.MAX_VALUE, Double.MAX_VALUE, 289),
		MOSCOVIUM("Mc", Double.MAX_VALUE, Double.MAX_VALUE, 289),
		LIVERMORIUM("Lv", Double.MAX_VALUE, Double.MAX_VALUE, 293),
		TENNESSINE("Ts", Double.MAX_VALUE, Double.MAX_VALUE, 294),
		OGANESSON("Og", Double.MAX_VALUE, Double.MAX_VALUE, 294);
		
		
		private final String symbol;
		private final double melting;
		private final double boiling;
		private final double molar;
		
		private Element(String symbol, double melting, double boiling, double molar)
		{
			this.symbol = symbol;
			this.melting = melting;
			this.boiling = boiling;
			this.molar = molar;
		}
		
		public String getSymbol()
		{
			return symbol;
		}
		
		public double getMeltingPoint()
		{
			return melting;
		}
		
		public String getMeltingString()
		{
			return melting == Double.MAX_VALUE ? "Unknown" : Double.toString(melting) + " K";
		}
		
		public double getBoilingPoint()
		{
			return boiling;
		}
		
		public String getBoilingString()
		{
			return boiling == Double.MAX_VALUE ? "Unknown" : Double.toString(boiling) + " K";
		}
		
		public double getMolarMass()
		{
			return molar;
		}
		
		public String getMolarString()
		{
			return Double.toString(molar) + " amu";
		}
		
		public Phase getPhase(int temp)
		{
			double boil = getBoilingPoint();
			double melt = getMeltingPoint();
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
	}
	
	public enum Phase
	{
		Solid,
		Liquid,
		Gas
	}
}
