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

public class ArcanaPillow_5 extends Spell {

	public static int getUniqueID()
	{
		return 44;
	}
	
	@Override
	public int getLevel() 
	{
		return 10;
	}

	@Override
	public int getCost()
	{
		return 420;
	}
	
	@Override
	public String getName()
	{
		return I18n.format("spell.mage.arcane_pillow");
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
			packet = new PacketSpellToServer(getUniqueID(), e.getEntityId(), this.player.clarity / 20);
			Packets.network.sendToServer(packet);
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
		
		str = new String[3];
		str[0] = "Inflict 6 (+ " + ChatColor.AQUA + (this.player.clarity / 20.0f) + ChatColor.RESET + ") magic";
		str[1] = "damages and increase your";
		str[2] = "movement speed.";

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
		EntityFX particles;
		float a;
		float b;
		float c;
		
		world = Minecraft.getMinecraft().theWorld;
		for (int pi = 0; pi < 360; pi += 4)
        {
			a = world.rand.nextFloat();
			b = (float) Math.tan(pi) * 4;
			c = world.rand.nextFloat();

			if (world.rand.nextInt(2) == 0)
				a = -a;
			if (world.rand.nextInt(2) == 0)
				c = -c;
			
    		world.spawnParticle("fireworksSpark", x, y, z, a, b, c);
    		particles = new EntityFX_Colored(world, x, y, z, -a, b, -c, 2.0f, 5.0f, 0.0f, 1.5f);
    		Minecraft.getMinecraft().effectRenderer.addEffect(particles);
        }
	}
}
