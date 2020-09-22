package xratedjunior.hunter.api.entity;

import java.util.List;

import org.apache.logging.log4j.Logger;

import net.minecraft.entity.EntityType;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biome.Category;
import net.minecraft.world.biome.MobSpawnInfo;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;
import xratedjunior.hunter.configuration.DebugConfig;
import xratedjunior.hunter.configuration.HunterConfig;
import xratedjunior.hunter.core.HunterMod;

@Mod.EventBusSubscriber(modid = HunterMod.MOD_ID)
public class HunterModSpawns 
{	
    private static Logger logger = HunterMod.logger;

    @SubscribeEvent(priority = EventPriority.HIGH)
	public static void registerEntityWorldSpawn(BiomeLoadingEvent event)
	{
		ResourceLocation biomeName = event.getName();
		Biome biome = ForgeRegistries.BIOMES.getValue(biomeName);
		if(biome != null) 
		{
			if(HunterConfig.hunter_weight.get() > 0) {
				EntityType<?> hunter = HunterModEntityTypes.HUNTER_ENTITY;
				if(isMobInputBiomeOrCategory(biome, HunterConfig.spawn_biomes.get(), hunter)) {
					event.getSpawns().getSpawner(hunter.getClassification()).add(new MobSpawnInfo.Spawners(hunter, HunterConfig.hunter_weight.get(), HunterConfig.hunter_min_group.get(), HunterConfig.hunter_max_group.get()));
				    Boolean HunterSpawnsLogger = DebugConfig.spawn_logger.get();
					if(HunterSpawnsLogger) {
						logger.info(hunter.getName().getString().replace("entity.betterdefaultbiomes.", "").toUpperCase() + " Spawns in: " + biome.getRegistryName().toString());
						logger.info("Weight: " + HunterConfig.hunter_weight.get() + ", Min Group: " + HunterConfig.hunter_min_group.get() + ", Max Group: " + HunterConfig.hunter_max_group.get());
					}
				}
			}
		}
	}
	
	private static Boolean inputIsCategory(String string) 
	{
		Category[] allCategories = Biome.Category.values();
		for (int i = 0; i < allCategories.length; i++)
		{
			if(allCategories[i] == Biome.Category.func_235103_a_(string.toLowerCase())) {
				//logger.info("THIS IS A BIOME TYPE: \"" + string + "\"");
				return true;
			}
		}
		//logger.info("THIS IS NOT A BIOME TYPE: \"" + string + "\"");
		return false;
	}
	
	private static Category[] inputCategory(String categoryInputs)
	{
		String[] inputStrings = new String[] { categoryInputs };;
		Category[] categoryArray = new Category[inputStrings.length];
		for (int i = 0; i < inputStrings.length; i++)
		{
			String categoryName = inputStrings[i].toLowerCase();
			categoryArray[i] = Biome.Category.func_235103_a_(categoryName);
		}
		return categoryArray;
	}
	
	/*
	 * Check if the input matches one of the current Biome's Types.
	 */
	private static boolean biomeWithInputCategory(Biome biome, Category... categories)
	{		
		for(Category category : categories)
		{
			if(category == biome.getCategory()){
				return true;
			}
		}
		return false;
	}
	
	/*
	 * Check if the input is a possible Spawn Biome.
	 */
	private static boolean isInputBiome(Biome biome, String spawnInput, EntityType<?> entity)
	{
		String biomeName = spawnInput.toLowerCase();
		Biome spawnBiome = ForgeRegistries.BIOMES.getValue(new ResourceLocation(biomeName));
        if(spawnBiome == null) { // Could not get biome with ID
        	if(biomeName == null) {
        		return false;
        	} else {
				logger.error("Invalid biome configuration entered for entity \"" + entity.getRegistryName().toString().toUpperCase() + "\" (biome/type was mistyped or a biome/type mod was removed?): " + spawnInput);
        	}
        } 
        if(biome == spawnBiome) {
        	//logger.info("Spawns in Biome: " + biome + ", " + entity.getRegistryName().toString().toUpperCase());
        	return true;
        }
		return false;
	}
	
	/*
	 * Check if the given biome is in the list biomes/types of possible spawn biomes of an entity.
	 */
	public static boolean isMobInputBiomeOrCategory(Biome biome, List<String> spawnInputs, EntityType<?> entity)
	{
		for (String spawnInput : spawnInputs)
		{
			if(inputIsCategory(spawnInput)) {
				if(biomeWithInputCategory(biome, inputCategory(spawnInput))) {
					return true;
				}
			}
			else if(isInputBiome(biome, spawnInput, entity)) {
				return true;
			}
		}
		return false;
	}
}
