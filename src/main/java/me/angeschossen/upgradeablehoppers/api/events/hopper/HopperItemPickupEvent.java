package me.angeschossen.upgradeablehoppers.api.events.hopper;

import com.github.angeschossen.pluginframework.api.utils.Checks;
import me.angeschossen.upgradeablehoppers.api.events.hopper.base.HopperEvent;
import me.angeschossen.upgradeablehoppers.api.events.hopper.base.HopperEventCancelable;
import me.angeschossen.upgradeablehoppers.api.hopper.Hopper;
import org.bukkit.entity.Item;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

/**
 * For this event to be called, the server admin needs to explicitly enable it in the configuration.
 * Before using this event please read more info about it in the <a href="https://wiki.incredibleplugins.com/upradeablehoppers/developers/api#preventing-item-pickup">wiki</a>.
 */
public class HopperItemPickupEvent extends HopperEventCancelable {
    public static HandlerList handlerList = new HandlerList();
    private final @NotNull Item item;

    /**
     * Constructor
     *
     * @param hopper the involved hopper
     */
    public HopperItemPickupEvent(@NotNull Hopper hopper, @NotNull Item item) {
        super(hopper);
        this.item = Checks.requireNonNull(item, "item");
    }

    /**
     * Get the item that is being picked up.
     *
     * @return never null
     */
    public @NotNull Item getItem() {
        return item;
    }

    public static HandlerList getHandlerList() {
        return handlerList;
    }

    @Override
    public @NotNull HandlerList getHandlers() {
        return handlerList;
    }
}

