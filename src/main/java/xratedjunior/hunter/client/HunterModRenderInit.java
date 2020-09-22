package xratedjunior.hunter.client;

import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

public class HunterModRenderInit 
{
	public static void initialization(FMLClientSetupEvent event)
	{
		HunterModEntityRendering.init();
	}
}
