package fr.toss.common.register;

import net.minecraft.stats.Achievement;
import net.minecraftforge.common.AchievementPage;

public class AchievementList {
	
	public static final Achievement NEW_DIMENSION = new Achievement("new_dimension", "new_dimension", 1, -2, BlockRegister.ORE_ETHERNIUM, null).registerStat();

	public static final Achievement NEW_ITEMS = new Achievement("new_items", "new_items", 3, -2, ItemRegister.BLUE_STICK, NEW_DIMENSION).registerStat();

	public static final Achievement SILVER_PICKAXE = new Achievement("silver_pickaxe", "silver_pickaxe", 5, -2, ItemRegister.SILVER_PICKAXE, NEW_ITEMS).registerStat();

	public static final Achievement TITANIUM_STUFF = new Achievement("titanium_stuff", "titanium_stuff", 3, -4, ItemRegister.TITANIUM_CHESTPLATE, NEW_ITEMS).registerStat();

	public static final Achievement ETHERNIUM_SWORD = new Achievement("ethernium_sword", "ethernium_sword", 3, 0, ItemRegister.ETHERNIUM_SWORD, NEW_ITEMS).registerStat();

	public static final Achievement SULFURAS = new Achievement("sulfuron", "sulfuron", 1, 0, ItemRegister.SULFURAS, null).registerStat();

	public static final Achievement MAGIC_STAFF = new Achievement("magic_staff", "magic_staff", 1, 1, ItemRegister.STAFF_ELFIC, null).registerStat();

	public static void load()
	{
		AchievementPage.registerAchievementPage(new AchievementPage("Magic Crusade", NEW_DIMENSION, NEW_ITEMS, SILVER_PICKAXE, TITANIUM_STUFF, ETHERNIUM_SWORD, SULFURAS, MAGIC_STAFF));
	}
}
