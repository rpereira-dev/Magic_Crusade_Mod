package fr.toss.client.gui;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiTextField;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.scoreboard.ScorePlayerTeam;
import net.minecraft.util.ChatComponentText;
import fr.toss.common.command.ChatColor;
import fr.toss.common.packet.PacketTeamToServer;
import fr.toss.common.packet.Packets;

public class GuiGroup extends GuiScreen {
	
    private GuiTextField textfield_player;
    private GuiTextField textfield_rename;
    private ChatColor colors[];
    int index;
	private GuiButton color_button;

	@Override
	public void initGui()
	{
		index = 0;
		
		this.colors = new ChatColor[16];
		this.colors[0] = ChatColor.AQUA;
		this.colors[1] = ChatColor.BLACK;
		this.colors[2] = ChatColor.BLUE;
		this.colors[3] = ChatColor.DARK_AQUA;
		this.colors[4] = ChatColor.DARK_BLUE;
		this.colors[5] = ChatColor.DARK_GRAY;
		this.colors[6] = ChatColor.DARK_GREEN;
		this.colors[7] = ChatColor.DARK_PURPLE;
		this.colors[8] = ChatColor.DARK_RED;
		this.colors[9] = ChatColor.GOLD;
		this.colors[10] = ChatColor.GRAY;
		this.colors[11] = ChatColor.GREEN;
		this.colors[12] = ChatColor.LIGHT_PURPLE;
		this.colors[13] = ChatColor.RED;
		this.colors[14] = ChatColor.WHITE;
		this.colors[15] = ChatColor.YELLOW;
		
        this.textfield_rename = new GuiTextField(this.fontRendererObj, this.width / 2 - 120, 50, 150, 20);
        this.textfield_rename.setMaxStringLength(30);
        this.textfield_rename.setFocused(true);
        
        this.textfield_player = new GuiTextField(this.fontRendererObj, this.width / 2 - 120, 80, 150, 20);
        this.textfield_player.setMaxStringLength(20);
        
        this.buttonList.add(new GuiButton(41, this.width / 2 + 40, 50, 70, 20, "Prefix"));
        this.color_button = new GuiButton(40, this.width / 2 + 120, 50, 20, 20, this.colors[0] + "o" + ChatColor.RESET);
        this.buttonList.add(this.color_button);

        this.buttonList.add(new GuiButton(42, this.width / 2 + 40, 80, 100, 20, ChatColor.RESET + "Invite player"));
        this.buttonList.add(new GuiButton(43, this.width / 4, this.height - 70, this.width / 2, 20, ChatColor.RESET + "Leave group"));
        this.buttonList.add(new GuiButton(44, this.width / 4, this.height - 40, this.width / 2, 20, ChatColor.RESET + "Close"));
	}


	/**
     * Fired when a key is typed. This is the equivalent of KeyListener.keyTyped(KeyEvent e).
     */
    @Override
    protected void keyTyped(char c, int i)
    {
    	super.keyTyped(c, i);
    	if (this.textfield_player.isFocused())
        	this.textfield_player.textboxKeyTyped(c, i);
    	else
    		this.textfield_rename.textboxKeyTyped(c, i);
    }

    
    /**
     * Called when the mouse is clicked.
     */
    @Override
    protected void mouseClicked(int p_73864_1_, int p_73864_2_, int p_73864_3_)
    {
    	super.mouseClicked(p_73864_1_, p_73864_2_, p_73864_3_);
        this.textfield_player.mouseClicked(p_73864_1_, p_73864_2_, p_73864_3_);
        this.textfield_rename.mouseClicked(p_73864_1_, p_73864_2_, p_73864_3_);
    }
    
    /**
     * Draws the screen and all the components in it.
     */
    @Override
    public void drawScreen(int x, int y, float dunno)
    {
    	this.drawDefaultBackground();
        this.textfield_player.drawTextBox();
        this.textfield_rename.drawTextBox();
    	this.drawCenteredString(this.fontRendererObj, ChatColor.UNDERLINE + "Configuring group...", this.width / 2, 14, Integer.MAX_VALUE);
    	super.drawScreen(x, y, dunno);
    }
    
    /**
     * Called from the main game loop to update the screen.
     */
    @Override
    public void updateScreen() 
    {
        this.textfield_player.updateCursorCounter();
        this.textfield_rename.updateCursorCounter();
        
        this.color_button.displayString = this.colors[index] + "o" + ChatColor.RESET;
    }
    
    @Override
    public boolean doesGuiPauseGame()
    {
        return false;
    }
    
    @Override
    protected void actionPerformed(GuiButton b)
    {
    	if (b.id == 40) //color prefix
    		index = (index + 1) % this.colors.length;
    	else if (b.id == 41) //prefix
    	{
    		if (this.textfield_rename.getText().length() < 12)
    		{
	    		PacketTeamToServer packet;
	    		
	    		packet = new PacketTeamToServer(new char[0], 0, this.textfield_rename.getText().toCharArray(), this.textfield_rename.getText().length(), 10 + this.index);
	    		Packets.network.sendToServer(packet);
		        this.mc.displayGuiScreen((GuiScreen)null);
		        this.mc.setIngameFocus();
    		}
    		else
    			this.textfield_rename.setText(this.textfield_rename.getText() + " (Too long...)");
    	}
    	else if (b.id == 42) //invite
    	{
    		PacketTeamToServer packet;
    		
    		packet = new PacketTeamToServer(new char[0], 0, this.textfield_player.getText().toCharArray(), this.textfield_player.getText().length(), 3);
    		Packets.network.sendToServer(packet);
	        this.mc.displayGuiScreen((GuiScreen)null);
	        this.mc.setIngameFocus();
    	}
    	else if (b.id == 43) //destroy
    	{
    		PacketTeamToServer packet;
    		
    		packet = new PacketTeamToServer(new char[0], 0, new char[0], 0, 5);
    		Packets.network.sendToServer(packet);
	        this.mc.displayGuiScreen((GuiScreen)null);
	        this.mc.setIngameFocus();
    	}
    	else
    	{
	        this.mc.displayGuiScreen((GuiScreen)null);
	        this.mc.setIngameFocus();
    	}
    }
}
