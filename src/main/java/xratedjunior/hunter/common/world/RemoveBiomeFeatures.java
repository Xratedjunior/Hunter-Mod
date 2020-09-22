package xratedjunior.hunter.common.world;

import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraftforge.registries.ForgeRegistries;

public class RemoveBiomeFeatures 
{	
    public static void removeVegetalDecoration() 
    {
        for (Biome biome : ForgeRegistries.BIOMES) 
        {
            biome.getFeatures(GenerationStage.Decoration.VEGETAL_DECORATION).clear();
        }
    }
}