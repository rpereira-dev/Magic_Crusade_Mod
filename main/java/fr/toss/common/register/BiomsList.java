package fr.toss.common.register;

import net.minecraft.world.biome.BiomeGenBase;
import fr.toss.common.world.bioms.BiomDungeon;
import fr.toss.common.world.bioms.BiomIceForest;
import fr.toss.common.world.bioms.BiomMagicForest;
import fr.toss.common.world.bioms.BiomRoofedForest;

public class BiomsList {
	
	public static final BiomeGenBase FOREST_MAGIC = new BiomMagicForest(158);
	public static final BiomeGenBase FOREST_FROZEN = new BiomIceForest(159);
	public static final BiomeGenBase FOREST_ROOFED = new BiomRoofedForest(160);
	public static final BiomeGenBase DUNGEON = new BiomDungeon(161);
}
