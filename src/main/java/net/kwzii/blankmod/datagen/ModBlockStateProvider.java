package net.kwzii.blankmod.datagen;

import net.kwzii.blankmod.BlankMod;
import net.kwzii.blankmod.block.ModBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

/**
 * Class to create custom mod blocks json files
 * @author Travis Brown
 */
public class ModBlockStateProvider extends BlockStateProvider {
    /**
     * Constructor for the Mod Block State Provider
     * @param output the PackOutput
     * @param exFileHelper the existing file helper
     */
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, BlankMod.MOD_ID, exFileHelper); // todo change mod id
    }

    /**
     * Method to register block states and models
     */
    @Override
    protected void registerStatesAndModels() {
        // Example block state
        blockWithItem(ModBlocks.EXAMPLE_BLOCK);

    }

    /**
     * Custom registration method to register custom blocks easier
     * @param blockRegistryObject the block to register
     */
    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }
}
