package net.warchamer12.parkour.listeners;

import net.warchamer12.parkour.configs.PlayerConfig;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoinListener implements Listener {

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        if (PlayerConfig.getFile() == player) {
            return;
        } else {
            Bukkit.getConsoleSender().sendMessage(ChatColor.GREEN + "Utworzono plik " + player + ".yml" + "!");
            PlayerConfig.create(player);
        }
    }


}
