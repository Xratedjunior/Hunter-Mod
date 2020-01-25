package xratedjunior.hunter.configuration;

import java.io.File;

import com.electronwill.nightconfig.core.file.CommentedFileConfig;
import com.electronwill.nightconfig.core.io.WritingMode;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.fml.common.Mod;
import xratedjunior.hunter.core.HunterMod;

@Mod.EventBusSubscriber
public class HunterModConfig 
{
	private static final ForgeConfigSpec.Builder server_builder = new ForgeConfigSpec.Builder();
	public static final ForgeConfigSpec server_config;
	
	static
	{
		HunterConfig.init(server_builder);
		//ReplaceSkeletonsConfig.init(server_builder);
		
		server_config = server_builder.build();
	}
	
	public static void loadConfig(ForgeConfigSpec config, String path)
	{
		HunterMod.logger.info("Loading config" + path);
		final CommentedFileConfig file = CommentedFileConfig.builder(new File(path)).sync().autosave().writingMode(WritingMode.REPLACE).build();
		HunterMod.logger.info("Built config" + path);
		file.load();
		HunterMod.logger.info("Loaded config" + path);
		config.setConfig(file);
	}
}
