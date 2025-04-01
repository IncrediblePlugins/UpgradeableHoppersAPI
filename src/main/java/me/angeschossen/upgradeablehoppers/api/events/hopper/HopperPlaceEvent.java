package me.angeschossen.upgradeablehoppers.api.events.hopper;

import me.angeschossen.upgradeablehoppers.api.events.hopper.base.HopperPlayerCancellableEvent;
import me.angeschossen.upgradeablehoppers.api.hopper.Hopper;
import me.angeschossen.upgradeablehoppers.api.player.HopperPlayer;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Called whenever a hopper is placed.
 */
public class HopperPlaceEvent extends HopperPlayerCancellableEvent {
    public static HandlerList handlerList = new HandlerList();

    /**
     * Create an instance of this event.
     *
     * @param hopper       the placed hopper
     * @param hopperPlayer The player that initiated the hopper placement. If null, no hopper initiated the placement
     */
    public HopperPlaceEvent(@NotNull Hopper hopper, @Nullable HopperPlayer hopperPlayer) {
        super(hopper, hopperPlayer);
    }

    public static HandlerList getHandlerList() {
        return handlerList;
    }

    @Override
    public HandlerList getHandlers() {
        return handlerList;
    }
}
