package fr.toss.common.world.labyrinthe;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;


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
			return (this.previous);
		}
	}


	public void generate(World world, int x, int y, int z, int cellule_size, int cellule_hauteur)
	{
		if (this.doors[0] != 0) //gauche
			for (int h = 0; h < cellule_hauteur; h++)
				for (int j = 0; j < cellule_size; j++)
					world.setBlock(x + this.z * cellule_size + j, y + h, z + this.x * cellule_size, Blocks.bedrock);
		
		if (this.doors[1] != 0) //droite
			for (int h = 0; h < cellule_hauteur; h++)
				for (int j = 0; j < cellule_size; j++)
					world.setBlock(x + this.z * cellule_size + j, y + h, z + this.x * cellule_size + cellule_size - 1, Blocks.bedrock);
			
		if (this.doors[2] != 0) //bas
			for (int h = 0; h < cellule_hauteur; h++)
				for (int j = 0; j < cellule_size; j++)
					world.setBlock(x + this.z * cellule_size, y + h, z + this.x * cellule_size + j, Blocks.bedrock);
			
		if (this.doors[3] != 0) //haut
			for (int h = 0; h < cellule_hauteur; h++)
				for (int j = 0; j < cellule_size; j++)
					world.setBlock(x + this.z * cellule_size + cellule_size - 1, y + h, z + this.x * cellule_size + j, Blocks.bedrock);
	}	
}