package model.pojo;

import java.util.List;
import java.util.UUID;

/**
 *
 * @author Sluski
 */
public class Room {
    private User firstUser;
    private User secondUser;
    private List<Message> messages;
    private List<String> filesPath;
    
    public Room (User firstUser, User secondUser, String filesPath){
        this.firstUser = firstUser;
        this.secondUser = secondUser;
        this.filesPath = this.filesPath;
    }
    
    public void addMessage(Message message){
        messages.add(message);
    }
    
}
