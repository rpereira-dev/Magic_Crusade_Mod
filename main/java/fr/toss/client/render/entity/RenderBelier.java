package fr.toss.client.render.entity;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fr.toss.common.entity.EntityBelier;

@SideOnly(Side.CLIENT)
public class RenderBelier extends RenderLiving
{
    private static final ResourceLocation texture1 = new ResourceLocation("magiccrusade:textures/entity/belier.png");
    private static final ResourceLocation texture2 = new ResourceLocation("magiccrusade:textures/entity/belier_golden.png");
    private static final ResourceLocation texture3 = new ResourceLocation("magiccrusade:textures/entity/belier_green.png");

    
    public RenderBelier(ModelBase model, float f)
    {
        super(model, f);
    }

    /**
     * Returns the location of an entity's texture. Doesn't seem to be called unless you call Render.bindEntityTexture.
     */
    protected ResourceLocation getEntityTexture(Entity e)
    {
        return this.getEntityTexture((EntityBelier)e);
    }
    
    
    protected ResourceLocation getEntityTexture(EntityBelier entity)
    {
    	switch (entity.type)
    	{
    		case 0 :
        		return texture1;
        		
    		case 1 :
        		return texture2;
        		
       		case 2 :
        		return texture3;
    	}
    	return (null);
    }
}