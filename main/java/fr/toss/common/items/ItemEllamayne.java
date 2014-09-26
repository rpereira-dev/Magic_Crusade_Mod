package fr.toss.common.items;

import java.util.List;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fr.toss.common.command.ChatColor;
import fr.toss.common.register.EnumMaterial;

public class ItemEllamayne extends ItemSwordM {

	public ItemEllamayne()
	{
		super(EnumMaterial.TOOL_ZERO);
		this.setTextureName("magiccrusade:Ellamayne");
		this.setUnlocalizedName("ellamayne");
		this.setHasEffect();
		this.setManaRegen(5);
	}
	
    /**
     * Called whenever this item is equipped and the right mouse button is pressed. Args: itemStack, world, entityPlayer
     */
    public ItemStack onItemRightClick(ItemStack is, World w, EntityPlayer p)
    {
    	return (super.onItemRightClick(is, w, p));
    }
    
	 /**
     * allows items to add custom lines of information to the mouseover description
     */
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack item, EntityPlayer player, List list, boolean bool)
    {
    	if (!item.isItemEnchanted())
    		item.addEnchantment(Enchantment.smite, 4);
    	list.add(ChatColor.LIGHT_PURPLE + "This item heal your target." + ChatColor.RESET);
    	super.addInformation(item, player, list, bool);
    }
    
    
	@Override
    public boolean hitEntity(ItemStack is, EntityLivingBase entity, EntityLivingBase player)
    {		
    	if (entity != null)
    	{
    		entity.heal(4.0f);
    		entity.addPotionEffect(new PotionEffect(Potion.regeneration.id, 40, 1));
    	}
		return (true);
	}
}
