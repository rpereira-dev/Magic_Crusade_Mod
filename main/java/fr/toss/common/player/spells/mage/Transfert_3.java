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

public class Transfert_3 extends Spell {

	public static int getUniqueID()
	{
		return 42;
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
		return I18n.format("spell.mage.transfert");
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
			packet = new PacketSpellToServer(getUniqueID(), e.getEntityId());
			Packets.network.sendToServer(packet);
			
			player.getPlayer().setLocationAndAngles(e.posX, e.posY, e.posZ, e.rotationYaw, e.rotationPitch);

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
		
		str = new String[2];
		str[0] = "Swap your position with";
		str[1] = "your target's one";

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
	}
}
