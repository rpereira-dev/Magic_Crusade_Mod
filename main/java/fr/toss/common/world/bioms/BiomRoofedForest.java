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
import fr.toss.common.entity.EntityLutin;
import fr.toss.common.register.BlockRegister;
import fr.toss.common.world.bioms.deco.BiomeDecoratorMagic;
import fr.toss.common.world.bioms.deco.WorldGenBigTreesDim;
import fr.toss.common.world.bioms.deco.WorldGenFloatingHouse2;
import fr.toss.common.world.bioms.deco.WorldGenRoofedTrees;
import fr.toss.common.world.bioms.deco.WorldGenTreesDim;
import fr.toss.common.world.bioms.deco.WorldGenVillage;

public class BiomRoofedForest extends BiomGenMagic
{
    public BiomRoofedForest(int p_i45383_1_)
    {
        super(p_i45383_1_);
        
        this.spawnableCreatureList.add(new BiomeGenBase.SpawnListEntry(EntityCow.class, 8, 4, 6));
        this.spawnableCreatureList.add(new BiomeGenBase.SpawnListEntry(EntityWolf.class, 2, 4, 6));
        this.spawnableCreatureList.add(new BiomeGenBase.SpawnListEntry(EntityCentaure.class, 12, 4, 6));
        this.spawnableCreatureList.add(new BiomeGenBase.SpawnListEntry(EntityLutin.class, 14, 4, 6));

        this.spawnableMonsterList.add(new BiomeGenBase.SpawnListEntry(EntityCaveSpider.class, 8, 2, 4));
        this.spawnableMonsterList.add(new BiomeGenBase.SpawnListEntry(EntityZombie.class, 8, 2, 4));
        
		this.topBlock = BlockRegister.GRASS;
		this.fillerBlock = BlockRegister.DIRT;
		this.setBiomeName("Mystic Roofed Forest");
		this.theBiomeDecorator.grassPerChunk = 16;
        ((BiomeDecoratorMagic) this.theBiomeDecorator).berry_per_chunk = 6;
		this.theBiomeDecorator.treesPerChunk = 10;
    }
    
    public WorldGenAbstractTree func_150567_a(Random rand)
    {
    	switch (rand.nextInt(7))
    	{
	    	case 0 : 
	    		return (WorldGenAbstractTree) new WorldGenRoofedTrees(0, 0);
	    		
	    	case 1 : 
	    		return (WorldGenAbstractTree) new WorldGenRoofedTrees(0, 3);
	    		
	    	case 2 : 
	    		return (WorldGenAbstractTree) new WorldGenRoofedTrees(2, 0);
	    		
	    	case 3 : 
	    		return (WorldGenAbstractTree) new WorldGenRoofedTrees(2, 3);
	    		
	    	case 4 : 
	    		return (WorldGenAbstractTree) new WorldGenTreesDim(5 + rand.nextInt(8), 2, 3);
	    		
	    	case 5 : 
	    		return (WorldGenAbstractTree) new WorldGenTreesDim(5 + rand.nextInt(8), 2, 0);
	    		
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
        return new WorldGenTallGrass(BlockRegister.TALLGRASS, 1);
    }
    
    /**
     * Creates a mutated version of the biome and places it into the biomeList with an index equal to the original plus
     * 128
     */
    public BiomeGenBase createMutation()
    {
        BiomRoofedForest.Mutated mutated = new BiomRoofedForest.Mutated(this.biomeID + 128, this);
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
            this.topBlock = Blocks.grass;
            this.field_150604_aj = 0;
            this.fillerBlock = Blocks.dirt;

            if (var > 1.75D)
            {
                this.topBlock = Blocks.grass;
                this.fillerBlock = Blocks.dirt;
            }
            else if (var > -0.5D)
            {
                this.topBlock = Blocks.grass;
                this.field_150604_aj = 1;
            }

            this.genBiomeTerrain(w, rand, blocks, bytes, x, z, var);
        }
    }
}
