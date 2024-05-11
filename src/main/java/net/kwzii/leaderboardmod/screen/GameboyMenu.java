package net.kwzii.leaderboardmod.screen;

import net.kwzii.leaderboardmod.block.ModBlocks;
import net.kwzii.leaderboardmod.block.entity.LeaderboardBlockEntity;
import net.kwzii.leaderboardmod.item.custom.Gameboy;
import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class GameboyMenu extends AbstractContainerMenu {
    Level level;
    BlockPos leaderboardPos;
    LeaderboardBlockEntity leaderboard;
    Player player;

    /**
     * Constructor for the Leaderboard Menu
     * Calls to other constructor
     */
    public GameboyMenu(int pContainerId, Inventory inv, FriendlyByteBuf extraData) {
        this(pContainerId, inv);
    }

    public GameboyMenu(int pContainerId, Inventory inv) {
        super(ModMenuTypes.GAMEBOY_MENU.get(), pContainerId);
        level = inv.player.level();
        Gameboy gameboy = (Gameboy) inv.player.getItemInHand(InteractionHand.MAIN_HAND).getItem();
        leaderboardPos = gameboy.getLeaderboard();
        player = inv.player;

        if (level.getBlockState(leaderboardPos).getBlock() == ModBlocks.LEADERBOARD.get())
            leaderboard = (LeaderboardBlockEntity) level.getBlockEntity(leaderboardPos);
        else
            leaderboard = null;
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
        if (!level.isClientSide && leaderboard != null) {
            leaderboard.addScore(player.getScoreboardName(), score);
        }
    }

}