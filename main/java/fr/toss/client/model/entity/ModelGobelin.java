package fr.toss.client.model.entity;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelGobelin extends ModelBase
{
  ModelRenderer tete;
  ModelRenderer tronc;
  ModelRenderer jambeGCH;
  ModelRenderer jambeDR;
  ModelRenderer brasGCH;
  ModelRenderer brasDR;

  public ModelGobelin()
  {
    this.textureWidth = 128;
    this.textureHeight = 64;

    this.tete = new ModelRenderer(this, 0, 38);
    this.tete.addBox(-4.0F, -11.0F, -4.0F, 8, 10, 8);
    this.tete.setRotationPoint(0.0F, 4.0F, 0.0F);
    this.tete.setTextureSize(128, 64);
    this.tete.mirror = true;
    setRotation(this.tete, 0.0F, 0.0F, 0.0F);
    this.tronc = new ModelRenderer(this, 40, 24);
    this.tronc.addBox(-4.0F, 3.0F, -3.0F, 8, 14, 6);
    this.tronc.setRotationPoint(0.0F, 0.0F, 0.0F);
    this.tronc.setTextureSize(128, 64);
    this.tronc.mirror = true;
    setRotation(this.tronc, 0.0F, 0.0F, 0.0F);
    this.jambeGCH = new ModelRenderer(this, 0, 0);
    this.jambeGCH.addBox(0.0F, 0.0F, -2.0F, 4, 12, 4);
    this.jambeGCH.setRotationPoint(0.0F, 16.0F, 0.0F);
    this.jambeGCH.setTextureSize(128, 64);
    this.jambeGCH.mirror = true;
    setRotation(this.jambeGCH, 0.0F, 0.0F, 0.0F);
    this.jambeDR = new ModelRenderer(this, 16, 0);
    this.jambeDR.addBox(-4.0F, 0.0F, -2.0F, 4, 12, 4);
    this.jambeDR.setRotationPoint(0.0F, 16.0F, 0.0F);
    this.jambeDR.setTextureSize(128, 64);
    this.jambeDR.mirror = true;
    setRotation(this.jambeDR, 0.0F, 0.0F, 0.0F);
    this.brasGCH = new ModelRenderer(this, 32, 0);
    this.brasGCH.addBox(0.0F, 0.0F, -2.0F, 3, 12, 4);
    this.brasGCH.setRotationPoint(4.0F, 5.0F, 0.0F);
    this.brasGCH.setTextureSize(128, 64);
    this.brasGCH.mirror = true;
    setRotation(this.brasGCH, -0.7853982F, 0.0F, 0.0F);
    this.brasDR = new ModelRenderer(this, 52, 0);
    this.brasDR.addBox(-4.0F, 0.0F, -2.0F, 3, 12, 4);
    this.brasDR.setRotationPoint(-3.0F, 5.0F, 0.0F);
    this.brasDR.setTextureSize(128, 64);
    this.brasDR.mirror = true;
    setRotation(this.brasDR, -0.7853982F, 0.0F, 0.0F);
  }

  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5);
    this.tete.render(f5);
    this.tronc.render(f5);
    this.jambeGCH.render(f5);
    this.jambeDR.render(f5);
    this.brasGCH.render(f5);
    this.brasDR.render(f5);
  }

  private void setRotation(ModelRenderer model, float x, float y, float z)
  {
    model.rotateAngleX = x;
    model.rotateAngleY = y;
    model.rotateAngleZ = z;
  }

  public void setRotationAngles(float var1, float var2, float var3, float var4, float var5, float var6)
  {
    this.jambeDR.rotateAngleX = (MathHelper.cos(var1 * 0.6662F) * 1.4F * var2 / 3.0F);
    this.jambeGCH.rotateAngleX = (-(MathHelper.cos(var1 * 0.6662F) * 1.4F * var2 / 3.0F));

    this.brasGCH.rotateAngleX = (MathHelper.cos(var1 * 0.6662F) * 1.4F * var2 / 3.0F);
    this.brasDR.rotateAngleX = (-(MathHelper.cos(var1 * 0.6662F) * 1.4F * var2 / 3.0F));

    super.setRotationAngles(var1, var2, var3, var4, var5, var6, (Entity)null);
  }
}