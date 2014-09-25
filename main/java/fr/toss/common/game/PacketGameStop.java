package fr.toss.common.game;

import fr.toss.client.event.GuiIngameOverlay;
import fr.toss.common.command.ChatColor;
import io.netty.buffer.ByteBuf;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class PacketGameStop implements IMessage {
   
    public PacketGameStop() {}

	@Override
    public void fromBytes(ByteBuf buf) {}

    @Override
    public void toBytes(ByteBuf buf) {}

    public static class Handler implements IMessageHandler<PacketGameStop, IMessage> 
    {
		@Override
		@SideOnly(Side.CLIENT)
		public IMessage onMessage(PacketGameStop message, MessageContext ctx)
		{
			GuiIngameOverlay.INFO.add(ChatColor.YELLOW + "Le jeu est fini :)" + ChatColor.RESET);
			GuiIngameOverlay.DELAY_INFO = 10000;
			
			return (null);
		}
    }
}
