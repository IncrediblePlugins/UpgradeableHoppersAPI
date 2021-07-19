package me.angeschossen.upgradeablehoppers.api.events;

import me.angeschossen.upgradeablehoppers.api.objects.Hopper;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.bukkit.inventory.BlockInventoryHolder;
import org.jetbrains.annotations.NotNull;

public class LinkCreationEvent extends Event implements Cancellable {
    public static HandlerList handlerList = new HandlerList();
    private final @NotNull Hopper hopper;
    private final @NotNull BlockInventoryHolder blockInventoryHolder;
    private boolean cancelled = false;

    public LinkCreationEvent(@NotNull Hopper hopper, @NotNull BlockInventoryHolder blockInventoryHolder) {
        this.hopper = hopper;
        this.blockInventoryHolder = blockInventoryHolder;
    }

    public static HandlerList getHandlerList() {
        return handlerList;
    }

    @NotNull
    public BlockInventoryHolder getBlockInventoryHolder() {
        return blockInventoryHolder;
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
