package me.angeschossen.upgradeablehoppers.api.hopper.role;

public enum HopperAction {

    UPGRADE(true), OPEN(true), DELETE(false);

    public final boolean regionMembers;

    HopperAction(boolean regionMembers) {
        this.regionMembers = regionMembers;
    }
}
