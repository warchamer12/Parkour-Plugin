package net.warchamer12.parkour;

import org.bukkit.plugin.java.JavaPlugin;

public final class Parkour extends JavaPlugin {

    @Override
    public void onEnable() {
        getLogger().info("Starting parkour!");

    }

    @Override
    public void onDisable() {
        getLogger().info("Disabled plugin!");
    }
}
