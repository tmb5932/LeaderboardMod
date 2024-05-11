package net.kwzii.leaderboardmod.item.custom;

import net.kwzii.leaderboardmod.block.ModBlocks;
import net.kwzii.leaderboardmod.block.entity.LeaderboardBlockEntity;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.context.UseOnContext;

public class LeaderboardResetTool extends Item {
    public LeaderboardResetTool(Properties pProperties) {
        super(pProperties.stacksTo(1).rarity(Rarity.EPIC));
    }

    @Override
    public InteractionResult useOn(UseOnContext pContext) {
        if (!pContext.getLevel().isClientSide() && pContext.getLevel()
                .getBlockState(pContext.getClickedPos()).getBlock() == ModBlocks.LEADERBOARD.get()) {
            LeaderboardBlockEntity entity = (LeaderboardBlockEntity) pContext.getLevel().getBlockEntity(pContext.getClickedPos());
            assert entity != null;
            entity.resetLeaderboard();
        }
        return InteractionResult.SUCCESS;
    }
}
