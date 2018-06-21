package com.hamhub7.labday.block.processor;

import com.hamhub7.labday.LabDay;
import com.hamhub7.labday.block.ModBlocks;

import net.darkhax.tesla.api.ITeslaHolder;
import net.darkhax.tesla.capability.TeslaCapabilities;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;

public class GuiProcessor extends GuiContainer
{
	private InventoryPlayer playerInv;
	public static final ResourceLocation BG_TEXTURE = new ResourceLocation(LabDay.modid, "textures/gui/processor.png");
	private final TileEntityProcessor tileentity;
	
	public GuiProcessor(InventoryPlayer playerInv, TileEntity tileentity) 
	{
		super(new ContainerProcessor(playerInv, tileentity));
		this.playerInv = playerInv;
		this.tileentity = (TileEntityProcessor)tileentity;
	}
	
	@Override
	protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) 
	{
		GlStateManager.color(1, 1, 1, 1);
		mc.getTextureManager().bindTexture(BG_TEXTURE);
		int x = (width - xSize) / 2;
		int y = (height - ySize) / 2;
		drawTexturedModalRect(x, y, 0, 0, xSize, ySize);
		
		int l = this.tileentity.getCookProgressScaled(50);
		int e = this.tileentity.getEnergyScaled(54);
		
		this.drawTexturedModalRect(this.guiLeft + 10, this.guiTop + 7 + (54 - e), 240, 7, 8, e);
		
		if(this.tileentity.recipeAmount() == 1)
		{
			this.drawTexturedModalRect(this.guiLeft + 63, this.guiTop + 29, 180, 125, l, 44);
		}
		else if(this.tileentity.recipeAmount() == 2)
		{
			this.drawTexturedModalRect(this.guiLeft + 63, this.guiTop + 12, 180, 61, l, 44);
		}
		else if(this.tileentity.recipeAmount() == 3)
		{
			this.drawTexturedModalRect(this.guiLeft + 63, this.guiTop + 12, 180, 12, l, 44);
		}
	}
	
	@Override
	protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) 
	{
		String name = I18n.format(ModBlocks.processor.getUnlocalizedName() + ".name");
		fontRenderer.drawString(name, 24, 6, 0x000000);
		fontRenderer.drawString(playerInv.getDisplayName().getUnformattedText(), 8, ySize - 92, 0x404040);
		renderHoveredToolTip(mouseX, mouseY);
	}
}
