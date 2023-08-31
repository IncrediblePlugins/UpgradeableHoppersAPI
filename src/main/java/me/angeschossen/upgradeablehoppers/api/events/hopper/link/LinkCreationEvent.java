package me.angeschossen.upgradeablehoppers.api.events.hopper.link;

import com.github.angeschossen.pluginframework.api.utils.Checks;
import me.angeschossen.upgradeablehoppers.api.events.hopper.HopperPlayerCancellableEvent;
import me.angeschossen.upgradeablehoppers.api.hopper.Hopper;
import me.angeschossen.upgradeablehoppers.api.player.HopperPlayer;
import org.bukkit.event.HandlerList;
import org.bukkit.inventory.BlockInventoryHolder;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Called whenever a player links a container to an hopper.
 */
public class LinkCreationEvent extends HopperPlayerCancellableEvent {
    public static HandlerList handlerList = new HandlerList();
    private final @NotNull BlockInventoryHolder blockInventoryHolder;

    /**
     * Create an instance of this event.
     *
     * @param hopper               the hopper for which the link is being created
     * @param player               the player that initiated the creation. If null, no player initiated the creation
     * @param blockInventoryHolder the target container of the link
     */
    public LinkCreationEvent(@NotNull Hopper hopper, @Nullable HopperPlayer player, @NotNull BlockInventoryHolder blockInventoryHolder) {
        super(hopper, player);

        Checks.requireNonNull(blockInventoryHolder, "blockInventoryHolder");
        this.blockInventoryHolder = blockInventoryHolder;
    }

    public static HandlerList getHandlerList() {
        return handlerList;
    }

    /**
     * Get the destination container.
     *
     * @return the destination of the link
     */
    @NotNull
    public BlockInventoryHolder getBlockInventoryHolder() {
        return blockInventoryHolder;
    }

    @Override
    public HandlerList getHandlers() {
        return handlerList;
    }
}
