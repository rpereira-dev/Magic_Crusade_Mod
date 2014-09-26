package fr.toss.common.items;

import java.util.List;

import net.minecraft.client.resources.I18n;
import net.minecraft.entity.Entity;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fr.toss.common.command.ChatColor;
import fr.toss.common.register.EnumMaterial;

public class ItemLameTonerre extends ItemSwordM {
	
	public ItemLameTonerre()
	{
		super(EnumMaterial.TOOL_EPIC);
		this.hasEffect = true;
		this.setTextureName("magiccrusade:lame_tonerre");
		this.setUnlocalizedName("lame_tonerre");
		this.setAgility(40.0f);
	}
	
	@Override
	public void onCreated(ItemStack is, World w, EntityPlayer p)
	{
		is.stackTagCompound = new NBTTagCompound();
		is.stackTagCompound.setInteger("charge", 500);
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
		    		is.stackTagCompound.setInteger("charge", charge + 1);
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
    	list.add(ChatColor.LIGHT_PURPLE + I18n.format("item.description.lame_tonerre") + ChatColor.RESET);
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
    		w.spawnEntityInWorld(new EntityLightningBolt(w, e.posX - 4, e.posY, e.posZ - 4));
    		w.spawnEntityInWorld(new EntityLightningBolt(w, e.posX + 4, e.posY, e.posZ - 4));
    		w.spawnEntityInWorld(new EntityLightningBolt(w, e.posX + 4, e.posY, e.posZ + 4));
    		w.spawnEntityInWorld(new EntityLightningBolt(w, e.posX - 4, e.posY, e.posZ + 4));
    	}    	
    	return (super.onItemRightClick(is, w, e));
    }
}
