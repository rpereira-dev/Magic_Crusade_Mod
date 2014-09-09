package fr.toss.common;

import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.common.MinecraftForge;
import api.player.server.ServerPlayerAPI;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.VillagerRegistry;
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
import fr.toss.common.world.bioms.deco.WorldGenOrc;

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
        GameRegistry.registerWorldGenerator(new WorldGenChestElficStaff(), 0);
        GameRegistry.registerWorldGenerator(new WorldGenOrc(), 0);
        
		ServerPlayerAPI.register("Magic Crusade", ServerPlayerBaseMagic.class);
				
		for (int i = 0; i < 5; ++i)
			VillagerRegistry.instance().registerVillageTradeHandler(i, new TradeHandler());
		
		ServerEvent events = new ServerEvent();
    	FMLCommonHandler.instance().bus().register(events);
    	MinecraftForge.EVENT_BUS.register(events);
    	
    	AchievementList.load();
	}

	public void spawnParticle(String string, double x, double y, double z) {}
}