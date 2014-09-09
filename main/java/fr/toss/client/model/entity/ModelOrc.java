package fr.toss.client.model.entity;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelOrc extends ModelBiped
{
  ModelRenderer machoire;
  ModelRenderer tete;
  ModelRenderer dentDR;
  ModelRenderer dentGCH;
  ModelRenderer torse;
  ModelRenderer tronc;
  ModelRenderer jambeGCH;
  ModelRenderer jambeDR;
  ModelRenderer bipedLeftArm;
  ModelRenderer bipedRightArm;

  public ModelOrc()
  {
    this.textureWidth = 128;
    this.textureHeight = 64;

    this.machoire = new ModelRenderer(this, 0, 52);
    this.machoire.addBox(-4.0F, -3.0F, -5.0F, 8, 3, 9);
    this.machoire.setRotationPoint(0.0F, -1.0F, 0.0F);
    this.machoire.setTextureSize(64, 32);
    this.machoire.mirror = true;
    setRotation(this.machoire, 0.0F, 0.0F, 0.0F);
    this.tete = new ModelRenderer(this, 0, 38);
    this.tete.addBox(-3.0F, -9.0F, -3.0F, 6, 7, 7);
    this.tete.setRotationPoint(0.0F, -1.0F, 0.0F);
    this.tete.setTextureSize(64, 32);
    this.tete.mirror = true;
    setRotation(this.tete, 0.0F, 0.0F, 0.0F);
    this.dentDR = new ModelRenderer(this, 0, 52);
    this.dentDR.addBox(-3.0F, -5.0F, -5.0F, 1, 3, 1);
    this.dentDR.setRotationPoint(0.0F, -1.0F, 0.0F);
    this.dentDR.setTextureSize(64, 32);
    this.dentDR.mirror = true;
    setRotation(this.dentDR, 0.0F, 0.0F, 0.0F);
    this.dentGCH = new ModelRenderer(this, 4, 52);
    this.dentGCH.addBox(2.0F, -4.5F, -5.0F, 1, 3, 1);
    this.dentGCH.setRotationPoint(0.0F, -1.0F, 0.0F);
    this.dentGCH.setTextureSize(64, 32);
    this.dentGCH.mirror = true;
    setRotation(this.dentGCH, 0.0F, 0.0F, 0.0F);
    this.torse = new ModelRenderer(this, 0, 22);
    this.torse.addBox(-6.0F, 3.0F, -4.0F, 12, 8, 8);
    this.torse.setRotationPoint(0.0F, -4.0F, 0.0F);
    this.torse.setTextureSize(64, 32);
    this.torse.mirror = true;
    setRotation(this.torse, 0.0F, 0.0F, 0.0F);
    this.tronc = new ModelRenderer(this, 40, 24);
    this.tronc.addBox(-4.0F, 10.0F, -3.0F, 8, 8, 6);
    this.tronc.setRotationPoint(0.0F, -4.0F, 0.0F);
    this.tronc.setTextureSize(64, 32);
    this.tronc.mirror = true;
    setRotation(this.tronc, 0.0F, 0.0F, 0.0F);
    this.jambeGCH = new ModelRenderer(this, 0, 0);
    this.jambeGCH.addBox(0.0F, 0.0F, -2.0F, 4, 12, 4);
    this.jambeGCH.setRotationPoint(0.0F, 12.0F, 0.0F);
    this.jambeGCH.setTextureSize(64, 32);
    this.jambeGCH.mirror = true;
    setRotation(this.jambeGCH, 0.0F, 0.0F, 0.0F);
    this.jambeDR = new ModelRenderer(this, 16, 0);
    this.jambeDR.addBox(-4.0F, 0.0F, -2.0F, 4, 12, 4);
    this.jambeDR.setRotationPoint(0.0F, 12.0F, 0.0F);
    this.jambeDR.setTextureSize(64, 32);
    this.jambeDR.mirror = true;
    setRotation(this.jambeDR, 0.0F, 0.0F, 0.0F);
    this.bipedLeftArm = new ModelRenderer(this, 32, 0);
    this.bipedLeftArm.addBox(0.0F, 0.0F, -2.0F, 5, 12, 5);
    this.bipedLeftArm.setRotationPoint(4.0F, 0.0F, 0.0F);
    this.bipedLeftArm.setTextureSize(64, 32);
    this.bipedLeftArm.mirror = true;
    setRotation(this.bipedLeftArm, 0.0F, 0.0F, -0.349066F);
    this.bipedRightArm = new ModelRenderer(this, 52, 0);
    this.bipedRightArm.addBox(-5.0F, 0.0F, -2.0F, 5, 12, 5);
    this.bipedRightArm.setRotationPoint(-4.0F, 0.0F, 0.0F);
    this.bipedRightArm.setTextureSize(64, 32);
    this.bipedRightArm.mirror = true;
    setRotation(this.bipedRightArm, 0.0F, 0.0F, 0.349066F);
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
    this.bipedLeftArm.render(f5);
    this.bipedRightArm.render(f5);
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

    this.bipedLeftArm.rotateAngleX = MathHelper.cos(var1 * 0.6662F) * 1.4F * var2;
    this.bipedRightArm.rotateAngleX = -MathHelper.cos(var1 * 0.6662F) * 1.4F * var2;

    super.setRotationAngles(var1, var2, var3, var4, var5, var6, (Entity)null);
  }
}