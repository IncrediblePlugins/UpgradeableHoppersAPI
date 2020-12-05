package me.angeschossen.upgradeablehoppers.api;

import org.bukkit.entity.Item;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public interface ItemStackerIntegration {

    /**
     * The name of your plugin.
     *
     * @return Name
     */
    @NotNull
    String getName();

    /**
     * Get item stack from your custom stacked item. Your integration must handle the creation of the ItemStack object.
     * That means that you need to set the correct ItemStack amount and other values like NBT data.
     *
     * @param item      The item entity
     * @param maxAmount The returned ItemStack's amount should not be higher than this. Usually the value is 64.
     * @return null, if the item is not a stacked item of your plugin.
     */
    @Nullable
    ItemStack getItemStack(@NotNull Item item, final int maxAmount);

    /**
     * Add or substract an amount to/from a stacked item of your plugin.
     *
     * @param item   The item entity
     * @param amount The amount to add
     * @return false, if the item is not a stacked item of your plugin.
     */
    boolean addAmountToItem(@NotNull Item item, final int amount);
}
