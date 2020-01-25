package xratedjunior.hunter.common.item;

import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ArrowItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import xratedjunior.hunter.common.entity.projectile.HunterArrowEntity;

public class HunterArrowItem extends ArrowItem {
   public HunterArrowItem(Item.Properties builder) {
      super(builder);
   }

   public HunterArrowEntity createArrow(World worldIn, ItemStack stack, LivingEntity shooter) {
      return new HunterArrowEntity(worldIn, shooter);
   }
}