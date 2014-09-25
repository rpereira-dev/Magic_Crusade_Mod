package fr.toss.common.entity;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;
import fr.toss.common.register.ItemRegister;

public class EntityBelier extends EntityAnimal {
	
	public int type;

	public EntityBelier(World w)
	{
		super(w);
		this.setSize(0.8f, 1.6f);
		this.type = rand.nextInt(3);
	}
	
	@Override
    protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(14.0D);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.56D);
        this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(20.0d);
    }
	
    protected Item getDropItem()
    {
        return Item.getItemFromBlock(Blocks.wool);
    }

	
    /** Called when the entity is attacked. */
	@Override
    public boolean attackEntityFrom(DamageSource damage, float pow)
    {
		if (damage.getEntity() != null)
		{
			if (damage.getEntity().isEntityInvulnerable())
				return (false);
			else if (damage.getEntity() instanceof EntityLivingBase)
				this.setAttackTarget((EntityLivingBase) damage.getEntity());
		}
		return (super.attackEntityFrom(damage, pow));
    }
	
	@Override
    public boolean attackEntityAsMob(Entity e)
    {
		e.attackEntityFrom(DamageSource.magic, 1.0f);
        return e.attackEntityFrom(DamageSource.causeMobDamage(this), 3.0f);
    }
    
	@Override
    protected void dropRareDrop(int p_70600_1_)
    {
         switch (this.rand.nextInt(3))
        {
            case 0:
                this.dropItem(Items.golden_apple, 1);
                break;
            case 1:
                this.dropItem(Items.potato, 1);
                break;
            case 2:
                this.dropItem(ItemRegister.BERRY_RED, 3);
        }
    }
	
	@Override
	public void onUpdate()
	{
		super.onUpdate();
		
		if (this.rand.nextInt(40) == 0)
		{
			float i, j, k;
			
			for (int iterator = 0; iterator < 20; iterator++)
			{
				i = rand.nextFloat();
				j = rand.nextFloat();
				k = rand.nextFloat();
				
				if (rand.nextInt(2) == 0)
					i = -i;
				if (rand.nextInt(2) == 0)
					j = -j;
				if (rand.nextInt(2) == 0)
					k = -k;
				this.worldObj.spawnParticle("fireworksSpark", this.posX, this.posY, this.posZ, i, j / 6.0f, k);
			}
		}
	}
    
	
    /**
     * Returns the sound this mob makes while it's alive.
     */
    protected String getLivingSound()
    {
        return worldObj.rand.nextInt(2) == 0 ? "magiccrusade:belier_live1" : "magiccrusade:belier_live2";
    }

    /**
     * Returns the sound this mob makes when it is hurt.
     */
    protected String getHurtSound()
    {
        return "magiccrusade:belier_hurt";
    }

    /**
     * Returns the sound this mob makes on death.
     */
    protected String getDeathSound()
    {
        return "magiccrusade:belier_death";
    }

	@Override
	public EntityAgeable createChild(EntityAgeable e)
	{
		EntityBelier ent;
		
		ent = new EntityBelier(this.worldObj);
		ent.setGrowingAge(-24000);
		return ent;
	}
	

}
