package me.angeschossen.upgradeablehoppers.api.enums;

/**
 * Represents pending player action.
 */
public enum Action {

    /**
     * The player wants to link a container to a hopper.
     */
    LINK,
    /**
     * Same as {@link #LINK}, but doesn't automatically disable after link creation.
     */
    LINK_PERMANENT,
    /**
     * The player wants to remove a link.
     */
    UNLINK,
    /**
     * Same as {@link #UNLINK}, but doesn't automatically disable after link removal.
     */
    UNLINK_PERMANENT,
    /**
     * The player doesn't have any pending action.
     */
    NONE;

    /**
     * Check if this action is permanent.
     *
     * @return If true, this action doesn't disable until the player explicitly disables it.
     */
    public final boolean isPermanent() {
        return this == LINK_PERMANENT || this == UNLINK_PERMANENT;
    }

    /**
     * Check if this action creates links.
     *
     * @return true, if this action creates links
     */
    public final boolean isLink() {
        return this == LINK || this == LINK_PERMANENT;
    }

    /**
     * Check if this action removes links.
     *
     * @return true, if this action remvoes link
     */
    public final boolean isUnLink() {
        return this == UNLINK || this == UNLINK_PERMANENT;
    }
}
