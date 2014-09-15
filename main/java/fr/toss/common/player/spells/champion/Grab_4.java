package fr.toss.common.player.spells.champion;

import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.EntityFX;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import fr.toss.client.render.particles.EntityFX_Colored;
import fr.toss.common.packet.PacketParticleEffectToServer;
import fr.toss.common.packet.PacketSpellToServer;
import fr.toss.common.packet.Packets;
import fr.toss.common.player.spells.Spell;

public class Grab_4 extends Spell {

	public static int getUniqueID()
	{
		return 13;
	}
	
	@Override
	public int getLevel() 
	{
		return 1;
	}

	@Override
	public int getCost()
	{
		return 200;
	}
	
	@Override
	public String[] getDescription() 
	{
		String str[];
		
		str = new String[3];
		str[0] = "The Champion attract the target.";
		str[1] = "It makes the target bump to";
		str[2] = "the player.";

		return (str);
	}
	
	@Override
	public String getName()
	{
		return I18n.format("spell.champion.grab");
	}

	@Override
	public boolean onUse()
	{		
		PacketSpellToServer packet;
		Entity e;
		
		e = this.getLookingEntity(20.0d);
		if (e != null)
		{
			packet = new PacketSpellToServer(getUniqueID(), e.getEntityId());
			Packets.network.sendToServer(packet);
			this.sendEffectToServer(e);
			return (true);
		}
		return (false);
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
		EntityPlayer player;
		EntityFX particles;
		double x1;
		double y1;
		double z1;
		float a;
		float c;
		
		world = Minecraft.getMinecraft().theWorld;
    	player = Minecraft.getMinecraft().thePlayer;
		for (int i = 0; i < 100; i++)
        {
			x1 = (world.rand.nextInt(2) == 0) ? x + 3 : x - 3;
			y1 = y + world.rand.nextInt(3);
			z1 = (world.rand.nextInt(2) == 0) ? z + 3 : z - 3;

			a = (float) (x - x1) / 3;
			c = (float) (z - z1) / 3;
			
			particles = new EntityFX_Colored(world, x1, y1, z1, a, 0.1f, c, 2.0f, 1, 1, 1);
    		Minecraft.getMinecraft().effectRenderer.addEffect(particles);
        }
	}
}
