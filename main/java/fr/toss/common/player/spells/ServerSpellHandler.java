package fr.toss.common.player.spells;

import java.util.List;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.passive.EntityWolf;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.entity.projectile.EntityLargeFireball;
import net.minecraft.entity.projectile.EntitySmallFireball;
import net.minecraft.entity.projectile.EntityWitherSkull;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemBow;
import net.minecraft.item.ItemStack;
import net.minecraft.pathfinding.PathEntity;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;
import fr.toss.common.entity.EntitySummonZombie;
import fr.toss.common.packet.PacketSpellToServer;

public class ServerSpellHandler {
	
	/** Grab du champion */
	public static void handle_grab(PacketSpellToServer message, World world, EntityPlayerMP sender)
	{
		Entity e;
		
		e = world.getEntityByID(message.data);
		if (e != null)
		{
			e.motionX = sender.getLookVec().xCoord * -2.0f;
			e.motionY += 0.75f;
			e.motionZ = sender.getLookVec().zCoord * -2.0f;
		}
	}
	
	/** Effet du soin du Mage */
	public static void handle_heal(PacketSpellToServer message, World world)
	{
		Entity e;
		
		e = world.getEntityByID(message.data);
		if (e instanceof EntityLivingBase)
		{
			((EntityLivingBase)e).heal(4.0f + message.data2 / 20); //20 clarity pour 1 coeur en plus
		}
	}
	
	/** Effet du soin du Mage */
	public static void handle_heal_zone(PacketSpellToServer message, World world)
	{
		Entity e;
		
		e = world.getEntityByID(message.data);
		if (e instanceof EntityLivingBase && !(e instanceof EntityMob))
		{
			((EntityLivingBase)e).heal(3.0f + message.data2 / 30); //30 clarity pour 1 coeur en plus
		}
	}
	
	/** Effet de Purification du Mage */
	public static void handle_purification(PacketSpellToServer message, World world)
	{
		Entity e;
		
		e = world.getEntityByID(message.data);
		if (e != null)
		{
			if (e.isBurning())
				e.extinguish();
			if (e instanceof EntityLivingBase)
			{
				if (((EntityLivingBase) e).isPotionActive(Potion.blindness))
					((EntityLivingBase) e).removePotionEffect(Potion.blindness.id);
				if (((EntityLivingBase) e).isPotionActive(Potion.poison))
					((EntityLivingBase) e).removePotionEffect(Potion.poison.id);
				if (((EntityLivingBase) e).isPotionActive(Potion.digSlowdown))
					((EntityLivingBase) e).removePotionEffect(Potion.digSlowdown.id);
				if (((EntityLivingBase) e).isPotionActive(Potion.confusion))
					((EntityLivingBase) e).removePotionEffect(Potion.confusion.id);
				if (((EntityLivingBase) e).isPotionActive(Potion.hunger))
					((EntityLivingBase) e).removePotionEffect(Potion.hunger.id);
				if (((EntityLivingBase) e).isPotionActive(Potion.blindness))
					((EntityLivingBase) e).removePotionEffect(Potion.blindness.id);
				if (((EntityLivingBase) e).isPotionActive(Potion.moveSlowdown))
					((EntityLivingBase) e).removePotionEffect(Potion.moveSlowdown.id);
				if (((EntityLivingBase) e).isPotionActive(Potion.wither))
					((EntityLivingBase) e).removePotionEffect(Potion.wither.id);
				if (((EntityLivingBase) e).isPotionActive(Potion.weakness))
					((EntityLivingBase) e).removePotionEffect(Potion.weakness.id);
				((EntityLivingBase) e).addPotionEffect(new PotionEffect(Potion.moveSpeed.id, 40, 2));
			}		
		}
	}

	/** Effet de Buff du Mage */
	public static void handle_buff(PacketSpellToServer message, World world)
	{
		Entity e;
		
		e = world.getEntityByID(message.data);
		if (e instanceof EntityLivingBase)
		{
			((EntityLivingBase)e).addPotionEffect(new PotionEffect(Potion.moveSpeed.id, 200, 1));
			((EntityLivingBase)e).addPotionEffect(new PotionEffect(Potion.damageBoost.id, 200, 1));
			((EntityLivingBase)e).addPotionEffect(new PotionEffect(Potion.jump.id, 200, 1));
			((EntityLivingBase)e).addPotionEffect(new PotionEffect(Potion.resistance.id, 200, 0));
			((EntityLivingBase)e).addPotionEffect(new PotionEffect(Potion.fireResistance.id, 200, 0));
		}
	}
	
	/** Effet de l'invisibilité du Mage */
	public static void handle_invincible(PacketSpellToServer message, World world)
	{
		Entity e;
		
		e = world.getEntityByID(message.data);
		if (e instanceof EntityLivingBase)
		{
			((EntityLivingBase)e).extinguish();
			((EntityLivingBase)e).addPotionEffect(new PotionEffect(Potion.resistance.id, 60, 99));
			((EntityLivingBase)e).addPotionEffect(new PotionEffect(Potion.fireResistance.id, 60, 99));
			((EntityLivingBase)e).addPotionEffect(new PotionEffect(Potion.regeneration.id, 60, 99));
		}
	}

	/** Drain du necromancer */
	public static void handle_drain(PacketSpellToServer message, World world, EntityPlayerMP sender)
	{
		Entity e;
		
		e = world.getEntityByID(message.data);
		if (e instanceof EntityLivingBase)
		{
			((EntityLivingBase)e).attackEntityFrom(DamageSource.causePlayerDamage(sender), 4.0f + (message.data2 / 20.0f));
			sender.heal(2.0f + (message.data2 / 40));
		}
	}

	public static void handle_holyshield(PacketSpellToServer message, World world)
	{
		Entity e;
		
		e = world.getEntityByID(message.data);
		if (e instanceof EntityLivingBase)
		{
			((EntityLivingBase)e).extinguish();
			((EntityLivingBase)e).addPotionEffect(new PotionEffect(Potion.regeneration.id, 120, 1));
			((EntityLivingBase)e).addPotionEffect(new PotionEffect(Potion.field_76444_x.id, 120, 1));
		}		
	}

	public static void handle_holyexplosion(PacketSpellToServer message, World world, EntityPlayerMP sender)
	{
		Entity e;
		
		e = world.getEntityByID(message.data);
		if (e instanceof EntityLivingBase)
		{
			((EntityLivingBase)e).attackEntityFrom(DamageSource.causePlayerDamage(sender), 6.0f + message.data2 / 20.0f);
			((EntityLivingBase)e).addPotionEffect(new PotionEffect(Potion.weakness.id, 200, 1));
		}		
	}
	
	
	public static void handle_shockwave(PacketSpellToServer message, World world, EntityPlayerMP sender)
	{
		world.createExplosion(sender, sender.posX + 3, sender.posY, sender.posZ + 3, 1.0f, true);
		world.createExplosion(sender, sender.posX + 3, sender.posY, sender.posZ - 3, 1.0f, true);
		world.createExplosion(sender, sender.posX - 3, sender.posY, sender.posZ + 3, 1.0f, true);
		world.createExplosion(sender, sender.posX - 3, sender.posY, sender.posZ - 3, 1.0f, true);
		world.createExplosion(sender, sender.posX + 3, sender.posY, sender.posZ, 1.0f, true);
		world.createExplosion(sender, sender.posX - 3, sender.posY, sender.posZ, 1.0f, true);
		world.createExplosion(sender, sender.posX, sender.posY, sender.posZ + 3, 1.0f, true);
		world.createExplosion(sender, sender.posX, sender.posY, sender.posZ - 3, 1.0f, true);
	}

	/** Poison shot du Dragon slayer */
	public static void handle_shotpoison(World world, EntityPlayerMP sender)
	{
        EntityArrow entityarrow;
        
        entityarrow = new EntityArrow(world, sender, 2.0F)
        {
        	@Override
            public void onUpdate()
            {
            	super.onUpdate();
            	
            	List list;
            	
            	list = this.worldObj.getEntitiesWithinAABBExcludingEntity(this, this.boundingBox.expand(0.2f, 0.2f, 0.2f));
            	for (int i = 0; i < list.size(); i++)
            	{
            		if (list.get(i) instanceof EntityLivingBase)
            			((EntityLivingBase)list.get(i)).addPotionEffect(new PotionEffect(Potion.poison.id, 100, 2));
            	}
            }
        };
        world.spawnEntityInWorld(entityarrow);
	}
	
	/** Poison shot du Dragon slayer */
	public static void handle_frozenshot(World world, EntityPlayerMP sender)
	{
        EntityArrow entityarrow;
        
        entityarrow = new EntityArrow(world, sender, 2.0F)
        {
        	@Override
            public void onUpdate()
            {
            	super.onUpdate();
            	
            	List list;
            	
            	list = this.worldObj.getEntitiesWithinAABBExcludingEntity(this, this.boundingBox.expand(0.2f, 0.2f, 0.2f));
            	for (int i = 0; i < list.size(); i++)
            	{
            		if (list.get(i) instanceof EntityLivingBase)
            			((EntityLivingBase)list.get(i)).addPotionEffect(new PotionEffect(Potion.moveSlowdown.id, 100, 2));
            	}
            }
        };
        world.spawnEntityInWorld(entityarrow);
	}
	
	/** Poison shot du Dragon slayer */
	public static void handle_magicshot(World world, EntityPlayerMP sender)
	{
        EntityArrow entityarrow;
        
        entityarrow = new EntityArrow(world, sender, 5.0F)
        {
        	@Override
            public void onUpdate()
            {
            	super.onUpdate();
            	
            	List list;
            	
            	list = this.worldObj.getEntitiesWithinAABBExcludingEntity(this, this.boundingBox.expand(0.2f, 0.2f, 0.2f));
            	for (int i = 0; i < list.size(); i++)
            	{
            		if (list.get(i) instanceof EntityLivingBase)
            			((EntityLivingBase)list.get(i)).addPotionEffect(new PotionEffect(Potion.harm.id, 20, 0));
            	}
            }
        };
        entityarrow.setIsCritical(true);
        world.spawnEntityInWorld(entityarrow);
	}
	
	/** Poison shot du Dragon slayer */
	public static void handle_explodeshot(World world, EntityPlayerMP sender)
	{
        EntityArrow entityarrow;
        
        entityarrow = new EntityArrow(world, sender, 2.0F)
        {
        	@Override
            public void onUpdate()
            {
            	super.onUpdate();
            	
            	List list;
            	
            	list = this.worldObj.getEntitiesWithinAABBExcludingEntity(this, this.boundingBox.expand(0.2f, 0.2f, 0.2f));
            	for (int i = 0; i < list.size(); i++)
            	{
            		if (list.get(i) instanceof EntityLivingBase)
            			explode((Entity)list.get(i));
            	}
            }
        	
        	public void explode(Entity e)
        	{
    			this.worldObj.createExplosion(this, e.posX, e.posY, e.posZ, 2.0f, true);
        	}
        };
        entityarrow.setIsCritical(true);
        world.spawnEntityInWorld(entityarrow);
	}

	/** Enchantement de l'arc Dragon Slayer */
	public static void handle_refinement(World world, EntityPlayerMP sender)
	{
		ItemStack item;
		
		if (sender.getCurrentEquippedItem() != null)
		{
			item = sender.getCurrentEquippedItem();
			if (item.getItem() instanceof ItemBow && !item.isItemEnchanted())
			{
				item.addEnchantment(Enchantment.power, 2);
				item.addEnchantment(Enchantment.flame, 2);
				item.addEnchantment(Enchantment.smite, 2);
				item.addEnchantment(Enchantment.unbreaking, 5);
				item.addEnchantment(Enchantment.infinity, 5);
				item.setStackDisplayName("Refined " + sender.getCommandSenderName() + "'s Bow");
			}
		}
	}

	/** Wolves summons from Dragon Slayer */
	public static void handle_wolfsummon(World world, EntityPlayerMP sender)
	{
		EntityWolf wolf;
		int x;
		int z;
		
		x = sender.getLookVec().xCoord > 0 ? 1 : -1;
		z = sender.getLookVec().zCoord > 0 ? 1 : -1;

		wolf = new EntityWolf(world);
		wolf.setTamed(true);
		wolf.setPathToEntity((PathEntity)null);
		wolf.setAttackTarget((EntityLivingBase)null);
		wolf.setHealth(20.0F);
		wolf.func_152115_b(sender.getUniqueID().toString());
		wolf.worldObj.setEntityState(wolf, (byte)7);
		
		x += sender.posX;
		z += sender.posZ;
		wolf.setLocationAndAngles(x, world.getTopSolidOrLiquidBlock(x, z), z, (float) -sender.getLookVec().xCoord, (float) -sender.getLookVec().zCoord);
		
		world.spawnEntityInWorld(wolf);
	}
	
	/** Zombie summons from Necromancer */ 
	public static void handle_zombiesummon(World world, EntityPlayerMP sender, float clarity)
	{
		EntitySummonZombie e[];
		
		e = new EntitySummonZombie[4];
		for (int i = 0; i < 4; i++)
			e[i] = new EntitySummonZombie(sender.worldObj, sender, clarity);
		e[0].setPosition(sender.posX + 3, sender.worldObj.getTopSolidOrLiquidBlock((int) sender.posX + 3, (int) sender.posZ + 3), sender.posZ + 3);
		e[1].setPosition(sender.posX + 3, sender.worldObj.getTopSolidOrLiquidBlock((int) sender.posX + 3, (int) sender.posZ - 3), sender.posZ - 3);
		e[2].setPosition(sender.posX - 3, sender.worldObj.getTopSolidOrLiquidBlock((int) sender.posX - 3, (int) sender.posZ - 3), sender.posZ - 3);
		e[3].setPosition(sender.posX - 3, sender.worldObj.getTopSolidOrLiquidBlock((int) sender.posX - 3, (int) sender.posZ + 3), sender.posZ + 3);
		for (int i = 0; i < 4; i++)
			sender.worldObj.spawnEntityInWorld(e[i]);
	}
	
	

	/** Fireland du necromancer */
	public static void handle_fireland(PacketSpellToServer message, World world, EntityPlayerMP sender)
	{
		Entity e;
		
		e = world.getEntityByID(message.data);
		if (e != null)
		{
			world.setBlock((int) e.posX, (int) e.posY, (int)e.posZ, Blocks.fire);
			if (e instanceof EntityLivingBase)
				((EntityLivingBase)e).attackEntityFrom(DamageSource.magic, 2);
		}
	}
	
	/** Fireland du necromancer */
	public static void handle_witherskull(PacketSpellToServer message, World world, EntityPlayerMP sender)
	{
		for (int i = 0; i < 3; i++)
		{
	        EntityWitherSkull wither_skull;
	        
	        wither_skull = new EntityWitherSkull(world, sender, sender.getLookVec().xCoord * 2.0f, sender.getLookVec().yCoord * 2.0f, sender.getLookVec().zCoord * 2.0f);
	        wither_skull.setLocationAndAngles(sender.posX + sender.getLookVec().xCoord, sender.posY + 1, sender.posZ + sender.getLookVec().zCoord, (float) sender.getLookVec().xCoord, (float) sender.getLookVec().zCoord);
	        wither_skull.setInvulnerable(false);
	        world.spawnEntityInWorld(wither_skull);
		}
	}

	/** Sort corruption du Necromancer */
	public static void handle_corruption(World world, EntityPlayerMP sender, int entity_id, float clarity)
	{
		EntityLivingBase e;
		
		e = (EntityLivingBase) world.getEntityByID(entity_id);
		e.attackEntityFrom(DamageSource.causePlayerDamage(sender), 1.0f);
		e.addPotionEffect(new PotionEffect(Potion.wither.id, (int) (80 + clarity / 26 * 20), 1));
	}
	
	/** Fireland du necromancer */
	public static void handle_necromancy(PacketSpellToServer message, World world, EntityPlayerMP sender)
	{
		Entity e;
		
		e = world.getEntityByID(message.data);
		if (e != null)
		{
			if (e instanceof EntityLivingBase)
			{
				((EntityLivingBase)e).addPotionEffect(new PotionEffect(Potion.moveSlowdown.id, 140, 0));
				((EntityLivingBase)e).addPotionEffect(new PotionEffect(Potion.poison.id, 70, 0));
			}
		}
	}

	public static void handle_arena(PacketSpellToServer message, World world, EntityPlayerMP sender)
	{
		Entity e;
		
		e = world.getEntityByID(message.data);
		if (e != null)
		{
			if (e instanceof EntityLivingBase)
			{
				e.attackEntityFrom(DamageSource.causePlayerDamage(sender), 4 + message.data2);
				((EntityLivingBase) e).addPotionEffect(new PotionEffect(Potion.weakness.id, 100, 0));
			}
		}
	}

	public static void handle_conefeu(PacketSpellToServer message, World world, EntityPlayerMP sender)
	{
		Entity e;
		
		e = world.getEntityByID(message.data);
		if (e != null)
		{
			if (e instanceof EntityLivingBase)
			{
				e.attackEntityFrom(DamageSource.causePlayerDamage(sender), 4 + message.data2);
				if (world.rand.nextInt(3) == 0)
					e.setFire(3);
			}
		}
	}
	
	public static void handle_frozencube(PacketSpellToServer message, World world, EntityPlayerMP sender)
	{
		Entity e;
		
		e = world.getEntityByID(message.data);
		if (e != null)
		{
			if (e instanceof EntityLivingBase)
			{
				e.attackEntityFrom(DamageSource.causePlayerDamage(sender), 3 + message.data2);
				((EntityLivingBase) e).addPotionEffect(new PotionEffect(Potion.moveSlowdown.id, 120, 1));
			}
		}
	}

	public static void handle_teleport(PacketSpellToServer message, World world, EntityPlayerMP sender)
	{
		Entity e;
		double posX;
		double posY;
		double posZ;
		float rotationYaw;
		float rotationPitch;
		e = world.getEntityByID(message.data);
		if (e != null)
		{
			posX = e.posX;
			posY = e.posY;
			posZ = e.posZ;
			rotationYaw = e.rotationYaw;
			rotationPitch = e.rotationPitch;
					
			e.setLocationAndAngles(sender.posX, sender.posY, sender.posZ, sender.rotationYaw, sender.rotationPitch);
			e.setLocationAndAngles(e.posX, e.posY, e.posZ, e.rotationYaw, e.rotationPitch);
		}
	}

	public static void handle_field_destruction(PacketSpellToServer message, World world, EntityPlayerMP sender)
	{
		List entities;
		Entity e;
		
		e = world.getEntityByID(message.data);
		entities = e.worldObj.getEntitiesWithinAABBExcludingEntity(e, e.boundingBox.expand(5, 3, 5));
		for (Object obj : entities)
			((Entity)obj).attackEntityFrom(DamageSource.causePlayerDamage(sender), 3 + message.data2);
			
			
		if (e != null)
			e.attackEntityFrom(DamageSource.causePlayerDamage(sender), 3 + message.data2);
	}

	public static void handle_speed_rogue(EntityPlayerMP sender)
	{
		sender.addPotionEffect(new PotionEffect(Potion.moveSpeed.id, 120, 1));
		sender.addPotionEffect(new PotionEffect(Potion.jump.id, 120, 1));
	}
	
	public static void handle_vision(EntityPlayerMP sender)
	{
		sender.addPotionEffect(new PotionEffect(Potion.nightVision.id, 200, 99));
	}
	
	public static void handle_invisible(EntityPlayerMP sender)
	{
		sender.addPotionEffect(new PotionEffect(Potion.invisibility.id, 160, 99));
	}

	public static void handle_boots(EntityPlayerMP sender)
	{
		sender.inventory.armorInventory[0].addEnchantment(Enchantment.featherFalling, 5);
	}

	public static void handle_arcane_pillow(PacketSpellToServer message, World world, EntityPlayerMP sender)
	{
		Entity e;
		
		e = world.getEntityByID(message.data);
		if (e != null)
		{
			if (e instanceof EntityLivingBase)
			{
				e.attackEntityFrom(DamageSource.causePlayerDamage(sender), 6 + message.data2);
				sender.addPotionEffect(new PotionEffect(Potion.moveSpeed.id, 60, 1));
			}
		}		
	}

	public static void handle_fireball(World world, EntityPlayerMP sender)
	{
		float a;
		float b;
		float c;
		
		a = (float) sender.getLookVec().xCoord;
		b = (float) sender.getLookVec().yCoord;
		c = (float) sender.getLookVec().zCoord;
    	EntityLargeFireball fireball = new EntityLargeFireball(world, sender.posX + a, sender.posY + b, sender.posZ + c, a, b, c);
        fireball.posY = sender.posY + (double)(sender.height / 2.0F) + 0.5D;
        world.spawnEntityInWorld(fireball);
        fireball.setVelocity(fireball.motionX * 1.5f, fireball.motionY, fireball.motionZ * 1.5f);
	}
}
