package fr.toss.common.player.spells.necromancer;

import java.util.List;

import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.EntityFX;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.util.ChatComponentText;
import net.minecraft.world.World;
import fr.toss.common.command.ChatColor;
import fr.toss.common.entity.EntitySummonZombie;
import fr.toss.common.packet.PacketParticleEffectToServer;
import fr.toss.common.packet.PacketSpellToServer;
import fr.toss.common.packet.Packets;
import fr.toss.common.player.spells.Spell;

public class Fireland_2 extends Spell {

	public static int getUniqueID()
	{
		return 21;
	}
	
	@Override
	public int getLevel() 
	{
		return 8;
	}

	@Override
	public int getCost()
	{
		return 500;
	}
	
	@Override
	public String getName()
	{
		return I18n.format("spell.necromancer.fireland");
	}

	@Override
	public boolean onUse()
	{
		List list;
		
		list = this.getEntitiesAround(24.0d, false);
		if (list.size() > 0)
		{
			this.sendEffectToServer();
			for (int i = 0; i < list.size(); i++)
			{
				if (!(list.get(i) instanceof EntityItem) && !(list.get(i) instanceof EntitySummonZombie))
				{
					if (((Entity)list.get(i)).getEntityId() != player.getPlayer().getEntityId())
					{
						PacketSpellToServer packet;
						packet = new PacketSpellToServer(getUniqueID(), ((Entity)list.get(i)).getEntityId());
						Packets.network.sendToServer(packet);
					}
				}
			}
			return (true);
		}
		else
			player.getPlayer().addChatComponentMessage(new ChatComponentText(ChatColor.RED + "No ennemis around." + ChatColor.RESET));
		return (false);
	}
	
	@Override
	public String[] getDescription() 
	{
		String str[];
		
		str = new String[3];
		str[0] = "Inflict 2 magic damages to";
		str[1] = "every mobs around and";
		str[2] = "put fire on them.";

		return (str);
	}
	
	@Override
	public void sendEffectToServer(Object ... obj)
	{
		PacketParticleEffectToServer packet;

		
		packet = new PacketParticleEffectToServer(getUniqueID(), player.getPlayer().posX, player.getPlayer().posY, player.getPlayer().posZ, player.getPlayer().dimension);
		Packets.network.sendToServer(packet);		
	}
	
	public static void playEffect(double x, double y, double z)
	{
		World world;
		EntityFX particles;
		float a;
		float b;
		float c;
		
		world = Minecraft.getMinecraft().theWorld;
		for (int i = 0; i < 50; i++)
        {
			for (int j = 0; j < 50; j++)
	        {
				world.spawnParticle("flame", x - 25 + i, y - 2, z - 25 + j, 0, 0.2f, 0);
				if (world.rand.nextInt(2) == 0)
					world.spawnParticle("smoke", x - 25 + i, y - 1, z - 25 + j, 0, 0.2f, 0);
	        }
        }
	}
}
