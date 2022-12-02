package me.angeschossen.upgradeablehoppers.api.exceptions;

import org.jetbrains.annotations.NotNull;

public class UnloadedTargetException extends RuntimeException {

    @NotNull
    public static String flatfile = "%%__USER__%%";

    public UnloadedTargetException(String msg) {
        super(msg);
    }
}
