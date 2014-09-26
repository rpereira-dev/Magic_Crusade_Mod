package fr.toss.common.items;

import java.util.List;

import net.minecraft.client.resources.I18n;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fr.toss.common.command.ChatColor;
import fr.toss.common.register.EnumMaterial;

public class ItemFaux extends ItemSwordM {

	public ItemFaux()
	{
		super(EnumMaterial.TOOL_EPIC);
		this.setTextureName("magiccrusade:faux");
		this.setUnlocalizedName("faux");
		this.setHasEffect();
		this.setAgility(-20.0f);
		this.setClarity(-20.0f);
	}
	
	 /**
     * allows items to add custom lines of information to the mouseover description
     */
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack item, EntityPlayer player, List list, boolean bool)
    {
		list.add(ChatColor.RED + "- " + this.agility + " Stamina");
		list.add(ChatColor.RED + "- " + this.clarity + " Clarity");
		list.add(" ");
    	list.add(ChatColor.LIGHT_PURPLE + I18n.format("item.description.faux") + ChatColor.RESET);
    }
    
    
	@Override
    public boolean hitEntity(ItemStack is, EntityLivingBase entity, EntityLivingBase player)
    {		
		player.heal(2.0f);

		return super.hitEntity(is, entity, player);
	}
}
