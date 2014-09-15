package fr.toss.client.model.entity;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.MathHelper;
import fr.toss.common.entity.EntityArkavon;


public class ModelArkavon extends ModelBase
{
  ModelRenderer JambeGCH1;
  ModelRenderer JambeDR1;
  ModelRenderer JambeGCH2;
  ModelRenderer JambeDR2;
  ModelRenderer JambeGCH3;
  ModelRenderer JambeDR3;
  ModelRenderer JambeDR4;
  ModelRenderer JambeGCH4;
  ModelRenderer JambeGCH5;
  ModelRenderer JambeDR5;
  ModelRenderer JambeGCH6;
  ModelRenderer JambeDR6;
  ModelRenderer JambeDR7;
  ModelRenderer JambeGCH7;
  ModelRenderer Corps1;
  ModelRenderer Corps2;
  ModelRenderer BrasGCH1;
  ModelRenderer BrasDR1;
  ModelRenderer BrasGCH2;
  ModelRenderer BrasDR2;
  ModelRenderer BrasGCH3;
  ModelRenderer BrasGCH4;
  ModelRenderer BrasDR3;
  ModelRenderer BrasGCH5;
  ModelRenderer BrasDR4;
  ModelRenderer BrasDR5;
  ModelRenderer BrasDR6;
  ModelRenderer BrasDR7;
  ModelRenderer Tete1;
  ModelRenderer Tete2;
  ModelRenderer Tete3;
  ModelRenderer Corps3;
  ModelRenderer Tete4;

  public ModelArkavon()
  {
    this.textureWidth = 512;
    this.textureHeight = 512;

    this.JambeGCH1 = new ModelRenderer(this, 0, 24);
    this.JambeGCH1.addBox(7.0F, 52.0F, -9.0F, 10, 7, 17);
    this.JambeGCH1.setRotationPoint(.0F, -35.0F, 0.0F);
    this.JambeGCH1.setTextureSize(512, 512);
    this.JambeGCH1.mirror= true;
    setRotation(this.JambeGCH1, 0.0F, 0.0F, 0.0F);
    this.JambeDR1 = new ModelRenderer(this, 0, 0);
    this.JambeDR1.addBox(-17.0F, 52.0F, -9.0F, 10, 7, 17);
    this.JambeDR1.setRotationPoint(.0F, -35.0F, 0.0F);
    this.JambeDR1.setTextureSize(512, 512);
    this.JambeDR1.mirror= true;
    setRotation(this.JambeDR1, 0.0F, 0.0F, 0.0F);
    this.JambeGCH2 = new ModelRenderer(this, 54, 17);
    this.JambeGCH2.addBox(7.5F, 51.0F, -6.0F, 9, 2, 14);
    this.JambeGCH2.setRotationPoint(.0F, -35.0F, 0.0F);
    this.JambeGCH2.setTextureSize(512, 512);
    this.JambeGCH2.mirror= true;
    setRotation(this.JambeGCH2, 0.0F, 0.0F, 0.0F);
    this.JambeDR2 = new ModelRenderer(this, 55, 0);
    this.JambeDR2.addBox(-16.5F, 51.0F, -6.0F, 9, 2, 14);
    this.JambeDR2.setRotationPoint(.0F, -35.0F, 0.0F);
    this.JambeDR2.setTextureSize(512, 512);
    this.JambeDR2.mirror= true;
    setRotation(this.JambeDR2, 0.0F, 0.0F, 0.0F);
    this.JambeGCH3 = new ModelRenderer(this, 361, 33);
    this.JambeGCH3.addBox(8.0F, 30.0F, -3.0F, 8, 21, 10);
    this.JambeGCH3.setRotationPoint(.0F, -35.0F, 0.0F);
    this.JambeGCH3.setTextureSize(512, 512);
    this.JambeGCH3.mirror= true;
    setRotation(this.JambeGCH3, 0.0F, 0.0F, 0.0F);
    this.JambeDR3 = new ModelRenderer(this, 361, 0);
    this.JambeDR3.addBox(-16.0F, 30.0F, -3.0F, 8, 21, 10);
    this.JambeDR3.setRotationPoint(.0F, -35.0F, 0.0F);
    this.JambeDR3.setTextureSize(512, 512);
    this.JambeDR3.mirror= true;
    setRotation(this.JambeDR3, 0.0F, 0.0F, 0.0F);
    this.JambeDR4 = new ModelRenderer(this, 335, 0);
    this.JambeDR4.addBox(-14.5F, 28.0F, -11.0F, 5, 16, 7);
    this.JambeDR4.setRotationPoint(.0F, -35.0F, 0.0F);
    this.JambeDR4.setTextureSize(512, 512);
    this.JambeDR4.mirror= true;
    setRotation(this.JambeDR4, 0.1745329F, 0.0F, 0.0F);
    this.JambeGCH4 = new ModelRenderer(this, 335, 25);
    this.JambeGCH4.addBox(9.5F, 28.0F, -11.0F, 5, 16, 7);
    this.JambeGCH4.setRotationPoint(.0F, -35.0F, 0.0F);
    this.JambeGCH4.setTextureSize(512, 512);
    this.JambeGCH4.mirror= true;
    setRotation(this.JambeGCH4, 0.1745329F, 0.0F, 0.0F);
    this.JambeGCH5 = new ModelRenderer(this, 440, 0);
    this.JambeGCH5.addBox(7.0F, 0.0F, -5.0F, 10, 30, 12);
    this.JambeGCH5.setRotationPoint(.0F, -35.0F, 0.0F);
    this.JambeGCH5.setTextureSize(512, 512);
    this.JambeGCH5.mirror= true;
    setRotation(this.JambeGCH5, 0.0F, -0.1745329F, 0.0F);
    this.JambeDR5 = new ModelRenderer(this, 400, 0);
    this.JambeDR5.addBox(-18.0F, 5.0F, -6.0F, 9, 20, 10);
    this.JambeDR5.setRotationPoint(.0F, -35.0F, 0.0F);
    this.JambeDR5.setTextureSize(512, 512);
    this.JambeDR5.mirror= true;
    setRotation(this.JambeDR5, 0.0F, 0.1745329F, 0.0F);
    this.JambeGCH6 = new ModelRenderer(this, 400, 32);
    this.JambeGCH6.addBox(9.0F, 4.0F, -6.0F, 9, 20, 10);
    this.JambeGCH6.setRotationPoint(.0F, -35.0F, 0.0F);
    this.JambeGCH6.setTextureSize(512, 512);
    this.JambeGCH6.mirror= true;
    setRotation(this.JambeGCH6, 0.0F, -0.1745329F, 0.0F);
    this.JambeDR6 = new ModelRenderer(this, 440, 43);
    this.JambeDR6.addBox(-17.0F, 0.0F, -5.0F, 10, 30, 12);
    this.JambeDR6.setRotationPoint(.0F, -35.0F, 0.0F);
    this.JambeDR6.setTextureSize(512, 512);
    this.JambeDR6.mirror= true;
    setRotation(this.JambeDR6, 0.0F, 0.1745329F, 0.0F);
    this.JambeDR7 = new ModelRenderer(this, 486, 0);
    this.JambeDR7.addBox(-8.0F, -6.0F, -3.0F, 5, 16, 8);
    this.JambeDR7.setRotationPoint(.0F, -35.0F, 0.0F);
    this.JambeDR7.setTextureSize(512, 512);
    this.JambeDR7.mirror= true;
    setRotation(this.JambeDR7, 0.0F, 0.1745329F, 0.4363323F);
    this.JambeGCH7 = new ModelRenderer(this, 486, 25);
    this.JambeGCH7.addBox(3.0F, -6.0F, -3.0F, 5, 16, 8);
    this.JambeGCH7.setRotationPoint(.0F, -35.0F, 0.0F);
    this.JambeGCH7.setTextureSize(512, 512);
    this.JambeGCH7.mirror= true;
    setRotation(this.JambeGCH7, 0.0F, -0.1745329F, -0.4363323F);
    this.Corps1 = new ModelRenderer(this, 0, 438);
    this.Corps1.addBox(-14.0F, -2.0F, -4.0F, 28, 18, 16);
    this.Corps1.setRotationPoint(.0F, -50.0F, 0.0F);
    this.Corps1.setTextureSize(512, 512);
    this.Corps1.mirror= true;
    setRotation(this.Corps1, 0.0F, 0.0F, 0.0F);
    this.Corps2 = new ModelRenderer(this, 0, 473);
    this.Corps2.addBox(-16.0F, -21.0F, -6.0F, 32, 20, 19);
    this.Corps2.setRotationPoint(.0F, -50.0F, 0.0F);
    this.Corps2.setTextureSize(512, 512);
    this.Corps2.mirror= true;
    setRotation(this.Corps2, 0.0F, 0.0F, 0.0F);
    this.BrasGCH1 = new ModelRenderer(this, 71, 346);
    this.BrasGCH1.addBox(.0F, -8.0F, 0.0F, 18, 12, 17);
    this.BrasGCH1.setRotationPoint(9.0F, -71.0F, -7.0F);
    this.BrasGCH1.setTextureSize(512, 512);
    this.BrasGCH1.mirror= true;
    setRotation(this.BrasGCH1, 0.0F, 0.0F, -0.1745329F);
    this.BrasDR1 = new ModelRenderer(this, 0, 346);
    this.BrasDR1.addBox(-18.0F, -8.0F, 0.0F, 18, 12, 17);
    this.BrasDR1.setRotationPoint(-9.0F, -71.0F, -7.0F);
    this.BrasDR1.setTextureSize(512, 512);
    this.BrasDR1.mirror= true;
    setRotation(this.BrasDR1, -0.0872665F, 0.0F, 0.1745329F);
    this.BrasGCH2 = new ModelRenderer(this, 53, 307);
    this.BrasGCH2.addBox(6.0F, 0.0F, 2.0F, 11, 22, 15);
    this.BrasGCH2.setRotationPoint(9.0F, -71.0F, -7.0F);
    this.BrasGCH2.setTextureSize(512, 512);
    this.BrasGCH2.mirror= true;
    setRotation(this.BrasGCH2, 0.0F, 0.0F, -0.349066F);
    this.BrasDR2 = new ModelRenderer(this, 0, 306);
    this.BrasDR2.addBox(-17.0F, 0.0F, 2.0F, 11, 24, 15);
    this.BrasDR2.setRotationPoint(-9.0F, -71.0F, -7.0F);
    this.BrasDR2.setTextureSize(512, 512);
    this.BrasDR2.mirror= true;
    setRotation(this.BrasDR2, 0.0F, 0.0F, 0.349066F);
    this.BrasGCH3 = new ModelRenderer(this, 0, 270);
    this.BrasGCH3.addBox(11.5F, 0.0F, 10.0F, 12, 22, 13);
    this.BrasGCH3.setRotationPoint(9.0F, -71.0F, -7.0F);
    this.BrasGCH3.setTextureSize(512, 512);
    this.BrasGCH3.mirror= true;
    setRotation(this.BrasGCH3, -0.7853982F, 0.0F, 0.0F);
    this.BrasGCH4 = new ModelRenderer(this, 0, 207);
    this.BrasGCH4.addBox(4.0F, -3.0F, -14.0F, 14, 60, 2);
    this.BrasGCH4.setRotationPoint(9.0F, -71.0F, -7.0F);
    this.BrasGCH4.setTextureSize(512, 512);
    this.BrasGCH4.mirror= true;
    setRotation(this.BrasGCH4, 0.1745329F, -0.0872665F, 0.0F);
    this.BrasGCH4.mirror= false;
    this.BrasDR3 = new ModelRenderer(this, 52, 271);
    this.BrasDR3.addBox(-24.0F, 1.0F, 12.0F, 12, 22, 12);
    this.BrasDR3.setRotationPoint(-9.0F, -71.0F, -7.0F);
    this.BrasDR3.setTextureSize(512, 512);
    this.BrasDR3.mirror= true;
    setRotation(this.BrasDR3, -0.7853982F, 0.0F, 0.0F);
    this.BrasGCH5 = new ModelRenderer(this, 33, 207);
    this.BrasGCH5.addBox(18.0F, -3.0F, -14.0F, 14, 60, 2);
    this.BrasGCH5.setRotationPoint(9.0F, -71.0F, -7.0F);
    this.BrasGCH5.setTextureSize(512, 512);
    this.BrasGCH5.mirror= true;
    setRotation(this.BrasGCH5, 0.1745329F, -0.0872665F, 0.0F);

    this.BrasDR4 = new ModelRenderer(this, 21, 193);
    this.BrasDR4.addBox(-19.0F, 28.0F, -5.0F, 3, 3, 8);
    this.BrasDR4.setRotationPoint(-9.0F, -71.0F, -7.0F);
    this.BrasDR4.setTextureSize(512, 512);
    this.BrasDR4.mirror= true;
    setRotation(this.BrasDR4, -0.1745329F, 0.0F, 0.0F);

    this.BrasDR5 = new ModelRenderer(this, 0, 195);
    this.BrasDR5.addBox(-20.0F, 27.0F, 3.0F, 5, 5, 5);
    this.BrasDR5.setRotationPoint(-9.0F, -71.0F, -7.0F);
    this.BrasDR5.setTextureSize(512, 512);
    this.BrasDR5.mirror= true;
    setRotation(this.BrasDR5, -0.1745329F, 0.0F, 0.0F);

    this.BrasDR6 = new ModelRenderer(this, 0, 176);
    this.BrasDR6.addBox(-19.5F, 23.0F, -9.0F, 4, 13, 4);
    this.BrasDR6.setRotationPoint(-9.0F, -71.0F, -7.0F);
    this.BrasDR6.setTextureSize(512, 512);
    this.BrasDR6.mirror= true;
    setRotation(this.BrasDR6, -0.1745329F, 0.0F, 0.0F);

    this.BrasDR7 = new ModelRenderer(this, 67, 208);
    this.BrasDR7.addBox(-17.5F, 25.0F, -60.0F, 0, 9, 52);
    this.BrasDR7.setRotationPoint(-9.0F, -71.0F, -7.0F);
    this.BrasDR7.setTextureSize(512, 512);
    this.BrasDR7.mirror= true;
    setRotation(this.BrasDR7, -0.1745329F, 0.0F, 0.0F);

    this.Tete1 = new ModelRenderer(this, 0, 397);
    this.Tete1.addBox(-7.0F, -43.0F, -4.0F, 14, 24, 16);
    this.Tete1.setRotationPoint(.0F, -50.0F, 0.0F);
    this.Tete1.setTextureSize(512, 512);
    this.Tete1.mirror= true;
    setRotation(this.Tete1, 0.0F, 0.0F, 0.0F);
    this.Tete2 = new ModelRenderer(this, 0, 376);
    this.Tete2.addBox(-7.0F, -29.0F, 0.1F, 14, 8, 12);
    this.Tete2.setRotationPoint(.0F, -50.0F, 0.0F);
    this.Tete2.setTextureSize(512, 512);
    this.Tete2.mirror= true;
    setRotation(this.Tete2, 0.0F, 0.0F, 0.349066F);
    this.Tete3 = new ModelRenderer(this, 52, 376);
    this.Tete3.addBox(-7.0F, -29.0F, 0.1F, 14, 8, 12);
    this.Tete3.setRotationPoint(.0F, -50.0F, 0.0F);
    this.Tete3.setTextureSize(512, 512);
    this.Tete3.mirror= true;
    setRotation(this.Tete3, 0.0F, 0.0F, -0.349066F);
    this.Corps3 = new ModelRenderer(this, 63, 55);
    this.Corps3.addBox(-7.0F, 14.0F, -2.0F, 14, 50, 0);
    this.Corps3.setRotationPoint(.0F, -50.0F, 0.0F);
    this.Corps3.setTextureSize(512, 512);
    this.Corps3.mirror= true;
    setRotation(this.Corps3, 0.0F, 0.0F, 0.0F);
    this.Tete4 = new ModelRenderer(this, 66, 206);
    this.Tete4.addBox(-6.0F, -58.0F, -3.0F, 12, 16, 14);
    this.Tete4.setRotationPoint(.0F, -50.0F, 0.0F);
    this.Tete4.setTextureSize(512, 512);
    this.Tete4.mirror= true;
    setRotation(this.Tete4, 0.0F, 0.0F, 0.0F);
  }

  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5);
    this.JambeGCH1.render(f5);
    this.JambeDR1.render(f5);
    this.JambeGCH2.render(f5);
    this.JambeDR2.render(f5);
    this.JambeGCH3.render(f5);
    this.JambeDR3.render(f5);
    this.JambeDR4.render(f5);
    this.JambeGCH4.render(f5);
    this.JambeGCH5.render(f5);
    this.JambeDR5.render(f5);
    this.JambeGCH6.render(f5);
    this.JambeDR6.render(f5);
    this.JambeDR7.render(f5);
    this.JambeGCH7.render(f5);
    this.Corps1.render(f5);
    this.Corps2.render(f5);
    this.BrasGCH1.render(f5);
    this.BrasDR1.render(f5);
    this.BrasGCH2.render(f5);
    this.BrasDR2.render(f5);
    this.BrasGCH3.render(f5);
    this.BrasGCH4.render(f5);
    this.BrasDR3.render(f5);
    this.BrasGCH5.render(f5);
    this.BrasDR4.render(f5);
    this.BrasDR5.render(f5);
    this.BrasDR6.render(f5);
    this.BrasDR7.render(f5);
    this.Tete1.render(f5);
    this.Tete2.render(f5);
    this.Tete3.render(f5);
    this.Corps3.render(f5);
    this.Tete4.render(f5);
  }

  private void setRotation(ModelRenderer model, float x, float y, float z)
  {
    model.rotateAngleX = x;
    model.rotateAngleY = y;
    model.rotateAngleZ = z;
  }

  public void setRotationAngles(float par1, float par2, float par3, float par4, float par5, float par6)
  {
    super.setRotationAngles(par1, par2, par3, par4, par5, par6, null);

    this.Tete1.rotateAngleY = (par4 / 57.295776F);
    this.Tete2.rotateAngleY = (par4 / 57.295776F);
    this.Tete3.rotateAngleY = (par4 / 57.295776F);
    this.Tete4.rotateAngleY = (par4 / 57.295776F);	

    this.JambeDR1.rotateAngleX = (MathHelper.cos(par1 * 0.6662F) * 0.7F * par2);
    this.JambeDR2.rotateAngleX = this.JambeDR1.rotateAngleX;
    this.JambeDR3.rotateAngleX = this.JambeDR1.rotateAngleX;
    this.JambeDR4.rotateAngleX = this.JambeDR1.rotateAngleX;
    this.JambeDR5.rotateAngleX = this.JambeDR1.rotateAngleX;
    this.JambeDR6.rotateAngleX = this.JambeDR1.rotateAngleX;
    this.JambeDR7.rotateAngleX = this.JambeDR1.rotateAngleX;

    this.JambeGCH1.rotateAngleX = (MathHelper.cos(par1 * 0.6662F + 3.141593F) * 0.7F * par2);
    this.JambeGCH2.rotateAngleX = this.JambeGCH1.rotateAngleX;
    this.JambeGCH3.rotateAngleX = this.JambeGCH1.rotateAngleX;
    this.JambeGCH4.rotateAngleX = this.JambeGCH1.rotateAngleX;
    this.JambeGCH5.rotateAngleX = this.JambeGCH1.rotateAngleX;
    this.JambeGCH6.rotateAngleX = this.JambeGCH1.rotateAngleX;
    this.JambeGCH7.rotateAngleX = this.JambeGCH1.rotateAngleX;

    float var8 = this.onGround;
    this.Corps1.rotateAngleY = (MathHelper.sin(MathHelper.sqrt_float(var8) * 3.141593F * 2.0F) * 0.2F);
    this.Corps2.rotateAngleY = this.Corps1.rotateAngleY;
    this.Corps3.rotateAngleY = this.Corps1.rotateAngleY;

    this.BrasDR1.rotateAngleX = (MathHelper.cos(par1 * 0.6662F + 3.141593F) * 2.0F * par2 * 0.5F);
    this.BrasDR2.rotateAngleX = (MathHelper.cos(par1 * 0.6662F + 3.141593F) * 2.0F * par2 * 0.5F);

    this.BrasDR3.rotateAngleX = (MathHelper.cos(par1 * 0.6662F + 3.141593F) * 2.0F * par2 * 0.5F - 0.8F);

    this.BrasDR4.rotateAngleX = (MathHelper.cos(par1 * 0.6662F + 3.141593F) * 2.0F * par2 * 0.5F - 0.1F);
    this.BrasDR5.rotateAngleX = this.BrasDR4.rotateAngleX;
    this.BrasDR6.rotateAngleX = this.BrasDR4.rotateAngleX;
    this.BrasDR7.rotateAngleX = this.BrasDR4.rotateAngleX;

    this.BrasGCH1.rotateAngleX = (MathHelper.cos(par1 * 0.6662F) * 2.0F * par2 * 0.5F);
    this.BrasGCH2.rotateAngleX = (MathHelper.cos(par1 * 0.6662F) * 2.0F * par2 * 0.5F);
    this.BrasGCH3.rotateAngleX = (MathHelper.cos(par1 * 0.6662F) * 2.0F * par2 * 0.5F - 1.0F);
    this.BrasGCH4.rotateAngleX = (MathHelper.cos(par1 * 0.6662F) * 2.0F * par2 * 0.5F);
    this.BrasGCH5.rotateAngleX = (MathHelper.cos(par1 * 0.6662F) * 2.0F * par2 * 0.5F);
  }
  
  
  /**
   * Used for easily adding entity-dependent animations. The second and third float params here are the same second
   * and third as in the setRotationAngles method.
   */
  public void setLivingAnimations(EntityLivingBase e, float x, float y, float z)
  {
      EntityArkavon arkavon;
      long time;
      
      arkavon = (EntityArkavon)e;
      time = System.currentTimeMillis() % 1000;
      
      if (time < 1000)
      {
    	    this.BrasDR1.rotateAngleX = (MathHelper.cos(x * 0.6662F + 3.141593F) * 2.0F * y * 0.5F);
    	    this.BrasDR2.rotateAngleX = (MathHelper.cos(x * 0.6662F + 3.141593F) * 2.0F * y * 0.5F);

    	    this.BrasDR3.rotateAngleX = (MathHelper.cos(x * 0.6662F + 3.141593F) * 2.0F * y * 0.5F - 0.8F);

    	    this.BrasDR4.rotateAngleX = (MathHelper.cos(x * 0.6662F + 3.141593F) * 2.0F * y * 0.5F - 0.1F);
    	    this.BrasDR5.rotateAngleX = this.BrasDR4.rotateAngleX;
    	    this.BrasDR6.rotateAngleX = this.BrasDR4.rotateAngleX;
    	    this.BrasDR7.rotateAngleX = this.BrasDR4.rotateAngleX;  
      }
      else
      {
  	    this.BrasDR1.rotateAngleX = -(MathHelper.cos(x * 0.6662F + 3.141593F) * 2.0F * y * 0.5F);
  	    this.BrasDR2.rotateAngleX = -(MathHelper.cos(x * 0.6662F + 3.141593F) * 2.0F * y * 0.5F);

  	    this.BrasDR3.rotateAngleX = -(MathHelper.cos(x * 0.6662F + 3.141593F) * 2.0F * y * 0.5F - 0.8F);

  	    this.BrasDR4.rotateAngleX = -(MathHelper.cos(x * 0.6662F + 3.141593F) * 2.0F * y * 0.5F - 0.1F);
  	    this.BrasDR5.rotateAngleX = this.BrasDR4.rotateAngleX;
  	    this.BrasDR6.rotateAngleX = this.BrasDR4.rotateAngleX;
  	    this.BrasDR7.rotateAngleX = this.BrasDR4.rotateAngleX;  
      }

  }
}