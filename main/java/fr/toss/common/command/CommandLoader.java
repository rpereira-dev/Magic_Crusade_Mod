package fr.toss.common.command;

import cpw.mods.fml.common.event.FMLServerStartingEvent;

public class CommandLoader {

	public static void	load(FMLServerStartingEvent event)
	{
		event.registerServerCommand(new CommandLevel());
		event.registerServerCommand(new CommandGame());
	}
	
}
