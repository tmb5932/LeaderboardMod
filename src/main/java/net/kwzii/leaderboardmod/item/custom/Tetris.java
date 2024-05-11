package net.kwzii.leaderboardmod.item.custom;

import net.kwzii.leaderboardmod.block.ModBlocks;
import net.kwzii.leaderboardmod.block.entity.LeaderboardBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;

public class Tetris extends Item {
    private boolean linked = false;
    private BlockPos leaderboard = null;
    private int pointVal = 100;

    public Tetris(Properties pProperties) {
        super(pProperties.stacksTo(1).rarity(Rarity.EPIC));
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {
        if (!pLevel.isClientSide) {
            if (linked && pLevel.getBlockState(leaderboard).getBlock() == ModBlocks.LEADERBOARD.get()) {
                LeaderboardBlockEntity blockEntity = (LeaderboardBlockEntity) pLevel.getBlockEntity(leaderboard);
                if (!pPlayer.isShiftKeyDown()) {
                blockEntity.addScore(pPlayer.getDisplayName().getString(), pointVal);
                pointVal += 100;
                }
            } else {
                linked = false;
                leaderboard = null;
            }
            return InteractionResultHolder.success(pPlayer.getItemInHand(pUsedHand));
        }
        return InteractionResultHolder.fail(pPlayer.getItemInHand(pUsedHand));
    }

    @Override
    public InteractionResult useOn(UseOnContext pContext) {
        if (!pContext.getLevel().isClientSide) {
            if (pContext.getLevel().getBlockState(pContext.getClickedPos()).getBlock() == ModBlocks.LEADERBOARD.get()) {
                leaderboard = pContext.getClickedPos();
                linked = true;
            }
        }
        return InteractionResult.PASS;
    }


}
