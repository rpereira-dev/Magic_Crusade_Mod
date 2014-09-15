package fr.toss.common.player.spells.priest;

import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.EntityFX;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import fr.toss.common.command.ChatColor;
import fr.toss.common.packet.PacketParticleEffectToServer;
import fr.toss.common.packet.PacketSpellToServer;
import fr.toss.common.packet.Packets;
import fr.toss.common.player.spells.Spell;

public class HolyExplosion_7 extends Spell {

	public static int getUniqueID()
	{
		return 6;
	}
	
	@Override
	public int getLevel() 
	{
		return 1;
	}

	@Override
	public int getCost()
	{
		return 680;
	}
	
	@Override
	public String getName()
	{
		return I18n.format("spell.priest.holy_explosion");
	}

	
	@Override
	public String[] getDescription() 
	{
		String str[];
		
		str = new String[3];
		str[0] = "A spell that deals 6 (+" + ChatColor.AQUA + (this.player.clarity / 20.0f) + ChatColor.RESET + ")";
		str[1] = "damages to your target";
		str[2] = "and weaken it for 10 seconds";
		
		return (str);
	}
	
	@Override
	public boolean onUse()
	{
		PacketSpellToServer packet;
		Entity e;
		
		e = this.getLookingEntity(30.0d);
		if (e == null)
		{
			this.player.getPlayer().addChatComponentMessage(new ChatComponentText(ChatColor.RED + "You have no target" + ChatColor.RESET));
			return (false);
		}
		this.sendEffectToServer(e);
		packet = new PacketSpellToServer(getUniqueID(), e.getEntityId(), this.player.clarity);
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
		a = 0;
		for (int i = 0; i < 200; i++)
		{
			a = MathHelper.cos(i) / 4.0f;
			b = (float) Math.tan(i);
			c = MathHelper.sin(i) / 2.0f;
			
    		world.spawnParticle("fireworksSpark", x, y, z, 0, b, c);
    		world.spawnParticle("fireworksSpark", x, y, z, a, b, 0);

        }
	}
}
