package net.kwzii.blankmod.item;

import net.kwzii.blankmod.BlankMod;
import net.kwzii.blankmod.item.custom.ExampleItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

/**
 * Class of all custom items added
 * @author Travis Brown
 */
public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, BlankMod.MOD_ID); // todo change mod id

    // Example item
    public static final RegistryObject<Item> EXAMPLE_ITEM = ITEMS.register("example_item",
            () -> new ExampleItem(new Item.Properties().stacksTo(64)));

    /**
     * Registers an IEventBus with the mod items
     * @param eventBus the IEventBus to be registered
     */
    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
