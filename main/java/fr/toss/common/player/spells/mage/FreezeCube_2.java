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

public class FreezeCube_2 extends Spell {

	public static int getUniqueID()
	{
		return 41;
	}
	
	@Override
	public int getLevel() 
	{
		return 1;
	}

	@Override
	public int getCost()
	{
		return 320;
	}
	
	@Override
	public String getName()
	{
		return I18n.format("spell.mage.freeze_cube");
	}

	@Override
	public boolean onUse()
	{
		PacketSpellToServer packet;
		Entity e;
		
		e = this.getLookingEntity(24.0d);
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
		str[1] = "damages and slow your";
		str[2] = "target for 5 seconds.";

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

		world = player.getPlayer().worldObj;
		for (float i = 0; i < 8; i += 0.25f)
		{
			for (float j = 0; j < 8; j += 0.25f)
			{
				world.spawnParticle("snowballpoof", x + i - 4, y, z + j - 4, 0, 0, 0);
	    		world.spawnParticle("snowballpoof", x + i - 4, y + 8, z + j - 4, 0, 0, 0);
	    		
				world.spawnParticle("snowballpoof", x + i - 4, y + j, z - 4, 0, 0, 0);
	    		world.spawnParticle("snowballpoof", x + i - 4, y + j, z + 4, 0, 0, 0);
	    		
				world.spawnParticle("snowballpoof", x - 4, y + j, z - 4 + i, 0, 0, 0);
	    		world.spawnParticle("snowballpoof", x + 4, y + j, z - 4 + i, 0, 0, 0);
			}
		}
	}
}
