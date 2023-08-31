package me.angeschossen.upgradeablehoppers.api.events.hopper;

import me.angeschossen.upgradeablehoppers.api.hopper.Hopper;
import me.angeschossen.upgradeablehoppers.api.player.HopperPlayer;
import org.bukkit.event.Cancellable;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Used for events that involve a hopper and player.
 */
public abstract class HopperPlayerCancellableEvent extends HopperPlayerEvent implements Cancellable {
    private boolean cancelled;

    /**
     * Constructor
     *
     * @param hopper the involved hopper
     * @param player the player
     */
    protected HopperPlayerCancellableEvent(@NotNull Hopper hopper, @Nullable HopperPlayer player) {
        super(hopper, player);
    }

    @Override
    public final boolean isCancelled() {
        return cancelled;
    }

    @Override
    public void setCancelled(boolean cancelled) {
        this.cancelled = cancelled;
    }
}
