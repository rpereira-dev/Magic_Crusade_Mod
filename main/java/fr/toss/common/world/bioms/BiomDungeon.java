package fr.toss.common.world.bioms;

import net.minecraft.entity.monster.EntitySilverfish;
import net.minecraft.world.biome.BiomeDecorator;
import net.minecraft.world.biome.BiomeGenBase;
import fr.toss.common.entity.EntityBelier;
import fr.toss.common.entity.EntityCrocotta;
import fr.toss.common.entity.EntityLibellule;
import fr.toss.common.entity.EntitySlave;
import fr.toss.common.world.bioms.deco.BiomeDecoratorMagic;

public class BiomDungeon extends BiomeGenBase {
		
	public BiomDungeon(int id) 
	{
		super(id);
		
		this.theBiomeDecorator = new BiomeDecoratorMagic();
		
		this.spawnableMonsterList.clear();
		this.spawnableCreatureList.clear();
		this.spawnableCaveCreatureList.clear();
		this.spawnableMonsterList.clear();
		
		this.biomeName = "Dungeon";
	}
}
