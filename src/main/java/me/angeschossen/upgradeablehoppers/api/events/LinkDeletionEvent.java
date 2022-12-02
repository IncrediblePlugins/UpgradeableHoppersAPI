package me.angeschossen.upgradeablehoppers.api.events;

import me.angeschossen.upgradeablehoppers.api.hopper.Hopper;
import me.angeschossen.upgradeablehoppers.api.hopper.link.Link;
import org.bukkit.Bukkit;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

public class LinkDeletionEvent extends Event {
    public static HandlerList handlerList = new HandlerList();
    private final @NotNull Hopper hopper;
    private final @NotNull Link link;

    public LinkDeletionEvent(@NotNull Hopper hopper, @NotNull Link link) {
        super(!Bukkit.isPrimaryThread());

        this.hopper = hopper;
        this.link = link;
    }

    public static HandlerList getHandlerList() {
        return handlerList;
    }

    @NotNull
    public Link getLink() {
        return link;
    }

    @NotNull
    public Hopper getHopper() {
        return hopper;
    }

    @Override
    public HandlerList getHandlers() {
        return handlerList;
    }
}
