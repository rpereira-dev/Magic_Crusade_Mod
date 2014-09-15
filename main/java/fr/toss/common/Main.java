package fr.toss.common;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraftforge.common.DimensionManager;
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
import fr.toss.common.command.CommandLevel;
import fr.toss.common.packet.Packets;
import fr.toss.common.player.ClientPlayerBaseMagic;
import fr.toss.common.player.ServerPlayerBaseMagic;

@Mod(name = "MagicCrusade", modid = "magiccrusade", version = "0.0.1")
public class Main
{
	private static Main instance;
	@SidedProxy(clientSide="fr.toss.client.ClientProxy", serverSide="fr.toss.common.CommonProxy")
	public static CommonProxy proxy;
	public static final int DIM_ID = DimensionManager.getNextFreeDimId();    

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
    	Packets.initialize();
    }
       
    @EventHandler
    public void init(FMLInitializationEvent event)
    {
    	instance = this;
    	proxy.load();
    }

    @EventHandler
    public void serverLoad(FMLServerStartingEvent event)
    {
    	event.registerServerCommand(new CommandLevel());
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
    
    public static Main instance() 
	{
		return instance;
	}

	public static boolean isModLoadded(String mod)
	{
	    return (Loader.isModLoaded(mod));
	}
}
