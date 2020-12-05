package me.angeschossen.upgradeablehoppers.api.exceptions;

import org.jetbrains.annotations.NotNull;

public class UnloadedStateException extends RuntimeException {

    @NotNull
    public static String flatfile = "%%__USER__%%";

    public UnloadedStateException(String msg) {
        super(msg);
    }
}
