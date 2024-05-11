package net.kwzii.leaderboardmod.item;

import net.kwzii.leaderboardmod.LeaderboardMod;
import net.kwzii.leaderboardmod.item.custom.LeaderboardResetTool;
import net.kwzii.leaderboardmod.item.custom.Tetris;
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
            DeferredRegister.create(ForgeRegistries.ITEMS, LeaderboardMod.MOD_ID);

    public static final RegistryObject<Item> TETRIS = ITEMS.register("tetris",
            () -> new Tetris(new Item.Properties()));

    public static final RegistryObject<Item> LEADERBOARD_RESET_TOOL = ITEMS.register("leaderboard_reset_tool",
            () -> new LeaderboardResetTool(new Item.Properties()));

    /**
     * Registers an IEventBus with the mod items
     * @param eventBus the IEventBus to be registered
     */
    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
