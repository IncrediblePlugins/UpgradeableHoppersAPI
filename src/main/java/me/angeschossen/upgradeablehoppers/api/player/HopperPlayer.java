package me.angeschossen.upgradeablehoppers.api.player;

import me.angeschossen.upgradeablehoppers.api.enums.Action;

import java.util.UUID;

public interface HopperPlayer {
    Action getPendingAction();

    UUID getUID();
}
