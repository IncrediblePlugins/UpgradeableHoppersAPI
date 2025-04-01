package me.angeschossen.upgradeablehoppers.api.events.hopper.base;

import com.github.angeschossen.pluginframework.api.utils.Checks;
import me.angeschossen.upgradeablehoppers.api.hopper.Hopper;
import me.angeschossen.upgradeablehoppers.api.player.HopperPlayer;
import org.bukkit.Bukkit;
import org.bukkit.event.Event;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public abstract class HopperEvent extends Event {
    protected final @NotNull Hopper hopper;

    /**
     * Constructor
     *
     * @param hopper the involved hopper
     */
    protected HopperEvent(@NotNull Hopper hopper) {
        super(!Bukkit.isPrimaryThread());

        this.hopper = Checks.requireNonNull(hopper, "hopper");
    }

    /**
     * Get the hopper involved in this event.
     *
     * @return the hopper
     */
    @NotNull
    public final Hopper getHopper() {
        return hopper;
    }

}
