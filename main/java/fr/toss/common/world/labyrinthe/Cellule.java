package fr.toss.common.world.labyrinthe;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.chunk.Chunk;


public class Cellule {
	
	Cellule					previous;
	boolean					visited;
	int						x;
	int						z;
	Labyrinthe				labyrinthe;
	public int				doors[];
	public List<Direction>	possibilities;

	
	public			Cellule(Labyrinthe lab, int X, int Z)
	{
		this.previous = null;
		this.visited = false;
		this.x = X;
		this.z = Z;
		this.labyrinthe = lab;
		this.doors = new int[4];
		for (int i = 0; i < 4; i++)
			this.doors[i] = 1;
		this.load_possibilities();
	}

	public void		load_possibilities()
	{
		this.possibilities = new ArrayList<Direction>();
		this.possibilities.add(Direction.BAS);
		this.possibilities.add(Direction.HAUT);
		this.possibilities.add(Direction.DROITE);
		this.possibilities.add(Direction.GAUCHE);

	}
	
	/** Ouvres la cellule et renvoie la suivante */
	public Cellule	open()
	{
		System.out.println("Oppening: " + this.x + " - " + this.z);		

		this.visited = true;

		for (int i = this.possibilities.size() - 1 ; i >= 0 ; i--)
		{
			Direction d;
			Cellule voisin;
			
			d = this.possibilities.get(i);
			try
			{
				voisin = this.labyrinthe.cellules[this.x + d.x][this.z + d.z];
				System.out.println("Voisin: " + voisin.x + " - " + voisin.z + " Visited: " + voisin.visited);
				if (voisin.visited)
					this.possibilities.remove(d);
			} catch (ArrayIndexOutOfBoundsException e) {
				this.possibilities.remove(d);
			}
		}
		
		if (this.possibilities.size() > 0)
		{
			Direction d;
						
			
			for (Direction de : this.possibilities)
				System.out.println("Possible: " + de.toString());
			
			d = this.possibilities.get(this.labyrinthe.random.nextInt(this.possibilities.size())); //this.possibilities aléatoire parmi celle dispo
			System.out.println("possibility taken: " + d.toString() + " - " + d.getId());
			this.possibilities.remove(d);
			this.doors[d.getId()] = 0;
			this.labyrinthe.cellules[x + d.x][z + d.z].doors[d.get_opposite().getId()] = 0;
			this.labyrinthe.cellules[x + d.x][z + d.z].previous = this.labyrinthe.cellules[x][z];
			return (this.labyrinthe.cellules[x + d.x][z + d.z]);
		}
		else
		{
			System.out.println("Returned previous: " + this.previous.x + " - " + this.previous.z);
			if (this.labyrinthe.x_arrive == -1 && this.labyrinthe.z_arrive == -1)
			{
				this.labyrinthe.x_arrive = this.x;
				this.labyrinthe.z_arrive = this.z;
			}
			return (this.previous);
		}
	}


	/** Generes la cellule */
	public void generate(World world, int x, int y, int z)
	{
		Block block;
		int X;
		int Z;
		int cellule_size;
		int cellule_hauteur;
		
		cellule_size = this.labyrinthe.cellule_size + 2;
		cellule_hauteur = this.labyrinthe.cellule_height;
		X = x + this.z * cellule_size;
		Z = z + this.x * cellule_size;

		if (this.labyrinthe.gen_chest && this.labyrinthe.random.nextInt(this.labyrinthe.size * this.labyrinthe.size / 2) == 0)
			this.generate_chest(world, X, y, Z, cellule_size, cellule_hauteur);
		this.generate_ground(world, X, y, Z, cellule_size, cellule_hauteur);
		this.generate_walls(world, X, y, Z, cellule_size, cellule_hauteur);
	}

	/** Generes le sol de la cellule */
	void generate_chest(World world, int x, int y, int z, int cellule_size, int cellule_hauteur)
	{
		
		
	}
	
	
	/** Generes le sol de la cellule */
	void generate_ground(World world, int X, int y, int Z, int cellule_size, int cellule_hauteur)
	{
		Block block;
		
		block = (this.x == this.labyrinthe.x_depart && this.z == this.labyrinthe.z_depart) ? this.labyrinthe.block_spawn
				: (this.x == this.labyrinthe.x_arrive && this.z == this.labyrinthe.z_arrive) ? this.labyrinthe.block_arrive
					: this.labyrinthe.block_ground;

		for (int i = 0; i < cellule_size; i++)
			for (int j = 0; j < cellule_size; j++)
				this.setBlock(X + i, y - 1, Z + j, block);
	}
	
	/** Generes les murs des cellules (en fonction de si la cellule a été ouverte ou non */
	void generate_walls(World world, int X, int y, int Z, int cellule_size, int cellule_hauteur)
	{
		if (this.doors[0] != 0) //gauche
			for (int h = 0; h < cellule_hauteur; h++)
				for (int j = 0; j < cellule_size; j++)
					this.setBlock(X + j, y + h, Z, Blocks.bedrock);
		
		if (this.doors[1] != 0) //droite
			for (int h = 0; h < cellule_hauteur; h++)
				for (int j = 0; j < cellule_size; j++)
					this.setBlock(X + j, y + h, Z + cellule_size - 1, Blocks.bedrock);
			
		if (this.doors[2] != 0) //bas
			for (int h = 0; h < cellule_hauteur; h++)
				for (int j = 0; j < cellule_size; j++)
					this.setBlock(X, y + h, Z + j, Blocks.bedrock);
			
		if (this.doors[3] != 0) //haut
			for (int h = 0; h < cellule_hauteur; h++)
				for (int j = 0; j < cellule_size; j++)
					this.setBlock(X + cellule_size - 1, y + h, Z + j, Blocks.bedrock);
	}	
	
	
	public void setBlock(int x, int y, int z, Block block)
	{
		this.labyrinthe.world.setBlock(x, y, z, block);
	}
}