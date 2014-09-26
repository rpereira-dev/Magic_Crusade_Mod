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
		Main.log("Dungeon loaded");
	}
	
	/** Param: String save = nom de la sauvegarde */
	public void			install_map(String save)
	{
		String 			save_folder;
    	ZipInputStream 	zin;
    	ZipEntry 		entry;
    	
    	save_folder = this.find_save_folder(save);
		
    	if (save_folder != null)
    	{
			Main.log("Save folder found: " + save_folder);
			
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
    	else
    		Main.log("Error: Cannot find save folder, no dungeon available.");
	}

	String				find_save_folder(String save)
	{
		File	search;
		String	save_folder;
		
		search = new File(System.getProperty("user.dir"));
		save_folder = null;
		for (File file : search.listFiles())
		{
			if (file.isDirectory())
			{
				if (file.getName().equals("saves")) //on est sur le client
					return (System.getProperty("user.dir") + File.separator + "saves" + File.separator + save);
				else
				{
					for (File f : file.listFiles())
					{
						Main.log("Searching into: " + file.getName());
						if (f.getName().equals("DIM1"))
							return (file.getAbsolutePath());
					}
				}
			}
		}
		
		return null;
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
}