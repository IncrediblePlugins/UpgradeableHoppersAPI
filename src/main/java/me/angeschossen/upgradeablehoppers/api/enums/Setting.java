package me.angeschossen.upgradeablehoppers.api.enums;

import java.util.HashMap;
import java.util.Map;

public enum Setting {

    SUCTION_ENABLED(0),
    @Deprecated
    FILTER_DELETE(1),
    FILTER_BLACKLIST(2),
    INSERT_BY_ORDER(3);

    private final static Map<Integer, Setting> map = new HashMap<>();

    static {
        for (Setting setting : values()) {
            map.put(setting.id, setting);
        }
    }

    private final int id;

    Setting(int id) {
        this.id = id;
    }

    public static Setting getById(int id) {
        if (map.containsKey(id)) {
            return map.get(id);
        }

        throw new IllegalArgumentException("Enum constant does not exist with this id: " + id);
    }

    public int getId() {
        return id;
    }
}
