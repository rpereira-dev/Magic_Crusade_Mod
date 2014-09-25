package fr.toss.common.world.dungeon;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import net.minecraft.world.ChunkPosition;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeCache;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.WorldChunkManager;
import net.minecraft.world.gen.layer.IntCache;
import fr.toss.common.register.BiomsList;
import fr.toss.common.world.OldNoiseGeneratorOctaves2;

public class ChunkManagerEmpty extends WorldChunkManager
{
    private BiomeCache biomeCache;
    private List biomesToSpawnIn;
	
	protected ChunkManagerEmpty()
	{
        this.biomeCache = new BiomeCache(this);
        this.biomesToSpawnIn = new ArrayList();
	}

    public ChunkManagerEmpty(World par1World)
    {
        this();
    }    
    
	public static double[] getColdTemperatures(double ad[], int i, int j, int k, int l)
    {
        return ad;
    }
	
    public static int[] getBiomesGens(int par1, int par2, int par3, int par4)
    {
		int[] abiomegenbase;
		
		abiomegenbase = new int[par3 * par4];
		return abiomegenbase;
    }
	
    public static int getBiomeFromLookup(double d, double d1)
    {
        return BiomeGenBase.desert.biomeID;
    }
		
    public List getBiomesToSpawnIn()
    {
        return this.biomesToSpawnIn;
    }

    public BiomeGenBase getBiomeGenAt(int par1, int par2)
    {
        return BiomsList.DUNGEON;
    }

    public float[] getRainfall(float[] par1ArrayOfFloat, int par2, int par3, int par4, int par5)
    {
        return par1ArrayOfFloat;
    }

    public float getTemperatureAtHeight(float par1, int par2)
    {
        return par1;
    }

    public BiomeGenBase[] getBiomesForGeneration(BiomeGenBase[] par1ArrayOfBiomeGenBase, int par2, int par3, int par4, int par5)
    {
        return par1ArrayOfBiomeGenBase;
    }

    public BiomeGenBase[] loadBlockGeneratorData(BiomeGenBase[] par1ArrayOfBiomeGenBase, int par2, int par3, int par4, int par5)
    {
        return par1ArrayOfBiomeGenBase;
    }


    public boolean areBiomesViable(int par1, int par2, int par3, List par4List)
    {
    	return false;
    }

    public ChunkPosition findBiomePosition(int p_150795_1_, int p_150795_2_, int p_150795_3_, List p_150795_4_, Random p_150795_5_)
    {
    	return null;
    }

    public void cleanupCache()
    {
        this.biomeCache.cleanupCache();
    }
}
 