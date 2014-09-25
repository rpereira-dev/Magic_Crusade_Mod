package fr.toss.common.blocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fr.toss.common.Main;

public class BlockPortalMagic extends Block {
	

	public BlockPortalMagic(int id)
	{
		super(Material.fire);
        this.setTickRandomly(true);
        this.setBlockTextureName("magiccrusade:portal_dim");
        this.setBlockName("portal_dim");
        this.lightValue = 1;
        this.setBlockBounds(0.001f, 0.001f, 0.001f, 0.999f, 0.999f, 0.999f);
        this.setResistance(1.0f);
	}
	
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
		Main.getPlayerServer(player).travelToDimension(player.dimension != Main.DIM_ID ? Main.DIM_ID : 0, player.dimension);
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