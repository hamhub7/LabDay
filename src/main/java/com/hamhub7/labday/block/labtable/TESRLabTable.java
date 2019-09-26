package com.hamhub7.labday.block.labtable;

import java.util.Random;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.block.model.IBakedModel;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.client.ForgeHooksClient;

public class TESRLabTable extends TileEntitySpecialRenderer<TileEntityLabTable>
{
	@Override
	public void render(TileEntityLabTable te, double x, double y, double z, float partialTicks, int destroyStage, float alpha) 
	{	
		Random rand = new Random(MathHelper.getPositionRandom(te.getPos()));
		
		for(int i = 0; i < te.inventory.getSlots(); i++)
		{
			ItemStack stack = te.inventory.getStackInSlot(i);
			if(!stack.isEmpty())
			{
				GlStateManager.enableRescaleNormal();
				GlStateManager.alphaFunc(GL11.GL_GREATER, 0.1f);
				GlStateManager.enableBlend();
				RenderHelper.enableStandardItemLighting();
				GlStateManager.tryBlendFuncSeparate(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA, 1, 0);
				GlStateManager.pushMatrix();
				GlStateManager.translate(x + (0.7*rand.nextDouble() + 0.15), y + 1.01, z + (0.7*rand.nextDouble() + 0.15));
				GlStateManager.rotate(-90, 1, 0, 0);
				GlStateManager.rotate(rand.nextInt(360), 0, 0, 1);
				GlStateManager.scale(0.5, 0.5, 0.5);
				
				IBakedModel model = Minecraft.getMinecraft().getRenderItem().getItemModelWithOverrides(stack, te.getWorld(), null);
				model = ForgeHooksClient.handleCameraTransforms(model, ItemCameraTransforms.TransformType.GROUND, false);
				
				Minecraft.getMinecraft().getTextureManager().bindTexture(TextureMap.LOCATION_BLOCKS_TEXTURE);
				Minecraft.getMinecraft().getRenderItem().renderItem(stack, model);
				
				GlStateManager.popMatrix();
				GlStateManager.disableRescaleNormal();
				GlStateManager.disableBlend();
			}
		}
	}
}
