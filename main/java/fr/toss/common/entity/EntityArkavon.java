package fr.toss.common.entity;

import java.util.List;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.SharedMonsterAttributes;
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

public class EntityArkavon extends EntityBossM {

	public EntityArkavon(World w)
	{
		super(w);
		this.setSize(2.0f, 4.0f);
		this.isImmuneToFire = true;
		
		this.set_loot(5, ItemRegister.LAME_TONERRE, ItemRegister.baneful_SWORD, ItemRegister.SHALAMAYNE, ItemRegister.SHALLATOR, ItemRegister.FAUX,
							ItemRegister.ELLAMAYNE, ItemRegister.TANK_CHESTPLATE[7], ItemRegister.TANK_HELMET[7], ItemRegister.TANK_PANTS[7], ItemRegister.TANK_PANTS[7],
								ItemRegister.baneful_BOOTS, ItemRegister.baneful_CHESTPLATE, ItemRegister.baneful_PANTS, ItemRegister.baneful_HELMET);
	}
	
    protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(600.0D);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.64D);
        this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(30.0D);
        this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(30.0D);
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
		
    	
    	if (this.getHealth() < this.getMaxHealth() / 4 && System.currentTimeMillis() % 2000 < 30)
    		this.aura_death(list);
    	
    	if (this.getHealth() < this.getMaxHealth() / 16)
    	{
    		this.setInvisible(true);
    		this.sendWitherSkull();
    		this.setInvisible(false);
    	}
    }
    
    private void sendWitherSkull()
    {
    	EntityWitherSkull skull;
    	double a;
    	double b;
    	double c;
    	
    	a = this.rand.nextFloat();
    	b = this.rand.nextFloat();
    	c = this.rand.nextFloat();
    	if (rand.nextInt(2) == 0)
    		a = -a;
    	if (rand.nextInt(2) == 0)
    		b = -b;
    	if (rand.nextInt(2) == 0)
    		c = -c;
    	
    	skull = new EntityWitherSkull(this.worldObj, this, a, b, c);
    	this.worldObj.spawnEntityInWorld(skull);
    }

	private void aura_death(List list)
    {
		int r;
		double x;
		double y;
		double z;
		
		r = 20;
		for (int beta = -180; beta < 180; beta += 4)
		{
    		for (int teta = -90; teta < 90; teta += 4)
    		{
    			x = r * MathHelper.cos(teta) * MathHelper.cos(beta);
    			y = r * MathHelper.sin(teta);
    			z = r * MathHelper.cos(teta) * MathHelper.sin(beta);
    			this.worldObj.spawnParticle("smoke", this.posX, this.posY + 2, this.posZ, x / 12.0f, y / 8.0f, z / 12.0f);
    		}
		}
		
		for (int i = 0; i < list.size(); i++)
		{
			if (list.get(i) instanceof EntityPlayer)
			{
				if (list.get(i) instanceof EntityLivingBase)
				{
					((EntityLivingBase)list.get(i)).attackEntityFrom(DamageSource.causeMobDamage(this), 2);
				}
			}
		}		
	}

	public void update_battle(EntityPlayer p, int id)
    {
    	long timer;
    	
		timer = System.currentTimeMillis() % 34000;

    	if (timer < 40)
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
    	else if (timer > 12000 && timer < 18000)
    	{
    		if (p.posY - this.posY < 6)
    			p.motionY += 0.1f;
    		p.attackEntityFrom(DamageSource.magic, 0.05f);
    	}
    	else if (timer > 24000 && timer < 26400 && timer % 1000 < 100)
    	{
			this.worldObj.createExplosion(this, p.posX, p.posY - 1, p.posZ, 1, true);
    	}
    	else if (timer > 30000 && timer < 30100)
    	{

            this.worldObj.playAuxSFXAtEntity((EntityPlayer)null, 1009, (int)this.posX, (int)this.posY, (int)this.posZ, 0);
            for (int i = 0; i < 4; ++i)
            {
                EntitySmallFireball entitysmallfireball = new EntitySmallFireball(this.worldObj, this, this.getLookVec().xCoord, this.getLookVec().yCoord, this.getLookVec().zCoord);
                entitysmallfireball.posY = this.posY + (double)(this.height / 2.0F) + 0.5D;
                this.worldObj.spawnEntityInWorld(entitysmallfireball);
            }
    	}
    }
	
    protected Entity findPlayerToAttack()
    {
        double d0 = 30.0D;
        return this.worldObj.getClosestVulnerablePlayerToEntity(this, d0);
    }
    
    /**
     * Get this Entity's EnumCreatureAttribute
     */
    public EnumCreatureAttribute getCreatureAttribute()
    {
        return EnumCreatureAttribute.UNDEFINED;
    }
    
    @Override
    protected Item getDropItem()
    {
    	super.getDropItem();
        return this.worldObj.rand.nextInt(2) == 0 ? ItemRegister.SHADOWMOURNE : ItemRegister.FROSTMOURNE;
    }
    
}
