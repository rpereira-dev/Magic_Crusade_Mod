package fr.toss.client.render.entity;

import net.minecraft.client.model.ModelGhast;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fr.toss.common.entity.EntityGhastFrozen;

@SideOnly(Side.CLIENT)
public class RenderGhastFrozen extends RenderLiving
{
    private static final ResourceLocation ghastTextures = new ResourceLocation("magiccrusade:textures/entity/ghast/ghast.png");
    private static final ResourceLocation ghastShootingTextures = new ResourceLocation("magiccrusade:textures/entity/ghast/ghast_shooting.png");

    public RenderGhastFrozen()
    {
        super(new ModelGhast(), 0.5F);
    }
 
    /**
     * Returns the location of an entity's texture. Doesn't seem to be called unless you call Render.bindEntityTexture.
     */
    protected ResourceLocation getEntityTexture(EntityGhastFrozen p_110775_1_)
    {
        return p_110775_1_.func_110182_bF() ? ghastShootingTextures : ghastTextures;
    }

    /**
     * Allows the render to do any OpenGL state modifications necessary before the model is rendered. Args:
     * entityLiving, partialTickTime
     */
    protected void preRenderCallback(EntityGhastFrozen p_77041_1_, float p_77041_2_)
    {
        float f1 = ((float)p_77041_1_.prevAttackCounter + (float)(p_77041_1_.attackCounter - p_77041_1_.prevAttackCounter) * p_77041_2_) / 20.0F;

        if (f1 < 0.0F)
        {
            f1 = 0.0F;
        }

        f1 = 1.0F / (f1 * f1 * f1 * f1 * f1 * 2.0F + 1.0F);
        float f2 = (8.0F + f1) / 2.0F;
        float f3 = (8.0F + 1.0F / f1) / 2.0F;
        GL11.glScalef(f3, f2, f3);
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
    }

    /**
     * Allows the render to do any OpenGL state modifications necessary before the model is rendered. Args:
     * entityLiving, partialTickTime
     */
    protected void preRenderCallback(EntityLivingBase p_77041_1_, float p_77041_2_)
    {
        this.preRenderCallback((EntityGhastFrozen)p_77041_1_, p_77041_2_);
    }

    /**
     * Returns the location of an entity's texture. Doesn't seem to be called unless you call Render.bindEntityTexture.
     */
    protected ResourceLocation getEntityTexture(Entity p_110775_1_)
    {
        return this.getEntityTexture((EntityGhastFrozen)p_110775_1_);
    }
}