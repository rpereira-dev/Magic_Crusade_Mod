package fr.toss.common.player.spells.rogue;

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

public class Critic_1 extends Spell {

	public static int getUniqueID()
	{
		return 50;
	}
	
	@Override
	public int getLevel() 
	{
		return 1;
	}

	@Override
	public int getCost()
	{
		return (0);
	}
	
	@Override
	public String getName()
	{
		return I18n.format("spell.rogue.critic");
	}

	
	@Override
	public String[] getDescription() 
	{
		String str[];
		
		str = new String[2];
		str[0] = "Double your agility (and critics)";
		str[1] = "when you hit ennemis from behind";
		
		return (str);
	}
	
	@Override
	public boolean onUse()
	{
		return (false);
	}
	
	@Override
	public void sendEffectToServer(Object ... obj) {}
	
	public static void playEffect(double x, double y, double z) {}
	
}