package fr.toss.common;

import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.common.MinecraftForge;
import api.player.server.ServerPlayerAPI;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.VillagerRegistry;
import fr.toss.common.event.JoueurEvent;
import fr.toss.common.event.LivingEntityEvent;
import fr.toss.common.event.ServerEvent;
import fr.toss.common.player.ServerPlayerBaseMagic;
import fr.toss.common.register.AchievementList;
import fr.toss.common.register.BlockRegister;
import fr.toss.common.register.CraftRegister;
import fr.toss.common.register.CreativesTabsRegister;
import fr.toss.common.register.EntityRegister;
import fr.toss.common.register.ItemRegister;
import fr.toss.common.register.TradeHandler;
import fr.toss.common.world.WorldProviderMagic;
import fr.toss.common.world.bioms.deco.WorldGenChestElficStaff;
import fr.toss.common.world.bioms.deco.WorldGenFloatingDungeon;
import fr.toss.common.world.bioms.deco.WorldGenFloatingHouse;
import fr.toss.common.world.bioms.deco.WorldGenFloatingHouse2;
import fr.toss.common.world.bioms.deco.WorldGenOrc;
import fr.toss.common.world.bioms.deco.WorldGenVillage;
import fr.toss.common.world.dungeon.Dungeon;
import fr.toss.common.world.dungeon.WorldProviderDungeon;

public class CommonProxy {
		
	public void load()
	{
		BlockRegister.load();
		ItemRegister.load();
		CreativesTabsRegister.load();
		CreativesTabsRegister.loadAll();
		EntityRegister.load(); 
		CraftRegister.load();
		
		DimensionManager.registerProviderType(Main.DIM_ID, WorldProviderMagic.class, true);
		DimensionManager.registerDimension(Main.DIM_ID, Main.DIM_ID);
		
		for (Dungeon d : Main.DUNGEONS)
		{
			DimensionManager.registerProviderType(d.DIM_ID, WorldProviderDungeon.class, true);
			DimensionManager.registerDimension(d.DIM_ID, d.DIM_ID);
		}

		GameRegistry.registerWorldGenerator(new WorldGenChestElficStaff(), 0);
        GameRegistry.registerWorldGenerator(new WorldGenOrc(), 0);
        GameRegistry.registerWorldGenerator(new WorldGenFloatingHouse(), 0);
        GameRegistry.registerWorldGenerator(new WorldGenFloatingHouse2(), 0);
        GameRegistry.registerWorldGenerator(new WorldGenFloatingDungeon(), 0);
        GameRegistry.registerWorldGenerator(new WorldGenVillage(), 0);
        
		ServerPlayerAPI.register("Magic Crusade", ServerPlayerBaseMagic.class);
				
		for (int i = 0; i < 5; ++i)
			VillagerRegistry.instance().registerVillageTradeHandler(i, new TradeHandler());
		
		this.register_event(new ServerEvent());
		this.register_event(new JoueurEvent());
		this.register_event(new LivingEntityEvent());
    	
    	AchievementList.load();
	}

	public void spawnParticle(String string, double x, double y, double z) {}
	
	public void register_event(Object obj)
	{
    	FMLCommonHandler.instance().bus().register(obj);
    	MinecraftForge.EVENT_BUS.register(obj);
	}
}