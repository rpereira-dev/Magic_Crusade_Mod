package fr.toss.common;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.List;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import api.player.client.IClientPlayerAPI;
import api.player.server.IServerPlayerAPI;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fr.toss.client.event.GuiIngameOverlay;
import fr.toss.common.command.ChatColor;
import fr.toss.common.command.CommandLoader;
import fr.toss.common.game.ServerMagic;
import fr.toss.common.packet.Packets;
import fr.toss.common.player.ClientPlayerBaseMagic;
import fr.toss.common.player.ServerPlayerBaseMagic;
import fr.toss.common.world.dungeon.Dungeon;

@Mod(name = "MagicCrusade", modid = "magiccrusade", version = "2.0.0")
public class Main
{
	private static Main 		instance;
	public static ServerMagic 	server;
	public static int 			DIM_ID;
	public static List<Dungeon> DUNGEONS;

	@SidedProxy(clientSide="fr.toss.client.ClientProxy", serverSide="fr.toss.common.CommonProxy")
	public static CommonProxy 	proxy;
	

    @EventHandler
    public void 		preInit(FMLPreInitializationEvent event)
    {
    	Packets.initialize();
    }
       
    @EventHandler
    public void 		init(FMLInitializationEvent event)
    {
    	instance = this;
    	Dungeon.init();
    	proxy.load();
    }

	@EventHandler
    public void 		serverLoad(FMLServerStartingEvent event)
    {
    	CommandLoader.load(event);
    }
   
    
    /** Retournes le joueur coté Client */
    @SideOnly(Side.CLIENT)
    public static ClientPlayerBaseMagic getPlayerClient()
    {
    	EntityPlayer player;
    	
    	player = Minecraft.getMinecraft().thePlayer;
    	if (player instanceof EntityPlayerSP)
    		return (ClientPlayerBaseMagic) (((IClientPlayerAPI)player).getClientPlayerBase("Magic Crusade"));
    	return (null);
    }
    
    
    /** Retournes le joueur coté Server */
    public static ServerPlayerBaseMagic getPlayerServer(EntityPlayer player)
    {
    	if (player instanceof EntityPlayerMP)
    		return (ServerPlayerBaseMagic) (((IServerPlayerAPI)player).getServerPlayerBase("Magic Crusade"));
    	return (null);
    }
    
    /** Retournes l'instance du mod */
    public static Main 		instance() 
	{
		return instance;
	}

    /** Retournes vrai si le mod est chargé */
	public static boolean 	isModLoadded(String mod)
	{
	    return (Loader.isModLoaded(mod));
	}
	
	/** retournes le donjon correspondant à l'id*/
	public static Dungeon	get_dungeon(int id)
	{
		for (Dungeon d : DUNGEONS)
		{
			if (id == d.DIM_ID)
				return (d);
		}
		return (null);
	}
	
	public static void		log(String str)
	{
		java.util.Date date;
		
		date = new java.util.Date();
		System.out.println("[" + date.getHours() + ":" + date.getMinutes() + ":" + date.getSeconds() + "]" + " [Magic Crusade]: " + str);
	}
}
