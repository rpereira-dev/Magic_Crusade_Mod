package fr.toss.common.packet;

import fr.toss.common.player.spells.champion.EarthShield_5;
import fr.toss.common.player.spells.champion.Grab_4;
import fr.toss.common.player.spells.champion.Ironskin_3;
import fr.toss.common.player.spells.champion.Shockwave_2;
import fr.toss.common.player.spells.necromancer.Drain_1;
import fr.toss.common.player.spells.priest.Buff_4;
import fr.toss.common.player.spells.priest.GodTouch_5;
import fr.toss.common.player.spells.priest.Heal_2;
import fr.toss.common.player.spells.priest.Healzone_3;
import fr.toss.common.player.spells.priest.Purification_1;
import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;
import cpw.mods.fml.common.network.NetworkRegistry.TargetPoint;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;

public class PacketParticleEffectToServer implements IMessage {
   
	public int effectID;
	public double x;
	public double y;
	public double z;
	public int dimensionID;

    public PacketParticleEffectToServer()
    {
    	this(0, 0, 0, 0, 0);
    }
    
    public PacketParticleEffectToServer(int a, double b, double c, double d, int e)
    {
    	this.effectID = a;
    	this.x = b;
    	this.y = c;
    	this.z = d;
    	this.dimensionID = e;
    }

    @Override
    public void fromBytes(ByteBuf buf)
    {
    	this.effectID = buf.readInt();
        this.x = buf.readDouble();
        this.y = buf.readDouble();
        this.z = buf.readDouble();
        this.dimensionID = buf.readInt();
    }

    @Override
    public void toBytes(ByteBuf buf)
    {
    	buf.writeInt(this.effectID);
    	buf.writeDouble(this.x);
    	buf.writeDouble(this.y);
    	buf.writeDouble(this.z);
    	buf.writeInt(this.dimensionID);
    }

    public static class Handler implements IMessageHandler<PacketParticleEffectToServer, IMessage> 
    {
		@Override
		public IMessage onMessage(PacketParticleEffectToServer message, MessageContext ctx)
		{
			World world;
			EntityPlayerMP player;
			TargetPoint point;
			
			
			player = ctx.getServerHandler().playerEntity;
			world = player.worldObj;
			point = new TargetPoint(message.dimensionID, message.x, message.y, message.z, 40.0D);
			Packets.network.sendToAllAround(new PacketParticleEffectToClient(message), point);
			
			return null;
		}
    }
}
