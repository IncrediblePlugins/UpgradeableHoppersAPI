package me.angeschossen.upgradeablehoppers.api.hopper;

import com.github.angeschossen.pluginframework.api.blockutil.BlockPosition;
import me.angeschossen.upgradeablehoppers.api.events.hopper.link.LinkDeletionEvent;
import me.angeschossen.upgradeablehoppers.api.exceptions.UnloadedTargetException;
import me.angeschossen.upgradeablehoppers.api.hopper.link.Link;
import me.angeschossen.upgradeablehoppers.api.hopper.role.RoleFlag;
import me.angeschossen.upgradeablehoppers.api.player.HopperPlayer;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.UUID;

/**
 * Represents a placed upgradeable hopper.
 */
public interface Hopper {

    /**
     * Get the links of this hopper.
     *
     * @return collection of active links
     */
    @NotNull
    List<? extends Link> getLinks();

    /**
     * Check if the inventory of this hopper is full.
     *
     * @return true, if all slots are full and the hopper is loaded
     */
    boolean isFull();

    /**
     * Check if the hopper has any links.
     *
     * @return false, if the hopper doesn't have any links
     */
    boolean hasLinks();

    /**
     * Toggle the suction mode.
     *
     * @param enabled whether suction mode should be enabled
     */
    void setSuction(boolean enabled);

    /**
     * Use {@link #passesLinkFilters(ItemStack)} instead.
     *
     * @param itemStack the item to check
     * @return true, if any of the links can transfer this item
     */
    @Deprecated
    boolean canTransfer(@NotNull ItemStack itemStack);

    /**
     * Check if any of the links can transfer this item.
     *
     * @param itemStack the item to check
     * @return true, if any of the links can transfer this item
     */
    boolean passesLinkFilters(@NotNull ItemStack itemStack);


    /**
     * Check if a player can execute an action at a hopper.
     *
     * @param player the player to check
     * @param action action to check
     * @return true, if the player is allowed to do this at this hopper
     */
    boolean canAction(@NotNull Player player, @NotNull RoleFlag action);

    /**
     * Add a link (destination)
     *
     * @param block  target block
     * @param player optional: send failure messages to the player, if the destination is already linked, in a different world, or is the hopper itself
     * @return null, if the link could not be added.
     * @throws IllegalArgumentException the target block is not a block-inventory holder
     * @throws IllegalStateException    not called on main thread
     * @throws UnloadedTargetException  the destination chunk is unloaded
     */
    @Nullable Link addLink(@NotNull Block block, @Nullable Player player) throws IllegalArgumentException, IllegalStateException, UnloadedTargetException;

    /**
     * Remove a link.
     *
     * @param player Player that initiated the removal. If null, no player initiated it.
     * @param world  the world of the link
     * @param x      x block
     * @param y      y block
     * @param z      z block
     * @return false, if the hopper has no link at this position
     */
    boolean removeLink(@Nullable HopperPlayer player, World world, int x, int y, int z, LinkDeletionEvent.Reason reason);

    /**
     * Add an item to a hopper.
     *
     * @param itemStack the item to add
     * @param delete    If true, the item will be deleted it the hopper's filters don't accept it and the hopper has deletion mode enabled.
     * @return ItemStack with correct amount that couldn't be added. Or null if the whole item has been added.
     * null is also possible, if delete was true, hopper has deletion mode enable and the item couldn't be added.
     */
    @Nullable ItemStack addItem(@NotNull ItemStack itemStack, boolean delete);

    /**
     * Add an item to a hopper. Won't delete any items, even if the hopper doesn't allow this item and has even if it has the delete mode enabled.
     *
     * @param itemStack the item
     * @return ItemStack with correct amount that couldn't be added. Or null if the whole item has been added.
     */
    @Nullable ItemStack addItem(@NotNull ItemStack itemStack);

    /**
     * Remove an item from this hopper.
     *
     * @param itemStack item to remove
     * @return item that couldn't be removed
     */
    @Nullable ItemStack removeItem(@NotNull ItemStack itemStack);

    /**
     * Use {@link #getPosition()} instead.
     *
     * @return position of this hopper
     */
    Coordinate getCoordinate();

    /**
     * Get the status of this hopper.
     *
     * @return never null
     */
    @NotNull
    HopperStatus getStatus();

    /**
     * Get the position of this hopper.
     *
     * @return position
     */
    @NotNull
    BlockPosition getPosition();

    /**
     * Use {@link #getPosition()} instead.
     *
     * @return location of this hopper
     */
    @Deprecated
    Location getLocation();

    /**
     * Check if the chunk of this hopper is loaded.
     *
     * @return true, if the chunk is loaded
     */
    boolean isChunkLoaded();

    /**
     * Get the owner of this hopper.
     *
     * @return owner of this hopper
     */
    @NotNull
    UUID getOwner();

    /**
     * Set the owner of the hopper.
     *
     * @param ownerUID new owner
     */
    void setOwner(@NotNull UUID ownerUID);

    /**
     * Get hopper item of this upgradeable hopper.
     * Same as {@link #buildUpgradeableHopperItem(UUID)} but with the current owner as the item owner.
     *
     * @return the itemStack with its levels saved applied to it
     */
    @NotNull ItemStack buildUpgradeableHopperItem();

    /**
     * Get hopper item of this upgradeable hopper.
     *
     * @param ownerUUID Owner of the item. Usually {@link #getOwner()}
     * @return The itemStack with its levels saved applied to it
     */
    @NotNull ItemStack buildUpgradeableHopperItem(@Nullable UUID ownerUUID);
}
