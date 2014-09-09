package fr.toss.client.model.entity;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;


public class ModelZombieMonster extends ModelBase
{
  ModelRenderer molletGCH;
  ModelRenderer molletDR;
  ModelRenderer tronc;
  ModelRenderer torse;
  ModelRenderer tete;
  ModelRenderer brasGCH;
  ModelRenderer brasDR;
  ModelRenderer avantbrasGCH;
  ModelRenderer avantbrasDR;

  public ModelZombieMonster()
  {
    this.textureWidth = 256;
    this.textureHeight = 128;

    this.molletGCH = new ModelRenderer(this, 48, 24);
    this.molletGCH.addBox(3.0F, 8.0F, -14.0F, 6, 20, 6);
    this.molletGCH.setRotationPoint(-3.0F, -6.0F, 10.0F);
    this.molletGCH.setTextureSize(256, 128);
    this.molletGCH.mirror = true;
    setRotation(this.molletGCH, 0.0872665F, -0.1745329F, 0.0F);
    this.molletDR = new ModelRenderer(this, 68, 24);
    this.molletDR.addBox(-8.0F, 8.0F, -14.0F, 6, 20, 6);
    this.molletDR.setRotationPoint(2.0F, -6.0F, 10.0F);
    this.molletDR.setTextureSize(256, 128);
    this.molletDR.mirror = true;
    setRotation(this.molletDR, 0.0872665F, 0.1745329F, 0.0F);
    this.tronc = new ModelRenderer(this, 0, 100);
    this.tronc.addBox(-8.0F, -16.0F, -4.0F, 16, 20, 8);
    this.tronc.setRotationPoint(0.0F, 0.0F, 0.0F);
    this.tronc.setTextureSize(256, 128);
    this.tronc.mirror = true;
    setRotation(this.tronc, 0.261799F, 0.0F, 0.0F);
    this.torse = new ModelRenderer(this, 0, 78);
    this.torse.addBox(-10.0F, -18.0F, -5.0F, 20, 10, 12);
    this.torse.setRotationPoint(0.0F, 0.0F, 0.0F);
    this.torse.setTextureSize(256, 128);
    this.torse.mirror = true;
    setRotation(this.torse, 0.349066F, 0.0F, 0.0F);
    this.tete = new ModelRenderer(this, 0, 62);
    this.tete.addBox(-4.0F, -8.0F, -4.0F, 8, 8, 8);
    this.tete.setRotationPoint(0.0F, -17.0F, -5.0F);
    this.tete.setTextureSize(256, 128);
    this.tete.mirror = true;
    setRotation(this.tete, 0.2974289F, 0.0F, 0.0F);
    this.brasGCH = new ModelRenderer(this, 0, 41);
    this.brasGCH.addBox(0.0F, -2.0F, -2.0F, 5, 16, 5);
    this.brasGCH.setRotationPoint(9.0F, -13.0F, -3.0F);
    this.brasGCH.setTextureSize(256, 128);
    this.brasGCH.mirror = true;
    setRotation(this.brasGCH, 0.1745329F, 1.047198F, -0.5235988F);
    this.brasDR = new ModelRenderer(this, 20, 41);
    this.brasDR.addBox(-5.0F, -2.0F, -2.0F, 5, 16, 5);
    this.brasDR.setRotationPoint(-9.0F, -13.0F, -3.0F);
    this.brasDR.setTextureSize(256, 128);
    this.brasDR.mirror = true;
    setRotation(this.brasDR, 0.1745329F, -1.047198F, 0.5235988F);
    this.avantbrasGCH = new ModelRenderer(this, 38, 0);
    this.avantbrasGCH.addBox(3.0F, 5.0F, -16.0F, 7, 7, 12);
    this.avantbrasGCH.setRotationPoint(9.0F, -13.0F, -3.0F);
    this.avantbrasGCH.setTextureSize(256, 128);
    this.avantbrasGCH.mirror = true;
    setRotation(this.avantbrasGCH, 0.349066F, 0.349066F, -0.1745329F);
    this.avantbrasDR = new ModelRenderer(this, 0, 0);
    this.avantbrasDR.addBox(-10.0F, 5.0F, -15.0F, 7, 7, 12);
    this.avantbrasDR.setRotationPoint(-9.0F, -13.0F, -3.0F);
    this.avantbrasDR.setTextureSize(256, 128);
    this.avantbrasDR.mirror = true;
    setRotation(this.avantbrasDR, 0.349066F, -0.349066F, 0.1745329F);
  }

  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5);
    this.molletGCH.render(f5);
    this.molletDR.render(f5);
    this.tronc.render(f5);
    this.torse.render(f5);
    this.tete.render(f5);
    this.brasGCH.render(f5);
    this.brasDR.render(f5);
    this.avantbrasGCH.render(f5);
    this.avantbrasDR.render(f5);
  }

  private void setRotation(ModelRenderer model, float x, float y, float z)
  {
    model.rotateAngleX = x;
    model.rotateAngleY = y;
    model.rotateAngleZ = z;
  }

  public void setRotationAngles(float var1, float var2, float var3, float var4, float var5, float var6)
  {
    this.molletDR.rotateAngleX = (MathHelper.cos(var1 * 0.6662F) * 1.4F * var2 / 3.0F);
    this.molletGCH.rotateAngleX = (-(MathHelper.cos(var1 * 0.6662F) * 1.4F * var2 / 3.0F));

    this.avantbrasGCH.rotateAngleX = (MathHelper.cos(var1 * 0.6662F) * 1.4F * var2 / 3.0F);
    this.avantbrasDR.rotateAngleX = (-(MathHelper.cos(var1 * 0.6662F) * 1.4F * var2 / 3.0F));
    this.brasGCH.rotateAngleX = (MathHelper.cos(var1 * 0.6662F) * 1.4F * var2 / 3.0F);
    this.brasDR.rotateAngleX = (-(MathHelper.cos(var1 * 0.6662F) * 1.4F * var2 / 3.0F));

    this.tete.rotateAngleX = (var5 / 57.295776F);
    this.tete.rotateAngleY = (var4 / 57.295776F);
    
    super.setRotationAngles(var1, var2, var3, var4, var5, var6, (Entity)null);
  }
  
}