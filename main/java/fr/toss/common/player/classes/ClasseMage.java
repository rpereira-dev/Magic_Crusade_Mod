package fr.toss.common.player.classes;

import net.minecraft.util.ResourceLocation;
import fr.toss.common.command.ChatColor;
import fr.toss.common.player.spells.mage.ArcanaPillow_5;
import fr.toss.common.player.spells.mage.ConeFeu_1;
import fr.toss.common.player.spells.mage.FieldDestruction_4;
import fr.toss.common.player.spells.mage.Fireball_6;
import fr.toss.common.player.spells.mage.FreezeCube_2;
import fr.toss.common.player.spells.mage.Transfert_3;

public class ClasseMage extends Classe {
	
	public ClasseMage()
	{
		super();
	}

	@Override
	public String getName() 
	{
		return "Mage";
	}

	@Override
	public ChatColor getColor() 
	{
		return ChatColor.AQUA;
	}

	@Override
	/** definis tous les sorts de la classe */
	public void defineClasseSpells()
	{	
		this.CLASSE_SPELL.clear();
		this.CLASSE_SPELL.add(new ConeFeu_1());
		this.CLASSE_SPELL.add(new FreezeCube_2());
		this.CLASSE_SPELL.add(new Transfert_3());
		this.CLASSE_SPELL.add(new FieldDestruction_4());
		this.CLASSE_SPELL.add(new ArcanaPillow_5());
		this.CLASSE_SPELL.add(new Fireball_6());
	}
	
	@Override
	public EnumType getType() 
	{
		return EnumType.DPS;
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
		return (MAGE);
	}
}
