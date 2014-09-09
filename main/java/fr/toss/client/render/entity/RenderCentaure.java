package fr.toss.client.render.entity;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fr.toss.common.entity.EntityCentaure;

@SideOnly(Side.CLIENT)
public class RenderCentaure extends RenderLiving
{
    private static final ResourceLocation texture1 = new ResourceLocation("magiccrusade:textures/entity/centaure.png");

    
    public RenderCentaure(ModelBase model, float size)
    {
        super(model, size);
    }

    /**
     * Returns the location of an entity's texture. Doesn't seem to be called unless you call Render.bindEntityTexture.
     */
    protected ResourceLocation getEntityTexture(Entity e)
    {
        return this.getEntityTexture((EntityCentaure)e);
    }
    
    
    protected ResourceLocation getEntityTexture(EntityCentaure entity)
    {
    	return texture1;
    }
}