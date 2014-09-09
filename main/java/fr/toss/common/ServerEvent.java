package fr.toss.common;

import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.network.play.server.S0BPacketAnimation;
import net.minecraft.util.DamageSource;
import net.minecraft.world.WorldServer;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.event.entity.player.AttackEntityEvent;
import net.minecraftforge.event.entity.player.PlayerSleepInBedEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent;
import cpw.mods.fml.common.gameevent.TickEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fr.toss.common.items.ItemArmorM;
import fr.toss.common.items.ItemSwordM;
import fr.toss.common.packet.PacketLogIn;
import fr.toss.common.packet.Packets;
import fr.toss.common.player.ClientPlayerBaseMagic;
import fr.toss.common.player.ServerPlayerBaseMagic;
import fr.toss.common.player.classes.ClasseChampion;
import fr.toss.common.register.AchievementList;
import fr.toss.common.register.ItemRegister;

public class ServerEvent {
	 
	@SubscribeEvent
    public void onChangedDimension(PlayerEvent.PlayerChangedDimensionEvent event)
    {
        if (event.toDim == Main.DIM_ID)
        {
        	//achievement
        }
    }
	
	@SideOnly(Side.CLIENT)
	@SubscribeEvent
    public void onAttackClient(AttackEntityEvent event)
	{
		ClientPlayerBaseMagic p;
		
		p = Main.getPlayerClient();
		if (p.getClasse() instanceof ClasseChampion)
		{
			p.increase_energy(40 + p.getPlayer().worldObj.rand.nextInt(40));
			p.last_hit = System.currentTimeMillis();
		}
	}
	
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
    public void onAttack(AttackEntityEvent event)
	{
		WorldServer world;
		ServerPlayerBaseMagic pm;
		Item item;
		float damages;
		float strength;
		float agility;
		
		pm = Main.getPlayerServer(event.entityPlayer);
		damages = 0;
		strength = 0;
		agility = 0;
		
		if (pm != null)
		{
			world = pm.getPlayer().getServerForPlayer();
			
			for (int i = 0; i < 4; i++)
			{
				if (pm.getPlayer().inventory.armorInventory[i] != null)
				{
					item = pm.getPlayer().inventory.armorInventory[i].getItem();
					if (item != null && item instanceof ItemArmorM)
					{
						strength += ((ItemArmorM)item).strength;
						agility += ((ItemArmorM)item).agility;
					}
				}
			}
			
			if (pm.getPlayer().inventory.getCurrentItem() != null)
			{
				if (pm.getPlayer().inventory.getCurrentItem().getItem() instanceof ItemSwordM)
				{
					item = pm.getPlayer().inventory.getCurrentItem().getItem();
					strength += ((ItemSwordM)item).strength;
					agility += ((ItemSwordM)item).agility;
				}
			}
			
			damages += (strength / 20.0f);  //20 points d'attaque = 1 coeur

			if (agility / 2 > world.rand.nextInt(100) && !event.entityLiving.isDead) // 1 point agility = 0.5% crit
			{
				damages += ((float)pm.getPlayer().getEntityAttribute(SharedMonsterAttributes.attackDamage).getAttributeValue() * 0.5f);
				world.getEntityTracker().func_151248_b(pm.getPlayer(), new S0BPacketAnimation(event.target, 4));
			}
			event.target.attackEntityFrom(DamageSource.causePlayerDamage(pm.getPlayer()), damages);
		}
		System.out.println(damages);

	}
	
	
	@SubscribeEvent
    public void onSleep(PlayerSleepInBedEvent event)
	{
		ClientPlayerBaseMagic p;
		ServerPlayerBaseMagic pm;
		
		pm = Main.getPlayerServer(event.entityPlayer);
		
		if (pm != null)
		{
			 if (pm.getPlayer().worldObj.rand.nextInt(10) == 0)
				 pm.travelToDimension(pm.getPlayer());
		}			 
    }
	
	@SubscribeEvent
    public void onCraft(PlayerEvent.ItemCraftedEvent event)
    {
		Item item = event.crafting.getItem();
		
		if (item == ItemRegister.BLUE_STICK)
			event.player.triggerAchievement(AchievementList.NEW_ITEMS);
		else if (item == ItemRegister.TITANIUM_CHESTPLATE || item == ItemRegister.TITANIUM_BOOTS || item == ItemRegister.TITANIUM_PANTS ||item == ItemRegister.TITANIUM_HELMET)
			event.player.triggerAchievement(AchievementList.TITANIUM_STUFF);
		else if (item == ItemRegister.SILVER_PICKAXE)
			event.player.triggerAchievement(AchievementList.SILVER_PICKAXE);
		else if (item == ItemRegister.ETHERNIUM_SWORD)
			event.player.triggerAchievement(AchievementList.ETHERNIUM_SWORD);}

	@SubscribeEvent
    public void onItemPickup(PlayerEvent.ItemPickupEvent event)
    {
		Item item;
		
		item = event.pickedUp.getEntityItem().getItem();

		if (item == ItemRegister.STAFF_BUMPING || item == ItemRegister.STAFF_ELFIC || item == ItemRegister.STAFF_LIGHTNING)
			event.player.triggerAchievement(AchievementList.MAGIC_STAFF);
		else if (item == ItemRegister.SULFURAS)
			event.player.triggerAchievement(AchievementList.SULFURAS);

    }

	@SubscribeEvent
    public void onPlayerRespawn(PlayerEvent.PlayerRespawnEvent event)
    {
		ServerPlayerBaseMagic player;

		player = Main.getPlayerServer((EntityPlayerMP) event.player);
		player.onRespawn();
    }
	
	
	@SubscribeEvent
    public void onPlayerChangedDimension(PlayerEvent.PlayerChangedDimensionEvent event)
    {
		ServerPlayerBaseMagic player;
		PacketLogIn packet;

		player = Main.getPlayerServer((EntityPlayerMP) event.player);
	    player.getPlayer().getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(20.0d + (player.getLevel() - 1) * 0.5d);
		packet = new PacketLogIn(player);
		Packets.network.sendTo(packet, player.getPlayer());
		
		if (event.toDim == Main.DIM_ID)
			event.player.triggerAchievement(AchievementList.NEW_DIMENSION);
    }
	
	@SubscribeEvent
    public void onPlayerLog(PlayerEvent.PlayerLoggedInEvent event)
    {
		ServerPlayerBaseMagic player;
		PacketLogIn packet;

		player = Main.getPlayerServer((EntityPlayerMP) event.player);
		packet = new PacketLogIn(player);
		Packets.network.sendTo(packet, player.getPlayer());
    }
	
	@SubscribeEvent
	public void onWorldTick(TickEvent.WorldTickEvent event) {}
	
	@SubscribeEvent
	public void onTickServer(TickEvent.ServerTickEvent event) {}
}
