package me.angeschossen.upgradeablehoppers.api.hopper.upgrade;

import com.github.angeschossen.pluginframework.api.player.PlayerData;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Contains info about an attribute that can be leveled.
 */
public interface HopperLevel {
    /**
     * Get the attribute type of this level.
     *
     * @return never null
     */
    @NotNull AttributeType getAttributeType();

    /**
     * Get the upgrade cost of this level.
     *
     * @return never negative
     */
    double getUpgradeCost();

    /**
     * Get the index of this level in the levels file.
     *
     * @return never negative
     */
    int getIndex();

    /**
     * Get the value of this attribute.
     *
     * @return never negative
     */
    int getValue();

    /**
     * Display the value in a GUI or something.
     *
     * @param playerData may depend on players locale
     * @return never null
     */
    @NotNull String getValueDisplay(@Nullable PlayerData playerData);
}
