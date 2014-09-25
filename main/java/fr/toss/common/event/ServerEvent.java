package fr.toss.common.event;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.ChatComponentText;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent;
import cpw.mods.fml.common.gameevent.TickEvent;
import fr.toss.common.Main;
import fr.toss.common.packet.PacketLogIn;
import fr.toss.common.packet.Packets;
import fr.toss.common.player.ServerPlayerBaseMagic;
import fr.toss.common.register.AchievementList;
import fr.toss.common.world.dungeon.Dungeon;

public class ServerEvent {
	
	@SubscribeEvent
    public void onPlayerLog(PlayerEvent.PlayerLoggedInEvent event)
    {
		ServerPlayerBaseMagic player;
		PacketLogIn packet;

		event.player.triggerAchievement(AchievementList.LOGING);
		player = Main.getPlayerServer((EntityPlayerMP) event.player);
		packet = new PacketLogIn(player);
		Packets.network.sendTo(packet, player.getPlayer());
		
		for (Dungeon d : Main.DUNGEONS) //Install les maps du donjon
			d.install_map(event.player.worldObj.getWorldInfo().getWorldName());
    }
	
	@SubscribeEvent
    public void onPlayerLogout(PlayerEvent.PlayerLoggedOutEvent event)
    {
		System.out.println("Logged out: " + event.player);

		for (Dungeon d : Main.DUNGEONS)
		{
			if (event.player.dimension == d.DIM_ID)
			{
				Main.getPlayerServer(event.player).travelToDimension(d.DIM_RETOUR, event.player.dimension);
				Main.log(event.player.getCommandSenderName() + " has disconnected into a dungeon");
				return ;
			}
		}
		
    }
	
	@SubscribeEvent
	public void onTickServer(TickEvent.ServerTickEvent event)
	{
		if (Main.server != null)
			Main.server.onServerUpdate();
	}
	
	@SubscribeEvent
	public void onWorldTick(TickEvent.WorldTickEvent event)
	{
		EntityPlayer player;
		
		player = null;
		for (Dungeon d : Main.DUNGEONS)
		{
			if (event.world.provider.dimensionId == d.DIM_ID && d.is_running)
			{
				if (event.world.playerEntities.size() == 0)
				{
					d.is_running = false;
					d.current_team = null;
				}
				else
				{
					for (Object obj : event.world.playerEntities)
					{
						if (((EntityPlayer)obj).getTeam() == null || !((EntityPlayer)obj).getTeam().isSameTeam(d.current_team)) //le joueur quitte le groupe du donjon
						{
							player = (EntityPlayer)obj;
							break ;
						}
					}
				}
			}
			if (player != null)
			{
				Main.getPlayerServer(player).travelToDimension(d.DIM_RETOUR, player.dimension);
				player.addChatComponentMessage(new ChatComponentText("You are no longer in this dungeon's group."));
				player = null;
			}
		}
	}
}
