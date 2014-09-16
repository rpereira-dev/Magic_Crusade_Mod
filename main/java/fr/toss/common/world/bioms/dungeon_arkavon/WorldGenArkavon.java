package fr.toss.common.world.bioms.dungeon_arkavon;

import java.util.Random;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.util.ChatComponentText;
import net.minecraft.world.World;
import fr.toss.common.entity.EntityArkavon;
import fr.toss.common.entity.EntityChevalier;
import fr.toss.common.entity.EntityCrocotta;
import fr.toss.common.entity.EntityGobelin;
import fr.toss.common.register.BlockRegister;

public class WorldGenArkavon extends WorldGeneratorM {

	
	@Override
	public boolean generate(World w, Random r, int x, int y, int z)
	{
		int a;
		int b;
		
		a = 0;
		b = 0;
		this.genTore(w, BlockRegister.STONE, 20, 10, x, y, z, 1);
		this.genBloc(w, Blocks.air, new Cube(new Point(x + 29, y - 2, z - 4), new Vec(1, 4, 9)));
		this.genBloc(w, Blocks.air, new Cube(new Point(x - 29, y - 2, z - 4), new Vec(1, 4, 9)));
		this.genBloc(w, Blocks.air, new Cube(new Point(x - 4, y - 2, z + 29), new Vec(9, 4, 1)));
		this.genBloc(w, Blocks.air, new Cube(new Point(x - 4, y - 2, z - 29), new Vec(9, 4, 1)));
		
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
		
		EntityChevalier chevalier;
		
		chevalier = new EntityChevalier(w);
		chevalier.setLocationAndAngles(a, this.getTopBlock(w, a + 12, b + 12, y + 4), b, 0,  0);
		w.spawnEntityInWorld(chevalier);
		
		for (Object p : w.playerEntities)
    		((EntityPlayer)p).addChatMessage(new ChatComponentText("... still loading, sorry for the inconveniance, wait a little please"));
		
		
		this.genBloc(w, BlockRegister.STONE, new Cube(new Point(x + 29, y - 3, z - 4), new Vec(20, 1, 9)));
		this.genSphere(w, BlockRegister.STONE, 36, x + 83, y, z, 0.5f);
		this.genCircle(w, BlockRegister.ORE_ETHERNIUM, 36, x + 83, y, z, 0.5f);

		this.genTore(w, BlockRegister.STONE, 20, 20, x + 83, y, z, 1);
		this.genBloc(w, Blocks.air, new Cube(new Point(x + 48, y - 2, z - 4), new Vec(1, 4, 9)));
		this.genBloc(w, Blocks.air, new Cube(new Point(x + 44, y - 2, z - 4), new Vec(1, 4, 9)));
		this.genBloc(w, Blocks.glowstone, new Cube(new Point(x + 79, y + 35, z - 4), new Vec(8, 1, 8)));
		this.genCircle(w, Blocks.water, 19, x + 83, y - 18, z, 0.5f);
		this.genCircle(w, Blocks.glowstone, 18, x + 83, y - 19, z, 0.5f);
		this.genCircle(w, Blocks.glowstone, 21, x + 83, y - 19, z, 0.5f);

		EntityArkavon arkavon = new EntityArkavon(w);
		arkavon.setLocationAndAngles(x + 75, y + 4, z + 3, 0, 0);
		w.spawnEntityInWorld(arkavon);
		
		for (int i = 0; i < 10; i++)
		{
			EntityCrocotta crocotta = new EntityCrocotta(w);
			crocotta.setLocationAndAngles(x + 75, y + 4, z + 3, 0, 0);
			w.spawnEntityInWorld(crocotta);
		}
		
		Plateforme plateforme;
		
		plateforme = new Plateforme(x + 83, y + 9, z + 10, 10, 4, 10);
		this.genPlateforme(w, r, plateforme);	
		
		plateforme = new Plateforme(x + 58, y + 6, z - 10, 14, 6, 14);
		this.genPlateforme(w, r, plateforme);	
		
		
		this.gen_house(w, x + 58, y - 18, z + 10);
		this.gen_house(w, x + 96, y - 18, z - 10);

		return false;
	}

	public void gen_house(World w, int x, int y, int z)
	{
		this.genBlocVide(w, Blocks.wool, new Cube(new Point(x, y, z), new Vec(6, 6, 5)));
		this.genBloc(w, Blocks.air, new Cube(new Point(x + 2, y + 1, z), new Vec(2, 3, 1)));
		this.genBloc(w, Blocks.air, new Cube(new Point(x, y + 1, z + 2), new Vec(1, 3, 2)));
		this.genBloc(w, Blocks.air, new Cube(new Point(x + 2, y + 1, z + 5), new Vec(2, 3, 1)));
		this.genBloc(w, Blocks.air, new Cube(new Point(x + 5, y + 1, z + 2), new Vec(1, 3, 2)));
		this.genBlocVide(w, BlockRegister.PLANKS, new Cube(new Point(x - 1, y - 1, z - 1), new Vec(8, 1, 7)));
		this.genBlocVide(w, BlockRegister.PLANKS, new Cube(new Point(x - 1, y + 5, z - 1), new Vec(8, 1, 7)));
		w.setBlock(x + 3, y + 1, z + 3, Blocks.torch);
		
		for (int i = 0; i < 4; i++)
		{
			EntityGobelin gob;
			
			gob = new EntityGobelin(w);
			gob.setLocationAndAngles(x + i, y + 8, z + i, 0, 0);
			w.spawnEntityInWorld(gob);
		}

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
		

		for (int i = 0; i < 6; i++)
			w.setBlock(plateforme.x + r.nextInt(plateforme.xSize), plateforme.y + 1, plateforme.z + r.nextInt(plateforme.zSize), Blocks.torch);

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
