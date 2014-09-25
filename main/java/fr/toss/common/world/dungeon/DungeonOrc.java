package fr.toss.common.world.dungeon;

import net.minecraft.entity.Entity;
import net.minecraft.entity.monster.EntitySilverfish;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.monster.EntityWitch;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.world.World;
import fr.toss.common.entity.EntityBossOrc;
import fr.toss.common.entity.EntityLibellule;
import fr.toss.common.entity.EntityMageOrc;
import fr.toss.common.entity.EntityOrc;

public class DungeonOrc extends Dungeon {
	
	public DungeonOrc()
	{
		super("orc_dungeon", "Orcs Entrance", 0, 0, 81, 66, -9); //0 = Dungeon Orc, 0 = Overworld
	}
	
	@Override
	public void spawn_entities(World world)
	{
		Entity e;
		
		for (int i = 0; i < 5; i++)
		{
			e = new EntityOrc(world);
			e.setLocationAndAngles(69, 63, -11 + i, 0, 0);
			world.spawnEntityInWorld(e);
		}
		
		e = new EntityWitch(world);
		e.setLocationAndAngles(69, 63, -9, 0, 0);
		world.spawnEntityInWorld(e);
		
		for (int i = 0; i < 5; i++)
		{
			e = new EntityOrc(world);
			e.setLocationAndAngles(54 - i, 63, -11 + i, 0, 0);
			world.spawnEntityInWorld(e);
		}
		
		for (int i = 0; i < 6; i++)
		{
			e = new EntitySilverfish(world);
			e.setLocationAndAngles(42 - i, 61, -4 + i, 0, 0);
			world.spawnEntityInWorld(e);
		}
		
		for (int i = 0; i < 3; i++)
		{
			e = new EntityOrc(world);
			e.setLocationAndAngles(12 - i, 64, -3 + i, 0, 0);
			world.spawnEntityInWorld(e);
		}
		
		e = new EntityMageOrc(world);
		e.setLocationAndAngles(3, 64, 0, 0, 0);
		world.spawnEntityInWorld(e);

		e = new EntityMageOrc(world);
		e.setLocationAndAngles(3, 64, -7, 0, 0);
		world.spawnEntityInWorld(e);
		
		for (int i = 0; i < 12; i++)
		{
			if (i % 2 == 0)
			{
				e = new EntityLibellule(world);
				e.setLocationAndAngles(-10 - i, 65, 1, 0, 0);
				world.spawnEntityInWorld(e);
			}
			e = new EntityOrc(world);
			e.setLocationAndAngles(-10 - i, 65, 1, 0, 0);
			world.spawnEntityInWorld(e);
		}
		
		for (int i = 0; i < 8; i++)
		{
			e = new EntityOrc(world);
			e.setLocationAndAngles(-15 - i, 71, 20, 0, 0);
			world.spawnEntityInWorld(e);
		}

		for (int i = 0; i < 8; i++)
		{
			e = new EntitySilverfish(world);
			e.setLocationAndAngles(-32 - i, 76, 23, 0, 0);
			world.spawnEntityInWorld(e);
		}
		
		for (int i = 0; i < 4; i++)
		{
			e = new EntitySilverfish(world);
			e.setLocationAndAngles(-57, 59, -1, 0, 0);
			world.spawnEntityInWorld(e);
		}
		
		for (int i = 0; i < 4; i++)
		{
			e = new EntityZombie(world);
			e.setLocationAndAngles(-46, 59, 1, 0, 0);
			world.spawnEntityInWorld(e);
		}
		
		for (int i = 0; i < 6; i++)
		{
			e = new EntitySkeleton(world);
			e.setLocationAndAngles(-51, 72, 6 - i, 0, 0);
			world.spawnEntityInWorld(e);
		}
		
		for (int i = 0; i < 6; i++)
		{
			e = new EntitySkeleton(world);
			e.setLocationAndAngles(-68, 72, 6 - i, 0, 0);
			world.spawnEntityInWorld(e);
		}
		
		for (int i = 0; i < 6; i++)
		{
			e = new EntityOrc(world);
			e.setLocationAndAngles(-68, 65, 6 - i, 0, 0);
			world.spawnEntityInWorld(e);
		}
		
		e = new EntityWitch(world);
		e.setLocationAndAngles(-47, 59, 1, 0, 0);
		world.spawnEntityInWorld(e);
		
		for (int i = 0; i < 6; i++)
		{
			e = new EntityOrc(world);
			e.setLocationAndAngles(-21 - i, 68, -19, 0, 0);
			world.spawnEntityInWorld(e);
		}
		
		e = new EntityMageOrc(world);
		e.setLocationAndAngles(-38, 65, 0, 0, 0);
		world.spawnEntityInWorld(e);
		
		e = new EntityBossOrc(world);
		e.setLocationAndAngles(-56, 65, 0, 0, 0);
		world.spawnEntityInWorld(e);
	}
	
	@Override
	public void despawn_entities(World world)
	{
		super.reset_entities(world, 512, 128);
	}

}
