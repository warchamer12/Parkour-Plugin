package net.warchamer12.parkour.configs.area;

import net.warchamer12.parkour.Parkour;
import net.warchamer12.parkour.objects.ParkourObject;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.File;

public class ParkourConfigMedium {

    static File cfile;
    static FileConfiguration config;
    static File folder = new File(Parkour.getPlugin().getDataFolder(), "medium" + File.separator);
    static File df = Parkour.getPlugin().getDataFolder();

    public static void create() {
        if (!folder.exists()) folder.mkdir();
        cfile = new File(df, "medium" + File.separator + ParkourObject.getMedium() + ".yml");
        if (!df.exists()) df.mkdir();
        if (!cfile.exists()) {
            try {
                cfile.createNewFile();
            } catch(Exception e) {
                Bukkit.getConsoleSender().sendMessage(ChatColor.RED + "Error creating " + cfile.getName() + "!");
            }
        }
        config = YamlConfiguration.loadConfiguration(cfile);
    }

    public static File getfolder() {
        return folder;
    }

    public static File getfile() {
        return cfile;
    }

    public static void getFileParkour(String name) {
        cfile = new File(df, "medium" + File.separator + name + ".yml");
        config = YamlConfiguration.loadConfiguration(cfile);
    }

    public static void load(Player p) {
        cfile = new File(df, "medium" + File.separator + ParkourObject.getMedium() + ".yml");
        config = YamlConfiguration.loadConfiguration(cfile);
    }

    public static FileConfiguration get() {
        return config;
    }

    public static void save() {
        try {
            config.save(cfile);
        } catch(Exception e) {
            Bukkit.getConsoleSender().sendMessage(ChatColor.RED + "Error saving " + cfile.getName() + "!");
        }
    }

    public static void delete() {
        cfile.delete();
    }


}
