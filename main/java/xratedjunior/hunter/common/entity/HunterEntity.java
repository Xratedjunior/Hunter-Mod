package xratedjunior.hunter.common.entity;

import java.util.Random;

import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.Difficulty;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;

public class HunterEntity extends HunterEntityAbstract{
   public HunterEntity(EntityType<? extends HunterEntity> p_i50194_1_, World p_i50194_2_) {
	      super(p_i50194_1_, p_i50194_2_);
	   }

	   protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
	      return SoundEvents.ENTITY_GENERIC_HURT;
	   }

	   protected SoundEvent getDeathSound() {
	      return SoundEvents.ENTITY_GENERIC_DEATH;
	   }

	   protected SoundEvent getStepSound() {
	      return SoundEvents.ENTITY_WOLF_STEP;
	   }
	   
	   public static boolean checkHunterSpawnRules(EntityType<? extends HunterEntity> type, IWorld worldIn, SpawnReason reason, BlockPos pos, Random randomIn) {
	      return worldIn.getDifficulty() != Difficulty.PEACEFUL && worldIn.getBlockState(pos.down()).getBlock() == Blocks.GRASS_BLOCK && func_223315_a(type, worldIn, reason, pos, randomIn) && pos.getY() > worldIn.getSeaLevel();
	   }
}