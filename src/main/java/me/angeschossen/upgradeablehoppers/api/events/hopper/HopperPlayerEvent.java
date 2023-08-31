package me.angeschossen.upgradeablehoppers.api.events.hopper;

import com.github.angeschossen.pluginframework.api.utils.Checks;
import me.angeschossen.upgradeablehoppers.api.hopper.Hopper;
import me.angeschossen.upgradeablehoppers.api.player.HopperPlayer;
import org.bukkit.event.Event;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Used for events that involve a hopper and player.
 */
public abstract class HopperPlayerEvent extends Event {
    protected final @Nullable HopperPlayer player;
    protected final @NotNull Hopper hopper;

    /**
     * Constructor
     * @param hopper the involved hopper
     * @param player the player
     */
    protected HopperPlayerEvent(@NotNull Hopper hopper, @Nullable HopperPlayer player) {
        Checks.requireNonNull(hopper, "hopper");
        this.player = player;
        this.hopper = hopper;
    }

    /**
     * Get the player that created the link.
     * @return null, if no player triggered this event.
     */
    @Nullable
    public final HopperPlayer getHopperPlayer() {
        return player;
    }

    /**
     * Get the hopper involved in this event.
     * @return the hopper
     */
    @NotNull
    public final Hopper getHopper() {
        return hopper;
    }

}
