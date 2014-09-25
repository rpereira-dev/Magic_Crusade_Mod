package fr.toss.common.event;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.Item;
import net.minecraft.network.play.server.S0BPacketAnimation;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.DamageSource;
import net.minecraft.world.WorldServer;
import net.minecraftforge.event.entity.player.AttackEntityEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.event.entity.player.PlayerSleepInBedEvent;
import net.minecraftforge.event.world.BlockEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fr.toss.common.Main;
import fr.toss.common.command.ChatColor;
import fr.toss.common.items.ItemArmorM;
import fr.toss.common.items.ItemSwordM;
import fr.toss.common.packet.PacketLogIn;
import fr.toss.common.packet.Packets;
import fr.toss.common.player.ClientPlayerBaseMagic;
import fr.toss.common.player.ServerPlayerBaseMagic;
import fr.toss.common.player.classes.ClasseChampion;
import fr.toss.common.register.AchievementList;
import fr.toss.common.register.ItemRegister;

public class JoueurEvent {
	
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
			event.player.triggerAchievement(AchievementList.ETHERNIUM_SWORD);
    }
	
	@SubscribeEvent
    public void onInteract(PlayerInteractEvent event)
    {
		if (Main.get_dungeon(event.world.provider.dimensionId) != null && event.action == event.action.RIGHT_CLICK_BLOCK)
		{
			event.entityPlayer.addChatComponentMessage(new ChatComponentText(ChatColor.RED + "You cannot place block in a dungeon." + ChatColor.RESET));
			event.setCanceled(true);
		}
    }
	
	@SubscribeEvent
    public void onPlayerBreakBlock(BlockEvent.BreakEvent event)
    {
		if (Main.get_dungeon(event.world.provider.dimensionId) != null)
		{
			event.setCanceled(true);
			event.getPlayer().addChatComponentMessage(new ChatComponentText(ChatColor.RED + "You cannot destroy block in dungeons."));
		}
    }
	
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
    public void onSleep(PlayerSleepInBedEvent event)
	{
		ServerPlayerBaseMagic pm;
		
		pm = Main.getPlayerServer(event.entityPlayer);
		
		if (pm != null)
		{
			 if (pm.getPlayer().worldObj.rand.nextInt(2) == 0)
				 pm.travelToDimension(Main.DIM_ID, pm.getPlayer().dimension);
		}			 
    }

	
	@SideOnly(Side.CLIENT)
	@SubscribeEvent
    public void onAttackClient(AttackEntityEvent event)
	{
		ClientPlayerBaseMagic p;
		
		p = Main.getPlayerClient();
		if (p.getClasse() instanceof ClasseChampion && !event.target.isDead)
		{
			p.increase_energy(40 + p.getPlayer().worldObj.rand.nextInt(40));
			p.last_hit = System.currentTimeMillis();
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

			if (pm.classe == 6) //Rogue
			{
				if (pm.getPlayer().getLookVec().xCoord - 0.5f <= event.target.getLookVec().xCoord
					&& event.target.getLookVec().xCoord <= pm.getPlayer().getLookVec().xCoord + 0.5f
					&& pm.getPlayer().getLookVec().zCoord - 0.5f <= event.target.getLookVec().zCoord
					&& event.target.getLookVec().zCoord <= pm.getPlayer().getLookVec().zCoord + 0.5f)
					agility *= 2;
				if (pm.is_poisonned && event.target instanceof EntityLivingBase)
					((EntityLivingBase) event.target).addPotionEffect(new PotionEffect(Potion.poison.id, 100, 0));
				pm.is_poisonned = false;
			}
			
			if (agility / 2 > world.rand.nextInt(100) && !event.entityLiving.isDead) // 1 point agility = 0.5% crit
			{
				damages += ((float)pm.getPlayer().getEntityAttribute(SharedMonsterAttributes.attackDamage).getAttributeValue() * 0.5f);
				world.getEntityTracker().func_151248_b(pm.getPlayer(), new S0BPacketAnimation(event.target, 4));
			}
			event.target.attackEntityFrom(DamageSource.causePlayerDamage(pm.getPlayer()), damages);
		}
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
		
		if (Main.get_dungeon(event.toDim) != null)
			Main.get_dungeon(event.toDim).onPlayerJoin(player);
		
		if (event.toDim == Main.DIM_ID)
			event.player.triggerAchievement(AchievementList.NEW_DIMENSION);
    }
}
