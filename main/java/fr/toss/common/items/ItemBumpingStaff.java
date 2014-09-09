package fr.toss.common.items;

import java.util.List;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fr.toss.common.command.ChatColor;

public class ItemBumpingStaff extends ItemSwordM {

	public ItemBumpingStaff(ToolMaterial material)
	{
		super(material);
		this.setManaRegen(5);
		this.setTextureName("magiccrusade:batonDiamant");
		this.setUnlocalizedName("baton_bumping");
		this.setHasEffect();
	}
	
	 /**
     * allows items to add custom lines of information to the mouseover description
     */
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack item, EntityPlayer player, List list, boolean bool)
    {
    	list.add(ChatColor.LIGHT_PURPLE + "Bump your target away." + ChatColor.RESET);
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
    		e.motionX += player.getLookVec().xCoord * 3;
    		e.motionY += 1.5f;
    		e.motionZ += player.getLookVec().zCoord * 3;

        	is.damageItem(10, player);
    	}
    	return super.onItemRightClick(is, world, player);
    }

}
