package fr.toss.common.entity;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAvoidEntity;
import net.minecraft.entity.ai.EntityAIFollowOwner;
import net.minecraft.entity.ai.EntityAILeapAtTarget;
import net.minecraft.entity.ai.EntityAIMate;
import net.minecraft.entity.ai.EntityAIOcelotAttack;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAITargetNonTamed;
import net.minecraft.entity.ai.EntityAITempt;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.passive.EntityTameable;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;
import fr.toss.common.packet.PacketDisplayGui;
import fr.toss.common.packet.Packets;
import fr.toss.common.register.ItemRegister;

public class EntitySlave extends EntityTameable
{
    private EntityAITempt aiTempt;

    public EntitySlave(World p_i1688_1_)
    {
        super(p_i1688_1_);
        this.setSize(0.8F, 1.6F);
        this.getNavigator().setAvoidsWater(true);
        this.tasks.addTask(1, new EntityAISwimming(this));
        this.tasks.addTask(2, this.aiSit);
        this.tasks.addTask(3, this.aiTempt = new EntityAITempt(this, 0.6D, Items.diamond, true));
        this.tasks.addTask(4, new EntityAIFollowOwner(this, 1.0D, 10.0F, 5.0F));
        this.tasks.addTask(5, new EntityAIAvoidEntity(this, EntityCreeper.class, 16.0F, 0.8D, 1.33D));
        this.tasks.addTask(6, new EntityAILeapAtTarget(this, 0.3F));
        this.tasks.addTask(7, new EntityAIOcelotAttack(this));
        this.tasks.addTask(8, new EntityAIMate(this, 0.8D));
        this.tasks.addTask(9, new EntityAIWander(this, 0.8D));
        this.tasks.addTask(10, new EntityAIWatchClosest(this, EntityPlayer.class, 6.0F));
        this.targetTasks.addTask(1, new EntityAITargetNonTamed(this, EntityMob.class, 750, false));
        this.setType(this.rand.nextInt(4));
        this.setRandomStuff();
    }

    private void setRandomStuff()
    {
    	switch (rand.nextInt(4))
    	{
    		case 0 :
    			if (rand.nextInt(3) != 2)
    				this.setCurrentItemOrArmor(1, new ItemStack(Items.leather_boots));
    			if (rand.nextInt(3) != 2)
    				this.setCurrentItemOrArmor(2, new ItemStack(Items.leather_leggings));
    			if (rand.nextInt(3) != 2)
    				this.setCurrentItemOrArmor(3, new ItemStack(Items.leather_chestplate));
    			if (rand.nextInt(3) != 2)
    				this.setCurrentItemOrArmor(4, new ItemStack(Items.leather_helmet));
    			break ;
    			
    		case 1 :
    			if (rand.nextInt(3) != 2)
    				this.setCurrentItemOrArmor(1, new ItemStack(Items.iron_boots));
    			if (rand.nextInt(3) != 2)
    				this.setCurrentItemOrArmor(2, new ItemStack(Items.iron_leggings));
    			if (rand.nextInt(3) != 2)
    				this.setCurrentItemOrArmor(3, new ItemStack(Items.iron_chestplate));
    			if (rand.nextInt(3) != 2)
    				this.setCurrentItemOrArmor(4, new ItemStack(Items.iron_helmet));
    			break ;
    			
    		case 2 :
    			if (rand.nextInt(3) != 2)
    				this.setCurrentItemOrArmor(1, new ItemStack(Items.diamond_boots));
    			if (rand.nextInt(3) != 2)
    				this.setCurrentItemOrArmor(2, new ItemStack(Items.diamond_leggings));
    			if (rand.nextInt(3) != 2)
    				this.setCurrentItemOrArmor(3, new ItemStack(Items.diamond_chestplate));
    			if (rand.nextInt(3) != 2)
    				this.setCurrentItemOrArmor(4, new ItemStack(Items.diamond_helmet));
    			break ;
    			
    		case 3 :
    			if (rand.nextInt(3) != 2)
    				this.setCurrentItemOrArmor(1, new ItemStack(Items.golden_boots));
    			if (rand.nextInt(3) != 2)
    				this.setCurrentItemOrArmor(2, new ItemStack(Items.golden_leggings));
    			if (rand.nextInt(3) != 2)
    				this.setCurrentItemOrArmor(3, new ItemStack(Items.golden_chestplate));
    			if (rand.nextInt(3) != 2)
    				this.setCurrentItemOrArmor(4, new ItemStack(Items.golden_helmet));
    			break ;
    	}
    	
    	switch (rand.nextInt(10))
    	{
	    	case 0 :
	    		this.setCurrentItemOrArmor(0, new ItemStack(Items.iron_axe));
	  			break ;
	  			
	    	case 1 :
	    		this.setCurrentItemOrArmor(0, new ItemStack(Items.wooden_axe));
	  			break ;
	  			
	    	case 2 :
	    		this.setCurrentItemOrArmor(0, new ItemStack(Items.iron_pickaxe));
	  			break ;
	  			
	    	case 3 :
	    		this.setCurrentItemOrArmor(0, new ItemStack(Items.stick));
	  			break ;
	  			
	    	case 4 :
	    		this.setCurrentItemOrArmor(0, new ItemStack(Items.bone));
	  			break ;
	  			
	    	case 5 :
	    		this.setCurrentItemOrArmor(0, new ItemStack(Items.diamond_pickaxe));
	  			break ;
	  			
	    	case 6 :
	    		this.setCurrentItemOrArmor(0, new ItemStack(ItemRegister.ETHERNIUM_PICKAXE));
	  			break ;
	  			
	    	case 7 :
	    		this.setCurrentItemOrArmor(0, new ItemStack(ItemRegister.TITANIUM_SHOVEL));
	  			break ;
	  			
	    	case 8 :
	    		this.setCurrentItemOrArmor(0, new ItemStack(ItemRegister.TITANIUM_SHOVEL));
	  			break ;
	  			
	    	case 9 :
	    		this.setCurrentItemOrArmor(0, new ItemStack(ItemRegister.BLUE_STICK));
	  			break ;
    	}
	}

	protected void entityInit()
    {
        super.entityInit();
        this.dataWatcher.addObject(18, Byte.valueOf((byte)0));
    }

    /**
     * main AI tick function, replaces updateEntityActionState
     */
    public void updateAITick()
    {
    	if (System.currentTimeMillis() % 1000 < 20)
    	{
    		int x = (int) this.posX;
    		int y = (int) this.posY;
    		int z = (int) this.posZ;
    		
    		if (this.worldObj.getLightBrightness(x, y, z) < 0.5f)
    		{
    			this.worldObj.setBlock(x, y, z, Blocks.torch);
    		}
    	}
    	
    	EntityPlayer p;
    	
    	p = this.worldObj.getClosestPlayerToEntity(this, 6.0d);
    	if (p != null)
    		this.setSneaking(true);
    	else
    		this.setSneaking(false);
    }
    
    
    /**
     * Determines if an entity can be despawned, used on idle far away entities
     */
    protected boolean canDespawn()
    {
        return !this.isTamed() && this.ticksExisted > 2400;
    }

    /**
     * Returns true if the newer Entity AI code should be run
     */
    public boolean isAIEnabled()
    {
        return true;
    }

    protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(20.0D);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.30000001192092896D);
    }

    /**
     * (abstract) Protected helper method to write subclass entity data to NBT.
     */
    public void writeEntityToNBT(NBTTagCompound p_70014_1_)
    {
        super.writeEntityToNBT(p_70014_1_);
        p_70014_1_.setInteger("Type", this.getType());
    }

    /**
     * (abstract) Protected helper method to read subclass entity data from NBT.
     */
    public void readEntityFromNBT(NBTTagCompound p_70037_1_)
    {
        super.readEntityFromNBT(p_70037_1_);
        this.setType(p_70037_1_.getInteger("Type"));
    }

    /**
     * Returns the sound this mob makes while it's alive.
     */
    protected String getLivingSound()
    {
        return "mob.villager.haggle";
    }

    /**
     * Returns the sound this mob makes when it is hurt.
     */
    protected String getHurtSound()
    {
        return "mob.villager.hit";
    }

    /**
     * Returns the sound this mob makes on death.
     */
    protected String getDeathSound()
    {
        return "mob.villager.death";
    }

    

    /**
     * Returns the volume for the sounds this mob makes.
     */
    protected float getSoundVolume()
    {
        return 0.4F;
    }

    protected Item getDropItem()
    {
        return Items.leather;
    }

    public boolean attackEntityAsMob(Entity p_70652_1_)
    {
        return p_70652_1_.attackEntityFrom(DamageSource.causeMobDamage(this), 3.0F);
    }

    /**
     * Called when the entity is attacked.
     */
    public boolean attackEntityFrom(DamageSource p_70097_1_, float p_70097_2_)
    {
        if (this.isEntityInvulnerable())
        {
            return false;
        }
        else
        {
            this.aiSit.setSitting(false);
            return super.attackEntityFrom(p_70097_1_, p_70097_2_);
        }
    }

    /**
     * Drop 0-2 items of this living's type. @param par1 - Whether this entity has recently been hit by a player. @param
     * par2 - Level of Looting used to kill this mob.
     */
    protected void dropFewItems(boolean p_70628_1_, int p_70628_2_) {}

    /**
     * Called when a player interacts with a mob. e.g. gets milk from a cow, gets into the saddle on a pig.
     */
    public boolean interact(EntityPlayer player)
    {
        ItemStack itemstack = player.inventory.getCurrentItem();

        if ((itemstack == null) || (itemstack != null && itemstack.getItem() != Items.diamond))
        {
        	if (player instanceof EntityPlayerMP)
        		Packets.network.sendTo(new PacketDisplayGui(1, 0), (EntityPlayerMP) player);
        }
        if (itemstack != null && itemstack.getItem() == Items.diamond && player.getDistanceSqToEntity(this) < 2.0D)
        {
            if (!player.capabilities.isCreativeMode)
            {
                --itemstack.stackSize;
            }

            if (itemstack.stackSize <= 0)
            {
                player.inventory.setInventorySlotContents(player.inventory.currentItem, (ItemStack)null);
            }

            if (!this.worldObj.isRemote)
            {
                if (this.rand.nextInt(3) == 0)
                {
                    this.setTamed(true);
                    this.setType(1 + this.worldObj.rand.nextInt(3));
                    this.func_152115_b(player.getUniqueID().toString());
                    this.playTameEffect(true);
                    this.worldObj.setEntityState(this, (byte)7);
                }
                else
                {
                    this.playTameEffect(false);
                    this.worldObj.setEntityState(this, (byte)6);
                }
            }

            return true;
        }

        return super.interact(player);
    }

    public EntitySlave createChild(EntityAgeable p_90011_1_)
    {
        EntitySlave slave = new EntitySlave(this.worldObj);

        if (this.isTamed())
        {
        	slave.func_152115_b(this.func_152113_b());
        	slave.setTamed(true);
        	slave.setType(this.getType());
        }

        return slave;
    }

    /**
     * Checks if the parameter is an item which this animal can be fed to breed it (wheat, carrots or seeds depending on
     * the animal type)
     */
    public boolean isBreedingItem(ItemStack itemstack)
    {
        return itemstack != null && itemstack.getItem() == Items.diamond;
    }

    /**
     * Returns true if the mob is currently able to mate with the specified mob.
     */
    public boolean canMateWith(EntityAnimal entity)
    {
        if (entity == this || !(entity instanceof EntitySlave))
        	return false;
        else
        {
            EntitySlave slave = (EntitySlave)entity;
            return (slave.getType() == 2) || (this.getType() == 2);
        }
    }

    public int getType()
    {
        return this.dataWatcher.getWatchableObjectByte(18);
    }

    public void setType(int type)
    {
        this.dataWatcher.updateObject(18, Byte.valueOf((byte)type));
    }

    /**
     * Checks if the entity's current position is a valid location to spawn this entity.
     */
    public boolean getCanSpawnHere()
    {
        if (this.worldObj.rand.nextInt(3) == 0)
        {
            return false;
        }
        else
        {
            if (this.worldObj.checkNoEntityCollision(this.boundingBox) && this.worldObj.getCollidingBoundingBoxes(this, this.boundingBox).isEmpty() && !this.worldObj.isAnyLiquid(this.boundingBox))
            {
                int i = MathHelper.floor_double(this.posX);
                int j = MathHelper.floor_double(this.boundingBox.minY);
                int k = MathHelper.floor_double(this.posZ);

                if (j < 63)
                {
                    return false;
                }

                Block block = this.worldObj.getBlock(i, j - 1, k);

                if (block == Blocks.grass || block.isLeaves(worldObj, i, j - 1, k))
                {
                    return true;
                }
            }

            return false;
        }
    }

    /**
     * Gets the name of this command sender (usually username, but possibly "Rcon")
     */
    public String getCommandSenderName()
    {
        return this.hasCustomNameTag() ? this.getCustomNameTag() : (this.isTamed() ? StatCollector.translateToLocal("entity.Slave.name") : super.getCommandSenderName());
    }

    public IEntityLivingData onSpawnWithEgg(IEntityLivingData living_data)
    {
        living_data = super.onSpawnWithEgg(living_data);

        if (this.worldObj.rand.nextInt(7) == 0)
        {
            for (int i = 0; i < 2; ++i)
            {
                EntitySlave slave = new EntitySlave(this.worldObj);
                slave.setLocationAndAngles(this.posX, this.posY, this.posZ, this.rotationYaw, 0.0F);
                slave.setGrowingAge(-24000);
                this.worldObj.spawnEntityInWorld(slave);
            }
        }

        return living_data;
    }
}