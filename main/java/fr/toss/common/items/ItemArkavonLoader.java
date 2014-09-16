package fr.toss.common.items;

import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fr.toss.common.world.bioms.dungeon_arkavon.ThreadGenerator;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.World;

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
