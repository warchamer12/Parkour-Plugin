package net.warchamer12.parkour.objects;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class AreaObject {

    public static List<Player> parkours = new ArrayList<>();

    private static boolean start;

    private String nick;

    public AreaObject(String name) {
        this.start = true;
        this.nick = name;
    }

    public AreaObject() {
        this.start = true;
    }

    public static boolean getStart(Player player) {
        return start;
    }

    public static void setStart(boolean st) {
       start = st;
    }

    public String getNick() {
        return this.nick;
    }

    public Player getPlayer() {
        return Bukkit.getPlayer(this.nick);
    }

}
