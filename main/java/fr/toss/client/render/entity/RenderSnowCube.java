package fr.toss.client.render.entity;

import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fr.toss.client.model.entity.ModelSnowCube;
import fr.toss.common.entity.EntitySnowCube;

@SideOnly(Side.CLIENT)
public class RenderSnowCube extends RenderLiving
{
    private static final ResourceLocation cube_texture = new ResourceLocation("magiccrusade:textures/entity/snow_cube.png");

    public RenderSnowCube()
    {
        super(new ModelSnowCube(), 0.5F);
    }

    /**
     * Returns the location of an entity's texture. Doesn't seem to be called unless you call Render.bindEntityTexture.
     */
    protected ResourceLocation getEntityTexture(EntitySnowCube p_110775_1_)
    {
        return cube_texture;
    }

    /**
     * Returns the location of an entity's texture. Doesn't seem to be called unless you call Render.bindEntityTexture.
     */
    protected ResourceLocation getEntityTexture(Entity p_110775_1_)
    {
        return this.getEntityTexture((EntitySnowCube)p_110775_1_);
    }
}