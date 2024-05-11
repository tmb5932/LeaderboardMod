package net.kwzii.leaderboardmod.block.entity;

import net.kwzii.leaderboardmod.LeaderboardMod;
import net.kwzii.leaderboardmod.block.ModBlocks;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

/**
 * Class for all the mod block entities to be registered
 * @author Travis Brown
 */
public class ModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, LeaderboardMod.MOD_ID);

    public static final RegistryObject<BlockEntityType<LeaderboardBlockEntity>> LEADERBOARD_BE =
            BLOCK_ENTITIES.register("leaderboard_be", () ->
                    BlockEntityType.Builder.of(LeaderboardBlockEntity::new, ModBlocks.LEADERBOARD.get()).build(null));

    public static final RegistryObject<BlockEntityType<ArcadeMachineBlockEntity>> ARCADE_MACHINE_BE =
            BLOCK_ENTITIES.register("arcade_machine_be", () ->
                    BlockEntityType.Builder.of(ArcadeMachineBlockEntity::new, ModBlocks.ARCADE_MACHINE.get()).build(null));

    /**
     * Method to register an IEventBus with the block entities
     * @param eventBus IEventBus to be registered with the block entity deferred register
     */
    public static void register(IEventBus eventBus) {
        BLOCK_ENTITIES.register(eventBus);
    }

}
