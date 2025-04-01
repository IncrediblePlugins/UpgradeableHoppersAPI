package me.angeschossen.upgradeablehoppers.api.hopper.upgrade;

import org.jetbrains.annotations.Nullable;

import java.util.HashMap;
import java.util.Map;

public enum AttributeType {
    SUCTION_RADIUS(0, 2),
    TRANSFER_AMOUNT(1, 8),
    LINKS_AMOUNT(2, 1),
    LINK_DISTANCE(3, 100);

    private static final Map<Integer, AttributeType> map = new HashMap<>();

    static {
        for (AttributeType attributeType : values()) {
            map.put(attributeType.id, attributeType);
        }
    }

    private final int defaultValue;
    private final int id;

    AttributeType(int id, int defaultValue) {
        this.id = id;
        this.defaultValue = defaultValue;
    }

    /**
     * Only used if no values are configured in hoppers.yml.
     * @return the default value
     */
    public int getDefaultValue() {
        return defaultValue;
    }

    public int getId() {
        return id;
    }

    @Nullable
    public static AttributeType getById(int id){
        return map.get(id);
    }
}
