package xratedjunior.hunter.init;

import net.minecraft.entity.EntitySpawnPlacementRegistry;
import net.minecraft.entity.EntityType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.world.gen.Heightmap;
import net.minecraftforge.event.RegistryEvent.Register;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.IForgeRegistryEntry;
import xratedjunior.hunter.api.entity.HunterModEntityTypes;
import xratedjunior.hunter.api.entity.HunterModSpawns;
import xratedjunior.hunter.common.entity.HunterEntity;
import xratedjunior.hunter.core.HunterMod;

@EventBusSubscriber(modid = HunterMod.MOD_ID, bus = Bus.MOD)
public class HunterModEntityRegistryHandler 
{	
	@SubscribeEvent
	public static void onRegisterItems(Register<Item> event)
	{
		register(event.getRegistry(), "hunter_spawn_egg", new SpawnEggItem(HunterModEntityTypes.HUNTER_ENTITY, 0x699564, 0x665339, new Item.Properties().group(ItemGroup.MISC)));
	}

	@SubscribeEvent
	public static void onRegisterEntityTypes(Register<EntityType<?>> event)
	{
		HunterModEntityTypes.init(event);
		EntitySpawnPlacementRegistry.register(HunterModEntityTypes.HUNTER_ENTITY, EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, HunterEntity::checkHunterSpawnRules);
		HunterModSpawns.registerEntityWorldSpawns();
	}
	
	public static <T extends IForgeRegistryEntry<T>> void register(IForgeRegistry<T> registry, String name, T object)
	{
		object.setRegistryName(HunterMod.locate(name));
		registry.register(object);
	}
}
