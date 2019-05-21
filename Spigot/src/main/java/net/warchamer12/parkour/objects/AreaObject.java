package net.warchamer12.parkour.objects;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class AreaObject {

    public static List<Player> parkours = new ArrayList<>();

    private String nick;

    private static boolean start;

    public AreaObject(String name) {
        this.start = true;
        this.nick = name;
    }

    public static boolean getStart(AreaObject player) {
        return start;
    }

    public static void setStart(AreaObject name, boolean b) {
        start = b;
    }

    public String getNick() {
        return this.nick;
    }

    public Player getPlayer() {
        return Bukkit.getPlayer(this.nick);
    }

}
