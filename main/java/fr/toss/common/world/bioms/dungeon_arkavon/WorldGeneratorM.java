package fr.toss.common.world.bioms.dungeon_arkavon;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;
import fr.toss.common.register.ItemRegister;

public class WorldGeneratorM extends WorldGenerator {

	@Override
	public boolean	generate(World w, Random r, int x, int y, int z)
	{
		return false;
	}
	
	public void		genBloc(World world, Block block, Cube cube)
	{
		for (int i = 0; i < cube.vec.x; i++)
		{
			for (int j = 0; j < cube.vec.y; j++)
			{
				for (int k = 0; k < cube.vec.z; k++)
				{
					world.setBlock(cube.origine.x + i, cube.origine.y + j, cube.origine.z + k,  block);
				}
			}
		}
	}
	
	
	public void		spawn_random_skeleton(World w, Random rand, int x, int y, int z)
	{
		EntitySkeleton	skeleton;
		Item		stuff[];
		skeleton = new EntitySkeleton(w);
		skeleton.setSkeletonType(1);
	
		skeleton.setCurrentItemOrArmor(0, new ItemStack(this.get_random_weapon(rand), 1));
		skeleton.setEquipmentDropChance(0, 0.2f);
		stuff = this.get_random_stuff(rand);
		for (int i = 0; i <  3; i++)
		{
			skeleton.setEquipmentDropChance(i + 1, 0.2f);
			skeleton.setCurrentItemOrArmor(i + 1, new ItemStack(stuff[i], 1));
		}
		skeleton.setPosition(x, y + 2, z);
		w.spawnEntityInWorld(skeleton);
	}
	
	Item[] get_random_stuff(Random rand)
	{
		Item		stuff[];

		stuff = new Item[3];
		switch (rand.nextInt(12))
		{
			case 0 :
				stuff[0] = ItemRegister.wrathful_BOOTS;
				stuff[1] = ItemRegister.wrathful_PANTS;
				stuff[2] = ItemRegister.wrathful_CHESTPLATE;
				break;
				
			case 1 :
				stuff[0] = ItemRegister.lethal_BOOTS;
				stuff[1] = ItemRegister.lethal_PANTS;
				stuff[2] = ItemRegister.lethal_CHESTPLATE;
				break;
				
			case 2 :
				stuff[0] = ItemRegister.baneful_BOOTS;
				stuff[1] = ItemRegister.baneful_PANTS;
				stuff[2] = ItemRegister.baneful_CHESTPLATE;
				break;
				
			case 3 :
				stuff[0] = ItemRegister.DPS_AD_BOOTS[0];
				stuff[1] = ItemRegister.DPS_AD_PANTS[1];
				stuff[2] = ItemRegister.DPS_AD_CHESTPLATE[2];
				break;
				
			case 4 :
				stuff[0] = ItemRegister.HEAL_BOOTS[0];
				stuff[1] = ItemRegister.HEAL_PANTS[1];
				stuff[2] = ItemRegister.HEAL_CHESTPLATE[2];
				break;
				
			case 5 :
				stuff[0] = ItemRegister.TITANIUM_BOOTS;
				stuff[1] = ItemRegister.TITANIUM_PANTS;
				stuff[2] = ItemRegister.TITANIUM_CHESTPLATE;
				break;
				
			case 6 :
				stuff[0] = ItemRegister.ENERGY_BOOTS[0];
				stuff[1] = ItemRegister.ENERGY_PANTS[1];
				stuff[2] = ItemRegister.ENERGY_CHESTPLATE[2];
				break;
				
			case 7 :
				stuff[0] = ItemRegister.TANK_BOOTS[0];
				stuff[1] = ItemRegister.TANK_PANTS[1];
				stuff[2] = ItemRegister.TANK_CHESTPLATE[2];
				break;
				
			case 8 :
				stuff[0] = ItemRegister.ETHERNIUM_BOOTS;
				stuff[1] = ItemRegister.ETHERNIUM_PANTS;
				stuff[2] = ItemRegister.ETHERNIUM_CHESTPLATE;
				break;
				
			case 9 :
				stuff[0] = ItemRegister.SILVER_BOOTS;
				stuff[1] = ItemRegister.SILVER_PANTS;
				stuff[2] = ItemRegister.SILVER_CHESTPLATE;
				break;
				
			case 10 :
				stuff[0] = Items.golden_boots;
				stuff[1] = Items.golden_leggings;
				stuff[2] = Items.golden_chestplate;
				break;
				
			case 11 :
				stuff[0] = ItemRegister.RAGE_BOOTS[0];
				stuff[1] = ItemRegister.RAGE_PANTS[0];
				stuff[2] = ItemRegister.RAGE_CHESTPLATE[0];
				break;

		}
		return (stuff);
	}

	Item get_random_weapon(Random rand)
	{
		switch (rand.nextInt(15))
		{
			case 0 :
				return (ItemRegister.ASHBRINGER_POISON);
				
			case 1 :
				return (ItemRegister.ELLAMAYNE);
				
			case 2 :
				return (ItemRegister.TITANIUM_SWORD);
				
			case 3 :
				return (ItemRegister.STAFF_LIGHTNING);
				
			case 4 :
				return (ItemRegister.wrathful_SWORD);
				
			case 5 :
				return (ItemRegister.baneful_SWORD);
				
			case 6 :
				return (ItemRegister.lethal_SWORD);
				
			case 7 :
				return (ItemRegister.SILVER_HOE);
				
			case 8 :
				return (ItemRegister.TITANIUM_PICKAXE);
				
			case 9 :
				return (ItemRegister.TITANIUM_SHOVEL);
			
			case 10 :
				return (ItemRegister.SILVER_HATCHET);
				
			case 11 :
				return (Items.golden_sword);
				
			case 12 :
				return (ItemRegister.LAME_RUNIQUE);
				
			case 13 :
				return (ItemRegister.STAFF_BUMPING);
				
			case 14 :
				return (ItemRegister.TITANIUM_SHOVEL);
		}
		return null;
	}
	
	
	public int		getTopBlock(World w, int x, int z, int default_y)
	{
        int k;

        for (k = default_y; !w.isAirBlock(x, k + 1, z); ++k)
        {
            ;
        }

        return (k);
	}

	public void		genSphere(World world, Block block, int rayon, int x, int y, int z, float path)
	{
		int x1;
		int y1;
		int z1;
		
		for (float phi = -180; phi < 180; phi += path * 2)
		{
			for (float teta = -90; teta < 90; teta += path)
			{
				x1 = (int) (rayon * MathHelper.cos(teta) * MathHelper.cos(phi));
				y1 = (int) (rayon * MathHelper.cos(teta) * MathHelper.sin(phi));
				z1 = (int) (rayon * MathHelper.sin(teta));
				world.setBlock(x + x1, y + y1, z + z1, block);
			}
		}		
	}
	
	
	public void		genDisque(World world, Block block, int rayon, int x, int y, int z, float path)
	{
		int x1;
		int z1;
		
		for (float phi = -180; phi < 180; phi += path * 2)
		{
			for (float teta = -90; teta < 90; teta += path)
			{
				x1 = (int) (rayon * MathHelper.cos(teta) * MathHelper.cos(phi));
				z1 = (int) (rayon * MathHelper.sin(teta));
				world.setBlock(x + x1, y, z + z1, block);
			}
		}		
	}
	
	public void		genEmptySphere(World world, Block block, int rayon, int x, int y, int z, float path, int min, int max)
	{
		int x1;
		int y1;
		int z1;
		
		for (float phi = -min; phi < max; phi += path)
		{
			for (float teta = -min / 2; teta < min / 2; teta += path)
			{
				x1 = (int) (rayon * MathHelper.cos(teta) * MathHelper.cos(phi));
				y1 = (int) (rayon * MathHelper.cos(teta) * MathHelper.sin(phi) / 2);
				z1 = (int) (rayon * MathHelper.sin(teta));
				world.setBlock(x + x1, y + y1, z + z1, block);
			}
		}		
	}
	
	public void		genCircle(World world, Block block, int rayon, int x, int y, int z, float path)
	{
		int x1;
		int z1;
		
		for (float pi = -180; pi < 180; pi += path)
		{
			x1 = (int) (rayon * MathHelper.cos(pi));
			z1 = (int) (rayon * MathHelper.sin(pi));
			world.setBlock(x + x1, y, z + z1, block);
		}		
	}
	
	
	public void		genTore(World world, Block block, int R, int r, int x, int y, int z, float path)
	{
		
		int x1;
		int y1;
		int z1;
		
		for (float u = -180; u < 180; u += path)
		{
			for (float v = -180; v < 180; v += path)
			{
				x1 = (int) ((R + r * MathHelper.cos(v)) * MathHelper.cos(u));
				y1 = (int) ((R + r * MathHelper.cos(v)) * MathHelper.sin(u));
				z1 = (int) (r * MathHelper.sin(v));
				world.setBlock(x + x1, y + z1, z + y1, block);
			}
		}	
	}
	
	
	
	public void		genBlocVide(World world, Block block, Cube cube)
	{
		for (int i = 0; i < cube.vec.x; i++)
		{
			for (int j = 0; j < cube.vec.y; j++)
			{
				world.setBlock(cube.origine.x + i, cube.origine.y + j, cube.origine.z,  block);
				world.setBlock(cube.origine.x + i, cube.origine.y + j, cube.origine.z + cube.vec.z,  block);
			}
		}
		
		for (int i = 0; i < cube.vec.x; i++)
		{
			for (int j = 0; j < cube.vec.z; j++)
			{
				world.setBlock(cube.origine.x + i, cube.origine.y, cube.origine.z + j,  block);
				world.setBlock(cube.origine.x + i, cube.origine.y + cube.vec.y - 1, cube.origine.z + j,  block);
			}
		}
		
		for (int i = 0; i < cube.vec.z; i++)
		{
			for (int j = 0; j < cube.vec.y; j++)
			{
				world.setBlock(cube.origine.x, cube.origine.y + j, cube.origine.z + i,  block);
				world.setBlock(cube.origine.x + cube.vec.x - 1, cube.origine.y + j, cube.origine.z + i,  block);
			}
		}
	}
	
	
	public void		genBlockVideNoBaseWithPorte(World world, Block block, Cube cube)
	{
		//TODO
		for (int i = 0; i < cube.vec.x; i++)
		{
			for (int j = 0; j < cube.vec.y; j++)
			{
				world.setBlock(cube.origine.x + i, cube.origine.y + j, cube.origine.z,  block);
				world.setBlock(cube.origine.x + i, cube.origine.y + j, cube.origine.z + cube.vec.z,  block);
			}
		}
		
		for (int i = 0; i < cube.vec.x; i++)
		{
			for (int j = 0; j < cube.vec.z; j++)
			{
				world.setBlock(cube.origine.x + i, cube.origine.y + cube.vec.y - 1, cube.origine.z + j,  block);
			}
		}
		
		for (int i = 0; i < cube.vec.z; i++)
		{
			for (int j = 0; j < cube.vec.y; j++)
			{
				world.setBlock(cube.origine.x, cube.origine.y + j, cube.origine.z + i,  block);
				world.setBlock(cube.origine.x + cube.vec.x - 1, cube.origine.y + j, cube.origine.z + i,  block);
			}
		}
	}
	
	
	public void		genBlockVideNoBase(World world, Block block, Cube cube)
	{
		for (int i = 0; i < cube.vec.x; i++)
		{
			for (int j = 0; j < cube.vec.y; j++)
			{
				world.setBlock(cube.origine.x + i, cube.origine.y + j, cube.origine.z,  block);
				world.setBlock(cube.origine.x + i, cube.origine.y + j, cube.origine.z + cube.vec.z,  block);
			}
		}
		
		for (int i = 0; i < cube.vec.x; i++)
		{
			for (int j = 0; j < cube.vec.z; j++)
			{
				world.setBlock(cube.origine.x + i, cube.origine.y + cube.vec.y - 1, cube.origine.z + j,  block);
			}
		}
		
		for (int i = 0; i < cube.vec.z; i++)
		{
			for (int j = 0; j < cube.vec.y; j++)
			{
				world.setBlock(cube.origine.x, cube.origine.y + j, cube.origine.z + i,  block);
				world.setBlock(cube.origine.x + cube.vec.x - 1, cube.origine.y + j, cube.origine.z + i,  block);
			}
		}
	}
}

class Cube
{
	Point origine;
	Vec vec;
	
	public Cube(Point point, Vec vec)
	{
		this.origine = point;
		this.vec = vec;
	}

	public Cube extend(int i, int j, int k)
	{
		return new Cube(new Point(this.origine.x - i / 2, this.origine.y - i / 2, this.origine.z - i / 2), new Vec(this.vec.x + i, this.vec.y + j, this.vec.z + k));
	}
}

class Point
{
	int x;
	int y;
	int z;
	
	public Point(int x, int y, int z)
	{
		this.x = x;
		this.y = y;
		this.z = z;
	}
}

class Vec
{
	int x;
	int y;
	int z;
	
	public Vec(int x, int y, int z)
	{
		this.x = x;
		this.y = y;
		this.z = z;
	}
}