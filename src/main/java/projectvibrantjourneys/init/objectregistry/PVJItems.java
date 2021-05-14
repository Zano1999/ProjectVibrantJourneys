package projectvibrantjourneys.init.objectregistry;

import java.util.ArrayList;

import net.minecraft.entity.EntityType;
import net.minecraft.item.Item;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import projectvibrantjourneys.core.ProjectVibrantJourneys;
import projectvibrantjourneys.init.PVJItemGroup;

@EventBusSubscriber(modid = ProjectVibrantJourneys.MOD_ID, bus = EventBusSubscriber.Bus.MOD)
public class PVJItems {
	public static final ArrayList<Item> ITEMS = new ArrayList<Item>();
	
	
	
	@SubscribeEvent
	public static void initItems(RegistryEvent.Register<Item> event) {
		createSpawnEgg(PVJEntities.FLY, 0x7e7e7e, 0xb3b3b3);
		createSpawnEgg(PVJEntities.FIREFLY, 0xd4d360, 0xf5f371);
		
		ITEMS.forEach((e) -> event.getRegistry().register(e));
	}
	
	public static Item registerItem(Item item, String name) {
		item.setRegistryName(new ResourceLocation(ProjectVibrantJourneys.MOD_ID, name));
		ITEMS.add(item);
		
		return item;
	}
	
	public static Item createSpawnEgg(EntityType<?> entity, int color1, int color2) {
		return registerItem(new SpawnEggItem(entity, color2, color2, new Item.Properties().tab(PVJItemGroup.PVJ_ITEMGROUP)), entity.getRegistryName().getPath() + "_spawn_egg");
	}
}
