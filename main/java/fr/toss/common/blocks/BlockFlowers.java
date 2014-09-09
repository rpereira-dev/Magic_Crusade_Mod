package fr.toss.common.blocks;

import java.util.ArrayList;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockBush;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fr.toss.common.register.BlockRegister;
import fr.toss.common.register.ItemRegister;

public class BlockFlowers extends BlockBush
{
	public BlockFlowers()
	{
		super();
		this.setHardness(0.1f);
		if (this == BlockRegister.SNOW_TALLGRASS)
        	this.setTickRandomly(true);
	}

	protected boolean canPlaceBlockOn(Block b)
    {
    	return (b == Blocks.snow) || (b == Blocks.dirt) || (b == Blocks.grass) 
    			|| (b == BlockRegister.GRASS) || (b == BlockRegister.DIRT);
    }

    @Override
    public ArrayList<ItemStack> getDrops(World world, int x, int y, int z, int meta, int fortune)
    {
        ArrayList<ItemStack> ret;
        
        ret = new ArrayList<ItemStack>();
        if (this == BlockRegister.BERRY_RED)
        	ret.add(new ItemStack(ItemRegister.BERRY_RED, 1 + fortune));
        else if (this == BlockRegister.BERRY_YELLOW)
        	ret.add(new ItemStack(ItemRegister.BERRY_YELLOW, 1 + fortune));
        return ret;
    }
    
    /**
     * A randomly called display update to be able to add particles or other items for display
     */
    @SideOnly(Side.CLIENT)
    public void randomDisplayTick(World w, int x, int y, int z, Random rand)
    {
    	if (this != BlockRegister.TALLGRASS)
    	{
	    	if (rand.nextInt(10) == 0)
	    	{
		        double d0 = (double)((float)x + rand.nextFloat());
		        double d1 = (double)((float)y + rand.nextFloat());
		        double d2 = (double)((float)z + rand.nextFloat());
		        double d3 = (double)(rand.nextFloat() * 2.0F * (float)rand.nextInt(2) * 2 - 1);
		        double d4 = ((double)rand.nextFloat() - 0.5D) * 0.5D;
		        double d5 = ((double)rand.nextFloat() - 0.5D) * 0.5D;
		        w.spawnParticle("fireworksSpark", d0, d1, d2, d3, d4, d5);
	    	}
    	}
    }
}