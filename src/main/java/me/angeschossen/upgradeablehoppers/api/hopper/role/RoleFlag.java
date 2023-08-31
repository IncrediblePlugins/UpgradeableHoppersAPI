package me.angeschossen.upgradeablehoppers.api.hopper.role;

/**
 * Used to restrict hopper interactions.
 */
public enum RoleFlag {

    /**
     * Controls whether players should be allowed to upgrade a hopper and open the upgrade menu.
     */
    UPGRADE(true),
    /**
     * Controls if players can open a hopper item menu.
     */
    OPEN(true),
    /**
     * Controls if a players of a role can delete a hopper.
     */
    DELETE(false);

    private final boolean regionMembers;

    RoleFlag(boolean regionMembers) {
        this.regionMembers = regionMembers;
    }

    /**
     * Check if this flag applies to the "allow-region-members" option in config.
     * If this option is enabled and this method returns true, players of the same land are allowed to execute the action controlled by the flag.
     * @return true, if this flag applies to the "allow-region-members" option
     */
    public final boolean allowsRegionMembers() {
        return regionMembers;
    }
}
