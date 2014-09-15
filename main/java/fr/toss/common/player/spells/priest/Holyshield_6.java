package fr.toss.common.player.spells.priest;

import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.EntityFX;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import fr.toss.client.render.particles.EntityFX_Colored;
import fr.toss.common.packet.PacketParticleEffectToServer;
import fr.toss.common.packet.PacketSpellToServer;
import fr.toss.common.packet.Packets;
import fr.toss.common.player.spells.Spell;

public class Holyshield_6 extends Spell {

	public static int getUniqueID()
	{
		return 5;
	}
	
	@Override
	public int getLevel() 
	{
		return 12;
	}

	@Override
	public int getCost()
	{
		return 680;
	}
	
	@Override
	public String getName()
	{
		return I18n.format("spell.priest.holyshield");
	}

	
	@Override
	public String[] getDescription() 
	{
		String str[];
		
		str = new String[2];
		str[0] = "Shield and give a regeneration";
		str[1] = "effect to your target";
		
		return (str);
	}
	
	@Override
	public boolean onUse()
	{
		PacketSpellToServer packet;
		Entity e;
		
		e = this.getLookingEntity(30.0d);
		if (e == null)
			e = player.getPlayer();
		this.sendEffectToServer(e);
		packet = new PacketSpellToServer(getUniqueID(), e.getEntityId());
		Packets.network.sendToServer(packet);
		return (true);
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
		int rayon;
		
		y += 2;
		
		world = Minecraft.getMinecraft().theWorld;
		rayon = 4;
		for (int phi = -180; phi < 180; phi += 2)
		{
			for (int teta = -90; teta < 90; teta += 2)
			{
				a = rayon * MathHelper.cos(teta) * MathHelper.cos(phi);
				b = rayon * MathHelper.cos(teta) * MathHelper.sin(phi);
				c = rayon * MathHelper.sin(teta);
				
				world.spawnParticle("fireworksSpark", x, y, z, a / 8.0f, -b / 8.0f, c / 8.0f);
				particles = new EntityFX_Colored(world, x, y, z, a / 8.0f, -b / 8.0f, c / 8.0f, 2.0f, 5.0f, 0.0f, 1.5f);
				Minecraft.getMinecraft().effectRenderer.addEffect(particles);
			}
		}
	}
}