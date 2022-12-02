package me.angeschossen.upgradeablehoppers.api.events;

import me.angeschossen.upgradeablehoppers.api.hopper.Hopper;
import me.angeschossen.upgradeablehoppers.api.player.HopperPlayer;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class HopperBreakEvent extends Event implements Cancellable {
    public static HandlerList handlerList = new HandlerList();
    private final @NotNull Hopper hopper;
    private final @Nullable HopperPlayer hopperPlayer;
    private final @NotNull Reason reason;
    private boolean cancelled = false;

    public HopperBreakEvent(@NotNull Hopper hopper, @Nullable HopperPlayer hopperPlayer, @NotNull Reason reason) {
        this.hopper = hopper;
        this.hopperPlayer = hopperPlayer;
        this.reason = reason;
    }

    public static HandlerList getHandlerList() {
        return handlerList;
    }

    @NotNull
    public Reason getReason() {
        return reason;
    }

    @Nullable
    public HopperPlayer getHopperPlayer() {
        return hopperPlayer;
    }

    @NotNull
    public Hopper getHopper() {
        return hopper;
    }

    @Override
    public HandlerList getHandlers() {
        return handlerList;
    }

    @Override
    public boolean isCancelled() {
        return cancelled;
    }

    @Override
    public void setCancelled(boolean cancelled) throws IllegalStateException {
        if (reason == Reason.ADMIN) {
            throw new IllegalStateException("Can't cancel event with reason = SERVER");
        }

        this.cancelled = cancelled;
    }

    public enum Reason {
        ADMIN, PLAYER
    }
}
