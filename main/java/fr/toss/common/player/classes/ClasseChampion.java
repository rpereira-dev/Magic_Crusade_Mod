package fr.toss.common.player.classes;

import net.minecraft.util.ResourceLocation;
import fr.toss.common.command.ChatColor;
import fr.toss.common.player.spells.champion.Arena_6;
import fr.toss.common.player.spells.champion.Charge_1;
import fr.toss.common.player.spells.champion.EarthShield_5;
import fr.toss.common.player.spells.champion.Grab_4;
import fr.toss.common.player.spells.champion.Ironskin_3;
import fr.toss.common.player.spells.champion.Shockwave_2;

public class ClasseChampion extends Classe {
	
	public ClasseChampion()
	{
		super();
	}

	@Override
	public String getName() 
	{
		return "Champion";
	}

	@Override
	public ChatColor getColor() 
	{
		return ChatColor.RED;
	}

	@Override
	/** definis tous les sorts de la classe */
	public void defineClasseSpells()
	{	
		this.CLASSE_SPELL.clear();

		this.CLASSE_SPELL.add(new Charge_1());
		this.CLASSE_SPELL.add(new Ironskin_3());
		this.CLASSE_SPELL.add(new Grab_4());
		this.CLASSE_SPELL.add(new Shockwave_2());
		this.CLASSE_SPELL.add(new EarthShield_5());
		this.CLASSE_SPELL.add(new Arena_6());
	}
	
	@Override
	public EnumType getType() 
	{
		return EnumType.TANK;
	}
	
	@Override
	public int getMaxEnergy()
	{
		return 1000;
	}
	
	@Override
	public int getBaseEnergyRegen()
	{
		return -1;
	}
	
	@Override
	public ResourceLocation getTexture()
	{
		return (CHAMPION);
	}
}
