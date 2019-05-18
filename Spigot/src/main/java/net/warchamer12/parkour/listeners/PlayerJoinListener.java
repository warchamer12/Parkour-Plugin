package net.warchamer12.parkour.listeners;

import net.warchamer12.parkour.configs.PlayerConfig;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.text.SimpleDateFormat;
import java.util.Date;

public class PlayerJoinListener implements Listener {

    Date joined = new Date();
    SimpleDateFormat format1 = new SimpleDateFormat("dd/MM/yyyy");
    SimpleDateFormat format2 = new SimpleDateFormat("HH:mm:ss");

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        if (player.hasPlayedBefore()) {
            PlayerConfig.load(player);
        } else {
            PlayerConfig.create(player);
            PlayerConfig.get().set("playername", player.getName());
            PlayerConfig.get().set("joined in", format1.format(joined));
            PlayerConfig.get().set("joined at", format2.format(joined));
            PlayerConfig.save();
        }
    }


}
