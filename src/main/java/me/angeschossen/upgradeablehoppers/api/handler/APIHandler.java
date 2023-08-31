package me.angeschossen.upgradeablehoppers.api.handler;

import me.angeschossen.upgradeablehoppers.api.UpgradeableHoppersAPI;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

/**
 * This class is not intended for direct usage and might change at any time.
 */
public class APIHandler {

    private static APIHandler instance;
    private final UpgradeableHoppersAPI api;

    @NotNull
    public UpgradeableHoppersAPI getAPI() {
        return api;
    }

    private APIHandler(@NotNull UpgradeableHoppersAPI api) {
        this.api = api;
    }

    public static APIHandler getInstance() {
        return instance;
    }

    public static void init(@NotNull UpgradeableHoppersAPI api) {
        Objects.requireNonNull(api);
        if (instance != null) {
            throw new IllegalStateException("Already initialized.");
        }

        instance = new APIHandler(api);
    }
}
