package me.angeschossen.upgradeablehoppers.api;

import me.angeschossen.upgradeablehoppers.api.exceptions.UnloadedTargetException;
import me.angeschossen.upgradeablehoppers.api.handler.APIHandler;
import me.angeschossen.upgradeablehoppers.api.hopper.Hopper;
import me.angeschossen.upgradeablehoppers.api.player.HopperPlayer;
import me.angeschossen.upgradeablehoppers.api.stacking.ItemStackerProvider;
import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;

public interface UpgradeableHoppersAPI {

    /**
     * Get online player data.
     *
     * @param player The player must be online.
     * @return null, if it doesn't exist or is offline.
     */
    @Nullable
    HopperPlayer getHopperPlayer(@NotNull Player player);

    /**
     * Get implementation of this API.
     * Should only be called after UpgradeableHoppers finished loading.
     * It doesn't need to be fully enabled though.
     *
     * @return implementation of this API
     */
    @NotNull
    static UpgradeableHoppersAPI getInstance() {
        try {
            return APIHandler.getInstance().getAPI();
        } catch (NullPointerException ex) {
            throw new IllegalStateException("UpgradeableHoppers hasn't loaded yet. Could can only use the API after UpgradeableHoppers finished loading.");
        }
    }

    /**
     * Retrieve hopper by its location.
     *
     * @param location location of the hopper
     * @return null, if the hopper is in an unloaded chunk or simply doesn't exist
     */
    @Nullable
    Hopper getHopper(@NotNull Location location);

    /**
     * Set a custom item stacking provider.
     *
     * @param provider the provider to be set
     */
    void setItemStackerProvider(@NotNull ItemStackerProvider provider);

    /**
     * Register a new hopper.
     *
     * @param plugin   Your plugin
     * @param type     The hopper type
     * @param block    The block
     * @param ownerUID The owner
     * @return Future with registered hopper.
     * @throws IllegalArgumentException if {@code block} is already an upgradeable hopper or the block's material doesn't equal HOPPER
     * @throws IllegalStateException    if method isn't called sync
     * @throws UnloadedTargetException  if the chunk of the {@code block} isn't loaded
     */
    @NotNull
    CompletableFuture<Hopper> registerHopper(@NotNull Plugin plugin, @Nullable String type, @NotNull Block block, @NotNull UUID ownerUID) throws IllegalArgumentException, IllegalStateException, UnloadedTargetException;
}