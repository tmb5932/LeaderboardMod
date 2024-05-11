package net.kwzii.leaderboardmod.screen;

import net.kwzii.leaderboardmod.LeaderboardMod;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraftforge.common.extensions.IForgeMenuType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.network.IContainerFactory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

/**
 * Mod Menu Registration class
 * @author Travis Brown
 */
public class ModMenuTypes {
    public static final DeferredRegister<MenuType<?>> MENUS =
            DeferredRegister.create(ForgeRegistries.MENU_TYPES, LeaderboardMod.MOD_ID);

    public static final RegistryObject<MenuType<LeaderboardMenu>> LEADERBOARD_MENU =
            registerMenuType("leaderboard_menu", LeaderboardMenu::new);

    public static final RegistryObject<MenuType<ArcadeMachineMenu>> ARCADE_MACHINE_MENU =
            registerMenuType("arcade_machine_menu", ArcadeMachineMenu::new);

    private static <T extends AbstractContainerMenu>RegistryObject<MenuType<T>> registerMenuType(String name, IContainerFactory<T> factory) {
        return MENUS.register(name, () -> IForgeMenuType.create(factory));
    }

    /**
     * Method to register an IEventBus with the mod menus
     * @param eventBus IEventBus to be registered
     */
    public static void register(IEventBus eventBus) {
        MENUS.register(eventBus);
    }
}
