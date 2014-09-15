package fr.toss.common.packet;

import fr.toss.client.gui.GuiInvitation;
import io.netty.buffer.ByteBuf;
import net.minecraft.client.Minecraft;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class PacketTeamToClient implements IMessage {
   
	public char str1[];
	public int str1_size;
	
	public char str2[];
	public int str2_size;
	
	public int id;

    public PacketTeamToClient()
    {
    	this(new char[0], 0, new char[0], 0, 0);
    }
    
    public PacketTeamToClient(char str[], int l, char str1[], int l2, int p_id)
    {
    	this.str1 = str;
    	this.str1_size = l;
    	this.str2 = str1;
    	this.str2_size = l2;
    	this.id = p_id;
    }

    @Override
    public void fromBytes(ByteBuf buf)
    {
    	this.str1_size = buf.readInt();
    	this.str1 = new char[this.str1_size];
    	for (int i = 0; i < this.str1_size; i++)
    		this.str1[i] = buf.readChar();
    	
    	this.str2_size = buf.readInt();
    	this.str2 = new char[this.str2_size];
    	for (int i = 0; i < this.str2_size; i++)
    		this.str2[i] = buf.readChar();
    	
    	this.id = buf.readInt();
    }

    @Override
    public void toBytes(ByteBuf buf)
    {
    	buf.writeInt(this.str1_size);
    	for (int i = 0; i < this.str1_size; i++)
    		buf.writeChar(this.str1[i]);
    	
    	buf.writeInt(this.str2_size);
    	for (int i = 0; i < this.str2_size; i++)
    		buf.writeChar(this.str2[i]);
    	
    	buf.writeInt(this.id);
    }

    public static class Handler implements IMessageHandler<PacketTeamToClient, IMessage> 
    {
		@Override
		@SideOnly(Side.CLIENT)
		public IMessage onMessage(PacketTeamToClient message, MessageContext ctx)
		{
			if (message.id == 3) //Le joueur a été invité
			{
				Minecraft.getMinecraft().displayGuiScreen(new GuiInvitation(String.valueOf(message.str1), String.valueOf(message.str2)));
			}
			return (null);
		}
    }
}
