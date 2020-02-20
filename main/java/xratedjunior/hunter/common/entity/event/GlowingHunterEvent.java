package xratedjunior.hunter.common.entity.event;

import org.apache.logging.log4j.Logger;

import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import xratedjunior.hunter.api.entity.HunterModEntityTypes;
import xratedjunior.hunter.core.HunterMod;

public class GlowingHunterEvent 
{
    public static Logger logger = HunterMod.logger;

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
