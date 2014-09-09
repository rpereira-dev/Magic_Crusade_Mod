package fr.toss.common.entity;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;

public class EntityGobelin extends EntityMob {
	
	int tnt_x;
	int tnt_y;
	int tnt_z;

	public EntityGobelin(World w)
	{
		super(w);
		this.setSize(0.8f, 1.6f);
	}
	
    protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(14.0D);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.6500000238418579D);
        this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(2.0D);
    }
    
    public boolean canDespawn()
    {
    	return (false);
    }
    

    protected Entity findPlayerToAttack()
    {
        double d0 = 16.0D;
        return this.worldObj.getClosestVulnerablePlayerToEntity(this, d0);
    }
  
    public void onUpdate()
    {
    	super.onUpdate();
    	
    	long timer = System.currentTimeMillis() % 10000;
    	
    	if (timer < 20)
    	{
    		this.tnt_x = (int) this.posX;
    		this.tnt_y = (int) this.posY;
    		this.tnt_z = (int) this.posZ;
    		this.worldObj.setBlock(this.tnt_x, this.tnt_y, this.tnt_z, Blocks.tnt);
    	}
    }
    
    /**
     * Returns the sound this mob makes while it's alive.
     */
    protected String getLivingSound()
    {
        return this.worldObj.rand.nextInt(2) == 0 ? "mob.villager.haggle" : "mob.villager.idle";
    }

    /**
     * Returns the sound this mob makes when it is hurt.
     */
    protected String getHurtSound()
    {
        return "mob.villager.hit";
    }

    /**
     * Returns the sound this mob makes on death.
     */
    protected String getDeathSound()
    {
        return "mob.villager.death";
    }
    
    /**
     * Get this Entity's EnumCreatureAttribute
     */
    public EnumCreatureAttribute getCreatureAttribute()
    {
        return EnumCreatureAttribute.UNDEFINED;
    }
}
