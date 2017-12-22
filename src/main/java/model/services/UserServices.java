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
    User user;
    public void createUser(HttpServletRequest request){
        User user = new User(request.getRemoteAddr(), request.getRequestedSessionId());
    }
    
    public void createUser(HttpServletRequest request, List<String> tags){
        User user = new User(request.getRemoteAddr(), request.getRequestedSessionId());
        user.setTags(tags);
        findRoom();
    }
    
    private void findRoom(){
        user.setIsLooking(true);
        while(!user.isInConversation()){
            
        }
        user.setInConversation(true);
        
    }
}
