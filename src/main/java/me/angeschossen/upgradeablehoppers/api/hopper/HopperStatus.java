package me.angeschossen.upgradeablehoppers.api.hopper;

/**
 * Defines the current status of the hopper.
 */
public enum HopperStatus {
    /**
     * The hopper is owned.
     */
    OWNED,
    /**
     * The hopper is neutral, since the region it stands in got unclaimed or the hopper owner got untrusted from the region.
     * This depends on the server's config.
     */
    NEUTRAL,
    /**
     * The hopper will be deleted on the next load, since the region it stands in got unclaimed, while the chunk of the hopper
     * wasn't loaded. This depends on the server's config.
     */
    DELETION_PENDING_UNCLAIM,
    /**
     * The hopper will be deleted on the next load, since the owner got untrusted in the region it stands in, while the chunk of the hopper
     * wasn't loaded. This depends on the server's config.
     */
    DELETION_PENDING_UNTRUST,
}
