package fr.toss.common.player.spells.champion;

import java.util.List;

import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.EntityFX;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import fr.toss.client.render.particles.EntityFX_Colored;
import fr.toss.common.command.ChatColor;
import fr.toss.common.packet.PacketParticleEffectToServer;
import fr.toss.common.packet.PacketSpellToServer;
import fr.toss.common.packet.Packets;
import fr.toss.common.player.spells.Spell;

public class Arena_6 extends Spell {

	public static int getUniqueID()
	{
		return 15;
	}
	
	@Override
	public int getLevel() 
	{
		return 16;
	}

	@Override
	public int getCost()
	{
		return 420;
	}
	
	@Override
	public String getName()
	{
		return I18n.format("spell.champion.arena");
	}

	
	@Override
	public String[] getDescription() 
	{
		String str[];
		
		str = new String[2];
		str[0] = "Weaken your target and";
		str[1] = "deal 4 (+ " + ChatColor.GOLD + (this.player.strength / 20.0f) + ChatColor.RESET + ") damages";
		
		return (str);
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
			packet = new PacketSpellToServer(getUniqueID(), e.getEntityId(), this.player.strength / 20.0f);
			Packets.network.sendToServer(packet);
			return (true);
		}
		else
			player.getPlayer().addChatComponentMessage(new ChatComponentText(ChatColor.RED + "No target available." + ChatColor.RESET));

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
		EntityFX particles;
		float a;
		float b;
		float c;
		int rayon;
		
		
		world = Minecraft.getMinecraft().theWorld;
		rayon = 12;
		for (int teta = 0; teta < 360; teta++)
		{
			for (float hauteur = 0; hauteur < 12; hauteur += 0.5f)
			{
				a = rayon * MathHelper.cos(teta);
				b = hauteur;
				c = rayon * MathHelper.sin(teta);
				
				world.spawnParticle("fireworksSpark", x + a - 1, y + b - 4, z + c - 1, 0, 0, 0);
				particles = new EntityFX_Colored(world, x + a, y + b - 2, z + c, 0, 0, 0, 2.0f, 1.5f, 1.5f, 0.0f);
				Minecraft.getMinecraft().effectRenderer.addEffect(particles);
			}
		}
	}
}