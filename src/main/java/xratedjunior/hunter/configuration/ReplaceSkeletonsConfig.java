package xratedjunior.hunter.configuration;

import net.minecraftforge.common.ForgeConfigSpec;

public class ReplaceSkeletonsConfig 
{
	public static ForgeConfigSpec.BooleanValue replace_skeletons;
	public static ForgeConfigSpec.IntValue replace_chance;
	public static ForgeConfigSpec.BooleanValue replace_skeletons_below_surface;
	public static ForgeConfigSpec.IntValue custom_y_level;
	
	public static void init(ForgeConfigSpec.Builder builder)
	{
		builder.comment("Replace Skeletons Config");
		
		replace_skeletons = builder
			.comment("Replace skeletons in the jungle with hunters (Default: false)")
			.define("Skeletons.replace_skeletons", true);
		
		replace_chance = builder
				.comment("The chance for a hunter to replace a skeleton (Default: 100)")
				.defineInRange("Skeletons.replace_chance", 100, 0, 100);
		
		replace_skeletons_below_surface = builder
				.comment("Replace skeletons above a custom Y level (Default: false (which means above sea level))")
				.define("Skeletons.custom_y_level.active", false);
		
		custom_y_level = builder
			.comment("Put a custom Y level above which skeletons will be replaced")
			.defineInRange("Skeletons.custom_y_level.y", 1, 1, 256);
	}
}
