package me.angeschossen.upgradeablehoppers.api.events.hopper.link;

import com.github.angeschossen.pluginframework.api.utils.Checks;
import me.angeschossen.upgradeablehoppers.api.events.hopper.base.HopperPlayerCancellableEvent;
import me.angeschossen.upgradeablehoppers.api.hopper.Hopper;
import me.angeschossen.upgradeablehoppers.api.hopper.link.Link;
import me.angeschossen.upgradeablehoppers.api.player.HopperPlayer;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Called whenever a link is being deleted.
 */
public class LinkDeletionEvent extends HopperPlayerCancellableEvent {
    public static HandlerList handlerList = new HandlerList();
    private final @NotNull Link link;
    private final @NotNull Reason reason;

    /**
     * Create an instance of this event.
     *
     * @param hopper the hopper for which the link is being removed
     * @param player the player that initiated the link removal. If null, no player initiated the removal
     * @param link   the link that is being removed
     */
    public LinkDeletionEvent(@NotNull Hopper hopper, @Nullable HopperPlayer player, @NotNull Link link, @NotNull Reason reason) {
        super(hopper, player);

        Checks.requireNonNull(link, "link");
        Checks.requireNonNull(reason, "reason");
        this.link = link;
        this.reason = reason;
    }

    public static HandlerList getHandlerList() {
        return handlerList;
    }

    @NotNull
    public Link getLink() {
        return link;
    }

    @Override
    public HandlerList getHandlers() {
        return handlerList;
    }

    /**
     * Cancel the link deletion.
     *
     * @param cancelled true if you wish to cancel this event
     * @throws IllegalArgumentException if this link is removed, because it doesn't exist anymore in the world
     */
    @Override
    public void setCancelled(boolean cancelled) throws IllegalStateException {
        if (reason == Reason.INVALID) {
            throw new IllegalStateException("Can't cancel removal with reason " + Reason.INVALID);
        }

        super.setCancelled(cancelled);
    }

    public enum Reason {
        /**
         * A player initiated the removal. For example by breaking the block of the link or via the menu.
         */
        PLAYER,
        /**
         * The link doesn't exist any longer in the world.
         */
        INVALID,
        /**
         * The link broke because of an explosion.
         */
        EXPLOSION
    }
}
