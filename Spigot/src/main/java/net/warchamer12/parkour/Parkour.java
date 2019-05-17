package net.warchamer12.parkour;

import net.warchamer12.parkour.configs.PlayerConfig;
import net.warchamer12.parkour.listeners.PlayerJoinListener;
import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class Parkour extends JavaPlugin {

    private static Parkour plugin;

    @Override
    public void onEnable() {
        plugin = this;
        plugin.getDataFolder().getPath();
        getLogger().info("Starting parkour!");

        PluginManager pm = Bukkit.getPluginManager();
        pm.registerEvents(new PlayerJoinListener(), this);

    }

    @Override
    public void onDisable() {
        getLogger().info("Disabled plugin!");
        PlayerConfig.save();
    }

    public static Parkour getPlugin() {
        return plugin;
    }

    public Plugin getInstance() {
        return null;
    }
}
