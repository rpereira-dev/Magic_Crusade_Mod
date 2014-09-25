package fr.toss.client.registry;

import net.minecraft.client.model.ModelSlime;
import cpw.mods.fml.client.registry.RenderingRegistry;
import fr.toss.client.model.entity.ModelArkavon;
import fr.toss.client.model.entity.ModelBelier;
import fr.toss.client.model.entity.ModelCentaure;
import fr.toss.client.model.entity.ModelChevalier;
import fr.toss.client.model.entity.ModelCrocotta;
import fr.toss.client.model.entity.ModelGobelin;
import fr.toss.client.model.entity.ModelHaunter;
import fr.toss.client.model.entity.ModelLibellule;
import fr.toss.client.model.entity.ModelLutin;
import fr.toss.client.model.entity.ModelMageOrc;
import fr.toss.client.model.entity.ModelOrc;
import fr.toss.client.model.entity.ModelRoiOrc;
import fr.toss.client.model.entity.ModelStymph;
import fr.toss.client.model.entity.ModelZombieMonster;
import fr.toss.client.render.entity.RenderArkavon;
import fr.toss.client.render.entity.RenderBelier;
import fr.toss.client.render.entity.RenderBossOrc;
import fr.toss.client.render.entity.RenderCentaure;
import fr.toss.client.render.entity.RenderChevalier;
import fr.toss.client.render.entity.RenderCrocotta;
import fr.toss.client.render.entity.RenderFrozenCube;
import fr.toss.client.render.entity.RenderGhastFrozen;
import fr.toss.client.render.entity.RenderGobelin;
import fr.toss.client.render.entity.RenderHaunter;
import fr.toss.client.render.entity.RenderLibellule;
import fr.toss.client.render.entity.RenderLutin;
import fr.toss.client.render.entity.RenderMageOrc;
import fr.toss.client.render.entity.RenderOrc;
import fr.toss.client.render.entity.RenderSlave;
import fr.toss.client.render.entity.RenderSlimeFrozen;
import fr.toss.client.render.entity.RenderSnowCube;
import fr.toss.client.render.entity.RenderStymph;
import fr.toss.client.render.entity.RenderSummonZombie;
import fr.toss.client.render.entity.RenderVillagerDim;
import fr.toss.client.render.entity.RenderZombieMonster;
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


public class RenderRegistry {
	
	public static void load()
	{
		RenderingRegistry.addNewArmourRendererPrefix("5");
		RenderingRegistry.addNewArmourRendererPrefix("6");
		RenderingRegistry.addNewArmourRendererPrefix("7");
		RenderingRegistry.addNewArmourRendererPrefix("8");
		RenderingRegistry.addNewArmourRendererPrefix("9");
		RenderingRegistry.addNewArmourRendererPrefix("10");
		RenderingRegistry.addNewArmourRendererPrefix("11");
		RenderingRegistry.addNewArmourRendererPrefix("12");
		RenderingRegistry.addNewArmourRendererPrefix("13");
		RenderingRegistry.addNewArmourRendererPrefix("14");
		RenderingRegistry.addNewArmourRendererPrefix("15");
		RenderingRegistry.addNewArmourRendererPrefix("16");
		RenderingRegistry.addNewArmourRendererPrefix("17");
		RenderingRegistry.addNewArmourRendererPrefix("18");
		RenderingRegistry.addNewArmourRendererPrefix("19");
		RenderingRegistry.addNewArmourRendererPrefix("20");
		RenderingRegistry.addNewArmourRendererPrefix("21");

        RenderingRegistry.registerEntityRenderingHandler(EntityVillagerDim.class, new RenderVillagerDim());
        RenderingRegistry.registerEntityRenderingHandler(EntityGhastFrozen.class, new RenderGhastFrozen());
        RenderingRegistry.registerEntityRenderingHandler(EntitySlimeFrozen.class, new RenderSlimeFrozen(new ModelSlime(16), new ModelSlime(0), 0.25F));
        RenderingRegistry.registerEntityRenderingHandler(EntitySnowCube.class, new RenderSnowCube());
        RenderingRegistry.registerEntityRenderingHandler(EntityFrozenCube.class, new RenderFrozenCube());
        RenderingRegistry.registerEntityRenderingHandler(EntitySlave.class, new RenderSlave());
        RenderingRegistry.registerEntityRenderingHandler(EntityStymph.class, new RenderStymph(new ModelStymph(), 0.7F));
        RenderingRegistry.registerEntityRenderingHandler(EntityCentaure.class, new RenderCentaure(new ModelCentaure(), 0.7F));
        RenderingRegistry.registerEntityRenderingHandler(EntitySummonZombie.class, new RenderSummonZombie());
        RenderingRegistry.registerEntityRenderingHandler(EntityBossOrc.class, new RenderBossOrc(new ModelRoiOrc(), 0.7F));
        RenderingRegistry.registerEntityRenderingHandler(EntityOrc.class, new RenderOrc(new ModelOrc(), 0.7F));
        RenderingRegistry.registerEntityRenderingHandler(EntityMageOrc.class, new RenderMageOrc(new ModelMageOrc(), 0.7F));
        RenderingRegistry.registerEntityRenderingHandler(EntityLutin.class, new RenderLutin(new ModelLutin(), 0.7F));
        RenderingRegistry.registerEntityRenderingHandler(EntityGobelin.class, new RenderGobelin(new ModelGobelin(), 0.7F));
        RenderingRegistry.registerEntityRenderingHandler(EntityArkavon.class, new RenderArkavon(new ModelArkavon(), 0.7F));
        RenderingRegistry.registerEntityRenderingHandler(EntityMonsterZombie.class, new RenderZombieMonster(new ModelZombieMonster(), 0.7F));
        RenderingRegistry.registerEntityRenderingHandler(EntityCrocotta.class, new RenderCrocotta(new ModelCrocotta(), 0.7F));
        RenderingRegistry.registerEntityRenderingHandler(EntityChevalier.class, new RenderChevalier(new ModelChevalier(), 0.7F));
        RenderingRegistry.registerEntityRenderingHandler(EntityLibellule.class, new RenderLibellule(new ModelLibellule(), 0.7F));
        RenderingRegistry.registerEntityRenderingHandler(EntityBelier.class, new RenderBelier(new ModelBelier(), 0.7F));
        RenderingRegistry.registerEntityRenderingHandler(EntityHaunter.class, new RenderHaunter(new ModelHaunter(), 0.7F));
	}

}
