package fr.toss.common.world.labyrinthe;

import java.util.Random;

import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class WorldGenLabyrinthe extends WorldGenerator {

	@Override
	public boolean generate(World w, Random r, int x, int y, int z)
	{
		Labyrinthe lab;
		long seed;
		int taille;
		int largeur_case;
		int hauteur_case;
		
		seed = 1000;
		taille = 40;
		largeur_case = 8;
		hauteur_case = 4;
		lab = new Labyrinthe(w, x, y, z, seed, taille, largeur_case, hauteur_case);
		lab.solve();
		lab.generate();
		return false;
	}
}