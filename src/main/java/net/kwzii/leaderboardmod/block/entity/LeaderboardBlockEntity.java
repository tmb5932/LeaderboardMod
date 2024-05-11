package net.kwzii.leaderboardmod.block.entity;

import net.kwzii.leaderboardmod.screen.LeaderboardMenu;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

public class LeaderboardBlockEntity extends BlockEntity implements MenuProvider {
    private boolean updated = false;
    private Ranking first = new Ranking("-", 0);
    private Ranking second = new Ranking("-", 0);
    private Ranking third = new Ranking("-", 0);
    private Ranking newScore;

    public LeaderboardBlockEntity(BlockPos pPos, BlockState pBlockState) {
        super(ModBlockEntities.LEADERBOARD_BE.get(), pPos, pBlockState);
        System.out.println(first);
        System.out.println(second);
        System.out.println(third);
    }

    /**
     * Sets the display name of the block entity
     * @return Component of what the name of the block entity is
     */
    @Override
    public Component getDisplayName() {
        return Component.translatable("block.leaderboardmod.leaderboard_block");
    }

    /**
     * Creates GUI menu for the leaderboard block entity
     * @param pContainerId the int container ID
     * @param inv the player inventory
     * @param player the player
     * @return new LeaderBoard Menu instance
     */

    @Nullable
    @Override
    public AbstractContainerMenu createMenu(int pContainerId, Inventory inv, Player player) {
        System.out.println(first);
        System.out.println(second);
        System.out.println(third);
        return new LeaderboardMenu(pContainerId, inv, this);
    }

    /**
     * Method to save additional information to server files
     * @param pTag data structure used to store information
     */
    @Override
    protected void saveAdditional(CompoundTag pTag) {
        pTag.putString("leaderboard.first_name", first.name());
        pTag.putInt("leaderboard.first_pts", first.points());

        pTag.putString("leaderboard.second_name", second.name());
        pTag.putInt("leaderboard.second_pts", second.points());

        pTag.putString("leaderboard.third_name", third.name());
        pTag.putInt("leaderboard.third_pts", third.points());
        super.saveAdditional(pTag);
    }

    /**
     * Loads saved information about block
     * @param pTag data structure used to store information
     */
    @Override
    public void load(CompoundTag pTag) {
        super.load(pTag);

        String firstName = pTag.getString("leaderboard.first_name");
        int firstPoints = pTag.getInt("leaderboard.first_pts");
        first = new Ranking(firstName, firstPoints);

        String secondName = pTag.getString("leaderboard.second_name");
        int secondPoints = pTag.getInt("leaderboard.second_pts");
        second = new Ranking(secondName, secondPoints);

        String thirdName = pTag.getString("leaderboard.third_name");
        int thirdPoints = pTag.getInt("leaderboard.third_pts");
        third = new Ranking(thirdName, thirdPoints);
    }

    /**
     * Method that runs every tick
     * Checks if new score has been added, and if so, update leaderboard
     * @param pLevel the world instance the tick is happening on
     * @param pPos the block's position
     * @param pState the state of the block
     */
    public void tick(Level pLevel, BlockPos pPos, BlockState pState) {
        if (updated) {
            if (newScore.points() > third.points()) {
                third = newScore;
                if (newScore.points() > second.points()) {
                    third = second;
                    second = newScore;
                    if (newScore.points() > first.points()) {
                        second = first;
                        first = newScore;
                    }
                }
            }
            updated = false;
        }
    }

    public void addScore(String name, int points) {
        newScore = new Ranking(name, points);
        updated = true;
    }

    public String getRankingID(int i) {
        switch(i) {
            case 1 -> { return first.name(); }
            case 2 -> { return second.name(); }
            case 3 -> { return third.name(); }
            default -> throw new IllegalArgumentException("Invalid integer value: " + i);
        }
    }

    public int getRankingPoints(int i) {
        switch(i) {
            case 1 -> { return first.points(); }
            case 2 -> { return second.points(); }
            case 3 -> { return third.points(); }
            default -> throw new IllegalArgumentException("Invalid integer value: " + i);
        }
    }
}

record Ranking(String name, int points) {
    @Override
    public String toString() {
        return "Ranking{" +
                "name='" + name + '\'' +
                ", points=" + points +
                '}';
    }
}
