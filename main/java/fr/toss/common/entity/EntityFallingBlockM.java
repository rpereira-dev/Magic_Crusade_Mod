package fr.toss.common.entity;

import net.minecraft.block.Block;
import net.minecraft.entity.item.EntityFallingBlock;
import net.minecraft.world.World;

public class EntityFallingBlockM extends EntityFallingBlock {
	
	int life_time;

	public EntityFallingBlockM(World w) {
		super(w);
		this.life_time = 0;
	}

	public EntityFallingBlockM(World world, int x, int y, int z, Block block)
	{
		super(world, x, y, z, block);
	}

	@Override
	public void	onUpdate()
	{
		super.onUpdate();
		if (this.life_time > 2000 || this.onGround)
			this.setDead();
		else
			life_time += 20;
	}
}
