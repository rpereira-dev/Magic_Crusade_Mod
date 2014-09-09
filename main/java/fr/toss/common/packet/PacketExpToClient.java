package fr.toss.common.packet;

import fr.toss.common.Main;
import io.netty.buffer.ByteBuf;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class PacketExpToClient implements IMessage {
   
	public int exp;

    public PacketExpToClient(int a)
    {
    	this.exp = a;
    }
    
    public PacketExpToClient()
    {
    	this(0);
    }

	@Override
    public void fromBytes(ByteBuf buf)
    {
    	this.exp = buf.readInt();
    }

    @Override
    public void toBytes(ByteBuf buf)
    {
    	buf.writeInt(this.exp);
    }

    public static class Handler implements IMessageHandler<PacketExpToClient, IMessage> 
    {
		@Override
		@SideOnly(Side.CLIENT)
		public IMessage onMessage(PacketExpToClient message, MessageContext ctx)
		{
			Main.getPlayerClient().experience_to_get = message.exp;
			
			return (null);
		}
    }
}
