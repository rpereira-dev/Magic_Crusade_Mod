package fr.toss.common.player.spells.rogue;

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

public class Poison_4 extends Spell {

	public static int getUniqueID()
	{
		return 53;
	}
	
	@Override
	public int getLevel() 
	{
		return 4;
	}

	@Override
	public int getCost()
	{
		return 24;
	}
	
	@Override
	public String getName()
	{
		return I18n.format("spell.rogue.poison");
	}

	@Override
	public String[] getDescription() 
	{
		String str[];
		
		str = new String[2];
		str[0] = "Your next attack poison";
		str[1] = "the ennemi for 5 seconds.";

		return (str);
	}

	@Override
	public boolean onUse()
	{
		PacketSpellToServer packet;

		this.sendEffectToServer(player.getPlayer());
		packet = new PacketSpellToServer(getUniqueID(), 0);
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
		EntityPlayer player;
		EntityFX particles;
		float a;
		float b;
		float c;
		
		world = Minecraft.getMinecraft().theWorld;
    	player = Minecraft.getMinecraft().thePlayer;
		for (int i = 0; i < 250; i++)
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
    		
    		world.spawnParticle("smoke", x, y, z, a, b, c);
    		particles = new EntityFX_Colored(world, x, y, z, a, -b, c, 0.5f, 0.5f, 5.0f, 0.0f);
    		Minecraft.getMinecraft().effectRenderer.addEffect(particles);
        }
	}
}
