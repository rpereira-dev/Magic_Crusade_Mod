package fr.toss.common.player.spells.priest;

import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.EntityFX;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.world.World;
import fr.toss.common.command.ChatColor;
import fr.toss.common.items.ItemArmorM;
import fr.toss.common.packet.PacketParticleEffectToServer;
import fr.toss.common.packet.PacketSpellToServer;
import fr.toss.common.packet.Packets;
import fr.toss.common.player.spells.Spell;

public class Heal_2 extends Spell {

	public static int getUniqueID()
	{
		return 1;
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
		return I18n.format("spell.priest.heal");
	}

	@Override
	public String[] getDescription() 
	{
		String str[];
		
		str = new String[3];
		str[0] = "A spell that heal your";
		str[1] = "target with 4 hp";
		str[2] = "(+ " + ChatColor.AQUA + (this.player.clarity / 20.0f) + ChatColor.RESET + ")";

		return (str);
	}
	
	
	@Override
	public boolean onUse()
	{
		PacketSpellToServer packet;
		Entity e;
		Item item;
		float clarity;
		
		clarity = 0;
		e = this.getLookingEntity(30.0d);
		if (e == null)
			e = player.getPlayer();
		
		for (int i = 0; i < 4; i++)
		{
			if (player.getPlayer().inventory.armorInventory[i] != null)
			{
				item = player.getPlayer().inventory.armorInventory[i].getItem();
				if (item != null && item instanceof ItemArmorM)
					clarity += ((ItemArmorM)item).clarity;
			}
		}
		
		this.sendEffectToServer(e);
		packet = new PacketSpellToServer(getUniqueID(), e.getEntityId(), clarity);
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
		float c;
		world = Minecraft.getMinecraft().theWorld;
    	player = Minecraft.getMinecraft().thePlayer;
		for (int i = 0; i < 250; i++)
        {
			a = world.rand.nextFloat() / 20.0f;
			c = world.rand.nextFloat() / 20.0f;
			if (world.rand.nextInt(2) == 0)
				a = - a;
			if (world.rand.nextInt(2) == 0)
				c = - c;
    		world.spawnParticle("fireworksSpark", x, y + 1, z, a * 5, -0.25f, c * 5);
    		world.spawnParticle("fireworksSpark", x, y + 1, z, a * 5, 0.25f, c * 5);
    		world.spawnParticle("fireworksSpark", x, y + 1, z, a, -0.25f, c);
    		world.spawnParticle("fireworksSpark", x, y - 1, z, a, 0.25f, c);
        }
	}
}
