package fr.toss.common.items;

import java.util.List;

import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.EntityFX;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;
import cpw.mods.fml.common.network.NetworkRegistry.TargetPoint;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fr.toss.client.render.particles.EntityFX_Colored;
import fr.toss.common.command.ChatColor;
import fr.toss.common.packet.PacketParticleEffectToClient;
import fr.toss.common.packet.PacketParticleEffectToServer;
import fr.toss.common.packet.Packets;

public class ItemSwordEthernium extends ItemSwordM {

	public ItemSwordEthernium(ToolMaterial material)
	{
		super(material);
	}
	
	 /**
     * allows items to add custom lines of information to the mouseover description
     */
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack item, EntityPlayer player, List list, boolean bool)
    {
    	list.add(ChatColor.LIGHT_PURPLE + "This weapon is enchanted..." + ChatColor.RESET);
    	super.addInformation(item, player, list, bool);
    }
    
    
	@Override
    public boolean hitEntity(ItemStack is, EntityLivingBase entity, EntityLivingBase player)
    {
		super.hitEntity(is, entity, player);
		
    	if (entity != null && entity instanceof EntityLivingBase)
    	{
    		entity.attackEntityFrom(DamageSource.magic, 2.0f);
    		PacketParticleEffectToServer effect;
    		
			TargetPoint point;
			
			point = new TargetPoint(entity.dimension, entity.posX, entity.posY, entity.posZ, 40.0D);
			Packets.network.sendToAllAround(new PacketParticleEffectToClient(new PacketParticleEffectToServer(100, entity.posX, entity.posY, entity.posZ, entity.dimension)), point);
    	}
		return (true);
	}
	
    @SideOnly(Side.CLIENT)
	public static void playEffect(double x, double y, double z)
	{
		World world;
		EntityFX particles;
		float a;
		float b;
		float c;
		int x1;
		int z1;
		
		x1 = 5;
		z1 = 5;
		world = Minecraft.getMinecraft().theWorld;
		for (int i = 0; i < 100; i++)
        {
    		a = (float) (Math.random() - 0.5);
    		if(Math.random() * 2 + 1 == 0)
    			a = -a;
    		b = (float) (Math.random() * 2 - 0.5);
    		if(Math.random() * 2 + 1 == 0)
    			b=-b;
    		c = (float) (Math.random() - 0.5);
    		if(Math.random() * 2 + 1 == 0)
    			c=-c;
    		
    		world.spawnParticle("fireworksSpark", x, y, z, -a, -b / 2.0f, -c);
    		particles = new EntityFX_Colored(world, x, y, z, a, b / 2.0f, c, 1.0f, 5.0f, 0.0f, 5.0f);
    		Minecraft.getMinecraft().effectRenderer.addEffect(particles);
        }
	}
}
