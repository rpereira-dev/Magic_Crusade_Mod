package fr.toss.common.entity;

import java.util.List;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.boss.BossStatus;
import net.minecraft.entity.boss.IBossDisplayData;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntitySmallFireball;
import net.minecraft.entity.projectile.EntityWitherSkull;
import net.minecraft.item.Item;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.DamageSource;
import net.minecraft.util.IChatComponent;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import fr.toss.common.register.ItemRegister;

public class EntityChevalier extends EntityMob implements IBossDisplayData {

	public EntityChevalier(World w)
	{
		super(w);
		this.setSize(2.0f, 4.0f);
	}
	
    protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(200.0D);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.64D);
        this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(18.0D);
        this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(20.0D);
    }
    
    @Override
    public IChatComponent func_145748_c_()
    {
    	return new ChatComponentText("Chevalier");
    }

    
    public boolean canDespawn()
    {
    	return (false);
    }
    
    @Override
    public void onUpdate()
    {
    	super.onUpdate();
    	
		List list;
		EntityPlayer p = null;
		long time;
		
		time = System.currentTimeMillis() % 10000;

		if (time < 30)
		{
			list = this.worldObj.getEntitiesWithinAABBExcludingEntity(this, this.boundingBox.expand(16.0d, 16.0d, 16.0d));
			for (int i = 0; i < list.size(); i++)
			{
				if (list.get(i) instanceof EntityPlayer)
				{
					p = (EntityPlayer) list.get(i);
					p.setHealth(0.5f);
					p.setAbsorptionAmount(20.0f);
				}
			}
		}
		else if (time >= 5000 && time <= 5030)
		{
			list = this.worldObj.getEntitiesWithinAABBExcludingEntity(this, this.boundingBox.expand(16.0d, 16.0d, 16.0d));
			for (int i = 0; i < list.size(); i++)
			{
				if (list.get(i) instanceof EntityPlayer)
				{
					p = (EntityPlayer) list.get(i);
					p.heal(p.getMaxHealth() / 2);
					p.setAbsorptionAmount(0);
				}
			}
		}
    }
    
    protected Item getDropItem()
    {
        for (int k = 0; k < 4; ++k)
        	this.dropItem(ItemRegister.getRandomArmor(), 1);

        return ItemRegister.LAME_RUNIQUE;
    }

    protected Entity findPlayerToAttack()
    {
        double d0 = 20.0D;
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
