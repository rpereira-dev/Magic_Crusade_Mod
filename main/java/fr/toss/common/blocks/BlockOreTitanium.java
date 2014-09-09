package fr.toss.common.blocks;

import java.util.Random;

import net.minecraft.item.Item;
import net.minecraft.world.World;
import fr.toss.common.register.ItemRegister;

public class BlockOreTitanium extends BlockOreMagic {
	
	public BlockOreTitanium()
	{
		super();
		this.setBlockName("ore_ethernium");
		this.setBlockTextureName("magiccrusade:ore_ethernium");
		this.setHardness(2.0f);
		this.setLightLevel(1.0f);
		this.setTickRandomly(true);
	}
	
    public void updateTick(World w, int x, int y, int z, Random rand)
	{
		super.updateTick(w, x, y, z, rand);
		
        for (int l = 0; l < 4; ++l)
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
    
    public Item getItemDropped(int p_149650_1_, Random p_149650_2_, int p_149650_3_)
    {
    	return ItemRegister.ETHERNIUM;
    }

}
