package net.warchamer12.parkour.commands;

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
        if (sender.hasPermission("parkour.admin")) {
            Player player = (Player) sender;
            if (args.length == 1) {
                if (args[0].equalsIgnoreCase("stworz")) {
                    if (args[1].equalsIgnoreCase("easy")) {
                        ParkourObject.easy += 1;
                        player.sendMessage(ChatColor.GREEN + "Stworzono parkour o nazwie " + args[1]);
                        ParkourConfigEasy.create();
                        ParkourConfigEasy.save();
                    } else if (args[1].equalsIgnoreCase("medium")) {
                        ParkourObject.medium += 1;
                        player.sendMessage(ChatColor.GREEN + "Stworzono parkour o nazwie " + args[1]);
                        ParkourConfigMedium.create();
                        ParkourConfigMedium.save();
                    } else if (args[1].equalsIgnoreCase("hard")) {
                        ParkourObject.hard += 1;
                        player.sendMessage(ChatColor.GREEN + "Stworzono parkour o nazwie " + args[1]);
                        ParkourConfigHard.create();
                        ParkourConfigHard.save();
                    } else if (args[1].equalsIgnoreCase("ultra")) {
                        ParkourObject.ultra += 1;
                        player.sendMessage(ChatColor.GREEN + "Stworzono parkour o nazwie " + args[1]);
                        ParkourConfigUltra.create();
                        ParkourConfigUltra.save();
                    } else {
                        player.sendMessage(Util.fixColor("&cWybierz arene do dodania easy/medium/hard/ultra"));
                    }
                }

                //TODO remove, setspawn
            }
        } else {
            ((Player) sender).sendTitle(" ", Util.fixColor("&cNie masz uprawnien!"), 2, 3, 2);
        }
        return false;
    }

}
