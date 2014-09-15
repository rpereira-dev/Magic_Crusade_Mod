package fr.toss.common.player.classes;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.util.ResourceLocation;
import fr.toss.common.Main;
import fr.toss.common.command.ChatColor;
import fr.toss.common.player.ClientPlayerBaseMagic;
import fr.toss.common.player.spells.Spell;

public class Classe implements IClasse {
	
	public List<Spell> CLASSE_SPELL;
	public ClientPlayerBaseMagic player;
	
	public static final ResourceLocation PRIEST = new ResourceLocation("magiccrusade:textures/spells/priest.png");
	public static final ResourceLocation MAGE = new ResourceLocation("magiccrusade:textures/spells/mage.png");
	public static final ResourceLocation CHAMPION = new ResourceLocation("magiccrusade:textures/spells/champion.png");
	public static final ResourceLocation DRAGON_SLAYER = new ResourceLocation("magiccrusade:textures/spells/dragon_slayer.png");
	public static final ResourceLocation NECROMANCER = new ResourceLocation("magiccrusade:textures/spells/necromancer.png");
	public static final ResourceLocation ROGUE = new ResourceLocation("magiccrusade:textures/spells/rogue.png");

	public Classe()
	{
		this.player = Main.getPlayerClient();
		Spell.player = this.player;
		this.CLASSE_SPELL = new ArrayList<Spell>();
		this.defineClasseSpells(); 
	}

	@Override
	/** definis tous les sorts de la classe */
	public void defineClasseSpells() {}


	@Override
	public String getName() 
	{
		return "Paysan";
	}

	@Override
	public ChatColor getColor() 
	{
		return ChatColor.WHITE;
	}

	@Override
	public EnumType getType() 
	{
		return null;
	}


	@Override
	public int getMaxEnergy()
	{
		return 100;
	}
	
	@Override
	public int getBaseEnergyRegen()
	{
		return 1;
	}

	public static Classe getClasse(int id)
	{
		switch (id)
		{
			case 1 :
				return (new ClasseChampion());
				
			case 2 :
				return (new ClasseRanger());

			case 3 :
				return (new ClassePriest());
			
			case 4 :
				return (new ClasseNecromancer());
				
			case 5 :
				return (new ClasseMage());
				
			case 6 :
				return (new ClasseRogue());
		}
		return (new ClasseFarmer());
	}
	
	public static int getIdFromClasse(Classe classe)
	{

		if (classe instanceof ClasseChampion)
			return (1);
		else if (classe instanceof ClasseRanger)
			return (2);
		else if (classe instanceof ClassePriest)
			return (3);
		else if (classe instanceof ClasseNecromancer)
			return (4);
		else if (classe instanceof ClasseMage)
			return (5);
		else
			return (0);
	}

	public ResourceLocation getTexture()
	{
		return null;
	}
}
