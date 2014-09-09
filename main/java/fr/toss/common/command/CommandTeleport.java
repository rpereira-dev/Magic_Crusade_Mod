package fr.toss.common.command;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.command.ICommand;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ChatComponentText;
import net.minecraft.world.WorldServer;

public class CommandTeleport implements ICommand
{
	private List aliases;
	
	public CommandTeleport()
	{
		this.aliases = new ArrayList();
		this.aliases.add("tpm");
		this.aliases.add("teleport_magic");
	}

	@Override
	public String getCommandName()
	{
		return "teleport";
	}

	@Override
	public String getCommandUsage(ICommandSender icommandsender)
	{
		return "tpm <world> <player> <x> <y> <z>";
	}

	@Override
	public List getCommandAliases()
	{
		return this.aliases;
	}

	@Override
	public void processCommand(ICommandSender icommandsender, String[] args)
	{
		String msg;
		MinecraftServer server;
		WorldServer w;
		int stop;
		int x;
		int y;
		int z;
		int i;
		
		if(args.length != 5)
		{
			server = MinecraftServer.getServer();
			if (icommandsender instanceof EntityPlayer)
			{
				msg = ChatColor.RED + "Usage: " + this.getCommandUsage(icommandsender);
				((EntityPlayer) icommandsender).addChatMessage(new ChatComponentText(msg));
				msg = "";
				i = 0;
				while (i < server.worldServers.length - 1)
				{
					msg += (" " + server.worldServers[i].getWorldInfo().getWorldName() + " -");
					i++;
				}
				msg += (" " + server.worldServers[i].getWorldInfo().getWorldName());
				((EntityPlayer) icommandsender).addChatMessage(new ChatComponentText(msg));
				return;
			}
			else
			{
				msg = "Arguments error";
				server.addChatMessage(new ChatComponentText(msg));
				return;
			}
		}
		else
		{
			server = MinecraftServer.getServer();
			stop = 0;
			w = null;
			for (WorldServer world : server.worldServers)
			{
				if (world.getWorldInfo().getWorldName().equals(args[0]))
				for (EntityPlayer player : (List<EntityPlayer>) world.playerEntities)
				{
					if (player.getCommandSenderName().equals(args[1]))
					{
						try 
						{
							x = Integer.valueOf(args[2]);
							y = Integer.valueOf(args[3]);
							z = Integer.valueOf(args[4]);
							player.travelToDimension(w.provider.dimensionId);
							player.setPosition(x, y, z);
						} catch (Exception error) {}
						stop = 1;
						break ;
					}
				}
				if (stop == 1)
					break ;
			}
			if (stop == 0)
			{
				msg = ChatColor.RED + "Invalid world or player.";
				((EntityPlayer) icommandsender).addChatMessage(new ChatComponentText(msg));
			}	
		}
	}

	@Override
	public boolean canCommandSenderUseCommand(ICommandSender icommandsender)
	{
		return true;
	}

	@Override
	public List addTabCompletionOptions(ICommandSender icommandsender,
			String[] astring)
	{
		return null;
	}

	@Override
	public boolean isUsernameIndex(String[] astring, int i)
	{
		return false;
	}

	@Override
	public int compareTo(Object o)
	{
		return 0;
	}
}