package com.hamhub7.labday.sounds;

import javax.annotation.Nonnull;

import com.hamhub7.labday.LabDay;

import net.minecraft.client.audio.ITickableSound;
import net.minecraft.client.audio.PositionedSound;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundCategory;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ProcessorSound extends PositionedSound implements ITickableSound
{
	private boolean donePlaying;
	
	public ProcessorSound(float x, float y, float z) 
	{
		super(new ResourceLocation(LabDay.modid, "block.processor.process"), SoundCategory.BLOCKS);
		this.xPosF = x;
		this.yPosF = y;
		this.zPosF = z;
		this.volume = 5.0F;
		this.pitch = 1.0F;
		this.repeat = true;
	}
	
	@Override
	public void update() 
	{
		
	}
	
	@Override
	public boolean isDonePlaying() 
	{
		return donePlaying;
	}
	
	public void endPlaying() 
	{
		donePlaying = true;
	}
	
	public void startPlaying() 
	{
		donePlaying = false;
	}
}
