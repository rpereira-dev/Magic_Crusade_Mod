package fr.toss.common.packet;

import fr.toss.common.command.ChatColor;
import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.scoreboard.ScorePlayerTeam;
import net.minecraft.util.ChatComponentText;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;

public class PacketTeamToServer implements IMessage {
   
	public char group_name[];
	public int group_name_size;
	
	public char str[];
	public int str_size;
	
	public int id;

    public PacketTeamToServer()
    {
    	this(new char[0], 0, new char[0], 0, 0);
    }
    
    public PacketTeamToServer(char str[], int l, char str2[], int l2, int p_id)
    {
    	this.group_name = str;
    	this.group_name_size = l;
    	this.str = str2;
    	this.str_size = l2;
    	this.id = p_id;
    }

    @Override
    public void fromBytes(ByteBuf buf)
    {
    	this.group_name_size = buf.readInt();
    	this.group_name = new char[this.group_name_size];
    	for (int i = 0; i < this.group_name_size; i++)
    		this.group_name[i] = buf.readChar();
    	
    	this.str_size = buf.readInt();
    	this.str = new char[this.str_size];
    	for (int i = 0; i < this.str_size; i++)
    		this.str[i] = buf.readChar();
    	
    	this.id = buf.readInt();
    }

    @Override
    public void toBytes(ByteBuf buf)
    {
    	buf.writeInt(this.group_name_size);
    	for (int i = 0; i < this.group_name_size; i++)
    		buf.writeChar(this.group_name[i]);
    	
    	buf.writeInt(this.str_size);
    	for (int i = 0; i < this.str_size; i++)
    		buf.writeChar(this.str[i]);
    	
    	buf.writeInt(this.id);
    }

    public static class Handler implements IMessageHandler<PacketTeamToServer, IMessage> 
    {
		@Override
		public IMessage onMessage(PacketTeamToServer message, MessageContext ctx)
		{
			if (message.id == 1) //le joueur refuse l'invitation
			{
				EntityPlayerMP	player;				
				EntityPlayerMP	sender;				
		        
		        player = ctx.getServerHandler().playerEntity;
		        sender = (EntityPlayerMP) player.worldObj.getPlayerEntityByName(String.valueOf(message.str));
		        sender.addChatComponentMessage(new ChatComponentText(player.getCommandSenderName() + " refused your invitation."));
			}
			else if (message.id == 2) //le joueur accepte l'invitation
			{
				EntityPlayerMP	player;				
				EntityPlayer	tmp;				
		        ScorePlayerTeam team;
		        
		        player = ctx.getServerHandler().playerEntity;
		        team = ctx.getServerHandler().playerEntity.worldObj.getScoreboard().getTeam(String.valueOf(message.group_name));

				if (team != null)
				{
					player.worldObj.getScoreboard().func_151392_a(player.getCommandSenderName(), String.copyValueOf(message.group_name));
					for (Object obj : team.getMembershipCollection())
					{
						tmp = player.worldObj.getPlayerEntityByName(obj.toString());
						tmp.addChatComponentMessage(new ChatComponentText(player.getCommandSenderName() + " has joined the group."));
					}
				}
				else
					player.addChatComponentMessage(new ChatComponentText("This team no longer exists."));

			}
			else if (message.id == 3) //Invite un autre joueur 
			{
				EntityPlayerMP	player;
				EntityPlayerMP	player_invite;
	    		int err;
	    		
				player = ctx.getServerHandler().playerEntity;
				player_invite = (EntityPlayerMP) player.worldObj.getPlayerEntityByName(String.copyValueOf(message.str));
				
				if (player_invite == null)
	    			player.addChatComponentMessage(new ChatComponentText("This player isn't logged yet."));
				else if (player_invite != null && player_invite.getTeam() != null)
	    			player.addChatComponentMessage(new ChatComponentText("This player already has a team"));
				else //On invite le joeuur
				{
					PacketTeamToClient packet;
					
	    			player.addChatComponentMessage(new ChatComponentText("You have invited " + player_invite.getCommandSenderName()));
					packet = new PacketTeamToClient(player.getTeam().getRegisteredName().toCharArray(), player.getTeam().getRegisteredName().length(), player.getCommandSenderName().toCharArray(), player.getCommandSenderName().length(), 3);
					Packets.network.sendTo(packet, player_invite);
				}
			}
			else if (message.id == 4) //Crée un group
			{
				EntityPlayerMP	player;				
		        ScorePlayerTeam team;
		        
		        player = ctx.getServerHandler().playerEntity;
		        team = ctx.getServerHandler().playerEntity.worldObj.getScoreboard().getTeam(String.valueOf(message.group_name));

				if (team != null)
					player.addChatComponentMessage(new ChatComponentText("A group with the same name already exist."));
				else
				{
					player.worldObj.getScoreboard().createTeam(String.copyValueOf(message.group_name));
					player.worldObj.getScoreboard().func_151392_a(player.getCommandSenderName(), String.copyValueOf(message.group_name));
					player.worldObj.getScoreboard().getTeam(String.copyValueOf(message.group_name)).setNamePrefix("[" + String.valueOf(message.str) + "] <");
				}
			}
			else if (message.id == 5)//Quittes un group
			{
				EntityPlayerMP player;
				EntityPlayer tmp;
	    		ScorePlayerTeam team;

	    		player = ctx.getServerHandler().playerEntity;
	    		team = player.getWorldScoreboard().getPlayersTeam(player.getCommandSenderName());
	    		player.getWorldScoreboard().removePlayerFromTeams(player.getCommandSenderName());
				if (team.getMembershipCollection().size() == 0)
				{
					player.getWorldScoreboard().removeTeam(team);
					player.addChatComponentMessage(new ChatComponentText("Your group was destroyed"));
				}
				else
				{
					for (Object obj : team.getMembershipCollection())
					{
						tmp = player.worldObj.getPlayerEntityByName(obj.toString());
						tmp.addChatComponentMessage(new ChatComponentText(player.getCommandSenderName() + " has left the group."));
					}
				}
			}
			else if (message.id >= 10)//Rename un group
			{
				ChatColor		color;
				EntityPlayerMP	player;
				EntityPlayer	tmp;
	    		ScorePlayerTeam	team;

	    		color = (message.id - 10 == 0) ? ChatColor.AQUA : (message.id - 10 == 1) ? ChatColor.BLACK :
	    					(message.id - 10 == 2) ? ChatColor.BLUE : (message.id - 10 == 3) ? ChatColor.DARK_AQUA  :
	    	    				(message.id - 10 == 4) ? ChatColor.DARK_BLUE : (message.id - 10 == 5) ? ChatColor.DARK_GRAY :
	    	    	    				(message.id - 10 == 6) ? ChatColor.DARK_GREEN : (message.id - 10 == 7) ? ChatColor.DARK_PURPLE :
    	    	    	    				(message.id - 10 == 8) ? ChatColor.DARK_RED : (message.id - 10 == 9) ? ChatColor.GOLD :
	    	    	    	    				(message.id - 10 == 10) ? ChatColor.GRAY : (message.id - 10 == 11) ? ChatColor.GREEN :
		    	    	    	    				(message.id - 10 == 12) ? ChatColor.LIGHT_PURPLE : (message.id - 10 == 13) ? ChatColor.RED :
			    	    	    	    				(message.id - 10 == 14) ? ChatColor.WHITE : ChatColor.YELLOW;

	    		player = ctx.getServerHandler().playerEntity;
	    		team = player.getWorldScoreboard().getPlayersTeam(player.getCommandSenderName());
	    		team.setNamePrefix(color + "[" + String.valueOf(message.str) + "] ");
				for (Object obj : team.getMembershipCollection())
				{
					tmp = player.worldObj.getPlayerEntityByName(obj.toString());
					if (tmp != null)
						tmp.addChatComponentMessage(new ChatComponentText("Your group prefix has been changed."));
				}
			}
			
			return null;
		}
    }
}
