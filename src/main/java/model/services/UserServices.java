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
    }
    
    public void createUser(HttpServletRequest request, List<String> tags){
        User user = new User(request.getRemoteAddr(), request.getRequestedSessionId());
        user.setTags(tags);
        WaitingRoom.add(user);
    }
    
}
