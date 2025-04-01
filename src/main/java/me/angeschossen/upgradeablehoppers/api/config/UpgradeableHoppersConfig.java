package me.angeschossen.upgradeablehoppers.api.config;

import com.github.angeschossen.pluginframework.api.configuration.Configuration;

public interface UpgradeableHoppersConfig extends Configuration {

    /**
     * Check if the server admin enabled the item suction event in the config.
     *
     * @return true, if they enabled it
     */
    boolean isCallItemPickupEventEnabled();
}
