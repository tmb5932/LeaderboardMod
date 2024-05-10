package net.kwzii.blankmod.block.entity;

import net.kwzii.blankmod.BlankMod;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

/**
 * Class for all the mod block entities to be registered
 * @author Travis Brown
 */
public class ModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, BlankMod.MOD_ID); // todo change mod id


    /**
     * Method to register an IEventBus with the block entities
     * @param eventBus IEventBus to be registered with the block entity deferred register
     */
    public static void register(IEventBus eventBus) {
        BLOCK_ENTITIES.register(eventBus);
    }

}
