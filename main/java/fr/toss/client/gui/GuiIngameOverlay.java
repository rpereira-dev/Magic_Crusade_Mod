package fr.toss.client.gui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.inventory.GuiInventory;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.GuiOpenEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.client.config.GuiUtils;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fr.toss.common.Main;
import fr.toss.common.player.ClientPlayerBaseMagic;
import fr.toss.common.player.classes.ClasseChampion;
import fr.toss.common.player.classes.ClasseMage;
import fr.toss.common.player.classes.ClasseNecromancer;
import fr.toss.common.player.classes.ClassePriest;
import fr.toss.common.player.classes.ClasseRanger;

public class GuiIngameOverlay {
	
	public Minecraft mc;
	public static final ResourceLocation CHARGE_BARRE = new ResourceLocation("magiccrusade:textures/gui/ChargeGUI.png");
	
	public GuiIngameOverlay(Minecraft m)
	{
		this.mc = m;
	}
	
	
	@SubscribeEvent
	@SideOnly(Side.CLIENT)
	public void onGuiOpen(GuiOpenEvent event)
	{
		if (event.gui instanceof GuiInventory)
		{

		}
	}
	
	@SubscribeEvent
	@SideOnly(Side.CLIENT)
	public void onGuiIngameRender(RenderGameOverlayEvent.Post event)
	{
		if (this.mc.inGameHasFocus)
		{
			ClientPlayerBaseMagic pm;
			EntityPlayer p;
			FontRenderer font;
			String health;
			String energy;
			int x;
			int y;
			
			pm = Main.getPlayerClient();
			p = pm.getPlayer();
			font = this.mc.fontRenderer;
			x = 20;
			y = 4;
			
			if (Main.isModLoadded("DamageIndicatorsMod"))
				y += 100;
			
			GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
			GL11.glDisable(GL11.GL_LIGHTING);      
		      						
	        this.mc.mcProfiler.startSection("healthBar");
	        
	        	if (pm.getClasse() != null)
		    		health = pm.getClasse().getName() + " Lvl. " + pm.level;
	        	else
		    		health = " Lvl. " + pm.level;

		        font.drawStringWithShadow(health, 35 + x - font.getStringWidth(health) / 2, y, Integer.MAX_VALUE);

		        y += 10;
		    	this.mc.getTextureManager().bindTexture(CHARGE_BARRE);
	        	GuiUtils.drawTexturedModalRect(x, y, 0, 0, 65, 13, 0);
	        	GuiUtils.drawTexturedModalRect(x, y, 65, 0, (int) (65 / p.getMaxHealth() * p.getHealth()), 13, 0);	        
		        
	        	GuiUtils.drawTexturedModalRect(4, y + 30, 130, 0, 81, 5, 0);
	        	GuiUtils.drawTexturedModalRect(4, y + 30, 130, 5, (int) (81.0f / pm.exp_to_next_level * pm.experience), 5, 0);
	    	    GuiClasseInformation.drawEntity(10, y + 24, 12, 0, 0, this.mc.thePlayer);

				health = p.getHealth() + "/" + p.getMaxHealth();
		        font.drawStringWithShadow(health, 35 + x - font.getStringWidth(health) / 2, y + 2, Integer.MAX_VALUE);

	        this.mc.mcProfiler.endSection();
	        
	        this.mc.mcProfiler.startSection("energyBar");
	        
	    		this.mc.getTextureManager().bindTexture(CHARGE_BARRE);

	    		health = (int) pm.energy + "/" + (int) pm.max_energy;
	
	        	if (pm.getClasse() instanceof ClasseNecromancer || pm.getClasse() instanceof ClasseMage || pm.getClasse() instanceof ClassePriest)
	        	{
	            	GuiUtils.drawTexturedModalRect(x, y + 15, 0, 0, 65, 13, 0);
	    	    	GuiUtils.drawTexturedModalRect(x, y + 15, 0, 98, (int) (65.0f / pm.max_energy * pm.energy), 13, 0);
	    	        font.drawStringWithShadow(health, 35 + x - font.getStringWidth(health) / 2, y + 17, Integer.MAX_VALUE);
	        	}
	        	else if (pm.getClasse() instanceof ClasseRanger)
	        	{
	            	GuiUtils.drawTexturedModalRect(x, y + 15, 0, 28, 65, 13, 0);
	    	    	GuiUtils.drawTexturedModalRect(x, y + 15, 130, 84, (int) (65.0f / pm.max_energy * pm.energy), 13, 0);
	    	        font.drawStringWithShadow(health, 35 + x - font.getStringWidth(health) / 2, y + 17, Integer.MAX_VALUE);
	        	}
	        	else if (pm.getClasse() instanceof ClasseChampion)
	        	{
	            	GuiUtils.drawTexturedModalRect(x, y + 15, 0, 14, 65, 13, 0);
	    	    	GuiUtils.drawTexturedModalRect(x, y + 15, 65, 70, (int) (65.0f / pm.max_energy * pm.energy), 13, 0);
	    	        font.drawStringWithShadow(health, 35 + x - font.getStringWidth(health) / 2, y + 17, Integer.MAX_VALUE);
	        	}
	        	
	        this.mc.mcProfiler.endSection();
	        
	        this.mc.getTextureManager().bindTexture(Gui.icons);
		}
	}

}
