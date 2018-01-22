package model.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import model.pojo.User;

/**
 *
 * @author Sluski
 */
public final class WaitingRoom {

    private static List<User> activeUsers = new ArrayList<>();
    private static RoomManager roomManager = new RoomManager();
    private static Random random = new Random();

    public static List<User> getActiveUsers() {
        return activeUsers;
    }

    public static void add(User user) {
        activeUsers.add(user);
    }

    public static List<User> returnAndRemovePairUsers() {
        List<User> pairUser = new ArrayList<>();
        if (activeUsers.size() >= 2) {
            for (int i = 0; i <= 1; i++) {
                User randomUser;
                if (activeUsers.size() != 1) {
                    randomUser = activeUsers.get(random.nextInt(activeUsers.size() - 1));
                } else {
                    randomUser = activeUsers.get(0);
                }
                pairUser.add(randomUser);
                activeUsers.remove(randomUser);
            }
        }
        return pairUser;
    }

}
