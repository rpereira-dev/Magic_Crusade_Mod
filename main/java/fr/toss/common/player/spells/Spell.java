package fr.toss.common.player.spells;

import java.util.List;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.Vec3;
import fr.toss.common.Main;
import fr.toss.common.player.ClientPlayerBaseMagic;

public abstract class Spell {
	
	public static ClientPlayerBaseMagic player;
	public String texture_path;
	
	public void use()
	{
		System.out.println("Using: " + this.getName());
		if (player.hasEnoughEnergy(this.getCost()))
		{
			System.out.println("Player has enough enery");

			if (this.onUse())
				player.decreaseEnergy(this.getCost());
		}
		else
		{
			System.out.println(player.energy);
			System.out.println(Main.getPlayerClient().energy);

			System.out.println("Player doesn't have enough enery");
		}

	}
	
	public boolean onUse()
	{
		return false;
	}

	public void sendEffectToServer(Object ... obj) {}

	public int getLevel() 
	{
		return 0;
	}
	
	public int getCost()
	{
		return 0;
	}

	public String getName()
	{
		return "Null";
	}
	
	
	public List getEntitiesAround(double range, boolean includePlayer)
	{
		EntityPlayer thePlayer = player.getPlayer();
		List list;
		Entity entity;
		
		if (includePlayer)
			list = thePlayer.worldObj.getEntitiesWithinAABBExcludingEntity(thePlayer, thePlayer.boundingBox.expand(range, range, range));
		else
			list = thePlayer.worldObj.getEntitiesWithinAABB(Entity.class, thePlayer.boundingBox.expand(range, range, range));
		return (list);
	}

	
	public Entity getLookingEntity(double range)
	{
		EntityPlayer thePlayer = player.getPlayer();
		List list = thePlayer.worldObj.getEntitiesWithinAABBExcludingEntity(thePlayer, thePlayer.boundingBox.expand(range, range, range));
		Entity entity;
		
		if (list != null)
		{
			for (int i = 0; i < list.size(); i++)
			{
				entity = (Entity)list.get(i);

		                if (!entity.isDead)
		                {
		             	   if(entity instanceof EntityLivingBase)
		             	   {
		             		   Vec3 vec3d;
		             		   Vec3 vec3d1;
		             		   double d;
		             		   double d1;
		             		   double a;
		             		   double b;
		             		   double c;
		             		   
		             		   vec3d = thePlayer.getLook(1.0F).normalize();
		             		   vec3d1 = Vec3.createVectorHelper(entity.posX - thePlayer.posX, (entity.boundingBox.minY + (double)(entity.height / 2.0F)) - (thePlayer.posY + (double)thePlayer.getEyeHeight()), entity.posZ - thePlayer.posZ);
		             		   d = vec3d1.lengthVector();
		             		   vec3d1 = vec3d1.normalize();
		             		   d1 = vec3d.dotProduct(vec3d1);
		             	       if (d1 > 1.0D - 0.025000000000000001D / d)
		             	       {
		             	    	   System.out.println("Looking at " + entity);
		             	    	   return (entity);
		             	       }
		             	   }
	             	   
	                	}     
			}
		}
		return (null);
	}

	public String[] getDescription() 
	{
		return null;
	}
}
