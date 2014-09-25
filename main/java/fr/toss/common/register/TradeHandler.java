package fr.toss.common.register;

import java.util.Random;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentData;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.village.MerchantRecipe;
import net.minecraft.village.MerchantRecipeList;
import cpw.mods.fml.common.registry.VillagerRegistry.IVillageTradeHandler;

public class TradeHandler implements IVillageTradeHandler
{
	@Override
	public void manipulateTradesForVillager(EntityVillager villager, MerchantRecipeList recipeList, Random random)
	{
		for (int i = 0; i < 4; i++)
		{
			switch(villager.getProfession()) 
			{
				case 0: // FARMER
					recipeList.add(new MerchantRecipe(new ItemStack(ItemRegister.COMBUSTIUM, 2), new ItemStack(Items.apple, 1)));
					break;
				case 1: // LIBRARIAN
					recipeList.add(new MerchantRecipe(new ItemStack(ItemRegister.COMBUSTIUM, 4, 15), new ItemStack(Items.paper, 1, 6)));
					recipeList.add(new MerchantRecipe(new ItemStack(ItemRegister.COMBUSTIUM, 1), Items.enchanted_book.getEnchantedItemStack(new EnchantmentData(Enchantment.flame, 1))));
					break;
				case 2: // PRIEST
					recipeList.add(new MerchantRecipe(new ItemStack(ItemRegister.COMBUSTIUM, 6), new ItemStack(Items.apple, 2), new ItemStack(Items.apple, 2)));
					break;
				case 3: // BLACKSMITH
					recipeList.add(new MerchantRecipe(new ItemStack(ItemRegister.COMBUSTIUM, 6 + random.nextInt(6)), new ItemStack(Items.apple, 5 + random.nextInt(4)), new ItemStack(Items.apple, 1)));
					recipeList.add(new MerchantRecipe(new ItemStack(ItemRegister.ETHERNIUM, 64), new ItemStack(ItemRegister.ELLAMAYNE, 1)));
					break;
				default:
					break;
			}
		}
	}
}
