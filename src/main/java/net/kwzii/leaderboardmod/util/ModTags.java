package net.kwzii.leaderboardmod.util;

import net.kwzii.leaderboardmod.LeaderboardMod;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

/**
 * Custom Mod Tags class
 * @author Travis Brown
 */
public class ModTags {

    /**
     * Custom Mod Tags for Blocks
     */
    public static class Blocks {

        /**
         * Method to create a new custom tag for blocks
         * @param name the name of the tag
         * @return the TagKey
         */
        private static TagKey<Block> tag(String name) {
            return BlockTags.create(new ResourceLocation(LeaderboardMod.MOD_ID, name));
        }
    }

    /**
     * Custom Mod Tags for Items
     */
    public static class Items {
        public static final TagKey<Item> EXAMPLE_ITEM_TAG = tag("example_item_tag");

        /**
         * Method to create a new custom tag for items
         * @param name the name of the tag
         * @return the TagKey
         */
        private static TagKey<Item> tag(String name) {
            return ItemTags.create(new ResourceLocation(LeaderboardMod.MOD_ID, name));
        }
    }
}
