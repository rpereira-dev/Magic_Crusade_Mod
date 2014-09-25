package fr.toss.client.event;

import java.util.Random;

import net.minecraft.client.Minecraft;
import net.minecraft.client.audio.ISound;
import net.minecraft.client.audio.PositionedSoundRecord;
import net.minecraft.client.audio.SoundCategory;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.sound.PlaySoundEvent17;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fr.toss.common.Main;

public class SoundEventM {
	
	static Minecraft mc = Minecraft.getMinecraft();
	public static final ISound LUAN_HONG = PositionedSoundRecord.func_147673_a(new ResourceLocation("magiccrusade:luan_hong"));
	public static final ISound FLUTE = PositionedSoundRecord.func_147673_a(new ResourceLocation("magiccrusade:flute"));
	public static final ISound BRUITAGE_DAY = PositionedSoundRecord.func_147673_a(new ResourceLocation("magiccrusade:bruitage_day"));
	public static final ISound BRUITAGE_NIGHT = PositionedSoundRecord.func_147673_a(new ResourceLocation("magiccrusade:bruitage_nuit"));

	@SubscribeEvent
	@SideOnly(Side.CLIENT)
	public void onSoundPlay(PlaySoundEvent17 event)
	{
		if (this.mc.thePlayer != null && mc.thePlayer.dimension == Main.DIM_ID && event.category == SoundCategory.MUSIC)
			event.manager.setSoundCategoryVolume(SoundCategory.MUSIC, 0);
	}
	
	
	public static void update_sound(boolean is_day, Random rand)
	{
		if (System.currentTimeMillis() % (1000 * 60 * 5) < 5000) // 5 minutes
		{
			if (!mc.getSoundHandler().isSoundPlaying(FLUTE) || !mc.getSoundHandler().isSoundPlaying(LUAN_HONG))
			{
				mc.getSoundHandler().stopSounds();
				
				if (rand.nextInt(2) == 0)
					mc.getSoundHandler().playSound(LUAN_HONG);
				else
					mc.getSoundHandler().playSound(FLUTE);
			}
		}
		else if (System.currentTimeMillis() % (1000 * 15) < 1000)
		{
			if (rand.nextInt(4) == 0 && !mc.getSoundHandler().isSoundPlaying(BRUITAGE_DAY) && !mc.getSoundHandler().isSoundPlaying(BRUITAGE_NIGHT))
			{
				Main.log("Playing bruitage sounds.");
				if (is_day)
					mc.getSoundHandler().playSound(BRUITAGE_DAY);
				else
					mc.getSoundHandler().playSound(BRUITAGE_NIGHT);

			}
		}
	}
}
