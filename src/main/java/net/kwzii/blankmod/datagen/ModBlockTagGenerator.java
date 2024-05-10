package net.kwzii.blankmod.datagen;

import net.kwzii.blankmod.BlankMod;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

/**
 * Class to generate tags for custom mod blocks
 * @author Travis Brown
 */
public class ModBlockTagGenerator extends BlockTagsProvider {
    /**
     * Constructor for mod block tag generation
     * @param output the Pack Output
     * @param lookupProvider the lookupProvider
     * @param existingFileHelper the existing File Helper
     */
    public ModBlockTagGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, BlankMod.MOD_ID, existingFileHelper); // todo: change mod id
    }

    /**
     * Method to add blocks to custom tags
     * @param provider the provider
     */
    @Override
    protected void addTags(HolderLookup.Provider provider) {

//        this.tag(BlockTags.NEEDS_STONE_TOOL).add(
//        );

//        this.tag(BlockTags.NEEDS_IRON_TOOL).add(
//        );

//        this.tag(BlockTags.NEEDS_DIAMOND_TOOL).add(
//        );

//        this.tag(Tags.Blocks.NEEDS_NETHERITE_TOOL).add(
//        );

//        this.tag(BlockTags.MINEABLE_WITH_PICKAXE).add(
//        );

//        this.tag(BlockTags.MINEABLE_WITH_AXE).add(
//        );

//        this.tag(BlockTags.MINEABLE_WITH_HOE).add(
//        );

//        this.tag(BlockTags.MINEABLE_WITH_SHOVEL).add(
//        );
    }
}
