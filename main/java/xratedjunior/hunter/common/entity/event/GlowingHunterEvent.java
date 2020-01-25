package xratedjunior.hunter.common.entity.event;

import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import xratedjunior.hunter.api.entity.HunterModEntityTypes;

public class GlowingHunterEvent 
{
	@SubscribeEvent
	public void onEntityJoinWorld(EntityJoinWorldEvent event)
	{
		if (event.getEntity().getType() == HunterModEntityTypes.HUNTER_ENTITY)
		{
			if (!event.getWorld().isRemote)
			{
				event.getEntity().setGlowing(true);
			}
		}
	}
}
