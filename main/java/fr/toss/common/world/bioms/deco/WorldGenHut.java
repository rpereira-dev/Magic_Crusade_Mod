package fr.toss.common.world.bioms.deco;

import net.minecraft.block.Block;
import net.minecraft.world.World;

public class WorldGenHut {

	public static void spawn(World world, int x, int y, int z) {

		world.setBlock(x+1, y+0, z+0, Block.getBlockById(109));
		world.setBlockMetadataWithNotify(x+1, y+0, z+0, 2, 2);
		world.setBlock(x+3, y+0, z+0, Block.getBlockById(109));
		world.setBlockMetadataWithNotify(x+3, y+0, z+0, 2, 2);
		world.setBlock(x+0, y+0, z+1, Block.getBlockById(109));
		world.setBlock(x+1, y+0, z+1, Block.getBlockById(85));
		world.setBlock(x+2, y+0, z+1, Block.getBlockById(64));
		world.setBlockMetadataWithNotify(x+2, y+0, z+1, 1, 1);
		world.setBlock(x+3, y+0, z+1, Block.getBlockById(26));
		world.setBlock(x+4, y+0, z+1, Block.getBlockById(109));
		world.setBlockMetadataWithNotify(x+4, y+0, z+1, 1, 1);
		world.setBlock(x+0, y+0, z+2, Block.getBlockById(109));
		world.setBlock(x+3, y+0, z+2, Block.getBlockById(26));
		world.setBlockMetadataWithNotify(x+3, y+0, z+2, 8, 8);
		world.setBlock(x+4, y+0, z+2, Block.getBlockById(109));
		world.setBlockMetadataWithNotify(x+4, y+0, z+2, 1, 1);
		world.setBlock(x+1, y+0, z+3, Block.getBlockById(109));
		world.setBlockMetadataWithNotify(x+1, y+0, z+3, 3, 3);
		world.setBlock(x+2, y+0, z+3, Block.getBlockById(109));
		world.setBlockMetadataWithNotify(x+2, y+0, z+3, 3, 3);
		world.setBlock(x+3, y+0, z+3, Block.getBlockById(109));
		world.setBlockMetadataWithNotify(x+3, y+0, z+3, 3, 3);
		world.setBlock(x+1, y+1, z+0, Block.getBlockById(109));
		world.setBlockMetadataWithNotify(x+1, y+1, z+0, 6, 6);
		world.setBlock(x+3, y+1, z+0, Block.getBlockById(109));
		world.setBlockMetadataWithNotify(x+3, y+1, z+0, 6, 6);
		world.setBlock(x+0, y+1, z+1, Block.getBlockById(109));
		world.setBlockMetadataWithNotify(x+0, y+1, z+1, 4, 4);
		world.setBlock(x+1, y+1, z+1, Block.getBlockById(50));
		world.setBlockMetadataWithNotify(x+1, y+1, z+1, 5, 5);
		world.setBlock(x+2, y+1, z+1, Block.getBlockById(64));
		world.setBlockMetadataWithNotify(x+2, y+1, z+1, 8, 8);
		world.setBlock(x+4, y+1, z+1, Block.getBlockById(109));
		world.setBlockMetadataWithNotify(x+4, y+1, z+1, 5, 5);
		world.setBlock(x+0, y+1, z+2, Block.getBlockById(109));
		world.setBlockMetadataWithNotify(x+0, y+1, z+2, 4, 4);
		world.setBlock(x+4, y+1, z+2, Block.getBlockById(109));
		world.setBlockMetadataWithNotify(x+4, y+1, z+2, 5, 5);
		world.setBlock(x+1, y+1, z+3, Block.getBlockById(109));
		world.setBlockMetadataWithNotify(x+1, y+1, z+3, 7, 7);
		world.setBlock(x+3, y+1, z+3, Block.getBlockById(109));
		world.setBlockMetadataWithNotify(x+3, y+1, z+3, 7, 7);
		world.setBlock(x+1, y+2, z+0, Block.getBlockById(134));
		world.setBlockMetadataWithNotify(x+1, y+2, z+0, 2, 2);
		world.setBlock(x+2, y+2, z+0, Block.getBlockById(134));
		world.setBlockMetadataWithNotify(x+2, y+2, z+0, 2, 2);
		world.setBlock(x+3, y+2, z+0, Block.getBlockById(134));
		world.setBlockMetadataWithNotify(x+3, y+2, z+0, 2, 2);
		world.setBlock(x+0, y+2, z+1, Block.getBlockById(134));
		world.setBlock(x+1, y+2, z+1, Block.getBlockById(5));
		world.setBlockMetadataWithNotify(x+1, y+2, z+1, 1, 1);
		world.setBlock(x+2, y+2, z+1, Block.getBlockById(5));
		world.setBlockMetadataWithNotify(x+2, y+2, z+1, 1, 1);
		world.setBlock(x+3, y+2, z+1, Block.getBlockById(5));
		world.setBlockMetadataWithNotify(x+3, y+2, z+1, 1, 1);
		world.setBlock(x+4, y+2, z+1, Block.getBlockById(134));
		world.setBlockMetadataWithNotify(x+4, y+2, z+1, 1, 1);
		world.setBlock(x+0, y+2, z+2, Block.getBlockById(134));
		world.setBlock(x+1, y+2, z+2, Block.getBlockById(5));
		world.setBlockMetadataWithNotify(x+1, y+2, z+2, 1, 1);
		world.setBlock(x+2, y+2, z+2, Block.getBlockById(5));
		world.setBlockMetadataWithNotify(x+2, y+2, z+2, 1, 1);
		world.setBlock(x+3, y+2, z+2, Block.getBlockById(5));
		world.setBlockMetadataWithNotify(x+3, y+2, z+2, 1, 1);
		world.setBlock(x+4, y+2, z+2, Block.getBlockById(134));
		world.setBlockMetadataWithNotify(x+4, y+2, z+2, 1, 1);
		world.setBlock(x+1, y+2, z+3, Block.getBlockById(134));
		world.setBlockMetadataWithNotify(x+1, y+2, z+3, 3, 3);
		world.setBlock(x+2, y+2, z+3, Block.getBlockById(134));
		world.setBlockMetadataWithNotify(x+2, y+2, z+3, 3, 3);
		world.setBlock(x+3, y+2, z+3, Block.getBlockById(134));
		world.setBlockMetadataWithNotify(x+3, y+2, z+3, 3, 3);
	}
}