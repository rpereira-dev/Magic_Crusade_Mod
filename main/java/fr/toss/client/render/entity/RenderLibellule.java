package fr.toss.client.render.entity;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fr.toss.common.entity.EntityLibellule;
import fr.toss.common.entity.EntityStymph;

@SideOnly(Side.CLIENT)
public class RenderLibellule extends RenderLiving
{
    private static final ResourceLocation texture1 = new ResourceLocation("magiccrusade:textures/entity/libellule1.png");
    private static final ResourceLocation texture2 = new ResourceLocation("magiccrusade:textures/entity/libellule2.png");

    
    public RenderLibellule(ModelBase model, float f)
    {
        super(model, f);
    }

    /**
     * Returns the location of an entity's texture. Doesn't seem to be called unless you call Render.bindEntityTexture.
     */
    protected ResourceLocation getEntityTexture(Entity e)
    {
        return this.getEntityTexture((EntityLibellule)e);
    }
    
    
    protected ResourceLocation getEntityTexture(EntityLibellule entity)
    {
    	switch (entity.type)
    	{
    		case 0 :
        		return texture1;
        		
    		case 1 :
        		return texture2;
    	}
    	return (null);
    }
}