package fr.toss.common.player.classes;

import net.minecraft.util.ResourceLocation;
import fr.toss.common.command.ChatColor;
import fr.toss.common.player.spells.dragonslayer.ExplodeShot_3;
import fr.toss.common.player.spells.dragonslayer.MagicShot_2;
import fr.toss.common.player.spells.dragonslayer.PoisonShot_1;
import fr.toss.common.player.spells.dragonslayer.Refinement_4;
import fr.toss.common.player.spells.dragonslayer.SlowShot_6;
import fr.toss.common.player.spells.dragonslayer.Wolves_5;

public class ClasseRanger extends Classe {

	public ClasseRanger()
	{
		super();
	}
	
	@Override
	public String getName() 
	{
		return "Ranger";
	}

	@Override
	public ChatColor getColor() 
	{
		return ChatColor.GOLD;
	}

	@Override
	/** definis tous les sorts de la classe */
	public void defineClasseSpells()
	{	
		this.CLASSE_SPELL.clear();
		this.CLASSE_SPELL.add(new PoisonShot_1());
		this.CLASSE_SPELL.add(new Wolves_5());
		this.CLASSE_SPELL.add(new MagicShot_2());
		this.CLASSE_SPELL.add(new ExplodeShot_3());
		this.CLASSE_SPELL.add(new SlowShot_6());
		this.CLASSE_SPELL.add(new Refinement_4());
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
	
	@Override
	public ResourceLocation getTexture()
	{
		return (DRAGON_SLAYER);
	}
}
