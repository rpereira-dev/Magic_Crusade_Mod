package fr.toss.common.items;

import java.util.List;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fr.toss.common.command.ChatColor;
import fr.toss.common.register.EnumMaterial;

public class ItemAshbringer extends ItemSwordM {

	public ItemAshbringer()
	{
		super(EnumMaterial.TOOL_EPIC);
		this.setTextureName("magiccrusade:ashbringer");
		this.setUnlocalizedName("ashbringer");
		this.setHasEffect();
		this.setClarity(40.0f);
		this.setManaRegen(1);
	}
	
	 /**
     * allows items to add custom lines of information to the mouseover description
     */
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack item, EntityPlayer player, List list, boolean bool)
    {
    	list.add(ChatColor.LIGHT_PURPLE + "This dagger has a slow effect." + ChatColor.RESET);
    	super.addInformation(item, player, list, bool);
    }
    
    
	@Override
    public boolean hitEntity(ItemStack is, EntityLivingBase entity, EntityLivingBase player)
    {
		super.hitEntity(is, entity, player);
		
    	if (entity != null)
    	{
    		entity.addPotionEffect(new PotionEffect(Potion.moveSlowdown.id, 60, 0));
    	}
		return (true);
	}
}
