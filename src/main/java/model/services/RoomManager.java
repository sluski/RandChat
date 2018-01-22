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

    private static Map<UUID, Room> rooms;

    public RoomManager() {
        rooms = new HashMap<>();
    }

    public void create(User firstUser, User secondUser) {
            UUID roomRandomUUID = UUID.randomUUID();
            Room room = new Room(firstUser, secondUser, createDir(roomRandomUUID));
            rooms.put(roomRandomUUID, room);
    }

    private String createDir(UUID roomUUID) {
        File dir = new File("C:\\Users\\Sluski\\Desktop\\AppFolders\\" + roomUUID.toString());
        dir.mkdir();
        return dir.getAbsolutePath();
    }
}
