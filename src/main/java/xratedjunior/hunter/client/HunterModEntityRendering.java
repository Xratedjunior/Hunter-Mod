package xratedjunior.hunter.client;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import xratedjunior.hunter.api.entity.HunterModEntityTypes;
import xratedjunior.hunter.client.renderer.HunterRenderer;

public class HunterModEntityRendering 
{
	public static void init()
	{
		register(HunterModEntityTypes.HUNTER_ENTITY, HunterRenderer::new);
	}

	private static <T extends Entity> void register(EntityType<T> entityClass, IRenderFactory<? super T> renderFactory)
	{
		RenderingRegistry.registerEntityRenderingHandler(entityClass, renderFactory);
	}
}
