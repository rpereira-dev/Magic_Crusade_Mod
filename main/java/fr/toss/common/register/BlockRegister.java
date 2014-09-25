package fr.toss.common.register;

import net.minecraft.block.Block;
import net.minecraft.block.BlockStone;

import org.apache.logging.log4j.LogManager;

import cpw.mods.fml.common.registry.GameRegistry;
import fr.toss.common.Main;
import fr.toss.common.blocks.BlockDirtDim;
import fr.toss.common.blocks.BlockFlowers;
import fr.toss.common.blocks.BlockGrassDim;
import fr.toss.common.blocks.BlockLeavesDim;
import fr.toss.common.blocks.BlockLeavesDim.LeafCategory;
import fr.toss.common.blocks.BlockLogDim;
import fr.toss.common.blocks.BlockLogDim.LogCategory;
import fr.toss.common.blocks.BlockOreEthernium;
import fr.toss.common.blocks.BlockOreMagic;
import fr.toss.common.blocks.BlockPlankDim;
import fr.toss.common.blocks.BlockPortalDungeon;
import fr.toss.common.blocks.BlockPortalMagic;
import fr.toss.common.blocks.BlockStoneFalling;
import fr.toss.common.blocks.ItemBlockLog;
import fr.toss.common.blocks.ItemBlockPlank;
import fr.toss.common.world.dungeon.Dungeon;

public class BlockRegister {
	
	public static Block[] 				PORTAL_DUNGEON;
	public static BlockStoneFalling 	STONE_FALLING;
	public static Block 				STONE;
	public static BlockGrassDim 		GRASS;
	public static Block 				DIRT;
	public static BlockPortalMagic 		PORTAL_MY_GROV;

	public static BlockOreEthernium 	ORE_ETHERNIUM;
	public static BlockOreMagic 		ORE_SILVER;
	public static BlockOreMagic 		ORE_TITANIUM;
	public static BlockOreMagic 		ORE_COMBUSTIUM;
	public static BlockLogDim 			LOGS1;
	public static BlockPlankDim			PLANKS;
	public static BlockLeavesDim 		LEAVES;
	public static Block 				BERRY_RED;
	public static Block 				BERRY_YELLOW;
	public static Block 				SNOW_TALLGRASS;
	public static Block 				TALLGRASS;

	public static void load() 
	{   
		STONE 			= new BlockStone().setHardness(1.5F).setResistance(10.0F).setStepSound(Block.soundTypeStone).setBlockName("stone").setBlockTextureName("magiccrusade:stone_dim");
		GameRegistry.registerBlock(STONE, "stone_dim");

		DIRT 			= new BlockDirtDim().setHardness(0.5F).setStepSound(Block.soundTypeGravel).setBlockName("dirt").setBlockTextureName("magiccrusade:dirt_dim");
		GameRegistry.registerBlock(DIRT, "dirt_dim");

		GRASS 			= (BlockGrassDim) new BlockGrassDim().setHardness(0.6F).setStepSound(Block.soundTypeGrass).setBlockName("grass").setBlockTextureName("magiccrusade:grass_dim");
		GameRegistry.registerBlock(GRASS, "grass_dim");
		
		STONE_FALLING 	= new BlockStoneFalling();
		GameRegistry.registerBlock(STONE_FALLING, "stone_falling");
		
        PORTAL_MY_GROV	= new BlockPortalMagic(Main.DIM_ID);
		GameRegistry.registerBlock(PORTAL_MY_GROV, "portal_dim");
		
		int i;
		
		i = 0;
		PORTAL_DUNGEON = new BlockPortalDungeon[2];
		for (Dungeon d : Main.DUNGEONS)
		{
	        PORTAL_DUNGEON[i] = new BlockPortalDungeon(d.DIM_ID);
			GameRegistry.registerBlock(PORTAL_DUNGEON[i], "portal_dungeon_" + d.file_name);
			i++;
		}

		LOGS1 			= new BlockLogDim(LogCategory.CAT1);
		GameRegistry.registerBlock(LOGS1, ItemBlockLog.class, "log_1");
		
		PLANKS			= new BlockPlankDim();
		GameRegistry.registerBlock(PLANKS, ItemBlockPlank.class, "planks_1");
		
		LEAVES		  	= new BlockLeavesDim(LeafCategory.CAT1);
		GameRegistry.registerBlock(LEAVES, "leaves_dim");
		
		BERRY_RED		= new BlockFlowers().setBlockName("berry_red").setBlockTextureName("magiccrusade:berry_red");
		GameRegistry.registerBlock(BERRY_RED, "red_berry");
		
		BERRY_YELLOW	= new BlockFlowers().setBlockName("berry_yellow").setBlockTextureName("magiccrusade:berry_yellow");
		GameRegistry.registerBlock(BERRY_YELLOW, "yellow_berry");
		
		SNOW_TALLGRASS	= new BlockFlowers().setBlockName("tallgrass_snowed").setBlockTextureName("magiccrusade:tallgrass_snowed");
		GameRegistry.registerBlock(SNOW_TALLGRASS, "tallgrass_snowed");
		
		TALLGRASS		= new BlockFlowers().setBlockName("tallgrass").setBlockTextureName("magiccrusade:tallgrass_dim");
		GameRegistry.registerBlock(TALLGRASS, "tallgrass_dim");
		
		ORE_ETHERNIUM 	= new BlockOreEthernium();
		GameRegistry.registerBlock(ORE_ETHERNIUM, "ore_ethernium");
		
		ORE_SILVER 		= (BlockOreMagic) new BlockOreMagic().setBlockName("ore_silver").setBlockTextureName("magiccrusade:ore_silver").setHardness(2.0f);
		GameRegistry.registerBlock(ORE_SILVER, "ore_silver");
		
		ORE_TITANIUM 	= (BlockOreMagic) new BlockOreMagic().setBlockName("ore_titanium").setBlockTextureName("magiccrusade:ore_titanium").setHardness(2.0f);
		GameRegistry.registerBlock(ORE_TITANIUM, "ore_titanium");
		
		ORE_COMBUSTIUM	= (BlockOreMagic) new BlockOreMagic().setBlockName("ore_combustium").setBlockTextureName("magiccrusade:ore_combustium").setHardness(2.0f);
		GameRegistry.registerBlock(ORE_COMBUSTIUM, "ore_combustium");

	}
	
	public static int getNextId()
	{
		int i;
		
		i = 0;
		while (Block.blockRegistry.containsId(i))
			i++;
		LogManager.getLogger().info("ID registered: " + i);
		return (i);
	}
}
