package xratedjunior.hunter.configuration;

import net.minecraftforge.common.ForgeConfigSpec;

public class ReplaceSkeletonsConfig 
{
	public static ForgeConfigSpec.BooleanValue replace_skeletons;
	public static ForgeConfigSpec.IntValue replace_chance;
	public static ForgeConfigSpec.BooleanValue replace_skeletons_below_surface;
	public static ForgeConfigSpec.IntValue custom_y_level;
	
	public static void init(ForgeConfigSpec.Builder server)
	{
		server.comment("Replace Skeletons Config");
		
		replace_skeletons = server
			.comment("Replace skeletons in the jungle with hunters (Default: false)")
			.define("Skeletons.Replace skeletons", true);
		
		replace_chance = server
				.comment("The chance for a hunter to replace a skeleton (Default: 100)")
				.defineInRange("Skeletons.Replace chance", 100, 0, 100);
		
		replace_skeletons_below_surface = server
				.comment("Replace skeletons above a custom Y level (Default: false (which means above sea level))")
				.define("Custom y level.active", false);
		
		custom_y_level = server
			.comment("Put a custom Y level above which skeletons will be replaced")
			.defineInRange("Custom y level.y", 0, 0, 256);
	}
}
