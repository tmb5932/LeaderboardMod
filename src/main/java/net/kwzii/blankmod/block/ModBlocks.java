package net.kwzii.blankmod.block;

import net.kwzii.blankmod.BlankMod;
import net.kwzii.blankmod.block.custom.ExampleBlock;
import net.kwzii.blankmod.item.ModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

/**
 * Class for all the mod blocks to be registered in
 * @author Travis Brown
 */
public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, BlankMod.MOD_ID); // todo change id

    // Example Block
    public static final RegistryObject<Block> EXAMPLE_BLOCK = registerBlock("example_block",
            () -> new ExampleBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noOcclusion()));

    private static <T extends Block>RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    /**
     * Function to register block a block
     * @param name the name of the block
     * @param block the block that is being registered
     * @return Registry object of the registered block
     * @param <T> Register object type
     */
    private static <T extends Block>RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    /**
     * Registers an IEventBus with the mod blocks
     * @param eventBus the IEventBus to be registered
     */
    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
