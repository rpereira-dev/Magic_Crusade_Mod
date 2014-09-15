package fr.toss.client.gui;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiTextField;
import net.minecraft.client.resources.I18n;
import net.minecraft.util.ResourceLocation;

import com.google.code.chatterbotapi.ChatterBot;
import com.google.code.chatterbotapi.ChatterBotFactory;
import com.google.code.chatterbotapi.ChatterBotSession;
import com.google.code.chatterbotapi.ChatterBotType;

import cpw.mods.fml.client.config.GuiUtils;
import fr.toss.common.Main;
import fr.toss.common.command.ChatColor;

public class GuiSelectClass extends GuiScreen {
	
	public static final ResourceLocation CLASSES = new ResourceLocation("magiccrusade:textures/gui/classes.png");

	@Override
	public void initGui()
	{
		GuiButton buttons[];
		
		buttons = new GuiButton[6];
		
		buttons[0] = new GuiButton(42, this.width / 4 - 40, this.height / 4 - 26, 80, 20, ChatColor.RESET + I18n.format("classe.champion"));
		
		buttons[1] = new GuiButton(43, this.width / 2 - 40, this.height / 4 - 26, 80, 20, ChatColor.RESET + I18n.format("classe.rogue"));
		
		buttons[2] = new GuiButton(44, this.width / 4 * 3 - 40, this.height / 4 - 26, 80, 20, ChatColor.RESET + I18n.format("classe.necromancer"));
		
		buttons[3] = new GuiButton(45, this.width / 4 - 40, this.height / 4 * 3 - 52, 80, 20, ChatColor.RESET + I18n.format("classe.ranger"));
		
		buttons[4] = new GuiButton(46, this.width / 2 - 40, this.height / 4 * 3 - 52, 80, 20, ChatColor.RESET + I18n.format("classe.mage"));

		buttons[5] = new GuiButton(47, this.width / 4 * 3 - 40, this.height / 4 * 3 - 52, 80, 20, ChatColor.RESET + I18n.format("classe.priest"));

		for (GuiButton b : buttons)
			this.buttonList.add(b);
	}

    /**
     * Fired when a key is typed. This is the equivalent of KeyListener.keyTyped(KeyEvent e).
     */
    protected void keyTyped(char c, int i)
    {
    	super.keyTyped(c, i);
    }
    
    
    /**
     * Draws the screen and all the components in it.
     */
    @Override
    public void drawScreen(int x, int y, float dunno)
    {
    	int x1 = this.width / 4 - 26;
    	int y1 = this.height / 4;
    	int a = 0;
    	int b = 0;

    	this.drawDefaultBackground();
    	this.drawCenteredString(this.fontRendererObj, I18n.format("classe.choose"), this.width / 2, 14, Integer.MAX_VALUE / 2);
        this.mc.getTextureManager().bindTexture(CLASSES);
         
        for (int i = 0; i < 6; i++)
        {
        	GuiUtils.drawTexturedModalRect(x1, y1, a, b, 52, 52, 0);
        	x1 += this.width / 4;
        	a += 52;
        	if (i == 2)
        	{
        		a = 0;
        		b += 52;
        		x1 = this.width / 4 - 26;
        		y1 = this.height / 4 * 3 - 26;
        	}
        }
        
    	super.drawScreen(x, y, dunno);
    	
    }
    
    /**
     * Called from the main game loop to update the screen.
     */
    @Override
    public void updateScreen() 
    {
    	super.updateScreen();
    }
    
    @Override
    public boolean doesGuiPauseGame()
    {
        return false;
    }
    
    @Override
    protected void actionPerformed(GuiButton b)
    {
		GuiClasseInformation gui;
		String classe;
		String description[];
		String advices[];
    	if (b.id == 42)
    	{    		
    		description = new String[4];
    		advices = new String[4];
    		classe = ChatColor.RED + I18n.format("classe.champion.slogan");
    		description[0] = I18n.format("classe.champion.line1");
    		description[1] = I18n.format("classe.champion.line2");
    		description[2] = I18n.format("classe.champion.line3");
    		description[3] = I18n.format("classe.champion.line4");
    		advices[0] = ChatColor.GREEN + "+ " + I18n.format("stats.hp");
    		advices[1] = ChatColor.GREEN + "+ " + I18n.format("stats.strength");
    		advices[2] = ChatColor.GREEN + "+ " + I18n.format("stats.armor");
    		advices[3] = ChatColor.RED + "- " + I18n.format("stats.mana");
    		gui = new GuiClasseInformation(classe, description, advices, 0, 0, 190000000, 1);
    		this.mc.displayGuiScreen(gui);
    	}
    	else if (b.id == 43)
    	{
    		description = new String[5];
    		advices = new String[4];
    		classe = ChatColor.YELLOW + I18n.format("classe.rogue.slogan");
    		description[0] = I18n.format("classe.rogue.line1");
    		description[1] = I18n.format("classe.rogue.line2");
    		description[2] = I18n.format("classe.rogue.line3");
    		description[3] = I18n.format("classe.rogue.line4");
    		description[4] = I18n.format("classe.rogue.line5");
    		advices[0] = ChatColor.GREEN + "+ " + I18n.format("stats.hp");
    		advices[1] = ChatColor.GREEN + "+ " + I18n.format("stats.agility");
    		advices[2] = ChatColor.RED + "- " + I18n.format("stats.mana");
    		advices[3] = ChatColor.RED + "- " + I18n.format("stats.clarity");
    		gui = new GuiClasseInformation(classe, description, advices, 1, 0, 180000000, 6);
    		this.mc.displayGuiScreen(gui);
    	}
    	else if (b.id == 44)
    	{
    		description = new String[4];
    		advices = new String[4];
    		classe = ChatColor.DARK_PURPLE + I18n.format("classe.necromancer.slogan");
    		description[0] = I18n.format("classe.necromancer.line1");
    		description[1] = I18n.format("classe.necromancer.line2");
    		description[2] = I18n.format("classe.necromancer.line3");
    		description[3] = I18n.format("classe.necromancer.line4");
    		advices[0] = ChatColor.GREEN + "+ " + I18n.format("stats.mana");
    		advices[1] = ChatColor.GREEN + "+ " + I18n.format("stats.clarity");
    		advices[2] = ChatColor.RED + "- " + I18n.format("stats.strength");
    		advices[3] = ChatColor.RED + "- " + I18n.format("stats.agility");
    		gui = new GuiClasseInformation(classe, description, advices, 2, 0, -100000000, 4);
    		this.mc.displayGuiScreen(gui);
    	}
    	else if (b.id == 45)
    	{
    		description = new String[4];
    		advices = new String[4];
    		classe = ChatColor.GOLD + I18n.format("classe.ranger.slogan");
    		description[0] = I18n.format("classe.ranger.line1");
    		description[1] = I18n.format("classe.ranger.line2");
    		description[2] = I18n.format("classe.ranger.line3");
    		description[3] = I18n.format("classe.ranger.line4");
    		advices[0] = ChatColor.GREEN + "+ " + I18n.format("stats.agility");
    		advices[1] = ChatColor.GREEN + "+ " + I18n.format("stats.strength");
    		advices[2] = ChatColor.RED + "- " + I18n.format("stats.mana");
    		advices[3] = ChatColor.RED + "- " + I18n.format("stats.clarity");
    		gui = new GuiClasseInformation(classe, description, advices, 0, 1, 180000000, 2);
    		this.mc.displayGuiScreen(gui);
    	}
    	else if (b.id == 46)
    	{
    		description = new String[4];
    		advices = new String[4];
    		classe = ChatColor.AQUA + I18n.format("classe.mage.slogan");
    		description[0] = I18n.format("classe.mage.line1");
    		description[1] = I18n.format("classe.mage.line2");
    		description[2] = I18n.format("classe.mage.line3");
    		description[3] = I18n.format("classe.mage.line4");
    		advices[0] = ChatColor.GREEN + "+ " + I18n.format("stats.mana");
    		advices[1] = ChatColor.GREEN + "+ " + I18n.format("stats.clarity");
    		advices[2] = ChatColor.GREEN + "+ " + I18n.format("stats.mana_regen");
    		advices[3] = ChatColor.RED + "- " + I18n.format("stats.strength");
    		gui = new GuiClasseInformation(classe, description, advices, 1, 1, Integer.MAX_VALUE, 5);
    		this.mc.displayGuiScreen(gui);
    	}
    	else if (b.id == 47)
    	{
    		description = new String[3];
    		advices = new String[4];
    		classe = ChatColor.GRAY + I18n.format("classe.priest.slogan");
    		description[0] = I18n.format("classe.priest.line1");
    		description[1] = I18n.format("classe.priest.line2");
    		description[2] = I18n.format("classe.priest.line3");
    		advices[0] = ChatColor.GREEN + "+ " + I18n.format("stats.mana");
    		advices[1] = ChatColor.GREEN + "+ " + I18n.format("stats.clarity");
    		advices[2] = ChatColor.GREEN + "+" + I18n.format("stats.mana_regen");
    		advices[3] = ChatColor.RED + "- " + I18n.format("stats.strength");
    		gui = new GuiClasseInformation(classe, description, advices, 2, 1, Integer.MAX_VALUE, 3);
    		this.mc.displayGuiScreen(gui);
    	}
    }
}
