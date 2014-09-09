package fr.toss.common.world.bioms;

import net.minecraft.entity.monster.EntitySilverfish;
import net.minecraft.world.biome.BiomeDecorator;
import net.minecraft.world.biome.BiomeGenBase;
import fr.toss.common.entity.EntitySlave;
import fr.toss.common.world.bioms.deco.BiomeDecoratorMagic;

public class BiomGenMagic extends BiomeGenBase {
		
	public BiomGenMagic(int p_i1971_1_) 
	{
		super(p_i1971_1_);
		
		this.theBiomeDecorator = new BiomeDecoratorMagic();
		
		this.spawnableMonsterList.clear();
		this.spawnableCreatureList.clear();
		
        this.spawnableMonsterList.add(new BiomeGenBase.SpawnListEntry(EntitySilverfish.class, 12, 4, 8));
		this.spawnableCreatureList.add(new BiomeGenBase.SpawnListEntry(EntitySlave.class, 12, 1, 2));
	}


	@Override
    public BiomeDecorator createBiomeDecorator()
    {
        return getModdedBiomeDecorator(new BiomeDecoratorMagic());
    }
}
