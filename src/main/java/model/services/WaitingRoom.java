package model.services;

import java.util.ArrayList;
import java.util.List;
import model.pojo.Room;
import model.pojo.Tag;
import model.pojo.User;

/**
 *
 * @author Sluski
 */
public final class WaitingRoom {

    private static List<User> waitingUsers = new ArrayList<>();

    public static void add(User user) {
        waitingUsers.add(user);

    }

    public static Room createRoom(User first, User second) {
        Room room = new Room(first, second);

        return null;
    }


}
