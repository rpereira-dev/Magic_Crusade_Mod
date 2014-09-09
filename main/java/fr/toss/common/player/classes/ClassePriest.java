package fr.toss.common.player.classes;

import net.minecraft.util.ResourceLocation;
import fr.toss.common.command.ChatColor;
import fr.toss.common.player.spells.priest.Buff_4;
import fr.toss.common.player.spells.priest.GodTouch_5;
import fr.toss.common.player.spells.priest.Heal_2;
import fr.toss.common.player.spells.priest.Healzone_3;
import fr.toss.common.player.spells.priest.HolyExplosion_7;
import fr.toss.common.player.spells.priest.Holyshield_6;
import fr.toss.common.player.spells.priest.Purification_1;

public class ClassePriest extends Classe {
	
	public ClassePriest()
	{
		super();
	}

	@Override
	public String getName() 
	{
		return "Priest";
	}

	@Override
	public ChatColor getColor() 
	{
		return ChatColor.GRAY;
	}

	@Override
	/** definis tous les sorts de la classe */
	public void defineClasseSpells()
	{	
		this.CLASSE_SPELL.clear();
		this.CLASSE_SPELL.add(new Purification_1());
		this.CLASSE_SPELL.add(new Heal_2());
		this.CLASSE_SPELL.add(new Buff_4());
		this.CLASSE_SPELL.add(new Healzone_3());
		this.CLASSE_SPELL.add(new Holyshield_6());
		this.CLASSE_SPELL.add(new GodTouch_5());
		this.CLASSE_SPELL.add(new HolyExplosion_7());

	}
	
	@Override
	public EnumType getType() 
	{
		return EnumType.HEALER;
	}
	
	@Override
	public int getMaxEnergy()
	{
		return 2000;
	}
	
	@Override
	public int getBaseEnergyRegen()
	{
		return 5;
	}
	
	@Override
	public ResourceLocation getTexture()
	{
		return (PRIEST);
	}
}
