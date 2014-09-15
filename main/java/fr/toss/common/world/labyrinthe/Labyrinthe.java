package fr.toss.common.world.labyrinthe;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;

public class Labyrinthe {
	
	Random	random;
	
	/** tableaus des cellules */
	Cellule	cellules[][];
	
	/** Différents blocks composants le lab */
	Block 	block_arrive;
	Block	block_ground;
	Block	block_spawn;
	
	/** Localisation du labyrinthe */
	World	world;
	int		x;
	int		y;
	int		z;
	
	/** infos sur la taille du lab */
	int		size;
	int		cellule_size;
	int		cellule_height;
	
	/** Coordonnées de départ et d'arrivé */
	int		x_depart;
	int		z_depart;
	int		x_arrive;
	int		z_arrive;

	/** Si la generation des coffres est activé */
	boolean gen_chest;
	
	public Labyrinthe(World w, int p_x, int p_y, int p_z, long seed, int p_size, int c_size, int c_height)
	{
		this.world = w;
		this.x = p_x;
		this.y = p_y;
		this.z = p_z;
		this.size = p_size;
		this.cellule_size = c_size;
		this.cellule_height = c_height;
		this.random = new Random(seed);
		this.cellules = new Cellule[size][size];
		this.x_depart = random.nextInt(this.size);
		this.z_depart = random.nextInt(this.size);
		this.init();
		this.block_ground = Blocks.stone;
		this.block_spawn = Blocks.glowstone;
		this.block_arrive = Blocks.gold_block;
		this.x_arrive = -1;
		this.z_arrive = -1;
		this.gen_chest = true;
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

	public void generate()
	{
		ThreadGenerator thread;
		
		thread = new ThreadGenerator(this);
		thread.start();
	}
	
	public void solve()
	{		
		Cellule cellule;
		int i;
		
		cellule = this.cellules[this.x_depart][this.z_depart];
		cellule.previous = null;
		cellule = cellule.open();
		while ((cellule = cellule.open()) != this.cellules[this.x_depart][this.z_depart]);
	}
	
	/** Retournes 0 s'il est sur la case de départ, 1 si l'entity se situe dans la case d'arrivé, ou 2 s'il est n'importe ou dans la labyrinthe*/
	public int check_position(Entity e)
	{
		if (e.posX >= this.x + this.z_depart * this.cellule_size 
				&& e.posX <= this.x + this.z_depart * this.cellule_size + this.cellule_size
				&& e.posZ >= this.z + this.x_depart * this.cellule_size 
				&& e.posZ <= this.z + this.x_depart * this.cellule_size + this.cellule_size)
			return (0);
		else if (e.posX >= this.x + this.z_arrive * this.cellule_size 
				&& e.posX <= this.x + this.z_arrive * this.cellule_size + this.cellule_size
				&& e.posZ >= this.z + this.x_arrive * this.cellule_size 
				&& e.posZ <= this.z + this.x_arrive * this.cellule_size + this.cellule_size)
			return (1);
			
		return (2);
	}
}