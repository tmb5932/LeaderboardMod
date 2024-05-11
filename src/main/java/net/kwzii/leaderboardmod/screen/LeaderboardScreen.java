package net.kwzii.leaderboardmod.screen;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import net.kwzii.leaderboardmod.LeaderboardMod;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.components.StringWidget;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;


/**
 * Leaderboard Screen Class
 * @author Travis Brown
 */
public class LeaderboardScreen extends AbstractContainerScreen<LeaderboardMenu> {
    private StringWidget rank1;
    private StringWidget rank2;
    private StringWidget rank3;
    private static final ResourceLocation TEXTURE =
            new ResourceLocation(LeaderboardMod.MOD_ID, "textures/gui/leaderboard_gui.png");
    private int midX;
    private int midY;

    /**
     * Constructor for the leaderboard screen
     * @param pMenu the menu to be shown
     * @param pPlayerInventory the player inventory
     * @param pTitle the title of the screen
     */
    public LeaderboardScreen(LeaderboardMenu pMenu, Inventory pPlayerInventory, Component pTitle) {
        super(pMenu, pPlayerInventory, pTitle);
    }

    @Override
    protected void init() {
        super.init();
        inventoryLabelY += 10000;
        midX = (width - imageWidth) / 2;
        midY = (height - imageHeight) / 2;
        rank1 = new StringWidget(midX - (midX / 14), midY, 75, 20, Component.literal("RANK 1 TEST"), this.font);
        rank2 = new StringWidget(midX - (midX / 14), midY + (midY / 2), 75, 20, Component.literal("RANK 2 TEST"), this.font);
        rank3 = new StringWidget(midX - (midX / 14), midY + (midY ), 75, 20, Component.literal("RANK 3 TEST"), this.font);
        rank1.setColor(0xFFFFFF);
        rank2.setColor(0xFFFFFF);
        rank3.setColor(0xFFFFFF);
        addRenderableWidget(rank1);
        addRenderableWidget(rank2);
        addRenderableWidget(rank3);
    }

    /**
     * Method to render the graphics
     * @param guiGraphics the gui graphics
     * @param pPartialTick float value partial tick
     * @param pMouseX int the mouse x value
     * @param pMouseY int the mouse y value
     */
    @Override
    protected void renderBg(GuiGraphics guiGraphics, float pPartialTick, int pMouseX, int pMouseY) {
        midX = (width - imageWidth) / 2;
        midY = (height - imageHeight) / 2;
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        RenderSystem.setShaderTexture(0, TEXTURE);
        int x = midX;
        int y = midY;
        rank1.setPosition(midX - (midX / 14), midY);
        rank2.setPosition(midX - (midX / 14), midY + (midY / 2));
        rank3.setPosition(midX - (midX / 14), midY + (midY ));
        guiGraphics.blit(TEXTURE, x, y, 0, 0, imageWidth, imageHeight);
        renderRankings();
    }

    /**
     * Method to render the updated rankings
     */
    private void renderRankings() {
//        System.out.println("UPDATED RANK1:" + menu.getRankingID(1) + ", " + menu.getRankingPoints(1));
        rank1.setMessage(Component.literal(menu.getRankingID(1) + ": " + menu.getRankingPoints(1)));
        rank2.setMessage(Component.literal(menu.getRankingID(2) + ": " + menu.getRankingPoints(2)));
        rank3.setMessage(Component.literal(menu.getRankingID(3) + ": " + menu.getRankingPoints(3)));
    }

    /**
     * Method to render the graphics
     * @param guiGraphics the graphics to render
     * @param mouseX the mouses x value
     * @param mouseY the mouses y value
     * @param delta the delta float
     */
    @Override
    public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float delta) {
        renderBackground(guiGraphics);
        super.render(guiGraphics, mouseX, mouseY, delta);
        renderTooltip(guiGraphics, mouseX, mouseY);
    }
}
