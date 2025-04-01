package me.angeschossen.upgradeablehoppers.api.events.hopper.base;

import com.github.angeschossen.pluginframework.api.utils.Checks;
import me.angeschossen.upgradeablehoppers.api.hopper.Hopper;
import org.bukkit.Bukkit;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.jetbrains.annotations.NotNull;

public abstract class HopperEventCancelable extends HopperEvent implements Cancellable {
    private boolean cancelled;

    /**
     * Constructor
     *
     * @param hopper the involved hopper
     */
    protected HopperEventCancelable(@NotNull Hopper hopper) {
        super(hopper);
    }

    @Override
    public boolean isCancelled() {
        return cancelled;
    }

    @Override
    public void setCancelled(boolean b) {
        this.cancelled = b;
    }
}
