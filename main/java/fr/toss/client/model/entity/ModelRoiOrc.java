package fr.toss.client.model.entity;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;


public class ModelRoiOrc extends ModelBase
{
  ModelRenderer machoire;
  ModelRenderer tete;
  ModelRenderer dentDR;
  ModelRenderer dentGCH;
  ModelRenderer torse;
  ModelRenderer tronc;
  ModelRenderer jambeGCH;
  ModelRenderer jambeDR;
  ModelRenderer brasGCH;
  ModelRenderer brasDR;
  ModelRenderer manche;
  ModelRenderer fer;
  ModelRenderer fer2;

  public ModelRoiOrc()
  {
    this.textureWidth = 256;
    this.textureHeight = 128;

    this.machoire = new ModelRenderer(this, 80, 104);
    this.machoire.addBox(-8.0F, -22.0F, -10.0F, 16, 6, 18);
    this.machoire.setRotationPoint(0.0F, -1.0F, 0.0F);
    this.machoire.setTextureSize(256, 128);
    this.machoire.mirror = true;
    setRotation(this.machoire, 0.0F, 0.0F, 0.0F);
    this.tete = new ModelRenderer(this, 56, 68);
    this.tete.addBox(-6.0F, -36.0F, -6.0F, 12, 14, 14);
    this.tete.setRotationPoint(0.0F, -1.0F, 0.0F);
    this.tete.setTextureSize(256, 128);
    this.tete.mirror = true;
    setRotation(this.tete, 0.0F, 0.0F, 0.0F);
    this.dentDR = new ModelRenderer(this, 0, 52);
    this.dentDR.addBox(-6.0F, -27.0F, -9.4F, 2, 6, 2);
    this.dentDR.setRotationPoint(0.0F, -1.0F, 0.0F);
    this.dentDR.setTextureSize(256, 128);
    this.dentDR.mirror = true;
    setRotation(this.dentDR, 0.0F, 0.0F, 0.0F);
    this.dentGCH = new ModelRenderer(this, 4, 52);
    this.dentGCH.addBox(4.0F, -26.5F, -9.8F, 2, 6, 2);
    this.dentGCH.setRotationPoint(0.0F, -1.0F, 0.0F);
    this.dentGCH.setTextureSize(256, 128);
    this.dentGCH.mirror = true;
    setRotation(this.dentGCH, 0.0F, 0.0F, 0.0F);
    this.torse = new ModelRenderer(this, 0, 96);
    this.torse.addBox(-12.0F, -13.0F, -8.0F, 24, 16, 16);
    this.torse.setRotationPoint(0.0F, -4.0F, 0.0F);
    this.torse.setTextureSize(256, 128);
    this.torse.mirror = true;
    setRotation(this.torse, 0.0F, 0.0F, 0.0F);
    this.tronc = new ModelRenderer(this, 0, 68);
    this.tronc.addBox(-8.0F, 0.0F, -6.0F, 16, 16, 12);
    this.tronc.setRotationPoint(0.0F, -2.0F, 0.0F);
    this.tronc.setTextureSize(256, 128);
    this.tronc.mirror = true;
    setRotation(this.tronc, 0.0F, 0.0F, 0.0F);
    this.jambeGCH = new ModelRenderer(this, 184, 0);
    this.jambeGCH.addBox(0.0F, 0.0F, -4.0F, 8, 12, 8);
    this.jambeGCH.setRotationPoint(0.0F, 12.0F, 0.0F);
    this.jambeGCH.setTextureSize(256, 128);
    this.jambeGCH.mirror = true;
    setRotation(this.jambeGCH, 0.0F, 0.0F, 0.0F);
    this.jambeDR = new ModelRenderer(this, 184, 0);
    this.jambeDR.addBox(-8.0F, 0.0F, -4.0F, 8, 12, 8);
    this.jambeDR.setRotationPoint(0.0F, 12.0F, 0.0F);
    this.jambeDR.setTextureSize(256, 128);
    this.jambeDR.mirror = true;
    setRotation(this.jambeDR, 0.0F, 0.0F, 0.0F);
    this.brasGCH = new ModelRenderer(this, 216, 0);
    this.brasGCH.addBox(0.0F, 0.0F, -4.0F, 10, 24, 10);
    this.brasGCH.setRotationPoint(8.0F, -14.0F, 0.0F);
    this.brasGCH.setTextureSize(256, 128);
    this.brasGCH.mirror = true;
    setRotation(this.brasGCH, 0.0F, 0.0F, -0.349066F);
    this.brasDR = new ModelRenderer(this, 216, 0);
    this.brasDR.addBox(-10.0F, 0.0F, -4.0F, 10, 24, 10);
    this.brasDR.setRotationPoint(-8.0F, -14.0F, 0.0F);
    this.brasDR.setTextureSize(256, 128);
    this.brasDR.mirror = true;
    setRotation(this.brasDR, 0.0F, 0.0F, 0.349066F);
    this.manche = new ModelRenderer(this, 0, 0);
    this.manche.addBox(-12.0F, -18.0F, -16.0F, 2, 40, 2);
    this.manche.setRotationPoint(-8.0F, -14.0F, 0.0F);
    this.manche.setTextureSize(256, 128);
    this.manche.mirror = true;
    setRotation(this.manche, 0.7853982F, 0.0F, 0.0F);
    this.fer = new ModelRenderer(this, 8, 0);
    this.fer.addBox(-12.0F, -20.0F, -24.0F, 2, 12, 6);
    this.fer.setRotationPoint(-8.0F, -14.0F, 0.0F);
    this.fer.setTextureSize(256, 128);
    this.fer.mirror = true;
    setRotation(this.fer, 0.7853982F, 0.0F, 0.0F);
    this.fer2 = new ModelRenderer(this, 24, 0);
    this.fer2.addBox(-12.0F, -16.0F, -20.0F, 1, 4, 8);
    this.fer2.setRotationPoint(-7.5F, -14.0F, 0.0F);
    this.fer2.setTextureSize(256, 128);
    this.fer2.mirror = true;
    setRotation(this.fer2, 0.7853982F, 0.0F, 0.0F);
  }

  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5);
    this.machoire.render(f5);
    this.tete.render(f5);
    this.dentDR.render(f5);
    this.dentGCH.render(f5);
    this.torse.render(f5);
    this.tronc.render(f5);
    this.jambeGCH.render(f5);
    this.jambeDR.render(f5);
    this.brasGCH.render(f5);
    this.brasDR.render(f5);
    this.manche.render(f5);
    this.fer.render(f5);
    this.fer2.render(f5);
  }

  private void setRotation(ModelRenderer model, float x, float y, float z)
  {
    model.rotateAngleX = x;
    model.rotateAngleY = y;
    model.rotateAngleZ = z;
  }

  public void setRotationAngles(float var1, float var2, float var3, float var4, float var5, float var6)
  {
    this.jambeDR.rotateAngleX = MathHelper.cos(var1 * 0.6662F) * 1.4F * var2;
    this.jambeGCH.rotateAngleX = -MathHelper.cos(var1 * 0.6662F) * 1.4F * var2;

    this.brasDR.rotateAngleX = MathHelper.cos(var1 * 0.6662F) * 1.4F * var2;
    this.brasGCH.rotateAngleX = -MathHelper.cos(var1 * 0.6662F) * 1.4F * var2;
    this.manche.rotateAngleX = MathHelper.cos(var1 * 0.6662F) * 1.4F * var2 + 1.0F;
    this.fer.rotateAngleX = MathHelper.cos(var1 * 0.6662F) * 1.4F * var2 + 1.0F;
    this.fer2.rotateAngleX = MathHelper.cos(var1 * 0.6662F) * 1.4F * var2 + 1.0F;

    this.tete.rotateAngleX = (var5 / 57.295776F);
    this.tete.rotateAngleY = (var4 / 57.295776F);
    this.machoire.rotateAngleX = this.tete.rotateAngleX;
    this.machoire.rotateAngleY = this.tete.rotateAngleY;
    
    this.dentDR.rotateAngleX = this.tete.rotateAngleX;
    this.dentGCH.rotateAngleX = this.tete.rotateAngleX;
    this.dentDR.rotateAngleY = this.tete.rotateAngleY;
    this.dentGCH.rotateAngleY = this.tete.rotateAngleY;
    
    super.setRotationAngles(var1, var2, var3, var4, var5, var6, (Entity)null);
  }
}