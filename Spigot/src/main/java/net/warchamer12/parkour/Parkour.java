package net.warchamer12.parkour;

import net.warchamer12.parkour.commands.ParkourCommand;
import net.warchamer12.parkour.configs.PlayerConfig;
import net.warchamer12.parkour.configs.area.ParkourConfigEasy;
import net.warchamer12.parkour.configs.area.ParkourConfigHard;
import net.warchamer12.parkour.configs.area.ParkourConfigMedium;
import net.warchamer12.parkour.configs.area.ParkourConfigUltra;
import net.warchamer12.parkour.listeners.ParkourListener;
import net.warchamer12.parkour.listeners.PlayerJoinListener;
import net.warchamer12.parkour.objects.ParkourObject;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class Parkour extends JavaPlugin {

    private static Parkour plugin;

    @Override
    public void onEnable() {
        plugin = this;
        saveConfig();
        loadConfig();
        plugin.getDataFolder().getPath();
        getLogger().info("Starting parkour!");

        //Commands
        this.getCommands();

        //Listeners
        PluginManager pm = Bukkit.getPluginManager();
        pm.registerEvents(new PlayerJoinListener(), this);
        pm.registerEvents(new ParkourListener(), this);
    }

    @Override
    public void onDisable() {
        getLogger().info("Disabled plugin!");
        //Players
        PlayerConfig.save();

        //Parkours
        ParkourConfigEasy.save();
        Parkour.getPlugin().getConfig().set("easy", ParkourObject.getEasy());
        ParkourConfigMedium.save();
        Parkour.getPlugin().getConfig().set("medium", ParkourObject.getMedium());
        ParkourConfigHard.save();
        Parkour.getPlugin().getConfig().set("hard", ParkourObject.getHard());
        ParkourConfigUltra.save();
        Parkour.getPlugin().getConfig().set("ultra", ParkourObject.getUltra());
        plugin.saveConfig();
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

    public static void loadConfig() {
        Parkour.getPlugin().saveDefaultConfig();
        FileConfiguration config = Parkour.getPlugin().getConfig();
        ParkourObject.easy = config.getInt("easy");
        ParkourObject.medium = config.getInt("medium");
        ParkourObject.hard = config.getInt("hard");
        ParkourObject.ultra = config.getInt("ultra");
    }
}
