package net.warchamer12.parkour.utils.players;

import net.warchamer12.parkour.objects.AreaObject;

import java.util.ArrayList;
import java.util.List;

public class uUtil {

    public static List<AreaObject> users = new ArrayList<>();

    public static List<AreaObject> getUsers() {
        return users;
    }

    public static AreaObject createUser(String playername) {
        AreaObject user = new AreaObject(playername);
        uUtil.users.add(user);
        return user;
    }

    public static AreaObject getUserByNick(String nick) {
        for (AreaObject user : getUsers()) {
            if (user.getNick().equalsIgnoreCase(nick)) {
                return user;
            }
        }
        return null;
    }
}
