package xratedjunior.hunter.configuration;

import net.minecraftforge.common.ForgeConfigSpec;

public class DebugConfig 
{
	public static ForgeConfigSpec.BooleanValue glowing_hunters;
	public static ForgeConfigSpec.BooleanValue spawn_logger;
	//public static ForgeConfigSpec.BooleanValue remove_vegetal_decoration;
	
	private static boolean glowingHunters = false;
	private static boolean spawnLogger = false;
	//private static boolean removeVegetalDecoration = false;
	
	public static void init(ForgeConfigSpec.Builder builder)
	{	
		glowing_hunters = builder
				.comment("Gives hunters the glowing effect (Default: " + glowingHunters + ")")
				.define("Debug.glowing_hunters", glowingHunters);
		
		spawn_logger = builder
				.comment("Enables a logger for more info about the registered spawns of the Hunter (Default: " + spawnLogger + ")")
				.define("Debug.spawn_logger", spawnLogger);
		
		/*
		remove_vegetal_decoration = builder
				.comment("Removes all vegetation to see if the hunter is spawning. Please note: Hunters can't spawn in complete daylight. (Default: " + removeVegetalDecoration + ")" )
				.define("Debug.remove_vegetal_decoration", removeVegetalDecoration);
		*/
	}
}
