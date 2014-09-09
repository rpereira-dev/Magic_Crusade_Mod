package fr.toss.common.blocks;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

public class BlockPlankDim extends Block
{
	private static final String[] woodTypes = new String[] {"plank_bleu", "plank_sky"};
	private IIcon[] textures;

	public BlockPlankDim()
	{
		super(Material.wood);
		
		this.setHardness(2.0F);
		this.setHarvestLevel("axe", 0);
		this.setStepSound(Block.soundTypeWood);
		this.setBlockName("planks");
	}

	@Override
	public void registerBlockIcons(IIconRegister iconRegister)
	{
		textures = new IIcon[woodTypes.length];

		for (int i = 0; i < woodTypes.length; ++i) 
		{
			textures[i] = iconRegister.registerIcon("magiccrusade:" + woodTypes[i]);
		}
	}

	@Override
	public IIcon getIcon(int side, int meta)
	{
		if (meta < 0 || meta >= textures.length) 
		{
			meta = 0;
		}

		return textures[meta];
	}

	@Override
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void getSubBlocks(Item block, CreativeTabs creativeTabs, List list) 
	{
		for (int i = 0; i < woodTypes.length; ++i) 
		{
			list.add(new ItemStack(block, 1, i));
		}
	}

	@Override
	public int damageDropped(int meta)
	{
		return meta;
	}
}
