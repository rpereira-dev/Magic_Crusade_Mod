package fr.toss.common.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockFalling;
import net.minecraft.block.material.Material;

public class BlockStoneFalling extends BlockFalling {
	
	public BlockStoneFalling()
	{
		super(Material.rock);
		this.setHardness(1.5f);
		this.setStepSound(Block.soundTypeStone);
		this.setBlockName("stone");
		this.setBlockTextureName("stone");
	}
}
