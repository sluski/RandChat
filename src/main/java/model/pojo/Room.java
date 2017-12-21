package model.pojo;

import java.util.List;

/**
 *
 * @author Sluski
 */
public class Room {
    private User firstUser;
    private User secondUser;
    private List<Message> messages;
    private List<String> filesPath;
    
    public void createRoom(User firstUser, User secondUser){
        this.firstUser = firstUser;
        this.secondUser = secondUser;
    }
    
    public void addMessage(Message message){
        messages.add(message);
    }
    
}
