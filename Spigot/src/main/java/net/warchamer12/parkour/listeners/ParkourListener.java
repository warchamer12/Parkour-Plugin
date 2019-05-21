package net.warchamer12.parkour.listeners;

import net.warchamer12.parkour.objects.AreaObject;
import net.warchamer12.parkour.utils.players.uUtil;
import net.warchamer12.parkour.utils.timers.TimeCalculation;
import org.bukkit.DyeColor;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.material.Wool;

public class ParkourListener implements Listener {

    @EventHandler
    public static void onPlayerMove(PlayerMoveEvent event) {
        Player player = event.getPlayer();
        AreaObject user = uUtil.getUserByNick(player.getName());

        if (AreaObject.parkours.contains(user)) {
            Block block = player.getLocation().getBlock().getRelative(BlockFace.DOWN);
            if (block.getType() == Material.WOOL) {
                Wool wool = new Wool(block.getType(), block.getData());
                if (AreaObject.getStart(user.getPlayer()) == true) {
                    if (wool.getColor() == DyeColor.LIME) {
                        player.sendMessage("wystarowala!");
                        TimeCalculation.calculate(user.getPlayer());
                        AreaObject.setStart(false);
                    }
                } else if (AreaObject.getStart(user.getPlayer()) == false) {
                    if (wool.getColor() == DyeColor.RED) {
                        user.getPlayer().getServer().getScheduler().cancelAllTasks();
                        player.sendMessage("end!");
                        TimeCalculation.setTime(user.getPlayer(), 0);
                        AreaObject.setStart(true);
                    }
                }
            }
        }

    }


}
