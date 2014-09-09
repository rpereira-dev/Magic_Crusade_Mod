package fr.toss.common.world.labyrinthe;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;

public class Labyrinthe {
	
	Random	random;
	Cellule	cellules[][];
	int		size;
	int		cellule_size;
	int		cellule_height;
	
	public Labyrinthe(int seed, int p_size, int c_size, int c_height)
	{
		this.size = p_size;
		this.cellule_size = c_size;
		this.cellule_height = c_height;
		this.random = new Random(seed);
		this.cellules = new Cellule[size][size];
		this.init();
	}
	
	void init()
	{
		int i;
		int j;
		
		i = 0;
		while (i < this.size)
		{
			j = 0;
			while (j < this.size)
			{
				this.cellules[i][j] = new Cellule(this, i, j);
				j++;
			}
			i++;
		}
	}

	public void generate(World w, int x, int y, int z)
	{
		System.out.println("Generation starting");
		int i;
		int j;
		
		i = 0;
		while (i < this.size)
		{
			j = 0;
			while (j < this.size)
			{
				this.cellules[i][j].generate(w, x, y, z, this.cellule_size + 2, this.cellule_height);
				j++;
			}
			i++;
		}
		System.out.println("Endded");
	}

	public void solve()
	{		
		Cellule cellule;
		int i;
		
		cellule = this.cellules[0][0];
		cellule.previous = null;
		cellule = cellule.open();
		while ((cellule = cellule.open()) != this.cellules[0][0]);
	}
}