package fr.toss.client.gui;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiTextField;

import com.google.code.chatterbotapi.ChatterBot;
import com.google.code.chatterbotapi.ChatterBotFactory;
import com.google.code.chatterbotapi.ChatterBotSession;
import com.google.code.chatterbotapi.ChatterBotType;

import fr.toss.common.command.ChatColor;

public class GuiSlave extends GuiScreen {
	
    private GuiTextField textfield;
    private ChatterBotFactory factory;
    private ChatterBot bot;
    private ChatterBotSession bot_session;
	private String reponse;

	public static final int ID = 1;

	@Override
	public void initGui()
	{
		this.reponse = this.getRandomString();
        this.textfield = new GuiTextField(this.fontRendererObj, this.width / 2 - 150, 50, 300, 20);
        this.textfield.setMaxStringLength(300);
        this.textfield.setFocused(true);
        
        this.factory = new ChatterBotFactory();
        try {
			this.bot = this.factory.create(ChatterBotType.PANDORABOTS, "b0dafd24ee35a477");
	        this.bot_session = this.bot.createSession();
		} catch (Exception e) {
			e.printStackTrace();
		}
        
        this.buttonList.add(new GuiButton(42, this.width / 4, this.height - 40, this.width / 2, 20, ChatColor.RESET + "Say"));
	}

	
    private String getRandomString()
    {
    	int i = (int) (System.currentTimeMillis() % 4);
    	switch (i)
    	{
	    	case 0 :
	    		return "Hi, what's up ?";
    		
	    	case 1 :
	    		return "Hum, what you want?";
	    		
	    	case 2 :
	    		return "I know how to speak your language";
	    		
	    	case 3 :
	    		return "Hey, anything you want to tell me ?";
    	}
		return null;
	}


	/**
     * Fired when a key is typed. This is the equivalent of KeyListener.keyTyped(KeyEvent e).
     */
    @Override
    protected void keyTyped(char c, int i)
    {
    	super.keyTyped(c, i);
        this.textfield.textboxKeyTyped(c, i);
    }

    
    /**
     * Called when the mouse is clicked.
     */
    @Override
    protected void mouseClicked(int p_73864_1_, int p_73864_2_, int p_73864_3_)
    {
    	super.mouseClicked(p_73864_1_, p_73864_2_, p_73864_3_);
        this.textfield.mouseClicked(p_73864_1_, p_73864_2_, p_73864_3_);
    }
    
    /**
     * Draws the screen and all the components in it.
     */
    @Override
    public void drawScreen(int x, int y, float dunno)
    {
    	this.drawDefaultBackground();
        this.textfield.drawTextBox();
    	this.drawCenteredString(this.fontRendererObj, this.reponse, this.width / 2, this.height / 2, Integer.MAX_VALUE);
    	this.drawCenteredString(this.fontRendererObj, ChatColor.ITALIC + "(the first click may make you lag)", this.width / 2, this.height - 14, Integer.MAX_VALUE);
    	super.drawScreen(x, y, dunno);
    }
    
    /**
     * Called from the main game loop to update the screen.
     */
    @Override
    public void updateScreen() 
    {
        this.textfield.updateCursorCounter();
    }
    
    @Override
    public boolean doesGuiPauseGame()
    {
        return false;
    }
    
    @Override
    protected void actionPerformed(GuiButton b)
    {
    	if (b.id == 42)
    	{
    		String s;
    		s = this.textfield.getText();
			try
			{
	    		if (s != null)
	    		{
	    			this.reponse = this.bot_session.think(s);
	    			if (this.reponse.length() > 40)
	    				this.reponse = this.reponse.subSequence(0, 40) + "/n" + this.reponse.subSequence(40, this.reponse.length());
	    		}
	    		else
	    			this.reponse = this.bot_session.think("Hey");
			} catch (Exception e) {
				this.reponse = "I'm sorry you're not connected to Internet :(";
			}
			
			this.textfield.setText("");
    	}
    }
}
