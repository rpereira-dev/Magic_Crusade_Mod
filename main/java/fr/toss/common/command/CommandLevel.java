package fr.toss.common.command;

import java.util.ArrayList;
import java.util.List;

import fr.toss.common.Main;
import net.minecraft.command.ICommand;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ChatComponentText;
import net.minecraft.world.WorldServer;

public class CommandLevel implements ICommand
{
	private List aliases;
	
	public CommandLevel()
	{
		this.aliases = new ArrayList();
		this.aliases.add("lvl");
		this.aliases.add("level");
	}

	@Override
	public String getCommandName()
	{
		return "lvl";
	}

	@Override
	public String getCommandUsage(ICommandSender icommandsender)
	{
		return "lvl <level>";
	}

	@Override
	public List getCommandAliases()
	{
		return this.aliases;
	}

	@Override
	public void processCommand(ICommandSender icommandsender, String[] args)
	{
		if (icommandsender instanceof EntityPlayer)
		{
			if (args.length == 1)
			{

			}
			else
				((EntityPlayer)icommandsender).addChatComponentMessage(new ChatComponentText(ChatColor.RED + "Error usage: /level X"));
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