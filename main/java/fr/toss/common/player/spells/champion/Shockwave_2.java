package fr.toss.common.player.spells.champion;

import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.EntityFX;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import fr.toss.client.render.particles.EntityFX_Colored;
import fr.toss.common.packet.PacketParticleEffectToServer;
import fr.toss.common.packet.PacketSpellToServer;
import fr.toss.common.packet.Packets;
import fr.toss.common.player.spells.Spell;

public class Shockwave_2 extends Spell {

	public static int getUniqueID()
	{
		return 11;
	}
	
	@Override
	public int getLevel() 
	{
		return 4;
	}

	@Override
	public int getCost()
	{
		return 200;
	}
	
	@Override
	public String getName()
	{
		return I18n.format("spell.champion.shockwave");
	}
	
	@Override
	public String[] getDescription() 
	{
		String str[];
		
		str = new String[4];
		str[0] = "It creates an explosion";
		str[1] = "around the player and";
		str[2] = "deal damages to mobs";
		str[3] = "around";


		return (str);
	}
	
	@Override
	public boolean onUse()
	{
		PacketSpellToServer packet;
		
		packet = new PacketSpellToServer(getUniqueID());
		Packets.network.sendToServer(packet);
			
		this.sendEffectToServer();
		return (true);
	}
	
	@Override
	public void sendEffectToServer(Object ... obj)
	{
		PacketParticleEffectToServer packet;
		
		packet = new PacketParticleEffectToServer(getUniqueID(), player.getPlayer().posX, player.getPlayer().posY - 1, player.getPlayer().posZ, player.getPlayer().dimension);
		Packets.network.sendToServer(packet);		
	}
	
	public static void playEffect(double x, double y, double z)
	{
		World world;
		EntityPlayer player;
		EntityFX particles;
		float a;
		float c;
		System.out.println("Shockwaveee");
		world = Minecraft.getMinecraft().theWorld;
    	player = Minecraft.getMinecraft().thePlayer;
		for (int i = 0; i < 250; i++)
        {
			a = world.rand.nextFloat();
			c = world.rand.nextFloat();
			
			if (world.rand.nextInt(2) == 0)
				a = -a;
			if (world.rand.nextInt(2) == 0)
				c = -c;
			
    		particles = new EntityFX_Colored(world, x, y, z, a, 0, c, 2.0f, 0, 2.5f, 5.0f);
    		Minecraft.getMinecraft().effectRenderer.addEffect(particles);
        }
	}
}
