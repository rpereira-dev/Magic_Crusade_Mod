package fr.toss.common.world.bioms;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.entity.monster.EntityCaveSpider;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.passive.EntityCow;
import net.minecraft.entity.passive.EntityWolf;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.BiomeGenMutated;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraft.world.gen.feature.WorldGenTallGrass;
import net.minecraft.world.gen.feature.WorldGenerator;
import fr.toss.common.entity.EntityCentaure;
import fr.toss.common.entity.EntityGobelin;
import fr.toss.common.entity.EntityLutin;
import fr.toss.common.entity.EntityStymph;
import fr.toss.common.register.BlockRegister;
import fr.toss.common.world.bioms.deco.BiomeDecoratorMagic;
import fr.toss.common.world.bioms.deco.WorldGenBigTreesDim;
import fr.toss.common.world.bioms.deco.WorldGenFloatingHouse;
import fr.toss.common.world.bioms.deco.WorldGenFloatingHouse2;
import fr.toss.common.world.bioms.deco.WorldGenTreesDim;
import fr.toss.common.world.bioms.deco.WorldGenVillage;

public class BiomMagicForest extends BiomGenMagic
{
    public BiomMagicForest(int p_i45383_1_)
    {
        super(p_i45383_1_);
        
        this.spawnableCreatureList.add(new BiomeGenBase.SpawnListEntry(EntityCow.class, 8, 4, 6));
        this.spawnableCreatureList.add(new BiomeGenBase.SpawnListEntry(EntityWolf.class, 2, 4, 6));
        this.spawnableCreatureList.add(new BiomeGenBase.SpawnListEntry(EntityStymph.class, 10, 4, 6));
        
        this.spawnableMonsterList.add(new BiomeGenBase.SpawnListEntry(EntityLutin.class, 14, 4, 6));   
        this.spawnableMonsterList.add(new BiomeGenBase.SpawnListEntry(EntityCentaure.class, 12, 4, 6));
        this.spawnableMonsterList.add(new BiomeGenBase.SpawnListEntry(EntityCaveSpider.class, 8, 2, 4));
        this.spawnableMonsterList.add(new BiomeGenBase.SpawnListEntry(EntityZombie.class, 8, 2, 4));
        this.spawnableMonsterList.add(new BiomeGenBase.SpawnListEntry(EntityGobelin.class, 8, 2, 4));
        
		this.topBlock = Blocks.grass;
		this.fillerBlock = Blocks.dirt;
		this.setBiomeName("Mystic Forest");
		this.theBiomeDecorator.grassPerChunk = 16;
        ((BiomeDecoratorMagic) this.theBiomeDecorator).berry_per_chunk = 6;
		this.theBiomeDecorator.treesPerChunk = 6;
    }
    
    public WorldGenAbstractTree func_150567_a(Random rand)
    {
    	switch (rand.nextInt(7))
    	{
	    	case 0 : 
	    		return (WorldGenAbstractTree) new WorldGenTreesDim(4 + rand.nextInt(8), 0, 0);
	    		
	    	case 1 : 
	    		return (WorldGenAbstractTree) new WorldGenTreesDim(4 + rand.nextInt(8), 0, 1);
	    		
	    	case 2 : 
	    		return (WorldGenAbstractTree) new WorldGenTreesDim(4 + rand.nextInt(8), 0, 2);
	    		
	    	case 3 : 
	    		return (WorldGenAbstractTree) new WorldGenTreesDim(4 + rand.nextInt(8), 2, 0);
	    		
	    	case 4 : 
	    		return (WorldGenAbstractTree) new WorldGenTreesDim(4 + rand.nextInt(8), 2, 1);
	    		
	    	case 5 : 
	    		return (WorldGenAbstractTree) new WorldGenTreesDim(4 + rand.nextInt(8), 2, 2);
	    		
	    	case 6 : 
	    		return (WorldGenAbstractTree) new WorldGenBigTreesDim();
    	}
    	
    	return (null);
    }
    
    /**
     * Gets a WorldGen appropriate for this biome.
     */
    public WorldGenerator getRandomWorldGenForGrass(Random p_76730_1_)
    {
        return new WorldGenTallGrass(Blocks.tallgrass, 1);
    }
    
    public void decorate(World w, Random rand, int x, int z)
    {
        super.decorate(w, rand, x, z);
        
        int l = 0;

        while (l < 6 + rand.nextInt(8))
        {
            int alea = rand.nextInt(3);

            if (alea == 0)
            {
                genTallFlowers.func_150548_a(1);
            }
            else if (alea == 1)
            {
                genTallFlowers.func_150548_a(4);
            }
            else if (alea == 2)
            {
                genTallFlowers.func_150548_a(5);
            }

            int j1 = 0;

            while (true)
            {
                if (j1 < 5)
                {
                    int k1 = x + rand.nextInt(16) + 8;
                    int i2 = z + rand.nextInt(16) + 8;
                    int l1 = rand.nextInt(w.getHeightValue(k1, i2) + 32);

                    if (!genTallFlowers.generate(w, rand, k1, l1, i2))
                    {
                        ++j1;
                        continue;
                    }
                }

                ++l;
                break;
            }
        }
    }
    
    /**
     * Creates a mutated version of the biome and places it into the biomeList with an index equal to the original plus
     * 128
     */
    public BiomeGenBase createMutation()
    {
        BiomMagicForest.Mutated mutated = new BiomMagicForest.Mutated(this.biomeID + 128, this);
        mutated.temperature = (this.temperature + 1.0F) * 0.5F;
        mutated.rootHeight = this.rootHeight * 0.5F + 0.3F;
        mutated.heightVariation = this.heightVariation * 0.5F + 1.2F;
        return mutated;
    }

    public static class Mutated extends BiomeGenMutated
    {

        public Mutated(int entier, BiomeGenBase biom)
        {
            super(entier, biom);
            this.theBiomeDecorator.treesPerChunk = 2;
            this.theBiomeDecorator.flowersPerChunk = 2;
            ((BiomeDecoratorMagic) this.theBiomeDecorator).berry_per_chunk = 4;
        }

        public void genTerrainBlocks(World w, Random rand, Block[] blocks, byte[] bytes, int x, int z, double var)
        {
            this.topBlock = BlockRegister.GRASS;
            this.field_150604_aj = 0;
            this.fillerBlock = BlockRegister.DIRT;

            if (var > 1.75D)
            {
                this.topBlock = BlockRegister.GRASS;
                this.fillerBlock = BlockRegister.DIRT;
            }
            else if (var > -0.5D)
            {
                this.topBlock = BlockRegister.GRASS;
                this.field_150604_aj = 1;
            }

            this.genBiomeTerrain(w, rand, blocks, bytes, x, z, var);
        }
    }
}
