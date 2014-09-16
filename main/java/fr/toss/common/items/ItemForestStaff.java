package fr.toss.common.items;

import java.util.List;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;
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
    		int x1;
    		int y1;
    		int z1;
    		int rayon = 8;
    		
    		for (float phi = -180; phi < 180; phi += 1)
    		{
    			for (float teta = -90; teta < 90; teta += 0.5f)
    			{
    				x1 = (int) (rayon * MathHelper.cos(teta) * MathHelper.cos(phi));
    				y1 = (int) (rayon * MathHelper.cos(teta) * MathHelper.sin(phi));
    				z1 = (int) (rayon * MathHelper.sin(teta));
    	    		world.setBlock((int) e.posX + x1, (int) e.posY - y1, (int)  e.posZ + z1, Blocks.leaves);
    			}
    		}	
    		    		
        	is.damageItem(10, player);
    	}
    	return super.onItemRightClick(is, world, player);
    }

}
