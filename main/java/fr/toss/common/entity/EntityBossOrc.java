package fr.toss.common.entity;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.boss.IBossDisplayData;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.DamageSource;
import net.minecraft.util.IChatComponent;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import fr.toss.common.command.ChatColor;
import fr.toss.common.register.ItemRegister;

public class EntityBossOrc extends EntityMob implements IBossDisplayData {

	public EntityBossOrc(World w)
	{
		super(w);
		this.setSize(2.0f, 4.0f);
		this.isImmuneToFire = true;
	}
	
	  /**
     * Returns the sound this mob makes while it's alive.
     */
    protected String getLivingSound()
    {
        return this.worldObj.rand.nextInt(2) == 0 ? "magiccrusade:king_orc_live1" : "magiccrusade:king_orc_live2";
    }

    /**
     * Returns the sound this mob makes when it is hurt.
     */
    protected String getHurtSound()
    {
        return this.worldObj.rand.nextInt(2) == 0 ? "magiccrusade:king_orc_hurt1" : "magiccrusade:king_orc_hurt2";
    }

    /**
     * Returns the sound this mob makes on death.
     */
    protected String getDeathSound()
    {
        return "mob.magiccrusade:king_orc_die";
    }

    protected void func_145780_a(int p_145780_1_, int p_145780_2_, int p_145780_3_, Block p_145780_4_)
    {
        this.playSound("mob.zombie.step", 0.15F, 1.0F);
    }
	
    protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(300.0D);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.64D);
        this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(10.0D);
        this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(20.0D);
    }
    
    @Override
    public IChatComponent func_145748_c_()
    {
    	return new ChatComponentText("Orc King");
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
		long timer;
		
		list = this.worldObj.getEntitiesWithinAABBExcludingEntity(this, this.boundingBox.expand(16.0d, 4.0d, 16.0d));
		for (int i = 0; i < list.size(); i++)
		{
			if (list.get(i) instanceof EntityPlayer)
			{
				p = (EntityPlayer) list.get(i);
				update_battle(p);	
			}
		}
    }
    
    public void update_battle(EntityPlayer p)
    {
    	long timer;
    	
		timer = System.currentTimeMillis() % 18000;
	
    	if (timer < 40)
    		p.addPotionEffect(new PotionEffect(Potion.blindness.id, 100, 0));
    	else if (timer > 8000 && timer < 8020)
    	{
    		Vec3 vec;
    		
			vec = p.getLookVec();
			p.motionX += -vec.xCoord * 4;
			p.motionY += 0.4f;
			p.motionZ += -vec.zCoord * 4;
			p.attackEntityFrom(DamageSource.magic, 0.5f);
			p.addChatComponentMessage(new ChatComponentText(ChatColor.UNDERLINE + "King Orc:" + ChatColor.RESET + " GO AWAY!"));
		}
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
