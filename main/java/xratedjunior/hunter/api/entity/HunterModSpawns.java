package xratedjunior.hunter.api.entity;

import net.minecraft.entity.EntityType;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biome.SpawnListEntry;
import net.minecraft.world.biome.Biomes;
import xratedjunior.hunter.configuration.HunterConfig;

public class HunterModSpawns 
{
	public static void registerEntityWorldSpawns()
	{
		registerEntityWorldSpawn(HunterModEntityTypes.HUNTER_ENTITY, Biomes.BAMBOO_JUNGLE, Biomes.BAMBOO_JUNGLE_HILLS, Biomes.JUNGLE, Biomes.JUNGLE_EDGE, Biomes.JUNGLE_HILLS, Biomes.MODIFIED_JUNGLE, Biomes.MODIFIED_JUNGLE_EDGE);
	}
	
	public static void registerEntityWorldSpawn(EntityType<?> entity, Biome...biomes)
	{
		for(Biome biome : biomes)
		{
			if(biome != null)
			{
				biome.getSpawns(entity.getClassification()).add(new SpawnListEntry(HunterModEntityTypes.HUNTER_ENTITY, HunterConfig.hunter_weight.get(), HunterConfig.hunter_min_group.get(), HunterConfig.hunter_max_group.get()));
			}
		}
	}
}
