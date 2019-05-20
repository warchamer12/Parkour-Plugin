package net.warchamer12.parkour.listeners;

import net.warchamer12.parkour.objects.AreaObject;
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

        if (AreaObject.parkours.contains(player)) {
            Block block = player.getLocation().getBlock().getRelative(BlockFace.DOWN);
            if (block.getType() == Material.WOOL) {
                Wool wool = new Wool(block.getType(), block.getData());
                if (AreaObject.getStart() == true) {
                    if (wool.getColor() == DyeColor.LIME) {
                        player.sendMessage("wystarowala!");
                        TimeCalculation.time(player);
                        TimeCalculation.calculate(TimeCalculation.getTime(), player);
                        AreaObject.setStart(false);
                    }
                } else if (AreaObject.getStart() == false) {
                    if (wool.getColor() == DyeColor.RED) {
                        player.sendMessage("end!");
                        TimeCalculation.setTime(0, player);
                        AreaObject.setStart(true);
                    }
                }
            }
        }

    }


}
