package fr.toss.client.render.entity;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fr.toss.common.entity.EntityMonsterZombie;

@SideOnly(Side.CLIENT)
public class RenderZombieMonster extends RenderLiving
{
    private static final ResourceLocation texture1 = new ResourceLocation("magiccrusade:textures/entity/zombie_monster.png");

    
    public RenderZombieMonster(ModelBase model, float size)
    {
        super(model, size);
    }

    /**
     * Returns the location of an entity's texture. Doesn't seem to be called unless you call Render.bindEntityTexture.
     */
    protected ResourceLocation getEntityTexture(Entity e)
    {
        return this.getEntityTexture((EntityMonsterZombie)e);
    }
    
    
    protected ResourceLocation getEntityTexture(EntityMonsterZombie entity)
    {
    	return texture1;
    }
}