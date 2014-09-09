package fr.toss.common.packet;

import fr.toss.common.Main;
import fr.toss.common.player.ServerPlayerBaseMagic;
import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayerMP;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;

public class PacketSetClasse implements IMessage {
   
	public int classe;

    public PacketSetClasse()
    {
    	this(0);
    }
    
    public PacketSetClasse(int classe)
    {
    	this.classe = classe;
    }

    @Override
    public void fromBytes(ByteBuf buf)
    {
    	this.classe = buf.readInt();
    }

    @Override
    public void toBytes(ByteBuf buf)
    {
    	buf.writeInt(this.classe);
    }

    public static class Handler implements IMessageHandler<PacketSetClasse, IMessage> 
    {
		@Override
		public IMessage onMessage(PacketSetClasse message, MessageContext ctx)
		{
			EntityPlayerMP player;
			ServerPlayerBaseMagic pm;
			
			player = ctx.getServerHandler().playerEntity;
			pm = Main.getPlayerServer(player);
			
			pm.init(message.classe);

			
			return null;
		}
    }
}
