package fr.toss.client.model.entity;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelBelier extends ModelBase
{
  ModelRenderer tete2;
  ModelRenderer Shape1;
  ModelRenderer Shape11;
  ModelRenderer Shape2;
  ModelRenderer Shape21;
  ModelRenderer tete;
  ModelRenderer corps;
  ModelRenderer patteArDR;
  ModelRenderer patteArGCH;
  ModelRenderer patteAvDR;
  ModelRenderer patteAvGCH;
  ModelRenderer patte2ArDr;
  ModelRenderer patte2ArGCH;
  ModelRenderer patte2AvDR;
  ModelRenderer patte2AvGCH;

  public ModelBelier()
  {
    this.textureWidth = 64;
    this.textureHeight = 32;

    this.tete2 = new ModelRenderer(this, 27, 15);
    this.tete2.addBox(-4.5F, -4.5F, -7.5F, 7, 7, 7);
    this.tete2.setRotationPoint(1.0F, 10.6F, -7.0F);
    this.tete2.setTextureSize(64, 32);
    this.tete2.mirror = true;
    setRotation(this.tete2, 0.0F, 0.0F, 0.0F);
    this.Shape1 = new ModelRenderer(this, 0, 0);
    this.Shape1.addBox(2.3F, -4.0F, -6.0F, 1, 4, 4);
    this.Shape1.setRotationPoint(1.0F, 10.6F, -7.0F);
    this.Shape1.setTextureSize(64, 32);
    this.Shape1.mirror = true;
    setRotation(this.Shape1, 0.0F, 0.0F, 0.0F);
    this.Shape11 = new ModelRenderer(this, 0, 0);
    this.Shape11.addBox(-5.3F, -4.0F, -6.0F, 1, 4, 4);
    this.Shape11.setRotationPoint(1.0F, 10.6F, -7.0F);
    this.Shape11.setTextureSize(64, 32);
    this.Shape11.mirror = true;
    setRotation(this.Shape1, 0.0F, 0.0F, 0.0F);
    this.Shape2 = new ModelRenderer(this, 0, 0);
    this.Shape2.addBox(-6.0F, -3.5F, -5.5F, 1, 3, 3);
    this.Shape2.setRotationPoint(1.0F, 10.6F, -7.0F);
    this.Shape2.setTextureSize(64, 32);
    this.Shape2.mirror = true;
    setRotation(this.Shape2, 0.0F, 0.0F, 0.0F);
    this.Shape21 = new ModelRenderer(this, 0, 0);
    this.Shape21.addBox(3.0F, -3.5F, -5.5F, 1, 3, 3);
    this.Shape21.setRotationPoint(1.0F, 10.6F, -7.0F);
    this.Shape21.setTextureSize(64, 32);
    this.Shape21.mirror = true;
    setRotation(this.Shape2, 0.0F, 0.0F, 0.0F);
    this.tete = new ModelRenderer(this, 0, 0);
    this.tete.addBox(-4.0F, -4.0F, -8.0F, 6, 6, 8);
    this.tete.setRotationPoint(1.0F, 10.6F, -7.0F);
    this.tete.setTextureSize(64, 32);
    this.tete.mirror = true;
    setRotation(this.tete, 0.0F, 0.0F, 0.0F);
    this.corps = new ModelRenderer(this, 24, 5);
    this.corps.addBox(-7.0F, -9.0F, -7.0F, 12, 19, 8);
    this.corps.setRotationPoint(1.0F, 9.0F, 0.0F);
    this.corps.setTextureSize(64, 32);
    this.corps.mirror = true;
    setRotation(this.corps, 1.570796F, 0.0F, 0.0F);
    this.patteArDR = new ModelRenderer(this, 0, 17);
    this.patteArDR.addBox(-2.0F, 0.0F, -2.0F, 4, 11, 4);
    this.patteArDR.setRotationPoint(-3.0F, 13.0F, 7.0F);
    this.patteArDR.setTextureSize(64, 32);
    this.patteArDR.mirror = true;
    setRotation(this.patteArDR, 0.0F, 0.0F, 0.0F);
    this.patteArGCH = new ModelRenderer(this, 0, 17);
    this.patteArGCH.addBox(-2.0F, 0.0F, -2.0F, 4, 11, 4);
    this.patteArGCH.setRotationPoint(3.0F, 13.0F, 7.0F);
    this.patteArGCH.setTextureSize(64, 32);
    this.patteArGCH.mirror = true;
    setRotation(this.patteArGCH, 0.0F, 0.0F, 0.0F);
    this.patteAvDR = new ModelRenderer(this, 0, 17);
    this.patteAvDR.addBox(-2.0F, 0.0F, -2.0F, 4, 11, 4);
    this.patteAvDR.setRotationPoint(-3.0F, 13.0F, -5.0F);
    this.patteAvDR.setTextureSize(64, 32);
    this.patteAvDR.mirror = true;
    setRotation(this.patteAvDR, 0.0F, 0.0F, 0.0F);
    this.patteAvGCH = new ModelRenderer(this, 0, 17);
    this.patteAvGCH.addBox(-2.0F, 0.0F, -2.0F, 4, 11, 4);
    this.patteAvGCH.setRotationPoint(3.0F, 13.0F, -5.0F);
    this.patteAvGCH.setTextureSize(64, 32);
    this.patteAvGCH.mirror = true;
    setRotation(this.patteAvGCH, 0.0F, 0.0F, 0.0F);
    this.patte2ArDr = new ModelRenderer(this, 30, 0);
    this.patte2ArDr.addBox(-2.5F, -1.0F, -2.5F, 5, 8, 5);
    this.patte2ArDr.setRotationPoint(-3.0F, 13.0F, 7.0F);
    this.patte2ArDr.setTextureSize(64, 32);
    this.patte2ArDr.mirror = true;
    setRotation(this.patte2ArDr, 0.0F, 0.0F, 0.0F);
    this.patte2ArGCH = new ModelRenderer(this, 30, 0);
    this.patte2ArGCH.addBox(-2.5F, -1.0F, -2.5F, 5, 8, 5);
    this.patte2ArGCH.setRotationPoint(3.0F, 13.0F, 7.0F);
    this.patte2ArGCH.setTextureSize(64, 32);
    this.patte2ArGCH.mirror = true;
    setRotation(this.patte2ArGCH, 0.0F, 0.0F, 0.0F);
    this.patte2AvDR = new ModelRenderer(this, 30, 0);
    this.patte2AvDR.addBox(-2.5F, -1.0F, -2.5F, 5, 8, 5);
    this.patte2AvDR.setRotationPoint(-3.0F, 13.0F, -5.0F);
    this.patte2AvDR.setTextureSize(64, 32);
    this.patte2AvDR.mirror = true;
    setRotation(this.patte2AvDR, 0.0F, 0.0F, 0.0F);
    this.patte2AvGCH = new ModelRenderer(this, 30, 0);
    this.patte2AvGCH.addBox(-2.5F, -1.0F, -2.5F, 5, 8, 5);
    this.patte2AvGCH.setRotationPoint(3.0F, 13.0F, -5.0F);
    this.patte2AvGCH.setTextureSize(64, 32);
    this.patte2AvGCH.mirror = true;
    setRotation(this.patte2AvGCH, 0.0F, 0.0F, 0.0F);
  }

  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5);
    this.tete2.render(f5);
    this.Shape1.render(f5);
    this.Shape1.render(f5);
    this.Shape2.render(f5);
    this.Shape2.render(f5);
    this.tete.render(f5);
    this.corps.render(f5);
    this.patteArDR.render(f5);
    this.patteArGCH.render(f5);
    this.patteAvDR.render(f5);
    this.patteAvGCH.render(f5);
    this.patte2ArDr.render(f5);
    this.patte2ArGCH.render(f5);
    this.patte2AvDR.render(f5);
    this.patte2AvGCH.render(f5);
  }

  private void setRotation(ModelRenderer model, float x, float y, float z)
  {
    model.rotateAngleX = x;
    model.rotateAngleY = y;
    model.rotateAngleZ = z;
  }

  public void setRotationAngles(float var1, float var2, float var3, float var4, float var5, float var6)
  {
    this.patteAvDR.rotateAngleX = (MathHelper.cos(var1 * 0.6662F) * 1.4F * var2 / 3.0F);
    this.patteAvGCH.rotateAngleX = (-(MathHelper.cos(var1 * 0.6662F) * 1.4F * var2 / 3.0F));
    this.patteArDR.rotateAngleX = (-(MathHelper.cos(var1 * 0.6662F) * 1.4F * var2 / 3.0F));
    this.patteArGCH.rotateAngleX = (MathHelper.cos(var1 * 0.6662F) * 1.4F * var2 / 3.0F);

    super.setRotationAngles(var1, var2, var3, var4, var5, var6, (Entity)null);
  }
}