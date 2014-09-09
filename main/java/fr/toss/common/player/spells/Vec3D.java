package fr.toss.common.player.spells;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.util.MathHelper;

public class Vec3D
{
  private static List vectorList = new ArrayList();
  private static int nextVector = 0;
  public double xCoord;
  public double yCoord;
  public double zCoord;

  public static Vec3D createVectorHelper(double par0, double par2, double par4)
  {
    return new Vec3D(par0, par2, par4);
  }

  public static void clearVectorList()
  {
    vectorList.clear();
    nextVector = 0;
  }

  public static void initialize()
  {
    nextVector = 0;
  }

  public static Vec3D createVector(double par0, double par2, double par4)
  {
    if (nextVector >= vectorList.size())
    {
      vectorList.add(createVectorHelper(0.0D, 0.0D, 0.0D));
    }

    return ((Vec3D)vectorList.get(nextVector++)).setComponents(par0, par2, par4);
  }

  private Vec3D(double par1, double par3, double par5)
  {
    if (par1 == -0.0D)
    {
      par1 = 0.0D;
    }

    if (par3 == -0.0D)
    {
      par3 = 0.0D;
    }

    if (par5 == -0.0D)
    {
      par5 = 0.0D;
    }

    this.xCoord = par1;
    this.yCoord = par3;
    this.zCoord = par5;
  }

  private Vec3D setComponents(double par1, double par3, double par5)
  {
    this.xCoord = par1;
    this.yCoord = par3;
    this.zCoord = par5;
    return this;
  }

  public Vec3D subtract(Vec3D par1Vec3D)
  {
    return createVector(par1Vec3D.xCoord - this.xCoord, par1Vec3D.yCoord - this.yCoord, par1Vec3D.zCoord - this.zCoord);
  }

  public Vec3D normalize()
  {
    double d = MathHelper.sqrt_double(this.xCoord * this.xCoord + this.yCoord * this.yCoord + this.zCoord * this.zCoord);
    return d < 0.0001D ? createVector(0.0D, 0.0D, 0.0D) : createVector(this.xCoord / d, this.yCoord / d, this.zCoord / d);
  }

  public double dotProduct(Vec3D par1Vec3D)
  {
    return this.xCoord * par1Vec3D.xCoord + this.yCoord * par1Vec3D.yCoord + this.zCoord * par1Vec3D.zCoord;
  }

  public Vec3D crossProduct(Vec3D par1Vec3D)
  {
    return createVector(this.yCoord * par1Vec3D.zCoord - this.zCoord * par1Vec3D.yCoord, this.zCoord * par1Vec3D.xCoord - this.xCoord * par1Vec3D.zCoord, this.xCoord * par1Vec3D.yCoord - this.yCoord * par1Vec3D.xCoord);
  }

  public Vec3D addVector(double par1, double par3, double par5)
  {
    return createVector(this.xCoord + par1, this.yCoord + par3, this.zCoord + par5);
  }

  public double distanceTo(Vec3D par1Vec3D)
  {
    double d = par1Vec3D.xCoord - this.xCoord;
    double d1 = par1Vec3D.yCoord - this.yCoord;
    double d2 = par1Vec3D.zCoord - this.zCoord;
    return MathHelper.sqrt_double(d * d + d1 * d1 + d2 * d2);
  }

  public double squareDistanceTo(Vec3D par1Vec3D)
  {
    double d = par1Vec3D.xCoord - this.xCoord;
    double d1 = par1Vec3D.yCoord - this.yCoord;
    double d2 = par1Vec3D.zCoord - this.zCoord;
    return d * d + d1 * d1 + d2 * d2;
  }

  public double squareDistanceTo(double par1, double par3, double par5)
  {
    double d = par1 - this.xCoord;
    double d1 = par3 - this.yCoord;
    double d2 = par5 - this.zCoord;
    return d * d + d1 * d1 + d2 * d2;
  }

  public double lengthVector()
  {
    return MathHelper.sqrt_double(this.xCoord * this.xCoord + this.yCoord * this.yCoord + this.zCoord * this.zCoord);
  }

  public Vec3D getIntermediateWithXValue(Vec3D par1Vec3D, double par2)
  {
    double d = par1Vec3D.xCoord - this.xCoord;
    double d1 = par1Vec3D.yCoord - this.yCoord;
    double d2 = par1Vec3D.zCoord - this.zCoord;

    if (d * d < 1.000000011686097E-007D)
    {
      return null;
    }

    double d3 = (par2 - this.xCoord) / d;
    return (d3 >= 0.0D) && (d3 <= 1.0D) ? createVector(this.xCoord + d * d3, this.yCoord + d1 * d3, this.zCoord + d2 * d3) : null;
  }

  public Vec3D getIntermediateWithYValue(Vec3D par1Vec3D, double par2)
  {
    double d = par1Vec3D.xCoord - this.xCoord;
    double d1 = par1Vec3D.yCoord - this.yCoord;
    double d2 = par1Vec3D.zCoord - this.zCoord;

    if (d1 * d1 < 1.000000011686097E-007D)
    {
      return null;
    }

    double d3 = (par2 - this.yCoord) / d1;
    return (d3 >= 0.0D) && (d3 <= 1.0D) ? createVector(this.xCoord + d * d3, this.yCoord + d1 * d3, this.zCoord + d2 * d3) : null;
  }

  public Vec3D getIntermediateWithZValue(Vec3D par1Vec3D, double par2)
  {
    double d = par1Vec3D.xCoord - this.xCoord;
    double d1 = par1Vec3D.yCoord - this.yCoord;
    double d2 = par1Vec3D.zCoord - this.zCoord;

    if (d2 * d2 < 1.000000011686097E-007D)
    {
      return null;
    }

    double d3 = (par2 - this.zCoord) / d2;
    return (d3 >= 0.0D) && (d3 <= 1.0D) ? createVector(this.xCoord + d * d3, this.yCoord + d1 * d3, this.zCoord + d2 * d3) : null;
  }

  public String toString()
  {
    return "(" + this.xCoord + ", " + this.yCoord + ", " + this.zCoord + ")";
  }

  public void rotateAroundX(float par1)
  {
    float f = MathHelper.cos(par1);
    float f1 = MathHelper.sin(par1);
    double d = this.xCoord;
    double d1 = this.yCoord * f + this.zCoord * f1;
    double d2 = this.zCoord * f - this.yCoord * f1;
    this.xCoord = d;
    this.yCoord = d1;
    this.zCoord = d2;
  }

  public void rotateAroundY(float par1)
  {
    float f = MathHelper.cos(par1);
    float f1 = MathHelper.sin(par1);
    double d = this.xCoord * f + this.zCoord * f1;
    double d1 = this.yCoord;
    double d2 = this.zCoord * f - this.xCoord * f1;
    this.xCoord = d;
    this.yCoord = d1;
    this.zCoord = d2;
  }
}