package me.angeschossen.upgradeablehoppers.api.handler;

import me.angeschossen.upgradeablehoppers.api.UpgradeableHoppersAPI;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

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

    @NotNull
    public static APIHandler init(@NotNull UpgradeableHoppersAPI api) {
        Objects.requireNonNull(api);
        if (instance != null) {
            throw new IllegalStateException("Already initialized.");
        }

        instance = new APIHandler(api);
        return instance;
    }


}
