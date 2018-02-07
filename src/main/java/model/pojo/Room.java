package model.pojo;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Sluski
 */
public class Room {
    private User firstUser;
    private User secondUser;
    private String filesPath;
    private List<Message> conversation;
    private boolean isPair;
    
    public Room (User firstUser, User secondUser, String filesPath){
        this.firstUser = firstUser;
        this.secondUser = secondUser;
        this.filesPath = filesPath;
        conversation = new ArrayList<>();
        isPair = false;
    }

    public List<Message> getConversation() {
        return conversation;
    }

    public void setConversation(List<Message> conversation) {
        this.conversation = conversation;
    }

    public User getFirstUser() {
        return firstUser;
    }

    public void setFirstUser(User firstUser) {
        this.firstUser = firstUser;
    }

    public User getSecondUser() {
        return secondUser;
    }

    public void setSecondUser(User secondUser) {
        this.secondUser = secondUser;
    }

    public String getFilesPath() {
        return filesPath;
    }

    public void setFilesPath(String filesPath) {
        this.filesPath = filesPath;
    }

    public boolean isIsPair() {
        return isPair;
    }

    public void setIsPair(boolean isPair) {
        this.isPair = isPair;
    }
    
    
}
