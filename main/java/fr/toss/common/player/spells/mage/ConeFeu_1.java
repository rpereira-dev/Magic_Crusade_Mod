package fr.toss.common.player.spells.mage;

import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.EntityFX;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.Entity;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import fr.toss.client.render.particles.EntityFX_Colored;
import fr.toss.common.command.ChatColor;
import fr.toss.common.packet.PacketParticleEffectToServer;
import fr.toss.common.packet.PacketSpellToServer;
import fr.toss.common.packet.Packets;
import fr.toss.common.player.spells.Spell;

public class ConeFeu_1 extends Spell {

	public static int getUniqueID()
	{
		return 40;
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
		return I18n.format("spell.mage.cone");
	}

	@Override
	public boolean onUse()
	{
		PacketSpellToServer packet;
		Entity e;
		
		e = this.getLookingEntity(16.0d);
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
		str[1] = "damages and can leave";
		str[2] = "your target on fire.";

		return (str);
	}
	
	@Override
	public void sendEffectToServer(Object ... obj)
	{
		PacketParticleEffectToServer packet;
		Entity e;
		
		e = (Entity) obj[0];
		packet = new PacketParticleEffectToServer(getUniqueID(), e.posX, e.posY, e.posZ, e.dimension);
		Packets.network.sendToServer(packet);		
	}
	
	public static void playEffect(double x, double y, double z)
	{
		World world;
		EntityFX particles;
		float a;
		float b;
		float c;
		float rayon;
		
		b = 0;
		world = Minecraft.getMinecraft().theWorld;
		for (int pi = 0; pi < 360; pi++)
        {
			for (int longueur = 0; longueur < 10; longueur++)
			{
				rayon = 1 + longueur / 5.0f;
				a = rayon * MathHelper.cos(pi);
				c = rayon * MathHelper.sin(pi);
	
	    		world.spawnParticle("flame", x, y, z, a / 16.0f, (b + 10 - longueur) / 16.0f, c / 16.0f);
			}
        }
	}
}
