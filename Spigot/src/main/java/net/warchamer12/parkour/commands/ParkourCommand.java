package net.warchamer12.parkour.commands;

import net.warchamer12.parkour.Parkour;
import net.warchamer12.parkour.configs.area.ParkourConfigEasy;
import net.warchamer12.parkour.configs.area.ParkourConfigHard;
import net.warchamer12.parkour.configs.area.ParkourConfigMedium;
import net.warchamer12.parkour.configs.area.ParkourConfigUltra;
import net.warchamer12.parkour.objects.ParkourObject;
import net.warchamer12.parkour.utils.Util;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ParkourCommand implements CommandExecutor {

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
                        ParkourConfigEasy.get().set("nazwa", "Easy " + ParkourObject.getEasy());
                        ParkourConfigEasy.get().set("spawn", loc);
                        ParkourConfigEasy.save();
                        Parkour.getPlugin().getConfig().set("easy", ParkourObject.getEasy());
                        Parkour.getPlugin().saveConfig();
                        return true;
                    } else if (args[1].equalsIgnoreCase("medium")) {
                        ParkourObject.medium += 1;
                        player.sendMessage(ChatColor.GREEN + "Stworzono parkour o nazwie " + args[1]);
                        ParkourConfigMedium.create();
                        ParkourConfigMedium.get().set("nazwa", "Medium " + ParkourObject.getMedium());
                        ParkourConfigMedium.get().set("spawn", loc);
                        ParkourConfigMedium.save();
                        Parkour.getPlugin().getConfig().set("medium", ParkourObject.getMedium());
                        Parkour.getPlugin().saveConfig();
                        return true;
                    } else if (args[1].equalsIgnoreCase("hard")) {
                        ParkourObject.hard += 1;
                        player.sendMessage(ChatColor.GREEN + "Stworzono parkour o nazwie " + args[1]);
                        ParkourConfigHard.create();
                        ParkourConfigHard.get().set("nazwa", "Hard " + ParkourObject.getHard());
                        ParkourConfigHard.get().set("spawn", loc);
                        ParkourConfigHard.save();
                        Parkour.getPlugin().getConfig().set("hard", ParkourObject.getHard());
                        Parkour.getPlugin().saveConfig();
                        return true;
                    } else if (args[1].equalsIgnoreCase("ultra")) {
                        ParkourObject.ultra += 1;
                        player.sendMessage(ChatColor.GREEN + "Stworzono parkour o nazwie " + args[1]);
                        ParkourConfigUltra.create();
                        ParkourConfigUltra.get().set("nazwa", "Ultra " + ParkourObject.getUltra());
                        ParkourConfigUltra.get().set("spawn", loc);
                        ParkourConfigUltra.save();
                        Parkour.getPlugin().getConfig().set("ultra", ParkourObject.getUltra());
                        Parkour.getPlugin().saveConfig();
                        return true;
                    } else {
                        player.sendMessage(Util.fixColor("&cNiepoprawna forma!"));
                        return true;
                    }
                } else {
                    this.helpCommand(player);
                    return true;
                }
            } else if (args.length == 3) {
                if (args[0].equalsIgnoreCase("ustawspawn")) {
                    if (args[1].equalsIgnoreCase("easy")) {
                        ParkourConfigEasy.getFileParkour(args[2]);
                        ParkourConfigEasy.get().set("spawn", loc);
                        ParkourConfigEasy.save();
                        player.sendMessage(Util.fixColor("&cUstawiono spawn dla mapy " + args[2] + " na kordynatach: " + loc));
                        return true;
                    } else if (args[1].equalsIgnoreCase("medium")) {
                        ParkourConfigMedium.getFileParkour(args[2]);
                        ParkourConfigMedium.get().set("spawn", loc);
                        ParkourConfigMedium.save();
                        player.sendMessage(Util.fixColor("&cUstawiono spawn dla mapy " + args[2] + " na kordynatach: " + loc));
                        return true;
                    } else if (args[1].equalsIgnoreCase("hard")) {
                        ParkourConfigHard.getFileParkour(args[2]);
                        ParkourConfigHard.get().set("spawn", loc);
                        ParkourConfigHard.save();
                        player.sendMessage(Util.fixColor("&cUstawiono spawn dla mapy " + args[2] + " na kordynatach: " + loc));
                        return true;
                    } else if (args[1].equalsIgnoreCase("ultra")) {
                        ParkourConfigUltra.getFileParkour(args[2]);
                        ParkourConfigUltra.get().set("spawn", loc);
                        ParkourConfigUltra.save();
                        player.sendMessage(Util.fixColor("&cUstawiono spawn dla mapy " + args[2] + " na kordynatach: " + loc));
                        return true;
                    } else {
                        player.sendMessage(Util.fixColor("&cNiepoprawna forma!"));
                        return true;
                    }
                } else if (args[0].equalsIgnoreCase("usun")) {
                    if (args[1].equalsIgnoreCase("easy")) {
                        ParkourConfigEasy.delete(args[2]);
                        player.sendMessage(Util.fixColor("&cUsunieto arene!"));
                        ParkourObject.easy -= 1;
                        Parkour.getPlugin().saveConfig();
                        return true;
                    } else if (args[1].equalsIgnoreCase("medium")) {
                        ParkourConfigMedium.delete(args[2]);
                        player.sendMessage(Util.fixColor("&cUsunieto arene!"));
                        ParkourObject.medium -= 1;
                        Parkour.getPlugin().saveConfig();
                        return true;
                    } else if (args[1].equalsIgnoreCase("hard")) {
                        ParkourConfigHard.delete(args[2]);
                        player.sendMessage(Util.fixColor("&cUsunieto arene!"));
                        ParkourObject.hard -= 1;
                        Parkour.getPlugin().saveConfig();
                        return true;
                    } else if (args[1].equalsIgnoreCase("ultra")) {
                        ParkourConfigUltra.delete(args[2]);
                        player.sendMessage(Util.fixColor("&cUsunieto arene!"));
                        ParkourObject.ultra -= 1;
                        Parkour.getPlugin().saveConfig();
                        return true;
                    } else {
                        player.sendMessage(Util.fixColor("&cNiepoprawna forma!"));
                        return true;
                    }
                } else {
                    this.helpCommand(player);
                    return true;
                }
            } else {
                this.helpCommand(player);
                return true;
            }
        } else {
            player.sendMessage(Util.fixColor("&cNie masz uprawnien!"));
        }
        return false;
    }

    private void helpCommand(Player player) {
        player.sendMessage(Util.fixColor("&c/parkour stworz easy/medium/hard/ultra"));
        player.sendMessage(Util.fixColor("&c/parkour usun easy/medium/hard/ultra id"));
        player.sendMessage(Util.fixColor("&c/parkour ustawspawn easy/medium/hard/ultra id"));
    }


}
