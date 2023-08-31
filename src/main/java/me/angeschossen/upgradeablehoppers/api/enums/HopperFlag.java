package me.angeschossen.upgradeablehoppers.api.enums;

import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;

/**
 * Hopper flags.
 */
public enum HopperFlag {

    /**
     * Controls whether suction is enabled.
     */
    SUCTION_ENABLED(0),
    /**
     * If items should be deleted, if they don't pass any filter.
     */
    FILTER_DELETE(1),
    /**
     * If the link has the blacklist mode set instead of whitelist.
     */
    FILTER_BLACKLIST(2),
    /**
     * If the links are prioritized, at item adding, by their order in the links menu.
     */
    INSERT_BY_ORDER(3);

    private final static Map<Integer, HopperFlag> map = new HashMap<>();

    static {
        for (HopperFlag setting : values()) {
            map.put(setting.id, setting);
        }
    }

    private final int id;

    HopperFlag(int id) {
        this.id = id;
    }

    /**
     * Get a flag by its numerical ID.
     * @param id numerical ID
     * @return never null
     * @throws IllegalArgumentException if no flag with this ID exists
     */
    @NotNull
    public static HopperFlag getById(int id) {
        if (map.containsKey(id)) {
            return map.get(id);
        }

        throw new IllegalArgumentException("flag does not exist with this id: " + id);
    }

    /**
     * Get the ID of this flag.
     * @return numerical unique ID
     */
    public final int getId() {
        return id;
    }
}
