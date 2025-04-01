package me.angeschossen.upgradeablehoppers.api.events.hopper.base;

import com.github.angeschossen.pluginframework.api.utils.Checks;
import me.angeschossen.upgradeablehoppers.api.hopper.Hopper;
import me.angeschossen.upgradeablehoppers.api.player.HopperPlayer;
import org.bukkit.Bukkit;
import org.bukkit.event.Event;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Used for events that involve a hopper and player.
 */
public abstract class HopperPlayerEvent extends HopperEvent {
    protected final @Nullable HopperPlayer player;

    /**
     * Constructor
     *
     * @param hopper the involved hopper
     * @param player the player
     */
    protected HopperPlayerEvent(@NotNull Hopper hopper, @Nullable HopperPlayer player) {
        super(hopper);

        this.player = player;
    }

    /**
     * Get the player that created the link.
     *
     * @return null, if no player triggered this event.
     */
    @Nullable
    public final HopperPlayer getHopperPlayer() {
        return player;
    }
}
