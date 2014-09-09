package fr.toss.common.items;

import java.util.List;

import net.minecraft.entity.Entity;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fr.toss.common.command.ChatColor;

public class ItemLightningStaff extends ItemSwordM {

	public ItemLightningStaff(ToolMaterial material)
	{
		super(material);
		this.setClarity(30.0f);
		this.setTextureName("magiccrusade:batonOr");
		this.setUnlocalizedName("baton_lightning");
		this.setHasEffect();

	}
	
	 /**
     * allows items to add custom lines of information to the mouseover description
     */
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack item, EntityPlayer player, List list, boolean bool)
    {
    	list.add(ChatColor.LIGHT_PURPLE + "Spawn a Lightning bolt to your target" + ChatColor.RESET);
    	super.addInformation(item, player, list, bool);
    }
    
    /**
     * Called whenever this item is equipped and the right mouse button is pressed. Args: itemStack, world, entityPlayer
     */
    public ItemStack onItemRightClick(ItemStack is, World world, EntityPlayer player)
    {
    	Entity e;
    	
    	e = this.getLookingEntity(player, 20.0d);
    	if (e != null)
    	{
    		EntityLightningBolt b;
    		
    		b = new EntityLightningBolt(world, e.posX, e.posY, e.posZ);
    		world.spawnEntityInWorld(b);
        	is.damageItem(10, player);
    	}
    	return super.onItemRightClick(is, world, player);
    }

}
