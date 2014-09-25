package fr.toss.common.game;

import fr.toss.client.event.GuiIngameOverlay;
import fr.toss.common.command.ChatColor;
import io.netty.buffer.ByteBuf;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class PacketTogglePvp implements IMessage {
   
	boolean pvp;
	
    public PacketTogglePvp()
    {
    	this(true);
    }
    
    public PacketTogglePvp(boolean b)
    {
    	this.pvp = b;
    }

	@Override
    public void fromBytes(ByteBuf buf)
	{
		this.pvp = buf.readBoolean();
	}

    @Override
    public void toBytes(ByteBuf buf)
    {
    	buf.writeBoolean(this.pvp);
    }

    public static class Handler implements IMessageHandler<PacketTogglePvp, IMessage> 
    {
		@Override
		@SideOnly(Side.CLIENT)
		public IMessage onMessage(PacketTogglePvp message, MessageContext ctx)
		{
			if (message.pvp)
				GuiIngameOverlay.INFO.add(ChatColor.YELLOW + "Le PVP a été activé... Bonne chance." + ChatColor.RESET);
			else
				GuiIngameOverlay.INFO.add(ChatColor.YELLOW + "Le PVP a été désactivé." + ChatColor.RESET);

			GuiIngameOverlay.DELAY_INFO = 5000;
			
			return (null);
		}
    }
}
