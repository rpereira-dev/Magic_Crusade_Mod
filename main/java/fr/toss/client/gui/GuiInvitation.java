package fr.toss.client.gui;

import fr.toss.common.command.ChatColor;
import fr.toss.common.packet.PacketTeamToServer;
import fr.toss.common.packet.Packets;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiTextField;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ChatComponentText;

public class GuiInvitation extends GuiScreen {
	
	String group;
	String celui_qui_invite;
	
	public GuiInvitation(String str, String string)
	{
		this.group = str;
		this.celui_qui_invite = string;
	}
	
	@Override
	public void initGui()
	{
        this.buttonList.add(new GuiButton(42, this.width / 4, this.height - 80, this.width / 2, 20, ChatColor.RESET + "Accept"));
        this.buttonList.add(new GuiButton(43, this.width / 4, this.height - 40, this.width / 2, 20, ChatColor.RESET + "Decline"));
	}

    
    /**
     * Draws the screen and all the components in it.
     */
    @Override
    public void drawScreen(int x, int y, float dunno)
    {
    	this.drawCenteredString(this.fontRendererObj, ChatColor.UNDERLINE + this.celui_qui_invite + " has invited you in his team: " + this.group, this.width / 2, 14, Integer.MAX_VALUE);
    	super.drawScreen(x, y, dunno);
    }
    
    @Override
    public boolean doesGuiPauseGame()
    {
        return false;
    }
    
    @Override
    protected void actionPerformed(GuiButton b)
    {
    	if (b.id == 42) //accpetes
    	{
    		PacketTeamToServer packet;
    		
    		packet = new PacketTeamToServer(this.group.toCharArray(), this.group.length(), new char[0], 0, 2);
    		Packets.network.sendToServer(packet);
    		
            this.mc.displayGuiScreen((GuiScreen)null);
            this.mc.setIngameFocus();
    	}
    	else if (b.id == 43) //refuses
    	{
    		PacketTeamToServer packet;
    		
    		packet = new PacketTeamToServer(new char[0], 0, this.celui_qui_invite.toCharArray(), this.celui_qui_invite.length(), 1);
    		Packets.network.sendToServer(packet);
    		
            this.mc.displayGuiScreen((GuiScreen)null);
            this.mc.setIngameFocus();
    	}
    }
}