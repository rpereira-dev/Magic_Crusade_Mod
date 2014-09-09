package fr.toss.common.entity;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import fr.toss.common.register.ItemRegister;

public class EntityMonsterZombie extends EntityMob {
	

	public EntityMonsterZombie(World w)
	{
		super(w);
		this.setSize(1.0f, 2.0f);
	}
	
    protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(200.0D);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.3D);
        this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(100.0D);
    }
    
    public boolean canDespawn()
    {
    	return (true);
    }
    
    protected Item getDropItem()
    {  
        return Items.rotten_flesh;
    }
    
    @Override
    public void onUpdate()
    {
    	super.onUpdate();
    	this.setHealth(this.getHealth() - 1);
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
        return EnumCreatureAttribute.UNDEAD;
    }
}
