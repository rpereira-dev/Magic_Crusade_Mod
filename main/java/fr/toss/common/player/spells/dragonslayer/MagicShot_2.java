package fr.toss.common.player.spells.dragonslayer;

import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemBow;
import net.minecraft.util.ChatComponentText;
import fr.toss.common.command.ChatColor;
import fr.toss.common.packet.PacketSpellToServer;
import fr.toss.common.packet.Packets;
import fr.toss.common.player.spells.Spell;

public class MagicShot_2 extends Spell {

	public static int getUniqueID()
	{
		return 31;
	}
	
	@Override
	public int getLevel() 
	{
		return 4;
	}

	@Override
	public int getCost()
	{
		return 30;
	}
	
	@Override
	public String[] getDescription() 
	{
		String str[];
		
		str = new String[3];
		str[0] = "Shot a magic arrow which";
		str[1] = "will inflicts critical";
		str[2] = "and magical damages";

		return (str);
	}
	
	@Override
	public String getName()
	{
		return I18n.format("spell.ranger.magic_shot");
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
