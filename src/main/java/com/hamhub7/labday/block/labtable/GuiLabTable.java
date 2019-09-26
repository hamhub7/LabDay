package com.hamhub7.labday.block.labtable;

import com.hamhub7.labday.LabDay;
import com.hamhub7.labday.block.ModBlocks;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

public class GuiLabTable extends GuiContainer
{
	private InventoryPlayer playerInv;
	public static final ResourceLocation BG_TEXTURE = new ResourceLocation(LabDay.modid, "textures/gui/lab_table.png");
	private final TileEntityLabTable tileentity;
	
	public GuiLabTable(InventoryPlayer playerInv, TileEntity tileentity) 
	{
		super(new ContainerLabTable(playerInv, tileentity));
		this.playerInv = playerInv;
		this.tileentity = (TileEntityLabTable)tileentity;
	}
	
	@Override
	protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) 
	{
		GlStateManager.color(1, 1, 1, 1);
		mc.getTextureManager().bindTexture(BG_TEXTURE);
		int x = (width - xSize) / 2;
		//Texture is 193 pixels tall, and we want the margin to only change on the top
		int y = ((height - ySize) / 2) - (193 - ySize);
		drawTexturedModalRect(x, y, 0, 0, xSize, 193);
	}
	
	@Override
	protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) 
	{
		String name = I18n.format(ModBlocks.labTable.getUnlocalizedName() + ".name");
		fontRenderer.drawString(name, 8, 0, 0x000000);
		fontRenderer.drawString(playerInv.getDisplayName().getUnformattedText(), 8, ySize - 92, 0x404040);
	}
	
	@Override
	public void drawScreen(int mouseX, int mouseY, float partialTicks) 
	{
		super.drawScreen(mouseX, mouseY, partialTicks);
		renderHoveredToolTip(mouseX, mouseY);
	}
	
}
