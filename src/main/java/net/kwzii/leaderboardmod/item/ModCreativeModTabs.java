package net.kwzii.leaderboardmod.item;

import net.kwzii.leaderboardmod.LeaderboardMod;
import net.kwzii.leaderboardmod.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

/**
 * Class to create custom creative tab
 * @author Travis Brown
 */
public class ModCreativeModTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, LeaderboardMod.MOD_ID);

    public static final RegistryObject<CreativeModeTab> LEADERBOARDMOD_TAB =
            CREATIVE_MODE_TABS.register("leaderboardmod_tab", () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModBlocks.LEADERBOARD.get()))
                    .title(Component.translatable("creativetab.leaderboardmod_tab"))
            .displayItems((itemDisplayParameters, output) -> {
                // Add blocks to mod tab
                for(RegistryObject<Block> block : ModBlocks.BLOCKS.getEntries()) {
                    output.accept(block.get());
                }

                    // Add items to mod tab
                for(RegistryObject<Item> item : ModItems.ITEMS.getEntries()) {
                    output.accept(item.get());
                }
            }).build());

    /**
     * Registers an IEventBus with the mod creative tab
     * @param eventBus the IEventBus to be registered
     */
    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }

}
