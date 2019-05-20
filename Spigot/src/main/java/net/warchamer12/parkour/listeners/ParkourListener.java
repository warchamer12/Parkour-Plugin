package net.warchamer12.parkour.listeners;

import net.warchamer12.parkour.objects.AreaObject;
import net.warchamer12.parkour.utils.timers.TimeCalculation;
import org.bukkit.DyeColor;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.material.Wool;

public class ParkourListener implements Listener {

    public static void onPlayerMove(PlayerMoveEvent event) {
        Player player = event.getPlayer();

        if (AreaObject.parkours.contains(player.getName())) {
            Block block = player.getLocation().getBlock().getRelative(BlockFace.DOWN);
            if (block.getType() == Material.WOOL) {
                Wool wool = new Wool(block.getType(), block.getData());
                if (wool.getColor() == DyeColor.LIME) {
                    player.sendMessage("wystarowala!");
                    TimeCalculation.time(player);
                    TimeCalculation.calculate(TimeCalculation.getTime(), player);
                }
                if (wool.getColor() == DyeColor.RED) {
                    player.sendMessage("end!");
                    TimeCalculation.setTime(0, player);
                }
            }
        }

    }


}
