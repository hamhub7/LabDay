package com.hamhub7.labday;

import org.apache.logging.log4j.Logger;

import com.hamhub7.labday.block.ModBlocks;
import com.hamhub7.labday.gen.ModWorldGen;
import com.hamhub7.labday.item.ModItems;
import com.hamhub7.labday.proxy.CommonProxy;
import com.hamhub7.labday.recipes.ModRecipes;
import com.hamhub7.labday.recipes.ProcessorRecipes;
import com.hamhub7.labday.tabs.CreativeTab;
import com.hamhub7.labday.tabs.ElementTab;
import com.hamhub7.labday.util.CompoundUtil;
import com.hamhub7.labday.util.ElementUtil;
import com.hamhub7.labday.util.GuiHandler;
import com.hamhub7.labday.util.SoundsHandler;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;

@Mod(modid = LabDay.modid, name = LabDay.name, version = LabDay.version)
public class LabDay
{
    public static final String modid = "labday";
    public static final String name = "Lab Day";
    public static final String version = "1.0";

    @Mod.Instance(modid)
    public static LabDay instance;
    private static Logger logger;
    
    @SidedProxy(serverSide = "com.hamhub7.labday.proxy.CommonProxy", clientSide = "com.hamhub7.labday.proxy.ClientProxy")
    public static CommonProxy proxy;
    public static final CreativeTab creativeTab = new CreativeTab();
    public static final ElementTab elementTab = new ElementTab();

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
    	System.out.println(name + " is loading my dudes!");
        logger = event.getModLog();
    	proxy.registerRenderers();
    	ElementUtil.init();
    	CompoundUtil.init();
    	GameRegistry.registerWorldGenerator(new ModWorldGen(), 3);
    	NetworkRegistry.INSTANCE.registerGuiHandler(this, new GuiHandler());
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event)
    {
    	ModRecipes.init();
    	ProcessorRecipes.getInstance().init();
    	SoundsHandler.registerSounds();
    }
    
    @Mod.EventHandler
    public void postInit(FMLInitializationEvent event)
    {
    	
    }
    
    @Mod.EventHandler
    public void serverLoad(FMLServerStartingEvent event)
    {
    	
    }
    
    @Mod.EventBusSubscriber
    public static class RegistrationHandler
    {
    	@SubscribeEvent
    	public static void registerBlocks(RegistryEvent.Register<Block> event)
    	{
    		ModBlocks.register(event.getRegistry());
    	}
    	
    	@SubscribeEvent
    	public static void registerItems(RegistryEvent.Register<Item> event)
    	{
    		ModItems.register(event.getRegistry());
    		ModBlocks.registerItemBlocks(event.getRegistry());
    	}
    	
    	@SubscribeEvent
    	public static void registerModels(ModelRegistryEvent event)
    	{
    		ModItems.registerModels();
    		ModBlocks.registerModels();
    	}
    }
}
