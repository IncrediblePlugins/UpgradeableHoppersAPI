package me.angeschossen.upgradeablehoppers.api.exceptions;


import org.jetbrains.annotations.NotNull;

/**
 * Thrown when you try to modify a target, which chunk isn't loaded.
 */
public class UnloadedTargetException extends RuntimeException {

    public UnloadedTargetException(@NotNull String msg) {
        super(msg);
    }
}
