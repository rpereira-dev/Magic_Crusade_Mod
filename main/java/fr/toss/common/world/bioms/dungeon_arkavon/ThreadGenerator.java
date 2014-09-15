package fr.toss.common.world.bioms.dungeon_arkavon;

import java.util.Random;

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
		System.out.println("Generation starting");
		long time;
		
		time = System.currentTimeMillis();
		this.world_gen.generate(world, rand, x, y, z);
		
		System.out.println("Endded, Taken: " + ((System.currentTimeMillis() - time) / 1000.0f) + " seconds");
	}

}
