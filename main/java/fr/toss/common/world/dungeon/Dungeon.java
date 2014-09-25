package fr.toss.common.world.dungeon;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.scoreboard.Team;
import net.minecraft.util.ChatComponentText;
import net.minecraft.world.World;
import net.minecraftforge.common.DimensionManager;
import fr.toss.common.Main;
import fr.toss.common.command.ChatColor;
import fr.toss.common.player.ServerPlayerBaseMagic;
import fr.toss.common.register.AchievementList;

public class Dungeon {
	
	public String			file_name;
	public String			name;
	public int				DIM_ID;
	public int				DIM_RETOUR;
	public boolean			is_running;
	public Team				current_team;
	
	public int				x;
	public int				y;
	public int				z;


	public Dungeon(String fd, String na, int id, int dim_retour, int ... location)
	{
		this.file_name = fd;
		this.name = na;
		this.DIM_ID = id + 42;
		this.DIM_RETOUR = dim_retour;
		this.x = location[0];
		this.y = location[1];
		this.z = location[2];
	}
	
	public static void		init()
	{		
		Main.DIM_ID = DimensionManager.getNextFreeDimId();

		Main.DUNGEONS = new ArrayList<Dungeon>();
		
		Main.DUNGEONS.add(new DungeonOrc());
		Main.DUNGEONS.add(new DungeonGraveyard());

		Main.log("Initializing Dungeons...");
//		Main.log("Downloading into: " + System.getProperty("user.dir"));
//
//		for (Dungeon d : Main.DUNGEONS)
//		{
//			Main.log("Downloading " + d.file_name + ".zip");
//			download_dungeon(d.file_name + ".zip");
//		}
		
						
		Main.log("Dungeon loaded");
	}
	
//	static void				download_dungeon(String dj)
//	{
//		if (!new File(System.getProperty("user.dir") + "/" + dj).exists())
//		{
//			download("http://grillecube.fr/MagicCrusade/" + dj, new File(System.getProperty("user.dir")));
//			Main.log(dj + " has been downloaded");
//		}
//		else
//			Main.log(dj + " already exist");
//	}
	
//	@SuppressWarnings("resource")
//	public static void		download(String link, File directory)
//	{
//	    try
//	    {
//	      URL				url;
//	      URLConnection 	connection;
//	      String 			fileName;
//	      int 				fileLength;
//	      InputStream 		is;
//	      FileOutputStream	os;
//	      File				file;
//	      byte[]			buffer;
//	      int				read;
//	      
//	      url = new URL(link);
//	      connection = url.openConnection();
//	      fileName = url.getFile().substring(url.getFile().lastIndexOf('/') + 1);
//	      connection.getContentType();
//	      fileLength = connection.getContentLength();
//	      is = connection.getInputStream();
//	      os = new FileOutputStream(directory + File.separator + fileName);
//	      file = new File(directory + File.separator + fileName);
//
//	      buffer = new byte[1024];
//	      while ((read = is.read(buffer)) >= 0)
//	    	  os.write(buffer, 0, read);
//	      os.flush();
//	      is.close();
//	    }
//	    catch (MalformedURLException ex) {
//	      ex.printStackTrace();
//	    }
//	    catch (IOException ex) {
//	      ex.printStackTrace();
//	    }
//	}
	
	
	public void			install_map(String save)
	{
		String 			save_folder;
    	ZipInputStream 	zin;
    	ZipEntry 		entry;
    	
		if(new File(System.getProperty("user.dir") + File.separator + "saves").exists())
			save_folder = System.getProperty("user.dir") + File.separator + "saves" + File.separator + save;
		else if (new File(System.getProperty("user.dir") + File.separator + "world").exists())
			save_folder = System.getProperty("user.dir") + File.separator + "world" + File.separator;
		else if (new File(System.getProperty("user.dir") + File.separator + "monde").exists())
			save_folder = System.getProperty("user.dir") + File.separator + "monde" + File.separator;
		else
			return ;
		
		Main.log("Worlds folder is: " + save_folder);
		
		for (Dungeon d : Main.DUNGEONS)
		{
			if (!new File(save_folder + File.separator + "DIM" + d.DIM_ID + File.separator + d.file_name + ".txt").exists())
			{
				Main.log("Installing a dungeon, lag expected: " + d.name);
				ZipUtil.unzip(Dungeon.class.getResourceAsStream(d.file_name + ".zip"), new File(save_folder + File.separator + "DIM" + d.DIM_ID));	
			}
			else
				Main.log("Dungeon is already installed: " + d.name);
		}
	}

	public void		onPlayerJoin(ServerPlayerBaseMagic pm)
	{
		pm.getPlayer().triggerAchievement(AchievementList.DUNGEON);
		pm.getPlayer().addChatComponentMessage(new ChatComponentText(ChatColor.AQUA + "You have entered a dungeon: " + ChatColor.UNDERLINE + this.name + ChatColor.RESET));
	}
	
	public void 	spawn_entities(World worldObj) {}
	
	public void 	despawn_entities(World world) {}
	
	public void 	reset_entities(World world, int nb_chunk_x, int nb_chunk_z)
	{
		for (int i = -nb_chunk_x / 2; i < nb_chunk_x / 2; i += 16)
		{
			for (int j =-nb_chunk_z / 2; j < nb_chunk_z / 2; j += 16)
			{
				for (List l : world.getChunkFromBlockCoords(this.x + i, this.z + j).entityLists)
				{
					for (Object obj : l)
					{
						if (!(obj instanceof EntityPlayer))
						{
							world.removeEntity((Entity)obj);
							Main.log("Removing: " + obj);
						}
					}
				}
			}
		}
	}
}
