package fr.toss.common.player.spells.necromancer;

import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.EntityFX;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.Entity;
import net.minecraft.util.ChatComponentText;
import net.minecraft.world.World;
import fr.toss.client.render.particles.EntityFX_Colored;
import fr.toss.common.command.ChatColor;
import fr.toss.common.packet.PacketParticleEffectToServer;
import fr.toss.common.packet.PacketSpellToServer;
import fr.toss.common.packet.Packets;
import fr.toss.common.player.spells.Spell;

public class Drain_1 extends Spell {

	public static int getUniqueID()
	{
		return 20;
	}
	
	@Override
	public int getLevel() 
	{
		return 1;
	}

	@Override
	public int getCost()
	{
		return 360;
	}
	
	@Override
	public String getName()
	{
		return I18n.format("spell.necromancer.drain");
	}

	@Override
	public boolean onUse()
	{
		PacketSpellToServer packet;
		Entity e;
		
		e = this.getLookingEntity(30.0d);
		if (e != null)
		{
			this.sendEffectToServer(e);
			packet = new PacketSpellToServer(getUniqueID(), e.getEntityId(), this.player.clarity / 20);
			Packets.network.sendToServer(packet);
			return (true);
		}
		else
			player.getPlayer().addChatComponentMessage(new ChatComponentText(ChatColor.RED + "No target available." + ChatColor.RESET));

		return (false);
	}
	
	@Override
	public String[] getDescription() 
	{
		String str[];
		
		str = new String[3];
		str[0] = "Inflict 4 (+ " + ChatColor.AQUA + (this.player.clarity / 20.0f) + ChatColor.RESET + ") magic";
		str[1] = "damages and heal you half";
		str[2] = "the damages dealt.";

		return (str);
	}
	
	@Override
	public void sendEffectToServer(Object ... obj)
	{
		PacketParticleEffectToServer packet;
		Entity e;
		
		e = (Entity) obj[0];
		packet = new PacketParticleEffectToServer(getUniqueID(), e.posX, e.posY, e.posZ, player.getPlayer().dimension);
		Packets.network.sendToServer(packet);		
	}
	
	public static void playEffect(double x, double y, double z)
	{
		World world;
		EntityFX particles;
		float a;
		float b;
		float c;
		int x1;
		int z1;
		
		x1 = 5;
		z1 = 5;
		world = Minecraft.getMinecraft().theWorld;
		for (int i = 0; i < 100; i++)
        {
    		a = (float) (Math.random() - 0.5);
    		if(Math.random() * 2 + 1 == 0)
    			a = -a;
    		b = (float) (Math.random() * 2 - 0.5);
    		if(Math.random() * 2 + 1 == 0)
    			b=-b;
    		c = (float) (Math.random() - 0.5);
    		if(Math.random() * 2 + 1 == 0)
    			c=-c;
    		
    		world.spawnParticle("smoke", x, y, z, -a, -b / 2.0f, -c);
    		particles = new EntityFX_Colored(world, x, y, z, a, b / 2.0f, c, 1.0f, 5.0f, 0.0f, 0.0f);
    		Minecraft.getMinecraft().effectRenderer.addEffect(particles);
    		particles = new EntityFX_Colored(world, x, y, z, a, b / 2.0f, c, 1.0f, 0.0f, 5.0f, 0.0f);
    		Minecraft.getMinecraft().effectRenderer.addEffect(particles);
        }
	}
}
