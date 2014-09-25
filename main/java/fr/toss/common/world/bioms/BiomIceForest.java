package fr.toss.common.world.bioms;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.BiomeGenMutated;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraft.world.gen.feature.WorldGenTallGrass;
import net.minecraft.world.gen.feature.WorldGenerator;
import fr.toss.common.entity.EntitySlimeFrozen;
import fr.toss.common.entity.EntitySnowCube;
import fr.toss.common.entity.EntityStymph;
import fr.toss.common.register.BlockRegister;
import fr.toss.common.world.bioms.deco.BiomeDecoratorMagic;
import fr.toss.common.world.bioms.deco.WorldGenFloatingDungeon;
import fr.toss.common.world.bioms.deco.WorldGenFloatingHouse;
import fr.toss.common.world.bioms.deco.WorldGenIceTrees;

public class BiomIceForest extends BiomGenMagic
{
    public WorldGenIceTrees trees;

    public BiomIceForest(int p_i45383_1_)
    {
        super(p_i45383_1_);
        
        this.spawnableCreatureList.add(new BiomeGenBase.SpawnListEntry(EntitySnowCube.class, 50, 2, 6));
        this.spawnableCreatureList.add(new BiomeGenBase.SpawnListEntry(EntityStymph.class, 10, 4, 6));
        this.spawnableMonsterList.add(new BiomeGenBase.SpawnListEntry(EntitySlimeFrozen.class, 50, 4, 6));

		this.topBlock = Blocks.snow;
		this.fillerBlock = Blocks.packed_ice;
		this.setBiomeName("Frozen Forest");
		this.trees = new WorldGenIceTrees(false);
		this.theBiomeDecorator.grassPerChunk = 20;
		this.theBiomeDecorator.treesPerChunk = 2;
        ((BiomeDecoratorMagic) this.theBiomeDecorator).berry_per_chunk = 10;
    }

    public WorldGenAbstractTree func_150567_a(Random rand)
    {
        return (WorldGenAbstractTree)(rand.nextInt(5) > 0 ? trees : this.worldGeneratorTrees);
    }

    
    /**
     * Gets a WorldGen appropriate for this biome.
     */
    public WorldGenerator getRandomWorldGenForGrass(Random p_76730_1_)
    {
        return new WorldGenTallGrass(BlockRegister.SNOW_TALLGRASS, 1);
    }

    
    /**
     * Creates a mutated version of the biome and places it into the biomeList with an index equal to the original plus
     * 128
     */
    public BiomeGenBase createMutation()
    {
        BiomIceForest.Mutated mutated = new BiomIceForest.Mutated(this.biomeID + 128, this);
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
        }

        public void genTerrainBlocks(World w, Random rand, Block[] blocks, byte[] bytes, int x, int z, double var)
        {
            this.topBlock = Blocks.packed_ice;
            this.field_150604_aj = 0;
            this.fillerBlock = Blocks.packed_ice;

            if (var > 1.75D)
            {
                this.topBlock = Blocks.packed_ice;
                this.fillerBlock = Blocks.packed_ice;
            }
            else if (var > -0.5D)
            {
                this.topBlock = Blocks.packed_ice;
                this.field_150604_aj = 1;
            }

            this.genBiomeTerrain(w, rand, blocks, bytes, x, z, var);
        }
    }
}
