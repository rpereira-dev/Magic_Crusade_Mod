package fr.toss.common.register;

import java.util.Random;

import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemSpade;

import org.apache.logging.log4j.LogManager;

import cpw.mods.fml.common.registry.GameRegistry;
import fr.toss.common.items.ItemArkavonLoader;
import fr.toss.common.items.ItemArmorM;
import fr.toss.common.items.ItemAshbringer;
import fr.toss.common.items.ItemAshbringerPoison;
import fr.toss.common.items.ItemAxeM;
import fr.toss.common.items.ItemBumpingStaff;
import fr.toss.common.items.ItemEllamayne;
import fr.toss.common.items.ItemFaux;
import fr.toss.common.items.ItemForestStaff;
import fr.toss.common.items.ItemFrostmourne;
import fr.toss.common.items.ItemLameTonerre;
import fr.toss.common.items.ItemLightningStaff;
import fr.toss.common.items.ItemPickaxeM;
import fr.toss.common.items.ItemShadowmourne;
import fr.toss.common.items.ItemSulfuras;
import fr.toss.common.items.ItemSwordEthernium;
import fr.toss.common.items.ItemSwordM;
import fr.toss.common.items.ItemValanyr;

public class ItemRegister {
	
	public static Item 		COMBUSTIUM;
	public static Item 		BERRY_YELLOW;
	public static Item 		BERRY_RED;
	public static Item 		SAUCISSE;
	public static Item 		BLUE_STICK;
	public static Item 		ARKAVON_GENERATOR;
	
	public static Item 		ETHERNIUM;
	public static Item 		INGOT_TITANIUM;
	public static Item 		INGOT_SILVER;
	
	public static Item 		SULFURAS;
	public static Item 		ASHBRINGER;
	public static Item 		ASHBRINGER_POISON;
	public static Item 		ELLAMAYNE;
	public static Item 		VALANYR;
	public static Item 		FAUX;
	public static Item 		LAME_TONERRE;
	
	public static Item 		SHALAMAYNE;
	public static Item 		SHALLATOR;
	public static Item 		SHADOWMOURNE;
	public static Item 		FROSTMOURNE;

	public static Item 		CUT[];
	public static Item 		SWORD_UNO[];
	public static Item 		GLAIVE[];
	public static Item		LANCE[];
	public static Item		MASSE[];

	public static Item 		LAME_RUNIQUE;

	public static Item 		STAFF_ELFIC;
	public static Item 		STAFF_LIGHTNING;
	public static Item		STAFF_BUMPING;
	
	public static Item		TITANIUM_HELMET;
	public static Item		TITANIUM_CHESTPLATE;
	public static Item		TITANIUM_PANTS;
	public static Item		TITANIUM_BOOTS;
	public static Item		TITANIUM_HOE;
	public static Item		TITANIUM_HATCHET;
	public static Item		TITANIUM_PICKAXE;
	public static Item		TITANIUM_SHOVEL; 
	public static Item		TITANIUM_SWORD; 

	public static Item		SILVER_HELMET;
	public static Item		SILVER_CHESTPLATE;
	public static Item		SILVER_PANTS;
	public static Item		SILVER_BOOTS;
	public static Item		SILVER_HOE;
	public static Item		SILVER_HATCHET;
	public static Item		SILVER_PICKAXE;
	public static Item		SILVER_SHOVEL; 
	public static Item		SILVER_SWORD; 

	public static Item		ETHERNIUM_HELMET;
	public static Item		ETHERNIUM_CHESTPLATE;
	public static Item		ETHERNIUM_PANTS;
	public static Item		ETHERNIUM_BOOTS;
	public static Item		ETHERNIUM_HOE;
	public static Item		ETHERNIUM_HATCHET;
	public static Item		ETHERNIUM_PICKAXE;
	public static Item		ETHERNIUM_SHOVEL; 
	public static Item		ETHERNIUM_SWORD; 

	public static Item		DPS_AD_HELMET[];
	public static Item		DPS_AD_CHESTPLATE[];
	public static Item		DPS_AD_PANTS[];
	public static Item		DPS_AD_BOOTS[];
	
	public static Item		ENERGY_HELMET[];
	public static Item		ENERGY_CHESTPLATE[];
	public static Item		ENERGY_PANTS[];
	public static Item		ENERGY_BOOTS[];
	
	public static Item		DPS_AP_HELMET[];
	public static Item		DPS_AP_CHESTPLATE[];
	public static Item		DPS_AP_PANTS[];
	public static Item		DPS_AP_BOOTS[];
	
	public static Item		HEAL_HELMET[];
	public static Item		HEAL_CHESTPLATE[];
	public static Item		HEAL_PANTS[];
	public static Item		HEAL_BOOTS[];
	
	public static Item		DPS_RAGE_HELMET[];
	public static Item		DPS_RAGE_CHESTPLATE[];
	public static Item		DPS_RAGE_PANTS[];
	public static Item		DPS_RAGE_BOOTS[];
	
	public static Item		TANK_HELMET[];
	public static Item		TANK_CHESTPLATE[];
	public static Item		TANK_PANTS[];
	public static Item		TANK_BOOTS[];
	
	public static Item		SLY_HELMET[];
	public static Item		SLY_CHESTPLATE[];
	public static Item		SLY_PANTS[];
	public static Item		SLY_BOOTS[];
	
	public static Item		ROGUE_HELMET[];
	public static Item		ROGUE_CHESTPLATE[];
	public static Item		ROGUE_PANTS[];
	public static Item		ROGUE_BOOTS[];
	
	public static Item		RAGE_HELMET[];
	public static Item		RAGE_CHESTPLATE[];
	public static Item		RAGE_PANTS[];
	public static Item		RAGE_BOOTS[];
	
	public static Item 		wrathful_HELMET;
	public static Item 		wrathful_CHESTPLATE;
	public static Item 		wrathful_PANTS;
	public static Item 		wrathful_BOOTS;
	public static Item 		wrathful_SWORD;

	public static Item 		lethal_HELMET;
	public static Item 		lethal_CHESTPLATE;
	public static Item 		lethal_PANTS;
	public static Item 		lethal_BOOTS;
	public static Item 		lethal_SWORD;

	public static Item 		baneful_HELMET;
	public static Item 		baneful_CHESTPLATE;
	public static Item 		baneful_PANTS;
	public static Item 		baneful_BOOTS;
	public static Item 		baneful_SWORD;

	public static void load() 
	{
		COMBUSTIUM = new Item().setUnlocalizedName("combustium").setTextureName("magiccrusade:combustium");
        GameRegistry.registerItem(COMBUSTIUM, "combustium");
        
        BERRY_YELLOW = new ItemFood(3, 0.3F, false).setUnlocalizedName("berry_yellow").setTextureName("magiccrusade:berry_yellow");
        GameRegistry.registerItem(BERRY_YELLOW, "berry_yellow");
        
        BERRY_RED = new ItemFood(3, 0.3F, false).setUnlocalizedName("berry_red").setTextureName("magiccrusade:berry_red");
        GameRegistry.registerItem(BERRY_RED, "berry_red");
        
        SAUCISSE = new ItemFood(3, 0.3F, false).setUnlocalizedName("saucisse").setTextureName("magiccrusade:saucisse");
        GameRegistry.registerItem(SAUCISSE, "saucisse");

        BLUE_STICK = new Item().setUnlocalizedName("blue_stick").setTextureName("magiccrusade:blue_stick");
        GameRegistry.registerItem(BLUE_STICK, "blue_stick");
	
        ARKAVON_GENERATOR = new ItemArkavonLoader().setUnlocalizedName("arkavon_generator").setTextureName("magiccrusade:blue_stick");
        GameRegistry.registerItem(ARKAVON_GENERATOR, "arkavon_generator");
        
        INGOT_TITANIUM = new Item().setUnlocalizedName("ingot_titanium").setTextureName("magiccrusade:ingot_titanium");
        GameRegistry.registerItem(INGOT_TITANIUM, "ingot_titanium");

        INGOT_SILVER = new Item().setUnlocalizedName("ingot_silver").setTextureName("magiccrusade:ingot_silver");
        GameRegistry.registerItem(INGOT_SILVER, "ingot_silver");

        ETHERNIUM = new Item().setUnlocalizedName("ethernium").setTextureName("magiccrusade:ethernium");
        GameRegistry.registerItem(ETHERNIUM, "ethernium");
        
        STAFF_ELFIC = new ItemForestStaff(EnumMaterial.STAFF);
        GameRegistry.registerItem(STAFF_ELFIC, "baton_elfique");
        
        STAFF_LIGHTNING = new ItemLightningStaff(EnumMaterial.STAFF);
        GameRegistry.registerItem(STAFF_LIGHTNING, "lightning_staff");
        
        STAFF_BUMPING = new ItemBumpingStaff(EnumMaterial.STAFF);
        GameRegistry.registerItem(STAFF_BUMPING, "bumping_staff");
        
        SULFURAS = new ItemSulfuras();
        GameRegistry.registerItem(SULFURAS, "sulfuras");

        ASHBRINGER = new ItemAshbringer();
        GameRegistry.registerItem(ASHBRINGER, "ashbringer");
        
        VALANYR = new ItemValanyr();
        GameRegistry.registerItem(VALANYR, "valanyr");
        
        FAUX = new ItemFaux();
        GameRegistry.registerItem(FAUX, "faux");
        
        LAME_TONERRE = new ItemLameTonerre();
        GameRegistry.registerItem(LAME_TONERRE, "lame_tonerre");
        
        ASHBRINGER_POISON = new ItemAshbringerPoison();
        GameRegistry.registerItem(ASHBRINGER_POISON, "ashbringer_poison");
        
        ELLAMAYNE = new ItemEllamayne();
        GameRegistry.registerItem(ELLAMAYNE, "ellamayne");

        LAME_RUNIQUE = ((ItemSwordM)new ItemSwordM(EnumMaterial.TOOL_TITANIUM).setUnlocalizedName("lame_runique").setTextureName("magiccrusade:LameRunique")).setHasEffect().setStrenght(50.0f);
        GameRegistry.registerItem(LAME_RUNIQUE, "lame_runique");
        
        SHALAMAYNE = ((ItemSwordM)new ItemSwordM(EnumMaterial.TOOL_ETHERNIUM).setUnlocalizedName("shalamayne").setTextureName("magiccrusade:shalamayne")).setHasEffect().setClarity(50.0f);
        GameRegistry.registerItem(SHALAMAYNE, "shalamayne");
        
        SHALLATOR = ((ItemSwordM)new ItemSwordM(EnumMaterial.TOOL_ETHERNIUM).setUnlocalizedName("shallator").setTextureName("magiccrusade:shallator")).setHasEffect().setClarity(50.0f);
        GameRegistry.registerItem(SHALLATOR, "shallator");
    	
        SHADOWMOURNE = new ItemShadowmourne();
        GameRegistry.registerItem(SHADOWMOURNE, "shadowmourne");
        
        FROSTMOURNE = new ItemFrostmourne();
        GameRegistry.registerItem(FROSTMOURNE, "frostmourne");
    	
    	LANCE = new ItemSwordM[8];
    	CUT = new ItemSwordM[8];
    	SWORD_UNO = new ItemSwordM[8];
    	MASSE = new ItemSwordM[8];
    	GLAIVE= new ItemSwordM[8];
        for (int i = 0; i < 8; i++)
        {
        	LANCE[i] = ((ItemSwordM)new ItemSwordM(EnumMaterial.TOOL_SILVER).setUnlocalizedName("lance").setTextureName("magiccrusade:lance")).setStrenght(4.0f + i * 2).setAgility(8.0f + i * 2);
	        GameRegistry.registerItem(LANCE[i], "lance_" + i);
	        
	        CUT[i] = ((ItemSwordM)new ItemSwordM(EnumMaterial.TOOL_SILVER).setUnlocalizedName("cut").setTextureName("magiccrusade:cut")).setStrenght(5.0f + i).setAgility(8.0f + i * 2);
	        GameRegistry.registerItem(CUT[i], "cut_" + i);
	        
	        SWORD_UNO[i] = ((ItemSwordM)new ItemSwordM(EnumMaterial.TOOL_SILVER).setUnlocalizedName("sword_uno").setTextureName("magiccrusade:sword_uno")).setStrenght(10.0f + i * 3);
	        GameRegistry.registerItem(SWORD_UNO[i], "sword_uno_" + i);
	        
	        GLAIVE[i] = ((ItemSwordM)new ItemSwordM(EnumMaterial.TOOL_SILVER).setUnlocalizedName("glaive").setTextureName("magiccrusade:glaive")).setStrenght(12.0f + i * 2);
	        GameRegistry.registerItem(GLAIVE[i], "glaive_" + i);
	        
	        MASSE[i] = ((ItemSwordM)new ItemSwordM(EnumMaterial.TOOL_SILVER).setUnlocalizedName("masse").setTextureName("magiccrusade:masse")).setManaRegen(1).setClarity(10 + i * 2);
	        GameRegistry.registerItem(MASSE[i], "masse_" + i);
        }
        
    	ETHERNIUM_HOE = new ItemHoe(EnumMaterial.TOOL_ETHERNIUM).setUnlocalizedName("ethernium_hoe").setTextureName("magiccrusade:ethernium_hoe");
    	ETHERNIUM_HATCHET = new ItemAxeM(EnumMaterial.TOOL_ETHERNIUM).setUnlocalizedName("ethernium_axe").setTextureName("magiccrusade:ethernium_axe");
    	ETHERNIUM_PICKAXE = new ItemPickaxeM(EnumMaterial.TOOL_ETHERNIUM).setUnlocalizedName("ethernium_pickaxe").setTextureName("magiccrusade:ethernium_pickaxe");
    	ETHERNIUM_SHOVEL = new ItemSpade(EnumMaterial.TOOL_ETHERNIUM).setUnlocalizedName("ethernium_shovel").setTextureName("magiccrusade:ethernium_shovel"); 
        GameRegistry.registerItem(ETHERNIUM_HOE, "ethernium_hoe");
        GameRegistry.registerItem(ETHERNIUM_HATCHET, "ethernium_axe");
        GameRegistry.registerItem(ETHERNIUM_PICKAXE, "ethernium_pickaxe");
        GameRegistry.registerItem(ETHERNIUM_SHOVEL, "ethernium_shovel");

    	SILVER_HOE = new ItemHoe(EnumMaterial.TOOL_SILVER).setUnlocalizedName("silver_hoe").setTextureName("magiccrusade:silver_hoe");
    	SILVER_HATCHET = new ItemAxeM(EnumMaterial.TOOL_SILVER).setUnlocalizedName("silver_axe").setTextureName("magiccrusade:silver_axe");
    	SILVER_PICKAXE = new ItemPickaxeM(EnumMaterial.TOOL_SILVER).setUnlocalizedName("silver_pickaxe").setTextureName("magiccrusade:silver_pickaxe");
    	SILVER_SHOVEL = new ItemSpade(EnumMaterial.TOOL_SILVER).setUnlocalizedName("silver_shovel").setTextureName("magiccrusade:silver_shovel"); 
        GameRegistry.registerItem(SILVER_HOE, "silver_hoe");
        GameRegistry.registerItem(SILVER_HATCHET, "silver_axe");
        GameRegistry.registerItem(SILVER_PICKAXE, "silver_pickaxe");
        GameRegistry.registerItem(SILVER_SHOVEL, "silver_shovel");
        
    	TITANIUM_HOE = new ItemHoe(EnumMaterial.TOOL_TITANIUM).setUnlocalizedName("titanium_hoe").setTextureName("magiccrusade:titanium_hoe");
    	TITANIUM_HATCHET = new ItemAxeM(EnumMaterial.TOOL_TITANIUM).setUnlocalizedName("titanium_axe").setTextureName("magiccrusade:titanium_axe");
    	TITANIUM_PICKAXE = new ItemPickaxeM(EnumMaterial.TOOL_TITANIUM).setUnlocalizedName("titanium_pickaxe").setTextureName("magiccrusade:titanium_pickaxe");
    	TITANIUM_SHOVEL = new ItemSpade(EnumMaterial.TOOL_TITANIUM).setUnlocalizedName("titanium_shovel").setTextureName("magiccrusade:titanium_shovel"); 
        GameRegistry.registerItem(TITANIUM_HOE, "titanium_hoe");
        GameRegistry.registerItem(TITANIUM_HATCHET, "titanium_axe");
        GameRegistry.registerItem(TITANIUM_PICKAXE, "titanium_pickaxe");
        GameRegistry.registerItem(TITANIUM_SHOVEL, "titanium_shovel");
        
        TITANIUM_HELMET = ((ItemArmorM) new ItemArmorM(EnumMaterial.titanium, 5, 0).setTextureName("magiccrusade:titanium_helmet").setUnlocalizedName("titanium_helmet")).setEndurance(20).setStrenght(10.0f);
        TITANIUM_CHESTPLATE = ((ItemArmorM) new ItemArmorM(EnumMaterial.titanium, 5, 1).setTextureName("magiccrusade:titanium_chestplate").setUnlocalizedName("titanium_chestplate")).setEndurance(40).setStrenght(20.0f);
        TITANIUM_PANTS = ((ItemArmorM) new ItemArmorM(EnumMaterial.titanium, 5, 2).setTextureName("magiccrusade:titanium_leggings").setUnlocalizedName("titanium_leggings")).setEndurance(30).setStrenght(14.0f);
        TITANIUM_BOOTS = ((ItemArmorM) new ItemArmorM(EnumMaterial.titanium, 5, 3).setTextureName("magiccrusade:titanium_boots").setUnlocalizedName("titanium_boots")).setEndurance(15).setStrenght(8.0f);
        GameRegistry.registerItem(TITANIUM_HELMET, "titanium_helmet");
        GameRegistry.registerItem(TITANIUM_CHESTPLATE, "titanium_chestplate");
        GameRegistry.registerItem(TITANIUM_PANTS, "titanium_pants");
        GameRegistry.registerItem(TITANIUM_BOOTS, "titanium_boots");
        
        SILVER_HELMET = ((ItemArmorM)new ItemArmorM(EnumMaterial.silver, 6, 0).setTextureName("magiccrusade:silver_helmet").setUnlocalizedName("silver_helmet")).setEndurance(10);
    	SILVER_CHESTPLATE = ((ItemArmorM)new ItemArmorM(EnumMaterial.silver, 6, 1).setTextureName("magiccrusade:silver_chestplate").setUnlocalizedName("silver_chestplate")).setEndurance(20);
    	SILVER_PANTS = ((ItemArmorM)new ItemArmorM(EnumMaterial.silver, 6, 2).setTextureName("magiccrusade:silver_leggings").setUnlocalizedName("silver_leggings")).setEndurance(15);
    	SILVER_BOOTS = ((ItemArmorM)new ItemArmorM(EnumMaterial.silver, 6, 3).setTextureName("magiccrusade:silver_boots").setUnlocalizedName("silver_boots")).setEndurance(5);
        GameRegistry.registerItem(SILVER_HELMET, "silver_helmet");
        GameRegistry.registerItem(SILVER_CHESTPLATE, "silver_chestplate");
        GameRegistry.registerItem(SILVER_PANTS, "silver_leggings");
        GameRegistry.registerItem(SILVER_BOOTS, "silver_boots");
        
        ETHERNIUM_HELMET = ((ItemArmorM)new ItemArmorM(EnumMaterial.ethernium, 7, 0).setTextureName("magiccrusade:ethernium_helmet").setUnlocalizedName("ethernium_helmet")).setAgility(10.0f).setStrenght(10.0f);
    	ETHERNIUM_CHESTPLATE = ((ItemArmorM)new ItemArmorM(EnumMaterial.ethernium, 7, 1).setTextureName("magiccrusade:ethernium_chestplate").setUnlocalizedName("ethernium_chestplate")).setAgility(24.0f).setStrenght(20.0f);
    	ETHERNIUM_PANTS = ((ItemArmorM)new ItemArmorM(EnumMaterial.ethernium, 7, 2).setTextureName("magiccrusade:ethernium_leggings").setUnlocalizedName("ethernium_leggings")).setAgility(14.0f).setStrenght(10.0f);
    	ETHERNIUM_BOOTS = ((ItemArmorM)new ItemArmorM(EnumMaterial.ethernium, 7, 3).setTextureName("magiccrusade:ethernium_boots").setUnlocalizedName("ethernium_boots")).setAgility(8.0f).setStrenght(10.0f);
        GameRegistry.registerItem(ETHERNIUM_HELMET, "ethernium_helmet");
        GameRegistry.registerItem(ETHERNIUM_CHESTPLATE, "ethernium_chestplate");
        GameRegistry.registerItem(ETHERNIUM_PANTS, "ethernium_leggings");
        GameRegistry.registerItem(ETHERNIUM_BOOTS, "ethernium_boots");
        
        wrathful_HELMET = ((ItemArmorM)new ItemArmorM(EnumMaterial.wrathful, 8, 0).setTextureName("magiccrusade:wrathful_helmet").setUnlocalizedName("wrathful_helmet")).setEndurance(60).setAgility(20.0f).setStrenght(24.0f).setHasEffect();
        wrathful_CHESTPLATE = ((ItemArmorM)new ItemArmorM(EnumMaterial.wrathful, 8, 1).setTextureName("magiccrusade:wrathful_chestplate").setUnlocalizedName("wrathful_chestplate")).setEndurance(74).setAgility(36.0f).setStrenght(32.0f).setHasEffect();
        wrathful_PANTS = ((ItemArmorM)new ItemArmorM(EnumMaterial.wrathful, 8, 2).setTextureName("magiccrusade:wrathful_leggings").setUnlocalizedName("wrathful_leggings")).setEndurance(68).setAgility(24.0f).setStrenght(28.0f).setHasEffect();
        wrathful_BOOTS = ((ItemArmorM)new ItemArmorM(EnumMaterial.wrathful, 8, 3).setTextureName("magiccrusade:wrathful_boots").setUnlocalizedName("wrathful_boots")).setEndurance(52).setAgility(18.0f).setStrenght(20.0f).setHasEffect();
        GameRegistry.registerItem(wrathful_HELMET, "wrathful_helmet");
        GameRegistry.registerItem(wrathful_CHESTPLATE, "wrathful_chestplate");
        GameRegistry.registerItem(wrathful_PANTS, "wrathful_leggings");
        GameRegistry.registerItem(wrathful_BOOTS, "wrathful_boots");
        
        lethal_HELMET = ((ItemArmorM)new ItemArmorM(EnumMaterial.lethal, 9, 0).setTextureName("magiccrusade:lethal_helmet").setUnlocalizedName("lethal_helmet")).setEndurance(60).setMana(600).setClarity(18).setManaRegen(2).setHasEffect();
        lethal_CHESTPLATE = ((ItemArmorM)new ItemArmorM(EnumMaterial.lethal, 9, 1).setTextureName("magiccrusade:lethal_chestplate").setUnlocalizedName("lethal_chestplate")).setEndurance(74).setMana(800).setClarity(24).setManaRegen(4).setHasEffect();
        lethal_PANTS = ((ItemArmorM)new ItemArmorM(EnumMaterial.lethal, 9, 2).setTextureName("magiccrusade:lethal_leggings").setUnlocalizedName("lethal_leggings")).setEndurance(68).setMana(680).setClarity(20.5f).setManaRegen(3).setHasEffect();
        lethal_BOOTS = ((ItemArmorM)new ItemArmorM(EnumMaterial.lethal, 9, 3).setTextureName("magiccrusade:lethal_boots").setUnlocalizedName("lethal_boots")).setEndurance(52).setMana(500).setClarity(14).setManaRegen(1).setHasEffect();
        GameRegistry.registerItem(lethal_HELMET, "lethal_helmet");
        GameRegistry.registerItem(lethal_CHESTPLATE, "lethal_chestplate");
        GameRegistry.registerItem(lethal_PANTS, "lethal_leggings");
        GameRegistry.registerItem(lethal_BOOTS, "lethal_boots");
        
        baneful_HELMET = ((ItemArmorM)new ItemArmorM(EnumMaterial.baneful, 10, 0).setTextureName("magiccrusade:baneful_helmet").setUnlocalizedName("baneful_helmet")).setEndurance(90).setStrenght(28.0f).setHasEffect();
        baneful_CHESTPLATE = ((ItemArmorM)new ItemArmorM(EnumMaterial.baneful, 7, 1).setTextureName("magiccrusade:baneful_chestplate").setUnlocalizedName("baneful_chestplate")).setEndurance(125).setStrenght(36.0f).setHasEffect();
        baneful_PANTS = ((ItemArmorM)new ItemArmorM(EnumMaterial.baneful, 10, 2).setTextureName("magiccrusade:baneful_leggings").setUnlocalizedName("baneful_leggings")).setEndurance(110).setStrenght(32.0f).setHasEffect();
        baneful_BOOTS = ((ItemArmorM)new ItemArmorM(EnumMaterial.baneful, 10, 3).setTextureName("magiccrusade:baneful_boots").setUnlocalizedName("baneful_boots")).setEndurance(80).setStrenght(26.0f).setHasEffect();
        GameRegistry.registerItem(baneful_HELMET, "baneful_helmet");
        GameRegistry.registerItem(baneful_CHESTPLATE, "baneful_chestplate");
        GameRegistry.registerItem(baneful_PANTS, "baneful_leggings");
        GameRegistry.registerItem(baneful_BOOTS, "baneful_boots");
        
        SILVER_SWORD = ((ItemSwordM)new ItemSwordM(EnumMaterial.TOOL_SILVER).setUnlocalizedName("silver_sword").setTextureName("magiccrusade:silver_sword")).setStrenght(10.0f);
        ETHERNIUM_SWORD = ((ItemSwordM)new ItemSwordEthernium(EnumMaterial.TOOL_ETHERNIUM).setUnlocalizedName("ethernium_sword").setTextureName("magiccrusade:ethernium_sword")).setAgility(20.0f);
        TITANIUM_SWORD = ((ItemSwordM)new ItemSwordM(EnumMaterial.TOOL_TITANIUM).setUnlocalizedName("titanium_sword").setTextureName("magiccrusade:titanium_sword")).setStrenght(20.0f);
        wrathful_SWORD = ((ItemSwordM)new ItemSwordM(EnumMaterial.TOOL_EPIC).setUnlocalizedName("wrathful_sword").setTextureName("magiccrusade:wrathful_sword")).setHasEffect().setStrenght(28.0f).setAgility(28.0f);
        lethal_SWORD = ((ItemSwordM) new ItemSwordM(EnumMaterial.TOOL_EPIC).setUnlocalizedName("lethal_sword").setTextureName("magiccrusade:lethal_sword")).setMana(1000).setClarity(30).setManaRegen(8).setHasEffect();
        baneful_SWORD = ((ItemSwordM)new ItemSwordM(EnumMaterial.TOOL_EPIC).setUnlocalizedName("baneful_sword").setTextureName("magiccrusade:baneful_sword")).setHasEffect().setStrenght(36.0f).setAgility(20.0f);
        GameRegistry.registerItem(SILVER_SWORD, "silver_sword");
        GameRegistry.registerItem(ETHERNIUM_SWORD, "ethernium_sword");
        GameRegistry.registerItem(TITANIUM_SWORD, "titanium_sword");
        GameRegistry.registerItem(wrathful_SWORD, "wrathful_sword");
        GameRegistry.registerItem(lethal_SWORD, "lethal_sword");
        GameRegistry.registerItem(baneful_SWORD, "baneful_sword");
        
        DPS_AD_HELMET = new ItemArmorM[8];
        DPS_AD_CHESTPLATE = new ItemArmorM[8];
        DPS_AD_PANTS = new ItemArmorM[8];
        DPS_AD_BOOTS = new ItemArmorM[8];
        
        ENERGY_HELMET = new ItemArmorM[8];
        ENERGY_CHESTPLATE = new ItemArmorM[8];
        ENERGY_PANTS = new ItemArmorM[8];
        ENERGY_BOOTS = new ItemArmorM[8];
        
        DPS_AP_HELMET = new ItemArmorM[8];
        DPS_AP_CHESTPLATE = new ItemArmorM[8];
        DPS_AP_PANTS = new ItemArmorM[8];
        DPS_AP_BOOTS = new ItemArmorM[8];
        
    	SLY_HELMET = new ItemArmorM[8];
    	SLY_CHESTPLATE = new ItemArmorM[8];
    	SLY_PANTS = new ItemArmorM[8];
    	SLY_BOOTS = new ItemArmorM[8];
    	
    	HEAL_HELMET = new ItemArmorM[8];
    	HEAL_CHESTPLATE = new ItemArmorM[8];
    	HEAL_PANTS = new ItemArmorM[8];
    	HEAL_BOOTS = new ItemArmorM[8];
    	
    	DPS_RAGE_HELMET = new ItemArmorM[8];
    	DPS_RAGE_CHESTPLATE = new ItemArmorM[8];
    	DPS_RAGE_PANTS = new ItemArmorM[8];
    	DPS_RAGE_BOOTS = new ItemArmorM[8];
    	
    	TANK_HELMET = new ItemArmorM[8];
    	TANK_CHESTPLATE = new ItemArmorM[8];
    	TANK_PANTS = new ItemArmorM[8];
    	TANK_BOOTS = new ItemArmorM[8];
    	
    	ROGUE_HELMET = new ItemArmorM[8];
    	ROGUE_CHESTPLATE = new ItemArmorM[8];
    	ROGUE_PANTS = new ItemArmorM[8];
    	ROGUE_BOOTS = new ItemArmorM[8];
    	
    	RAGE_HELMET = new ItemArmorM[8];
    	RAGE_CHESTPLATE = new ItemArmorM[8];
    	RAGE_PANTS = new ItemArmorM[8];
    	RAGE_BOOTS = new ItemArmorM[8];
    	
        for (int i = 0; i < 8; i++)
        {
        	DPS_AD_HELMET[i] = ((ItemArmorM)new ItemArmorM(EnumMaterial.dps_ad, 11, 0).setTextureName("magiccrusade:dps_ad_helmet").setUnlocalizedName("dps_ad_helmet")).setEndurance(10 + 4 * i).setStrenght(10 + 2 * i);
        	DPS_AD_CHESTPLATE[i] = ((ItemArmorM)new ItemArmorM(EnumMaterial.dps_ad, 11, 1).setTextureName("magiccrusade:dps_ad_chestplate").setUnlocalizedName("dps_ad_chestplate")).setEndurance(18 + 4 * i).setStrenght(16 + 2 * i);
            DPS_AD_PANTS[i] = ((ItemArmorM)new ItemArmorM(EnumMaterial.dps_ad, 11, 2).setTextureName("magiccrusade:dps_ad_leggings").setUnlocalizedName("dps_ad_leggings")).setEndurance(14 + 4 * i).setStrenght(12 + 2 * i);
            DPS_AD_BOOTS[i] = ((ItemArmorM)new ItemArmorM(EnumMaterial.dps_ad, 11, 3).setTextureName("magiccrusade:dps_ad_boots").setUnlocalizedName("dps_ad_boots")).setEndurance(8 + 4 * i).setStrenght(8 + 2 * i);
            GameRegistry.registerItem(DPS_AD_HELMET[i], "dps_ad_helmet_" + i);
            GameRegistry.registerItem(DPS_AD_CHESTPLATE[i], "dps_ad_chestplate_" + i);
            GameRegistry.registerItem(DPS_AD_PANTS[i], "dps_ad_leggings_" + i);
            GameRegistry.registerItem(DPS_AD_BOOTS[i], "dps_ad_boots_" + i);
            
        	SLY_HELMET[i] = ((ItemArmorM)new ItemArmorM(EnumMaterial.sly, 12, 0).setTextureName("magiccrusade:sly_helmet").setUnlocalizedName("sly_helmet")).setEndurance(10 + 4 * i).setAgility(10 + 2 * i);
        	SLY_CHESTPLATE[i] = ((ItemArmorM)new ItemArmorM(EnumMaterial.sly, 12, 1).setTextureName("magiccrusade:sly_chestplate").setUnlocalizedName("sly_chestplate")).setEndurance(18 + 4 * i).setAgility(16 + 2 * i);
        	SLY_PANTS[i] = ((ItemArmorM)new ItemArmorM(EnumMaterial.sly, 12, 2).setTextureName("magiccrusade:sly_leggings").setUnlocalizedName("sly_leggings")).setEndurance(14 + 4 * i).setAgility(12 + 2 * i);
        	SLY_BOOTS[i] = ((ItemArmorM)new ItemArmorM(EnumMaterial.sly, 12, 3).setTextureName("magiccrusade:sly_boots").setUnlocalizedName("sly_boots")).setEndurance(8 + 4 * i).setAgility(8 + 2 * i);
            GameRegistry.registerItem(SLY_HELMET[i], "sly_helmet_" + i);
            GameRegistry.registerItem(SLY_CHESTPLATE[i], "sly_chestplate_" + i);
            GameRegistry.registerItem(SLY_PANTS[i], "sly_leggings_" + i);
            GameRegistry.registerItem(SLY_BOOTS[i], "sly_boots_" + i);
            
        	HEAL_HELMET[i] = ((ItemArmorM)new ItemArmorM(EnumMaterial.heal, 13, 0).setTextureName("magiccrusade:heal_helmet").setUnlocalizedName("heal_helmet")).setEndurance(10 + 4 * i).setClarity(10 + 1.5f * i).setManaRegen(0.2f * i);
        	HEAL_CHESTPLATE[i] = ((ItemArmorM)new ItemArmorM(EnumMaterial.heal, 13, 1).setTextureName("magiccrusade:heal_chestplate").setUnlocalizedName("heal_chestplate")).setEndurance(18 + 4 * i).setClarity(16 + 1.5f * i).setManaRegen(0.4f * i);
        	HEAL_PANTS[i] = ((ItemArmorM)new ItemArmorM(EnumMaterial.heal, 13, 2).setTextureName("magiccrusade:heal_leggings").setUnlocalizedName("heal_leggings")).setEndurance(14 + 4 * i).setClarity(12 + 1.5f * i).setManaRegen(0.3f * i);
        	HEAL_BOOTS[i] = ((ItemArmorM)new ItemArmorM(EnumMaterial.heal, 13, 3).setTextureName("magiccrusade:heal_boots").setUnlocalizedName("heal_boots")).setEndurance(8 + 4 * i).setClarity(8 + 1.5f * i).setManaRegen(0.15f * i);
            GameRegistry.registerItem(HEAL_HELMET[i], "heal_helmet_" + i);
            GameRegistry.registerItem(HEAL_CHESTPLATE[i], "heal_chestplate_" + i);
            GameRegistry.registerItem(HEAL_PANTS[i], "heal_leggings_" + i);
            GameRegistry.registerItem(HEAL_BOOTS[i], "heal_boots_" + i);
            
        	TANK_HELMET[i] = ((ItemArmorM)new ItemArmorM(EnumMaterial.tank, 14, 0).setTextureName("magiccrusade:tank_helmet").setUnlocalizedName("tank_helmet")).setEndurance(10 + 5 * i).setStrenght(10 + 2 * i);
        	TANK_CHESTPLATE[i] = ((ItemArmorM)new ItemArmorM(EnumMaterial.tank, 14, 1).setTextureName("magiccrusade:tank_chestplate").setUnlocalizedName("tank_chestplate")).setEndurance(16 + 5 * i).setStrenght(16 + 2 * i);
        	TANK_PANTS[i] = ((ItemArmorM)new ItemArmorM(EnumMaterial.tank, 14, 2).setTextureName("magiccrusade:tank_leggings").setUnlocalizedName("tank_leggings")).setEndurance(12 + 6 * i).setStrenght(12 + 2 * i);
        	TANK_BOOTS[i] = ((ItemArmorM)new ItemArmorM(EnumMaterial.tank, 14, 3).setTextureName("magiccrusade:tank_boots").setUnlocalizedName("tank_boots")).setEndurance(8 + 5 * i).setStrenght(8 + 2 * i);
            GameRegistry.registerItem(TANK_HELMET[i], "tank_helmet_" + i);
            GameRegistry.registerItem(TANK_CHESTPLATE[i], "tank_chestplate_" + i);
            GameRegistry.registerItem(TANK_PANTS[i], "tank_leggings_" + i);
            GameRegistry.registerItem(TANK_BOOTS[i], "tank_boots_" + i);
        
        	DPS_AP_HELMET[i] = ((ItemArmorM)new ItemArmorM(EnumMaterial.dps_ap, 15, 0).setTextureName("magiccrusade:dps_ap_helmet").setUnlocalizedName("dps_ap_helmet")).setEndurance(10 + 5 * i).setClarity(10 + 2 * i);
        	DPS_AP_CHESTPLATE[i] = ((ItemArmorM)new ItemArmorM(EnumMaterial.dps_ap, 15, 1).setTextureName("magiccrusade:dps_ap_chestplate").setUnlocalizedName("dps_ap_chestplate")).setEndurance(16 + 5 * i).setClarity(16 + 2 * i);
        	DPS_AP_PANTS[i] = ((ItemArmorM)new ItemArmorM(EnumMaterial.dps_ap, 15, 2).setTextureName("magiccrusade:dps_ap_leggings").setUnlocalizedName("dps_ap_leggings")).setEndurance(12 + 6 * i).setClarity(12 + 2 * i);
        	DPS_AP_BOOTS[i] = ((ItemArmorM)new ItemArmorM(EnumMaterial.dps_ap, 15, 3).setTextureName("magiccrusade:dps_ap_boots").setUnlocalizedName("dps_ap_boots")).setEndurance(8 + 5 * i).setClarity(8 + 2 * i);
            GameRegistry.registerItem(DPS_AP_HELMET[i], "dps_ap_helmet_" + i);
            GameRegistry.registerItem(DPS_AP_CHESTPLATE[i], "dps_ap_chestplate_" + i);
            GameRegistry.registerItem(DPS_AP_PANTS[i], "dps_ap_leggings_" + i);
            GameRegistry.registerItem(DPS_AP_BOOTS[i], "dps_ap_boots_" + i);
            
        	ENERGY_HELMET[i] = ((ItemArmorM)new ItemArmorM(EnumMaterial.energy, 16, 0).setTextureName("magiccrusade:energy_helmet").setUnlocalizedName("energy_helmet")).setEndurance(10 + 3 * i).setAgility(8 + 1.5f * i).setStrenght(8 + 1.5f * i);
        	ENERGY_CHESTPLATE[i] = ((ItemArmorM)new ItemArmorM(EnumMaterial.energy, 16, 1).setTextureName("magiccrusade:energy_chestplate").setUnlocalizedName("energy_chestplate")).setEndurance(18 + 3 * i).setAgility(14 + 1.5f * i).setStrenght(14 + 1.5f * i);
        	ENERGY_PANTS[i] = ((ItemArmorM)new ItemArmorM(EnumMaterial.energy, 16, 2).setTextureName("magiccrusade:energy_leggings").setUnlocalizedName("energy_leggings")).setEndurance(14 + 3 * i).setAgility(10 + 1.5f * i).setStrenght(10 + 1.5f * i);
        	ENERGY_BOOTS[i] = ((ItemArmorM)new ItemArmorM(EnumMaterial.energy, 16, 3).setTextureName("magiccrusade:energy_boots").setUnlocalizedName("energy_boots")).setEndurance(8 + 3 * i).setAgility(6 + 1.5f * i).setStrenght(6 + 1.5f * i);
            GameRegistry.registerItem(ENERGY_HELMET[i], "energy_helmet_" + i);
            GameRegistry.registerItem(ENERGY_CHESTPLATE[i], "energy_chestplate_" + i);
            GameRegistry.registerItem(ENERGY_PANTS[i], "energy_leggings_" + i);
            GameRegistry.registerItem(ENERGY_BOOTS[i], "energy_boots_" + i);
            
        	ROGUE_HELMET[i] = ((ItemArmorM)new ItemArmorM(EnumMaterial.rogue, 17, 0).setTextureName("magiccrusade:rogue_helmet").setUnlocalizedName("rogue_helmet")).setAgility(10 + 2 * i).setStrenght(10 + 2 * i);
        	ROGUE_CHESTPLATE[i] = ((ItemArmorM)new ItemArmorM(EnumMaterial.rogue, 17, 1).setTextureName("magiccrusade:rogue_chestplate").setUnlocalizedName("rogue_chestplate")).setAgility(16 + 2 * i).setStrenght(16 + 2 * i);
        	ROGUE_PANTS[i] = ((ItemArmorM)new ItemArmorM(EnumMaterial.rogue, 17, 2).setTextureName("magiccrusade:rogue_leggings").setUnlocalizedName("rogue_leggings")).setAgility(12 + 2 * i).setStrenght(12 + 2 * i);
        	ROGUE_BOOTS[i] = ((ItemArmorM)new ItemArmorM(EnumMaterial.rogue, 17, 3).setTextureName("magiccrusade:rogue_boots").setUnlocalizedName("rogue_boots")).setAgility(8 + 2 * i).setStrenght(8 + 2 * i);
            GameRegistry.registerItem(ROGUE_HELMET[i], "rogue_helmet_" + i);
            GameRegistry.registerItem(ROGUE_CHESTPLATE[i], "rogue_chestplate_" + i);
            GameRegistry.registerItem(ROGUE_PANTS[i], "rogue_leggings_" + i);
            GameRegistry.registerItem(ROGUE_BOOTS[i], "rogue_boots_" + i);
            
        	RAGE_HELMET[i] = ((ItemArmorM)new ItemArmorM(EnumMaterial.rage, 18, 0).setTextureName("magiccrusade:rage_helmet").setUnlocalizedName("rage_helmet")).setAgility(10 + 2 * i).setStrenght(10 + 2 * i);
        	RAGE_CHESTPLATE[i] = ((ItemArmorM)new ItemArmorM(EnumMaterial.rage, 18, 1).setTextureName("magiccrusade:rage_chestplate").setUnlocalizedName("rage_chestplate")).setAgility(16 + 2 * i).setStrenght(16 + 2 * i);
        	RAGE_PANTS[i] = ((ItemArmorM)new ItemArmorM(EnumMaterial.rage, 18, 2).setTextureName("magiccrusade:rage_leggings").setUnlocalizedName("rage_leggings")).setAgility(12 + 2 * i).setStrenght(12 + 2 * i);
        	RAGE_BOOTS[i] = ((ItemArmorM)new ItemArmorM(EnumMaterial.rage, 18, 3).setTextureName("magiccrusade:rage_boots").setUnlocalizedName("rage_boots")).setAgility(8 + 2 * i).setStrenght(8 + 2 * i);
            GameRegistry.registerItem(RAGE_HELMET[i], "rage_helmet_" + i);
            GameRegistry.registerItem(RAGE_CHESTPLATE[i], "rage_chestplate_" + i);
            GameRegistry.registerItem(RAGE_PANTS[i], "rage_leggings_" + i);
            GameRegistry.registerItem(RAGE_BOOTS[i], "rage_boots_" + i);
        }
	}
	
	public static int getNextId()
	{
		int i;
		
		i = 0;
		while (Item.itemRegistry.containsId(i))
			i++;
		LogManager.getLogger().info("ID registered: " + i);
		return (i);
	}
	
	public static Item getRandomArmor()
	{
		Random rand;
		
		rand = new Random();
		
		switch (rand.nextInt(37))
		{
		
/**--------------------------------------------------------------------------------------*/
			case 0 :
				return DPS_AP_HELMET[rand.nextInt(8)];
				
			case 1 :
				return DPS_AP_CHESTPLATE[rand.nextInt(8)];
				
			case 2 :
				return DPS_AP_PANTS[rand.nextInt(8)];
				
			case 3 :
				return DPS_AP_BOOTS[rand.nextInt(8)];
				
/**--------------------------------------------------------------------------------------*/
				
			case 4 :
				return DPS_AD_HELMET[rand.nextInt(8)];
				
			case 5:
				return DPS_AD_CHESTPLATE[rand.nextInt(8)];
				
			case 6 :
				return DPS_AD_PANTS[rand.nextInt(8)];
				
			case 7 :
				return DPS_AD_BOOTS[rand.nextInt(8)];
				
/**--------------------------------------------------------------------------------------*/
				
			case 8 :
				return TANK_HELMET[rand.nextInt(8)];
				
			case 9:
				return TANK_CHESTPLATE[rand.nextInt(8)];
				
			case 10 :
				return TANK_PANTS[rand.nextInt(8)];
				
			case 11 :
				return TANK_BOOTS[rand.nextInt(8)];
				
/**--------------------------------------------------------------------------------------*/
				
			case 12 :
				return HEAL_HELMET[rand.nextInt(8)];
				
			case 13 :
				return HEAL_CHESTPLATE[rand.nextInt(8)];
				
			case 14 :
				return HEAL_PANTS[rand.nextInt(8)];
				
			case 15 :
				return HEAL_BOOTS[rand.nextInt(8)];
				
/**--------------------------------------------------------------------------------------*/
				
			case 16 :
				return ENERGY_HELMET[rand.nextInt(8)];
				
			case 17 :
				return ENERGY_CHESTPLATE[rand.nextInt(8)];
				
			case 18 :
				return ENERGY_PANTS[rand.nextInt(8)];
				
			case 19 :
				return ENERGY_BOOTS[rand.nextInt(8)];
				
/**--------------------------------------------------------------------------------------*/
				
			case 20 :
				return SLY_HELMET[rand.nextInt(8)];
				
			case 21 :
				return SLY_CHESTPLATE[rand.nextInt(8)];
				
			case 22 :
				return SLY_PANTS[rand.nextInt(8)];
				
			case 23 :
				return SLY_BOOTS[rand.nextInt(8)];
				
/**--------------------------------------------------------------------------------------*/
				
			case 24 :
				return ROGUE_HELMET[rand.nextInt(8)];
				
			case 25 :
				return ROGUE_CHESTPLATE[rand.nextInt(8)];
				
			case 26 :
				return ROGUE_PANTS[rand.nextInt(8)];
				
			case 27 :
				return ROGUE_BOOTS[rand.nextInt(8)];
				
/**--------------------------------------------------------------------------------------*/
				
			case 28 :
				return RAGE_HELMET[rand.nextInt(8)];
				
			case 29 :
				return RAGE_CHESTPLATE[rand.nextInt(8)];
				
			case 30 :
				return RAGE_PANTS[rand.nextInt(8)];
				
			case 31 :
				return RAGE_BOOTS[rand.nextInt(8)];
			
/**--------------------------------------------------------------------------------------*/

			case 32 :
				return GLAIVE[rand.nextInt(8)];
				
			case 33 :
				return LANCE[rand.nextInt(8)];
				
			case 34 :
				return CUT[rand.nextInt(8)];
				
			case 35 :
				return SWORD_UNO[rand.nextInt(8)];
				
			case 36 :
				return MASSE[rand.nextInt(8)];
		}
		
		return (null);
	}
}
