package fr.toss.common.blocks;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockLeavesBase;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.IShearable;
import net.minecraftforge.common.util.ForgeDirection;

public class BlockLeavesDim extends BlockLeavesBase implements IShearable
{
	public static enum LeafCategory
	{
		CAT1, CAT2, CAT3, CAT4;
	}

	private static final String[] leaves = new String[] {"violette", "frozen", "bleu", "noir"};

	private static final float[] fallingLeavesChance = new float[] {0.1F, 0.008F, 0.016F, 0.008F};

	private IIcon[][] textures;
	private final LeafCategory category;
	int[] adjacentTreeBlocks;

	public BlockLeavesDim(LeafCategory cat)
	{
        super(Material.leaves, false);
        
		category = cat;
        this.setBlockName("leaves");
		this.setHardness(0.2F);
		this.setStepSound(Block.soundTypeGrass);
		this.setTickRandomly(true);
		this.setLightOpacity(1);
	}

	@Override
	public void registerBlockIcons(IIconRegister iconRegister)
	{
		textures = new IIcon[3][leaves.length];
		for (int i = 0; i < leaves.length; ++i)
		{
			textures[0][i] = iconRegister.registerIcon("magiccrusade:leaves_" + leaves[i] + "_fancy");
			textures[1][i] = iconRegister.registerIcon("magiccrusade:leaves_" + leaves[i] + "_fast");
		}
	}

	public IIcon getIconBetterLeaves(int metadata, float randomIndex)
	{
		int type = getTypeFromMeta(metadata) + (category.ordinal() * 4);
		return textures[2][type >= leaves.length ? 0 : type];
	}

	public IIcon getIconFallingLeaves(int metadata)
	{
		int type = getTypeFromMeta(metadata) + (category.ordinal() * 4);
		return textures[1][type >= leaves.length ? 0 : type];
	}

	public float getSpawnChanceFallingLeaves(int metadata)
	{
		int type = getTypeFromMeta(metadata) + (category.ordinal() * 4);
		return fallingLeavesChance[type >= leaves.length ? 0 : type];
	}

	@Override
	public IIcon getIcon(int side, int metadata)
	{
		int type = getTypeFromMeta(metadata) + (category.ordinal() * 4);
		return textures[(!isOpaqueCube() ? 0 : 1)][type >= leaves.length ? 0 : type];
	}

	@Override
	public boolean isOpaqueCube()
	{
		return Blocks.leaves.isOpaqueCube();
	}

	@Override
	public void getSubBlocks(Item block, CreativeTabs creativeTabs, List list) 
	{
		for (int i = 0; i < 4; ++i)
		{
			if (category != LeafCategory.CAT4 || i < 2) 
			{
				list.add(new ItemStack(block, 1, i));
			}
		}
	}

	
	public boolean isType(int metadata, int baseMeta)
	{
		for (int type = baseMeta; type <= baseMeta + (4 * 3); type += 4)
		{
			if (metadata == type) return true;
		}
		
		return false;
	}

    @Override
	public void breakBlock(World world, int x, int y, int z, Block par5, int par6)
    {
        byte radius = 1;
        int bounds = radius + 1;

        if (world.checkChunksExist(x - bounds, y - bounds, z - bounds, x + bounds, y + bounds, z + bounds)) 
        {
            for (int i = -radius; i <= radius; ++i) 
            {
                for (int j = -radius; j <= radius; ++j) 
                {
                    for (int k = -radius; k <= radius; ++k)
                    {
						Block block = world.getBlock(x + i, y + j, z + k);

						if (block.isLeaves(world, x, y, z)) 
						{
							block.beginLeavesDecay(world, x + i, y + j, z + k);
						}
                    }
                }
            }
        }
    }

	@Override
	public void updateTick(World world, int x, int y, int z, Random random)
	{
		if (world.isRemote)
			return;

		int meta = world.getBlockMetadata(x, y, z);

		if ((meta & 8) != 0 && (meta & 4) == 0)
		{
			byte b0 = 4;
			int i1 = b0 + 1;
			byte b1 = 32;
			int j1 = b1 * b1;
			int k1 = b1 / 2;

			if (adjacentTreeBlocks == null)
			{
				adjacentTreeBlocks = new int[b1 * b1 * b1];
			}

			int l1;

			if (world.checkChunksExist(x - i1, y - i1, z - i1, x + i1, y + i1, z + i1))
			{
				int i2;
				int j2;
				int k2;

				for (l1 = -b0; l1 <= b0; ++l1)
				{
					for (i2 = -b0; i2 <= b0; ++i2)
					{
						for (j2 = -b0; j2 <= b0; ++j2)
						{
                            Block block = world.getBlock(x + l1, y + i2, z + j2);

							if (block != null && block.canSustainLeaves(world, x + l1, y + i2, z + j2))
							{
								adjacentTreeBlocks[(l1 + k1) * j1 + (i2 + k1) * b1 + j2 + k1] = 0;
							}
							else if (block != null && block.isLeaves(world, x + l1, y + i2, z + j2))
							{
								adjacentTreeBlocks[(l1 + k1) * j1 + (i2 + k1) * b1 + j2 + k1] = -2;
							}
							else
							{
								adjacentTreeBlocks[(l1 + k1) * j1 + (i2 + k1) * b1 + j2 + k1] = -1;
							}
						}
					}
				}

				for (l1 = 1; l1 <= 4; ++l1)
				{
					for (i2 = -b0; i2 <= b0; ++i2)
					{
						for (j2 = -b0; j2 <= b0; ++j2)
						{
							for (k2 = -b0; k2 <= b0; ++k2)
							{
								if (adjacentTreeBlocks[(i2 + k1) * j1 + (j2 + k1) * b1 + k2 + k1] == l1 - 1)
								{
									if (adjacentTreeBlocks[(i2 + k1 - 1) * j1 + (j2 + k1) * b1 + k2 + k1] == -2)
									{
										adjacentTreeBlocks[(i2 + k1 - 1) * j1 + (j2 + k1) * b1 + k2 + k1] = l1;
									}

									if (adjacentTreeBlocks[(i2 + k1 + 1) * j1 + (j2 + k1) * b1 + k2 + k1] == -2)
									{
										adjacentTreeBlocks[(i2 + k1 + 1) * j1 + (j2 + k1) * b1 + k2 + k1] = l1;
									}

									if (adjacentTreeBlocks[(i2 + k1) * j1 + (j2 + k1 - 1) * b1 + k2 + k1] == -2)
									{
										adjacentTreeBlocks[(i2 + k1) * j1 + (j2 + k1 - 1) * b1 + k2 + k1] = l1;
									}

									if (adjacentTreeBlocks[(i2 + k1) * j1 + (j2 + k1 + 1) * b1 + k2 + k1] == -2)
									{
										adjacentTreeBlocks[(i2 + k1) * j1 + (j2 + k1 + 1) * b1 + k2 + k1] = l1;
									}

									if (adjacentTreeBlocks[(i2 + k1) * j1 + (j2 + k1) * b1 + (k2 + k1 - 1)] == -2)
									{
										adjacentTreeBlocks[(i2 + k1) * j1 + (j2 + k1) * b1 + (k2 + k1 - 1)] = l1;
									}

									if (adjacentTreeBlocks[(i2 + k1) * j1 + (j2 + k1) * b1 + k2 + k1 + 1] == -2)
									{
										adjacentTreeBlocks[(i2 + k1) * j1 + (j2 + k1) * b1 + k2 + k1 + 1] = l1;
									}
								}
							}
						}
					}
				}
			}

			l1 = adjacentTreeBlocks[k1 * j1 + k1 * b1 + k1];

			if (l1 >= 0)
			{
				world.setBlockMetadataWithNotify(x, y, z, meta & -9, 4);
			}
			else
			{
				this.removeLeaves(world, x, y, z);
			}
		}
	}

    private void removeLeaves(World world, int x, int y, int z)
    {
        this.dropBlockAsItem(world, x, y, z, world.getBlockMetadata(x, y, z), 0);
        world.setBlockToAir(x, y, z);
    }

	@Override
	public int getFlammability(IBlockAccess world, int x, int y, int z, ForgeDirection face)
	{
		int metadata = world.getBlockMetadata(x, y, z);
		
		if (category == LeafCategory.CAT4 && metadata == 0)
		{
			return 0;
		}
		else
		{
			return Blocks.fire.getFlammability(this);
		}
	}

	@Override
	public int getFireSpreadSpeed(IBlockAccess world, int x, int y, int z, ForgeDirection face)
	{
		int metadata = world.getBlockMetadata(x, y, z);
		
		if (category == LeafCategory.CAT4 && metadata == 0)
		{
			return 0;
		}
		else
		{
			return Blocks.fire.getEncouragement(this);
		}
	}

	@Override
	public boolean isFlammable(IBlockAccess world, int x, int y, int z, ForgeDirection face)
	{
		int metadata = world.getBlockMetadata(x, y, z);
		
		if (category == LeafCategory.CAT4 && metadata == 0)
		{
			return false;
		}
		else
		{
			return getFlammability(world, x, y, z, face) > 0;
		}
	}

    @Override
	public Item getItemDropped(int metadata, Random random, int fortune)
	{
        return Item.getItemById(0);
    }

	@Override
	public int damageDropped(int meta)
	{
		return (getTypeFromMeta(meta) + category.ordinal() * 4) + 1;
	}

	@Override
	public int getDamageValue(World world, int x, int y, int z) 
    {
		return getTypeFromMeta(world.getBlockMetadata(x, y, z));
	}

	@Override
	public boolean isShearable(ItemStack item, IBlockAccess world, int x, int y, int z)
	{
		return true;
	}

	@Override
	public ArrayList<ItemStack> onSheared(ItemStack item, IBlockAccess world, int x, int y, int z, int fortune)
	{
		ArrayList<ItemStack> ret = new ArrayList<ItemStack>();
		ret.add(new ItemStack(this, 1, getTypeFromMeta(world.getBlockMetadata(x, y, z))));
		return ret;
	}

	public String getLeafType(int metadata)
	{
		int type = getTypeFromMeta(metadata) + (category.ordinal() * 4);
		return leaves[type >= leaves.length ? 0 : type];
	}

	private static int getTypeFromMeta(int meta)
	{
		meta = meta & 3;
		if (meta < 0 || meta >= leaves.length) {
			meta = 0;
		}
		return meta;
	}

	@Override
	public boolean shouldSideBeRendered(IBlockAccess world, int x, int y, int z, int side)
	{
		return true;
	}

	@Override
	public void beginLeavesDecay(World world, int x, int y, int z)
	{
		world.setBlockMetadataWithNotify(x, y, z, world.getBlockMetadata(x, y, z) | 8, 4);
	}

	@Override
	public boolean isLeaves(IBlockAccess world, int x, int y, int z)
	{
		return true;
	}
}