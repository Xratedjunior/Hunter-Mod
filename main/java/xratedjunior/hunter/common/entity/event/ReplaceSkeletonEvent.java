package xratedjunior.hunter.common.entity.event;

import net.minecraft.entity.EntityType;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import xratedjunior.hunter.api.entity.HunterModEntityTypes;
import xratedjunior.hunter.common.entity.HunterEntity;

public class ReplaceSkeletonEvent 
{
	public static int skeletonMinerSpawnChance = 1;

	@SubscribeEvent
	public void onEntityJoinWorld(EntityJoinWorldEvent event)
	{
		if (event.getEntity().getType() == EntityType.SKELETON)
		{
			if (!event.getWorld().isRemote)
			{
				//HunterEntity newHunter = new HunterEntity(HunterModEntityTypes.HUNTER_ENTITY, event.getWorld());
				HunterEntity newHunter = HunterModEntityTypes.HUNTER_ENTITY.create(event.getWorld());
				newHunter.moveToBlockPosAndAngles(event.getEntity().getPosition(), event.getEntity().rotationYaw, event.getEntity().rotationPitch);
				event.getEntity().remove();
				event.getWorld().addEntity(newHunter);
			}
		}
	}
}
