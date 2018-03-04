package model.services;

import java.util.ArrayList;
import java.util.List;
import model.pojo.User;

/**
 *
 * @author Sluski
 */
public final class UserManager {

    public static final List<User> allUsers = new ArrayList<>();

    public static void add(User user) {
        allUsers.add(user);
    }

    public static User returnBySSID(String clientSSID) {
        for (User user : allUsers) {
            if (user.getClientSSID().equals(clientSSID)) {
                return user;
            }
        }
        return null;
    }

    public static User findByAddress(String clientAddress) {
        for (User usr : allUsers) {
            if (usr.getClientAddress().equals(clientAddress)) {
                return usr;
            }
        }
        return null;
    }

    public static User findBySSID(String clientSSID) {
        for (User usr : allUsers) {
            if (usr.getClientSSID().equals(clientSSID)) {
                return usr;
            }
        }
        return null;
    }

    public static boolean userExist(String clientAddress) {
        return findByAddress(clientAddress) != null;
    }

    public static void removeIfExist(String userAddress) {
        for (User usr : allUsers) {
            if (userAddress.equals(usr.getClientAddress())) {
                allUsers.remove(usr);
            }
        }
    }
}
