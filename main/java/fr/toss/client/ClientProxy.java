package fr.toss.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.I18n;
import net.minecraftforge.common.MinecraftForge;
import api.player.client.ClientPlayerAPI;
import cpw.mods.fml.common.FMLCommonHandler;
import fr.toss.client.event.GuiIngameOverlay;
import fr.toss.client.event.SoundEventM;
import fr.toss.client.registry.RenderRegistry;
import fr.toss.common.CommonProxy;
import fr.toss.common.Main;
import fr.toss.common.command.ChatColor;
import fr.toss.common.player.ClientPlayerBaseMagic;

public class ClientProxy extends CommonProxy 
{
	public static Minecraft minecraft = Minecraft.getMinecraft();
	public static final int				CURRENT_VERSION = 4;
	public static int					LAST_VERSION;
	
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
    	
		SoundEventM soundHandler = new SoundEventM();
    	FMLCommonHandler.instance().bus().register(soundHandler);
    	MinecraftForge.EVENT_BUS.register(soundHandler);
    	
    	this.handle_version();
	}
	
    static void handle_version()
    {
        URL 			url;
        BufferedReader 	in;

        try {
            url = new URL("http://grillecube.fr/MagicCrusade/version.txt");
            in = new BufferedReader(new InputStreamReader(url.openStream()));
            LAST_VERSION = Integer.valueOf(in.readLine());
			in.close();
		} catch (IOException e) {
        	Main.log("[ERROR] Telechargement de la version");
			e.printStackTrace();
		}
        
        if (LAST_VERSION != CURRENT_VERSION)
        {
        	GuiIngameOverlay.INFO.add(ChatColor.RED + I18n.format("message.outdated") + ChatColor.RESET);
        	GuiIngameOverlay.DELAY_INFO = 20000;
        	Main.log("Le mod n'est pas à jour");
        }
	}
}