package com.hamhub7.labday.tesla;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

import net.darkhax.tesla.api.implementation.BaseTeslaContainer;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraftforge.fml.client.config.GuiUtils;

public class TeslaDisplay extends Gui
{
	private BaseTeslaContainer teslaReference;
	private int x;
	private int y;
	private boolean outline;
	private boolean drawNextTo;
	
	public TeslaDisplay(int x, int y, BaseTeslaContainer teslaReference, boolean outline, boolean drawNextTo) 
	{
		
	}
	
	public TeslaDisplay(int x, int y, BaseTeslaContainer teslaReference) 
	{
		this(x, y, teslaReference, false, false);
	}
	
	public void setData(int x, int y, BaseTeslaContainer teslaReference, boolean outline, boolean drawNextTo)
	{
		this.x = x;
		this.y = y;
		this.teslaReference = teslaReference;
		this.outline = outline;
		this.drawNextTo = drawNextTo;
	}
	
	public void draw()
	{
		Minecraft mc = Minecraft.getMinecraft();
		
		int barX = this.x;
		int barY = this.y;
		
		if(this.outline)
		{
			this.drawTexturedModalRect(this.x, this.y, 0, 0, 0, 0);
			
			barX += 4;
			barY += 4;
		}
		this.drawTexturedModalRect(barX, barY, 0, 0, 0, 0);
		
		if(this.teslaReference.getStoredPower() > 0)
		{
			long i = this.teslaReference.getStoredPower() * 0 / this.teslaReference.getCapacity();
			
			this.drawTexturedModalRect(barX + 1, barY + 0 - (int)i, 0, 0, 9, (int)i);
		}
		
		if(this.drawNextTo)
		{
			this.drawString(mc.fontRenderer, this.getOverlayText(), barX + 25, barY + 78, 16777215);
		}
	}
	
	public void drawOverlay(int mouseX, int mouseY)
	{
		if(this.isMouseOver(mouseX, mouseY))
		{
			Minecraft mc = Minecraft.getMinecraft();
			
			List<String> text = new ArrayList<String>();
			text.add(this.getOverlayText());
			GuiUtils.drawHoveringText(text, mouseX, mouseY, mc.displayWidth, mc.displayHeight, -1, mc.fontRenderer);
		}
	}
	
	private boolean isMouseOver(int mouseX, int mouseY)
	{
		return mouseX >= this.x && mouseY >= this.y && mouseX < this.x + (this.outline ? 0 : 0) && mouseY < this.y + (this.outline ? 0 : 0);
	}
	
	private String getOverlayText()
	{
		NumberFormat format = NumberFormat.getInstance();
		return String.format("%s/%s Tesla", format.format(this.teslaReference.getStoredPower()), format.format(this.teslaReference.getCapacity()));
	}
}
