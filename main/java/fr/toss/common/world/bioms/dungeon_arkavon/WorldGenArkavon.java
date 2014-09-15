package fr.toss.common.world.bioms.dungeon_arkavon;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import fr.toss.common.register.BlockRegister;

public class WorldGenArkavon extends WorldGeneratorM {

	
	
	@Override
	public boolean generate(World w, Random r, int x, int y, int z)
	{
		int a;
		int b;
		
//		this.genTore(w, BlockRegister.STONE, 20, 10, x, y, z, 1);
//		this.genBloc(w, Blocks.air, new Cube(new Point(x + 29, y - 2, z - 4), new Vec(1, 4, 9)));
//		this.genBloc(w, Blocks.air, new Cube(new Point(x - 29, y - 2, z - 4), new Vec(1, 4, 9)));
//		this.genBloc(w, Blocks.air, new Cube(new Point(x - 4, y - 2, z + 29), new Vec(9, 4, 1)));
//		this.genBloc(w, Blocks.air, new Cube(new Point(x - 4, y - 2, z - 29), new Vec(9, 4, 1)));
		
		for (int i = 0; i < 8; i++)
		{
			a = x + 5 + r.nextInt(15);
			b = z + 5 + r.nextInt(15);
			w.setBlock(a, this.getTopBlock(w, a, b, y - 10), b, BlockRegister.ORE_ETHERNIUM);
			this.spawn_random_skeleton(w, r, a, this.getTopBlock(w, a, b, y - 10), b);
			
			a = x - 5 - r.nextInt(15);
			b = z + 5 + r.nextInt(15);
			w.setBlock(a, this.getTopBlock(w, a, b, y - 10), b, BlockRegister.ORE_ETHERNIUM);
			this.spawn_random_skeleton(w, r, a, this.getTopBlock(w, a, b, y - 10), b);
			
			a = x - 5 - r.nextInt(15);
			b = z - 5 - r.nextInt(15);
			w.setBlock(a, this.getTopBlock(w, a, b, y - 10), b, BlockRegister.ORE_ETHERNIUM);
			this.spawn_random_skeleton(w, r, a, this.getTopBlock(w, a, b, y - 10), b);
			
			a = x + 5 + r.nextInt(15);
			b = z - 5 - r.nextInt(15);
			w.setBlock(a, this.getTopBlock(w, a, b, y - 10), b, BlockRegister.ORE_ETHERNIUM);
			this.spawn_random_skeleton(w, r, a, this.getTopBlock(w, a, b, y - 10), b);
		}
		
		this.genBloc(w, BlockRegister.STONE, new Cube(new Point(x + 29, y - 3, z - 4), new Vec(20, 1, 9)));
//		this.genSphere(w, BlockRegister.STONE, 36, x + 83, y, z, 0.5f);
		this.genBloc(w, Blocks.air, new Cube(new Point(x + 48, y - 2, z - 4), new Vec(1, 4, 9)));
		this.genTore(w, Blocks.stone, 20, 20, x + 83, y, z, 1);
		this.genBloc(w, Blocks.glowstone, new Cube(new Point(x + 83, y + 18, z), new Vec(8, 1, 8)));

		return false;
	}


	public void genPlateforme(World w, Random r, Plateforme plateforme)
	{
		
//		Plateforme plateforme;
//		
//		plateforme = new Plateforme(x, y, z, 10, 4, 10);
//		this.genPlateforme(w, r, plateforme);		
		
		
		Cube cube;
		
		for (int etage = 0; etage < plateforme.ySize; etage++)
		{
			cube = new Cube(new Point(plateforme.x + etage, plateforme.y - etage, plateforme.z + etage), new Vec(plateforme.xSize - etage * 2, 1, plateforme.zSize - etage * 2));
			this.genBloc(w, BlockRegister.STONE, cube);
		}
		
		for (int hauteur = 0; hauteur < 4 + r.nextInt(2); hauteur++)
			w.setBlock(plateforme.x + 1, plateforme.y - 2 - hauteur, plateforme.z + 1, Blocks.iron_bars);
		for (int hauteur = 0; hauteur < 4 + r.nextInt(2); hauteur++)
			w.setBlock(plateforme.x + 3, plateforme.y - 4 - hauteur, plateforme.z + 3, Blocks.iron_bars);
		for (int hauteur = 0; hauteur < 4 + r.nextInt(2); hauteur++)
			w.setBlock(plateforme.x + 5, plateforme.y - 4 - hauteur, plateforme.z + 6, Blocks.iron_bars);
		for (int hauteur = 0; hauteur < 4 + r.nextInt(2); hauteur++)
			w.setBlock(plateforme.x + 8, plateforme.y - 2 - hauteur, plateforme.z + 7, Blocks.iron_bars);
		for (int hauteur = 0; hauteur < 4 + r.nextInt(2); hauteur++)
			w.setBlock(plateforme.x + 7, plateforme.y - 3 - hauteur, plateforme.z + 2, Blocks.iron_bars);
		
		this.genBlockVideNoBase(w, Blocks.iron_bars, new Cube(new Point(plateforme.x, plateforme.y + 1, plateforme.z), new Vec(plateforme.xSize, plateforme.ySize, plateforme.zSize - 1)));
	}
}

class Plateforme
{
	int x;
	int y;
	int z;
	int xSize;
	int ySize;
	int zSize;
	
	public Plateforme(int x, int y, int z, int xSize, int ySize, int zSize)
	{
		this.x = x;
		this.y = y;
		this.z = z;
		this.xSize = xSize;
		this.ySize = ySize;
		this.zSize = zSize;
	}
	
	public Cube toCube()
	{
		return new Cube(new Point(this.x, this.y, this.z), new Vec(this.xSize, this.ySize, this.zSize));
	}
}
