package model.services;

import java.util.List;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import model.pojo.Room;
import model.pojo.User;

/**
 *
 * @author Sluski
 */
public class UserServices extends HttpServlet {

    private final RoomManager roomManager;

    public UserServices() {
        roomManager = new RoomManager();
    }

    public void createUser(HttpServletRequest request) {
        User user = new User(request.getRemoteAddr(), request.getRequestedSessionId());
        UserManager.add(user);
        addToRoomOrCreate(user);
    }

    public void createUser(HttpServletRequest request, List<String> tags) {
        User user = new User(request.getRemoteAddr(), request.getRequestedSessionId());
        user.setTags(tags);
        UserManager.removeIfExist(user.getClientAddress());
        UserManager.add(user);
        addToRoomOrCreate(user);
    }

    public void createUser(HttpServletRequest request, List<String> tags, String nick) {
        User user = new User(request.getRemoteAddr(), request.getRequestedSessionId());
        user.setNick(nick);
        user.setTags(tags);
        UserManager.add(user);
        addToRoomOrCreate(user);
    }

    public void createUser(HttpServletRequest request, String nick) {
        User user = new User(request.getRemoteAddr(), request.getRequestedSessionId());
        user.setNick(nick);
        UserManager.add(user);
        addToRoomOrCreate(user);
    }

    public void addToRoomOrCreate(User user) {
        for (Room item : RoomManager.rooms.values()) {
            if (!item.isIsPair()) {
                user.setRoomKey(item.getFirstUser().getRoomKey());
                item.setSecondUser(user);
                item.setIsPair(true);
                return;
            }
        }
        RoomManager.create(user, null);
    }
}