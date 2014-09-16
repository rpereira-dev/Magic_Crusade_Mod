package fr.toss.common.world.bioms.deco;

import net.minecraft.init.Blocks;
import net.minecraft.world.biome.BiomeDecorator;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraft.world.gen.feature.WorldGenFlowers;
import net.minecraft.world.gen.feature.WorldGenLiquids;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.terraingen.DecorateBiomeEvent;
import fr.toss.common.register.BlockRegister;

public class BiomeDecoratorMagic extends BiomeDecorator {
	
    public WorldGenFlowers 		gen_red_berry;
    public WorldGenFlowers 		gen_yellow_berry;
    public WorldGenFlowers 		gen_tallgrass;
    public int 					berry_per_chunk;
	private WorldGenerator 		combustiumGen;
	private WorldGenerator 		etherniumGen;
	private WorldGenerator 		silverGen;
	private WorldGenerator 		titaniumGen;

	public BiomeDecoratorMagic()
	{
		super();
        this.grassPerChunk = 10;
        this.gen_red_berry = new WorldGenFlowers(BlockRegister.BERRY_RED);
        this.gen_yellow_berry = new WorldGenFlowers(BlockRegister.BERRY_YELLOW);
        this.combustiumGen = new WorldGenMinable(BlockRegister.ORE_COMBUSTIUM, 24, BlockRegister.STONE);
        this.etherniumGen = new WorldGenMinable(BlockRegister.ORE_ETHERNIUM, 10, BlockRegister.STONE);
        this.silverGen = new WorldGenMinable(BlockRegister.ORE_SILVER, 14, BlockRegister.STONE);
        this.titaniumGen = new WorldGenMinable(BlockRegister.ORE_TITANIUM, 10, BlockRegister.STONE);
        this.goldGen = new WorldGenMinable(Blocks.gold_ore, 8, BlockRegister.STONE);
        this.redstoneGen = new WorldGenMinable(Blocks.redstone_ore, 7, BlockRegister.STONE);
        this.diamondGen = new WorldGenMinable(Blocks.diamond_ore, 7, BlockRegister.STONE);
	}

	@Override
	protected void genDecorations(BiomeGenBase biom)
	{
		this.generateOres();
        int i;
        int j;
        int k;

        i = this.treesPerChunk;

        if (this.randomGenerator.nextInt(10) == 0)
        {
            ++i;
        }

        int l;
        int i1;

        for (j = 0; j < i; ++j)
        {
            k = this.chunk_X + this.randomGenerator.nextInt(16) + 8;
            l = this.chunk_Z + this.randomGenerator.nextInt(16) + 8;
            i1 = this.currentWorld.getHeightValue(k, l);
            WorldGenAbstractTree worldgenabstracttree = biom.func_150567_a(this.randomGenerator);
            worldgenabstracttree.setScale(1.0D, 1.0D, 1.0D);

            if (worldgenabstracttree.generate(this.currentWorld, this.randomGenerator, k, i1, l))
            {
                worldgenabstracttree.func_150524_b(this.currentWorld, this.randomGenerator, k, i1, l);
            }
        }
    	
        for (j = 0; j < this.berry_per_chunk; ++j)
        {
            k = this.chunk_X + this.randomGenerator.nextInt(16) + 8;
            l = this.chunk_Z + this.randomGenerator.nextInt(16) + 8;
            i1 = nextInt(this.currentWorld.getHeightValue(k, l) + 32);
            if (this.randomGenerator.nextInt(2) == 0)
            	this.gen_red_berry.generate(this.currentWorld, this.randomGenerator, k, i1, l);
            else
            	this.gen_yellow_berry.generate(this.currentWorld, this.randomGenerator, k, i1, l);
        }
        
        k = this.chunk_X + this.randomGenerator.nextInt(16) + 8;
        l = this.chunk_Z + this.randomGenerator.nextInt(16) + 8;
        i1 = 10;
        while (this.currentWorld.getBlock(k, i1, l) == Blocks.air && i1 < 120)
        	i1++;
        
        for (j = 0; j < this.grassPerChunk; ++j)
        {
            k = this.chunk_X + this.randomGenerator.nextInt(16) + 8;
            l = this.chunk_Z + this.randomGenerator.nextInt(16) + 8;
            i1 = nextInt(this.currentWorld.getHeightValue(k, l) * 2);
            WorldGenerator worldgenerator = biom.getRandomWorldGenForGrass(this.randomGenerator);
            worldgenerator.generate(this.currentWorld, this.randomGenerator, k, i1, l);
        }
        
        if (this.generateLakes)
        {
            for (j = 0; j < 50; ++j)
            {
                k = this.chunk_X + this.randomGenerator.nextInt(16) + 8;
                l = this.randomGenerator.nextInt(this.randomGenerator.nextInt(248) + 8);
                i1 = this.chunk_Z + this.randomGenerator.nextInt(16) + 8;
                (new WorldGenLiquids(Blocks.flowing_water)).generate(this.currentWorld, this.randomGenerator, k, l, i1);
            }

            for (j = 0; j < 20; ++j)
            {
                k = this.chunk_X + this.randomGenerator.nextInt(16) + 8;
                l = this.randomGenerator.nextInt(this.randomGenerator.nextInt(this.randomGenerator.nextInt(240) + 8) + 8);
                i1 = this.chunk_Z + this.randomGenerator.nextInt(16) + 8;
                (new WorldGenLiquids(Blocks.flowing_lava)).generate(this.currentWorld, this.randomGenerator, k, l, i1);
            }
        }

        MinecraftForge.EVENT_BUS.post(new DecorateBiomeEvent.Post(currentWorld, randomGenerator, chunk_X, chunk_Z));
    }


    /**
     * Generates ores in the current chunk
     */
    protected void generateOres()
    {
        this.genStandardOre1(12, this.diamondGen, 0, 32);
        this.genStandardOre1(6, this.redstoneGen, 0, 32);
        this.genStandardOre1(12, this.goldGen, 0, 32);
        this.genStandardOre1(16, this.etherniumGen, 0, 48);
        this.genStandardOre1(20, this.silverGen, 0, 128);
        this.genStandardOre1(24, this.combustiumGen, 0, 128);
        this.genStandardOre1(8, this.titaniumGen, 0, 26);
    }
    
    private int nextInt(int i)
    {
        if (i <= 1)
            return 0;
        return this.randomGenerator.nextInt(i);
	}
}
