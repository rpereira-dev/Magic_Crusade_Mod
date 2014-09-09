package fr.toss.client.model.entity;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;


public class ModelStymph extends ModelBase
{
  ModelRenderer corps;
  ModelRenderer croupion;
  ModelRenderer patteDR;
  ModelRenderer patteGCH;
  ModelRenderer cou;
  ModelRenderer tete;
  ModelRenderer bec;
  ModelRenderer remigeGCH;
  ModelRenderer remigeDR;
  ModelRenderer aileDR;
  ModelRenderer aileGCH;

  public ModelStymph()
  {
    this.textureWidth = 64;
    this.textureHeight = 32;
    this.corps = new ModelRenderer(this, 46, 14);
    this.corps.addBox(-2.0F, 5.0F, -10.0F, 4, 10, 5);
    this.corps.setRotationPoint(0.0F, 0.0F, 0.0F);
    this.corps.setTextureSize(64, 32);
    this.corps.mirror = true;
    setRotation(this.corps, 0.5235988F, 0.0F, 0.0F);
    this.croupion = new ModelRenderer(this, 0, 0);
    this.croupion.addBox(-2.0F, -4.0F, -18.0F, 4, 8, 4);
    this.croupion.setRotationPoint(0.0F, 0.0F, 0.0F);
    this.croupion.setTextureSize(64, 32);
    this.croupion.mirror = true;
    setRotation(this.croupion, 1.745329F, 0.0F, 0.0F);
    this.patteDR = new ModelRenderer(this, 22, 0);
    this.patteDR.addBox(4.0F, 15.0F, 3.0F, 1, 8, 1);
    this.patteDR.setRotationPoint(0.0F, 0.0F, 0.0F);
    this.patteDR.setTextureSize(64, 32);
    this.patteDR.mirror = true;
    setRotation(this.patteDR, 0.0F, 0.0F, 0.349066F);
    this.patteGCH = new ModelRenderer(this, 22, 0);
    this.patteGCH.addBox(-5.0F, 15.0F, 3.0F, 1, 8, 1);
    this.patteGCH.setRotationPoint(0.0F, 0.0F, 0.0F);
    this.patteGCH.setTextureSize(64, 32);
    this.patteGCH.mirror = true;
    setRotation(this.patteGCH, 0.0F, 0.0F, -0.349066F);
    this.cou = new ModelRenderer(this, 42, 0);
    this.cou.addBox(-1.0F, 3.0F, -6.5F, 2, 6, 2);
    this.cou.setRotationPoint(0.0F, 0.0F, 0.0F);
    this.cou.setTextureSize(64, 32);
    this.cou.mirror = true;
    setRotation(this.cou, 0.1745329F, 0.0F, 0.0F);
    this.tete = new ModelRenderer(this, 50, 0);
    this.tete.addBox(-1.5F, -2.0F, -2.0F, 3, 4, 4);
    this.tete.setRotationPoint(0.0F, 3.0F, -5.0F);
    this.tete.setTextureSize(64, 32);
    this.tete.mirror = true;
    setRotation(this.tete, 0.0F, 0.0F, 0.0F);
    this.bec = new ModelRenderer(this, 52, 8);
    this.bec.addBox(-1.0F, -1.0F, -5.0F, 2, 2, 4);
    this.bec.setRotationPoint(0.0F, 3.0F, -5.0F);
    this.bec.setTextureSize(64, 32);
    this.bec.mirror = true;
    setRotation(this.bec, 0.1745329F, 0.0F, 0.0F);
    this.remigeGCH = new ModelRenderer(this, 0, 0);
    this.remigeGCH.addBox(0.0F, 0.0F, 0.0F, 1, 1, 20);
    this.remigeGCH.setRotationPoint(1.0F, 7.0F, -2.0F);
    this.remigeGCH.setTextureSize(64, 32);
    this.remigeGCH.mirror = true;
    setRotation(this.remigeGCH, 0.261799F, 0.4363323F, 0.0F);
    this.remigeDR = new ModelRenderer(this, 0, 0);
    this.remigeDR.addBox(-1.0F, 0.0F, 0.0F, 1, 1, 20);
    this.remigeDR.setRotationPoint(-1.0F, 7.0F, -2.0F);
    this.remigeDR.setTextureSize(64, 32);
    this.remigeDR.mirror = true;
    setRotation(this.remigeDR, 0.261799F, -0.4363323F, 0.0F);
    this.aileDR = new ModelRenderer(this, 0, 4);
    this.aileDR.addBox(-0.5F, 0.0F, 0.0F, 0, 8, 20);
    this.aileDR.setRotationPoint(-1.0F, 7.0F, -2.0F);
    this.aileDR.setTextureSize(64, 32);
    this.aileDR.mirror = true;
    setRotation(this.aileDR, 0.261799F, -0.4363323F, 0.0F);
    this.aileGCH = new ModelRenderer(this, 0, 4);
    this.aileGCH.addBox(0.5F, 0.0F, 0.0F, 0, 8, 20);
    this.aileGCH.setRotationPoint(1.0F, 7.0F, -2.0F);
    this.aileGCH.setTextureSize(64, 32);
    this.aileGCH.mirror = true;
    setRotation(this.aileGCH, 0.261799F, 0.4363323F, 0.0F);
  }

  @Override
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5);
    this.corps.render(f5);
    this.croupion.render(f5);
    this.patteDR.render(f5);
    this.patteGCH.render(f5);
    this.cou.render(f5);
    this.tete.render(f5);
    this.bec.render(f5);
    this.remigeGCH.render(f5);
    this.remigeDR.render(f5);
    this.aileDR.render(f5);
    this.aileGCH.render(f5);
  }

  private void setRotation(ModelRenderer model, float x, float y, float z)
  {
	    model.rotateAngleX = x;
	    model.rotateAngleY = y;
	    model.rotateAngleZ = z;
	    
//    model.rotateAngleX = x;
//    model.rotateAngleY = y;
//    model.rotateAngleZ = z;
  }

  public void setRotationAngles(float var1, float var2, float var3, float var4, float var5, float var6)
  {
    this.patteDR.rotateAngleX = (MathHelper.cos(var1 * 0.6662F) * 1.4F * var2 / 3.0F);
    this.patteGCH.rotateAngleX = (-(MathHelper.cos(var1 * 0.6662F) * 1.4F * var2 / 3.0F));
    this.tete.rotateAngleX = (var5 / 57.295776F + 0.5F);
    this.tete.rotateAngleY = (var4 / 57.295776F);
    this.bec.rotateAngleX = this.tete.rotateAngleX;
    this.bec.rotateAngleY = this.tete.rotateAngleY;
    this.aileDR.rotateAngleZ = (-(MathHelper.cos(var1 * 0.6662F) * 1.4F * var2 / 3.0F));
    this.aileGCH.rotateAngleZ = (MathHelper.cos(var1 * 0.6662F) * 1.4F * var2 / 3.0F);
    this.remigeDR.rotateAngleZ = (-(MathHelper.cos(var1 * 0.6662F) * 1.4F * var2 / 3.0F));
    this.remigeGCH.rotateAngleZ = (MathHelper.cos(var1 * 0.6662F) * 1.4F * var2 / 3.0F);
    super.setRotationAngles(var1, var2, var3, var4, var5, var6, (Entity)null);
  }
}