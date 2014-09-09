package fr.toss.common.blocks;

import java.util.Random;

import net.minecraft.block.BlockOre;
import net.minecraft.item.Item;
import fr.toss.common.register.BlockRegister;
import fr.toss.common.register.ItemRegister;

public class BlockOreMagic extends BlockOre {
	
	public BlockOreMagic()
	{
		super();
	}
	
    public Item getItemDropped(int p_149650_1_, Random p_149650_2_, int p_149650_3_)
    {
        return this == BlockRegister.ORE_COMBUSTIUM ? ItemRegister.COMBUSTIUM : Item.getItemFromBlock(this);
    }
}
