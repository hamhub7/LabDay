package com.hamhub7.labday;

import org.apache.logging.log4j.Logger;

import com.hamhub7.labday.block.ModBlocks;
import com.hamhub7.labday.block.labtable.packet.PacketRequestUpdateLabTable;
import com.hamhub7.labday.block.labtable.packet.PacketUpdateLabTable;
import com.hamhub7.labday.gen.ModWorldGen;
import com.hamhub7.labday.item.ModItems;
import com.hamhub7.labday.proxy.CommonProxy;
import com.hamhub7.labday.recipes.ModRecipes;
import com.hamhub7.labday.tabs.CreativeTab;
import com.hamhub7.labday.tabs.ElementTab;
import com.hamhub7.labday.util.GuiHandler;
import com.hamhub7.labday.util.SoundsHandler;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;

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
    
    public static SimpleNetworkWrapper network;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        logger = event.getModLog();
    	proxy.registerRenderers();
    	GameRegistry.registerWorldGenerator(new ModWorldGen(), 3);
    	NetworkRegistry.INSTANCE.registerGuiHandler(this, new GuiHandler());
    	
    	network = NetworkRegistry.INSTANCE.newSimpleChannel(modid);
    	network.registerMessage(new PacketUpdateLabTable.Handler(), PacketUpdateLabTable.class, 0, Side.CLIENT);
    	network.registerMessage(new PacketRequestUpdateLabTable.Handler(), PacketRequestUpdateLabTable.class, 1, Side.SERVER);
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event)
    {
    	ModRecipes.init();
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
