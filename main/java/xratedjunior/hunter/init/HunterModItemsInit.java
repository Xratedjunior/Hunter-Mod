package xratedjunior.hunter.init;

import org.apache.logging.log4j.Logger;

import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;
import xratedjunior.hunter.common.item.HunterArrowItem;
import xratedjunior.hunter.core.HunterMod;

import static xratedjunior.hunter.api.item.HunterModItems.*;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class HunterModItemsInit 
{
    public static Logger logger = HunterMod.logger;
	
	//public static final ItemGroup HUNTERTAB = HunterMod.HUNTERTAB;

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event)
	{
    	//Bow
		//hunter_bow = registerItem(new BowItem((new Item.Properties()).tab(HUNTERTAB)), "hunter_bow"),
		
    	//Arrow
    	hunter_arrow = registerItem(new HunterArrowItem((new Item.Properties()).group(ItemGroup.COMBAT)), "hunter_arrow");
    	
    	logger.info("Items registered");
	}
    
    public static Item registerItem(Item item, String name)
    {
    	item.setRegistryName(name);
        ForgeRegistries.ITEMS.register(item);
        return item;
    }
}
