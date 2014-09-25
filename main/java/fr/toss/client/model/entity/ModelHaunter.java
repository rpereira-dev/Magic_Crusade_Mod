package fr.toss.client.model.entity;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelHaunter extends ModelBase
{
    ModelRenderer bodyLow;
    ModelRenderer armLeft;
    ModelRenderer armRight;
    ModelRenderer head;
    ModelRenderer body;
    ModelRenderer rightarm;
    ModelRenderer leftarm;
    ModelRenderer rightleg;
    ModelRenderer leftleg;
  
  public ModelHaunter()
  {
    textureWidth = 256;
    textureHeight = 128;
    
      bodyLow = new ModelRenderer(this, 0, 32);
      bodyLow.addBox(-2.5F, 5F, -2F, 5, 8, 4);
      bodyLow.setRotationPoint(0F, 0F, 0F);
      bodyLow.setTextureSize(256, 128);
      bodyLow.mirror = true;
      setRotation(bodyLow, 0F, 0F, 0F);
      armLeft = new ModelRenderer(this, 18, 26);
      armLeft.addBox(0F, 6F, -1F, 2, 8, 2);
      armLeft.setRotationPoint(5F, 2F, 0F);
      armLeft.setTextureSize(256, 128);
      armLeft.mirror = true;
      setRotation(armLeft, 0F, 0F, 5.5F);
      armRight = new ModelRenderer(this, 26, 26);
      armRight.addBox(-2F, 6F, -1F, 2, 8, 2);
      armRight.setRotationPoint(-5F, 2F, 0F);
      armRight.setTextureSize(256, 128);
      armRight.mirror = true;
      setRotation(armRight, 0F, 0F, -5.5F);
      head = new ModelRenderer(this, 0, 0);
      head.addBox(-4F, -8F, -4F, 8, 8, 8);
      head.setRotationPoint(0F, 0F, 0F);
      head.setTextureSize(256, 128);
      head.mirror = true;
      setRotation(head, 0F, 0F, 0F);
      body = new ModelRenderer(this, 16, 16);
      body.addBox(-5F, 0F, -2.1F, 10, 6, 4);
      body.setRotationPoint(0F, 0F, 0F);
      body.setTextureSize(256, 128);
      body.mirror = true;
      setRotation(body, 0F, 0F, 0F);
      rightarm = new ModelRenderer(this, 44, 16);
      rightarm.addBox(-4F, -1F, -3F, 6, 8, 6);
      rightarm.setRotationPoint(-5F, 2F, 0F);
      rightarm.setTextureSize(256, 128);
      rightarm.mirror = true;
      setRotation(rightarm, 0F, 0F, 45F);
      leftarm = new ModelRenderer(this, 44, 30);
      leftarm.addBox(-2F, -1F, -3F, 6, 8, 6);
      leftarm.setRotationPoint(5F, 2F, 0F);
      leftarm.setTextureSize(256, 128);
      leftarm.mirror = true;
      setRotation(leftarm, 0F, 0F, -45F);
      rightleg = new ModelRenderer(this, 0, 16);
      rightleg.addBox(-1F, 0F, -2.1F, 3, 12, 4);
      rightleg.setRotationPoint(-2F, 12F, 0F);
      rightleg.setTextureSize(256, 128);
      rightleg.mirror = true;
      setRotation(rightleg, 0F, 0F, 0F);
      leftleg = new ModelRenderer(this, 0, 16);
      leftleg.addBox(-2F, 0F, -2.1F, 3, 12, 4);
      leftleg.setRotationPoint(2F, 12F, 0F);
      leftleg.setTextureSize(256, 128);
      leftleg.mirror = true;
      setRotation(leftleg, 0F, 0F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5);
    bodyLow.render(f5);
    armLeft.render(f5);
    armRight.render(f5);
    head.render(f5);
    body.render(f5);
    rightarm.render(f5);
    leftarm.render(f5);
    rightleg.render(f5);
    leftleg.render(f5);
  }
  
  private void setRotation(ModelRenderer model, float x, float y, float z)
  {
    model.rotateAngleX = x;
    model.rotateAngleY = y;
    model.rotateAngleZ = z;
  }
  
  public void setRotationAngles(float var1, float var2, float var3, float var4, float var5, float var6)
  {
    this.rightleg.rotateAngleX = MathHelper.cos(var1 * 0.6662F) * 1.4F * var2;
    this.leftleg.rotateAngleX = -MathHelper.cos(var1 * 0.6662F) * 1.4F * var2;

    this.rightarm.rotateAngleX = MathHelper.cos(var1 * 0.6662F) * 1.4F * var2;
    this.leftarm.rotateAngleX = -MathHelper.cos(var1 * 0.6662F) * 1.4F * var2;
    this.armRight.rotateAngleX = MathHelper.cos(var1 * 0.6662F) * 1.4F * var2;
    this.armLeft.rotateAngleX = -MathHelper.cos(var1 * 0.6662F) * 1.4F * var2;
    
    this.body.rotateAngleX = MathHelper.cos(var1 * 0.3f) * 0.5f * var2;
    this.bodyLow.rotateAngleX = MathHelper.cos(var1 * 0.3f) * 0.5f * var2;

    this.head.rotateAngleX = (var5 / 57.295776F);
    this.head.rotateAngleY = (var4 / 57.295776F);
  }

}
