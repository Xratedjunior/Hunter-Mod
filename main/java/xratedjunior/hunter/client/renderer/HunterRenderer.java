package xratedjunior.hunter.client.renderer;

import net.minecraft.client.renderer.entity.BipedRenderer;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.layers.BipedArmorLayer;
import net.minecraft.client.renderer.entity.layers.HeldItemLayer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import xratedjunior.hunter.client.models.HunterModel;
import xratedjunior.hunter.common.entity.HunterEntityAbstract;
import xratedjunior.hunter.core.HunterMod;

@OnlyIn(Dist.CLIENT)
public class HunterRenderer extends BipedRenderer<HunterEntityAbstract, HunterModel<HunterEntityAbstract>>
{
   private static final ResourceLocation HUNTER_TEXTURES = new ResourceLocation(HunterMod.MOD_ID,"textures/entity/hunter_entity.png");
   
   public HunterRenderer(EntityRendererManager manager) {
      super(manager, new HunterModel<>(), 0.5F);
      this.addLayer(new HeldItemLayer<>(this));
      this.addLayer(new BipedArmorLayer<>(this, new HunterModel<>(0.5F, true), new HunterModel<>(1.0F, true)));
   }

   public ResourceLocation getEntityTexture(HunterEntityAbstract entity) {
      return HUNTER_TEXTURES;
   }
   
   
   public static class RenderFactory implements IRenderFactory<HunterEntityAbstract>
   {
		@Override
		public EntityRenderer<? super HunterEntityAbstract> createRenderFor(EntityRendererManager manager) {
			return new HunterRenderer(manager);
		}
		
	}
}