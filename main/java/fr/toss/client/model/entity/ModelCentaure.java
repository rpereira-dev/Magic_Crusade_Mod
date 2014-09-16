package fr.toss.client.model.entity;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;


public class ModelCentaure extends ModelBase
{
  ModelRenderer tronc;
  ModelRenderer croupe;
  ModelRenderer corps;
  ModelRenderer torse;
  ModelRenderer patteAvtDR;
  ModelRenderer patteAvtGCH;
  ModelRenderer patteArGCH;
  ModelRenderer patteArDR;
  ModelRenderer brasGCH;
  ModelRenderer brasDR;
  ModelRenderer tete;

  public ModelCentaure()
  {
    this.textureWidth = 256;
    this.textureHeight = 128;
    
    this.tronc = new ModelRenderer(this, 0, 94);
    this.tronc.addBox(-8.0F, 0.0F, 0.0F, 16, 16, 18);
    this.tronc.setRotationPoint(0.0F, -14.0F, -10.0F);
    this.tronc.setTextureSize(256, 128);
    this.tronc.mirror = true;
    setRotation(this.tronc, -0.0872665F, 0.0F, 0.0F);
    
    this.croupe = new ModelRenderer(this, 68, 90);
    this.croupe.addBox(-6.0F, 3.0F, 15.0F, 12, 14, 24);
    this.croupe.setRotationPoint(0.0F, -14.0F, -10.0F);
    this.croupe.setTextureSize(256, 128);
    this.croupe.mirror = true;
    setRotation(this.croupe, 0.0872665F, 0.0F, 0.0F);
    
    this.corps = new ModelRenderer(this, 140, 96);
    this.corps.addBox(-4.0F, -15.0F, 0.0F, 10, 26, 6);
    this.corps.setRotationPoint(-1.0F, -14.0F, -11.0F);
    this.corps.setTextureSize(256, 128);
    this.corps.mirror = true;
    setRotation(this.corps, 0.0F, 0.0F, 0.0F);
    this.torse = new ModelRenderer(this, 168, 112);
    
    this.torse.addBox(-6.0F, -18.0F, -1.0F, 12, 8, 8);
    this.torse.setRotationPoint(0.0F, -14.0F, -11.0F);
    this.torse.setTextureSize(256, 128);
    this.torse.mirror = true;
    setRotation(this.torse, 0.0F, 0.0F, 0.0F);
    
    this.patteAvtDR = new ModelRenderer(this, 0, 66);
    this.patteAvtDR.addBox(-2.0F, 0.0F, -3.0F, 5, 22, 6);
    this.patteAvtDR.setRotationPoint(-6.0F, 2.0F, -8.0F);
    this.patteAvtDR.setTextureSize(256, 128);
    this.patteAvtDR.mirror = true;
    setRotation(this.patteAvtDR, 0.0F, 0.0F, 0.0F);
    
    this.patteAvtGCH = new ModelRenderer(this, 22, 66);
    this.patteAvtGCH.addBox(-3.0F, 0.0F, -3.0F, 5, 22, 6);
    this.patteAvtGCH.setRotationPoint(6.0F, 2.0F, -8.0F);
    this.patteAvtGCH.setTextureSize(256, 128);
    this.patteAvtGCH.mirror = true;
    setRotation(this.patteAvtGCH, 0.0F, 0.0F, 0.0F);
    
    this.patteArGCH = new ModelRenderer(this, 44, 59);
    this.patteArGCH.addBox(-3.0F, 0.0F, -3.5F, 5, 28, 7);
    this.patteArGCH.setRotationPoint(5.0F, -4.0F, 24.0F);
    this.patteArGCH.setTextureSize(256, 128);
    this.patteArGCH.mirror = true;
    setRotation(this.patteArGCH, 0.0F, 0.0F, 0.0F);
    
    this.patteArDR = new ModelRenderer(this, 68, 59);
    this.patteArDR.addBox(-2.0F, 0.0F, -3.5F, 5, 28, 7);
    this.patteArDR.setRotationPoint(-5.0F, -4.0F, 24.0F);
    this.patteArDR.setTextureSize(256, 128);
    this.patteArDR.mirror = true;
    setRotation(this.patteArDR, 0.0F, 0.0F, 0.0F);
    
    this.brasGCH = new ModelRenderer(this, 0, 40);
    this.brasGCH.addBox(0.0F, 0.0F, -2.0F, 4, 22, 4);
    this.brasGCH.setRotationPoint(5.0F, -31.0F, -9.0F);
    this.brasGCH.setTextureSize(256, 128);
    this.brasGCH.mirror = true;
    setRotation(this.brasGCH, 0.0F, 0.0F, -0.1745329F);
    
    this.brasDR = new ModelRenderer(this, 16, 40);
    this.brasDR.addBox(-4.0F, 0.0F, -2.0F, 4, 22, 4);
    this.brasDR.setRotationPoint(-5.0F, -31.0F, -9.0F);
    this.brasDR.setTextureSize(256, 128);
    this.brasDR.mirror = true;
    setRotation(this.brasDR, 0.0F, 0.0F, 0.1745329F);
    
    this.tete = new ModelRenderer(this, 0, 0);
    this.tete.addBox(-5.0F, -12.0F, -5.0F, 10, 12, 10);
    this.tete.setRotationPoint(0.0F, -32.0F, -8.0F);
    this.tete.setTextureSize(256, 128);
    this.tete.mirror = true;
    setRotation(this.tete, 0.0F, 0.0F, 0.0F);
  }

  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    this.setRotationAngles(f, f1, f2, f3, f4, f5);
    this.tronc.render(f5);
    this.croupe.render(f5);
    this.corps.render(f5);
    this.torse.render(f5);
    this.patteAvtDR.render(f5);
    this.patteAvtGCH.render(f5);
    this.patteArGCH.render(f5);
    this.patteArDR.render(f5);
    this.brasGCH.render(f5);
    this.brasDR.render(f5);
    this.tete.render(f5);
  }

  private void setRotation(ModelRenderer model, float x, float y, float z)
  {
	    model.rotateAngleX = x;
	    model.rotateAngleY = y;
	    model.rotateAngleZ = z;
  }

  public void setRotationAngles(float var1, float var2, float var3, float var4, float var5, float var6)
  {
    this.tete.rotateAngleY = (var4 / 57.295776F);
    this.tete.rotateAngleX = (var5 / 57.295776F);

    this.patteAvtDR.rotateAngleX = (MathHelper.cos(var1 * 0.6662F) * 1.4F * var2 / 3.0F);
    this.patteAvtGCH.rotateAngleX = (-(MathHelper.cos(var1 * 0.6662F) * 1.4F * var2 / 3.0F));
    this.patteArDR.rotateAngleX = (-(MathHelper.cos(var1 * 0.6662F) * 1.4F * var2 / 3.0F));
    this.patteArGCH.rotateAngleX = (MathHelper.cos(var1 * 0.6662F) * 1.4F * var2 / 3.0F);
    this.brasDR.rotateAngleX = (-(MathHelper.cos(var1 * 0.6662F) * 1.4F * var2 / 3.0F));
    this.brasGCH.rotateAngleX = (MathHelper.cos(var1 * 0.6662F) * 1.4F * var2 / 3.0F);
    super.setRotationAngles(var1, var2, var3, var4, var5, var6, (Entity)null);
  }
}