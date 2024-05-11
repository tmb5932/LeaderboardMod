package net.kwzii.leaderboardmod.item.custom;

import net.kwzii.leaderboardmod.block.ModBlocks;
import net.kwzii.leaderboardmod.block.entity.ArcadeMachineBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.extensions.IForgeItem;

public class LeaderboardLinkerTool extends Item implements IForgeItem {
    private boolean linked = false;
    private BlockPos leaderboard = null;

    public LeaderboardLinkerTool(Properties pProperties) {
        super(pProperties.stacksTo(1).rarity(Rarity.UNCOMMON));
    }

    @Override
    public UseAnim getUseAnimation(ItemStack pStack) {
        return UseAnim.NONE;
    }

    @Override
    public InteractionResult useOn(UseOnContext pContext) {
        if (!pContext.getLevel().isClientSide) {
            Block block = pContext.getLevel().getBlockState(pContext.getClickedPos()).getBlock();
            if (block == ModBlocks.LEADERBOARD.get()) {
                leaderboard = pContext.getClickedPos();
                linked = true;
                pContext.getPlayer().sendSystemMessage(Component.literal("Leaderboard Data Added!"));
            } else if (block == ModBlocks.ARCADE_MACHINE.get() && linked) {
                ArcadeMachineBlockEntity machine = (ArcadeMachineBlockEntity) pContext.getLevel().getBlockEntity(pContext.getClickedPos());
                machine.link(leaderboard);
                pContext.getPlayer().sendSystemMessage(Component.literal("Arcade Machine Linked!"));
            }
        }
        return InteractionResult.PASS;
    }

    public BlockPos getLeaderboard() {
        return leaderboard;
    }
}
