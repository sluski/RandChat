package model.services;

import java.util.List;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import model.pojo.User;

/**
 *
 * @author Sluski
 */
public class UserServices extends HttpServlet{
    
    public void createUser(HttpServletRequest request){
        User user = new User(request.getRemoteAddr(), request.getRequestedSessionId());
        WaitingRoom.add(user);
        createRoom();
    }
    
    public void createUser(HttpServletRequest request, List<String> tags){
        User user = new User(request.getRemoteAddr(), request.getRequestedSessionId());
        user.setTags(tags);
        WaitingRoom.add(user);
        createRoom();
    }
    
    public void createUser(HttpServletRequest request, List<String> tags, String nick){
        User user = new User(request.getRemoteAddr(), request.getRequestedSessionId());
        user.setNick(nick);
        user.setTags(tags);
        WaitingRoom.add(user);
        createRoom();
    }
    
    public void createUser(HttpServletRequest request, String nick){
        User user = new User(request.getRemoteAddr(), request.getRequestedSessionId());
        user.setNick(nick);
        WaitingRoom.add(user);
        createRoom();
    }
    
    public void createRoom(){
        RoomManager room = new RoomManager();
        List<User> pairUsers = WaitingRoom.returnAndRemovePairUsers();
        if(pairUsers.size() >= 2){
            User firstUser = pairUsers.get(0);
            User secondUser = pairUsers.get(1);
            room.create(firstUser, secondUser);
        }
    }
}
