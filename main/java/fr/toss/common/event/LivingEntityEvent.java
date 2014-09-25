package fr.toss.common.event;

import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EntityDamageSource;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import fr.toss.common.entity.EntityBossOrc;
import fr.toss.common.entity.EntityMageOrc;
import fr.toss.common.entity.EntityOrc;
import fr.toss.common.register.AchievementList;
import fr.toss.common.register.ItemRegister;

public class LivingEntityEvent {

	
	@SubscribeEvent
    public void onEntityDrops(LivingDropsEvent event)
	{
		int alea;
		
		if (event.entityLiving instanceof EntityMob)
			alea = 20;
		else
			alea = 50;
		
		if (event.entityLiving.worldObj.rand.nextInt(alea) < 1 + event.lootingLevel * 2)
		{
			EntityItem e;
			
			e = new EntityItem(event.entityLiving.worldObj, event.entityLiving.posX, event.entityLiving.posY, event.entityLiving.posZ, new ItemStack(ItemRegister.getRandomArmor(), 1));
			event.drops.add(e);
		}
	}

	@SubscribeEvent
    public void onEntityKillByPlayer(LivingDeathEvent event)
	{
		if (event.source.getDamageType().equals("player"))
		{
			if (event.entityLiving instanceof EntityOrc || event.entityLiving instanceof EntityMageOrc)
				((EntityPlayer)((EntityDamageSource)event.source).getEntity()).triggerAchievement(AchievementList.ORC_SLAYER);
			else if (event.entityLiving instanceof EntityBossOrc)
				((EntityPlayer)((EntityDamageSource)event.source).getEntity()).triggerAchievement(AchievementList.ORC_BOSS);
		
		}
	}
}
