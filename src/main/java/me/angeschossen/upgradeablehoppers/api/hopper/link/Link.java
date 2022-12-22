package me.angeschossen.upgradeablehoppers.api.hopper.link;

import me.angeschossen.upgradeablehoppers.api.hopper.Coordinate;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

import java.util.Map;


public interface Link {

    /**
     * add item
     * @param itemStack Item
     * @return Map of fails
     * @throws NullPointerException if not loaded
     */
    @NotNull
    Map<Integer, ItemStack> addItem(ItemStack itemStack);

    Inventory getDestination();

    boolean isLoaded();

    boolean canTransfer(ItemStack itemStack);

    Coordinate getCoordinate();

    Material getType();
}
