package fr.toss.common.world.bioms.dungeon_arkavon;

import java.util.Random;

import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import fr.toss.common.register.BlockRegister;

public class WorldGenArkavon extends WorldGeneratorM {

	
	
	@Override
	public boolean generate(World w, Random r, int x, int y, int z)
	{
		Plateforme plateforme;
		
		plateforme = new Plateforme(x, y, z, 10, 4, 10);
		this.genPlateforme(w, r, plateforme);		
		
		
		return false;
	}
	
	
	public void genMainPlateforme(World w, Random r, Plateforme plateforme)
	{
		
		
	}
	
	
	public void genPlateforme(World w, Random r, Plateforme plateforme)
	{
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
