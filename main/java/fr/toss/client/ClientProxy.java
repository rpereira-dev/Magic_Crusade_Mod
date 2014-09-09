package fr.toss.client;

import net.minecraft.client.Minecraft;
import net.minecraftforge.common.MinecraftForge;
import api.player.client.ClientPlayerAPI;
import cpw.mods.fml.common.FMLCommonHandler;
import fr.toss.client.gui.GuiIngameOverlay;
import fr.toss.client.registry.RenderRegistry;
import fr.toss.common.CommonProxy;
import fr.toss.common.player.ClientPlayerBaseMagic;

public class ClientProxy extends CommonProxy 
{
	public static Minecraft minecraft = Minecraft.getMinecraft();
	
	public void load()
	{
		super.load();
		ClientPlayerAPI.register("Magic Crusade", ClientPlayerBaseMagic.class);

		RenderRegistry.load();
		
		FMLCommonHandler.instance().bus().register(new KeyInputHandler());
		KeyBindings.load();
		
		GuiIngameOverlay events = new GuiIngameOverlay(minecraft);
    	FMLCommonHandler.instance().bus().register(events);
    	MinecraftForge.EVENT_BUS.register(events);
    	
		SoundHandler soundHandler = new SoundHandler();
    	FMLCommonHandler.instance().bus().register(soundHandler);
    	MinecraftForge.EVENT_BUS.register(soundHandler);
	}
}