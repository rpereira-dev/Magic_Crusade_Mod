package fr.toss.common.packet;

import fr.toss.common.Main;
import fr.toss.common.player.ServerPlayerBaseMagic;
import fr.toss.common.player.spells.ServerSpellHandler;
import fr.toss.common.player.spells.rogue.Speed_2;
import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;

public class PacketSpellToServer implements IMessage {
   
	public int spell_id;
	public int data;
	public float data2;

    public PacketSpellToServer()
    {
    	this(0, 0, 0);
    }
    
    public PacketSpellToServer(int a, int b)
    {
    	this(a, b, 0);
    }
    
    public PacketSpellToServer(int a, int b, float c)
    {
    	this.spell_id = a;
    	this.data = b;
    	this.data2 = c;
    }

	public PacketSpellToServer(int a)
	{
		this(a, 0, 0);
	}

	@Override
    public void fromBytes(ByteBuf buf)
    {
    	this.spell_id = buf.readInt();
    	this.data = buf.readInt();
    	this.data2 = buf.readFloat();
    }

    @Override
    public void toBytes(ByteBuf buf)
    {
    	buf.writeInt(this.spell_id);
    	buf.writeInt(this.data);
    	buf.writeFloat(this.data2);
    }

    public static class Handler implements IMessageHandler<PacketSpellToServer, IMessage> 
    {
		@Override
		public IMessage onMessage(PacketSpellToServer message, MessageContext ctx)
		{
			EntityPlayerMP sender;
			ServerPlayerBaseMagic pm;
			World world;
			
			sender = ctx.getServerHandler().playerEntity;
			pm = Main.getPlayerServer(sender);
			world = sender.worldObj;

			if (message.spell_id == 11)
				ServerSpellHandler.handle_shockwave(message, world, sender);
			else if (message.spell_id == 12)
				sender.addPotionEffect(new PotionEffect(Potion.resistance.id, 200, 2));
			else if (message.spell_id == 14)
				sender.addPotionEffect(new PotionEffect(Potion.field_76444_x.id, 40, 9));
			else if (message.spell_id == 13)
				ServerSpellHandler.handle_grab(message, world, sender);
			else if (message.spell_id == 15)
				ServerSpellHandler.handle_arena(message, world, sender);
			
			else if (message.spell_id == 0)
				ServerSpellHandler.handle_purification(message, world);
			else if (message.spell_id == 1)
				ServerSpellHandler.handle_heal(message, world);
			else if (message.spell_id == 2)
				ServerSpellHandler.handle_heal_zone(message, world);
			else if (message.spell_id == 3)
				ServerSpellHandler.handle_buff(message, world);
			else if (message.spell_id == 4)
				ServerSpellHandler.handle_invincible(message, world);
			else if (message.spell_id == 5)
				ServerSpellHandler.handle_holyshield(message, world);
			else if (message.spell_id == 6)
				ServerSpellHandler.handle_holyexplosion(message, world, sender);
			
			else if (message.spell_id == 30)
				ServerSpellHandler.handle_shotpoison(world, sender);
			else if (message.spell_id == 31)
				ServerSpellHandler.handle_magicshot(world, sender);
			else if (message.spell_id == 32)
				ServerSpellHandler.handle_explodeshot(world, sender);
			else if (message.spell_id == 33)
				ServerSpellHandler.handle_refinement(world, sender);
			else if (message.spell_id == 34)
				ServerSpellHandler.handle_wolfsummon(world, sender);
			else if (message.spell_id == 35)
				ServerSpellHandler.handle_frozenshot(world, sender);
			
			else if (message.spell_id == 20)
				ServerSpellHandler.handle_drain(message, world, sender);
			else if (message.spell_id == 21)
				ServerSpellHandler.handle_fireland(message, world, sender);
			else if (message.spell_id == 22)
				ServerSpellHandler.handle_witherskull(message, world, sender);
			else if (message.spell_id == 23)
				ServerSpellHandler.handle_zombiesummon(world, sender, message.data2);
			else if (message.spell_id == 24)
				ServerSpellHandler.handle_corruption(world, sender, message.data, message.data2);
			else if (message.spell_id == 25)
				ServerSpellHandler.handle_necromancy(message, world, sender);
			
			else if (message.spell_id == 40)
				ServerSpellHandler.handle_conefeu(message, world, sender);
			else if (message.spell_id == 41)
				ServerSpellHandler.handle_frozencube(message, world, sender);
			else if (message.spell_id == 42)
				ServerSpellHandler.handle_teleport(message, world, sender);
			else if (message.spell_id == 43)
				ServerSpellHandler.handle_field_destruction(message, world, sender);
			else if (message.spell_id == 44)
				ServerSpellHandler.handle_arcane_pillow(message, world, sender);
			else if (message.spell_id == 45)
				ServerSpellHandler.handle_fireball(world, sender);
			
			else if(message.spell_id == 51)
				ServerSpellHandler.handle_speed_rogue(sender);
			else if(message.spell_id == 52)
				ServerSpellHandler.handle_invisible(sender);
			else if(message.spell_id == 53)
				pm.is_poisonned = true;
			else if(message.spell_id == 54)
				ServerSpellHandler.handle_vision(sender);
			else if(message.spell_id == 55)
				ServerSpellHandler.handle_boots(sender);
			
			return (null);
		}
    }
}
