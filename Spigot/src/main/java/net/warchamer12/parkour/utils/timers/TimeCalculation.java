package net.warchamer12.parkour.utils.timers;

import net.warchamer12.parkour.Parkour;
import net.warchamer12.parkour.objects.AreaObject;
import net.warchamer12.parkour.utils.TitleReflection;
import net.warchamer12.parkour.utils.Util;
import org.bukkit.scheduler.BukkitRunnable;

public class TimeCalculation {

    private static int time = 0;

    public static void setTime(AreaObject playername, int t) {
        time = t;
        playername.getPlayer().getServer().getScheduler().cancelAllTasks();
    }

    public static void calculate(AreaObject player) {
        new BukkitRunnable() {
            @Override
            public void run() {
                time++;
                int miliseconds = time % 1000;
                long sec = time % 60;
                long minutes = time % 3600 / 60;
                long hours = time % 86400 / 3600;
                TitleReflection.sendActionbar(player.getPlayer(), Util.fixColor("&c" + hours + "h:" + minutes + "m:" + sec + "s"));
            }
        }.runTaskTimer(Parkour.getPlugin(), 20L, 20L);
    }


}
