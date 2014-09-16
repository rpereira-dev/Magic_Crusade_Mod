package fr.toss.common.packet;

import fr.toss.common.items.ItemSwordEthernium;
import fr.toss.common.player.spells.champion.Arena_6;
import fr.toss.common.player.spells.champion.Charge_1;
import fr.toss.common.player.spells.champion.EarthShield_5;
import fr.toss.common.player.spells.champion.Grab_4;
import fr.toss.common.player.spells.champion.Ironskin_3;
import fr.toss.common.player.spells.champion.Shockwave_2;
import fr.toss.common.player.spells.mage.ArcanaPillow_5;
import fr.toss.common.player.spells.mage.ConeFeu_1;
import fr.toss.common.player.spells.mage.FieldDestruction_4;
import fr.toss.common.player.spells.mage.FreezeCube_2;
import fr.toss.common.player.spells.mage.Transfert_3;
import fr.toss.common.player.spells.necromancer.Corruption_5;
import fr.toss.common.player.spells.necromancer.Drain_1;
import fr.toss.common.player.spells.necromancer.Fireland_2;
import fr.toss.common.player.spells.necromancer.Necromancy_6;
import fr.toss.common.player.spells.necromancer.Zombie_4;
import fr.toss.common.player.spells.priest.Buff_4;
import fr.toss.common.player.spells.priest.GodTouch_5;
import fr.toss.common.player.spells.priest.Heal_2;
import fr.toss.common.player.spells.priest.Healzone_3;
import fr.toss.common.player.spells.priest.HolyExplosion_7;
import fr.toss.common.player.spells.priest.Holyshield_6;
import fr.toss.common.player.spells.priest.Purification_1;
import fr.toss.common.player.spells.rogue.Poison_4;
import fr.toss.common.player.spells.rogue.Speed_2;
import io.netty.buffer.ByteBuf;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class PacketParticleEffectToClient implements IMessage {
   
	public int effectID;
	public double x;
	public double y;
	public double z;

    public PacketParticleEffectToClient(int a, double b, double c, double d)
    {
    	this.effectID = a;
    	this.x = b;
    	this.y = c;
    	this.z = d;
    }
    
    public PacketParticleEffectToClient()
    {
    	this(0, 0, 0, 0);
    }
    

    public PacketParticleEffectToClient(PacketParticleEffectToServer message)
    {
    	this(message.effectID, message.x, message.y, message.z);
    }

	@Override
    public void fromBytes(ByteBuf buf)
    {
    	this.effectID = buf.readInt();
        this.x = buf.readDouble();
        this.y = buf.readDouble();
        this.z = buf.readDouble();
    }

    @Override
    public void toBytes(ByteBuf buf)
    {
    	buf.writeInt(this.effectID);
    	buf.writeDouble(this.x);
    	buf.writeDouble(this.y);
    	buf.writeDouble(this.z);
    }

    public static class Handler implements IMessageHandler<PacketParticleEffectToClient, IMessage> 
    {
		@Override
		@SideOnly(Side.CLIENT)
		public IMessage onMessage(PacketParticleEffectToClient message, MessageContext ctx)
		{
			if (message.effectID == Charge_1.getUniqueID())
				Charge_1.playEffect(message.x, message.y, message.z);
			else if (message.effectID == Shockwave_2.getUniqueID())
				Shockwave_2.playEffect(message.x, message.y, message.z);
			else if (message.effectID == Ironskin_3.getUniqueID())
				Ironskin_3.playEffect(message.x, message.y, message.z);
			else if (message.effectID == EarthShield_5.getUniqueID())
				EarthShield_5.playEffect(message.x, message.y, message.z);
			else if (message.effectID == Grab_4.getUniqueID())
				Grab_4.playEffect(message.x, message.y, message.z);
			else if (message.effectID == Arena_6.getUniqueID())
				Arena_6.playEffect(message.x, message.y, message.z);
			
			else if(message.effectID == Purification_1.getUniqueID())
				Purification_1.playEffect(message.x, message.y, message.z);
			else if(message.effectID == Heal_2.getUniqueID())
				Heal_2.playEffect(message.x, message.y, message.z);
			else if(message.effectID == Healzone_3.getUniqueID())
				Healzone_3.playEffect(message.x, message.y, message.z);
			else if(message.effectID == Buff_4.getUniqueID())
				Buff_4.playEffect(message.x, message.y, message.z);
			else if(message.effectID == GodTouch_5.getUniqueID())
				GodTouch_5.playEffect(message.x, message.y, message.z);
			else if(message.effectID == Holyshield_6.getUniqueID())
				Holyshield_6.playEffect(message.x, message.y, message.z);
			else if(message.effectID == HolyExplosion_7.getUniqueID())
				HolyExplosion_7.playEffect(message.x, message.y, message.z);
			
			else if(message.effectID == Drain_1.getUniqueID())
				Drain_1.playEffect(message.x, message.y, message.z);
			else if(message.effectID == Fireland_2.getUniqueID())
				Fireland_2.playEffect(message.x, message.y, message.z);
			else if(message.effectID == Zombie_4.getUniqueID())
				Zombie_4.playEffect(message.x, message.y, message.z);
			else if(message.effectID == Corruption_5.getUniqueID())
				Corruption_5.playEffect(message.x, message.y, message.z);
			else if(message.effectID == Necromancy_6.getUniqueID())
				Necromancy_6.playEffect(message.x, message.y, message.z);
			
			else if(message.effectID == ConeFeu_1.getUniqueID())
				ConeFeu_1.playEffect(message.x, message.y, message.z);
			else if(message.effectID == FreezeCube_2.getUniqueID())
				FreezeCube_2.playEffect(message.x, message.y, message.z);
			else if(message.effectID == Transfert_3.getUniqueID())
				Transfert_3.playEffect(message.x, message.y, message.z);
			else if(message.effectID == FieldDestruction_4.getUniqueID())
				FieldDestruction_4.playEffect(message.x, message.y, message.z);
			else if(message.effectID == ArcanaPillow_5.getUniqueID())
				ArcanaPillow_5.playEffect(message.x, message.y, message.z);
			
			else if(message.effectID == Speed_2.getUniqueID())
				Speed_2.playEffect(message.x, message.y, message.z);
			else if(message.effectID == Poison_4.getUniqueID())
				Poison_4.playEffect(message.x, message.y, message.z);
			
			else if(message.effectID == 100)
				ItemSwordEthernium.playEffect(message.x, message.y, message.z);
			
			return (null);
		}
    }
}
