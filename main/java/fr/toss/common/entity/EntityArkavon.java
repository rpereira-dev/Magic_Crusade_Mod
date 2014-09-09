package fr.toss.common.entity;

import java.util.List;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.boss.BossStatus;
import net.minecraft.entity.boss.IBossDisplayData;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.DamageSource;
import net.minecraft.util.IChatComponent;
import net.minecraft.world.World;
import fr.toss.common.register.ItemRegister;

public class EntityArkavon extends EntityMob implements IBossDisplayData {

	public EntityArkavon(World w)
	{
		super(w);
		this.setSize(2.0f, 4.0f);
	}
	
    protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(600.0D);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.64D);
        this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(30.0D);
        this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(20.0D);
    }
    
    @Override
    public IChatComponent func_145748_c_()
    {
    	return new ChatComponentText("Arkavon");
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
		int id;

		id = 0;
		list = this.worldObj.getEntitiesWithinAABBExcludingEntity(this, this.boundingBox.expand(16.0d, 16.0d, 16.0d));
		for (int i = 0; i < list.size(); i++)
		{
			if (list.get(i) instanceof EntityPlayer)
			{
				p = (EntityPlayer) list.get(i);
				update_battle(p, id);	
				id++;
			}
		}
		
		
		if (p != null)
			BossStatus.setBossStatus(this, true);
    }
    
    public void update_battle(EntityPlayer p, int id)
    {
    	long timer;
    	
		timer = System.currentTimeMillis() % 30000;

    	if (timer < 40 && id % 2 == 1)
    	{
			p.addPotionEffect(new PotionEffect(Potion.poison.id, 400, 10));
			p.addPotionEffect(new PotionEffect(Potion.confusion.id, 400, 10));
			p.addPotionEffect(new PotionEffect(Potion.wither.id, 400, 10));
    	}
    	else if (timer > 4000 && timer < 4040)
    	{
    		EntityMonsterZombie zombie;
    		
    		zombie = new EntityMonsterZombie(this.worldObj);
    		zombie.setLocationAndAngles(this.posX + 1, this.posY + 2, this.posZ, 0, 0);
    		this.worldObj.spawnEntityInWorld(zombie);
    		p.addChatComponentMessage(new ChatComponentText("Say hello to my friends..."));	
    	}
    	else if (timer > 12000 && timer < 16000)
    	{
    		if (p.posY - this.posY < 6)
    			p.motionY += 0.1f;
    		p.attackEntityFrom(DamageSource.magic, 0.05f);
    	}
    	else if (timer > 24000 && timer < 26000 && timer % 1000 < 100)
			this.worldObj.createExplosion(this, p.posX, p.posY - 1, p.posZ, 1, true);

    }
    
    protected Item getDropItem()
    {
        for (int k = 0; k < 4; ++k)
        	this.dropItem(ItemRegister.getRandomArmor(), 1);
        
        return ItemRegister.SULFURAS;
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
