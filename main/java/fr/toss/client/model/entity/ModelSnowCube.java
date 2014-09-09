package fr.toss.client.model.entity;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelSnowCube extends ModelBase
{
	ModelRenderer  Corps;
	ModelRenderer  AileGCH;
	ModelRenderer  AileDR;

  public ModelSnowCube()
  {
    this.textureWidth  = 128;
    this.textureHeight = 64;
    
    this.Corps = new ModelRenderer(this, 0, 0);
    this.Corps.addBox(-8.0F, -8.0F, -8.0F, 16, 16, 16);
    this.Corps.setRotationPoint(0.0F, 0.0F, 0.0F);
    this.Corps.setTextureSize(128, 64);
    this.Corps.mirror = true;
    setRotation(this.Corps, 0.0F, 0.0F, 0.0F);
    
    this.AileGCH = new ModelRenderer(this, 0, 38);
    this.AileGCH.addBox(8.0F, 0.0F, -3.0F, 16, 0, 6);
    this.AileGCH.setRotationPoint(0.0F, 0.0F, 0.0F);
    this.AileGCH.setTextureSize(128, 64);
    this.AileGCH.mirror = false;
    setRotation(this.AileGCH, 0.0F, 0.0F, -0.349066F);
    
    this.AileDR = new ModelRenderer(this, 0, 32);
    this.AileDR.addBox(-24.0F, 0.0F, -3.0F, 16, 0, 6);
    this.AileDR.setRotationPoint(0.0F, 0.0F, 0.0F);
    this.AileDR.setTextureSize(128, 64);
    this.AileDR.mirror = false;
    setRotation(this.AileDR, 0.0F, 0.0F, 0.349066F);
  }

  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5);
    this.Corps.render(f5);
    this.AileGCH.render(f5);
    this.AileDR.render(f5);
  }

  private void setRotation(ModelRenderer model, float x, float y, float z)
  {
    model.rotateAngleX = x;
    model.rotateAngleY = y;
    model.rotateAngleZ = z;
  }
  

  public void setRotationAngles(float var1, float var2, float var3, float var4, float var5, float var6)
  {
    this.AileDR.rotateAngleZ = (-(MathHelper.cos(var1 * 0.6662F) * 1.4F * var2 / 3.0F));
    this.AileGCH.rotateAngleZ = (MathHelper.cos(var1 * 0.6662F) * 1.4F * var2 / 3.0F);

    super.setRotationAngles(var1, var2, var3, var4, var5, var6, (Entity)null);
  }
}