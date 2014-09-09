package fr.toss.client.render.entity;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.entity.RenderBiped;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fr.toss.client.model.entity.ModelZombieSummon;
import fr.toss.common.entity.EntitySummonZombie;

@SideOnly(Side.CLIENT)
public class RenderSummonZombie extends RenderBiped
{
    private static final ResourceLocation texture1 = new ResourceLocation("magiccrusade:textures/entity/zombie/zombie1.png");
    private static final ResourceLocation texture2 = new ResourceLocation("magiccrusade:textures/entity/zombie/zombie2.png");
    private static final ResourceLocation texture3 = new ResourceLocation("magiccrusade:textures/entity/zombie/zombie3.png");
    private static final ResourceLocation texture4 = new ResourceLocation("magiccrusade:textures/entity/zombie/zombie4.png");

    private ModelBiped model;
    
    public RenderSummonZombie()
    {
        super(new ModelZombieSummon(), 0.5F, 1.0F);
        this.model = this.modelBipedMain;
    }

    protected void func_82421_b()
    {
    	super.func_82421_b();
    }

    /**
     * Queries whether should render the specified pass or not.
     */
    protected int shouldRenderPass(EntitySummonZombie p_77032_1_, int p_77032_2_, float p_77032_3_)
    {
        this.func_82427_a(p_77032_1_);
        return super.shouldRenderPass((EntityLiving)p_77032_1_, p_77032_2_, p_77032_3_);
    }

    /**
     * Actually renders the given argument. This is a synthetic bridge method, always casting down its argument and then
     * handing it off to a worker function which does the actual work. In all probabilty, the class Render is generic
     * (Render<T extends Entity) and this method has signature public void func_76986_a(T entity, double d, double d1,
     * double d2, float f, float f1). But JAD is pre 1.5 so doesn't do that.
     */
    public void doRender(EntitySummonZombie p_76986_1_, double p_76986_2_, double p_76986_4_, double p_76986_6_, float p_76986_8_, float p_76986_9_)
    {
        this.func_82427_a(p_76986_1_);
        super.doRender((EntityLiving)p_76986_1_, p_76986_2_, p_76986_4_, p_76986_6_, p_76986_8_, p_76986_9_);
    }

    /**
     * Returns the location of an entity's texture. Doesn't seem to be called unless you call Render.bindEntityTexture.
     */
    protected ResourceLocation getEntityTexture(EntitySummonZombie entity)
    {
    	switch (entity.getType())
    	{
    		case 0 :
        		return texture1;
        		
    		case 1 :
        		return texture2;
        		
    		case 2 :
        		return texture3;
        		
    		case 3 :
        		return texture4;
    	}
    	return (null);
    }

    protected void renderEquippedItems(EntitySummonZombie p_77029_1_, float p_77029_2_)
    {
        this.func_82427_a(p_77029_1_);
        super.renderEquippedItems((EntityLiving)p_77029_1_, p_77029_2_);
    }

    private void func_82427_a(EntitySummonZombie p_82427_1_)
    {
    	this.mainModel = this.model;
        this.modelBipedMain = (ModelBiped)this.mainModel;
    }

    protected void rotateCorpse(EntitySummonZombie p_77043_1_, float p_77043_2_, float p_77043_3_, float p_77043_4_)
    {
        super.rotateCorpse(p_77043_1_, p_77043_2_, p_77043_3_, p_77043_4_);
    }

    protected void renderEquippedItems(EntityLiving p_77029_1_, float p_77029_2_)
    {
        this.renderEquippedItems((EntitySummonZombie)p_77029_1_, p_77029_2_);
    }

    /**
     * Returns the location of an entity's texture. Doesn't seem to be called unless you call Render.bindEntityTexture.
     */
    protected ResourceLocation getEntityTexture(EntityLiving p_110775_1_)
    {
        return this.getEntityTexture((EntitySummonZombie)p_110775_1_);
    }

    /**
     * Actually renders the given argument. This is a synthetic bridge method, always casting down its argument and then
     * handing it off to a worker function which does the actual work. In all probabilty, the class Render is generic
     * (Render<T extends Entity) and this method has signature public void func_76986_a(T entity, double d, double d1,
     * double d2, float f, float f1). But JAD is pre 1.5 so doesn't do that.
     */
    public void doRender(EntityLiving p_76986_1_, double p_76986_2_, double p_76986_4_, double p_76986_6_, float p_76986_8_, float p_76986_9_)
    {
        this.doRender((EntitySummonZombie)p_76986_1_, p_76986_2_, p_76986_4_, p_76986_6_, p_76986_8_, p_76986_9_);
    }

    /**
     * Queries whether should render the specified pass or not.
     */
    protected int shouldRenderPass(EntityLiving p_77032_1_, int p_77032_2_, float p_77032_3_)
    {
        return this.shouldRenderPass((EntitySummonZombie)p_77032_1_, p_77032_2_, p_77032_3_);
    }

    /**
     * Queries whether should render the specified pass or not.
     */
    protected int shouldRenderPass(EntityLivingBase p_77032_1_, int p_77032_2_, float p_77032_3_)
    {
        return this.shouldRenderPass((EntitySummonZombie)p_77032_1_, p_77032_2_, p_77032_3_);
    }

    protected void renderEquippedItems(EntityLivingBase p_77029_1_, float p_77029_2_)
    {
        this.renderEquippedItems((EntitySummonZombie)p_77029_1_, p_77029_2_);
    }

    protected void rotateCorpse(EntityLivingBase p_77043_1_, float p_77043_2_, float p_77043_3_, float p_77043_4_)
    {
        this.rotateCorpse((EntitySummonZombie)p_77043_1_, p_77043_2_, p_77043_3_, p_77043_4_);
    }

    /**
     * Actually renders the given argument. This is a synthetic bridge method, always casting down its argument and then
     * handing it off to a worker function which does the actual work. In all probabilty, the class Render is generic
     * (Render<T extends Entity) and this method has signature public void func_76986_a(T entity, double d, double d1,
     * double d2, float f, float f1). But JAD is pre 1.5 so doesn't do that.
     */
    public void doRender(EntityLivingBase p_76986_1_, double p_76986_2_, double p_76986_4_, double p_76986_6_, float p_76986_8_, float p_76986_9_)
    {
        this.doRender((EntitySummonZombie)p_76986_1_, p_76986_2_, p_76986_4_, p_76986_6_, p_76986_8_, p_76986_9_);
    }

    /**
     * Returns the location of an entity's texture. Doesn't seem to be called unless you call Render.bindEntityTexture.
     */
    protected ResourceLocation getEntityTexture(Entity p_110775_1_)
    {
        return this.getEntityTexture((EntitySummonZombie)p_110775_1_);
    }

    /**
     * Actually renders the given argument. This is a synthetic bridge method, always casting down its argument and then
     * handing it off to a worker function which does the actual work. In all probabilty, the class Render is generic
     * (Render<T extends Entity) and this method has signature public void func_76986_a(T entity, double d, double d1,
     * double d2, float f, float f1). But JAD is pre 1.5 so doesn't do that.
     */
    public void doRender(Entity p_76986_1_, double p_76986_2_, double p_76986_4_, double p_76986_6_, float p_76986_8_, float p_76986_9_)
    {
        this.doRender((EntitySummonZombie)p_76986_1_, p_76986_2_, p_76986_4_, p_76986_6_, p_76986_8_, p_76986_9_);
    }
}