package fr.toss.common.player.classes;

import fr.toss.common.command.ChatColor;

public class ClasseFarmer extends Classe {

	@Override
	public String getName() 
	{
		return "Farmer";
	}

	@Override
	public ChatColor getColor() 
	{
		return ChatColor.WHITE;
	}

	@Override
	/** definis tous les sorts de la classe */
	public void defineClasseSpells()
	{	
		
	}
	
	@Override
	public EnumType getType() 
	{
		return EnumType.DPS;
	}
	
	@Override
	public int getBaseEnergyRegen()
	{
		return 1;
	}
}
