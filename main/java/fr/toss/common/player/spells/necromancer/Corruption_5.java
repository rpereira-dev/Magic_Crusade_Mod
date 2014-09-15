package fr.toss.common.player.spells.necromancer;

import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.EntityFX;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.world.World;
import fr.toss.common.command.ChatColor;
import fr.toss.common.packet.PacketParticleEffectToServer;
import fr.toss.common.packet.PacketSpellToServer;
import fr.toss.common.packet.Packets;
import fr.toss.common.player.spells.Spell;

public class Corruption_5 extends Spell {

	public static int getUniqueID()
	{
		return 24;
	}
	
	@Override
	public int getLevel() 
	{
		return 1;
	}

	@Override
	public int getCost()
	{
		return 442;
	}
	
	@Override
	public String[] getDescription() 
	{
		String str[];
		
		str = new String[2];
		str[0] = "A malediction that deals damages to";
		str[1] = "your target for 4 (+ " + ChatColor.AQUA + ((int) (this.player.clarity / 24)) + ChatColor.RESET + ") seconds";

		return (str);
	}
	
	@Override
	public String getName()
	{
		return I18n.format("spell.necromancer.corruption");
	}

	@Override
	public boolean onUse()
	{
		Entity e;
		
		e = this.getLookingEntity(30.0d);
		
		if (e == null || !(e instanceof EntityLivingBase))
			return (false);

		PacketSpellToServer packet;
		
		packet = new PacketSpellToServer(getUniqueID(), e.getEntityId(), this.player.clarity);
		Packets.network.sendToServer(packet);

		PacketParticleEffectToServer p;
		
		p = new PacketParticleEffectToServer(getUniqueID(), e.posX, e.posY, e.posZ, player.getPlayer().dimension);
		Packets.network.sendToServer(p);
		return (true);
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
		for (int i = 0; i < 300; i++)
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
    		
    		world.spawnParticle("smoke", x, y, z, -a, -b, -c);
        }
	}
}
