package fr.toss.common.world.bioms.deco;

import java.util.Random;

import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class ThreadGenerator extends Thread implements Runnable {
	
	WorldGenerator world_gen;
	World world;
	int x;
	int y;
	int z;
	Random rand;
	
	public ThreadGenerator(WorldGenerator w, World wo, Random r, int x, int y, int z)
	{
		this.setName("Generator " + this.getId());
		this.world_gen = w;
		this.world = wo;
		this.x = x;
		this.y = y;
		this.z = z;
		this.rand = r;
	}
	
	@Override
	public void		run()
	{
		System.out.println("Generation starting");
		long time = System.currentTimeMillis();
	
		if (this.world != null)
			this.world_gen.generate(world, rand, x, y, z);
		
		System.out.println("Endded, Taken: " + ((System.currentTimeMillis() - time) / 1000.0f) + " seconds");
	}

}
