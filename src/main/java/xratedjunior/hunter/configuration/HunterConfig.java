package xratedjunior.hunter.configuration;

import java.util.List;

import com.google.common.collect.Lists;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.common.ForgeConfigSpec.ConfigValue;

public class HunterConfig 
{
	public static ForgeConfigSpec.IntValue hunter_weight;
	public static ConfigValue<Integer> hunter_min_group;
	public static ConfigValue<Integer> hunter_max_group;
	public static ConfigValue<Integer> hunter_bow_drop_chance;
	public static ForgeConfigSpec.ConfigValue<List<String>> spawn_biomes;

	private static int hunterSpawnWeight = 90;
	private static int hunterSpawnWeightMin = 0;
	private static int hunterSpawnWeightMax = 10000;
	private static int hunterMinGroup = 1;
	private static int hunterMaxGroup = 3;
	private static int hunterBowDropChance = 8;
	private static List<String> spawnBiomes = Lists.newArrayList("JUNGLE");
	
	public static void init(ForgeConfigSpec.Builder builder)
	{
		builder.comment("Hunter Config");
		
		hunter_weight = builder
			.comment("Spawn weight for the Hunter Entity (Default: " + hunterSpawnWeight + ")")
			.defineInRange("Hunter.weight", hunterSpawnWeight, hunterSpawnWeightMin, hunterSpawnWeightMax);
		
		hunter_min_group = builder
			.comment("Minimum amount of hunters to spawn in a group (Default: " + hunterMinGroup + ")")
			.define("Hunter.min_group", hunterMinGroup);
		
		hunter_max_group = builder
			.comment("Maximum amount of hunters to spawn in a group (Default: " + hunterMaxGroup + ")")
			.define("Hunter.max_group", hunterMaxGroup);
		
		hunter_bow_drop_chance = builder
			.comment("Drop chance in % for the \"Hunter's Bow\" (Default: " + hunterBowDropChance + ")")
			.defineInRange("Hunter.drop_chance", hunterBowDropChance, 0, 200);
		
		spawn_biomes = builder
			.comment("Spawn Biomes/BiomeTypes where the Hunter will spawn.")
			.define("Hunter.spawn_biomes", spawnBiomes);
	}
}
