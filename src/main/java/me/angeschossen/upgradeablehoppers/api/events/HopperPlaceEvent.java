package me.angeschossen.upgradeablehoppers.api.events;

import me.angeschossen.upgradeablehoppers.api.hopper.Hopper;
import me.angeschossen.upgradeablehoppers.api.player.HopperPlayer;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

public class HopperPlaceEvent extends Event implements Cancellable {
    public static HandlerList handlerList = new HandlerList();
    private final @NotNull Hopper hopper;
    private final @NotNull HopperPlayer hopperPlayer;
    private boolean cancelled = false;

    public HopperPlaceEvent(@NotNull Hopper hopper,@NotNull HopperPlayer hopperPlayer) {
        this.hopper = hopper;
        this.hopperPlayer = hopperPlayer;
    }

    public static HandlerList getHandlerList() {
        return handlerList;
    }

    @NotNull
    public HopperPlayer getHopperPlayer(){
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
    public void setCancelled(boolean cancelled) {
        this.cancelled = cancelled;
    }
}
