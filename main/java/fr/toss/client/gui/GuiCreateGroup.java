package fr.toss.client.gui;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiTextField;
import fr.toss.common.command.ChatColor;
import fr.toss.common.packet.PacketTeamToServer;
import fr.toss.common.packet.Packets;

public class GuiCreateGroup extends GuiScreen {
	
    private GuiTextField textfield;

	@Override
	public void initGui()
	{
        this.textfield = new GuiTextField(this.fontRendererObj, this.width / 2 - 150, 50, 300, 20);
        this.textfield.setMaxStringLength(20);
        this.textfield.setFocused(true);
        this.textfield.setText("Group name here");
        this.buttonList.add(new GuiButton(42, this.width / 4, this.height - 40, this.width / 2, 20, ChatColor.RESET + "Create Group"));
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
    	this.drawCenteredString(this.fontRendererObj, ChatColor.UNDERLINE + "Creating a new group...", this.width / 2, 14, Integer.MAX_VALUE);
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
    		if (this.textfield.getText().length() > 0)
    		{
	    		PacketTeamToServer packet;
	    		
	    		packet = new PacketTeamToServer(this.textfield.getText().toCharArray(), this.textfield.getText().length(), new char[0], 0, 4);
	    		Packets.network.sendToServer(packet);
	    		
	            this.mc.displayGuiScreen((GuiScreen)null);
	            this.mc.setIngameFocus();
    		}
    	}
    }
}
