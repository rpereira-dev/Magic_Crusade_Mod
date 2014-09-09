package fr.toss.client;

import java.util.Random;

import net.minecraft.client.Minecraft;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ChatComponentText;
import net.minecraft.world.World;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.InputEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fr.toss.client.gui.GuiSelectClass;
import fr.toss.client.gui.GuiStats;
import fr.toss.common.Main;
import fr.toss.common.command.ChatColor;
import fr.toss.common.player.ClientPlayerBaseMagic;
import fr.toss.common.player.spells.Spell;
import fr.toss.common.world.labyrinthe.WorldGenLabyrinthe;

public class KeyInputHandler {

    @SubscribeEvent
    @SideOnly(Side.CLIENT)
    public void onKeyInput(InputEvent.KeyInputEvent event)
    {
    	ClientPlayerBaseMagic player = Main.getPlayerClient();
    	
        if(KeyBindings.KEY_GENERATE.isPressed())
        {
        	World w = MinecraftServer.getServer().worldServerForDimension(player.getPlayer().dimension);
        	Random rand = Minecraft.getMinecraft().theWorld.rand;
        	
	        int x = (int) Minecraft.getMinecraft().thePlayer.posX;
	        int y = (int) Minecraft.getMinecraft().thePlayer.posY;
	        int z = (int) Minecraft.getMinecraft().thePlayer.posZ;
	        WorldGenLabyrinthe dj = new WorldGenLabyrinthe ();
	        dj.generate(w, rand, x, y, z);
        }
        else if(KeyBindings.KEY_SELECT_CLASSE.isPressed())
        	Minecraft.getMinecraft().displayGuiScreen(new GuiSelectClass());
        else if(KeyBindings.KEY_STATS.isPressed())
        	Minecraft.getMinecraft().displayGuiScreen(new GuiStats());
        else
        {
        	if (player != null && player.getClasse() != null)
        	{
	        	for (int i = 0; i < player.getClasse().CLASSE_SPELL.size(); i++)
	        	{
	        		Spell spell;
	        		
	        		spell = player.getClasse().CLASSE_SPELL.get(i);
	        		if (KeyBindings.KEY_SPELLS[i].isPressed())
	        		{
	        			if (player.getLevel() >= spell.getLevel())
	        				player.getClasse().CLASSE_SPELL.get(i).use();
	        			else
	        				player.getPlayer().addChatComponentMessage(new ChatComponentText(ChatColor.RED + "Level " + spell.getLevel() + " is required to use " + spell.getName() + ChatColor.RESET));
	        			break ;
	        		}
	        	}
        	}
        }
    }

}