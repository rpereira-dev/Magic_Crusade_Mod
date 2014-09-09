package fr.toss.common.world.bioms.dungeon_arkavon;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class WorldGeneratorM extends WorldGenerator {

	@Override
	public boolean generate(World w, Random r, int x, int y, int z)
	{
		return false;
	}
	
	public void genBloc(World world, Block block, Cube cube)
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
	
	public void genBlocVide(World world, Block block, Cube cube)
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
	
	
	public void genBlockVideNoBaseWithPorte(World world, Block block, Cube cube)
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
	
	
	public void genBlockVideNoBase(World world, Block block, Cube cube)
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