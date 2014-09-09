package fr.toss.common.world.bioms.deco;

import java.util.Random;

import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import cpw.mods.fml.common.IWorldGenerator;
import fr.toss.common.register.ItemRegister;

public class WorldGenChestElficStaff implements IWorldGenerator {

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider)
	{
		if (random.nextInt(200) == 0 &&
				world.getBiomeGenForCoords(chunkX, chunkZ).biomeName.contains("Forest") ||
				world.getBiomeGenForCoords(chunkX, chunkZ).biomeName.contains("Plain") ||
				world.getBiomeGenForCoords(chunkX, chunkZ).biomeName.contains("Jungle"))
		{
			int x = chunkX * 16 + random.nextInt(16);
			int z = chunkZ * 16 + random.nextInt(16);
			int y = world.getTopSolidOrLiquidBlock(x, z);

			world.setBlock(x, y, z, Blocks.chest);
			TileEntityChest chest = (TileEntityChest) world.getTileEntity(x, y, z);
			if (chest != null)
			{
				chest.setInventorySlotContents(0, new ItemStack(ItemRegister.STAFF_ELFIC, 1));
				
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
