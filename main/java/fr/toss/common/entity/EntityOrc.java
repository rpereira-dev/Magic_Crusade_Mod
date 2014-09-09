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

public class EntityOrc extends EntityMob {

	public EntityOrc(World w)
	{
		super(w);
		this.setSize(0.8f, 1.6f);
		if (w.rand.nextInt(10) == 0)
			this.setCurrentItemOrArmor(0, new ItemStack(ItemRegister.SULFURAS, 1));
		else if (w.rand.nextInt(4) == 0)
			this.setCurrentItemOrArmor(0, new ItemStack(ItemRegister.ETHERNIUM_HATCHET, 1));
	}
	
    protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(20.0D);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.6000000238418579D);
        this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(4.0D);
    }
    
    public boolean canDespawn()
    {
    	return (false);
    }
    
    protected Item getDropItem()
    {  
        if (rand.nextInt(10) == 0)
        	this.entityDropItem(new ItemStack(ItemRegister.ETHERNIUM_HATCHET, 1), 2.0f);
        
        if (rand.nextInt(4) == 0)
        	this.entityDropItem(new ItemStack(ItemRegister.getRandomArmor(), 1), 2.0f);
        
        return Items.stick;
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
