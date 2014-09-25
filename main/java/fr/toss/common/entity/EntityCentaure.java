package fr.toss.common.entity;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.MathHelper;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;

public class EntityCentaure extends EntityMob
{

    public EntityCentaure(World p_i1743_1_)
    {
        super(p_i1743_1_);
        this.setSize(1.0F, 3.0F);
    }

    protected void entityInit()
    {
        super.entityInit();
        this.dataWatcher.addObject(16, new Byte((byte)0));
    }

    /**
     * Called to update the entity's position/logic.
     */
    public void onUpdate()
    {
        super.onUpdate();
    }

    protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(24.0D);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.800000011920929D);
    }


    /**
     * Returns the sound this mob makes while it's alive.
     */
    protected String getLivingSound()
    {
    	int i;
    	
    	i = this.rand.nextInt(3);
        return i == 0 ? "magiccrusade:centaure_live1" : i == 1 ? "magiccrusade:centaure_live2" : null;
    }

    /**
     * Returns the sound this mob makes when it is hurt.
     */
    protected String getHurtSound()
    {
        return "magiccrusade:centaure_hurt";
    }

    /**
     * Returns the sound this mob makes on death.
     */
    protected String getDeathSound()
    {
        return "magiccrusade:centaure_die";
    }

    protected void func_145780_a(int p_145780_1_, int p_145780_2_, int p_145780_3_, Block p_145780_4_)
    {
        this.playSound("mob.spider.step", 0.15F, 1.0F);
    }

    /**
     * Basic mob attack. Default to touch of death in EntityCreature. Overridden by each mob to define their attack.
     */
    protected void attackEntity(Entity p_70785_1_, float p_70785_2_)
    {
    	if (this.onGround)
    	{
	        double d0 = p_70785_1_.posX - this.posX;
	        double d1 = p_70785_1_.posZ - this.posZ;
	        float f2 = MathHelper.sqrt_double(d0 * d0 + d1 * d1);
	        this.motionX = d0 / (double)f2 * 0.5D * 0.800000011920929D + this.motionX * 0.20000000298023224D;
	        this.motionZ = d1 / (double)f2 * 0.5D * 0.800000011920929D + this.motionZ * 0.20000000298023224D;
	        this.motionY = 0.4000000059604645D;
    	}
    	super.attackEntity(p_70785_1_, p_70785_2_);
    }

    protected Item getDropItem()
    {
        return Items.string;
    }

    /**
     * Drop 0-2 items of this living's type. @param par1 - Whether this entity has recently been hit by a player. @param
     * par2 - Level of Looting used to kill this mob.
     */
    protected void dropFewItems(boolean p_70628_1_, int p_70628_2_)
    {
        super.dropFewItems(p_70628_1_, p_70628_2_);

        if (p_70628_1_ && (this.rand.nextInt(3) == 0 || this.rand.nextInt(1 + p_70628_2_) > 0))
        {
            this.dropItem(Items.spider_eye, 1);
        }
    }


    /**
     * Sets the Entity inside a web block.
     */
    public void setInWeb() {}

    /**
     * Get this Entity's EnumCreatureAttribute
     */
    public EnumCreatureAttribute getCreatureAttribute()
    {
        return EnumCreatureAttribute.ARTHROPOD;
    }

    public boolean isPotionApplicable(PotionEffect p_70687_1_)
    {
        return p_70687_1_.getPotionID() == Potion.poison.id ? false : super.isPotionApplicable(p_70687_1_);
    }


    public IEntityLivingData onSpawnWithEgg(IEntityLivingData p_110161_1_)
    {
        Object p_110161_1_1 = super.onSpawnWithEgg(p_110161_1_);

        if (p_110161_1_1 == null)
        {
            p_110161_1_1 = new EntityCentaure.GroupData();

            if (this.worldObj.difficultySetting == EnumDifficulty.HARD && this.worldObj.rand.nextFloat() < 0.1F * this.worldObj.func_147462_b(this.posX, this.posY, this.posZ))
            {
                ((EntityCentaure.GroupData)p_110161_1_1).func_111104_a(this.worldObj.rand);
            }
        }

        if (p_110161_1_1 instanceof EntityCentaure.GroupData)
        {
            int i = ((EntityCentaure.GroupData)p_110161_1_1).field_111105_a;

            if (i > 0 && Potion.potionTypes[i] != null)
            {
                this.addPotionEffect(new PotionEffect(i, Integer.MAX_VALUE));
            }
        }

        return (IEntityLivingData)p_110161_1_1;
    }

    public static class GroupData implements IEntityLivingData
        {
            public int field_111105_a;

            public void func_111104_a(Random p_111104_1_)
            {
                int i = p_111104_1_.nextInt(5);

                if (i <= 1)
                {
                    this.field_111105_a = Potion.moveSpeed.id;
                }
                else if (i <= 2)
                {
                    this.field_111105_a = Potion.damageBoost.id;
                }
                else if (i <= 3)
                {
                    this.field_111105_a = Potion.regeneration.id;
                }
                else if (i <= 4)
                {
                    this.field_111105_a = Potion.invisibility.id;
                }
            }
        }
}