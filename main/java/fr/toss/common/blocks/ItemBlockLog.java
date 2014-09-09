package fr.toss.common.blocks;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemBlockLog extends ItemBlock
{
	public ItemBlockLog(Block block)
	{
		super(block);
		
		this.setMaxDamage(0);
		this.setHasSubtypes(true);
	}

	@Override
	public int getMetadata(int meta)
	{
		return meta & 3;
	}

	@Override
	public String getUnlocalizedName(ItemStack itemStack)
	{
		BlockLogDim block = (BlockLogDim)field_150939_a;
		return super.getUnlocalizedName() + "." + block.getWoodType(itemStack.getItemDamage()) + "Wood";
	}
}
