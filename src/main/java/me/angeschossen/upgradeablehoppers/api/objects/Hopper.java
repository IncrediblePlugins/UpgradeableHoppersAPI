package me.angeschossen.upgradeablehoppers.api.objects;

import me.angeschossen.upgradeablehoppers.api.objects.role.HopperAction;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import javax.annotation.Nullable;
import java.util.Collection;
import java.util.HashMap;
import java.util.UUID;

public interface Hopper {

    int getFreeSpace();

    int getMaxLinkDistance();

    void setMaxLinkDistance(int maxLinkDistance);

    boolean hasLinks();

    Collection<Material> getFilter();

    boolean addFilterItem(Material material);

    boolean removeFilterItem(Material material);

    boolean toggleFilterMode();

    Inventory getUpperContainer();

    boolean toggleSuction();

    boolean canTransfer(Material material);

    Inventory getInventory();

    boolean canAction(UUID playerUUID);

    boolean canAction(Player player, HopperAction action);

    int getTransferAmount();

    void setTransferAmount(int amount);

    int getSuctionRadius();

    void setSuctionRadius(int radius);

    int getLinksAmount();

    void setLinksAmount(int maxlinks);

    boolean addDestination(Block block, Player player);

    boolean removeDestination(World world, int x, int y, int z);

    @Nullable
    HashMap<Integer, ItemStack> addItem(ItemStack itemStack);

    @Nullable
    HashMap<Integer, ItemStack> removeItem(ItemStack itemStack);

    Coordinate getCoordinate();

    Location getLocation();

    Link getVanillaLink();

    boolean isChunkLoaded();

    boolean isLoaded();

    int getId();

    UUID getOwner();

    Collection<UUID> getPlayers();
}
