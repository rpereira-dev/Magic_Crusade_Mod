package fr.toss.common.packet;

import io.netty.buffer.ByteBuf;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import fr.toss.common.Main;
import fr.toss.common.player.ClientPlayerBaseMagic;
import fr.toss.common.player.ServerPlayerBaseMagic;

public class PacketLogIn implements IMessage {
   
	public int classe_id;
	public int level;
	public int current_experience;

    public PacketLogIn()
    {
    	this(0,0,0);
    }
    
    public PacketLogIn(int a, int b, int c)
    {
        this.classe_id = a;
        this.level = b;
        this.current_experience = c;
    }
    
    public PacketLogIn(ServerPlayerBaseMagic player)
    {
        this.classe_id = player.getClasse();
        this.level = player.getLevel();
        this.current_experience = player.getExperience();
    }

    @Override
    public void fromBytes(ByteBuf buf)
    {
        this.classe_id = buf.readInt();
        this.level = buf.readInt();
        this.current_experience = buf.readInt();
    }

    @Override
    public void toBytes(ByteBuf buf)
    {
    	buf.writeInt(this.classe_id);
    	buf.writeInt(this.level);
    	buf.writeInt(this.current_experience);
    }

    public static class Handler implements IMessageHandler<PacketLogIn, IMessage> {
       
        @Override
        public IMessage onMessage(PacketLogIn message, MessageContext ctx) 
        {
        	ClientPlayerBaseMagic player;
        	
        	player = Main.getPlayerClient();
        	player.initPlayer(message);

        	
        	return null;
        }
    }
}
