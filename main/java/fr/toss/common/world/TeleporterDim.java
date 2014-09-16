package fr.toss.common.world;

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
import fr.toss.common.command.ChatColor;
import fr.toss.common.register.BlockRegister;

public class TeleporterDim extends Teleporter
{
    private final WorldServer worldServerInstance;
    /** A private Random() function in Teleporter */
    private final Random random;
    /** Stores successful portal placement locations for rapid lookup. */
    private final LongHashMap destinationCoordinateCache = new LongHashMap();
    /**
     * A list of valid keys for the destinationCoordainteCache. These are based on the X & Z of the players initial
     * location.
     */
    private final List destinationCoordinateKeys = new ArrayList();

    public TeleporterDim(WorldServer ws)
    {
        super(ws);
        this.worldServerInstance = ws;
        this.random = new Random(ws.getSeed());
    }

    /**
     * Place an entity in a nearby portal, creating one if necessary.
     */
    public void placeInPortal(Entity entity, double x, double y, double z, float p_77185_8_)
    {
        int i = MathHelper.floor_double(entity.posX);
        int j = MathHelper.floor_double(entity.posY) - 1;
        int k = MathHelper.floor_double(entity.posZ);
        byte b0 = 1;
        byte b1 = 0;

        for (int l = -2; l <= 2; ++l)
        {
            for (int i1 = -2; i1 <= 2; ++i1)
            {
                for (int j1 = -1; j1 < 3; ++j1)
                {
                    int k1 = i + i1 * b0 + l * b1;
                    int i2 = k + i1 * b1 - l * b0;
                    if (j1 <= 0)
                    	j1 = 2;
                    this.worldServerInstance.setBlock(k1, j, i2, BlockRegister.LEAVES);
                }
            }
        }
        entity.setLocationAndAngles((double)i, (double)j + 4, (double)k, entity.rotationYaw, 0.0F);
        entity.motionX = entity.motionY = entity.motionZ = 0.0D;
        
        
        
        
        this.worldServerInstance.setBlock((int) x, (int) y, (int) z, Blocks.chest);
        TileEntityChest chest = (TileEntityChest) this.worldServerInstance.getTileEntity((int) x, (int) y, (int) z);
		ItemStack book;
	    NBTTagList bookPages;
	    
		book = new ItemStack(Items.writable_book, 1);
		bookPages = new NBTTagList();
        book.setTagInfo("author", new NBTTagString("Kargath"));
        book.setTagInfo("title", new NBTTagString("Lord of Sorrow"));
        
        bookPages.appendTag(new NBTTagString(
        			ChatColor.UNDERLINE + "Lord of Sorrow" + ChatColor.RESET
        			+ " \n"
        			+ "by Kargath"
        			+ "\n\n"
        			+ "Grief. Pain. Tears in the dark. Lives torn appart ... "
        			+ "That is what He brought with his arrival on Earth. The Lord of Sorrow ..."));

        bookPages.appendTag(new NBTTagString(
        		"Some say He killed the ancient gods. Some say He was killed ... I don't believe that."
        		+ " I don't think He was human enough to be killed ... Neither living nor dead, "
        		+ "He lurks in the dark, He bides his time, waiting for the right moment to reveal "
        		+ " Himself to the world ..."));
        
        bookPages.appendTag(new NBTTagString(
        		"The Lord of Sorrow destroyed the Mystic Groves. He torn apart the land, "
        		+ "opening gaping rifts in the ground. His dark magic corrupted the soil "
        		+ "and the animals mutated into fouls creatures, craving for blood and flesh."
        		+ " \nHe destroyed towns and camps, reducing humans to slaves."
        		));
        
        bookPages.appendTag(new NBTTagString(
	        "This was fifty years ago. Before the Fall of the Lord of Sorrow."
        		+ "The god who created the Mystic Groves couldn't fight the Lord of Sorrow himself."
        		+ " So he created a Champion. \nA Champion of the Holy Light, who could destroy the Evil."
        		));
        
        bookPages.appendTag(new NBTTagString(
        			"But the Evil Lord heard about this Champion. He then raised in secret a small"
        			+ " groups of Dark Knights, who were told to assassinate the Champion. But they"
        			+ " came too late and the battle between both camps had ended. "
        			+ "\nLord of Sorrow was defeated."
        		));
        
        bookPages.appendTag(new NBTTagString(
        			"The Knights dispersed in the Mystic Groves, hiding themselves into shelters, "
        			+ "living miserables lives despite their huge power.\n\n"
    		));
        
        bookPages.appendTag(new NBTTagString(
        		"Progressively, the life came back into the Mystic Groves. Without the vile magic of the Lord of Sorrow, "
            	+ "animals, plants and humans started to flourish again. But it was no longer paradise ..."
        				
        		));
        book.func_150996_a(Items.written_book);
		book.getTagCompound().setTag("pages", bookPages);

		if (chest != null)
			chest.setInventorySlotContents(0, book);
		else
			this.worldServerInstance.spawnEntityInWorld(new EntityItem(worldServerInstance, x, y, z, book));

    }
}