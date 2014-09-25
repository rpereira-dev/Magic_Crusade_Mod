package fr.toss.client.event;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.client.Minecraft;
import net.minecraft.client.audio.ISound;
import net.minecraft.client.audio.PositionedSoundRecord;
import net.minecraft.client.audio.SoundCategory;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.Gui;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.scoreboard.ScorePlayerTeam;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.event.sound.PlaySoundEvent17;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.client.config.GuiUtils;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fr.toss.client.gui.GuiClasseInformation;
import fr.toss.common.Main;
import fr.toss.common.player.ClientPlayerBaseMagic;
import fr.toss.common.player.classes.ClasseChampion;
import fr.toss.common.player.classes.ClasseMage;
import fr.toss.common.player.classes.ClasseNecromancer;
import fr.toss.common.player.classes.ClassePriest;
import fr.toss.common.player.classes.ClasseRanger;
import fr.toss.common.player.classes.ClasseRogue;

public class GuiIngameOverlay {
	
	public Minecraft mc;
	public static final ResourceLocation CHARGE_BARRE = new ResourceLocation("magiccrusade:textures/gui/ChargeGUI.png");
	
	public static List<String> INFO;
	public static int DELAY_INFO;
	
	public GuiIngameOverlay(Minecraft m)
	{
		this.mc = m;
		INFO = new ArrayList<String>();
	}
	
	@SubscribeEvent
	@SideOnly(Side.CLIENT)
	public void onGuiIngameRender(RenderGameOverlayEvent.Pre event)
	{
		if (this.mc.inGameHasFocus && !this.mc.gameSettings.showDebugInfo)
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
		      	
			if (INFO.size() > 0)
			{
				if (DELAY_INFO > 0)
				{
		        	font.drawStringWithShadow(INFO.get(0), (event.resolution.getScaledWidth() - font.getStringWidth(INFO.get(0))) / 2, 8, Integer.MAX_VALUE);
		        	DELAY_INFO -= 2;
				}
				else
				{
					INFO.remove(0);
					DELAY_INFO = 5000;
				}
			}
				
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
	        	else if (pm.getClasse() instanceof ClasseRanger || pm.getClasse() instanceof ClasseRogue)
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

	        
	        if (p.getTeam() != null)
	        {
		        this.mc.mcProfiler.startSection("group");
		        
		        ScorePlayerTeam team;
		        EntityPlayer tmp;
		        String str;
		        int i;
		        
		        team = this.mc.thePlayer.getWorldScoreboard().getPlayersTeam(this.mc.thePlayer.getCommandSenderName());
		        i = 0;
		        if (team.getColorPrefix().length() > 2)
		        	font.drawStringWithShadow(team.getColorPrefix(), 30 + x - font.getStringWidth(team.getColorPrefix()) / 2, y + 50, Integer.MAX_VALUE);
		        
				for (Object obj : team.getMembershipCollection())
				{
			        font.drawStringWithShadow(obj.toString(), 30 + x - font.getStringWidth(obj.toString()) / 2, y + 64 + i, Integer.MAX_VALUE);

					tmp = this.mc.theWorld.getPlayerEntityByName(obj.toString());
					if (tmp != null)
					{				        
				        str = "X: " + (int) tmp.posX
				        		+ " Y:" + (int) tmp.posY
				        		+ " Z:" +(int) tmp.posZ;
				        font.drawStringWithShadow(str, 30 + x - font.getStringWidth(str) / 2, y + 74 + i, Integer.MAX_VALUE);
		        		
				        GuiClasseInformation.drawEntity(x - 4 , y + 74 + i, 8, 0, 0, tmp);
				        i += 30;
		        	
					}
				}
		        
		        this.mc.mcProfiler.endSection();
	        }
		}
	        this.mc.getTextureManager().bindTexture(Gui.icons);
	}

}
