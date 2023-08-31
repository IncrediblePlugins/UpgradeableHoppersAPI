package me.angeschossen.upgradeablehoppers.api.hopper.link;

import me.angeschossen.upgradeablehoppers.api.hopper.Coordinate;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.Nullable;


public interface Link {

    /**
     * add item
     * @param itemStack Item
     * @return ItemStack if (partly) failed.
     * @throws NullPointerException if not loaded
     */
    @Nullable
    ItemStack addItem(ItemStack itemStack);

    Inventory getDestination();

    boolean isLoaded();

    ItemStack addFilterItem(ItemStack itemStack);

    boolean canTransfer(ItemStack itemStack);

    Coordinate getCoordinate();

    Material getType();

    void clear();

    boolean removeFilterItem(ItemStack itemStack);

    void setWhiteList(boolean whitelist);

    void setStrictFiltering(boolean strictFiltering);
}
