package fr.toss.common.entity;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;
import fr.toss.common.register.ItemRegister;

public class EntityHaunter extends EntityMob {

	public EntityHaunter(World w)
	{
		super(w);
		this.setSize(0.8f, 1.6f);
	}
	
    protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(26.0D);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.6D);
        this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(4.0D);
    }
    
    /**
     * Returns the sound this mob makes while it's alive.
     */
    protected String getLivingSound()
    {
        return this.worldObj.rand.nextInt(2) == 0 ? "mob.skeleton.say" : "mob.blaze.breathe";
    }

    /**
     * Returns the sound this mob makes when it is hurt.
     */
    protected String getHurtSound()
    {
        return "mob.skeleton.hurt";
    }

    /**
     * Returns the sound this mob makes on death.
     */
    protected String getDeathSound()
    {
        return "mob.skeleton.death";
    }

    protected void func_145780_a(int p_145780_1_, int p_145780_2_, int p_145780_3_, Block p_145780_4_)
    {
        this.playSound("mob.skeleton.step", 0.15F, 1.0F);
    }

    protected Entity findPlayerToAttack()
    {
        double d0 = 16.0D;
        return this.worldObj.getClosestVulnerablePlayerToEntity(this, d0);
    }
    
    public boolean attackEntityAsMob(Entity e)
    {
        if (super.attackEntityAsMob(e))
        {
        	if (e.worldObj.rand.nextInt(2) == 0)
        	{
            	if (e.worldObj.rand.nextInt(2) == 0)
                	((EntityLivingBase)e).addPotionEffect(new PotionEffect(Potion.poison.id, 40, 0));
            	else
                	((EntityLivingBase)e).addPotionEffect(new PotionEffect(Potion.blindness.id, 40, 0));
        	}
        }
		return (true);
    }

    protected Item getDropItem()
    {
        return Items.bone;
    }

    /**
     * Drop 0-2 items of this living's type. @param par1 - Whether this entity has recently been hit by a player. @param
     * par2 - Level of Looting used to kill this mob.
     */
    protected void dropFewItems(boolean bool, int nb)
    {
        int j = this.rand.nextInt(2) + nb;

        for (int k = 0; k < j; ++k)
        	this.dropItem(ItemRegister.INGOT_TITANIUM, 1);
    }
    

    /**
     * Get this Entity's EnumCreatureAttribute
     */
    public EnumCreatureAttribute getCreatureAttribute()
    {
        return EnumCreatureAttribute.UNDEAD;
    }
}
