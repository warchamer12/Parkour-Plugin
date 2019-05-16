package net.warchamer12.parkour.listeners;

import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.ComponentBuilder;

import net.warchamer12.parkour.Parkour;
import net.warchamer12.parkour.utils.Util;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.scheduler.BukkitRunnable;

public class PlayerJoinListener implements Listener {

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        new BukkitRunnable() {

            @Override
            public void run() {
                player.spigot().sendMessage(ChatMessageType.ACTION_BAR, new ComponentBuilder(Util.fixColor("&4Siema stary pijany!")).create());
            }
        }.runTaskTimer(Parkour.getPlugin().getInstance(), 20L, 20L);
    }


}
