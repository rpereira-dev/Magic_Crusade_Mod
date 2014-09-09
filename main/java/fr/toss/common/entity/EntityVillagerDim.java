package fr.toss.common.entity;

import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.village.MerchantRecipeList;
import net.minecraft.world.World;

public class EntityVillagerDim extends EntityVillager
{
	public EntityVillagerDim(World w)
	{
		super(w);
	}
	
	public EntityVillagerDim(World w, int profession)
	{
		super(w, profession);
		MerchantRecipeList recipes_list = new MerchantRecipeList();
		this.setRecipes(recipes_list);
	}
	
}