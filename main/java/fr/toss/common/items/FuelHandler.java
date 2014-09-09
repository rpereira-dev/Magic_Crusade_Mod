package fr.toss.common.items;

import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.IFuelHandler;
import fr.toss.common.register.ItemRegister;

public class FuelHandler implements IFuelHandler {
	@Override
	public int getBurnTime(ItemStack fuel)
	{		
		if(fuel.getItem() == ItemRegister.COMBUSTIUM)
			return (1600 * 2);
		else
			return 0;
	}
}