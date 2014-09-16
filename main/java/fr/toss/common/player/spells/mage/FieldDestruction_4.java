package fr.toss.common.player.spells.mage;

import net.minecraft.block.Block;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityFallingBlock;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import fr.toss.common.command.ChatColor;
import fr.toss.common.entity.EntityFallingBlockM;
import fr.toss.common.packet.PacketParticleEffectToServer;
import fr.toss.common.packet.PacketSpellToServer;
import fr.toss.common.packet.Packets;
import fr.toss.common.player.spells.Spell;

public class FieldDestruction_4 extends Spell {

	public static int getUniqueID()
	{
		return 43;
	}
	
	@Override
	public int getLevel() 
	{
		return 4;
	}

	@Override
	public int getCost()
	{
		return 600;
	}
	
	@Override
	public String getName()
	{
		return I18n.format("spell.mage.field_destruction");
	}

	@Override
	public boolean onUse()
	{
		PacketSpellToServer packet;
		Entity e;
		
		e = this.getLookingEntity(24.0d);

		if (e != null)
		{
			packet = new PacketSpellToServer(getUniqueID(), e.getEntityId(), player.clarity / 10);
			Packets.network.sendToServer(packet);
			this.sendEffectToServer(e);
			return (true);
		}
		
		return (false);
	}
	
	@Override
	public String[] getDescription() 
	{
		String str[];
		
		str = new String[3];
		str[0] = "Move ground upside your";
		str[1] = "target and deal (+" + ChatColor.AQUA + (2 + player.clarity / 10) + ChatColor.RESET + ")";
		str[2] = "to it.";

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
		System.out.println("Land");
		EntityPlayer sender;
		World world;
		int X;
		int Y;
		int Z;
		
		sender = player.getPlayer();
		world = sender.worldObj;
		for (int i = 0; i < 8; i++)
		{
			for (int j = 0; j < 8; j++)
			{
				EntityFallingBlock e;
				Block block;
				
				X = (int) x - 4 + i;
				Z = (int) z - 4 + j;
				Y = getTopBlock(world, X, Z);
				block = world.getBlock(X, Y, Z);
				e = new EntityFallingBlockM(world, X, Y + 5, Z, block);
				world.spawnEntityInWorld(e);
			}
		}
	}

	private static int getTopBlock(World world, int x, int z)
	{
        int k;

        for (k = 63; !world.isAirBlock(x, k + 1, z); ++k)
        {
            ;
        }
        
        return k;
	}
}
