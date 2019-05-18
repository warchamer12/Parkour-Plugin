package net.warchamer12.parkour.commands;

import net.warchamer12.parkour.Parkour;
import net.warchamer12.parkour.configs.area.ParkourConfigEasy;
import net.warchamer12.parkour.configs.area.ParkourConfigHard;
import net.warchamer12.parkour.configs.area.ParkourConfigMedium;
import net.warchamer12.parkour.configs.area.ParkourConfigUltra;
import net.warchamer12.parkour.objects.ParkourObject;
import net.warchamer12.parkour.utils.Util;

import org.apache.commons.lang.StringUtils;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.File;

public class ParkourCommand implements CommandExecutor {

    static File cfile;
    static File df = Parkour.getPlugin().getDataFolder();
    static File easy = new File(Parkour.getPlugin().getDataFolder(), "parkour easy data" + File.separator);
    static File medium = new File(Parkour.getPlugin().getDataFolder(), "parkour medium data" + File.separator);
    static File hard = new File(Parkour.getPlugin().getDataFolder(), "parkour hard data" + File.separator);
    static File ultra = new File(Parkour.getPlugin().getDataFolder(), "parkour ultra data" + File.separator);
    static FileConfiguration config;

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) { return true; }
        Player player = (Player) sender;
        Location loc = player.getLocation();
        if (player.hasPermission("parkour.admin")) {
            if (args.length == 2) {
                if (args[0].equalsIgnoreCase("stworz")) {
                    if (args[1].equalsIgnoreCase("easy")) {
                        ParkourObject.easy += 1;
                        player.sendMessage(ChatColor.GREEN + "Stworzono parkour o nazwie " + args[1]);
                        ParkourConfigEasy.create();
                        ParkourConfigEasy.get().set("spawn", loc);
                        ParkourConfigEasy.save();
                        Parkour.getPlugin().saveConfig();
                        return true;
                    } else if (args[1].equalsIgnoreCase("medium")) {
                        ParkourObject.medium += 1;
                        player.sendMessage(ChatColor.GREEN + "Stworzono parkour o nazwie " + args[1]);
                        ParkourConfigMedium.create();
                        ParkourConfigMedium.get().set("spawn", loc);
                        ParkourConfigMedium.save();
                        Parkour.getPlugin().saveConfig();
                        return true;
                    } else if (args[1].equalsIgnoreCase("hard")) {
                        ParkourObject.hard += 1;
                        player.sendMessage(ChatColor.GREEN + "Stworzono parkour o nazwie " + args[1]);
                        ParkourConfigHard.create();
                        ParkourConfigHard.get().set("spawn", loc);
                        ParkourConfigHard.save();
                        Parkour.getPlugin().saveConfig();
                        return true;
                    } else if (args[1].equalsIgnoreCase("ultra")) {
                        ParkourObject.ultra += 1;
                        player.sendMessage(ChatColor.GREEN + "Stworzono parkour o nazwie " + args[1]);
                        ParkourConfigUltra.create();
                        ParkourConfigUltra.get().set("spawn", loc);
                        ParkourConfigUltra.save();
                        Parkour.getPlugin().saveConfig();
                        return true;
                    } else {
                        player.sendMessage(Util.fixColor("&cNiepoprawna forma!"));
                        return true;
                    }
                } else if (args[0].equalsIgnoreCase("usun")) {
                    if (args[1].equalsIgnoreCase("easy")) {
                        ParkourConfigEasy.delete();
                        ParkourConfigEasy.save();
                        player.sendMessage(Util.fixColor("&cUsunieto arene!"));
                        ParkourObject.easy -= 1;
                        Parkour.getPlugin().saveConfig();
                        return true;
                    } else if (args[1].equalsIgnoreCase("medium")) {
                        ParkourConfigMedium.delete();
                        ParkourConfigMedium.save();
                        player.sendMessage(Util.fixColor("&cUsunieto arene!"));
                        ParkourObject.medium -= 1;
                        Parkour.getPlugin().saveConfig();
                        return true;
                    } else if (args[1].equalsIgnoreCase("hard")) {
                        ParkourConfigHard.delete();
                        ParkourConfigHard.save();
                        player.sendMessage(Util.fixColor("&cUsunieto arene!"));
                        ParkourObject.hard -= 1;
                        Parkour.getPlugin().saveConfig();
                        return true;
                    } else if (args[1].equalsIgnoreCase("ultra")) {
                        ParkourConfigUltra.delete();
                        ParkourConfigUltra.save();
                        player.sendMessage(Util.fixColor("&cUsunieto arene!"));
                        ParkourObject.ultra -= 1;
                        Parkour.getPlugin().saveConfig();
                        return true;
                    } else {
                        player.sendMessage(Util.fixColor("&cNiepoprawna forma!"));
                        return true;
                    }
                } else if (args.length < 0) {
                    helpCommand(player);
                    return true;
                }
            } else if (args.length == 3) {
                if (args[0].equalsIgnoreCase("ustawspawn")) {
                    if (args[1].equalsIgnoreCase("easy")) {
                        if (args[2].length() > 3 || !StringUtils.isNumeric(args[2])) {
                            sender.sendMessage(Util.fixColor("&8 Podaj id areny!"));
                            return true;
                        }
                        if (!easy.exists()) return true;
                        cfile = new File(df, "parkour easy data" + File.separator + args[2] + ".yml");
                        config = YamlConfiguration.loadConfiguration(cfile);
                        if (!df.exists()) return true;
                        if (!cfile.exists()) {
                            player.sendMessage(Util.fixColor("&6Nie ma takiej areny!"));
                            return true;
                        } else {
                            ParkourConfigEasy.get().set("spawn", loc);
                            ParkourConfigEasy.save();
                        }
                        return true;
                    } else if (args[1].equalsIgnoreCase("medium")) {
                        if (args[2].length() > 3 || !StringUtils.isNumeric(args[2])) {
                            sender.sendMessage(Util.fixColor("&8 Podaj id areny!"));
                            return true;
                        }
                        if (!medium.exists()) return true;
                        cfile = new File(df, "parkour medium data" + File.separator + args[2] + ".yml");
                        config = YamlConfiguration.loadConfiguration(cfile);
                        if (!df.exists()) return true;
                        if (!cfile.exists()) {
                            player.sendMessage(Util.fixColor("&6Nie ma takiej areny!"));
                            return true;
                        } else {
                            ParkourConfigMedium.get().set("spawn", loc);
                            ParkourConfigMedium.save();
                        }
                        return true;
                    } else if (args[1].equalsIgnoreCase("hard")) {
                        if (args[2].length() > 3 || !StringUtils.isNumeric(args[2])) {
                            sender.sendMessage(Util.fixColor("&8 Podaj id areny!"));
                            return true;
                        }
                        if (!hard.exists()) return true;
                        cfile = new File(df, "parkour hard data" + File.separator + args[2] + ".yml");
                        config = YamlConfiguration.loadConfiguration(cfile);
                        if (!df.exists()) return true;
                        if (!cfile.exists()) {
                            player.sendMessage(Util.fixColor("&6Nie ma takiej areny!"));
                            return true;
                        } else {
                            ParkourConfigHard.get().set("spawn", loc);
                            ParkourConfigHard.save();
                        }
                        return true;
                    } else if (args[1].equalsIgnoreCase("ultra")) {
                        if (args[2].length() > 3 || !StringUtils.isNumeric(args[2])) {
                            sender.sendMessage(Util.fixColor("&8 Podaj id areny!"));
                            return true;
                        }
                        if (!ultra.exists()) return true;
                        cfile = new File(df, "parkour ultra data" + File.separator + args[2] + ".yml");
                        config = YamlConfiguration.loadConfiguration(cfile);
                        if (!df.exists()) return true;
                        if (!cfile.exists()) {
                            player.sendMessage(Util.fixColor("&6Nie ma takiej areny!"));
                            return true;
                        } else {
                            ParkourConfigUltra.get().set("spawn", loc);
                            ParkourConfigUltra.save();
                        }
                        return true;
                    } else {
                        player.sendMessage(Util.fixColor("&cNiepoprawna forma!"));
                        return true;
                    }
                } else {
                    helpCommand(player);
                    return true;
                }
            } else if (args.length > 3) {
                helpCommand(player);
                return true;
            }
        } else {
            player.sendMessage(Util.fixColor("&cNie masz uprawnien!"));
            return true;
        }
        return false;
    }

    private void helpCommand(Player player) {
        player.sendMessage(Util.fixColor("&c/parkour stworz easy/medium/hard/ultra"));
    }


}
