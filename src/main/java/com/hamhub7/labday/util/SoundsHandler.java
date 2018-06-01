package com.hamhub7.labday.util;

import com.hamhub7.labday.LabDay;
import com.hamhub7.labday.sounds.ProcessorSound;

import net.minecraft.client.audio.PositionedSound;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

public class SoundsHandler 
{
	public static SoundEvent BLOCK_PROCESSOR_PROCESS;
	
	public static void registerSounds()
	{
		BLOCK_PROCESSOR_PROCESS = registerSoundEvent("block.processor.process");
	}
	
	private static SoundEvent registerSoundEvent(String name)
	{
		ResourceLocation location = new ResourceLocation(LabDay.modid, name);
		SoundEvent event = new SoundEvent(location);
		event.setRegistryName(name);
		ForgeRegistries.SOUND_EVENTS.register(event);
		return event;
	}
}
