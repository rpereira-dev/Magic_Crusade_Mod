package fr.toss.common.command;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommand;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.server.MinecraftServer;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import fr.toss.common.Main;
import fr.toss.common.game.PacketBorders;
import fr.toss.common.game.PacketGameStart;
import fr.toss.common.game.PacketGameStop;
import fr.toss.common.game.PacketTogglePvp;
import fr.toss.common.game.ServerMagic;
import fr.toss.common.packet.Packets;
import fr.toss.common.register.BlockRegister;
import fr.toss.common.register.ItemRegister;

public class CommandGame extends CommandBase implements ICommand
{
	private List aliases;
    
	public CommandGame()
	{
		this.aliases = new ArrayList();
		this.aliases.add("uhc");
	}

	@Override
	public String getCommandName()
	{
		return "uhc";
	}

	@Override
	public String getCommandUsage(ICommandSender icommandsender)
	{
		return "uhc [FLAG]";
	}

	@Override
	public List getCommandAliases()
	{
		return this.aliases;
	}

    
	@Override
	public void processCommand(ICommandSender icommandsender, String[] args)
	{
		if (args.length > 0)
		{
			if (args[0].equalsIgnoreCase("start"))
			{
				Main.server = new ServerMagic();
				Packets.network.sendToAll(new PacketGameStart());
				Main.server.start_new_game(60);				
			}
			else if (Main.server != null)
			{
				if (args[0].equalsIgnoreCase("stop"))
				{
					Packets.network.sendToAll(new PacketGameStop());
					Main.server = null;
				}
				else if (args[0].equalsIgnoreCase("chest"))
					this.genChest(icommandsender.getEntityWorld());
				else if (args[0].equalsIgnoreCase("localize"))
					this.displayPlayers();
				else if (args[0].equalsIgnoreCase("togglepvp"))
					this.handlePvp(icommandsender, args);
				else if (args[0].equalsIgnoreCase("teleport"))
					this.handleTeleport(icommandsender);
				else if (args[0].equalsIgnoreCase("setborders"))
					this.handleBorders(icommandsender, args);
				else
				{
					icommandsender.addChatMessage(new ChatComponentText(ChatColor.RED + "Error usage: /uhc [FLAG]"));
					icommandsender.addChatMessage(new ChatComponentText(ChatColor.RED + "Flags: start; teleport; setborders; stop; togglepvp; localize"));
				}
			}
			else
				icommandsender.addChatMessage(new ChatComponentText(ChatColor.RED + "Error: no game is running."));
		}
		else
		{
			icommandsender.addChatMessage(new ChatComponentText(ChatColor.RED + "Error usage: /uhc [FLAG]"));
			icommandsender.addChatMessage(new ChatComponentText(ChatColor.RED + "Flags: start; teleport; setborders; stop; togglepvp; localize"));
		}
		
	}

    
	void	handleBorders(ICommandSender icommandsender, String[] args)
	{
		if (args.length > 4)
		{
			try
			{
				Main.server.min_x = Integer.valueOf(args[1]);
				Main.server.min_z = Integer.valueOf(args[2]);
				Main.server.max_x = Integer.valueOf(args[3]);
				Main.server.max_z = Integer.valueOf(args[4]);
				Packets.network.sendToAll(new PacketBorders(Main.server));
			} catch (Exception e) {
				icommandsender.addChatMessage(new ChatComponentText(ChatColor.RED + "Error usage: /uhc setborders [MIN_X] [MIN_Z] [MAX_X] [MAX_Z]"));
			}
		}
		else
			icommandsender.addChatMessage(new ChatComponentText(ChatColor.RED + "" + "Error usage: /uhc setborders [MIN_X] [MIN_Z] [MAX_X] [MAX_Z]"));
	
	}

	void	handleTeleport(ICommandSender icommandsender)
	{
		Random rand;

		this.genPortal(Main.server.mc_server.getEntityWorld());
		Main.server.portal_is_generated = true;
		
		rand = icommandsender.getEntityWorld().rand;
		for (Object obj : icommandsender.getEntityWorld().playerEntities)
		{
			int x = Main.server.min_x + (rand.nextInt(Main.server.max_x - Main.server.min_x));
			int z = Main.server.min_z + (rand.nextInt(Main.server.max_z - Main.server.min_z));
			int y = icommandsender.getEntityWorld().getTopSolidOrLiquidBlock(x, z) + 100;
			((EntityPlayer)obj).addPotionEffect(new PotionEffect(Potion.resistance.id, 400, 999));
			Main.server.mc_server.getCommandManager().executeCommand(icommandsender, "tp " + ((EntityPlayer)obj).getCommandSenderName() + " " + x + " " + y + " " + z);
		}		
	}

	void	handlePvp(ICommandSender icommandsender, String[] args)
	{
		if (args.length > 1)
		{
			if (args[1].equalsIgnoreCase("true"))
			{
				Main.server.no_pvp_duration = -1;
				Main.server.mc_server.setAllowPvp(true);
				Packets.network.sendToAll(new PacketTogglePvp(true));
			}
			else if (args[1].equalsIgnoreCase("false"))
			{
				Main.server.no_pvp_duration = -1;
				Main.server.mc_server.setAllowPvp(false);
				Packets.network.sendToAll(new PacketTogglePvp(false));
			}
			else
			{
				icommandsender.addChatMessage(new ChatComponentText(ChatColor.RED + "Error usage: /uhc togglepvp [BOOLEAN]"));
				icommandsender.addChatMessage(new ChatComponentText(ChatColor.RED + "BOOLEAN : true / false if you want enable / disable pvp"));
			}
		}
		else
		{
			icommandsender.addChatMessage(new ChatComponentText(ChatColor.RED + "Error usage: /uhc togglepvp [BOOLEAN]"));
			icommandsender.addChatMessage(new ChatComponentText(ChatColor.RED + "BOOLEAN : true / false if you want enable / disable pvp"));
		}
	}
	
	void	displayPlayers()
	{
		Main.server.mc_server.getCommandManager().executeCommand(Main.server.mc_server, "say Localisation des joueurs:");

		for (World world : Main.server.mc_server.worldServers)
		{
			for (Object obj : world.playerEntities)
			{
				EntityPlayer p = (EntityPlayer) obj;
				int x = (int) p.posX;
				int y = (int) p.posY;
				int z = (int) p.posZ;
				String biom = world.getBiomeGenForCoords(x, z).biomeName;
				Main.server.mc_server.getCommandManager().executeCommand(Main.server.mc_server, "say " + p.getCommandSenderName() + ": X:" + x + " Y:" + y + " Z:" + z + " Biom: " + biom);
			}
		}
	}
	
	
	void		genChest(World w)
	{
		Random rand;
		TileEntityChest chest;
		EntityLightningBolt bolt;
		int x;
		int y;
		int z;
		
		rand = w.rand;
		x = Main.server.min_x + (rand.nextInt(Math.abs(Main.server.max_x - Main.server.min_x)));
		z = Main.server.min_z + (Math.abs(rand.nextInt(Main.server.max_z - Main.server.min_z)));
		y = w.getTopSolidOrLiquidBlock(x, z);
		bolt = new EntityLightningBolt(w, x, y, z);
		w.spawnEntityInWorld(bolt);
		w.setBlock(x, y, z, Blocks.chest);
		chest = (TileEntityChest) w.getTileEntity(x, y, z);
		this.fill_chest(chest, rand);
		
		Main.server.mc_server.getCommandManager().executeCommand(Main.server.mc_server, "say Un coffre est apparu en: X:" + x + " Y:" + y + " Z:" + z);
	}
	
	void fill_chest(TileEntityChest chest, Random rand)
	{
		chest.setInventorySlotContents(rand.nextInt(chest.getSizeInventory() - 1), new ItemStack(Blocks.enchanting_table, 1));
		for (int i = 0; i < 6 + rand.nextInt(10); i++)
		{
			chest.setInventorySlotContents(rand.nextInt(chest.getSizeInventory() - 1), getRandomItemStack(rand));
		}
	}

	ItemStack getRandomItemStack(Random rand)
	{		
		switch (rand.nextInt(42))
		{
			case 0 :
				return (new ItemStack(Items.blaze_rod, 4));
				
			case 1 :
				return (new ItemStack(Items.cake, 1));
				
			case 2 :
				return (new ItemStack(Items.map, 3));
				
			case 3 :
				return (new ItemStack(Items.melon, 16));
				
			case 4 :
				return (new ItemStack(Items.apple, 8));
				
			case 5 :
				return (new ItemStack(Items.bucket, 4));
				
			case 6 :
				return (new ItemStack(Items.nether_wart, 8));
				
			case 7 :
				return (new ItemStack(Blocks.dirt, 32));
				
			case 8 :
				return (new ItemStack(ItemRegister.COMBUSTIUM, 16 + rand.nextInt(5)));
				
			case 9 :
				return (new ItemStack(ItemRegister.ETHERNIUM, 10 + rand.nextInt(10)));
				
			case 10 :
				return (new ItemStack(ItemRegister.BERRY_YELLOW, 8));
				
			case 11 :
				return (new ItemStack(ItemRegister.getRandomArmor(), 1));
				
			case 12 :
				return (new ItemStack(ItemRegister.getRandomArmor(), 1));
				
			case 13 :
				return (new ItemStack(ItemRegister.getRandomArmor(), 1));
				
			case 14 :
				return (new ItemStack(ItemRegister.getRandomArmor(), 1));
				
			case 15 :
				return (new ItemStack(ItemRegister.getRandomArmor(), 1));
				
			case 16 :
				return (new ItemStack(ItemRegister.getRandomArmor(), 1));
				
			case 17 :
				return (new ItemStack(Items.diamond_pickaxe, 1));
				
			case 18 :
				return (new ItemStack(Items.cooked_chicken, 8));
				
			case 19 :
				return (new ItemStack(Items.bow, 1));
				
			case 20 :
				return (new ItemStack(BlockRegister.LOGS1, 16));
				
			case 21 :
				return (new ItemStack(ItemRegister.BERRY_RED, 8));
				
			case 22 :
				return (new ItemStack(Items.boat, 1));
				
			case 23 :
				return (new ItemStack(Items.bone, 8));
				
			case 24 :
				return (new ItemStack(Items.fishing_rod, 1));
				
			case 25 :
				return (new ItemStack(Items.redstone, 16));
				
			case 26 :
				return (new ItemStack(Items.shears, 1));
				
			case 27 :
				return (new ItemStack(Items.bed, 1));
				
			case 28 :
				return (new ItemStack(Items.ghast_tear, 2));
				
			case 29 :
				return (new ItemStack(Items.carrot, 4));
				
			case 30 :
				return (new ItemStack(Blocks.anvil, 1));	
				
			case 31 :
				return (new ItemStack(Blocks.crafting_table, 1));
				
			case 32 :
				return (new ItemStack(Blocks.furnace, 4));
				
			case 33 :
				return (new ItemStack(Blocks.glowstone, 4));
				
			case 34 :
				return (new ItemStack(Blocks.torch, 8));
				
			case 35 :
				return (new ItemStack(Blocks.ender_chest, 1));
				
			case 36 :
				return (new ItemStack(Items.arrow, 16));
				
			case 37 :
				return (new ItemStack(Items.coal, 16));
				
			case 38 :
				return (new ItemStack(Items.stick, 16));
				
			case 39 :
				return (new ItemStack(Items.stick, 16));
				
			case 40 :
				return (new ItemStack(Items.stick, 16));
				
			case 41 :
				return (new ItemStack(Items.leather, 16));	
		}
		return null;
	}

	void		genPortal(World w)
	{
		int R;
		int r;
		int x;
		int y;
		int z;
		int x1;
		int y1;
		int z1;
		
		
		//leaves
		R = 20;
		r = 10;
		x = (Main.server.min_x + Main.server.max_x) / 2;
		z = (Main.server.min_z + Main.server.max_z) / 2;
		y = w.getTopSolidOrLiquidBlock(x, z) + 5;
		for (float u = -180; u < 180; u += 1)
		{
			for (float v = -180; v < 180; v += 1)
			{
				x1 = (int) ((R + r * MathHelper.cos(v)) * MathHelper.cos(u));
				y1 = (int) ((R + r * MathHelper.cos(v)) * MathHelper.sin(u));
				z1 = (int) (r * MathHelper.sin(v));
				w.setBlock(x + x1, y + z1, z + y1, Blocks.stained_glass);
			}
		}	
		
		
		//portal
		R = 4;
		r = 4;
		x = (Main.server.min_x + Main.server.max_x) / 2;
		z = (Main.server.min_z + Main.server.max_z) / 2;
		y = w.getTopSolidOrLiquidBlock(x, z) + 5;
		for (float u = -180; u < 180; u += 1)
		{
			for (float v = -180; v < 180; v += 1)
			{
				x1 = (int) ((R + r * MathHelper.cos(v)) * MathHelper.cos(u));
				y1 = (int) ((R + r * MathHelper.cos(v)) * MathHelper.sin(u));
				z1 = (int) (r * MathHelper.sin(v));
				w.setBlock(x + x1, y + z1, z + y1, BlockRegister.PORTAL_MY_GROV);
			}
		}
	}
	
	
	
	@Override
	public boolean canCommandSenderUseCommand(ICommandSender icommandsender)
	{
		return (icommandsender.canCommandSenderUseCommand(2, this.getCommandName()));
	}

	@Override
	public List addTabCompletionOptions(ICommandSender icommandsender, String[] astring)
	{
        return getListOfStringsMatchingLastWord(astring, "start", "setborders", "teleport", "chest", "localize", "togglepvp");
	}

	@Override
	public boolean isUsernameIndex(String[] astring, int i)
	{
		return false;
	}

	@Override
	public int	compareTo(Object o)
	{
		return 0;
	}
}