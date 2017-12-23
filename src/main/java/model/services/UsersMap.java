package model.services;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import model.pojo.User;

/**
 *
 * @author Sluski
 */
public final class UsersMap {
    private static final Map<UUID, User> maps = new HashMap<>();
    
    public static UUID put(User user){
        UUID uuid = UUID.randomUUID();
        maps.put(uuid, user);
        return uuid;
    }
    
    public static User find(UUID uuid){
        return maps.get(uuid);
    }
}
