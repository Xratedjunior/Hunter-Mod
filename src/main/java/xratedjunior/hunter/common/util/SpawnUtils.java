package xratedjunior.hunter.common.util;

import java.util.Iterator;
import java.util.List;

import org.apache.logging.log4j.Logger;

import net.minecraft.entity.EntityType;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;
import net.minecraftforge.registries.ForgeRegistries;
import xratedjunior.hunter.core.HunterMod;

public class SpawnUtils 
{
    private static Logger logger = HunterMod.logger;
	
	/*
	 * Check if the input is a Biome Type.
	 */
	public static Boolean isBiomeType(String string) 
	{
		Iterator<Type> allTypes = Type.getAll().iterator();
		String typeName = string.toUpperCase();
		while(allTypes.hasNext()) {
			if(allTypes.next().toString().contains(typeName)) {
				return true;
			}
		}
		//logger.info("THIS IS NOT A BIOME TYPE: \"" + typeName + "\"");
		return false;
	}
	
	public static Type[] getBiomeTypes(String[] types)
	{
		Type[] bt = new Type[types.length];
		for (int i = 0; i < types.length; i++)
		{
			String s = types[i].toUpperCase();
			bt[i] = Type.getType(s);
		}
		return bt;
	}
	
	public static Type[] getBiomeType(String type)
	{
		String[] types = new String[] { type };;
		Type[] bt = new Type[types.length];
		for (int i = 0; i < types.length; i++)
		{
			String s = types[i].toUpperCase();
			bt[i] = Type.getType(s);
		}
		return bt;
	}
	
	/*
	 * Check if the input matches one of the current Biome's Types.
	 */
	public static boolean hasBiomeType(Biome biome, Type... types)
	{		
		for(Type t : types)
		{
			if(BiomeDictionary.hasType(biome, t))
				return true;
		}
		return false;
	}
	
	/*
	 * Check if the input is a possible Spawn Biome.
	 */
	public static boolean isSpawnBiome(Biome biome, String spawnInput, EntityType<?> entity)
	{
		String biomeName = spawnInput.toLowerCase();
		Biome spawnBiome = ForgeRegistries.BIOMES.getValue(new ResourceLocation(biomeName));
        if(spawnBiome == null) { // Could not get biome with ID
        	if(biomeName == null) {
        		return false;
        	}
        	else {
                logger.error("Invalid biome configuration entered for entity \"" + entity.getRegistryName().toString().toUpperCase() + "\" (biome/type was mistyped or a biome/type mod was removed?): " + biomeName);
        	}
        } 
        if(biome == spawnBiome) {
        	return true;
        }
		return false;
	}
	
	
	/*
	 * Check if the given biome is in the list biomes/types of possible spawn biomes of an entity.
	 */
	public static boolean isSpawnBiomeOrType(Biome biome, List<String> spawnInputs, EntityType<?> entity)
	{
		for (String spawnInput : spawnInputs)
		{
			if(isBiomeType(spawnInput)) {
				if( hasBiomeType(biome, getBiomeType(spawnInput)) )
					return true;
			}
			else {
				if( isSpawnBiome(biome, spawnInput, entity) )
					return true;
			}
		}
		return false;
	}
}
