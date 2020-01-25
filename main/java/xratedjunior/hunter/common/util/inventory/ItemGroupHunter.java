package xratedjunior.hunter.common.util.inventory;

import net.minecraft.block.Blocks;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class ItemGroupHunter extends ItemGroup{

	public ItemGroupHunter() {
		super("hunter");
	}

	@Override
	public ItemStack createIcon() {
		return new ItemStack(Blocks.COBWEB);
	}
}
