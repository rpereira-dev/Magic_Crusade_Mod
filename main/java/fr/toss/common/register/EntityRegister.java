package fr.toss.common.register;

import net.minecraft.entity.Entity;
import cpw.mods.fml.common.registry.EntityRegistry;
import fr.toss.common.entity.EntityArkavon;
import fr.toss.common.entity.EntityBelier;
import fr.toss.common.entity.EntityBossOrc;
import fr.toss.common.entity.EntityCentaure;
import fr.toss.common.entity.EntityChevalier;
import fr.toss.common.entity.EntityCrocotta;
import fr.toss.common.entity.EntityFrozenCube;
import fr.toss.common.entity.EntityGhastFrozen;
import fr.toss.common.entity.EntityGobelin;
import fr.toss.common.entity.EntityHaunter;
import fr.toss.common.entity.EntityLibellule;
import fr.toss.common.entity.EntityLutin;
import fr.toss.common.entity.EntityMageOrc;
import fr.toss.common.entity.EntityMonsterZombie;
import fr.toss.common.entity.EntityOrc;
import fr.toss.common.entity.EntitySlave;
import fr.toss.common.entity.EntitySlimeFrozen;
import fr.toss.common.entity.EntitySnowCube;
import fr.toss.common.entity.EntityStymph;
import fr.toss.common.entity.EntitySummonZombie;
import fr.toss.common.entity.EntityVillagerDim;

public class EntityRegister {

	public static void load() 
	{
		registerEntity(EntityVillagerDim.class, "VillagerDim");
		registerEntity(EntityGhastFrozen.class, "GhastFrozen");
		registerEntity(EntitySlimeFrozen.class, "SlimeFrozen");
		registerEntity(EntitySnowCube.class, "SnowCube");
		registerEntity(EntityFrozenCube.class, "FrozenCube");
		registerEntity(EntitySlave.class, "Slave");
		registerEntity(EntityCentaure.class, "Centaure");
		registerEntity(EntityStymph.class, "Stymph");
		registerEntity(EntitySummonZombie.class, "ZombieSummon");
		registerEntity(EntityOrc.class, "Orc");
		registerEntity(EntityBossOrc.class, "BossOrc");
		registerEntity(EntityMageOrc.class, "MageOrc");
		registerEntity(EntityLutin.class, "Lutin");
		registerEntity(EntityGobelin.class, "Gobelin");
		registerEntity(EntityArkavon.class, "Arkavon");
		registerEntity(EntityMonsterZombie.class, "MonsterZombie");
		registerEntity(EntityCrocotta.class, "Crocotta");
		registerEntity(EntityChevalier.class, "Chevalier");
		registerEntity(EntityLibellule.class, "Libellule");
		registerEntity(EntityBelier.class, "Belier");
		registerEntity(EntityHaunter.class, "Haunter");
	}
	
	public static void registerEntity(Class <? extends Entity > entityClass, String string)
	{
        EntityRegistry.registerGlobalEntityID(entityClass, string, EntityRegistry.findGlobalUniqueEntityId(), Integer.MIN_VALUE, Integer.MAX_VALUE);
	}
}
