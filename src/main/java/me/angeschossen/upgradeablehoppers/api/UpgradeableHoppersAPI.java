package me.angeschossen.upgradeablehoppers.api;


import me.angeschossen.upgradeablehoppers.api.objects.Hopper;
import org.bukkit.Location;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;


public class UpgradeableHoppersAPI {

    private UpgradeableHoppersAPI() {

    }

    public static @Nullable Hopper getHopper(@NotNull Location location) {
        return null;
    }

    public static boolean isHopper(@NotNull Location location) {
        return false;
    }

    public static void setItemStackerIntegration(@NotNull ItemStackerIntegration integration) {
    }
}
