package fr.toss.common.items;

import java.util.List;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fr.toss.common.command.ChatColor;

public class ItemSwordM extends ItemSword {
	
	public float agility;
	public float strength;
	public float clarity;
	public float mana;
	public float endurance;
	public float mana_regeneration;
	public boolean hasEffect;

	public ItemSwordM(ToolMaterial material)
	{
		super(material);
	}
	
	@Override
    @SideOnly(Side.CLIENT)
    public boolean hasEffect(ItemStack is)
    {
        return this.hasEffect || is.isItemEnchanted();
    }
	
	 /**
     * allows items to add custom lines of information to the mouseover description
     */
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack item, EntityPlayer player, List list, boolean bool)
    {
    	if (this.endurance != 0)
    		list.add(ChatColor.GREEN + "+ " + this.endurance + " Endurance");
    	if (this.mana != 0)
    		list.add(ChatColor.GREEN + "+ " + this.mana + " Mana");
    	if (this.strength != 0)
    		list.add(ChatColor.GREEN + "+ " + this.strength + " Strength");
    	if (this.agility != 0)
    		list.add(ChatColor.GREEN + "+ " + this.agility + " Stamina");
    	if (this.clarity != 0)
    		list.add(ChatColor.GREEN + "+ " + this.clarity + " Clarity");
    	if (this.mana_regeneration != 0)
    		list.add(ChatColor.GREEN + "+ " + this.mana_regeneration + " Mana Regen.");
    }
    
    
	@Override
	public void onArmorTick(World world, EntityPlayer player, ItemStack stack)
	{
		
	}
	
	public ItemSwordM setAgility(float i)
	{
		this.agility = i;
		return (this);
	}
	
	public ItemSwordM setStrenght(float i)
	{
		this.strength = i;
		return (this);
	}
	
	public ItemSwordM setClarity(float i)
	{
		this.clarity = i;
		return (this);
	}
	
	public ItemSwordM setMana(float i)
	{
		this.mana = i;
		return (this);
	}
	
	public ItemSwordM setEndurance(float i)
	{
		this.endurance = i;
		return (this);
	}
	
	public ItemSwordM setManaRegen(int i)
	{
		this.mana_regeneration = i;
		return (this);
	}
	
	public ItemSwordM setHasEffect()
	{
		this.hasEffect = true;
		return (this);
	}
	
	public Entity getLookingEntity(EntityPlayer thePlayer, double range)
	{
		List list = thePlayer.worldObj.getEntitiesWithinAABBExcludingEntity(thePlayer, thePlayer.boundingBox.expand(range, range, range));
		Entity entity;
		
		if (list != null)
		{
			for (int i = 0; i < list.size(); i++)
			{
				entity = (Entity)list.get(i);

	                if (!entity.isDead)
	                {
	             	   if(entity instanceof EntityLivingBase)
	             	   {
	             		   Vec3 vec3d;
	             		   Vec3 vec3d1;
	             		   double d;
	             		   double d1;
	             		   double a;
	             		   double b;
	             		   double c;
	             		   
	             		   vec3d = thePlayer.getLook(1.0F).normalize();
	             		   vec3d1 = Vec3.createVectorHelper(entity.posX - thePlayer.posX, (entity.boundingBox.minY + (double)(entity.height / 2.0F)) - (thePlayer.posY + (double)thePlayer.getEyeHeight()), entity.posZ - thePlayer.posZ);
	             		   d = vec3d1.lengthVector();
	             		   vec3d1 = vec3d1.normalize();
	             		   d1 = vec3d.dotProduct(vec3d1);
	             	       if (d1 > 1.0D - 0.025000000000000001D / d)
	             	       {
	             	    	   System.out.println("Looking at " + entity);
	             	    	   return (entity);
	             	       }
	             	   }
	             	   
	                }     
				}
			
			}
			return (null);
	    }


}
