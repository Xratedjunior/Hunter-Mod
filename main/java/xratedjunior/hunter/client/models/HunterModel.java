package xratedjunior.hunter.client.models;

import com.mojang.blaze3d.matrix.MatrixStack;

import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.IRangedAttackMob;
import net.minecraft.entity.MobEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.HandSide;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class HunterModel <T extends MobEntity & IRangedAttackMob> extends BipedModel<T> {
   public HunterModel() {
	      this(0.0F, false);
   }
	      
	public HunterModel(float modelSize, boolean smallArmsIn) {
		super(modelSize);
	}

   public void setLivingAnimations(T entityIn, float limbSwing, float limbSwingAmount, float partialTick) {
	      this.rightArmPose = BipedModel.ArmPose.EMPTY;
	      this.leftArmPose = BipedModel.ArmPose.EMPTY;
	      ItemStack itemstack = entityIn.getHeldItem(Hand.MAIN_HAND);
	      if (itemstack.getItem() instanceof net.minecraft.item.BowItem && entityIn.isAggressive()) {
	         if (entityIn.getPrimaryHand() == HandSide.RIGHT) {
	            this.rightArmPose = BipedModel.ArmPose.BOW_AND_ARROW;
	         } else {
	            this.leftArmPose = BipedModel.ArmPose.BOW_AND_ARROW;
	         }
	      }

	      super.setLivingAnimations(entityIn, limbSwing, limbSwingAmount, partialTick);
	   }

   public void func_225597_a_(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor) {
      super.func_225597_a_(entityIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
      ItemStack itemstack = entityIn.getHeldItemMainhand();
      if (entityIn.isAggressive() && (itemstack.isEmpty() || !(itemstack.getItem() instanceof net.minecraft.item.BowItem))) {
         float f = MathHelper.sin(this.swingProgress * (float)Math.PI);
         float f1 = MathHelper.sin((1.0F - (1.0F - this.swingProgress) * (1.0F - this.swingProgress)) * (float)Math.PI);
         this.bipedRightArm.rotateAngleZ = 0.0F;
         this.bipedLeftArm.rotateAngleZ = 0.0F;
         this.bipedRightArm.rotateAngleY = -(0.1F - f * 0.6F);
         this.bipedLeftArm.rotateAngleY = 0.1F - f * 0.6F;
         this.bipedRightArm.rotateAngleX = (-(float)Math.PI / 2F);
         this.bipedLeftArm.rotateAngleX = (-(float)Math.PI / 2F);
         this.bipedRightArm.rotateAngleX -= f * 1.2F - f1 * 0.4F;
         this.bipedLeftArm.rotateAngleX -= f * 1.2F - f1 * 0.4F;
         this.bipedRightArm.rotateAngleZ += MathHelper.cos(ageInTicks * 0.09F) * 0.05F + 0.05F;
         this.bipedLeftArm.rotateAngleZ -= MathHelper.cos(ageInTicks * 0.09F) * 0.05F + 0.05F;
         this.bipedRightArm.rotateAngleX += MathHelper.sin(ageInTicks * 0.067F) * 0.05F;
         this.bipedLeftArm.rotateAngleX -= MathHelper.sin(ageInTicks * 0.067F) * 0.05F;
      }
   }
   
   public void translateToHand(HandSide p_225599_1_, MatrixStack p_225599_2_) {
      float f = p_225599_1_ == HandSide.RIGHT ? 1.0F : -1.0F;
      ModelRenderer modelrenderer = this.getArmForSide(p_225599_1_);
      modelrenderer.rotationPointX += f;
      modelrenderer.func_228307_a_(p_225599_2_);
      modelrenderer.rotationPointX -= f;
   }
}