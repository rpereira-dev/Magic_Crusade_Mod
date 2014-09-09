package fr.toss.client;

import net.minecraftforge.client.event.sound.SoundLoadEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class SoundHandler
{
	@SubscribeEvent
    public void onSoundLoad(SoundLoadEvent event) 
	{
//            event.manager.addSound("yourmod:YourSound.ogg");//refers to: yourmod/sound/YourSound.ogg
//            event.manager.addSound("yourmod:optionalFile/YourSound.ogg");
//            event.manager.addSound("yourmod:optionalFile/optionalFile2/YourSound.ogg");
    }
}