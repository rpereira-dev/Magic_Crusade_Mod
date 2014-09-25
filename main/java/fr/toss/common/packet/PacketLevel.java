package fr.toss.common.packet;

import fr.toss.common.Main;
import fr.toss.common.command.ChatColor;
import fr.toss.common.player.ClientPlayerBaseMagic;
import io.netty.buffer.ByteBuf;
import net.minecraft.util.ChatComponentText;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class PacketLevel implements IMessage {

	public int level;
	
	public PacketLevel()
	{
		this(0);
	}
	
	public PacketLevel(int level)
	{
		this.level = level;
	}
	
	@Override
	public void fromBytes(ByteBuf buf)
	{
		this.level = buf.readInt();
	}
	
	@Override
	public void toBytes(ByteBuf buf)
	{
		buf.writeInt(this.level);
	}
	
   public static class Handler implements IMessageHandler<PacketLevel, IMessage> 
   {
		@Override
		@SideOnly(Side.CLIENT)
		public IMessage onMessage(PacketLevel message, MessageContext ctx)
		{
			ClientPlayerBaseMagic pm;
			
			pm = Main.getPlayerClient();
			pm.getPlayer().addChatComponentMessage(new ChatComponentText("You level was set to: " + message.level + " (" + (pm.level > message.level ? ChatColor.RED + "-" + (pm.level - message.level) : ChatColor.AQUA + "+" + (message.level - pm.level)) + ChatColor.RESET + ")"));
			pm.level = message.level;
			return (null);
		}
   }
}
