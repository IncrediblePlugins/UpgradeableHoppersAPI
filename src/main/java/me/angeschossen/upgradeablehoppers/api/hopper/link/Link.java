package me.angeschossen.upgradeablehoppers.api.hopper.link;

import com.github.angeschossen.pluginframework.api.blockutil.BlockPosition;
import me.angeschossen.upgradeablehoppers.api.hopper.Coordinate;
import me.angeschossen.upgradeablehoppers.api.hopper.Nameable;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Links allow items to be transferred over the air to containers etc.
 */
public interface Link extends Nameable {

    /**
     * Add an item to this link.
     *
     * @param itemStack item to add
     * @return not null, if (partly) failed
     * @throws NullPointerException if chunk of the link isn't loaded
     */
    @Nullable
    ItemStack addItem(@NotNull ItemStack itemStack);

    /**
     * Check if the link is initialized and the chunk of the link is loaded.
     *
     * @return false, if the link isn't initialized or the chunk isn't loaded
     */
    boolean isLoaded();

    /**
     * Add an item to the filter.
     *
     * @param itemStack the item to add
     * @return null, if the filter already has this item
     */
    @Nullable ItemStack addFilterItem(@NotNull ItemStack itemStack);

    /**
     * Use {@link #passesFilter(ItemStack)} instead.
     *
     * @param itemStack the item to check
     * @return false, if this item doesn't pass the filter or is a shulker box. Transferring shulker boxes into other shulker boxes isn't possible in vanilla and therefore prevented when using a link.
     */
    @Deprecated
    boolean canTransfer(@NotNull ItemStack itemStack);

    /**
     * Check if an item passes the filter.
     *
     * @param itemStack the item to check
     * @return false, if this item doesn't pass the filter or is a shulker box. Transferring shulker boxes into other shulker boxes isn't possible in vanilla and therefore prevented when using a link.
     */
    boolean passesFilter(@NotNull ItemStack itemStack);

    /**
     * Use {@link #getPosition()} instead.
     *
     * @return position of this link
     */
    @Deprecated
    @NotNull
    Coordinate getCoordinate();

    /**
     * Get the position of this link.
     *
     * @return position of this link
     */
    @NotNull
    BlockPosition getPosition();

    /**
     * Get the block type of this link.
     *
     * @return block type
     */
    @NotNull
    Material getType();

    /**
     * Remove an item from the filter.
     *
     * @param itemStack item to remove
     * @return false, if the item currently isn't in the filter
     */
    boolean removeFilterItem(ItemStack itemStack);

    /**
     * Toggle whitelist mode.
     *
     * @param whitelist true - items can only pass the filter if they're covered by the filter.
     *                  false - items can't pass the filter if they're covered by the filter.
     */
    void setWhiteList(boolean whitelist);

    /**
     * Toggle strict filtering mode.
     * @param strictFiltering if true, items will be filtered by their name, lore, enchantments etc.
     */
    void setStrictFiltering(boolean strictFiltering);
}
