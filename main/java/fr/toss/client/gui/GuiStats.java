package fr.toss.client.gui;

import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import cpw.mods.fml.client.config.GuiUtils;
import fr.toss.common.Main;
import fr.toss.common.command.ChatColor;
import fr.toss.common.items.ItemArmorM;
import fr.toss.common.items.ItemSwordM;
import fr.toss.common.player.ClientPlayerBaseMagic;
import fr.toss.common.player.classes.ClasseChampion;
import fr.toss.common.player.classes.ClasseMage;
import fr.toss.common.player.classes.ClasseNecromancer;
import fr.toss.common.player.spells.Spell;

public class GuiStats extends GuiScreen {
	
	public static final ResourceLocation SPELLS = new ResourceLocation("magiccrusade:textures/gui/spells.png");
	public static final ResourceLocation GUI = new ResourceLocation("magiccrusade:textures/gui/gui_stats.png");
	
	public ClientPlayerBaseMagic pm;
	public LineStat lines[];
	public Spell_slot spells[];
	
	public float endurance;
	public float strength;
	public float stamina;
	public int mana;
	public float clarity;
	public float mana_regen;

	@Override
	public void initGui()
	{
		super.initGui();
		Item item;
		String str;
		String color;
		
		pm = Main.getPlayerClient();
		endurance = 0;
		lines = new LineStat[6];
		spells = new Spell_slot[this.pm.getClasse().CLASSE_SPELL.size()];
		
		for (int i = 0; i < 4; i++)
		{
			if (pm.getPlayer().inventory.armorInventory[i] != null)
			{
				item = pm.getPlayer().inventory.armorInventory[i].getItem();
				if (item != null && item instanceof ItemArmorM)
				{
					strength += ((ItemArmorM)item).strength;
					stamina += ((ItemArmorM)item).agility;
					clarity += ((ItemArmorM)item).clarity;
					endurance += ((ItemArmorM)item).endurance;
					mana_regen += ((ItemArmorM)item).mana_regeneration;
					mana += ((ItemArmorM)item).mana;
				}
			}
		}
		if (pm.getPlayer().inventory.getCurrentItem() != null)
		{
			if (pm.getPlayer().inventory.getCurrentItem().getItem() instanceof ItemSwordM)
			{
				item = pm.getPlayer().inventory.getCurrentItem().getItem();
				strength += ((ItemSwordM)item).strength;
				stamina += ((ItemSwordM)item).agility;
				clarity += ((ItemSwordM)item).clarity;
				endurance += ((ItemSwordM)item).endurance;
				mana_regen += ((ItemSwordM)item).mana_regeneration;
				mana += ((ItemSwordM)item).mana;
			}
		}
		
		color = this.endurance > 0 ? "" + ChatColor.GREEN : "" + ChatColor.WHITE;
		str = "o " + ChatColor.UNDERLINE + "Health point:" + ChatColor.RESET + " " + color + this.pm.getPlayer().getHealth() + "/" + this.pm.getPlayer().getMaxHealth();
		lines[0] = new LineStat(str, this.endurance, "Endurance");
		
		color = this.mana > 0 ? "" + ChatColor.GREEN : "" + ChatColor.WHITE;
		str = "o " + ChatColor.UNDERLINE + this.getEnergyType() + ":" + ChatColor.RESET + " " + color + this.pm.energy + "/" + this.pm.getMaxEnergy(this.mana);
		lines[1] = new LineStat(str, this.mana, this.getEnergyType());
		
		color = this.strength	 > 0 ? "" + ChatColor.GREEN : "" + ChatColor.WHITE;
		str = "o " + ChatColor.UNDERLINE + "Damage boost:" + ChatColor.RESET + " " + color + (this.strength / 20.0f);
		lines[2] = new LineStat(str, this.strength, "Strength");
		
		color = this.stamina > 0 ? "" + ChatColor.GREEN : "" + ChatColor.WHITE;
		str = "o " + ChatColor.UNDERLINE + "Critic. Ratio:" + ChatColor.RESET + " " + color + (this.stamina / 2.0f);
		lines[3] = new LineStat(str, this.stamina, "Stamina");
		
		color = this.clarity > 0 ? "" + ChatColor.GREEN : "" + ChatColor.WHITE;
		str = "o " + ChatColor.UNDERLINE + "Magic power:" + ChatColor.RESET + " " + color + (this.clarity / 20);
		lines[4] = new LineStat(str, this.clarity, "Clarity");
		
		color = this.mana_regen > 0 ? "" + ChatColor.GREEN : "" + ChatColor.WHITE;
		str = "o " + ChatColor.UNDERLINE + "Mana per sec.:" + ChatColor.RESET + " " + color + ((5 + this.mana_regen) * 20);
		lines[5] = new LineStat(str, this.mana_regen, "Mana regen.");
		
		for (int i = 0; i < this.lines.length; i++)
		{
			this.lines[i].x = this.width / 2 - 88;
			this.lines[i].y = 118 + 16 * i;
		}
		
		for (int i = 0; i < this.pm.getClasse().CLASSE_SPELL.size(); i++)
			this.spells[i] = new Spell_slot(this.pm.getClasse().CLASSE_SPELL.get(i), this.width / 2 + 78, 47 + 22 * i);
	}


	/** Draws the screen and all the components in it. */
    @Override
    public void drawScreen(int x, int y, float dunno)
    {
        this.drawDefaultBackground();
        this.drawGuiContainerBackgroundLayer();
        this.drawStats();
        this.checkStatsHover(x, y);
        this.drawSpells();
        this.checkSpellHover(x, y);
        
        super.drawScreen(x, y, dunno);
    }

	protected void checkStatsHover(int x, int y)
    {
        for (int i = 0; i < this.lines.length; i++)
        {
        	boolean bool = x > this.lines[i].x && x < this.lines[i].x + 130 && y > this.lines[i].y && y < this.lines[i].y + 14;
            
        	if (bool)
        	{
        		int x1 = this.fontRendererObj.getStringWidth(this.lines[i].hover_text) / 2 + 4;
        		this.drawRect(x - x1, y - 20, x + x1, y + 5, Integer.MIN_VALUE);
        		this.drawCenteredString(this.fontRendererObj, this.lines[i].hover_text, x, y - 12, Integer.MAX_VALUE);
        	}
        }
    }

    protected void drawGuiContainerBackgroundLayer()
    {
    	String str;
    	
        str = this.pm.getClasse().getColor() + this.pm.getClasse().getName() + ChatColor.RESET + " " + this.pm.getPlayer().getCommandSenderName();
        
        this.mc.getTextureManager().bindTexture(GUI);
        this.drawTexturedModalRect(this.width / 2 - 128, 0, 0, 0, 256, 256);
        this.drawCenteredString(this.fontRendererObj, str, this.width / 2, 14, Integer.MAX_VALUE);
        str = ChatColor.YELLOW + "" + ChatColor.UNDERLINE  + "Level: " + this.pm.getLevel() + ChatColor.RESET;
        this.drawCenteredString(this.fontRendererObj, str, this.width / 2 - 26, 50, Integer.MAX_VALUE);
    }
    
    protected void drawStats()
    {
        FontRenderer font;
        
        font = this.fontRendererObj;
		
		this.drawCenteredString(this.fontRendererObj, ChatColor.YELLOW + "" + ChatColor.UNDERLINE + "Stats:", this.width / 2 - 68, 96, Integer.MAX_VALUE);

        for (LineStat line : this.lines)
        	font.drawStringWithShadow(line.line, line.x, line.y, Integer.MAX_VALUE);
    }

	/** Update du screen */
    public void updateScreen()
    {
    	super.updateScreen();
    }

    
    private void checkSpellHover(int x, int y)
    {
        for (int i = 0; i < this.spells.length; i++)
        {
        	boolean bool = x >= this.spells[i].x && x <= this.spells[i].x + 16 && y >= this.spells[i].y && y <= this.spells[i].y + 16;
            
        	if (bool)
        	{
        		Spell spell;
        		String description[];
        		String str;
        		int x1;
        		int y1;

        		spell = this.spells[i].spell;
        		description = spell.getDescription();
        		x1 = this.fontRendererObj.getStringWidth(description[0]) / 2 + 10;
        		y1 = 10 * description.length + 10;
        		drawRect(0, 0, this.width, this.height, Integer.MIN_VALUE);
        		drawRect(x - x1, y - y1 - 12, x + x1, y + 15, Integer.MAX_VALUE);
        		
        		this.drawCenteredString(this.fontRendererObj, ChatColor.AQUA + "" + ChatColor.UNDERLINE + spell.getName() + ChatColor.RESET, x, y - y1 - 10, Integer.MAX_VALUE);
        		for (int j = 0; j < description.length; j++)
        		{
            		this.drawCenteredString(this.fontRendererObj, description[j], x, y - y1 + 2 + j * 10, Integer.MAX_VALUE);
        		}
        		
        		str = ChatColor.YELLOW + "Cost " + spell.getCost();
        		this.drawCenteredString(this.fontRendererObj, str, x, y - y1 + 2 + y1 - 10, Integer.MAX_VALUE);
        		
        		str = (this.pm.getLevel() >= spell.getLevel()) ? "" + ChatColor.GREEN : "" + ChatColor.RED;
        		str += "Level required: " + spell.getLevel();
        		this.drawCenteredString(this.fontRendererObj, str, x, y - y1 + 2 + y1, Integer.MAX_VALUE);
        	}
        }
	}

    
    public void drawSpells()
    {
    	int x;
    	
    	x = 0;
    	for (Spell_slot slot : this.spells)
    	{
	        this.mc.getTextureManager().bindTexture(this.pm.getClasse().getTexture());
	        GuiUtils.drawContinuousTexturedBox(slot.x, slot.y, x, 0, 16, 16, 16, 16, 0, 0);
	        x += 16;
    	}
    }

    @Override
    protected void actionPerformed(GuiButton b)
    {
    	if (b.id == 42)
    	{
    		
    	}
    }
    
    private String getEnergyType()
    {
    	if (this.pm.getClasse() instanceof ClasseMage || this.pm.getClasse() instanceof ClasseNecromancer)
    		return ("Mana");
    	else if (this.pm.getClasse() instanceof ClasseChampion)
    		return ("Furror");
    	else
    		return ("Energy");
	}
}

class LineStat
{
	public String hover_text;
	public String line;
	public float value;
	public int x;
	public int y;
	
	public LineStat(String a, float b, String name)
	{
		this.value = b;
		this.line = a;
		this.hover_text = (b > 0) ? (ChatColor.GREEN + "+ ") : (b < 0) ? (ChatColor.RED + "- ") : ("");
		this.hover_text += b + " " + name;
	}
}

class Spell_slot
{
	public Spell spell;
	public int x;
	public int y;
	
	public Spell_slot(Spell a, int b, int c)
	{
		this.spell = a;
		this.x = b;
		this.y = c;
	}
}
