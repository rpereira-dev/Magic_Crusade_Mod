package fr.toss.common.world.bioms.dungeon_arkavon;

import java.util.Random;

import fr.toss.common.Main;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ChatComponentText;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class ThreadGenerator extends Thread implements Runnable {
	
	WorldGenerator world_gen;
	World world;
	Random rand;
	int x;
	int y;
	int z;
	
	public ThreadGenerator(World world, Random rand, int x, int y, int z)
	{
		this.world = world;
		this.rand = rand;
		this.x = x;
		this.y = y;
		this.z = z;
		this.world_gen = new WorldGenArkavon();
	}
	
	@Override
	public void		run()
	{		
    	for (Object p : this.world.playerEntities)
    		((EntityPlayer)p).addChatMessage(new ChatComponentText("Arkavon entrance is loading, you should pause your game and wait a minute or two (lag expected)"));
    	
    	long time;
    	
		time = System.currentTimeMillis();
		try {
			this.world_gen.generate(world, rand, x, y, z);
		} catch (Exception e)
		{
			e.printStackTrace();
	    	for (Object p : this.world.playerEntities)
	    		((EntityPlayer)p).addChatMessage(new ChatComponentText("Arkavon entrance couldn't be created. Tell the administrator to remove world/DIM-" + Main.DIM_ID + " folder"));
		}
		
    	for (Object p : this.world.playerEntities)
    		((EntityPlayer)p).addChatMessage(new ChatComponentText("Arkavon entrance is created. Taken: " + ((System.currentTimeMillis() - time) / 1000.0f) + " seconds"));
	}

}
