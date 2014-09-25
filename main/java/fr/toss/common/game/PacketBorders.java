package fr.toss.common.game;

import fr.toss.client.event.GuiIngameOverlay;
import fr.toss.common.Main;
import fr.toss.common.command.ChatColor;
import io.netty.buffer.ByteBuf;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class PacketBorders implements IMessage {
   
	int minX;
	int maxX;
	int minZ;
	int maxZ;
	
    public PacketBorders()
    {
    	this(Main.server);
    }
    
    public PacketBorders(ServerMagic server)
    {
    	if (server != null)
    	{
	    	this.minX = server.min_x;
	    	this.minZ = server.min_z;
	    	this.maxX = server.max_x;
	    	this.maxZ = server.max_z;
    	}
    }

	@Override
    public void fromBytes(ByteBuf buf)
	{
    	this.minX = buf.readInt();
    	this.minZ = buf.readInt();
    	this.maxX = buf.readInt();
    	this.maxZ = buf.readInt();
    	
	}

    @Override
    public void toBytes(ByteBuf buf)
    {
    	buf.writeInt(this.minX);
    	buf.writeInt(this.minZ);
    	buf.writeInt(this.maxX);
    	buf.writeInt(this.maxZ);
    }

    public static class Handler implements IMessageHandler<PacketBorders, IMessage> 
    {
		@Override
		@SideOnly(Side.CLIENT)
		public IMessage onMessage(PacketBorders message, MessageContext ctx)
		{
			GuiIngameOverlay.INFO.add(ChatColor.YELLOW + "Limite de la carte: (" + message.minX + ";" + message.minZ + ") - (" + message.maxX + ";" + message.maxZ + ")"+ ChatColor.RESET);
			GuiIngameOverlay.DELAY_INFO = 5000;
			
			return (null);
		}
    }
}
