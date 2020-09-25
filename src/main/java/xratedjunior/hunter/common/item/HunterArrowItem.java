package xratedjunior.hunter.common.item;

import java.util.List;

import javax.annotation.Nullable;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ArrowItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import xratedjunior.hunter.common.entity.projectile.HunterArrowEntity;

public class HunterArrowItem extends ArrowItem {
   public HunterArrowItem(Item.Properties builder) {
      super(builder);
   }

   public HunterArrowEntity createArrow(World worldIn, ItemStack stack, LivingEntity shooter) {
      return new HunterArrowEntity(worldIn, shooter);
   }
   
	/**
	* allows items to add custom lines of information to the mouseover description
	*/
	@OnlyIn(Dist.CLIENT)
	public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
	   if (Screen.func_231173_s_()) {
		   if(flagIn.isAdvanced()) {
			   tooltip.add(new TranslationTextComponent("tooltip.huntermod.hunter_arrow").func_240699_a_(TextFormatting.ITALIC).func_240699_a_(TextFormatting.GRAY));
		   }
			   tooltip.add(new StringTextComponent("Poison (0:10)").func_240699_a_(TextFormatting.RED));
			   tooltip.add(new StringTextComponent("Glowing (0:10)").func_240699_a_(TextFormatting.GOLD));
	   }
	   else {
		   tooltip.add(new TranslationTextComponent("tooltip.huntermod.hold_shift").func_240699_a_(TextFormatting.DARK_GRAY));
	   }
	}
}