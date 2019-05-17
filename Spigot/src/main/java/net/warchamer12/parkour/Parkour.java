package net.warchamer12.parkour;

import net.warchamer12.parkour.commands.ParkourCommand;
import net.warchamer12.parkour.configs.PlayerConfig;
import net.warchamer12.parkour.configs.area.ParkourConfigEasy;
import net.warchamer12.parkour.configs.area.ParkourConfigHard;
import net.warchamer12.parkour.configs.area.ParkourConfigMedium;
import net.warchamer12.parkour.configs.area.ParkourConfigUltra;
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

        //Commands
        this.getCommands();

        //Listeners
        PluginManager pm = Bukkit.getPluginManager();
        pm.registerEvents(new PlayerJoinListener(), this);
    }

    @Override
    public void onDisable() {
        getLogger().info("Disabled plugin!");
        PlayerConfig.save();

        //Parkours
        ParkourConfigEasy.save();
        ParkourConfigMedium.save();
        ParkourConfigHard.save();
        ParkourConfigUltra.save();
    }

    private void getCommands() {
        this.getCommand("parkour").setExecutor(new ParkourCommand());
    }

    public static Parkour getPlugin() {
        return plugin;
    }

    public Plugin getInstance() {
        return null;
    }
}
