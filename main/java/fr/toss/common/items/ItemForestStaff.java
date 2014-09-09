package fr.toss.common.items;

import java.util.List;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fr.toss.common.command.ChatColor;

public class ItemForestStaff extends ItemSwordM {

	public ItemForestStaff(ToolMaterial material)
	{
		super(material);
		this.setClarity(20.0f);
		this.setManaRegen(2);
		this.setTextureName("magiccrusade:batonElfique");
		this.setUnlocalizedName("baton_elfique");
		this.setHasEffect();

	}
	
	 /**
     * allows items to add custom lines of information to the mouseover description
     */
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack item, EntityPlayer player, List list, boolean bool)
    {
    	list.add(ChatColor.LIGHT_PURPLE + "Imprison your target into a leaves cage" + ChatColor.RESET);
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
    		for (int i = 0; i < 6; i++)
    		{
        		for (int j = 0; j < 6; j++)
        		{
            		for (int k = 0; k < 6; k++)
            		{
            			if (i == 0 || i == 5 || j == 0 || j == 5 || k == 0 || k == 5)
            				world.setBlock((int) e.posX - 3 + i, (int) e.posY - 2 + j, (int)  e.posZ + k - 3, Blocks.leaves);
            		}
        		}
    		}
    		
        	is.damageItem(10, player);
    	}
    	return super.onItemRightClick(is, world, player);
    }

}
