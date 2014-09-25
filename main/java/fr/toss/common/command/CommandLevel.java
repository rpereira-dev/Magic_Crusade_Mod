package fr.toss.common.command;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommand;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ChatComponentText;
import fr.toss.common.Main;
import fr.toss.common.packet.PacketLevel;
import fr.toss.common.packet.Packets;

public class CommandLevel extends CommandBase implements ICommand
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
		return "level";
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
		try
		{
			PacketLevel		packet;
			EntityPlayerMP	player;
			
			packet = new PacketLevel(Integer.valueOf(args[1]));
			player = (EntityPlayerMP) icommandsender.getEntityWorld().getPlayerEntityByName(args[0]);
			if (player != null)
			{
				Main.getPlayerServer(player).level = packet.level;
				player.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(0.5d * (packet.level - 1) + 20.0d + Main.getPlayerServer(player).endurance / 10);

				Packets.network.sendTo(packet, player);
			}
			else
				icommandsender.addChatMessage(new ChatComponentText(ChatColor.RED + "Error usage: /level [USERNAME] [LEVEL]"));
				
		} catch (Exception e) {
			((EntityPlayer)icommandsender).addChatComponentMessage(new ChatComponentText(ChatColor.RED + "Error usage: /level [USERNAME] [LEVEL]"));
		}
	}

    
	@Override
	public boolean canCommandSenderUseCommand(ICommandSender icommandsender)
	{
		return (icommandsender.canCommandSenderUseCommand(2, this.getCommandName()));
	}

	@Override
	public List addTabCompletionOptions(ICommandSender icommandsender, String[] astring)
	{
        return getListOfStringsMatchingLastWord(astring, MinecraftServer.getServer().getAllUsernames());
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