package fr.toss.common.world;

import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;
import net.minecraft.util.Vec3;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraftforge.client.ForgeHooksClient;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fr.toss.common.Main;

public class WorldProviderMagic extends WorldProvider
{
    /**
     * Returns a new chunk provider which generates chunks for this world
     */
    public IChunkProvider createChunkGenerator()
    {
        return new ChunkGeneratorSky(this.worldObj, this.worldObj.getSeed(), this.worldObj.getWorldInfo().isMapFeaturesEnabled(), Main.DIM_ID);
    }

    public float getCloudHeight()
    {
    	return (16.0f);
    }
    
    @SideOnly(Side.CLIENT)
    public Vec3 getSkyColor(Entity cameraEntity, float partialTicks)
    {

        float f1 = this.worldObj.getCelestialAngle(partialTicks);
        float f2 = MathHelper.cos(f1 * (float)Math.PI * 2.0F) * 2.0F + 0.5F;

        if (f2 < 0.0F)
        {
            f2 = 0.0F;
        }

        if (f2 > 1.0F)
        {
            f2 = 1.0F;
        }

        int i = MathHelper.floor_double(cameraEntity.posX);
        int j = MathHelper.floor_double(cameraEntity.posY);
        int k = MathHelper.floor_double(cameraEntity.posZ);
        int l = ForgeHooksClient.getSkyBlendColour(this.worldObj, i, j, k);
        float f4 = (float)(l >> 16 & 255) / 255.0F;
        float f5 = (float)(l >> 8 & 255) / 255.0F;
        float f6 = (float)(l & 255) / 255.0F;
        f4 *= f2;
        f5 *= f2;
        f6 *= f2;
        float f7 = this.worldObj.getRainStrength(partialTicks);
        float f8;
        float f9;

        if (f7 > 0.0F)
        {
            f8 = (f4 * 0.3F + f5 * 0.59F + f6 * 0.11F) * 0.6F;
            f9 = 1.0F - f7 * 0.75F;
            f4 = f4 * f9 + f8 * (1.0F - f9);
            f5 = f5 * f9 + f8 * (1.0F - f9);
            f6 = f6 * f9 + f8 * (1.0F - f9);
        }

        f8 = this.worldObj.getWeightedThunderStrength(partialTicks);

        if (f8 > 0.0F)
        {
            f9 = (f4 * 0.3F + f5 * 0.59F + f6 * 0.11F) * 0.2F;
            float f10 = 1.0F - f8 * 0.75F;
            f4 = f4 * f10 + f9 * (1.0F - f10);
            f5 = f5 * f10 + f9 * (1.0F - f10);
            f6 = f6 * f10 + f9 * (1.0F - f10);
        }

        if (this.worldObj.lastLightningBolt > 0)
        {
            f9 = (float)this.worldObj.lastLightningBolt - partialTicks;

            if (f9 > 1.0F)
            {
                f9 = 1.0F;
            }

            f9 *= 0.45F;
            f4 = f4 * (1.0F - f9) + 0.8F * f9;
            f5 = f5 * (1.0F - f9) + 0.8F * f9;
            f6 = f6 * (1.0F - f9) + 1.0F * f9;
        }
        return Vec3.createVectorHelper((double)f4, (double)f5, (double)f6);
        
    }
    
    @SideOnly(Side.CLIENT)
    public float getStarBrightness(float par1)
    {
        return (10.0f);
    }
    
    public void updateWeather() {}
    
    
    @SideOnly(Side.CLIENT)
    public double getVoidFogYFactor()
    {
        return 1.0D;
    }
    
    @SideOnly(Side.CLIENT)
    public boolean getWorldHasVoidParticles()
    {
        return false;
    }
    
    @Override
    public boolean canSnowAt(int x, int y, int z, boolean checkLight)
    {
        return false;
    }
        
    @Override
    public boolean canDoRainSnowIce(Chunk chunk)
    {
        return false;
    }
    
    @Override
    public boolean canDoLightning(Chunk chunk)
    {
        return false;
    }
    
    @SideOnly(Side.CLIENT)
    public Vec3 getFogColor(float p_76562_1_, float p_76562_2_)
    {
        float f2 = MathHelper.cos(p_76562_1_ * (float)Math.PI * 2.0F) * 2.0F + 0.5F;

        if (f2 < 0.0F)
        {
            f2 = 0.0F;
        }

        if (f2 > 1.0F)
        {
            f2 = 1.0F;
        }

        float f3 = 0.7529412F;
        float f4 = 0.84705883F;
        float f5 = 1.0F;
        f3 *= f2 * 0.94F + 0.02F;
        f4 *= f2 * 0.94F + 0.2F;
        f5 *= f2 * 0.91F + 0.2F;
        return Vec3.createVectorHelper((double)f3, (double)f4, (double)f5);
    }
    
    protected void registerWorldChunkManager()
    {
        this.worldChunkMgr = new ChunkManagerOld(this.worldObj);
    }
    
	@Override
	public String getDimensionName() 
	{
		return ("Mystic Groves");
	}
	
	@Override
	public boolean canRespawnHere()
	{
		return (false);
	}
}