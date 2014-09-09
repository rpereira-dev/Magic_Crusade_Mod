package fr.toss.common.entity;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.item.Item;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;
import fr.toss.common.register.ItemRegister;

public class EntityLutin extends EntityMob {

	public EntityLutin(World w)
	{
		super(w);
		this.setSize(0.8f, 1.6f);
	}
	
    protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(16.0D);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.5000000238418579D);
        this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(2.0D);
    }
    

    protected Entity findPlayerToAttack()
    {
        double d0 = 16.0D;
        return this.worldObj.getClosestVulnerablePlayerToEntity(this, d0);
    }
    
    public boolean attackEntityAsMob(Entity e)
    {
        if (super.attackEntityAsMob(e))
        	((EntityLivingBase)e).addPotionEffect(new PotionEffect(Potion.poison.id, 40, 0));
		return (true);
    }

    protected Item getDropItem()
    {
        return ItemRegister.ETHERNIUM;
    }

    /**
     * Drop 0-2 items of this living's type. @param par1 - Whether this entity has recently been hit by a player. @param
     * par2 - Level of Looting used to kill this mob.
     */
    protected void dropFewItems(boolean bool, int nb)
    {
        int j = this.rand.nextInt(2) + nb;

        for (int k = 0; k < j; ++k)
        	this.dropItem(ItemRegister.ETHERNIUM, 1);
    }
    

    /**
     * Get this Entity's EnumCreatureAttribute
     */
    public EnumCreatureAttribute getCreatureAttribute()
    {
        return EnumCreatureAttribute.UNDEFINED;
    }
}
