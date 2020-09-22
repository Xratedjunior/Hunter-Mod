package xratedjunior.hunter.common.entity.event;

import org.apache.logging.log4j.Logger;

import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.EntityType;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.Hand;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.entity.living.LivingSpawnEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import xratedjunior.hunter.api.entity.HunterModEntityTypes;
import xratedjunior.hunter.common.entity.HunterEntity;
import xratedjunior.hunter.configuration.ReplaceSkeletonsConfig;
import xratedjunior.hunter.core.HunterMod;

public class ReplaceSkeletonsEvent 
{
    public static Logger logger = HunterMod.logger;

	@SubscribeEvent
	public void onEntityJoinWorld(EntityJoinWorldEvent event)
	{
		int skeletonReplaceChance = ReplaceSkeletonsConfig.replace_chance.get();
		
		if (event.getEntity().getType() == EntityType.SKELETON && skeletonReplaceChance > 0)
		{
			if (!event.getWorld().isRemote)
			{
				float numberGenerator = Math.round(event.getWorld().getRandom().nextFloat() * 100);
				float chanceInput = numberGenerator - skeletonReplaceChance;
				
				if (ReplaceSkeletonsConfig.replace_skeletons_below_surface.get())
				{
					if (event.getEntity().getPosition().getY() >= ReplaceSkeletonsConfig.custom_y_level.get() && (skeletonReplaceChance == 100 || ( skeletonReplaceChance > 0 && chanceInput <= 0)) )
					{
						HunterEntity newLostMiner = HunterModEntityTypes.HUNTER_ENTITY.create(event.getWorld());
						newLostMiner.moveToBlockPosAndAngles(event.getEntity().getPosition(), event.getEntity().rotationYaw, event.getEntity().rotationPitch);
						event.getEntity().remove();
						event.getWorld().addEntity(newLostMiner);
					}
				}
				
				if (event.getEntity().getPosition().getY() >= event.getWorld().getSeaLevel() && (skeletonReplaceChance == 100 || ( skeletonReplaceChance > 0 && chanceInput <= 0)) )
				{
					HunterEntity newLostMiner = HunterModEntityTypes.HUNTER_ENTITY.create(event.getWorld());
					newLostMiner.moveToBlockPosAndAngles(event.getEntity().getPosition(), event.getEntity().rotationYaw, event.getEntity().rotationPitch);
					event.getEntity().remove();
					event.getWorld().addEntity(newLostMiner);
				}
			}
		}
	}
	
	@SubscribeEvent
	public void LivingSpawnEvent(LivingSpawnEvent event)
	{	
		if (event.getEntityLiving().getType() == HunterModEntityTypes.HUNTER_ENTITY)
		{
			if (!event.getWorld().isRemote())
			{
				if ((event.getEntityLiving().getHeldItem(Hand.MAIN_HAND) == ItemStack.EMPTY))
				{
					event.getEntityLiving().setItemStackToSlot(EquipmentSlotType.MAINHAND, new ItemStack(Items.BOW));
					event.getEntityLiving().getHeldItem(Hand.MAIN_HAND).addEnchantment(Enchantments.POWER, 1);
					event.getEntityLiving().getHeldItem(Hand.MAIN_HAND).addEnchantment(Enchantments.PUNCH, 1);
				}
			}
		}
	}
}
