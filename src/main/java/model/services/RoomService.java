package model.services;

import java.util.List;
import java.util.UUID;
import javax.servlet.http.HttpServletRequest;
import model.pojo.Message;
import model.pojo.Room;
import model.pojo.User;
import org.primefaces.push.annotation.OnMessage;
import org.primefaces.push.annotation.PathParam;
import org.primefaces.push.annotation.PushEndpoint;
import org.primefaces.push.annotation.Singleton;
import org.primefaces.push.impl.JSONEncoder;

/**
 *
 * @author Sluski
 */
@PushEndpoint("/123/1")
public class RoomService {

    private User connectedUser;
    private User alienUser;
    private final RoomManager roomManager;
    private static List<Message> conversation;

    @PathParam("room")
    private String roomKey;
    @PathParam("user")
    private String user;

    public RoomService() {
        connectedUser = new User();
        roomManager = new RoomManager();
    }

    public void setRoomValues(HttpServletRequest request) throws InterruptedException {
        connectedUser = UserManager.returnBySSID(request.getRequestedSessionId());
        roomKey = connectedUser.getRoomKey();
        user = connectedUser.getClientSSID();
        setAlienUser();
    }

    public void setAlienUser() {
        if (isPairInRoom(roomKey)) {
            Room room = RoomManager.rooms.get(UUID.fromString(roomKey));
            if (room.getFirstUser().equals(connectedUser)) {
                alienUser = room.getSecondUser();
            } else {
                alienUser = room.getFirstUser();
            }
        }
    }

    @OnMessage(encoders = {JSONEncoder.class})
    public boolean onMessage(Message comingMessage) {
        conversation.add(comingMessage);
        return true;
    }

    public String getRoomKey() {
        return roomKey;
    }

    public User getConnectedUser() {
        return connectedUser;
    }

    public boolean isPairInRoom(String roomUUID) {
        return roomManager.findRoom(roomUUID).isIsPair();
    }

    public User getAlienUser() {
        return alienUser;
    }

    public String getUser() {
        return user;
    }
}