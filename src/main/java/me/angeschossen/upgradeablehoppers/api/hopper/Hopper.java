package me.angeschossen.upgradeablehoppers.api.hopper;

import me.angeschossen.upgradeablehoppers.api.exceptions.UnloadedTargetException;
import me.angeschossen.upgradeablehoppers.api.hopper.link.Link;
import me.angeschossen.upgradeablehoppers.api.hopper.role.HopperAction;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public interface Hopper {

    @NotNull
    List<? extends Link> getLinks();

    int getFreeSpace();

    boolean hasLinks();

    @Deprecated
    Collection<Material> getFilter();

    @Deprecated
    boolean addFilterItem(Material material);

    @Deprecated
    boolean removeFilterItem(Material material);

    @Deprecated
    boolean toggleFilterMode();
    
    boolean toggleSuction();

    @Deprecated
    boolean canTransfer(Material material);

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

    @Deprecated
    boolean addDestination(Block block, Player player);

    boolean removeDestination(World world, int x, int y, int z);

    @Nullable
    Map<Integer, ItemStack> addItem(ItemStack... itemStack);

    @Nullable
    Map<Integer, ItemStack> removeItem(ItemStack... itemStack);

    Coordinate getCoordinate();

    Location getLocation();

    @Deprecated
    Link getVanillaLink();

    boolean isChunkLoaded();

    boolean isLoaded();

    UUID getOwner();

    /**
     * Set owner of the hopper.
     * @param ownerUID New owner
     */
    void setOwner(@NotNull UUID ownerUID);
}
