package fr.toss.common.items;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import fr.toss.common.world.bioms.dungeon_arkavon.ThreadGenerator;

public class ItemArkavonLoader extends Item {
	
	
    public ItemStack onItemRightClick(ItemStack i, World w, EntityPlayer p)
    {
    	if (!w.isRemote)
    	{
			i.stackSize = 0;
			
	        int x = (int) p.posX;
	        int y = (int) p.posY;
	        int z = (int) p.posZ;
	        ThreadGenerator thread = new ThreadGenerator(w, w.rand, x, y, z);
	        thread.start();
    	}
        
		return (super.onItemRightClick(i, w, p));
	}

}
