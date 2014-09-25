package fr.toss.common.world.bioms.deco;

import java.util.Random;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemEditableBook;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.nbt.NBTTagString;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import cpw.mods.fml.common.IWorldGenerator;
import fr.toss.common.command.ChatColor;
import fr.toss.common.register.ItemRegister;

public class WorldGenChestElficStaff implements IWorldGenerator {

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider)
	{
		if (random.nextInt(200) == 0 &&
				(world.getBiomeGenForCoords(chunkX, chunkZ).biomeName.contains("Forest") ||
				world.getBiomeGenForCoords(chunkX, chunkZ).biomeName.contains("Plain") ||
				world.getBiomeGenForCoords(chunkX, chunkZ).biomeName.contains("Jungle")))
		{
			
			ItemStack book;
		    NBTTagList bookPages;
		    
			book = new ItemStack(Items.writable_book, 1);
			bookPages = new NBTTagList();
	        book.setTagInfo("author", new NBTTagString("Gelbar"));
            book.setTagInfo("title", new NBTTagString("The Shaping of the World"));
            
            bookPages.appendTag(new NBTTagString(
            			ChatColor.UNDERLINE + "The Shaping of the World" + ChatColor.RESET
            			+ " \n"
            			+ "a story of creation, by Captain Adrallus Caro"
            			+ "\n\n"
            			+ "I'm kinda drunk right now, cuz' my men made me drank"
            			+ "some very strong alcohol, cuz' i'm badly wounded and "
            			+ "they had to take out the arrows and whatever,"));

            bookPages.appendTag(new NBTTagString(
            			"this is bullshit and i'm dying. So i have to share my "
            			+ "knowledge when it's still time !"
            			+ "\n\n"
            			+ ChatColor.MAGIC + "(" + ChatColor.RESET + "inde" + ChatColor.MAGIC + "s" + ChatColor.RESET + "cri" + ChatColor.MAGIC + "b" + ChatColor.RESET + "ab" + ChatColor.MAGIC + "l" + ChatColor.RESET + "e w" + ChatColor.MAGIC + "r" + ChatColor.RESET + "it"  + ChatColor.MAGIC + "i" + ChatColor.RESET + "in" + ChatColor.MAGIC + "g" + ChatColor.RESET + "s"
            			+ "\n\n Long time ago, the ancient gods ruled the universe."));
            bookPages.appendTag(new NBTTagString(
            			"We dont know many things about them. Maybe they didn't even "
            			+ "existed.\n\n\n Whatever. So, one of them, Notch, wanted to "
            			+ "create a world to his image."
            			+ " Using an ancient formula written by another god named Perlin, "));
            		
            bookPages.appendTag(new NBTTagString(
            		"He managed to create the Overworld. \n\nHis goal was to create "
            		+ "a heaven for his minions, the humans. The humans weren't "
            		+ "cool people, oh no, and they were quick to forget their God.\n"
            		+ "Followed a period of anarchy..."));
            
            bookPages.appendTag(new NBTTagString(
            		"Horrible creatures appeared like zombies and spiders"
            		+ "and shit and the bloody skeletons who just SHOT ME with their"
            		+ "bloody arrows, hell !! But um, Notch and his god team" 
            		+ "\n(i guess it was something like that, uh) helped by periodically improving the human's"));
            		
            bookPages.appendTag(new NBTTagString(
            		"possibilities and their engineering technics so they could craft better items."
            		+ "\n\nThey managed to survive this way, building shelters and castles, growing wheat"
            		+ "and hunting wild animals to keep themselves alive"));
            
            bookPages.appendTag(new NBTTagString(
            		"Then the Nether opened and the humans discovered a far worse hell."
            		+ "\n\nAnd then the End opened and it was even worse. Nobody knows who is responsible"
            		+ " for this, but i personally think it's due to another god, or several. Maybe jealous gods."));
            		
            bookPages.appendTag(new NBTTagString(
            		" The humans were still able to survive but life was hard. Yeah, HARD. "
            		+ "Like my ... whatever.\n\n Damn this whiskey !"
            		+ "\n\n" + ChatColor.STRIKETHROUGH + "whiskeeey" + ChatColor.RESET));
            
            bookPages.appendTag(new NBTTagString(
            			"... and Toss in its infinite kindness gave the humans new abilities."
            			+ "\n\nHe shaped the Mystic Groves and opened it to humans, so they could"
            			+ " prove themselves worthy against mightier opponents."));
            	
            bookPages.appendTag(new NBTTagString(
            		"He managed to create guardians for the sacred places he created."
            		+ "\n\nDuring the first era of its existence, the Mystic Groves was"
            		+ "a paradise that everybody dreamed about."));
            		
            bookPages.appendTag(new NBTTagString(
            		"And then came the Lord of Sorrow ..."
            		+ "\n\n\n(the page has been ripped and the book ends here)"));


            		
            book.func_150996_a(Items.written_book);
            
            
			book.getTagCompound().setTag("pages", bookPages);

			
			int x = chunkX * 16 + random.nextInt(16);
			int z = chunkZ * 16 + random.nextInt(16);
			int y = world.getTopSolidOrLiquidBlock(x, z);

			world.setBlock(x, y, z, Blocks.chest);
			TileEntityChest chest = (TileEntityChest) world.getTileEntity(x, y, z);
			if (chest != null)
			{
				chest.setInventorySlotContents(0, new ItemStack(ItemRegister.STAFF_ELFIC, 1));
				chest.setInventorySlotContents(1, book);

				y = world.getTopSolidOrLiquidBlock(x + 1, z + 1);
				world.setBlock(x + 1, y, z + 1, Blocks.torch);
				
				y = world.getTopSolidOrLiquidBlock(x + 1, z - 1);
				world.setBlock(x + 1, y, z - 1, Blocks.torch);
				
				y = world.getTopSolidOrLiquidBlock(x - 1, z + 1);
				world.setBlock(x - 1, y, z + 1, Blocks.torch);
				
				y = world.getTopSolidOrLiquidBlock(x - 1, z - 1);
				world.setBlock(x - 1, y, z - 1, Blocks.torch);
			}

		}
		
	}

}
