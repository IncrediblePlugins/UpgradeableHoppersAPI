package me.angeschossen.upgradeablehoppers.api.events;

import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class HopperTransferEvent extends Event {
    public static HandlerList handlerList = new HandlerList();

    public HopperTransferEvent() {

    }

    public static HandlerList getHandlerList() {
        return handlerList;
    }

    @Override
    public HandlerList getHandlers() {
        return handlerList;
    }
}
