package fr.toss.utils;

import java.io.File;
import java.io.IOException;

import net.minecraft.client.Minecraft;

public class FileUtils {
	
	public static boolean file_exists(String path)
	{
		File file;
		
		file = new File(Minecraft.getMinecraft().mcDataDir.getAbsoluteFile() + "/mods/magic_crusade/" + path);
		
		try 
		{
			return (!file.createNewFile());
		}
		catch (IOException e)
		{
			return (true);
		}
	}

}
