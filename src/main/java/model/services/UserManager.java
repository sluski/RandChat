package model.services;

import java.util.ArrayList;
import java.util.List;
import model.pojo.User;

/**
 *
 * @author Sluski
 */
public final class UserManager {

    private static final List<User> allUsers = new ArrayList<>();
    
    public static void add(User user) {
        allUsers.add(user);
    }

    public static User returnBySSID(String clientSSID){
        for(User user: allUsers){
            if(user.getClientSSID().equals(clientSSID)) return user;
        }
        return null;
    }
}
