package fr.toss.common.player.classes;

import net.minecraft.util.ResourceLocation;
import fr.toss.common.command.ChatColor;
import fr.toss.common.player.spells.necromancer.Corruption_5;
import fr.toss.common.player.spells.necromancer.Drain_1;
import fr.toss.common.player.spells.necromancer.Fireland_2;
import fr.toss.common.player.spells.necromancer.Necromancy_6;
import fr.toss.common.player.spells.necromancer.WitherSkull_3;
import fr.toss.common.player.spells.necromancer.Zombie_4;

public class ClasseNecromancer extends Classe {
	
	public ClasseNecromancer()
	{
		super();
	}
	
	@Override
	public String getName() 
	{
		return "Necromancer";
	}

	@Override
	public ChatColor getColor() 
	{
		return ChatColor.LIGHT_PURPLE;
	}

	@Override
	/** definis tous les sorts de la classe */
	public void defineClasseSpells()
	{	
		this.CLASSE_SPELL.clear();

		this.CLASSE_SPELL.add(new Drain_1());
		this.CLASSE_SPELL.add(new WitherSkull_3());
		this.CLASSE_SPELL.add(new Corruption_5());
		this.CLASSE_SPELL.add(new Zombie_4());
		this.CLASSE_SPELL.add(new Fireland_2());
		this.CLASSE_SPELL.add(new Necromancy_6());

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
		return (NECROMANCER);
	}
}
