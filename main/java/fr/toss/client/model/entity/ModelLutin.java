package fr.toss.client.model.entity;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;


public class ModelLutin extends ModelBase
{
  ModelRenderer corps;
  ModelRenderer jambe1DR;
  ModelRenderer jambe1GCH;
  ModelRenderer jambe2GCH;
  ModelRenderer jambe2DR;
  ModelRenderer piedGCH;
  ModelRenderer piedDR;
  ModelRenderer bras1GCH;
  ModelRenderer bras1DR;
  ModelRenderer bras2GCH;
  ModelRenderer bras2DR;
  ModelRenderer cou;
  ModelRenderer tete;
  ModelRenderer chapeau1;
  ModelRenderer chapeau2;
  ModelRenderer chapeau3;
  ModelRenderer chapeau4;
  ModelRenderer chapeau5;
  ModelRenderer chapeau6;
  ModelRenderer chapeau7;
  ModelRenderer oreilleGCH;
  ModelRenderer oreilleDR;

  public ModelLutin()
  {
    this.textureWidth = 256;
    this.textureHeight = 64;
    this.corps = new ModelRenderer(this, 0, 50);
    this.corps.addBox(-3.0F, -10.0F, 0.0F, 6, 10, 4);
    this.corps.setRotationPoint(0.0F, 14.0F, 0.0F);
    this.corps.setTextureSize(256, 64);
    this.corps.mirror = true;
    setRotation(this.corps, 0.0F, 0.0F, 0.0F);
    this.jambe1DR = new ModelRenderer(this, 0, 42);
    this.jambe1DR.addBox(-1.0F, 0.0F, 0.0F, 1, 6, 2);
    this.jambe1DR.setRotationPoint(-1.0F, 13.0F, 0.0F);
    this.jambe1DR.setTextureSize(256, 64);
    this.jambe1DR.mirror = true;
    setRotation(this.jambe1DR, -0.261799F, 0.0F, 0.0F);
    this.jambe1GCH = new ModelRenderer(this, 0, 42);
    this.jambe1GCH.addBox(0.0F, 0.0F, 0.0F, 1, 6, 2);
    this.jambe1GCH.setRotationPoint(1.0F, 13.0F, 0.0F);
    this.jambe1GCH.setTextureSize(256, 64);
    this.jambe1GCH.mirror = true;
    setRotation(this.jambe1GCH, -0.261799F, 0.0F, 0.0F);
    this.jambe2GCH = new ModelRenderer(this, 6, 42);
    this.jambe2GCH.addBox(0.0F, 5.0F, -2.5F, 1, 5, 1);
    this.jambe2GCH.setRotationPoint(1.0F, 13.0F, 0.0F);
    this.jambe2GCH.setTextureSize(256, 64);
    this.jambe2GCH.mirror = true;
    setRotation(this.jambe2GCH, 0.261799F, 0.0F, 0.0F);
    this.jambe2DR = new ModelRenderer(this, 6, 42);
    this.jambe2DR.addBox(-1.0F, 5.0F, -2.5F, 1, 5, 1);
    this.jambe2DR.setRotationPoint(-1.0F, 13.0F, 0.0F);
    this.jambe2DR.setTextureSize(256, 64);
    this.jambe2DR.mirror = true;
    setRotation(this.jambe2DR, 0.261799F, 0.0F, 0.0F);
    this.piedGCH = new ModelRenderer(this, 10, 42);
    this.piedGCH.addBox(0.0F, 10.0F, -2.0F, 2, 1, 4);
    this.piedGCH.setRotationPoint(1.0F, 13.0F, 0.0F);
    this.piedGCH.setTextureSize(256, 64);
    this.piedGCH.mirror = true;
    setRotation(this.piedGCH, 0.0F, 0.0F, 0.0F);
    this.piedDR = new ModelRenderer(this, 10, 42);
    this.piedDR.addBox(-2.0F, 10.0F, -4.0F, 2, 1, 4);
    this.piedDR.setRotationPoint(-1.0F, 13.0F, 2.0F);
    this.piedDR.setTextureSize(256, 64);
    this.piedDR.mirror = true;
    setRotation(this.piedDR, 0.0F, 0.0F, 0.0F);
    this.bras1GCH = new ModelRenderer(this, 0, 39);
    this.bras1GCH.addBox(0.0F, 0.0F, -1.0F, 6, 1, 2);
    this.bras1GCH.setRotationPoint(3.0F, 4.0F, 2.0F);
    this.bras1GCH.setTextureSize(256, 64);
    this.bras1GCH.mirror = true;
    setRotation(this.bras1GCH, 0.0F, 0.0F, 0.7853982F);
    this.bras1DR = new ModelRenderer(this, 0, 39);
    this.bras1DR.addBox(-6.0F, 0.0F, -1.0F, 6, 1, 2);
    this.bras1DR.setRotationPoint(-3.0F, 4.0F, 2.0F);
    this.bras1DR.setTextureSize(256, 64);
    this.bras1DR.mirror = true;
    setRotation(this.bras1DR, 0.0F, 0.0F, -0.7853982F);
    this.bras2GCH = new ModelRenderer(this, 16, 35);
    this.bras2GCH.addBox(3.0F, 4.0F, -5.0F, 1, 1, 6);
    this.bras2GCH.setRotationPoint(3.0F, 4.0F, 2.0F);
    this.bras2GCH.setTextureSize(256, 64);
    this.bras2GCH.mirror = true;
    setRotation(this.bras2GCH, 0.0F, 0.0F, 0.0F);
    this.bras2DR = new ModelRenderer(this, 16, 35);
    this.bras2DR.addBox(-4.0F, 4.0F, -5.0F, 1, 1, 6);
    this.bras2DR.setRotationPoint(-3.0F, 4.0F, 2.0F);
    this.bras2DR.setTextureSize(256, 64);
    this.bras2DR.mirror = true;
    setRotation(this.bras2DR, 0.0F, 0.0F, 0.0F);
    this.cou = new ModelRenderer(this, 0, 34);
    this.cou.addBox(-1.0F, -3.0F, -1.0F, 2, 3, 2);
    this.cou.setRotationPoint(0.0F, 5.0F, 2.0F);
    this.cou.setTextureSize(256, 64);
    this.cou.mirror = true;
    setRotation(this.cou, 0.0F, 0.0F, 0.0F);
    this.tete = new ModelRenderer(this, 0, 26);
    this.tete.addBox(-2.0F, -3.0F, -3.0F, 4, 4, 4);
    this.tete.setRotationPoint(0.0F, 2.0F, 3.0F);
    this.tete.setTextureSize(256, 64);
    this.tete.mirror = true;
    setRotation(this.tete, 0.0F, 0.0F, 0.0F);
    this.chapeau1 = new ModelRenderer(this, 0, 0);
    this.chapeau1.addBox(-5.0F, -6.0F, -5.0F, 10, 1, 8);
    this.chapeau1.setRotationPoint(0.0F, 5.0F, 3.0F);
    this.chapeau1.setTextureSize(256, 64);
    this.chapeau1.mirror = true;
    setRotation(this.chapeau1, 0.0F, 0.0F, 0.0F);
    this.chapeau2 = new ModelRenderer(this, 36, 0);
    this.chapeau2.addBox(-2.5F, -7.0F, -3.0F, 6, 2, 5);
    this.chapeau2.setRotationPoint(0.0F, 5.0F, 3.0F);
    this.chapeau2.setTextureSize(256, 64);
    this.chapeau2.mirror = true;
    setRotation(this.chapeau2, 0.0F, 0.0F, 0.0F);
    this.chapeau3 = new ModelRenderer(this, 58, 0);
    this.chapeau3.addBox(-1.0F, -8.0F, -2.5F, 4, 2, 4);
    this.chapeau3.setRotationPoint(0.0F, 5.0F, 3.0F);
    this.chapeau3.setTextureSize(256, 64);
    this.chapeau3.mirror = true;
    setRotation(this.chapeau3, 0.0F, 0.0F, 0.0F);
    this.chapeau4 = new ModelRenderer(this, 74, 0);
    this.chapeau4.addBox(-0.2F, -9.5F, -2.0F, 3, 3, 3);
    this.chapeau4.setRotationPoint(0.0F, 5.0F, 3.0F);
    this.chapeau4.setTextureSize(256, 64);
    this.chapeau4.mirror = true;
    setRotation(this.chapeau4, 0.0F, 0.0F, 0.0F);
    this.chapeau5 = new ModelRenderer(this, 86, 0);
    this.chapeau5.addBox(0.0F, -12.0F, -1.5F, 2, 3, 2);
    this.chapeau5.setRotationPoint(0.0F, 6.0F, 3.0F);
    this.chapeau5.setTextureSize(256, 64);
    this.chapeau5.mirror = true;
    setRotation(this.chapeau5, 0.0F, 0.0F, 0.0F);
    this.chapeau6 = new ModelRenderer(this, 94, 0);
    this.chapeau6.addBox(0.0F, -13.0F, -1.0F, 1, 2, 1);
    this.chapeau6.setRotationPoint(0.0F, 5.0F, 3.0F);
    this.chapeau6.setTextureSize(256, 64);
    this.chapeau6.mirror = true;
    setRotation(this.chapeau6, 0.0F, 0.0F, 0.0F);
    this.chapeau7 = new ModelRenderer(this, 98, 0);
    this.chapeau7.addBox(-1.0F, -14.0F, -0.5F, 1, 2, 1);
    this.chapeau7.setRotationPoint(0.0F, 5.0F, 3.0F);
    this.chapeau7.setTextureSize(256, 64);
    this.chapeau7.mirror = true;
    setRotation(this.chapeau7, 0.0F, 0.0F, 0.0F);
    this.oreilleGCH = new ModelRenderer(this, 0, 11);
    this.oreilleGCH.addBox(0.0F, -5.0F, -1.0F, 6, 2, 0);
    this.oreilleGCH.setRotationPoint(0.0F, 5.0F, 3.0F);
    this.oreilleGCH.setTextureSize(256, 64);
    this.oreilleGCH.mirror = true;
    setRotation(this.oreilleGCH, 0.0F, 0.0F, -0.0872665F);
    this.oreilleDR = new ModelRenderer(this, 0, 9);
    this.oreilleDR.addBox(-6.0F, -5.0F, -1.0F, 6, 2, 0);
    this.oreilleDR.setRotationPoint(0.0F, 5.0F, 3.0F);
    this.oreilleDR.setTextureSize(256, 64);
    this.oreilleDR.mirror = true;
    setRotation(this.oreilleDR, 0.0F, 0.0F, 0.0872665F);
  }

  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5);
    this.corps.render(f5);
    this.jambe1DR.render(f5);
    this.jambe1GCH.render(f5);
    this.jambe2GCH.render(f5);
    this.jambe2DR.render(f5);
    this.piedGCH.render(f5);
    this.piedDR.render(f5);
    this.bras1GCH.render(f5);
    this.bras1DR.render(f5);
    this.bras2GCH.render(f5);
    this.bras2DR.render(f5);
    this.cou.render(f5);
    this.tete.render(f5);
    this.chapeau1.render(f5);
    this.chapeau2.render(f5);
    this.chapeau3.render(f5);
    this.chapeau4.render(f5);
    this.chapeau5.render(f5);
    this.chapeau6.render(f5);
    this.chapeau7.render(f5);
    this.oreilleGCH.render(f5);
    this.oreilleDR.render(f5);
  }

  private void setRotation(ModelRenderer model, float x, float y, float z)
  {
    model.rotateAngleX = x;
    model.rotateAngleY = y;
    model.rotateAngleZ = z;
  }

  public void setRotationAngles(float var1, float var2, float var3, float var4, float var5, float var6)
  {
    this.jambe1DR.rotateAngleX = (MathHelper.cos(var1 * 0.6662F) * 1.4F * var2 / 3.0F);
    this.jambe1GCH.rotateAngleX = (-(MathHelper.cos(var1 * 0.6662F) * 1.4F * var2 / 3.0F));
    this.jambe2DR.rotateAngleX = (MathHelper.cos(var1 * 0.6662F) * 1.4F * var2 / 3.0F + 0.2F);
    this.jambe2GCH.rotateAngleX = (-(MathHelper.cos(var1 * 0.6662F) * 1.4F * var2 / 3.0F - 0.2F));
    this.piedDR.rotateAngleX = (MathHelper.cos(var1 * 0.6662F) * 1.4F * var2 / 3.0F + 0.2F);
    this.piedGCH.rotateAngleX = (-(MathHelper.cos(var1 * 0.6662F) * 1.4F * var2 / 3.0F - 0.2F));
    this.bras1DR.rotateAngleX = (MathHelper.cos(var1 * 0.6662F) * 1.4F * var2 / 3.0F);
    this.bras1GCH.rotateAngleX = (-(MathHelper.cos(var1 * 0.6662F) * 1.4F * var2 / 3.0F));
    this.bras2DR.rotateAngleX = (MathHelper.cos(var1 * 0.6662F) * 1.4F * var2 / 3.0F);
    this.bras2GCH.rotateAngleX = (-(MathHelper.cos(var1 * 0.6662F) * 1.4F * var2 / 3.0F));
    this.tete.rotateAngleX = (var5 / 57.295776F);
    this.tete.rotateAngleY = (var4 / 57.295776F);
    this.cou.rotateAngleX = (var5 / 57.295776F);
    this.cou.rotateAngleY = (var4 / 57.295776F);
    super.setRotationAngles(var1, var2, var3, var4, var5, var6, (Entity)null);
  }
}