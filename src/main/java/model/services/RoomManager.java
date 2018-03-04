package model.services;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import model.pojo.Room;
import model.pojo.User;

/**
 *
 * @author Sluski
 */
public class RoomManager {

    public static Map<UUID, Room> rooms = new HashMap<>();

    public static void create(User firstUser, User secondUser) {
        UUID roomRandomUUID = UUID.randomUUID();
        Room room = new Room(firstUser, secondUser, createDir(roomRandomUUID));
        firstUser.setRoomKey(roomRandomUUID.toString());
        if(secondUser != null) secondUser.setRoomKey(roomRandomUUID.toString());
        rooms.put(roomRandomUUID, room);
    }

    private static String createDir(UUID roomUUID) {
        File dir = new File("C:\\Users\\Sluski\\Desktop\\AppFolders\\" + roomUUID.toString());
        dir.mkdir();
        return dir.getAbsolutePath();
    }

    public static Room findRoom(String roomUUID) {
        return rooms.get(UUID.fromString(roomUUID));
    }
    
}
