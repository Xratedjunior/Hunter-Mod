package xratedjunior.hunter.init;

import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;
import xratedjunior.hunter.api.item.HunterModItems;
import xratedjunior.hunter.common.item.HunterArrowItem;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class HunterModItemsInit 
{
	//public static final ItemGroup HUNTERTAB = HunterMod.HUNTERTAB;

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event)
	{
    	event.getRegistry().registerAll(
    			
    			//Bow
    			//HunterModItems.hunter_bow = registerItem(new BowItem((new Item.Properties()).tab(HUNTERTAB)), "hunter_bow"),
    			//Arrow
    			HunterModItems.hunter_arrow = registerItem(new HunterArrowItem((new Item.Properties()).group(ItemGroup.COMBAT)), "hunter_arrow")
    	);
	}
    
    public static Item registerItem(Item item, String name)
    {
    	item.setRegistryName(name);
        ForgeRegistries.ITEMS.register(item);
        return item;
    }
}
