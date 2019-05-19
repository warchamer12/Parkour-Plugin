package net.warchamer12.parkour.listeners;

import net.warchamer12.parkour.configs.PlayerConfig;

import net.warchamer12.parkour.utils.ItemBuilder;
import net.warchamer12.parkour.utils.Util;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;

import java.text.SimpleDateFormat;
import java.util.Date;

public class PlayerJoinListener implements Listener {

    Date joined = new Date();
    SimpleDateFormat format1 = new SimpleDateFormat("dd/MM/yyyy");
    SimpleDateFormat format2 = new SimpleDateFormat("HH:mm:ss");


    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();

        ItemStack a = new ItemBuilder(Material.BOAT).setName(Util.fixColor("&c&lMenu")).toItemStack();
        ItemStack b = new ItemBuilder(Material.SKULL_ITEM).setSkullOwner(Bukkit.getServer().getOfflinePlayer(player.getPlayer().getName()).getUniqueId().toString()).setName(Util.fixColor("&c&l" + player.getName())).toItemStack();
        if (player.hasPlayedBefore()) {
            PlayerConfig.load(player);
            player.sendMessage(Util.fixColor("&cWitamy ponownie na serwerze " + player.getName() + "!"));

            player.getInventory().clear();
            player.getInventory().setItem(1, a);
            player.getInventory().setItem(4, b);
        } else {
            PlayerConfig.create(player);
            PlayerConfig.get().set("playername", player.getName());
            PlayerConfig.get().set("joined in", format1.format(joined));
            PlayerConfig.get().set("joined at", format2.format(joined));
            PlayerConfig.save();

            player.getInventory().setItem(1, a);
            player.getInventory().setItem(4, b);
        }
    }


}
