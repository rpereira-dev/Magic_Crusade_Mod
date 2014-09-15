package fr.toss.common.player.spells.necromancer;

import java.util.List;

import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.EntityFX;
import net.minecraft.client.resources.I18n;
import net.minecraft.util.ChatComponentText;
import net.minecraft.world.World;
import fr.toss.client.render.particles.EntityFX_Colored;
import fr.toss.common.command.ChatColor;
import fr.toss.common.entity.EntitySummonZombie;
import fr.toss.common.packet.PacketParticleEffectToServer;
import fr.toss.common.packet.PacketSpellToServer;
import fr.toss.common.packet.Packets;
import fr.toss.common.player.spells.Spell;

public class Zombie_4 extends Spell {

	public static int getUniqueID()
	{
		return 23;
	}
	
	@Override
	public int getLevel() 
	{
		return 4;
	}

	@Override
	public int getCost()
	{
		return 800;
	}
	
	@Override
	public String[] getDescription() 
	{
		String str[];
		
		str = new String[3];
		str[0] = "Summon 4 zombies nearby. They have";
		str[1] = "10 hp (+ " + ChatColor.AQUA + (this.player.clarity / 15) + ChatColor.RESET + ") and you can equip";
		str[2] = "them with weapon (right click)";

		return (str);
	}
	
	@Override
	public String getName()
	{
		return I18n.format("spell.necromancer.zombie");
	}

	@Override
	public boolean onUse()
	{
		List list;
		
		list = this.getEntitiesAround(10.0d, true);
		for (int i = 0; i < list.size(); i++)
		{
			if (list.get(i) instanceof EntitySummonZombie)
			{
				player.getPlayer().addChatComponentMessage(new ChatComponentText(ChatColor.RED + "You already have zombies summoned" + ChatColor.RESET));
				return (false);
			}
		}

		PacketSpellToServer packet;
		
		packet = new PacketSpellToServer(getUniqueID());
		Packets.network.sendToServer(packet);

		PacketParticleEffectToServer p;
		
		p = new PacketParticleEffectToServer(getUniqueID(), player.getPlayer().posX, player.getPlayer().posY, player.getPlayer().posZ, player.getPlayer().dimension);
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
