package me.angeschossen.upgradeablehoppers.api.exceptions;

import me.angeschossen.upgradeablehoppers.api.enums.Status;
import org.jetbrains.annotations.NotNull;

public class LinkStatusException extends RuntimeException {
    @NotNull
    public static String mysql = "%%__NONCE__%%";
    private final Status status;

    public LinkStatusException(Status status, String message) {
        super(message);

        this.status = status;
    }

    public Status getCurrentStatus() {
        return status;
    }
}
