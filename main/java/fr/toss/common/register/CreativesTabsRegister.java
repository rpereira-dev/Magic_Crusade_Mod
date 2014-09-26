package fr.toss.common.register;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class CreativesTabsRegister {
	
	public static CreativeTabs tabBlock;
	public static CreativeTabs tabItemUtil;
	public static CreativeTabs tabTools;
	public static CreativeTabs tabArmor;
	public static CreativeTabs tabArmorLoot;

	public static void load()
	{
		tabBlock = new CreativeTabs("block_magic")
		{
		    @Override
		    @SideOnly(Side.CLIENT)
		    public Item getTabIconItem() 
		    {
		        return Item.getItemFromBlock(BlockRegister.ORE_COMBUSTIUM);
		    }
		 };
		 
		tabItemUtil = new CreativeTabs("item_util")
		{
		    @Override
		    @SideOnly(Side.CLIENT)
		    public Item getTabIconItem() 
		    {
		        return ItemRegister.COMBUSTIUM;
		    }
		 };
		 
		tabTools = new CreativeTabs("item_tools")
		{
		    @Override
		    @SideOnly(Side.CLIENT)
		    public Item getTabIconItem() 
		    {
		        return ItemRegister.TITANIUM_PICKAXE;
		    }
		 };
		 
		 tabArmor = new CreativeTabs("item_fight")
		{
		    @Override
		    @SideOnly(Side.CLIENT)
		    public Item getTabIconItem() 
		    {
		        return ItemRegister.TITANIUM_CHESTPLATE;
		    }
		 };
		 
		 tabArmorLoot = new CreativeTabs("item_fight_loot")
		{
		    @Override
		    @SideOnly(Side.CLIENT)
		    public Item getTabIconItem() 
		    {
		        return ItemRegister.DPS_AP_HELMET[0];
		    }
		 };
		 
	}

	
	public static void loadAll()
	{
		BlockRegister.STONE.setCreativeTab(tabBlock);
		BlockRegister.DIRT.setCreativeTab(tabBlock);
		BlockRegister.GRASS.setCreativeTab(tabBlock);
		BlockRegister.ORE_ETHERNIUM.setCreativeTab(tabBlock);
		BlockRegister.ORE_SILVER.setCreativeTab(tabBlock);
		BlockRegister.ORE_TITANIUM.setCreativeTab(tabBlock);
		BlockRegister.ORE_COMBUSTIUM.setCreativeTab(tabBlock);
		BlockRegister.STONE_FALLING.setCreativeTab(tabBlock);
		BlockRegister.PORTAL_MY_GROV.setCreativeTab(tabBlock);
		BlockRegister.LOGS1.setCreativeTab(tabBlock);
		BlockRegister.PLANKS.setCreativeTab(tabBlock);
		BlockRegister.LEAVES.setCreativeTab(tabBlock);
		BlockRegister.BERRY_RED.setCreativeTab(tabBlock);
		BlockRegister.BERRY_YELLOW.setCreativeTab(tabBlock);
		BlockRegister.SNOW_TALLGRASS.setCreativeTab(tabBlock);
		BlockRegister.TALLGRASS.setCreativeTab(tabBlock);
		for (Block block : BlockRegister.PORTAL_DUNGEON)
			block.setCreativeTab(tabBlock);

		ItemRegister.COMBUSTIUM.setCreativeTab(tabItemUtil);
		ItemRegister.BERRY_RED.setCreativeTab(tabItemUtil);
		ItemRegister.BERRY_YELLOW.setCreativeTab(tabItemUtil);
		ItemRegister.SAUCISSE.setCreativeTab(tabItemUtil);
		ItemRegister.BLUE_STICK.setCreativeTab(tabItemUtil);
		ItemRegister.ARKAVON_GENERATOR.setCreativeTab(tabItemUtil);
		ItemRegister.INGOT_SILVER.setCreativeTab(tabItemUtil);
		ItemRegister.INGOT_TITANIUM.setCreativeTab(tabItemUtil);
		ItemRegister.ETHERNIUM.setCreativeTab(tabItemUtil);
		
		ItemRegister.ETHERNIUM_HATCHET.setCreativeTab(tabTools);
		ItemRegister.ETHERNIUM_HOE.setCreativeTab(tabTools);
		ItemRegister.ETHERNIUM_SHOVEL.setCreativeTab(tabTools);
		ItemRegister.ETHERNIUM_PICKAXE.setCreativeTab(tabTools);
		ItemRegister.TITANIUM_HATCHET.setCreativeTab(tabTools);
		ItemRegister.TITANIUM_HOE.setCreativeTab(tabTools);
		ItemRegister.TITANIUM_SHOVEL.setCreativeTab(tabTools);
		ItemRegister.TITANIUM_PICKAXE.setCreativeTab(tabTools);
		ItemRegister.SILVER_HATCHET.setCreativeTab(tabTools);
		ItemRegister.SILVER_HOE.setCreativeTab(tabTools);
		ItemRegister.SILVER_SHOVEL.setCreativeTab(tabTools);
		ItemRegister.SILVER_PICKAXE.setCreativeTab(tabTools);
		
		ItemRegister.SILVER_SWORD.setCreativeTab(tabTools);
		ItemRegister.ETHERNIUM_SWORD.setCreativeTab(tabTools);
		ItemRegister.TITANIUM_SWORD.setCreativeTab(tabTools);
		ItemRegister.wrathful_SWORD.setCreativeTab(tabTools);
		ItemRegister.baneful_SWORD.setCreativeTab(tabTools);
		ItemRegister.lethal_SWORD.setCreativeTab(tabTools);

		ItemRegister.SULFURAS.setCreativeTab(tabTools);
		ItemRegister.ASHBRINGER.setCreativeTab(tabTools);
		ItemRegister.ASHBRINGER_POISON.setCreativeTab(tabTools);
		ItemRegister.ELLAMAYNE.setCreativeTab(tabTools);
		ItemRegister.LAME_RUNIQUE.setCreativeTab(tabTools);
		ItemRegister.VALANYR.setCreativeTab(tabTools);
		ItemRegister.FAUX.setCreativeTab(tabTools);
		ItemRegister.LAME_TONERRE.setCreativeTab(tabTools);
		ItemRegister.SHALAMAYNE.setCreativeTab(tabTools);
		ItemRegister.SHALLATOR.setCreativeTab(tabTools);
		ItemRegister.SHADOWMOURNE.setCreativeTab(tabTools);
		ItemRegister.FROSTMOURNE.setCreativeTab(tabTools);
		
		ItemRegister.STAFF_ELFIC.setCreativeTab(tabTools);
		ItemRegister.STAFF_LIGHTNING.setCreativeTab(tabTools);
		ItemRegister.STAFF_BUMPING.setCreativeTab(tabTools);

		
		ItemRegister.TITANIUM_HELMET.setCreativeTab(tabArmor);
		ItemRegister.TITANIUM_CHESTPLATE.setCreativeTab(tabArmor);
		ItemRegister.TITANIUM_PANTS.setCreativeTab(tabArmor);
		ItemRegister.TITANIUM_BOOTS.setCreativeTab(tabArmor);
		
		ItemRegister.ETHERNIUM_HELMET.setCreativeTab(tabArmor);
		ItemRegister.ETHERNIUM_CHESTPLATE.setCreativeTab(tabArmor);
		ItemRegister.ETHERNIUM_PANTS.setCreativeTab(tabArmor);
		ItemRegister.ETHERNIUM_BOOTS.setCreativeTab(tabArmor);
		
		ItemRegister.SILVER_HELMET.setCreativeTab(tabArmor);
		ItemRegister.SILVER_CHESTPLATE.setCreativeTab(tabArmor);
		ItemRegister.SILVER_PANTS.setCreativeTab(tabArmor);
		ItemRegister.SILVER_BOOTS.setCreativeTab(tabArmor);

		ItemRegister.baneful_HELMET.setCreativeTab(tabArmor);
		ItemRegister.baneful_CHESTPLATE.setCreativeTab(tabArmor);
		ItemRegister.baneful_PANTS.setCreativeTab(tabArmor);
		ItemRegister.baneful_BOOTS.setCreativeTab(tabArmor);
		
		ItemRegister.wrathful_HELMET.setCreativeTab(tabArmor);
		ItemRegister.wrathful_CHESTPLATE.setCreativeTab(tabArmor);
		ItemRegister.wrathful_PANTS.setCreativeTab(tabArmor);
		ItemRegister.wrathful_BOOTS.setCreativeTab(tabArmor);
		
		ItemRegister.lethal_HELMET.setCreativeTab(tabArmor);
		ItemRegister.lethal_CHESTPLATE.setCreativeTab(tabArmor);
		ItemRegister.lethal_PANTS.setCreativeTab(tabArmor);
		ItemRegister.lethal_BOOTS.setCreativeTab(tabArmor);
		
		for (int i = 0; i < 8; i++)
		{
			ItemRegister.DPS_AD_BOOTS[i].setCreativeTab(tabArmorLoot);
			ItemRegister.DPS_AD_CHESTPLATE[i].setCreativeTab(tabArmorLoot);
			ItemRegister.DPS_AD_PANTS[i].setCreativeTab(tabArmorLoot);
			ItemRegister.DPS_AD_HELMET[i].setCreativeTab(tabArmorLoot);
			
			ItemRegister.DPS_AP_BOOTS[i].setCreativeTab(tabArmorLoot);
			ItemRegister.DPS_AP_CHESTPLATE[i].setCreativeTab(tabArmorLoot);
			ItemRegister.DPS_AP_PANTS[i].setCreativeTab(tabArmorLoot);
			ItemRegister.DPS_AP_HELMET[i].setCreativeTab(tabArmorLoot);
			
			ItemRegister.HEAL_BOOTS[i].setCreativeTab(tabArmorLoot);
			ItemRegister.HEAL_CHESTPLATE[i].setCreativeTab(tabArmorLoot);
			ItemRegister.HEAL_PANTS[i].setCreativeTab(tabArmorLoot);
			ItemRegister.HEAL_HELMET[i].setCreativeTab(tabArmorLoot);
			
			ItemRegister.SLY_BOOTS[i].setCreativeTab(tabArmorLoot);
			ItemRegister.SLY_CHESTPLATE[i].setCreativeTab(tabArmorLoot);
			ItemRegister.SLY_PANTS[i].setCreativeTab(tabArmorLoot);
			ItemRegister.SLY_HELMET[i].setCreativeTab(tabArmorLoot);
			
			ItemRegister.ENERGY_BOOTS[i].setCreativeTab(tabArmorLoot);
			ItemRegister.ENERGY_CHESTPLATE[i].setCreativeTab(tabArmorLoot);
			ItemRegister.ENERGY_PANTS[i].setCreativeTab(tabArmorLoot);
			ItemRegister.ENERGY_HELMET[i].setCreativeTab(tabArmorLoot);
			
			ItemRegister.RAGE_BOOTS[i].setCreativeTab(tabArmorLoot);
			ItemRegister.RAGE_CHESTPLATE[i].setCreativeTab(tabArmorLoot);
			ItemRegister.RAGE_PANTS[i].setCreativeTab(tabArmorLoot);
			ItemRegister.RAGE_HELMET[i].setCreativeTab(tabArmorLoot);
			
			ItemRegister.ROGUE_BOOTS[i].setCreativeTab(tabArmorLoot);
			ItemRegister.ROGUE_CHESTPLATE[i].setCreativeTab(tabArmorLoot);
			ItemRegister.ROGUE_PANTS[i].setCreativeTab(tabArmorLoot);
			ItemRegister.ROGUE_HELMET[i].setCreativeTab(tabArmorLoot);
			
			ItemRegister.TANK_BOOTS[i].setCreativeTab(tabArmorLoot);
			ItemRegister.TANK_CHESTPLATE[i].setCreativeTab(tabArmorLoot);
			ItemRegister.TANK_PANTS[i].setCreativeTab(tabArmorLoot);
			ItemRegister.TANK_HELMET[i].setCreativeTab(tabArmorLoot);
			
			ItemRegister.CUT[i].setCreativeTab(tabArmorLoot);
			ItemRegister.LANCE[i].setCreativeTab(tabArmorLoot);
			ItemRegister.GLAIVE[i].setCreativeTab(tabArmorLoot);
			ItemRegister.SWORD_UNO[i].setCreativeTab(tabArmorLoot);
			ItemRegister.MASSE[i].setCreativeTab(tabArmorLoot);
		}
		
	}
	
}
