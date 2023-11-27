package me.angeschossen.upgradeablehoppers.api.hopper;

import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.Nullable;

/**
 * Setting names for hoppers and links.
 */
public interface Nameable {

    /**
     * Get the name of the object.
     *
     * @return null, if no name has been set
     */
    @Nullable
    String getName();

    /**
     * Set the name.
     *
     * @param commandSender will receive an error message if the name is too long. The max. length is 32 characters, including color codes.
     * @param name          if null, name will be removed
     */
    void setName(@Nullable CommandSender commandSender, @Nullable String name);
}
