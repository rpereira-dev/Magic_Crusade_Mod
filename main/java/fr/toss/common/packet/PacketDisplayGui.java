package fr.toss.common.packet;

import fr.toss.client.gui.GuiSlave;
import io.netty.buffer.ByteBuf;
import net.minecraft.client.Minecraft;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class PacketDisplayGui implements IMessage {
   
	public int gui_id;
	public int data;

    public PacketDisplayGui()
    {
        this.gui_id = 0;
    }
    
    public PacketDisplayGui(int i, int d)
    {
        this.gui_id = i;
        this.data = d;
    }

    @Override
    public void fromBytes(ByteBuf buf)
    {
        this.gui_id = buf.readInt();
        this.data = buf.readInt();
    }

    @Override
    public void toBytes(ByteBuf buf)
    {
    	buf.writeInt(this.gui_id);
    	buf.writeInt(this.data);
    }

    public static class Handler implements IMessageHandler<PacketDisplayGui, IMessage> {
       
        @Override
        @SideOnly(Side.CLIENT)
        public IMessage onMessage(PacketDisplayGui message, MessageContext ctx) 
        {
        	switch (message.gui_id)
        	{
        		case GuiSlave.ID :
        			Minecraft.getMinecraft().displayGuiScreen(new GuiSlave());
        			break ;
        	}
        	
        	return null;
        }
    }
}
