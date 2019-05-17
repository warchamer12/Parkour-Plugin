package net.warchamer12.parkour.commands;

import net.warchamer12.parkour.Parkour;
import net.warchamer12.parkour.configs.area.ParkourConfigEasy;
import net.warchamer12.parkour.configs.area.ParkourConfigHard;
import net.warchamer12.parkour.configs.area.ParkourConfigMedium;
import net.warchamer12.parkour.configs.area.ParkourConfigUltra;
import net.warchamer12.parkour.objects.ParkourObject;
import net.warchamer12.parkour.utils.Util;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ParkourCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) { return true; }
        Player player = (Player) sender;
        if (player.hasPermission("parkour.admin")) {
            if (args.length == 2) {
                if (args[0].equalsIgnoreCase("stworz")) {
                    if (args[1].equalsIgnoreCase("easy")) {
                        ParkourObject.easy += 1;
                        player.sendMessage(ChatColor.GREEN + "Stworzono parkour o nazwie " + args[1]);
                        ParkourConfigEasy.create();
                        ParkourConfigEasy.save();
                        Parkour.getPlugin().saveConfig();
                        return true;
                    } else if (args[1].equalsIgnoreCase("medium")) {
                        ParkourObject.medium += 1;
                        player.sendMessage(ChatColor.GREEN + "Stworzono parkour o nazwie " + args[1]);
                        ParkourConfigMedium.create();
                        ParkourConfigMedium.save();
                        Parkour.getPlugin().saveConfig();
                        return true;
                    } else if (args[1].equalsIgnoreCase("hard")) {
                        ParkourObject.hard += 1;
                        player.sendMessage(ChatColor.GREEN + "Stworzono parkour o nazwie " + args[1]);
                        ParkourConfigHard.create();
                        ParkourConfigHard.save();
                        Parkour.getPlugin().saveConfig();
                        return true;
                    } else if (args[1].equalsIgnoreCase("ultra")) {
                        ParkourObject.ultra += 1;
                        player.sendMessage(ChatColor.GREEN + "Stworzono parkour o nazwie " + args[1]);
                        ParkourConfigUltra.create();
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
                }
            } else if (args.length > 2) {
                helpCommand(player);
                return true;
            } else if (args.length < 0) {
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
