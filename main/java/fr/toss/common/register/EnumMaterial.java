package fr.toss.common.register;

import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.util.EnumChatFormatting;
import net.minecraftforge.common.util.EnumHelper;

public class EnumMaterial {
		
	public static ToolMaterial TOOL_TITANIUM = EnumHelper.addToolMaterial("Titanium", 4, 1561 * 2, 10.0F, 3.5F, 20);
	public static ToolMaterial TOOL_ETHERNIUM = EnumHelper.addToolMaterial("Ethernium", 4, 1561, 10.0F, 3.5F, 50);
	public static ToolMaterial TOOL_SILVER = EnumHelper.addToolMaterial("Silver", 4, 1561, 7.0F, 2.5F, 20);
	public static ToolMaterial TOOL_EPIC = EnumHelper.addToolMaterial("Epic", 4, 1561 * 10, 10.0F, 5.0F, 50);
	public static ToolMaterial TOOL_ZERO = EnumHelper.addToolMaterial("Zero", 0, 1561 * 2, 0.0F, 0.0F, 100);
	public static ToolMaterial STAFF = EnumHelper.addToolMaterial("Staff", 4, 200, 6.0F, 2.5F, 50);

	public static ArmorMaterial titanium = EnumHelper.addArmorMaterial("Titanium", 40, new int[]{4, 9, 7, 3}, 20);
	public static ArmorMaterial ethernium = EnumHelper.addArmorMaterial("Ethernium", 30, new int[]{3, 8, 6, 3}, 50);
	public static ArmorMaterial silver = EnumHelper.addArmorMaterial("Silver", 15, new int[]{3, 7, 5, 2}, 20);
	public static ArmorMaterial wrathful = EnumHelper.addArmorMaterial("Wrathful", 40, new int[]{4, 9, 7, 3}, 20);
	public static ArmorMaterial lethal = EnumHelper.addArmorMaterial("Lethal", 40, new int[]{4, 9, 7, 3}, 20);
	public static ArmorMaterial baneful = EnumHelper.addArmorMaterial("Baneful", 40, new int[]{4, 9, 7, 3}, 20);
	
	public static ArmorMaterial dragon_slayer = EnumHelper.addArmorMaterial("Dragonslayer", 30, new int[]{3, 8, 6, 3}, 30);
	public static ArmorMaterial champion = EnumHelper.addArmorMaterial("Champion", 30, new int[]{3, 8, 6, 3}, 30);
	public static ArmorMaterial brutal = EnumHelper.addArmorMaterial("Brutal", 30, new int[]{3, 8, 6, 3}, 30);
	public static ArmorMaterial rage = EnumHelper.addArmorMaterial("Rage", 30, new int[]{3, 8, 6, 3}, 30); //done
	public static ArmorMaterial dps_ad = EnumHelper.addArmorMaterial("Dps_ad", 30, new int[]{3, 8, 6, 3}, 30); //done
	public static ArmorMaterial dps_ap = EnumHelper.addArmorMaterial("Magical", 30, new int[]{2, 7, 5, 2}, 30); //done
	public static ArmorMaterial heal = EnumHelper.addArmorMaterial("Mana", 30, new int[]{2, 7, 5, 2}, 30); //done
	public static ArmorMaterial tank = EnumHelper.addArmorMaterial("Tank", 30, new int[]{4, 8, 6, 3}, 30); //done
	public static ArmorMaterial rogue = EnumHelper.addArmorMaterial("Rogue", 30, new int[]{3, 8, 6, 3}, 30);
	public static ArmorMaterial sly = EnumHelper.addArmorMaterial("Sly", 30, new int[]{3, 8, 6, 3}, 30); //done
	public static ArmorMaterial energy = EnumHelper.addArmorMaterial("Energy", 30, new int[]{3, 8, 6, 3}, 30); //done

	public static EnumRarity RARITY_GOLD = EnumHelper.addEnum(EnumRarity.class, "Gold", EnumChatFormatting.GOLD, "Gold");
	public static EnumRarity RARITY_GREEN= EnumHelper.addEnum(EnumRarity.class, "Green", EnumChatFormatting.GREEN, "Green");
	public static EnumRarity RARITY_RED = EnumHelper.addEnum(EnumRarity.class, "Red", EnumChatFormatting.RED, "Red");
	public static EnumRarity RARITY_GRAY = EnumHelper.addEnum(EnumRarity.class, "Gray", EnumChatFormatting.GRAY, "Gray");
	public static EnumRarity RARITY_OBFUSCATED = EnumHelper.addEnum(EnumRarity.class, "Obf", EnumChatFormatting.OBFUSCATED, "Obf");

}
