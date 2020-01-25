package xratedjunior.hunter.common.entity.projectile;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.AbstractArrowEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.world.World;
import xratedjunior.hunter.api.item.HunterModItems;
import xratedjunior.hunter.common.item.HunterArrowItem;

public class HunterArrowEntity extends AbstractArrowEntity {
   private int duration = 200;

   public HunterArrowEntity(EntityType<? extends HunterArrowEntity> p_i50158_1_, World p_i50158_2_) {
      super(p_i50158_1_, p_i50158_2_);
   }

   public HunterArrowEntity(World worldIn, LivingEntity shooter) {
      super(EntityType.ARROW, shooter, worldIn);
   }

   public HunterArrowEntity(World worldIn, double x, double y, double z) {
      super(EntityType.ARROW, x, y, z, worldIn);
   }

   /**
    * Called to update the entity's position/logic.
    */
   public void tick() {
      super.tick();
      if (this.world.isRemote() && !this.inGround) {
         this.world.addParticle(ParticleTypes.INSTANT_EFFECT, this.func_226277_ct_(), this.func_226278_cu_(), this.func_226281_cx_(), 0.0D, 0.0D, 0.0D);
      }

   }

   protected ItemStack getArrowStack() {
      return new ItemStack(HunterModItems.hunter_arrow);
   }

   protected void arrowHit(LivingEntity living) {
      super.arrowHit(living);
      EffectInstance effectinstance1 = new EffectInstance(Effects.POISON, this.duration, 0);
      EffectInstance effectinstance2 = new EffectInstance(Effects.GLOWING, this.duration, 0);
      living.addPotionEffect(effectinstance1);
      living.addPotionEffect(effectinstance2);
   }

   /**
    * (abstract) Protected helper method to read subclass entity data from NBT.
    */
   public void readAdditional(CompoundNBT compound) {
      super.readAdditional(compound);
      if (compound.contains("Duration")) {
         this.duration = compound.getInt("Duration");
      }

   }

   public void writeAdditional(CompoundNBT compound) {
      super.writeAdditional(compound);
      compound.putInt("Duration", this.duration);
   }
   
   public static HunterArrowEntity shootHunterArrow(LivingEntity livingEntity, ItemStack itemStack, float damage) {
      HunterArrowItem arrowitem = (HunterArrowItem)(itemStack.getItem() instanceof HunterArrowItem ? itemStack.getItem() : HunterModItems.hunter_arrow);
      HunterArrowEntity abstractarrowentity = arrowitem.createArrow(livingEntity.world, itemStack, livingEntity);
      abstractarrowentity.setEnchantmentEffectsFromEntity(livingEntity, damage);
      return abstractarrowentity;
   }
}