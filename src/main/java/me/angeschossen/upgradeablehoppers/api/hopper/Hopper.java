package me.angeschossen.upgradeablehoppers.api.hopper;

import me.angeschossen.upgradeablehoppers.api.exceptions.UnloadedTargetException;
import me.angeschossen.upgradeablehoppers.api.hopper.link.Link;
import me.angeschossen.upgradeablehoppers.api.hopper.role.HopperAction;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public interface Hopper {

    @NotNull
    List<? extends Link> getLinks();

    int getFreeSpace();

    boolean hasLinks();

    boolean toggleSuction();

    boolean canTransfer(ItemStack itemStack);

    Inventory getInventory();

    boolean canAction(UUID playerUUID);

    boolean canAction(Player player, HopperAction action);

    /**
     * Add a link (destination).
     * @param block Target block.
     * @param player Optional: send failure messages to the player.
     * @return null, if the link could not be added.
     * @throws IllegalArgumentException The target block is not a block-inventory holder.
     * @throws IllegalStateException Not called on main thread.
     * @throws UnloadedTargetException The chunk is unloaded.
     */
    @Nullable Link addLink(@NotNull Block block, @Nullable Player player) throws IllegalArgumentException, IllegalStateException, UnloadedTargetException;

    boolean removeDestination(World world, int x, int y, int z);

    @NotNull
    HashMap<Integer, ItemStack> addItem(ItemStack... itemStack);

    @NotNull
    HashMap<Integer, ItemStack> removeItem(ItemStack... itemStack);

    Coordinate getCoordinate();

    Location getLocation();

    boolean isChunkLoaded();

    boolean isFull();

    boolean isLoaded();

    /**
     * Get hopper item of this upgradeable hopper.
     * @return The itemStack with its levels saved applied to it
     */
    @NotNull ItemStack getItem();

    /**
     * Get hopper item of this upgradeable hopper.
     * @param ownerUUID Owner of the item. Usually {@link #getOwner()}
     * @return The itemStack with its levels saved applied to it
     */
    @NotNull ItemStack getItem(@Nullable UUID ownerUUID);

    UUID getOwner();

    /**
     * Set owner of the hopper.
     * @param ownerUID New owner
     */
    void setOwner(@NotNull UUID ownerUID);
}
