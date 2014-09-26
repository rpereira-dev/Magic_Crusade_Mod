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

public class EntityChevalier extends EntityBossM {

	public EntityChevalier(World w)
	{
		super(w);
		this.setSize(2.0f, 4.0f);
		this.set_loot(6, ItemRegister.VALANYR, ItemRegister.LAME_RUNIQUE, ItemRegister.lethal_SWORD, ItemRegister.GLAIVE[7], ItemRegister.CUT[7],
							ItemRegister.MASSE[7], ItemRegister.HEAL_BOOTS[7], ItemRegister.HEAL_CHESTPLATE[7], ItemRegister.HEAL_HELMET[7], ItemRegister.HEAL_PANTS[7],
								ItemRegister.lethal_BOOTS, ItemRegister.lethal_CHESTPLATE, ItemRegister.lethal_PANTS, ItemRegister.lethal_HELMET);
	}
	
    protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(360.0D);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.64D);
        this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(24.0d);
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
		
		time = System.currentTimeMillis() % 20000;

		if (time < 30)
		{
			list = this.worldObj.getEntitiesWithinAABBExcludingEntity(this, this.boundingBox.expand(8.0d, 2.0d, 8.0d));
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
		else if (time >= 10000 && time <= 10030)
		{
			list = this.worldObj.getEntitiesWithinAABBExcludingEntity(this, this.boundingBox.expand(8.0d, 2.0d, 8.0d));
			for (int i = 0; i < list.size(); i++)
			{
				if (list.get(i) instanceof EntityPlayer)
				{
					p = (EntityPlayer) list.get(i);
					p.heal(p.getMaxHealth());
					p.addPotionEffect(new PotionEffect(Potion.wither.id, 200, 3));
					p.setAbsorptionAmount(0);
				}
			}
		}
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
