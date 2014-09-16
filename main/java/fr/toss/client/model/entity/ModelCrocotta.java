package fr.toss.client.model.entity;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelCrocotta extends ModelBase
{
  ModelRenderer museaubas;
  ModelRenderer tete;
  ModelRenderer corps;
  ModelRenderer torse;
  ModelRenderer patteArDr;
  ModelRenderer patteArGCH;
  ModelRenderer patteAvDr;
  ModelRenderer patteAvGCH;
  ModelRenderer queue;
  ModelRenderer oreilleDR;
  ModelRenderer oreilleGCH;
  ModelRenderer museau;

  public ModelCrocotta()
  {
    this.textureWidth = 128;
    this.textureHeight = 64;

    this.museaubas = new ModelRenderer(this, 0, 0);
    this.museaubas.addBox(-3.0F, 3.0F, -9.0F, 5, 1, 7);
    this.museaubas.setRotationPoint(-0.5F, 8.5F, -12.0F);
    this.museaubas.setTextureSize(128, 64);
    this.museaubas.mirror = true;
    setRotation(this.museaubas, 0.0F, 0.0F, 0.0F);
    this.tete = new ModelRenderer(this, 26, 0);
    this.tete.addBox(-4.0F, -4.0F, -4.0F, 8, 9, 6);
    this.tete.setRotationPoint(-1.0F, 9.5F, -11.0F);
    this.tete.setTextureSize(128, 64);
    this.tete.mirror = true;
    setRotation(this.tete, 0.0F, 0.0F, 0.0F);
    this.corps = new ModelRenderer(this, 54, 0);
    this.corps.addBox(-5.0F, -1.0F, -3.0F, 8, 11, 8);
    this.corps.setRotationPoint(0.0F, 10.0F, 2.0F);
    this.corps.setTextureSize(128, 64);
    this.corps.mirror = true;
    setRotation(this.corps, 1.570796F, 0.0F, 0.0F);
    this.torse = new ModelRenderer(this, 86, 0);
    this.torse.addBox(-6.0F, -3.0F, -3.0F, 12, 10, 9);
    this.torse.setRotationPoint(-1.0F, 10.0F, -6.0F);
    this.torse.setTextureSize(128, 64);
    this.torse.mirror = true;
    setRotation(this.torse, 1.570796F, 0.0F, 0.0F);
    this.patteArDr = new ModelRenderer(this, 0, 18);
    this.patteArDr.addBox(-1.0F, 0.0F, -1.0F, 2, 12, 2);
    this.patteArDr.setRotationPoint(-3.5F, 12.0F, 7.0F);
    this.patteArDr.setTextureSize(128, 64);
    this.patteArDr.mirror = true;
    setRotation(this.patteArDr, 0.0F, 0.0F, 0.0F);
    this.patteArGCH = new ModelRenderer(this, 0, 18);
    this.patteArGCH.addBox(-1.0F, 0.0F, -1.0F, 2, 12, 2);
    this.patteArGCH.setRotationPoint(1.5F, 12.0F, 7.0F);
    this.patteArGCH.setTextureSize(128, 64);
    this.patteArGCH.mirror = true;
    setRotation(this.patteArGCH, 0.0F, 0.0F, 0.0F);
    this.patteAvDr = new ModelRenderer(this, 0, 32);
    this.patteAvDr.addBox(-1.0F, 0.0F, -1.0F, 3, 11, 3);
    this.patteAvDr.setRotationPoint(-4.5F, 13.0F, -6.0F);
    this.patteAvDr.setTextureSize(128, 64);
    this.patteAvDr.mirror = true;
    setRotation(this.patteAvDr, 0.0F, 0.0F, 0.0F);
    this.patteAvGCH = new ModelRenderer(this, 0, 32);
    this.patteAvGCH.addBox(-1.0F, 0.0F, -1.0F, 3, 11, 3);
    this.patteAvGCH.setRotationPoint(1.5F, 13.0F, -6.0F);
    this.patteAvGCH.setTextureSize(128, 64);
    this.patteAvGCH.mirror = true;
    setRotation(this.patteAvGCH, 0.0F, 0.0F, 0.0F);
    this.queue = new ModelRenderer(this, 0, 53);
    this.queue.addBox(-1.0F, 0.0F, -1.0F, 2, 9, 2);
    this.queue.setRotationPoint(-1.0F, 8.0F, 11.0F);
    this.queue.setTextureSize(128, 64);
    this.queue.mirror = true;
    setRotation(this.queue, 1.130069F, 0.0F, 0.0F);
    this.oreilleDR = new ModelRenderer(this, 24, 16);
    this.oreilleDR.addBox(-5.0F, -5.0F, 0.0F, 3, 3, 1);
    this.oreilleDR.setRotationPoint(-1.0F, 9.5F, -11.0F);
    this.oreilleDR.setTextureSize(128, 64);
    this.oreilleDR.mirror = true;
    setRotation(this.oreilleDR, 0.0F, 0.0F, 0.0F);
    this.oreilleGCH = new ModelRenderer(this, 16, 16);
    this.oreilleGCH.addBox(2.0F, -5.0F, 0.0F, 3, 3, 1);
    this.oreilleGCH.setRotationPoint(-1.0F, 9.5F, -11.0F);
    this.oreilleGCH.setTextureSize(128, 64);
    this.oreilleGCH.mirror = true;
    setRotation(this.oreilleGCH, 0.0F, 0.0F, 0.0F);
    this.museau = new ModelRenderer(this, 0, 8);
    this.museau.addBox(-3.0F, -1.0F, -8.0F, 5, 2, 5);
    this.museau.setRotationPoint(-0.5F, 10.5F, -12.0F);
    this.museau.setTextureSize(128, 64);
    this.museau.mirror = true;
    setRotation(this.museau, 0.0F, 0.0F, 0.0F);
  }

  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5);
    this.museaubas.render(f5);
    this.tete.render(f5);
    this.corps.render(f5);
    this.torse.render(f5);
    this.patteArDr.render(f5);
    this.patteArGCH.render(f5);
    this.patteAvDr.render(f5);
    this.patteAvGCH.render(f5);
    this.queue.render(f5);
    this.oreilleDR.render(f5);
    this.oreilleGCH.render(f5);
    this.museau.render(f5);
  }

  private void setRotation(ModelRenderer model, float x, float y, float z)
  {
    model.rotateAngleX = x;
    model.rotateAngleY = y;
    model.rotateAngleZ = z;
  }

  public void setRotationAngles(float var1, float var2, float var3, float var4, float var5, float var6)
  {
    this.patteAvDr.rotateAngleX = (MathHelper.cos(var1 * 0.6662F) * 1.4F * var2 / 2.0F);
    this.patteAvGCH.rotateAngleX = (-(MathHelper.cos(var1 * 0.6662F) * 1.4F * var2 / 2.0F));
    this.patteArDr.rotateAngleX = (-(MathHelper.cos(var1 * 0.6662F) * 1.4F * var2 / 2.0F));
    this.patteArGCH.rotateAngleX = (MathHelper.cos(var1 * 0.6662F) * 1.4F * var2 / 2.0F);

    this.tete.rotateAngleX = (var5 / 57.295776F);
    this.tete.rotateAngleY = (var4 / 57.295776F);
    this.museau.rotateAngleX = this.tete.rotateAngleX;
    this.museau.rotateAngleY = this.tete.rotateAngleY;
    this.museaubas.rotateAngleX = this.tete.rotateAngleX;
    this.museaubas.rotateAngleY = this.tete.rotateAngleY;
    super.setRotationAngles(var1, var2, var3, var4, var5, var6, (Entity)null);
  }
}