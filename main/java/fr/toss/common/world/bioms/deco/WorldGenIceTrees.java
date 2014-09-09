package fr.toss.common.world.bioms.deco;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.util.Direction;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import fr.toss.common.register.BlockRegister;

public class WorldGenIceTrees extends WorldGenAbstractTree
{
    public WorldGenIceTrees(boolean p_i45463_1_)
    {
        super(p_i45463_1_);
    }

    public boolean generate(World w, Random rand, int x, int y, int z)
    {
    	if (rand.nextInt(2) == 0)
    		return (false);
    	
        int l = rand.nextInt(3) + rand.nextInt(3) + 12;
        boolean flag = true;

        if (y >= 1 && y + l + 1 <= 256)
        {
            int j1;
            int k1;

            for (int i1 = y; i1 <= y + 1 + l; ++i1)
            {
                byte b0 = 1;

                if (i1 == y)
                {
                    b0 = 0;
                }

                if (i1 >= y + 1 + l - 2)
                {
                    b0 = 2;
                }

                for (j1 = x - b0; j1 <= x + b0 && flag; ++j1)
                {
                    for (k1 = z - b0; k1 <= z + b0 && flag; ++k1)
                    {
                        if (i1 >= 0 && i1 < 256)
                        {
                            Block block = w.getBlock(j1, i1, k1);

                            if (!this.isReplaceable(w, j1, i1, k1))
                            {
                                flag = false;
                            }
                        }
                        else
                        {
                            flag = false;
                        }
                    }
                }
            }

            if (!flag)
            {
                return false;
            }
            else
            {
                Block block3 = w.getBlock(x, y - 1, z);

                boolean isSoil = (block3 == Blocks.snow);
                if (isSoil && y < 256 - l - 1)
                {
                    block3.onPlantGrow(w, x, y - 1, z, x, y, z);
                    int j3 = rand.nextInt(4);
                    j1 = l - rand.nextInt(4) - 1;
                    k1 = 3 - rand.nextInt(3);
                    int k3 = x;
                    int l1 = z;
                    int i2 = 0;
                    int j2;
                    int k2;

                    for (j2 = 0; j2 < l; ++j2)
                    {
                        k2 = y + j2;

                        if (j2 >= j1 && k1 > 0)
                        {
                            k3 += Direction.offsetX[j3];
                            l1 += Direction.offsetZ[j3];
                            --k1;
                        }

                        Block block1 = w.getBlock(k3, k2, l1);

                        if (block1.isAir(w, k3, k2, l1) || block1.isLeaves(w, k3, k2, l1))
                        {
                            this.setBlockAndNotifyAdequately(w, k3, k2, l1, BlockRegister.LOGS1, 1);
                            i2 = k2;
                        }
                    }

                    for (j2 = -1; j2 <= 1; ++j2)
                    {
                        for (k2 = -1; k2 <= 1; ++k2)
                        {
                            this.func_150525_a(w, k3 + j2, i2 + 1, l1 + k2);
                        }
                    }

                    this.func_150525_a(w, k3 + 2, i2 + 1, l1);
                    this.func_150525_a(w, k3 - 2, i2 + 1, l1);
                    this.func_150525_a(w, k3, i2 + 1, l1 + 2);
                    this.func_150525_a(w, k3, i2 + 1, l1 - 2);

                    for (j2 = -3; j2 <= 3; ++j2)
                    {
                        for (k2 = -3; k2 <= 3; ++k2)
                        {
                            if (Math.abs(j2) != 3 || Math.abs(k2) != 3)
                            {
                                this.func_150525_a(w, k3 + j2, i2, l1 + k2);
                            }
                        }
                    }

                    k3 = x;
                    l1 = z;
                    j2 = rand.nextInt(4);

                    if (j2 != j3)
                    {
                        k2 = j1 - rand.nextInt(2) - 1;
                        int l3 = 1 + rand.nextInt(3);
                        i2 = 0;
                        int l2;
                        int i3;

                        for (l2 = k2; l2 < l && l3 > 0; --l3)
                        {
                            if (l2 >= 1)
                            {
                                i3 = y + l2;
                                k3 += Direction.offsetX[j2];
                                l1 += Direction.offsetZ[j2];
                                Block block2 = w.getBlock(k3, i3, l1);

                                if (block2.isAir(w, k3, i3, l1) || block2.isLeaves(w, k3, i3, l1))
                                {
                                    this.setBlockAndNotifyAdequately(w, k3, i3, l1, BlockRegister.LOGS1, 1);
                                    i2 = i3;
                                }
                            }

                            ++l2;
                        }

                        if (i2 > 0)
                        {
                            for (l2 = -1; l2 <= 1; ++l2)
                            {
                                for (i3 = -1; i3 <= 1; ++i3)
                                {
                                    this.func_150525_a(w, k3 + l2, i2 + 1, l1 + i3);
                                }
                            }

                            for (l2 = -2; l2 <= 2; ++l2)
                            {
                                for (i3 = -2; i3 <= 2; ++i3)
                                {
                                    if (Math.abs(l2) != 2 || Math.abs(i3) != 2)
                                    {
                                        this.func_150525_a(w, k3 + l2, i2, l1 + i3);
                                    }
                                }
                            }
                        }
                    }

                    return true;
                }
                else
                {
                    return false;
                }
            }
        }
        else
        {
            return false;
        }
    }

    private void func_150525_a(World p_150525_1_, int p_150525_2_, int p_150525_3_, int p_150525_4_)
    {
        Block block = p_150525_1_.getBlock(p_150525_2_, p_150525_3_, p_150525_4_);

        if (block.isAir(p_150525_1_, p_150525_2_, p_150525_3_, p_150525_4_) || block.isLeaves(p_150525_1_, p_150525_2_, p_150525_3_, p_150525_4_))
        {
            this.setBlockAndNotifyAdequately(p_150525_1_, p_150525_2_, p_150525_3_, p_150525_4_, BlockRegister.LEAVES, 1);
        }
    }
}