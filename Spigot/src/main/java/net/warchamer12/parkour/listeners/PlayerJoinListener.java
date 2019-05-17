package net.warchamer12.parkour.listeners;

import net.warchamer12.parkour.configs.PlayerConfig;

import net.warchamer12.parkour.utils.Util;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoinListener implements Listener {

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        if (player.hasPlayedBefore()) {
            player.sendTitle(Util.fixColor("&6Siema"), "&6xDDDD", 2, 5, 2);
            PlayerConfig.load(player);
        } else {
            PlayerConfig.create(player);
            PlayerConfig.save();
        }
    }


}
