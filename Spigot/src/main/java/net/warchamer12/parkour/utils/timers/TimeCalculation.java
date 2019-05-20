package net.warchamer12.parkour.utils.timers;

import net.warchamer12.parkour.Parkour;
import net.warchamer12.parkour.utils.TitleReflection;
import net.warchamer12.parkour.utils.Util;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class TimeCalculation {

    private static int time = 0;

    public static int getTime() {
        return time;
    }

    public static void setTime(int t, Player player) {
        time = t;
        player.getServer().getScheduler().cancelTask(time);
    }

    public static void calculate(long seconds, Player player) {
        long sec = seconds % 60;
        long minutes = seconds % 3600 / 60;
        long hours = seconds % 86400 / 3600;

        new BukkitRunnable() {
            @Override
            public void run() {
                TitleReflection.sendActionbar(player.getUniqueId(), Util.fixColor("&c" + hours + "h:" + minutes + "m:" + sec + "s"));
            }
        }.runTaskTimer(Parkour.getPlugin(), 20L, 20L);
    }

    public static void time(Player player) {
        new BukkitRunnable() {
            @Override
            public void run() {
                time++;
            }
        }.runTaskTimer(Parkour.getPlugin(), 20L, 20L);
    }


}
