package fr.toss.client.gui;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiTextField;
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
		
		buttons[0] = new GuiButton(42, this.width / 4 - 40, this.height / 4 - 26, 80, 20, ChatColor.RESET + "Champion");
		
		buttons[1] = new GuiButton(43, this.width / 2 - 40, this.height / 4 - 26, 80, 20, ChatColor.RESET + "Prawler");
		buttons[1].enabled = false;
		
		buttons[2] = new GuiButton(44, this.width / 4 * 3 - 40, this.height / 4 - 26, 80, 20, ChatColor.RESET + "Necromancer");
		
		buttons[3] = new GuiButton(45, this.width / 4 - 40, this.height / 4 * 3 - 52, 80, 20, ChatColor.RESET + "Ranger");
		
		buttons[4] = new GuiButton(46, this.width / 2 - 40, this.height / 4 * 3 - 52, 80, 20, ChatColor.RESET + "Mage");

		buttons[5] = new GuiButton(47, this.width / 4 * 3 - 40, this.height / 4 * 3 - 52, 80, 20, ChatColor.RESET + "Priest");

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
    	this.drawCenteredString(this.fontRendererObj, "Choose a classe to get more informations about it", this.width / 2, 14, Integer.MAX_VALUE / 2);
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
    		classe = ChatColor.YELLOW + "Champion, the living force";
    		description[0] = "This class will make you resistant on melee fights";
    		description[1] = "His main role is to protect his allies from ennemis.";
    		description[2] = "He has to stay in front line to get mobs agressions.";
    		description[3] = "He can charge, spawn a shockwave, increase it armor...";
    		advices[0] = ChatColor.GREEN + "+ HP";
    		advices[1] = ChatColor.GREEN + "+ Strenght";
    		advices[2] = ChatColor.GREEN + "+ Armor";
    		advices[3] = ChatColor.RED + "- Mana";
    		gui = new GuiClasseInformation(classe, description, advices, 0, 0, 190000000, 1);
    		this.mc.displayGuiScreen(gui);
    	}
    	else if (b.id == 44)
    	{
    		description = new String[4];
    		advices = new String[4];
    		classe = ChatColor.DARK_PURPLE + "Necromancer, the sombre magician";
    		description[0] = "You will become a strong death wizard.";
    		description[1] = "In a group, he has to deal damages to mobs.";
    		description[2] = "He has to stay back and hit with his spells.";
    		description[3] = "He can also summons monsters to help him.";
    		advices[0] = ChatColor.GREEN + "+ Mana";
    		advices[1] = ChatColor.GREEN + "+ Clarity";
    		advices[2] = ChatColor.RED + "- Strength";
    		advices[3] = ChatColor.RED + "- Agility";
    		gui = new GuiClasseInformation(classe, description, advices, 2, 0, -100000000, 4);
    		this.mc.displayGuiScreen(gui);
    	}
    	else if (b.id == 45)
    	{
    		description = new String[4];
    		advices = new String[4];
    		classe = ChatColor.GOLD + "The Ranger";
    		description[0] = "A strong damage dealer classe.";
    		description[1] = "He hits ennemis with his powerful bow.";
    		description[2] = "He also have spells and can summons animals.";
    		description[3] = "He has a permanent speed / jump boost";
    		advices[0] = ChatColor.GREEN + "+ Agility";
    		advices[1] = ChatColor.GREEN + "+ Strength";
    		advices[2] = ChatColor.RED + "- Mana";
    		advices[3] = ChatColor.RED + "- Clarity";
    		gui = new GuiClasseInformation(classe, description, advices, 0, 1, 180000000, 2);
    		this.mc.displayGuiScreen(gui);
    	}
    	else if (b.id == 46)
    	{
    		description = new String[4];
    		advices = new String[4];
    		classe = ChatColor.AQUA + "The Mage";
    		description[0] = "A classe which deal heavy magic damages.";
    		description[1] = "It spells can also burn or slow the ennemi";
    		description[2] = "You have to stay away from ennemis";
    		description[3] = "to deal damages without being hitten";
    		advices[0] = ChatColor.GREEN + "+ Mana";
    		advices[1] = ChatColor.GREEN + "+ Clarity";
    		advices[2] = ChatColor.GREEN + "+ Mana regen.";
    		advices[3] = ChatColor.RED + "- Strength";
    		gui = new GuiClasseInformation(classe, description, advices, 1, 1, Integer.MAX_VALUE, 5);
    		this.mc.displayGuiScreen(gui);
    	}
    	else if (b.id == 47)
    	{
    		description = new String[3];
    		advices = new String[4];
    		classe = ChatColor.GRAY + "The Priest, tranquil mind";
    		description[0] = "A spriritual classe, which consist in healing";
    		description[1] = "and buffing players. In group, you have to stay";
    		description[2] = "behind and keep you're allies alive and buffed.";
    		advices[0] = ChatColor.GREEN + "+ Mana";
    		advices[1] = ChatColor.GREEN + "+ Clarity";
    		advices[2] = ChatColor.GREEN + "+ Mana regen.";
    		advices[3] = ChatColor.RED + "- Strength";
    		gui = new GuiClasseInformation(classe, description, advices, 2, 1, Integer.MAX_VALUE, 3);
    		this.mc.displayGuiScreen(gui);
    	}
    }
}
