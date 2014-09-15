package fr.toss.common.player.spells.rogue;

import net.minecraft.client.resources.I18n;
import net.minecraft.util.ChatComponentText;
import fr.toss.common.command.ChatColor;
import fr.toss.common.packet.PacketSpellToServer;
import fr.toss.common.packet.Packets;
import fr.toss.common.player.spells.Spell;

public class FeatherFalling_6 extends Spell {

	public static int getUniqueID()
	{
		return 55;
	}
	
	@Override
	public int getLevel() 
	{
		return 14;
	}

	@Override
	public int getCost()
	{
		return 50;
	}
	
	@Override
	public String getName()
	{
		return I18n.format("spell.rogue.feather_falling");
	}

	@Override
	public String[] getDescription() 
	{
		String str[];
		
		str = new String[3];
		str[0] = "You enchant your boots";
		str[1] = "with a high feather";
		str[2] = "falling enchantment level";

		return (str);
	}

	@Override
	public boolean onUse()
	{
		PacketSpellToServer packet;

		if (player.getPlayer().inventory.armorInventory[0] != null)
		{
			packet = new PacketSpellToServer(getUniqueID(), 0);
			Packets.network.sendToServer(packet);
			return (true);
		}
		else
			player.getPlayer().addChatComponentMessage(new ChatComponentText(ChatColor.RED + "You have no boots equipped." + ChatColor.RESET));
		
		return (false);
	}
	
	@Override
	public void sendEffectToServer(Object ... obj) {}
	
	public static void playEffect(double x, double y, double z) {}
}
