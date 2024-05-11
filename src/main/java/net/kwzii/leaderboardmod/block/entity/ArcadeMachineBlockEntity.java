package net.kwzii.leaderboardmod.block.entity;

import net.kwzii.leaderboardmod.block.custom.ArcadeMachineBlock;
import net.kwzii.leaderboardmod.screen.ArcadeMachineMenu;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

public class ArcadeMachineBlockEntity extends BlockEntity implements MenuProvider {
    LeaderboardBlockEntity leaderboard;

    public ArcadeMachineBlockEntity(BlockPos pPos, BlockState pBlockState) {
        super(ModBlockEntities.ARCADE_MACHINE_BE.get(), pPos, pBlockState);
    }

    /**
     * Sets the display name of the block entity
     * @return Component of what the name of the block entity is
     */
    @Override
    public Component getDisplayName() {
        return Component.translatable("leaderboardmod.arcade_machine_block");
    }

    /**
     * Creates arcade machine menu
     * @param pContainerId the menu container id
     * @param pPlayerInventory the players inventory
     * @param pPlayer the player who opened the menu
     * @return the created menu
     */
    @Nullable
    @Override
    public AbstractContainerMenu createMenu(int pContainerId, Inventory pPlayerInventory, Player pPlayer) {
        return new ArcadeMachineMenu(pContainerId, pPlayerInventory, this);
    }

    public void link(BlockPos pos) {
        if (!level.isClientSide && level.getBlockState(pos).getBlock() instanceof ArcadeMachineBlock)
            leaderboard = (LeaderboardBlockEntity) level.getBlockEntity(pos);
    }
}
