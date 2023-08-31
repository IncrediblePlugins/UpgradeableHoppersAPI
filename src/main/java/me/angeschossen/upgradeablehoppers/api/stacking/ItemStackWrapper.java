package me.angeschossen.upgradeablehoppers.api.stacking;

import org.bukkit.inventory.ItemStack;

public interface ItemStackWrapper {
    /**
     * Get the amount of this stack.
     * @return stack amount
     */
    int getAmount();

    /**
     * Remove this stack from the world.
     */
    void remove();

    /**
     * Check whether this item is a vanilla item or a stacked item.
     * @return true, if this item is from a stacking plugin
     */
    boolean isFromStackingPlugin();

    /**
     * Remove an amount.
     * @param amount amount to remove
     * @return the removed amount
     */
    ItemStack removeAmount(int amount);
}
