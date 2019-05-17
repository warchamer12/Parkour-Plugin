package net.warchamer12.parkour.listeners;

import net.warchamer12.parkour.configs.PlayerConfig;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.io.File;

public class PlayerJoinListener implements Listener {

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        if (PlayerConfig.getFile().getName() == File.separator + player.getUniqueId()) {
            return;
        } else {
            PlayerConfig.create(player);
            PlayerConfig.save();
        }
    }


}
