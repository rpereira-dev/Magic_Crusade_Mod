package fr.toss.common.packet;

import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import cpw.mods.fml.relauncher.Side;

public class Packets {
	
    public static SimpleNetworkWrapper network;

	public static void initialize()
	{
    	network = NetworkRegistry.INSTANCE.newSimpleChannel("MagicCrusade");
    	
    	network.registerMessage(PacketLogIn.Handler.class, PacketLogIn.class, 0, Side.CLIENT);
    	network.registerMessage(PacketDisplayGui.Handler.class, PacketDisplayGui.class, 1, Side.CLIENT);
    	network.registerMessage(PacketParticleEffectToClient.Handler.class, PacketParticleEffectToClient.class, 2, Side.CLIENT);
    	network.registerMessage(PacketParticleEffectToServer.Handler.class, PacketParticleEffectToServer.class, 3, Side.SERVER);
    	network.registerMessage(PacketSpellToServer.Handler.class, PacketSpellToServer.class, 4, Side.SERVER);
    	network.registerMessage(PacketSetClasse.Handler.class, PacketSetClasse.class, 5, Side.SERVER);
    	network.registerMessage(PacketExpToClient.Handler.class, PacketExpToClient.class, 6, Side.CLIENT);
    	network.registerMessage(PacketTeamToClient.Handler.class, PacketTeamToClient.class, 7, Side.CLIENT);
    	network.registerMessage(PacketTeamToServer.Handler.class, PacketTeamToServer.class, 8, Side.SERVER);
	}

}
