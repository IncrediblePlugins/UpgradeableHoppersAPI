package me.angeschossen.upgradeablehoppers.api.player;

import com.github.angeschossen.pluginframework.api.blockutil.impl.BlockPosition;
import me.angeschossen.upgradeablehoppers.api.enums.Action;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

public interface HopperPlayer {
    /**
     * Get ids and coordinates of placed hoppers.
     *
     * @return IDs and coordinates of placed hoppers.
     */
    Map<Integer, ? extends BlockPosition> getHoppers();

    /**
     * Get link, unlink mode status.
     * @return Current pending action
     */
    Action getPendingAction();

    /**
     * Get the ID of the player.
     * @return ID of the player
     */
    UUID getUID();
}
