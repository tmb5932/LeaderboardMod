package net.kwzii.leaderboardmod.datagen;

import net.kwzii.leaderboardmod.LeaderboardMod;
import net.kwzii.leaderboardmod.item.ModItems;
import net.kwzii.leaderboardmod.util.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

/**
 * Mod Item Tag Generator Class
 * @author Travis Brown
 */
public class ModItemTagGenerator extends ItemTagsProvider {
    /**
     * Constructor for Mod Item Generator
     * @param p_275343_ the packoutput
     * @param p_275729_ the provider
     * @param p_275322_ the tag lookup
     * @param existingFileHelper the existing file helper
     */
    public ModItemTagGenerator(PackOutput p_275343_, CompletableFuture<HolderLookup.Provider> p_275729_, CompletableFuture<TagLookup<Block>> p_275322_, @Nullable ExistingFileHelper existingFileHelper) {
        super(p_275343_, p_275729_, p_275322_, LeaderboardMod.MOD_ID, existingFileHelper);
    }

    /**
     * Method to add items to custom tags
     * @param provider the provider
     */
    @Override
    protected void addTags(HolderLookup.Provider provider) {


    }
}
