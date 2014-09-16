package fr.toss.client.render.entity;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.boss.BossStatus;
import net.minecraft.util.ResourceLocation;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fr.toss.common.entity.EntityBossOrc;

@SideOnly(Side.CLIENT)
public class RenderBossOrc extends RenderLiving
{
    private static final ResourceLocation texture1 = new ResourceLocation("magiccrusade:textures/entity/roi_orc.png");

    
    public RenderBossOrc(ModelBase model, float size)
    {
        super(model, size);
    }

    /**
     * Returns the location of an entity's texture. Doesn't seem to be called unless you call Render.bindEntityTexture.
     */
    protected ResourceLocation getEntityTexture(Entity e)
    {
        return this.getEntityTexture((EntityBossOrc)e);
    }
    
    
    protected ResourceLocation getEntityTexture(EntityBossOrc entity)
    {
    	return texture1;
    }

    @Override
    public void doRender(EntityLiving e, double x, double y, double z, float rotationYaw, float rotationPitch)
    {
        BossStatus.setBossStatus((EntityBossOrc) e, true);
    	super.doRender(e, x, y, z, rotationYaw, rotationPitch);
    }
        
}