package fr.toss.client.gui;

import java.util.Random;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ChatComponentText;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

import cpw.mods.fml.client.config.GuiUtils;
import fr.toss.common.Main;
import fr.toss.common.command.ChatColor;
import fr.toss.common.packet.PacketSetClasse;
import fr.toss.common.packet.Packets;

public class GuiClasseInformation extends GuiScreen {
	
	private String description[];
	private String advices[];
	private String classe;
	private int x;
	private int y;
	private int color;
	private int classe_id;

	public GuiClasseInformation(String classe_name, String p_description[], String p_advices[], int px, int py, int p_color, int classe_id)
	{
		super();
		this.description = p_description;
		this.advices = p_advices;
		this.classe = classe_name;
		this.x = px;
		this.y = py;
		this.color = p_color;
		this.classe_id = classe_id;
	}

	@Override
	public void initGui()
	{
		this.buttonList.add(new GuiButton(42, this.width / 2 - 40, 34, 80, 20, I18n.format("button.selection")));
		this.buttonList.add(new GuiButton(43, 10, this.height - 30, 120, 20, ChatColor.RESET + I18n.format("button.back_selection")));
	}


    /**
     * Draws the screen and all the components in it.
     */
    @Override
    public void drawScreen(int x, int y, float dunno)
    {
    	int i = 0;
   
        this.drawGradientRect(0, 0, this.width, this.height, this.color, this.color - 200000000);
    	this.drawCenteredString(this.fontRendererObj, this.classe + ChatColor.RESET, this.width / 2, 14, Integer.MAX_VALUE);

	    drawEntity(this.width / 2, this.height / 2, 28, 0, 0, this.mc.thePlayer);

    	for (String str : this.description)
    	{
    		this.drawCenteredString(this.fontRendererObj, str + ChatColor.RESET, this.width / 2, this.height / 2 + (i + 1) * 16, Integer.MAX_VALUE);
    		i++;
    	}
    	
		this.drawString(this.fontRendererObj, ChatColor.UNDERLINE + "Advices:", this.width / 4 * 3 + 10, 28, Integer.MAX_VALUE);
    	i = 0;
		for (String str : this.advices)
    	{
			this.drawString(this.fontRendererObj, str + ChatColor.RESET, this.width / 4 * 3 + 10, 46 + i * 14, Integer.MAX_VALUE);
    		i++;
    	}
		
    	this.mc.renderEngine.bindTexture(GuiSelectClass.CLASSES);
    	GuiUtils.drawTexturedModalRect(20, 14, this.x * 52, this.y * 52, 52, 52, 0);

    	super.drawScreen(x, y, dunno);
    }
    
    /**
     * Called from the main game loop to update the screen.
     */
    @Override
    public void updateScreen() 
    {
    	super.updateScreen();
    }
    
    @Override
    public boolean doesGuiPauseGame()
    {
        return false;
    }
    
    @Override
    protected void actionPerformed(GuiButton b)
    {
    	if (b.id == 42)
    	{
    		PacketSetClasse packet;
    		
    		packet = new PacketSetClasse(this.classe_id);
    		Packets.network.sendToServer(packet);
    		try {
				Main.getPlayerClient().init(this.classe_id);
			} catch (Exception e) {}
    		
    		
			Random rand = this.mc.theWorld.rand;

    		for (int i = 0; i < 200; i++)
    		{
    			float velX = rand.nextFloat();
    	    	if (rand.nextInt(2) == 0)
    	    		velX *= -1;
    	    	float velZ = rand.nextFloat();
    	    	if (rand.nextInt(2) == 0)
    	    		velZ *= -1;
    	    	this.mc.theWorld.spawnParticle("fireworksSpark", this.mc.thePlayer.posX, this.mc.thePlayer.posY - 1, this.mc.thePlayer.posZ, velX, rand.nextFloat(), velZ);
    	    	this.mc.displayGuiScreen(null);
    		}
	    	Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText("You can press " + ChatColor.RED + "P" + ChatColor.RESET + " on your keyboard to see more informations about " + classe + ChatColor.RESET + " and it spells."));
	    	Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText("Don't forget to configure your controls!"));

    	}
    	else if (b.id == 43)
    	{
    		GuiSelectClass gui;
    		
    		gui = new GuiSelectClass();
    		this.mc.displayGuiScreen(gui);
    	}
    }
    
    public static void drawEntity(int p_147046_0_, int p_147046_1_, int p_147046_2_, float p_147046_3_, float p_147046_4_, EntityLivingBase entity)
    {
        GL11.glEnable(GL11.GL_COLOR_MATERIAL);
        GL11.glPushMatrix();
        GL11.glTranslatef((float)p_147046_0_, (float)p_147046_1_, 50.0F);
        GL11.glScalef((float)(-p_147046_2_), (float)p_147046_2_, (float)p_147046_2_);
        GL11.glRotatef(180.0F, 0.0F, 0.0F, 1.0F);
        float f2 = entity.renderYawOffset;
        float f3 = entity.rotationYaw;
        float f4 = entity.rotationPitch;
        float f5 = entity.prevRotationYawHead;
        float f6 = entity.rotationYawHead;
        GL11.glRotatef(135.0F, 0.0F, 1.0F, 0.0F);
        RenderHelper.enableStandardItemLighting();
        GL11.glRotatef(-135.0F, 0.0F, 1.0F, 0.0F);
        GL11.glRotatef(-((float)Math.atan((double)(p_147046_4_ / 40.0F))) * 20.0F, 1.0F, 0.0F, 0.0F);
        entity.renderYawOffset = (float)Math.atan((double)(p_147046_3_ / 40.0F)) * 20.0F;
        entity.rotationYaw = (float)Math.atan((double)(p_147046_3_ / 40.0F)) * 40.0F;
        entity.rotationPitch = -((float)Math.atan((double)(p_147046_4_ / 40.0F))) * 20.0F;
        entity.rotationYawHead = entity.rotationYaw;
        entity.prevRotationYawHead = entity.rotationYaw;
        GL11.glTranslatef(0.0F, entity.yOffset, 0.0F);
        RenderManager.instance.playerViewY = 180.0F;
        RenderManager.instance.renderEntityWithPosYaw(entity, 0.0D, 0.0D, 0.0D, 0.0F, 1.0F);
        entity.renderYawOffset = f2;
        entity.rotationYaw = f3;
        entity.rotationPitch = f4;
        entity.prevRotationYawHead = f5;
        entity.rotationYawHead = f6;
        GL11.glPopMatrix();
        RenderHelper.disableStandardItemLighting();
        GL11.glDisable(GL12.GL_RESCALE_NORMAL);
        OpenGlHelper.setActiveTexture(OpenGlHelper.lightmapTexUnit);
        GL11.glDisable(GL11.GL_TEXTURE_2D);
        OpenGlHelper.setActiveTexture(OpenGlHelper.defaultTexUnit);
    }

}
