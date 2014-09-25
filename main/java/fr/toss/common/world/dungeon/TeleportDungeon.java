package fr.toss.common.world.dungeon;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.nbt.NBTTagString;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.util.LongHashMap;
import net.minecraft.util.MathHelper;
import net.minecraft.world.Teleporter;
import net.minecraft.world.WorldServer;
import fr.toss.common.Main;
import fr.toss.common.command.ChatColor;
import fr.toss.common.player.ServerPlayerBaseMagic;
import fr.toss.common.register.BlockRegister;

public class TeleportDungeon extends Teleporter
{
    ServerPlayerBaseMagic player;
    int to_dim;
	int from_dim;

    public TeleportDungeon(int dim, int from, ServerPlayerBaseMagic serverPlayerBaseMagic)
    {
        super(serverPlayerBaseMagic.getPlayer().mcServer.worldServerForDimension(dim));
        this.player = serverPlayerBaseMagic;
        this.to_dim = dim;
        this.from_dim = from;
    }

    /**
     * Place an entity in a nearby portal, creating one if necessary.
     */
    public void placeInPortal(Entity entity, double x, double y, double z, float p_77185_8_)
    {
    	if (this.from_dim == 0 || this.from_dim == Main.DIM_ID) //Si le joueur vient de l'overworld ou des mystic groves
    	{
    		Dungeon dungeon;
    		
    		dungeon = Main.get_dungeon(this.to_dim);
        	entity.setLocationAndAngles(dungeon.x, dungeon.y, dungeon.z, entity.rotationYaw, 0.0F);    	
    	}
    	else //sinon si le joueur est deja dans un donjon
    		entity.setLocationAndAngles(this.player.dungeon_location[0], this.player.dungeon_location[1], this.player.dungeon_location[2], entity.rotationYaw, 0.0F);
    	
    	entity.motionX = entity.motionY = entity.motionZ = 0.0D;
        
    	this.player.dungeon_location[0] = x;
    	this.player.dungeon_location[1] = y;
    	this.player.dungeon_location[2] = z;
    }
}