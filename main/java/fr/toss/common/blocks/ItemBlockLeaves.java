package fr.toss.common.blocks;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemBlockLeaves extends ItemBlock
{
	public ItemBlockLeaves(Block block)
	{
		super(block);
		
		this.setMaxDamage(0);
		this.setHasSubtypes(true);
	}

	@Override
	public int getMetadata(int meta)
	{
		return meta | 4;
	}

	@Override
	public String getUnlocalizedName(ItemStack itemStack)
	{
		BlockLeavesDim block = (BlockLeavesDim)field_150939_a;
		return super.getUnlocalizedName() + "." + block.getLeafType(itemStack.getItemDamage());
	}
}
