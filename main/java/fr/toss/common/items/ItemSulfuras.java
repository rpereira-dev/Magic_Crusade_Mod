package fr.toss.common.items;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import fr.toss.common.register.EnumMaterial;

public class ItemSulfuras extends ItemSwordM {

	public ItemSulfuras()
	{
		super(EnumMaterial.TOOL_EPIC);
		this.setStrenght(50.0f);
		this.setTextureName("magiccrusade:Sulfuras");
		this.setUnlocalizedName("sulfuras");
		this.setHasEffect();

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
    		world.setBlock((int) e.posX, (int) e.posY - 1, (int)  e.posZ, Blocks.fire);
    	}

    	return super.onItemRightClick(is, world, player);
    }

}
