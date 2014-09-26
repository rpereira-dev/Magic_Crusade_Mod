package fr.toss.common.items;

import java.util.List;

import net.minecraft.client.resources.I18n;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fr.toss.common.command.ChatColor;
import fr.toss.common.entity.EntityHaunter;
import fr.toss.common.register.EnumMaterial;

public class ItemShadowmourne extends ItemSwordM {

	public ItemShadowmourne()
	{
		super(EnumMaterial.TOOL_EPIC);
		this.setTextureName("magiccrusade:shadowmourne");
		this.setUnlocalizedName("shadowmourne");
		this.setHasEffect();
		this.setStrenght(60.0f);
	}
	
	 /**
     * allows items to add custom lines of information to the mouseover description
     */
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack item, EntityPlayer player, List list, boolean bool)
    {
    	super.addInformation(item, player, list, bool);
    	list.add(" ");
    	list.add(ChatColor.LIGHT_PURPLE + I18n.format("item.description.shadowmourne") + ChatColor.RESET);

    }
    
    
	@Override
    public boolean hitEntity(ItemStack is, EntityLivingBase entity, EntityLivingBase player)
    {
		return (super.hitEntity(is, entity, player));
	}
}
