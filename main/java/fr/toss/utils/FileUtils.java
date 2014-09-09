package fr.toss.utils;

import java.io.File;
import java.io.IOException;

import net.minecraft.client.Minecraft;

public class FileUtils {
	
	public static int[] read_data(String path)
	{
		File file;
		int retour[];
		
		retour = new int[4];
		file = new File(Minecraft.getMinecraft().mcDataDir.getAbsoluteFile() + "/mods/" + path);
		
		try 
		{
			if (file.createNewFile()) //First log
				return (null);
			else
			{
				
			}
		}
		catch (IOException e)
		{
			return (null);
		}
		
		
		return (retour);
	}

}
