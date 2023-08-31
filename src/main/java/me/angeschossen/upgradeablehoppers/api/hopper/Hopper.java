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

import java.util.List;
import java.util.UUID;

public interface Hopper {

    @NotNull
    List<? extends Link> getLinks();

    int getFreeSpace();

    boolean isFull();

    boolean hasLinks();

    boolean toggleSuction();

    boolean canTransfer(ItemStack itemStack);

    Inventory getInventory();

    boolean canAction(UUID playerUUID);

    boolean canAction(Player player, HopperAction action);

    /**
     * Add a link (destination).
     *
     * @param block  Target block.
     * @param player Optional: send failure messages to the player.
     * @return null, if the link could not be added.
     * @throws IllegalArgumentException The target block is not a block-inventory holder.
     * @throws IllegalStateException    Not called on main thread.
     * @throws UnloadedTargetException  The chunk is unloaded.
     */
    @Nullable Link addLink(@NotNull Block block, @Nullable Player player) throws IllegalArgumentException, IllegalStateException, UnloadedTargetException;

    boolean removeLink(World world, int x, int y, int z);

    /**
     * Add item to a hopper.
     *
     * @param itemStack The item
     * @param delete    If true, the item will be deleted it the hopper's filters don't accept it and the hopper has deletion mode enabled.
     * @return ItemStack with correct amount that couldn't be added. Or null if the whole item has been added.
     * null is also possible, if delete was true, hopper has deletion mode enable and the item couldn't be added.
     */
    @Nullable ItemStack addItem(ItemStack itemStack, boolean delete);

    /**
     * Add item to a hopper. Won't delete any items, even if the hopper doesn't allow this item and has delete mode enabled.
     *
     * @param itemStack The item
     * @return ItemStack with correct amount that couldn't be added. Or null if the whole item has been added.
     */
    @Nullable ItemStack addItem(ItemStack itemStack);

    @Nullable ItemStack removeItem(ItemStack itemStack);

    Coordinate getCoordinate();

    Location getLocation();

    boolean isChunkLoaded();

    boolean isLoaded();

    UUID getOwner();

    /**
     * Set owner of the hopper.
     *
     * @param ownerUID New owner
     */
    void setOwner(@NotNull UUID ownerUID);

    /**
     * Get hopper item of this upgradeable hopper.
     *
     * @return The itemStack with its levels saved applied to it
     */
    @NotNull ItemStack getItem();

    /**
     * Get hopper item of this upgradeable hopper.
     *
     * @param ownerUUID Owner of the item. Usually {@link #getOwner()}
     * @return The itemStack with its levels saved applied to it
     */
    @NotNull ItemStack getItem(@Nullable UUID ownerUUID);
}
