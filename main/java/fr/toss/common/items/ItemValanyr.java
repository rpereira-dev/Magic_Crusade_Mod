package fr.toss.common.items;

import java.util.List;
import java.util.Random;

import net.minecraft.client.resources.I18n;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fr.toss.common.command.ChatColor;
import fr.toss.common.register.EnumMaterial;

public class ItemValanyr extends ItemSwordM {
	
	private int charge;

	public ItemValanyr()
	{
		super(EnumMaterial.TOOL_EPIC);
		this.hasEffect = true;
		this.setTextureName("magiccrusade:valanyr");
		this.setUnlocalizedName("valanyr");
		this.setClarity(40.0f);
		this.setManaRegen(4);
	}

	@Override
    public void onUpdate(ItemStack is, World w, Entity e, int i, boolean b)
    {    	
    	int charge;
    	
    	if (System.currentTimeMillis() % 1000 < 20)
    	{
	    	if (is.stackTagCompound != null)
	    	{
		    	charge = is.stackTagCompound.getInteger("charge");
		    	if (charge < 500)
		    		is.stackTagCompound.setInteger("charge", charge + 20);
	    	}
	    	else
	    	{
	    		is.stackTagCompound = new NBTTagCompound();
	    		is.stackTagCompound.setInteger("charge", 500);
	    	}
    	}
    	super.onUpdate(is, w, e, i, b);
    }

	
	 /**
     * allows items to add custom lines of information to the mouseover description
     */
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack is, EntityPlayer player, List list, boolean bool)
    {
    	super.addInformation(is, player, list, bool);
    	if (is.stackTagCompound == null)
    	{
    		is.stackTagCompound = new NBTTagCompound();
    		is.stackTagCompound.setInteger("charge", 500);
    	}
    	list.add("");
    	list.add(ChatColor.LIGHT_PURPLE + I18n.format("item.description.valanyr") + ChatColor.RESET);
    	list.add(ChatColor.LIGHT_PURPLE + "Charge: " + is.stackTagCompound.getInteger("charge") + "/500" + ChatColor.RESET);
    }

    /**
     * Called whenever this item is equipped and the right mouse button is pressed. Args: itemStack, world, entityPlayer
     */
    public ItemStack onItemRightClick(ItemStack is, World w, EntityPlayer e)
    {
    	int charge;
    	
    	charge = is.stackTagCompound.getInteger("charge");
    	if (charge == 500)
    	{
    		is.stackTagCompound.setInteger("charge", 0);
    		e.setAbsorptionAmount(4.0f);
    		
    		Random rand;
    		float a;
    		float b;
    		float c;
    		
    		rand = w.rand;
    		for (int i = 0; i < 60; i++)
    		{
    			a = rand.nextInt(2) == 0 ? rand.nextFloat() : -rand.nextFloat();
    			b = rand.nextInt(2) == 0 ? rand.nextFloat() : -rand.nextFloat();
    			c = rand.nextInt(2) == 0 ? rand.nextFloat() : -rand.nextFloat();
    			w.spawnParticle("fireworksSpark", e.posX, e.posY, e.posZ, a, b, c);
    		}
    	}    	
    	return (super.onItemRightClick(is, w, e));
    }
}
