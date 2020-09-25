package xratedjunior.hunter.api.entity;

import org.apache.logging.log4j.Logger;

import net.minecraft.entity.EntityType;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biome.SpawnListEntry;
import net.minecraftforge.registries.ForgeRegistries;
import xratedjunior.hunter.common.util.SpawnUtils;
import xratedjunior.hunter.configuration.DebugConfig;
import xratedjunior.hunter.configuration.HunterConfig;
import xratedjunior.hunter.core.HunterMod;

public class HunterModSpawns 
{
    private static Logger logger = HunterMod.logger;
	
	public static void registerEntityWorldSpawn()
	{
		for(Biome biome : ForgeRegistries.BIOMES)
		{
			if(biome != null)
			{
				EntityType<?> hunter = HunterModEntityTypes.HUNTER_ENTITY;
				if(SpawnUtils.isSpawnBiomeOrType(biome, HunterConfig.spawn_biomes.get(), hunter) && HunterConfig.hunter_weight.get() > 0)
				{
					biome.getSpawns(hunter.getClassification()).add(new SpawnListEntry(hunter, HunterConfig.hunter_weight.get(), HunterConfig.hunter_min_group.get(), HunterConfig.hunter_max_group.get()));
					if(DebugConfig.spawn_logger.get()) {
						logger.info(hunter.getName().getFormattedText().replace("entity.huntermod.", "").toUpperCase() + " Spawns in: " + biome.getRegistryName().toString());
						logger.info("Weight: " + HunterConfig.hunter_weight.get() + ", Min Group: " + HunterConfig.hunter_min_group.get() + ", Max Group: " + HunterConfig.hunter_max_group.get());
					}
				}
			}
		}
	}
}
