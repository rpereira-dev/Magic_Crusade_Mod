package fr.toss.common.player.spells.dragonslayer;

import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemBow;
import net.minecraft.util.ChatComponentText;
import fr.toss.common.command.ChatColor;
import fr.toss.common.packet.PacketSpellToServer;
import fr.toss.common.packet.Packets;
import fr.toss.common.player.spells.Spell;

public class SlowShot_6 extends Spell {

	public static int getUniqueID()
	{
		return 35;
	}
	
	@Override
	public int getLevel() 
	{
		return 14;
	}

	@Override
	public int getCost()
	{
		return 40;
	}
	
	@Override
	public String[] getDescription() 
	{
		String str[];
		
		str = new String[3];
		str[0] = "Shot a frozen arrow";
		str[1] = "instantly and slow";
		str[2] = "your ennemi";

		return (str);
	}
	
	@Override
	public String getName()
	{
		return I18n.format("spell.ranger.frozen_shot");
	}

	@Override
	public boolean onUse()
	{
		EntityPlayer p;
		
		p = this.player.getPlayer();
		if (p.getCurrentEquippedItem() != null)
		{
			if (p.getCurrentEquippedItem().getItem() instanceof ItemBow)
			{
				PacketSpellToServer packet;
				
				packet = new PacketSpellToServer(getUniqueID());
				Packets.network.sendToServer(packet);
			}
			else
				player.getPlayer().addChatComponentMessage(new ChatComponentText(ChatColor.RED + "You must equip a bow for this." + ChatColor.RESET));
		}
		else
			player.getPlayer().addChatComponentMessage(new ChatComponentText(ChatColor.RED + "You must equip a bow for this." + ChatColor.RESET));
		
		return (true);
	}
}
