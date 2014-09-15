package fr.toss.common.player.spells.necromancer;

import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.EntityFX;
import net.minecraft.client.resources.I18n;
import net.minecraft.world.World;
import fr.toss.client.render.particles.EntityFX_Colored;
import fr.toss.common.packet.PacketSpellToServer;
import fr.toss.common.packet.Packets;
import fr.toss.common.player.spells.Spell;

public class WitherSkull_3 extends Spell {

	public static int getUniqueID()
	{
		return 22;
	}
	
	@Override
	public int getLevel() 
	{
		return 1;
	}

	@Override
	public int getCost()
	{
		return 300;
	}
	
	@Override
	public String getName()
	{
		return I18n.format("spell.necromancer.witherskull");
	}

	@Override
	public boolean onUse()
	{
		PacketSpellToServer packet;
		
		packet = new PacketSpellToServer(getUniqueID());
		Packets.network.sendToServer(packet);

		return (true);
	}
	
	@Override
	public String[] getDescription() 
	{
		String str[];
		
		str = new String[2];
		str[0] = "Randomly shot a wither skull which";
		str[1] = "inflicts heavy damages.";

		return (str);
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
		System.out.println("aaaaaaaaaaaa");
	}
}
