package me.angeschossen.upgradeablehoppers.api.enums;

public enum Action {

    LINK,
    LINK_PERMANENT,
    UNLINK, UNLINK_PERMANENT,
    NONE;

    public boolean isPermanent(){
        return this == LINK_PERMANENT || this == UNLINK_PERMANENT;
    }

    public boolean isLink() {
        return this == LINK || this == LINK_PERMANENT;
    }

    public boolean isUnLink() {
        return this == UNLINK || this == UNLINK_PERMANENT;
    }
}
