package net.kwzii.leaderboardmod.screen;

import net.kwzii.leaderboardmod.block.entity.ArcadeMachineBlockEntity;
import net.kwzii.leaderboardmod.block.entity.LeaderboardBlockEntity;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;

public class ArcadeMachineMenu extends AbstractContainerMenu {
    Level level;
    LeaderboardBlockEntity leaderboard;
    Player player;
    ArcadeMachineBlockEntity arcadeMachine;

    /**
     * Constructor for the Leaderboard Menu
     * Calls to other constructor
     */
    public ArcadeMachineMenu(int pContainerId, Inventory inv, FriendlyByteBuf extraData) {
        this(pContainerId, inv, inv.player.level().getBlockEntity(extraData.readBlockPos()));
    }

    public ArcadeMachineMenu(int pContainerId, Inventory inv, BlockEntity entity) {
        super(ModMenuTypes.ARCADE_MACHINE_MENU.get(), pContainerId);
        this.level = inv.player.level();
        this.player = inv.player;
        this.arcadeMachine = (ArcadeMachineBlockEntity) entity;
    }

    @Override
    public ItemStack quickMoveStack(Player pPlayer, int pIndex) {
        return null;
    }

    @Override
    public boolean stillValid(Player pPlayer) {
        return true;
    }

    public void uploadScore(int score) {
        System.out.println("CHECKPOINT 1; leaderboard: " + (leaderboard != null) + ", clientside: " + (!level.isClientSide));
        if (!level.isClientSide() && leaderboard != null) {
            System.out.println("CHECKPOINT 2");
            leaderboard.addScore(player.getScoreboardName(), score);
        }
    }

}
