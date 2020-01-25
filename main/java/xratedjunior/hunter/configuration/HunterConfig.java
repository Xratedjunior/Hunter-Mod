package xratedjunior.hunter.configuration;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.common.ForgeConfigSpec.ConfigValue;

public class HunterConfig 
{
	public static ForgeConfigSpec.IntValue hunter_weight;
	public static ConfigValue<Integer> hunter_min_group;
	public static ConfigValue<Integer> hunter_max_group;
	public static ForgeConfigSpec.BooleanValue glowing_hunters;
	public static ForgeConfigSpec.BooleanValue remove_vegetal_decoration;

	private static int hunterSpawnWeight = 90;
	private static int hunterSpawnWeightMin = 0;
	private static int hunterSpawnWeightMax = 100;
	private static int hunterMinGroup = 1;
	private static int hunterMaxGroup = 3;
	private static boolean glowingHunters = false;
	private static boolean removeVegetalDecoration = false;
	
	public static void init(ForgeConfigSpec.Builder server)
	{
		server.comment("Hunter Config");
		
		hunter_weight = server
			.comment("Spawn weight for the Hunter Entity (Default: " + hunterSpawnWeight + ")")
			.defineInRange("Hunter.weight", hunterSpawnWeight, hunterSpawnWeightMin, hunterSpawnWeightMax);
		
		hunter_min_group = server
			.comment("Minimum amount of hunters to spawn in a group (Default: " + hunterMinGroup + ")")
			.define("Hunter.min_group", hunterMinGroup);
		
		hunter_max_group = server
			.comment("Maximum amount of hunters to spawn in a group (Default: " + hunterMaxGroup + ")")
			.define("Hunter.max_group", hunterMaxGroup);
		
		glowing_hunters = server
				.comment("Gives hunters the glowing effect (Default: " + glowingHunters + ")")
				.define("Debug.Glowing hunters", glowingHunters);
		
		remove_vegetal_decoration = server
				.comment("Removes all vegetation to see if the hunter is spawning. Please note: Hunters can't spawn in complete daylight. (Default: " + removeVegetalDecoration + ")" )
				.define("Debug.Remove vegetal decoration", removeVegetalDecoration);
	}
}
