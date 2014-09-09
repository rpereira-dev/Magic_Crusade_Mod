package fr.toss.common.world.bioms.deco;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentData;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.world.World;
import fr.toss.common.register.ItemRegister;

public class APIGen
{
	
  public static EntitySkeleton getRandomSkeletonClasse(World w, double x, double y, double z, Random r)
  {
    EntitySkeleton skeleton = new EntitySkeleton(w);
    skeleton.setLocationAndAngles(x, y + 1.0D, z, 0.0F, 0.0F);
    skeleton.setSkeletonType(1);

    int alea = r.nextInt(4);

    if (alea == 0)
    {
    }
    else if (alea == 1)
    {}
    else
    {}

    return skeleton;
  }

  public static void genCubePlein(World w, int x, int y, int z, int lon, int haut, int lar, Block block)
  {
	for (int i = 0; i < lon; i++)
	{
	  for (int j = 0; j < lar; j++)
	  {
	    for (int k = 0; k < haut; k++)
	    {
	      w.setBlock(x + i, y + k, z + j, block);
	    }
	  }
	}
  }

  public static void genCubeVide(World w, int x, int y, int z, int lon, int haut, int lar, Block block)
  {
	  for (int i = 0; i < lon; i++)
	  {
		  for (int j = 0; j < lar; j++)
		  {
			  for (int k = 0; k < haut; k++)
			  {
				  if (i == 0 || j == 0 || k == 0 || i == lon - 1 || j == lar - 1 || k == haut - 1)
					  w.setBlock(x + i, y + k, z + j, block);
			  }
		  }
	  }
  }

  public static void genCubeVidePorte(World w, int x, int y, int z, int lon, int haut, int lar, Block block, Block door)
  {
	  genCubeVide(w, x, y, z, lon, haut, lar, block);

    w.setBlock(x + lon / 2, y + haut / 2 - 1, z, door);
    w.setBlock(x + lon / 2, y + haut / 2 - 2, z, door);
    w.setBlock(x + lon / 2 - 1, y + haut / 2 - 1, z, door);
    w.setBlock(x + lon / 2 - 1, y + haut / 2 - 2, z, door);

    w.setBlock(x + lon / 2, y + haut / 2 - 1, z + lar - 1, door);
    w.setBlock(x + lon / 2, y + haut / 2 - 2, z + lar - 1, door);
    w.setBlock(x + lon / 2 - 1, y + haut / 2 - 1, z + lar - 1, door);
    w.setBlock(x + lon / 2 - 1, y + haut / 2 - 2, z + lar - 1, door);

    w.setBlock(x, y + haut / 2 - 1, z + lar / 2, door);
    w.setBlock(x, y + haut / 2 - 2, z + lar / 2, door);
    w.setBlock(x, y + haut / 2 - 1, z + lar / 2 - 1, door);
    w.setBlock(x, y + haut / 2 - 2, z + lar / 2 - 1, door);

    w.setBlock(x + lon - 1, y + haut / 2 - 1, z + lar / 2, door);
    w.setBlock(x + lon - 1, y + haut / 2 - 2, z + lar / 2, door);
    w.setBlock(x + lon - 1, y + haut / 2 - 1, z + lar / 2 - 1, door);
    w.setBlock(x + lon - 1, y + haut / 2 - 2, z + lar / 2 - 1, door);
  }

  public static void genCubeVidePorteTorch(World w, int x, int y, int z, int lon, int haut, int lar, Block block, Block door)
  {
    genCubeVidePorte(w, x, y, z, lon, haut, lar, block, door);

    w.setBlock(x + lon / 2 + 1, y + haut / 2 - 1, z, Blocks.torch);
    w.setBlock(x + lon / 2 - 2, y + haut / 2 - 1, z, Blocks.torch);

    w.setBlock(x + lon / 2 + 1, y + haut / 2 - 1, z + lar - 1, Blocks.torch);
    w.setBlock(x + lon / 2 - 2, y + haut / 2 - 1, z + lar - 1, Blocks.torch);

    w.setBlock(x, y + haut / 2 - 1, z + lar / 2 + 1, Blocks.torch);
    w.setBlock(x, y + haut / 2 - 1, z + lar / 2 - 2, Blocks.torch);

    w.setBlock(x + lon - 1, y + haut / 2 - 1, z + lar / 2 + 1, Blocks.torch);
    w.setBlock(x + lon - 1, y + haut / 2 - 1, z + lar / 2 - 2, Blocks.torch);
  }
  

  public static void genCubePleinTrou(World w, int x, int y, int z, int lon, int haut, int lar, Block block, Block trou, Random r, int ratio)
  {
    for (int i = 0; i < lon; i++)
    {
      for (int j = 0; j < lar; j++)
      {
        for (int k = 0; k < haut; k++)
        {
          if (r.nextInt(ratio) == 0)
          {
            w.setBlock(x + i, y + k, z + j, trou);
          }
          else
          {
            w.setBlock(x + i, y + k, z + j, block);
          }
        }
      }
    }
  }

  public static void genCubePleinTrouPorte(World w, int x, int y, int z, int lon, int haut, int lar, Block block, Block trou, Random r, int ratio)
  {
    genCubeVideTrou(w, x, y, z, lon, haut, lar, block, trou, r, ratio);

    w.setBlock(x + lon / 2, y + haut / 2 - 1, z, Blocks.air);
    w.setBlock(x + lon / 2, y + haut / 2 - 2, z, Blocks.air);
    w.setBlock(x + lon / 2 - 1, y + haut / 2 - 1, z, Blocks.air);
    w.setBlock(x + lon / 2 - 1, y + haut / 2 - 2, z, Blocks.air);

    w.setBlock(x + lon / 2, y + haut / 2 - 1, z + lar - 1, Blocks.air);
    w.setBlock(x + lon / 2, y + haut / 2 - 2, z + lar - 1, Blocks.air);
    w.setBlock(x + lon / 2 - 1, y + haut / 2 - 1, z + lar - 1, Blocks.air);
    w.setBlock(x + lon / 2 - 1, y + haut / 2 - 2, z + lar - 1, Blocks.air);

    w.setBlock(x, y + haut / 2 - 1, z + lar / 2, Blocks.air);
    w.setBlock(x, y + haut / 2 - 2, z + lar / 2, Blocks.air);
    w.setBlock(x, y + haut / 2 - 1, z + lar / 2 - 1, Blocks.air);
    w.setBlock(x, y + haut / 2 - 2, z + lar / 2 - 1, Blocks.air);

    w.setBlock(x + lon - 1, y + haut / 2 - 1, z + lar / 2, Blocks.air);
    w.setBlock(x + lon - 1, y + haut / 2 - 2, z + lar / 2, Blocks.air);
    w.setBlock(x + lon - 1, y + haut / 2 - 1, z + lar / 2 - 1, Blocks.air);
    w.setBlock(x + lon - 1, y + haut / 2 - 2, z + lar / 2 - 1, Blocks.air);
  }
  
  public static void genCubeVideTrou(World w, int x, int y, int z, int lon, int haut, int lar, Block block, Block trou, Random r, int ratio)
  {
    genCubePleinTrou(w, x, y, z, lon, haut, lar, block, trou, r, ratio);
    genCubePlein(w, x + 1, y + 1, z + 1, lon - 2, haut - 2, lar - 2, Blocks.air);
  }

  
  public static void genCubePleinTrouPorteTorch(World w, int x, int y, int z, int lon, int haut, int lar, Block block, Block trou, Random r, int ratio)
  {
    genCubePleinTrouPorte(w, x, y, z, lon, haut, lar, block, trou, r, ratio);

    w.setBlock(x + lon / 2 + 1, y + haut / 2 - 1, z, Blocks.torch);
    w.setBlock(x + lon / 2 - 2, y + haut / 2 - 1, z, Blocks.torch);

    w.setBlock(x + lon / 2 + 1, y + haut / 2 - 1, z + lar - 1, Blocks.torch);
    w.setBlock(x + lon / 2 - 2, y + haut / 2 - 1, z + lar - 1, Blocks.torch);

    w.setBlock(x, y + haut / 2 - 1, z + lar / 2 + 1, Blocks.torch);
    w.setBlock(x, y + haut / 2 - 1, z + lar / 2 - 2, Blocks.torch);

    w.setBlock(x + lon - 1, y + haut / 2 - 1, z + lar / 2 + 1, Blocks.torch);
    w.setBlock(x + lon - 1, y + haut / 2 - 1, z + lar / 2 - 2, Blocks.torch);
  }

  public static void replaceBlocks(World w, int x, int z, int lon, int lar, Block block)
  {
    for (int i = 0; i < lon; i++)
    {
      for (int j = 0; j < lar; j++)
      {
        Block b = w.getBlock(x + i, w.getTopSolidOrLiquidBlock(x + i, z + j), z + j);
        if (b == block)
    	  	w.setBlock(x + i, w.getTopSolidOrLiquidBlock(x + i, z + j), z + j, block);
      }
    }
  }

  
	public static void genChest(World world, int x, int y, int z, Random rand)
	{
		world.setBlock(x, y, z, Blocks.chest);
		TileEntityChest chest = (TileEntityChest) world.getTileEntity(x, y, z);
		ItemStack itemstack = null;
		EnchantmentData en = null;
		
		for (int i = 0; i < chest.getSizeInventory(); i++)
		{
			if (rand.nextInt(3) == 0)
			{
				switch (rand.nextInt(24))
				{
					case 0:
						itemstack = new ItemStack(ItemRegister.COMBUSTIUM, 2 + rand.nextInt(10));
						break;
						
					case 1:
						itemstack = new ItemStack(ItemRegister.BERRY_YELLOW, 2 + rand.nextInt(10));
						break;
						
					case 2:
						itemstack = new ItemStack(ItemRegister.BERRY_RED, 2 + rand.nextInt(10));
						break;
						
					case 3:
						itemstack = new ItemStack(Items.diamond, 2 + rand.nextInt(10));
						break;
						
					case 4:
						itemstack = new ItemStack(Items.emerald, 2 + rand.nextInt(10));
						break;
						
					case 5:
						en = new EnchantmentData(Enchantment.thorns, 3);
						itemstack = new ItemStack(Items.enchanted_book, 1);
						Items.enchanted_book.addEnchantment(itemstack, en);
						break;
						
					case 6:
						en = new EnchantmentData(Enchantment.fireAspect, 3);
						itemstack = new ItemStack(Items.enchanted_book, 1);
						Items.enchanted_book.addEnchantment(itemstack, en);
						break;
						
					case 7:
						itemstack = new ItemStack(Items.blaze_powder, 5);
						break;
						
					case 8:
						itemstack = new ItemStack(Items.stick, 28);
						break;
						
					case 9:
						en = new EnchantmentData(Enchantment.blastProtection, 4);
						itemstack = new ItemStack(Items.enchanted_book, 1);
						Items.enchanted_book.addEnchantment(itemstack, en);
						break;
						
					case 10:
						en = new EnchantmentData(Enchantment.blastProtection, 5);
						itemstack = new ItemStack(Items.enchanted_book, 1);
						Items.enchanted_book.addEnchantment(itemstack, en);
						break;
						
					case 11:
						itemstack = new ItemStack(Items.apple, 2 + rand.nextInt(10));
						break;
						
					case 12:
						itemstack = new ItemStack(Items.iron_axe, 2 + rand.nextInt(10));
						break;
						
					case 13:
						itemstack = new ItemStack(Items.iron_ingot, 2 + rand.nextInt(10));
						break;
						
					case 14:
						itemstack = new ItemStack(Items.gold_nugget, 2 + rand.nextInt(10));
						break;
						
					case 15:
						itemstack = new ItemStack(Items.gold_ingot, 2 + rand.nextInt(10));
						break;
						
					case 16:
						itemstack = new ItemStack(Items.coal, 2 + rand.nextInt(10));
						break;
						
					case 17:
						itemstack = new ItemStack(Items.bone, 2 + rand.nextInt(10));
						break;
						
					case 18:
						itemstack = new ItemStack(Items.flint_and_steel, 2 + rand.nextInt(10));
						break;
						
					case 19:
						itemstack = new ItemStack(Items.flint, 2 + rand.nextInt(10));
						break;

					case 20:
						itemstack = new ItemStack(ItemRegister.INGOT_SILVER, 2 + rand.nextInt(10));
						break;
						
					case 21:
						itemstack = new ItemStack(ItemRegister.ETHERNIUM, 2 + rand.nextInt(10));
						break;
						
					case 22:
						itemstack = new ItemStack(ItemRegister.INGOT_TITANIUM, 2 + rand.nextInt(10));
						break;
						
					case 23:
						itemstack = new ItemStack(ItemRegister.STAFF_BUMPING, 2 + rand.nextInt(10));
						break;
				}
				chest.setInventorySlotContents(i, itemstack);
			}
		}
	}
}