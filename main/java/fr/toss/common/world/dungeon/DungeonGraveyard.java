package fr.toss.common.world.dungeon;

import net.minecraft.entity.Entity;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.monster.EntitySpider;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.world.World;
import fr.toss.common.Main;
import fr.toss.common.entity.EntityChevalier;
import fr.toss.common.entity.EntityCrocotta;
import fr.toss.common.entity.EntityHaunter;
import fr.toss.common.entity.EntityVillagerDim;

public class DungeonGraveyard extends Dungeon {
	
	public DungeonGraveyard()
	{
		super("graveyard_dungeon", "Graveyard", 1, Main.DIM_ID, 113, 83, 264);
	}
	
	@Override
	public void spawn_entities(World world)
	{
		Entity e;

		for (int i = 0; i < 4; i++)
		{
			e = new EntityVillagerDim(world);
			e.setLocationAndAngles(72, 84, 253 + i, 0, 0);
			world.spawnEntityInWorld(e);
			
			e = new EntityVillagerDim(world);
			e.setLocationAndAngles(86 - i, 84, 264, 0, 0);
			world.spawnEntityInWorld(e);
			
			e = new EntityVillagerDim(world);
			e.setLocationAndAngles(72, 84, 269 + i, 0, 0);
			world.spawnEntityInWorld(e);
			
			e = new EntityVillagerDim(world);
			e.setLocationAndAngles(64 - i, 84, 264, 0, 0);
			world.spawnEntityInWorld(e);
		}
		
		for (int i = 0; i < 12; i++)
		{
			e = new EntityZombie(world);
			e.setLocationAndAngles(108, 83, 264, 0, 0);
			world.spawnEntityInWorld(e);
			
			e = new EntityZombie(world);
			e.setLocationAndAngles(33, 83, 244, 0, 0);
			world.spawnEntityInWorld(e);
		}
		
		for (int i = 0; i < 8; i++)
		{
			e = new EntityCrocotta(world);
			e.setLocationAndAngles(32, 83, 280, 0, 0);
			world.spawnEntityInWorld(e);
		}
		
		for (int i = 0; i < 4; i++)
		{
			e = new EntityHaunter(world);
			e.setLocationAndAngles(53, 83, 237, 0, 0);
			world.spawnEntityInWorld(e);
			
			e = new EntityHaunter(world);
			e.setLocationAndAngles(84, 83, 25, 0, 0);
			world.spawnEntityInWorld(e);
			
			e = new EntitySkeleton(world);
			e.setLocationAndAngles(94, 83, 244, 0, 0);
			world.spawnEntityInWorld(e);
			
			e = new EntitySkeleton(world);
			e.setLocationAndAngles(107, 82, 267, 0, 0);
			world.spawnEntityInWorld(e);
		}
		
		
		for (int i = 0; i < 8; i++)
		{
			e = new EntityHaunter(world);
			e.setLocationAndAngles(106, 83, 287, 0, 0);
			world.spawnEntityInWorld(e);
			
			e = new EntityZombie(world);
			e.setLocationAndAngles(43, 83, 283, 0, 0);
			world.spawnEntityInWorld(e);
			
			e = new EntitySpider(world);
			e.setLocationAndAngles(60, 84, 240, 0, 0);
			world.spawnEntityInWorld(e);
		}
		
		e = new EntityChevalier(world);
		e.setLocationAndAngles(44, 84, 264, 0, 0);
		world.spawnEntityInWorld(e);
		
		for (int i = 0; i < 3; i++)
		{
			e = new EntityHaunter(world);
			e.setLocationAndAngles(43, 84, 264, 0, 0);
			world.spawnEntityInWorld(e);
		}
	}
	
	@Override
	public void despawn_entities(World world)
	{
		super.reset_entities(world, 512, 512);
	}

}
