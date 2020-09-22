package xratedjunior.hunter.api.entity;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraftforge.event.RegistryEvent.Register;
import net.minecraftforge.registries.ObjectHolder;
import xratedjunior.hunter.common.entity.HunterEntity;
import xratedjunior.hunter.core.HunterMod;
import xratedjunior.hunter.init.HunterModEntityRegistryHandler;

@ObjectHolder(HunterMod.MOD_ID)
public class HunterModEntityTypes 
{
	public static final EntityType<HunterEntity> HUNTER_ENTITY = buildEntity("hunter_entity", EntityType.Builder.create(HunterEntity::new, EntityClassification.MONSTER).size(0.6F, 1.99F));

	public static void init(Register<EntityType<?>> event)
	{
		HunterModEntityRegistryHandler.register(event.getRegistry(), "hunter_entity", HUNTER_ENTITY);
	}
	
	private static <T extends Entity> EntityType<T> buildEntity(String key, EntityType.Builder<T> builder)
	{
		return builder.build(HunterMod.find(key));
	}
}
