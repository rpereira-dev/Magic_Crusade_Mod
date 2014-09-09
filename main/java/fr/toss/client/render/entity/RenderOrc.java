package fr.toss.client.render.entity;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.entity.RenderBiped;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fr.toss.common.entity.EntityOrc;

@SideOnly(Side.CLIENT)
public class RenderOrc extends RenderBiped
{
    private static final ResourceLocation texture1 = new ResourceLocation("magiccrusade:textures/entity/orc.png");

    
    public RenderOrc(ModelBiped model, float size)
    {
        super(model, size);
    }
    

    /**
     * Returns the location of an entity's texture. Doesn't seem to be called unless you call Render.bindEntityTexture.
     */
    protected ResourceLocation getEntityTexture(Entity e)
    {
        return this.getEntityTexture((EntityOrc)e);
    }
    
    
    protected ResourceLocation getEntityTexture(EntityOrc entity)
    {
    	return texture1;
    }
}