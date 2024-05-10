package net.kwzii.leaderboardmod.screen;

import net.kwzii.leaderboardmod.block.ModBlocks;
import net.kwzii.leaderboardmod.block.entity.LeaderboardBlockEntity;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.inventory.SimpleContainerData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;

public class LeaderboardMenu extends AbstractContainerMenu {
    public final LeaderboardBlockEntity blockEntity;
    private final Level level;

    /**
     * Constructor for the Leaderboard Menu
     * Calls to other constructor
     */
    public LeaderboardMenu(int pContainerId, Inventory inv, FriendlyByteBuf extraData) {
        this(pContainerId, inv, inv.player.level().getBlockEntity(extraData.readBlockPos()));
    }

    /**
     * Constructor for Leaderboard Menu
     * @param pContainerId the Container ID
     * @param inv the player inventory
     * @param entity the block entity
     */
    public LeaderboardMenu(int pContainerId, Inventory inv, BlockEntity entity) {
        super(ModMenuTypes.LEADERBOARD_MENU.get(), pContainerId);

        this.blockEntity = ((LeaderboardBlockEntity) entity);
        this.level = inv.player.level();
    }

    @Override
    public ItemStack quickMoveStack(Player pPlayer, int pIndex) {
        return null;
    }

    /**
     * Checks for validity
     * @param pPlayer the player
     * @return true if stillValid call is true, false otherwise
     */
    @Override
    public boolean stillValid(Player pPlayer) {
        return stillValid(ContainerLevelAccess.create(level, blockEntity.getBlockPos()),
                pPlayer, ModBlocks.LEADERBOARD.get());
    }

    public String getRankingID(int i) {
        return blockEntity.getRankingID(i);
    }

    public int getRankingPoints(int i) {
        return blockEntity.getRankingPoints(i);
    }
}
