package net.kwzii.leaderboardmod.datagen;

import net.kwzii.leaderboardmod.LeaderboardMod;
import net.kwzii.leaderboardmod.block.ModBlocks;
import net.kwzii.leaderboardmod.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

/**
 * Mod Recipe Provider Class
 * @author Travis Brown
 */
public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    /**
     * Constructor for Mod Recipe Provider
     * @param pOutput the PackOutput
     */
    public ModRecipeProvider(PackOutput pOutput) {
        super(pOutput);
    }

    /**
     * Method to build custom recipes for custom mod blocks and items
     * @param consumer the Finished Recipe Consumer
     */
    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> consumer) {
        // Leaderboard Recipe
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.LEADERBOARD.get())
                .pattern(" B ")
                .pattern(" P ")
                .pattern("PPP")
                .define('P', ItemTags.PLANKS)
                .define('B', ItemTags.BANNERS)
                .unlockedBy(getHasName(Items.WHITE_BANNER), has(Items.WHITE_BANNER))
                .save(consumer);
    }

    /**
     * Method to simplify making an ore smelting recipe
     * @param pFinishedRecipeConsumer the finished recipe consumer
     * @param pIngredients the ingredients
     * @param pCategory the category
     * @param pResult the result from the smelting
     * @param pExperience the experience gained from the smelting
     * @param pCookingTime the cook time of the smelting
     * @param pGroup the group
     */
    protected static void oreSmelting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup) {
        oreCooking(pFinishedRecipeConsumer, RecipeSerializer.SMELTING_RECIPE, pIngredients, pCategory, pResult, pExperience, pCookingTime, pGroup, "_from_smelting");
    }

    /**
     * Method to simplify making an ore blasting recipe
     * @param pFinishedRecipeConsumer the finished recipe consumer
     * @param pIngredients the ingredients
     * @param pCategory the category
     * @param pResult the result from the smelting
     * @param pExperience the experience gained from the smelting
     * @param pCookingTime the cook time of the smelting
     * @param pGroup the group
     */
    protected static void oreBlasting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup) {
        oreCooking(pFinishedRecipeConsumer, RecipeSerializer.BLASTING_RECIPE, pIngredients, pCategory, pResult, pExperience, pCookingTime, pGroup, "_from_blasting");
    }

    /**
     * Method to simplify making an ore cooking recipe
     * @param pFinishedRecipeConsumer the finished recipe consumer
     * @param pCookingSerializer the cooking serializer
     * @param pIngredients the ingredients
     * @param pCategory the category
     * @param pResult the result from the smelting
     * @param pExperience the experience gained from the smelting
     * @param pCookingTime the cook time of the smelting
     * @param pGroup the group
     * @param pRecipeName the recipe name
     */
    protected static void oreCooking(Consumer<FinishedRecipe> pFinishedRecipeConsumer, RecipeSerializer<? extends AbstractCookingRecipe> pCookingSerializer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup, String pRecipeName) {
        Iterator var9 = pIngredients.iterator();

        while(var9.hasNext()) {
            ItemLike itemlike = (ItemLike)var9.next();
            SimpleCookingRecipeBuilder.generic(Ingredient.of(new ItemLike[]{itemlike}), pCategory, pResult, pExperience, pCookingTime, pCookingSerializer)
                    .group(pGroup).unlockedBy(getHasName(itemlike), has(itemlike))
                    .save(pFinishedRecipeConsumer, LeaderboardMod.MOD_ID + ":" + getItemName(pResult) + pRecipeName + "_" + getItemName(itemlike));
        }
    }

}
