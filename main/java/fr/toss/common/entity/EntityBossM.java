package fr.toss.common.entity;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.entity.boss.IBossDisplayData;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.item.Item;
import net.minecraft.world.World;

public class EntityBossM extends EntityMob implements IBossDisplayData {
	
	public List<Item>	loots;
	public int			nb_loots;

	public EntityBossM(World w)
	{
		super(w);
		this.loots = new ArrayList<Item>();
	}
	
    protected Item getDropItem()
    {
    	Item item;
        for (int i = 0; i < nb_loots; i++)
        {
        	item = this.loots.get(this.worldObj.rand.nextInt(this.loots.size()));
        	this.dropItem(item, 1);
        	this.loots.remove(item);
        }
        
        return Item.getItemById(0);
    }
    
    public void set_loot(int nb, Item ... item)
    {
    	this.nb_loots = nb;
    	for (Item i : item)
    		loots.add(i);
    }

}
