package fr.toss.common.game;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ChatComponentText;
import net.minecraft.world.World;
import fr.toss.common.command.ChatColor;

public class ServerMagic {
	
	public MinecraftServer	mc_server;
	public long				timestamp_launch;
	public long				no_pvp_duration; //en milliseconds
	public boolean			game_started;
	
	public int 				min_x;
	public int 				min_z;
	public int 				max_x;
	public int 				max_z;
	public boolean			portal_is_generated;
	
	public void start_new_game(int minute_no_pvp)
	{
		this.mc_server = MinecraftServer.getServer();
		this.mc_server.setAllowPvp(false);
		this.timestamp_launch = System.currentTimeMillis();
		this.no_pvp_duration = minute_no_pvp * 1000;
		this.mc_server.getCommandManager().executeCommand(this.mc_server, "time set 0");
		this.mc_server.getCommandManager().executeCommand(this.mc_server, "weather clear");
		this.min_x = Integer.MIN_VALUE;
		this.min_z = Integer.MIN_VALUE;
		this.max_x = Integer.MAX_VALUE;
		this.max_z = Integer.MAX_VALUE;
	}
	
	public void onWorldUpdate(World world)
	{
		if (portal_is_generated)
		{
			for (Object obj : world.playerEntities)
			{
				if ( ((EntityPlayer)obj).posX < this.min_x || ((EntityPlayer)obj).posZ < this.min_z
					|| (((EntityPlayer)obj).posX > this.max_x || ((EntityPlayer)obj).posZ > this.max_z))
				{
					if (System.currentTimeMillis() % 2000 < 20)
					{
						((EntityPlayer)obj).setFire(4);
						((EntityPlayer)obj).addPotionEffect(new PotionEffect(Potion.blindness.id, 100, 1));
						((EntityPlayer)obj).addPotionEffect(new PotionEffect(Potion.weakness.id, 100, 10));
						((EntityPlayer)obj).addPotionEffect(new PotionEffect(Potion.poison.id, 100, 10));
						((EntityPlayer)obj).addPotionEffect(new PotionEffect(Potion.wither.id, 100, 10));
					}
					else if (System.currentTimeMillis() % 2000 > 20 && System.currentTimeMillis() % 2000 < 50)
						((EntityPlayer)obj).addChatComponentMessage(new ChatComponentText(ChatColor.RED + "TU SORS DE LA MAP. ATTENTION"));
				}
			}
		}
	}

	public void onServerUpdate()
	{
		if (this.game_started)
			this.handle_pvp();
		
		for (World world : this.mc_server.worldServers)
			this.onWorldUpdate(world);
	}

	void handle_pvp()
	{
		if (this.no_pvp_duration == 0)
		{
			this.mc_server.getCommandManager().executeCommand(this.mc_server, "uhc togglepvp true");
			this.no_pvp_duration = -1;
		}
		else if (this.no_pvp_duration != -1)
			this.no_pvp_duration -= 20;
	}

	public void onPlayerDie(EntityPlayerMP player)
	{
		String message;
		
		message = "C'est fini pour toi :) Bien tenté";
		this.mc_server.getCommandManager().executeCommand(this.mc_server, "ban " + player.getCommandSenderName() + " " + message); 
	}
}
