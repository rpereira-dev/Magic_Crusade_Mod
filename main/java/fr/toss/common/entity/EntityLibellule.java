package fr.toss.common.entity;

import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.passive.EntityAmbientCreature;
import net.minecraft.world.World;

public class EntityLibellule extends EntityAmbientCreature {
	
	public int type;

	public EntityLibellule(World w) 
	{
		super(w);
		this.type = w.rand.nextInt(2);
	}
	
	@Override
    protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(2.0D);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(2.0d);
    }
	
	
	@Override
	public void fall(float f) {}

	
    /**
     * Returns true if the newer Entity AI code should be run
     */
    protected boolean isAIEnabled()
    {
        return true;
    }

    /**
     * Called to update the entity's position/logic.
     */
    public void onUpdate()
    {
        super.onUpdate();
        
        if (System.currentTimeMillis() % 4000 < 30 && this.posY - this.worldObj.getTopSolidOrLiquidBlock((int) this.posX, (int)this.posZ) < 4)
        	this.motionY += 0.06d;
        
        
    }
    
    
    /**
     * Returns the sound this mob makes while it's alive.
     */
    protected String getLivingSound()
    {
        return "magiccrusade:libellule";
    }
    

    /**
     * Returns the sound this mob makes when it is hurt.
     */
    protected String getHurtSound()
    {
        return "mob.villager.hit";
    }
}
