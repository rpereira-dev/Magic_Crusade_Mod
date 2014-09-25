package fr.toss.common.entity;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;
import fr.toss.common.register.ItemRegister;

public class EntityMageOrc extends EntityMob {

	public EntityMageOrc(World w)
	{
		super(w);
		this.setSize(0.8f, 1.6f);
		this.isImmuneToFire = true;
		this.addPotionEffect(new PotionEffect(Potion.jump.id, Integer.MAX_VALUE, 1));
	}
	
    protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(20.0D);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.6000000238418579D);
        this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(2.0D);
    }
    
    /**
     * Returns the sound this mob makes while it's alive.
     */
    protected String getLivingSound()
    {
        return "mob.zombie.say";
    }

    /**
     * Returns the sound this mob makes when it is hurt.
     */
    protected String getHurtSound()
    {
        return "mob.zombie.hurt";
    }

    /**
     * Returns the sound this mob makes on death.
     */
    protected String getDeathSound()
    {
        return "mob.zombie.death";
    }

    protected void func_145780_a(int p_145780_1_, int p_145780_2_, int p_145780_3_, Block p_145780_4_)
    {
        this.playSound("mob.zombie.step", 0.15F, 1.0F);
    }
    
    public boolean canDespawn()
    {
    	return (false);
    }
    
    protected Item getDropItem()
    {  
        if (rand.nextInt(10) == 0)
        	this.entityDropItem(new ItemStack(ItemRegister.COMBUSTIUM, 1 + this.worldObj.rand.nextInt(2)), 2.0f);
        
        if (rand.nextInt(3) == 0)
        	this.entityDropItem(new ItemStack(ItemRegister.STAFF_LIGHTNING, 1), 3.0f);
        
        return ItemRegister.COMBUSTIUM;
    }
    
    
    /**
     * Called to update the entity's position/logic.
     */
    public void onUpdate()
    {
    	super.onUpdate();
    	
    	long timer;
    	
    	timer = System.currentTimeMillis() % 8000;
    	
    	if (timer < 20) //TOutes les 3 secondes
    	{
    		Entity e;
    		
    		e = this.worldObj.getClosestPlayerToEntity(this, 6.0d);

    		if (e != null)
    		{
	    		EntityLightningBolt bolt;
	    		
	    		bolt = new EntityLightningBolt(this.worldObj, e.posX, e.posY, e.posZ);
	    		this.worldObj.spawnEntityInWorld(bolt);
    		}
    	}
    	else if (timer > 4000 && timer < 4020)
    	{
    		Entity e;
    		
    		e = this.worldObj.getClosestPlayerToEntity(this, 16.0d);
    		if (e != null)
    			this.worldObj.createExplosion(this, e.posX, e.posY - 1, e.posZ, 1.0f, true);
    	}
    }

    protected Entity findPlayerToAttack()
    {
        double d0 = 16.0D;
        return this.worldObj.getClosestVulnerablePlayerToEntity(this, d0);
    }
    
    /**
     * Get this Entity's EnumCreatureAttribute
     */
    public EnumCreatureAttribute getCreatureAttribute()
    {
        return EnumCreatureAttribute.UNDEFINED;
    }
}
