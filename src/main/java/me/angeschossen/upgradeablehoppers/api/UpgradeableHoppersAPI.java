package me.angeschossen.upgradeablehoppers.api;


import me.angeschossen.upgradeablehoppers.api.exceptions.UnloadedTargetException;
import me.angeschossen.upgradeablehoppers.api.objects.Hopper;
import org.bukkit.Location;
import org.bukkit.block.Block;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.UUID;


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


    /**
     * Register a hopper.
     *
     * @param block    The block
     * @param ownerUID Owner of the future hopper
     * @throws IllegalArgumentException The block is not a hopper, the world is not a hopper world or the hopper already exists.
     * @throws IllegalStateException    Method not called on the main thread.
     * @throws UnloadedTargetException  The chunk is unloaded.
     */
    @NotNull
    public static Hopper registerHopper(@NotNull Block block, @NotNull UUID ownerUID) throws IllegalArgumentException, IllegalStateException, UnloadedTargetException {
        return null;
    }
}
