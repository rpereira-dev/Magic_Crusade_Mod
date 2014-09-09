package fr.toss.common.blocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fr.toss.common.Main;
import fr.toss.common.world.TeleporterDim;

public class m_BlockPortal extends Block {
	
	public m_BlockPortal()
	{
		super(Material.fire);
        this.setBlockBounds(0.25F, 0.25f, 0.25F, 0.75F, 0.75F, 0.75F);
        this.setTickRandomly(true);
        this.lightValue = 1;
        this.setResistance(1.0f);
	}
	
	public boolean onBlockActivated(World w, int x, int y, int z, EntityPlayer player, int entier, float a, float b, float c)
    {
    	travelToDimension(player);
    	return (true);
    }
	
	 /**
     * Teleports the entity to another dimension. Params: Dimension number to teleport to
     */
    public void travelToDimension(EntityPlayer player)
    {	
    	if ((player.ridingEntity == null) && (player.riddenByEntity == null) && ((player instanceof EntityPlayerMP)))
    	{	    	
    		EntityPlayerMP thePlayer = (EntityPlayerMP)player;
	    	if (thePlayer.timeUntilPortal > 0)
	    	{
		    	thePlayer.timeUntilPortal = 10;
	    	}
	    	else if (thePlayer.dimension != Main.DIM_ID)
	    	{
		    	thePlayer.timeUntilPortal = 10;
		    	thePlayer.mcServer.getConfigurationManager().transferPlayerToDimension(thePlayer, Main.DIM_ID, new TeleporterDim(thePlayer.mcServer.worldServerForDimension(Main.DIM_ID)));
	    	}
	    	else 
	    	{
		    	thePlayer.timeUntilPortal = 10;
		    	thePlayer.mcServer.getConfigurationManager().transferPlayerToDimension(thePlayer, 0, new TeleporterDim(thePlayer.mcServer.worldServerForDimension(0)));
	    	}
    	}
    	
    }
    
    /**
     * How many world ticks before ticking
     */
    public int tickRate(World p_149738_1_)
    {
        return 10;
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
            double d3 = (double)(rand.nextFloat() * 2.0F * (float)rand.nextInt(2) * 2 - 1);
            double d4 = ((double)rand.nextFloat() - 0.5D) * 0.5D;
            double d5 = ((double)rand.nextFloat() - 0.5D) * 0.5D;
            w.spawnParticle("portal", d0, d1, d2, d3, d4, d5);
        }
    }
    
    /**
     * If this block doesn't render as an ordinary block it will return False (examples: signs, buttons, stairs, etc)
     */
    public boolean renderAsNormalBlock()
    {
        return false;
    }

}