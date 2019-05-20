package net.warchamer12.parkour.objects;

import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class AreaObject {

    public static List<Player> parkours = new ArrayList<>();

    private static boolean start;

    public static boolean getStart() {
        return start;
    }

    public static void setStart(boolean st) {
       start = st;
    }

}
