package fr.toss.common.blocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockPortal;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.ChatComponentText;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fr.toss.common.Main;
import fr.toss.common.command.ChatColor;
import fr.toss.common.world.dungeon.Dungeon;

public class BlockPortalDungeon extends BlockPortal {
	
	public int dimID; //Dungeon dim ID
	
	public BlockPortalDungeon(int id)
	{
		super();
		this.dimID = id;
        this.setTickRandomly(true);
        this.setBlockTextureName("magiccrusade:portal_dim");
        this.setBlockName("portal_dim");
        this.lightValue = 1;
        this.setResistance(9999.0f);
	}
	
    public void onNeighborBlockChange(World p_149695_1_, int p_149695_2_, int p_149695_3_, int p_149695_4_, Block p_149695_5_) {}
    
	public boolean onBlockActivated(World w, int x, int y, int z, EntityPlayer player, int entier, float a, float b, float c)
    {
    	if (player instanceof EntityPlayerMP)
    	{
    		handle_teleport((EntityPlayerMP) player);
    		return (true);
    	}
    	return (false);
    }
	
    public void onEntityCollidedWithBlock(World w, int x, int y, int z, Entity e)
    {
    	if (e instanceof EntityPlayerMP)
    		handle_teleport((EntityPlayerMP) e);
    }

    
    public void handle_teleport(EntityPlayerMP player)
    {
    	if (Main.getPlayerServer(player).portal_cd == 0)
    	{
	    	Dungeon	dungeon;
	    	
	    	dungeon = Main.get_dungeon(this.dimID);
			if (player.dimension == this.dimID) //Si le joueur est dans le donjon
			{
				Main.log(player.getCommandSenderName() + " has left " + dungeon.name + ". He is back into: " + dungeon.DIM_RETOUR);
				Main.getPlayerServer(player).travelToDimension(dungeon.DIM_RETOUR, player.dimension);
			}
			else if(dungeon.is_running) //si le dungeon est en cours
			{
				if (player.getTeam() != null && dungeon.current_team.isSameTeam(player.getTeam())) //si le joeuur est dans la meme equipe
					Main.getPlayerServer(player).travelToDimension(this.dimID, player.dimension);
				else
					player.addChatComponentMessage(new ChatComponentText("Error: a group is already in this Dungeon."));
			}
			else //Si le dungeon n'est pas en cours et que le joueur n'est pas dans le donjon
			{
				if (player.getTeam() != null) //si le joueur a une équipe
				{
					Main.getPlayerServer(player).travelToDimension(this.dimID, player.dimension);
					dungeon.despawn_entities(player.worldObj);
					dungeon.spawn_entities(player.worldObj);
					dungeon.is_running = true;
					dungeon.current_team = player.getTeam();
				}
				else // s'il n'en a pas
					player.addChatComponentMessage(new ChatComponentText("You have to be in a group for this dungeon: press " + ChatColor.RED + "G" + ChatColor.RESET));
			}
			Main.getPlayerServer(player).portal_cd = 80;
    	}
    }
    
    /**
     * How many world ticks before ticking
     */
    public int tickRate(World w)
    {
        return 1;
    }
    
    /**
     * A randomly called display update to be able to add particles or other items for display
     */
    @SideOnly(Side.CLIENT)
    public void randomDisplayTick(World w, int x, int y, int z, Random rand)
    {
        if (rand.nextInt(100) == 0)
        {
            w.playSound((double)x + 0.5D, (double)y + 0.5D, (double)z + 0.5D, "portal.portal", 0.5F, rand.nextFloat() * 0.4F + 0.8F, false);
        }
        
        for (int l = 0; l < 4; ++l)
        {
            double d0 = (double)((float)x + rand.nextFloat());
            double d1 = (double)((float)y + rand.nextFloat());
            double d2 = (double)((float)z + rand.nextFloat());
            double d3 = ((double)rand.nextFloat() - 0.5D) * 0.5D;
            double d4 = ((double)rand.nextFloat() - 0.5D) * 0.5D;
            double d5 = ((double)rand.nextFloat() - 0.5D) * 0.5D;

            w.spawnParticle("portal", d0, d1, d2, d3, d4, d5);
            if (rand.nextInt(8) == 0)
            	w.spawnParticle("fireworksSpark", d0, d1, d2, d3, d4, d5);
        }
    }
    
}