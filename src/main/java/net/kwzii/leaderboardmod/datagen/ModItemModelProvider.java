package net.kwzii.leaderboardmod.datagen;

import net.kwzii.leaderboardmod.LeaderboardMod;
import net.kwzii.leaderboardmod.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

/**
 * Mod Item datagen class
 * @author Travis Brown
 */
public class ModItemModelProvider extends ItemModelProvider {
    /**
     * Constructor for mod item data gen
     * @param output PackOutput
     * @param existingFileHelper the existing file helper
     */
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, LeaderboardMod.MOD_ID, existingFileHelper);
    }

    /**
     * Method to register the custom mod item models
     */
    @Override
    protected void registerModels() {
        // Item model example
        simpleItem(ModItems.GAMEBOY);
        simpleItem(ModItems.LEADERBOARD_RESET_TOOL);

        // Creates Item models for blocks that have a non data gen block state and model
//        withExistingParent("example_custom_block", modLoc("block/example_custom_block"));
    }

    /**
     * Method to create a simple item
     * @param item the custom mod item to be created
     * @return the ItemModelBuilder
     */
    private ItemModelBuilder simpleItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(LeaderboardMod.MOD_ID, "item/" + item.getId().getPath()));
    }
}
