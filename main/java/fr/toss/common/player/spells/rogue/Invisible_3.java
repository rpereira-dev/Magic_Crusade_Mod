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

public class Invisible_3 extends Spell {

	public static int getUniqueID()
	{
		return 52;
	}
	
	@Override
	public int getLevel() 
	{
		return 1;
	}

	@Override
	public int getCost()
	{
		return 50;
	}
	
	@Override
	public String getName()
	{
		return I18n.format("spell.rogue.invisible");
	}

	@Override
	public String[] getDescription() 
	{
		String str[];
		
		str = new String[2];
		str[0] = "You become invisible for";
		str[1] = "6 seconds.";

		return (str);
	}

	@Override
	public boolean onUse()
	{
		PacketSpellToServer packet;

		packet = new PacketSpellToServer(getUniqueID(), 0);
		Packets.network.sendToServer(packet);
		return (true);
	}
	
	@Override
	public void sendEffectToServer(Object ... obj) {}
	
	public static void playEffect(double x, double y, double z) {}
}
