package me.angeschossen.upgradeablehoppers.api.events.hopper;

import com.github.angeschossen.pluginframework.api.utils.Checks;
import me.angeschossen.upgradeablehoppers.api.hopper.Hopper;
import me.angeschossen.upgradeablehoppers.api.player.HopperPlayer;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Called whenever a hopper is removed.
 */
public class HopperBreakEvent extends HopperPlayerCancellableEvent {
    public static HandlerList handlerList = new HandlerList();
    private final @NotNull Reason reason;

    /**
     * Create an instance of this event.
     *
     * @param hopper       the hopper that is being removed
     * @param hopperPlayer The player that initiated the removal. If null, no player initiated the removal
     * @param reason       the reason of the removal
     */
    public HopperBreakEvent(@NotNull Hopper hopper, @Nullable HopperPlayer hopperPlayer, @NotNull Reason reason) {
        super(hopper, hopperPlayer);
        Checks.requireNonNull(reason, "reason");

        this.reason = reason;
    }

    public static HandlerList getHandlerList() {
        return handlerList;
    }

    /**
     * Get the reason of the removal.
     *
     * @return reason of removal
     */
    @NotNull
    public Reason getReason() {
        return reason;
    }

    @Override
    public HandlerList getHandlers() {
        return handlerList;
    }

    /**
     * Cancel the removal.
     *
     * @param cancelled true if you wish to cancel this event
     * @throws IllegalStateException if the reason of the removal is {@link Reason#INVALID}
     */
    @Override
    public void setCancelled(boolean cancelled) throws IllegalStateException {
        if (reason == Reason.INVALID) {
            throw new IllegalStateException("Can't cancel event with reason " + Reason.INVALID.toString());
        }

        super.setCancelled(cancelled);
    }

    public enum Reason {
        /**
         * A player initiated the removal. For example by breaking the block.
         */
        PLAYER,
        /**
         * The hopper doesn't exist any longer in the world.
         */
        INVALID,
        /**
         * The broke because of an explosion.
         */
        EXPLOSION,
        /**
         * The land or island etc., in which the hopper is located, got unclaimed / deleted.
         * The server must enable this in config.yml.
         */
        REGION_UNCLAIM,
        /**
         * The owner of the hopper got untrusted from the region it stands in. This depends on
         * the server's config.
         */
        REGION_UNTRUST
    }
}
