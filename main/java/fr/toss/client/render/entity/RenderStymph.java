package fr.toss.client.render.entity;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fr.toss.common.entity.EntityStymph;

@SideOnly(Side.CLIENT)
public class RenderStymph extends RenderLiving
{
    private static final ResourceLocation texture1 = new ResourceLocation("magiccrusade:textures/entity/stymph/stymph.png");
    private static final ResourceLocation texture2 = new ResourceLocation("magiccrusade:textures/entity/stymph/stymph_golden.png");
    private static final ResourceLocation texture3 = new ResourceLocation("magiccrusade:textures/entity/stymph/stymph_bronze.png");

    
    public RenderStymph(ModelBase p_i1253_1_, float p_i1253_2_)
    {
        super(p_i1253_1_, p_i1253_2_);
    }

    /**
     * Returns the location of an entity's texture. Doesn't seem to be called unless you call Render.bindEntityTexture.
     */
    protected ResourceLocation getEntityTexture(Entity p_110775_1_)
    {
        return this.getEntityTexture((EntityStymph)p_110775_1_);
    }
    
    
    protected ResourceLocation getEntityTexture(EntityStymph entity)
    {
    	switch (entity.getTameSkin())
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