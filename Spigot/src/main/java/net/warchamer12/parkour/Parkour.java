package net.warchamer12.parkour;

import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public final class Parkour extends JavaPlugin {

    private static Parkour plugin;

    @Override
    public void onEnable() {
        plugin = this;
        getLogger().info("Starting parkour!");

    }

    @Override
    public void onDisable() {
        getLogger().info("Disabled plugin!");
    }

    public static Parkour getPlugin() {
        return plugin;
    }

    public Plugin getInstance() {
        return null;
    }
}
