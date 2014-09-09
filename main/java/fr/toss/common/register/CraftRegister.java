package fr.toss.common.register;

import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import cpw.mods.fml.common.registry.GameRegistry;
import fr.toss.common.items.FuelHandler;

public class CraftRegister {
	
	public static void load()
	{
		CraftingManager craftingManager;
		
		craftingManager = CraftingManager.getInstance();
		craftingManager.addRecipe(new ItemStack(ItemRegister.BLUE_STICK, 4), new Object[] {"#", "#", '#', new ItemStack(BlockRegister.PLANKS, 1, 0)});
		craftingManager.addRecipe(new ItemStack(Items.stick, 4), new Object[] {"#", "#", '#', new ItemStack(BlockRegister.PLANKS, 1, 1)});

		craftingManager.addRecipe(new ItemStack(BlockRegister.PLANKS, 4, 0), new Object[] {"#", '#', new ItemStack(BlockRegister.LOGS1, 1, 0)});
		craftingManager.addRecipe(new ItemStack(BlockRegister.PLANKS, 4, 0), new Object[] {"#", '#', new ItemStack(BlockRegister.LOGS1, 1, 1)});
		craftingManager.addRecipe(new ItemStack(BlockRegister.PLANKS, 4, 1), new Object[] {"#", '#', new ItemStack(BlockRegister.LOGS1, 1, 2)});
        (new RecipesToolsM()).addRecipes(craftingManager);
        (new RecipesWeaponsM()).addRecipes(craftingManager);
        (new RecipesArmorM()).addRecipes(craftingManager);
        
        
        GameRegistry.registerFuelHandler(new FuelHandler());
        GameRegistry.addSmelting(BlockRegister.ORE_SILVER, new ItemStack(ItemRegister.INGOT_SILVER, 1), 0.1f);
        GameRegistry.addSmelting(BlockRegister.ORE_COMBUSTIUM, new ItemStack(ItemRegister.COMBUSTIUM, 1), 0.1f);
        GameRegistry.addSmelting(BlockRegister.ORE_ETHERNIUM, new ItemStack(ItemRegister.ETHERNIUM, 1), 0.1f);
        GameRegistry.addSmelting(BlockRegister.ORE_TITANIUM, new ItemStack(ItemRegister.INGOT_TITANIUM, 1), 0.1f);


	}
}

class RecipesToolsM
{
    private String[][] recipePatterns = new String[][] {{"XXX", " # ", " # "}, {"X", "#", "#"}, {"XX", "X#", " #"}, {"XX", " #", " #"}};
    private Object[][] recipeItems;

    public RecipesToolsM()
    {
        this.recipeItems = new Object[][] {
        		{ItemRegister.INGOT_SILVER, ItemRegister.ETHERNIUM, ItemRegister.INGOT_TITANIUM},
        		{ItemRegister.SILVER_PICKAXE, ItemRegister.ETHERNIUM_PICKAXE, ItemRegister.TITANIUM_PICKAXE},
        		{ItemRegister.SILVER_SHOVEL, ItemRegister.ETHERNIUM_SHOVEL, ItemRegister.TITANIUM_SHOVEL}, 
        		{ItemRegister.SILVER_HATCHET, ItemRegister.ETHERNIUM_HATCHET, ItemRegister.TITANIUM_HATCHET},
        		{ItemRegister.SILVER_HATCHET, ItemRegister.ETHERNIUM_HATCHET, ItemRegister.TITANIUM_HATCHET}};
    }

    /**
     * Adds the tool recipes to the CraftingManager.
     */
    public void addRecipes(CraftingManager craft)
    {
        for (int i = 0; i < this.recipeItems[0].length; ++i)
        {
            Object object = this.recipeItems[0][i];

            for (int j = 0; j < this.recipeItems.length - 1; ++j)
            {
                Item item = (Item)this.recipeItems[j + 1][i];
                craft.addRecipe(new ItemStack(item), new Object[] {this.recipePatterns[j], '#', ItemRegister.BLUE_STICK, 'X', object});
            }
        }
    }
}

class RecipesWeaponsM
{
    private String[][] recipePatterns = new String[][] {{"X", "X", "#"}};
    private Object[][] recipeItems;

    public RecipesWeaponsM()
    {
        this.recipeItems = new Object[][] {
        		{ItemRegister.INGOT_TITANIUM, ItemRegister.INGOT_SILVER, ItemRegister.ETHERNIUM},
        		{ItemRegister.TITANIUM_SWORD, ItemRegister.SILVER_SWORD, ItemRegister.ETHERNIUM_SWORD}};
    }

    /**
     * Adds the weapon recipes to the CraftingManager.
     */
    public void addRecipes(CraftingManager craftingmanager)
    {
        for (int i = 0; i < this.recipeItems[0].length; ++i)
        {
            Object object = this.recipeItems[0][i];

            for (int j = 0; j < this.recipeItems.length - 1; ++j)
            {
                Item item = (Item)this.recipeItems[j + 1][i];
                craftingmanager.addRecipe(new ItemStack(item), new Object[] {this.recipePatterns[j], '#', ItemRegister.BLUE_STICK, 'X', object});
                craftingmanager.addRecipe(new ItemStack(item), new Object[] {this.recipePatterns[j], '#', Items.stick, 'X', object});
            }
        }
    }
}


class RecipesArmorM
{
    private String[][] recipePatterns = new String[][] {{"XXX", "X X"}, {"X X", "XXX", "XXX"}, {"XXX", "X X", "X X"}, {"X X", "X X"}};
    private Object[][] recipeItems;

    public RecipesArmorM()
    {
        this.recipeItems = new Object[][] 
        		{
        		{ItemRegister.INGOT_TITANIUM, ItemRegister.INGOT_SILVER, ItemRegister.ETHERNIUM},
        		{ItemRegister.TITANIUM_HELMET, ItemRegister.SILVER_HELMET, ItemRegister.ETHERNIUM_HELMET},
        		{ItemRegister.TITANIUM_CHESTPLATE, ItemRegister.SILVER_CHESTPLATE, ItemRegister.ETHERNIUM_CHESTPLATE},
        		{ItemRegister.TITANIUM_PANTS, ItemRegister.SILVER_PANTS, ItemRegister.ETHERNIUM_PANTS},
        		{ItemRegister.TITANIUM_BOOTS, ItemRegister.SILVER_BOOTS, ItemRegister.ETHERNIUM_BOOTS},
        		};
    }

    /**
     * Adds the armor recipes to the CraftingManager.
     */
    public void addRecipes(CraftingManager craftingmanager)
    {
        for (int i = 0; i < this.recipeItems[0].length; ++i)
        {
            Object object = this.recipeItems[0][i];

            for (int j = 0; j < this.recipeItems.length - 1; ++j)
            {
                Item item = (Item)this.recipeItems[j + 1][i];
                craftingmanager.addRecipe(new ItemStack(item), new Object[] {this.recipePatterns[j], 'X', object});
            }
        }
    }
}