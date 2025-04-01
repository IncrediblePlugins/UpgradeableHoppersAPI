package me.angeschossen.upgradeablehoppers.api.events.hopper;

import com.github.angeschossen.pluginframework.api.utils.Checks;
import me.angeschossen.upgradeablehoppers.api.events.hopper.base.HopperEventCancelable;
import me.angeschossen.upgradeablehoppers.api.hopper.Hopper;
import me.angeschossen.upgradeablehoppers.api.hopper.upgrade.HopperLevel;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

public class HopperUpgradeEvent extends HopperEventCancelable {
    public static HandlerList handlerList = new HandlerList();
    private final @NotNull HopperLevel hopperLevel;

    /**
     * Constructor
     *
     * @param hopper   the involved hopper
     * @param levelNew the new level
     */
    public HopperUpgradeEvent(@NotNull Hopper hopper, @NotNull HopperLevel levelNew) {
        super(hopper);

        this.hopperLevel = Checks.requireNonNull(levelNew, "levelNew");
    }

    /**
     * Get the new level of the hopper attribute.
     *
     * @return new level
     */
    public @NotNull HopperLevel getNewLevel() {
        return hopperLevel;
    }

    /**
     * Get the old level of the hopper attribute.
     *
     * @return old level
     */
    public @NotNull HopperLevel getOldLevel() {
        return hopper.getLevel(this.hopperLevel.getAttributeType());
    }

    public static HandlerList getHandlerList() {
        return handlerList;
    }

    @Override
    public @NotNull HandlerList getHandlers() {
        return handlerList;
    }
}
