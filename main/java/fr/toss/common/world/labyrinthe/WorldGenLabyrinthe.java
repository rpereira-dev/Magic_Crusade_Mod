package fr.toss.common.world.labyrinthe;

import java.util.Random;

import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class WorldGenLabyrinthe extends WorldGenerator {

	@Override
	public boolean generate(World w, Random r, int x, int y, int z)
	{
		Labyrinthe lab;
		int seed;
		int taille;
		int largeur_case;
		int hauteur_case;
		
		seed = 1000;
		taille = 40;
		largeur_case = 4;
		hauteur_case = 4;
		lab = new Labyrinthe(seed, taille, largeur_case, hauteur_case);
		lab.solve();
		lab.generate(w, x, y, z);
		return false;
	}
}