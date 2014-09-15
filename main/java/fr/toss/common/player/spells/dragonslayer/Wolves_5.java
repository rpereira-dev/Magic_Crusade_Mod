package fr.toss.common.player.spells.dragonslayer;

import java.util.List;

import net.minecraft.client.resources.I18n;
import net.minecraft.entity.passive.EntityWolf;
import net.minecraft.util.ChatComponentText;
import fr.toss.common.command.ChatColor;
import fr.toss.common.packet.PacketSpellToServer;
import fr.toss.common.packet.Packets;
import fr.toss.common.player.spells.Spell;

public class Wolves_5 extends Spell {

	public static int getUniqueID()
	{
		return 34;
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
	public String[] getDescription() 
	{
		String str[];
		
		str = new String[3];
		str[0] = "Summon a tamed wolf";
		str[1] = "You can have 4";
		str[2] = "wolves maximum";

		return (str);
	}
	
	@Override
	public String getName()
	{
		return I18n.format("spell.ranger.wolves");
	}

	@Override
	public boolean onUse()
	{
		List list;
		int nb;
		
		list = this.getEntitiesAround(10.0d, true);
		nb = 0;
		for (int i = 0; i < list.size(); i++)
		{
			if (list.get(i) instanceof EntityWolf)
				nb++;
		}
		
		if (nb < 4)
		{
			PacketSpellToServer packet;
			
			packet = new PacketSpellToServer(getUniqueID());
			Packets.network.sendToServer(packet);
			return (true);
		}
		else
			player.getPlayer().addChatComponentMessage(new ChatComponentText(ChatColor.RED + "You already have 4 wolves (at least)" + ChatColor.RESET));


		return (false);
	}
}
