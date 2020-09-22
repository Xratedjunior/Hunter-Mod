package xratedjunior.hunter.core;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig.Type;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import xratedjunior.hunter.client.HunterModRenderInit;
import xratedjunior.hunter.common.entity.event.GlowingHunterEvent;
import xratedjunior.hunter.common.world.RemoveBiomeFeatures;
import xratedjunior.hunter.configuration.DebugConfig;
import xratedjunior.hunter.configuration.HunterModConfig;

@Mod(value = HunterMod.MOD_ID)
public class HunterMod 
{
    public static HunterMod instance;
    public static final String MOD_ID = "huntermod";
    public static Logger logger = LogManager.getLogger(MOD_ID);
    
	//public static final ItemGroup HUNTERTAB = new ItemGroupHunter();
	
    public HunterMod()
    {
    	ModLoadingContext.get().registerConfig(Type.COMMON, HunterModConfig.COMMON_SPEC, "Huntermod.toml");

		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::commonSetup);
		FMLJavaModLoadingContext.get().getModEventBus().addListener(HunterModRenderInit::initialization);
    }
	
	//Will run at launch (preInit)
	private void commonSetup(final FMLCommonSetupEvent event)
	{
		
		if (DebugConfig.remove_vegetal_decoration.get())
		{
	        RemoveBiomeFeatures.removeVegetalDecoration();
		}
		
		if (DebugConfig.glowing_hunters.get())
		{
			MinecraftForge.EVENT_BUS.register(new GlowingHunterEvent());
		}
		
		/*
		if (ReplaceSkeletonsConfig.replace_skeletons.get())
		{
			MinecraftForge.EVENT_BUS.register(new ReplaceSkeletonsEvent());
		}
		*/

		logger.info("Setup method registered.");
	}
    
	public static ResourceLocation locate(String name)
	{
		return new ResourceLocation(MOD_ID, name);
	}

	public static String find(String key)
	{
		return new String(MOD_ID + ":" + key);
	}

}
