package fr.toss.client.model.entity;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;


public class ModelChevalier extends ModelBase
{
  ModelRenderer tronc;
  ModelRenderer cuisse_DR;
  ModelRenderer cuisse_GCH;
  ModelRenderer mollet_GCH;
  ModelRenderer mollet_DR;
  ModelRenderer bras_GCH;
  ModelRenderer bras_DR;
  ModelRenderer avant_bras_GCH;
  ModelRenderer avant_bras_DR;
  ModelRenderer cou;
  ModelRenderer tete;
  ModelRenderer tete_enclume;

  public ModelChevalier()
  {
    this.textureWidth = 256;
    this.textureHeight = 128;

    this.tronc = new ModelRenderer(this, 0, 0);
    this.tronc.addBox(-9.0F, -26.0F, -4.5F, 18, 26, 9);
    this.tronc.setRotationPoint(0.0F, 0.0F, -1.0F);
    this.tronc.setTextureSize(256, 128);
    this.tronc.mirror = true;
    setRotation(this.tronc, 0.0F, 0.0F, 0.0F);
    this.cuisse_DR = new ModelRenderer(this, 0, 35);
    this.cuisse_DR.addBox(-3.5F, -2.0F, -4.0F, 7, 14, 8);
    this.cuisse_DR.setRotationPoint(-6.0F, 0.0F, -1.0F);
    this.cuisse_DR.setTextureSize(256, 128);
    this.cuisse_DR.mirror = true;
    setRotation(this.cuisse_DR, -0.1745329F, 0.0872665F, 0.0F);
    this.cuisse_GCH = new ModelRenderer(this, 0, 35);
    this.cuisse_GCH.addBox(-3.5F, -2.0F, -4.0F, 7, 14, 8);
    this.cuisse_GCH.setRotationPoint(6.0F, 0.0F, -1.0F);
    this.cuisse_GCH.setTextureSize(256, 128);
    this.cuisse_GCH.mirror = true;
    setRotation(this.cuisse_GCH, -0.1745329F, -0.0872665F, 0.0F);
    this.mollet_GCH = new ModelRenderer(this, 30, 35);
    this.mollet_GCH.addBox(-3.0F, 10.0F, -6.0F, 8, 14, 8);
    this.mollet_GCH.setRotationPoint(6.0F, 0.0F, -1.0F);
    this.mollet_GCH.setTextureSize(256, 128);
    this.mollet_GCH.mirror = true;
    setRotation(this.mollet_GCH, 0.0F, 0.0F, 0.0872665F);
    this.mollet_DR = new ModelRenderer(this, 30, 35);
    this.mollet_DR.addBox(-5.0F, 10.0F, -6.0F, 8, 14, 8);
    this.mollet_DR.setRotationPoint(-6.0F, 0.0F, -1.0F);
    this.mollet_DR.setTextureSize(256, 128);
    this.mollet_DR.mirror = true;
    setRotation(this.mollet_DR, 0.0F, 0.0F, -0.0872665F);
    this.bras_GCH = new ModelRenderer(this, 0, 57);
    this.bras_GCH.addBox(-2.0F, 0.0F, -3.0F, 6, 14, 6);
    this.bras_GCH.setRotationPoint(9.0F, -26.0F, 0.0F);
    this.bras_GCH.setTextureSize(256, 128);
    this.bras_GCH.mirror = true;
    setRotation(this.bras_GCH, 0.0F, 0.0F, -0.349066F);
    this.bras_DR = new ModelRenderer(this, 0, 57);
    this.bras_DR.addBox(-4.0F, 0.0F, -3.0F, 6, 14, 6);
    this.bras_DR.setRotationPoint(-9.0F, -26.0F, 0.0F);
    this.bras_DR.setTextureSize(256, 128);
    this.bras_DR.mirror = true;
    setRotation(this.bras_DR, 0.0F, 0.0F, 0.349066F);
    this.avant_bras_GCH = new ModelRenderer(this, 24, 57);
    this.avant_bras_GCH.addBox(2.0F, 7.0F, 3.0F, 8, 16, 8);
    this.avant_bras_GCH.setRotationPoint(9.0F, -26.0F, 0.0F);
    this.avant_bras_GCH.setTextureSize(256, 128);
    this.avant_bras_GCH.mirror = true;
    setRotation(this.avant_bras_GCH, -0.5235988F, 0.261799F, 0.0F);
    this.avant_bras_DR = new ModelRenderer(this, 24, 57);
    this.avant_bras_DR.addBox(-10.0F, 7.0F, 4.0F, 8, 16, 8);
    this.avant_bras_DR.setRotationPoint(-9.0F, -26.0F, 0.0F);
    this.avant_bras_DR.setTextureSize(256, 128);
    this.avant_bras_DR.mirror = true;
    setRotation(this.avant_bras_DR, -0.5235988F, -0.261799F, 0.0F);
    this.cou = new ModelRenderer(this, 0, 77);
    this.cou.addBox(-2.5F, -7.0F, -3.5F, 5, 7, 5);
    this.cou.setRotationPoint(0.0F, -24.0F, 0.0F);
    this.cou.setTextureSize(256, 128);
    this.cou.mirror = true;
    setRotation(this.cou, 0.0F, 0.0F, 0.0F);
    this.tete = new ModelRenderer(this, 0, 89);
    this.tete.addBox(-8.0F, -13.0F, -5.0F, 16, 8, 8);
    this.tete.setRotationPoint(0.0F, -24.0F, 0.0F);
    this.tete.setTextureSize(256, 128);
    this.tete.mirror = true;
    setRotation(this.tete, 0.0F, 0.0F, 0.0F);
    this.tete_enclume = new ModelRenderer(this, 0, 105);
    this.tete_enclume.addBox(-12.0F, -10.9F, -3.0F, 24, 2, 4);
    this.tete_enclume.setRotationPoint(0.0F, -26.0F, 0.0F);
    this.tete_enclume.setTextureSize(256, 128);
    this.tete_enclume.mirror = true;
    setRotation(this.tete_enclume, 0.0F, 0.0F, 0.0F);
  }

  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5);
    this.tronc.render(f5);
    this.cuisse_DR.render(f5);
    this.cuisse_GCH.render(f5);
    this.mollet_GCH.render(f5);
    this.mollet_DR.render(f5);
    this.bras_GCH.render(f5);
    this.bras_DR.render(f5);
    this.avant_bras_GCH.render(f5);
    this.avant_bras_DR.render(f5);
    this.cou.render(f5);
    this.tete.render(f5);
    this.tete_enclume.render(f5);
  }

  private void setRotation(ModelRenderer model, float x, float y, float z)
  {
    model.rotateAngleX = x;
    model.rotateAngleY = y;
    model.rotateAngleZ = z;
  }

  public void setRotationAngles(float var1, float var2, float var3, float var4, float var5, float var6)
  {
    this.cuisse_DR.rotateAngleX = (MathHelper.cos(var1 * 0.6662F) * 1.4F * var2 / 3.0F);
    this.cuisse_GCH.rotateAngleX = (-(MathHelper.cos(var1 * 0.6662F) * 1.4F * var2 / 3.0F));
    this.mollet_DR.rotateAngleX = (MathHelper.cos(var1 * 0.6662F) * 1.4F * var2 / 3.0F);
    this.mollet_GCH.rotateAngleX = (-(MathHelper.cos(var1 * 0.6662F) * 1.4F * var2 / 3.0F));
    this.bras_DR.rotateAngleX = (MathHelper.cos(var1 * 0.6662F) * 1.4F * var2 / 3.0F);
    this.bras_GCH.rotateAngleX = (-(MathHelper.cos(var1 * 0.6662F) * 1.4F * var2 / 3.0F));
    this.avant_bras_DR.rotateAngleX = (MathHelper.cos(var1 * 0.6662F) * 1.4F * var2 / 3.0F);
    this.avant_bras_GCH.rotateAngleX = (-(MathHelper.cos(var1 * 0.6662F) * 1.4F * var2 / 3.0F));
    this.tete.rotateAngleX = (var5 / 57.295776F);
    this.tete.rotateAngleY = (var4 / 57.295776F);
    this.tete_enclume.rotateAngleX = (var5 / 57.295776F);
    this.tete_enclume.rotateAngleY = (var4 / 57.295776F);

    super.setRotationAngles(var1, var2, var3, var4, var5, var6, (Entity)null);
  }
}