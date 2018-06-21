package com.hamhub7.labday.block.temperature.icebox;

import com.hamhub7.labday.LabDay;
import com.hamhub7.labday.block.ModBlocks;
import com.hamhub7.labday.block.temperature.bunsen.ContainerBunsenBurner;
import com.hamhub7.labday.block.temperature.bunsen.TileEntityBunsenBurner;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

public class GuiIcebox extends GuiContainer
{
	private InventoryPlayer playerInv;
	public static final ResourceLocation BG_TEXTURE = new ResourceLocation(LabDay.modid, "textures/gui/icebox.png");
	private final TileEntityIcebox tileentity;
	
	public GuiIcebox(InventoryPlayer playerInv, TileEntity tileentity) 
	{
		super(new ContainerIcebox(playerInv, tileentity));
		this.playerInv = playerInv;
		this.tileentity = (TileEntityIcebox)tileentity;
	}
	
	@Override
	protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) 
	{
		GlStateManager.color(1, 1, 1, 1);
		mc.getTextureManager().bindTexture(BG_TEXTURE);
		int x = (width - xSize) / 2;
		int y = (height - ySize) / 2;
		drawTexturedModalRect(x, y, 0, 0, xSize, ySize);
	}
	
	@Override
	protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) 
	{
		this.renderHoveredToolTip(mouseX, mouseY);
		String name = I18n.format(ModBlocks.icebox.getUnlocalizedName() + ".name");
		fontRenderer.drawString(name, 6, 6, 0x000000);
		fontRenderer.drawString(playerInv.getDisplayName().getUnformattedText(), 8, ySize - 92, 0x404040);
	}
}
